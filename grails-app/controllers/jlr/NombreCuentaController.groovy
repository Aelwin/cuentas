package jlr

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class NombreCuentaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond NombreCuenta.list(params), model:[nombreCuentaCount: NombreCuenta.count()]
    }

    def show(NombreCuenta nombreCuenta) {
        respond nombreCuenta
    }

    def create() {
        respond new NombreCuenta(params)
    }

    @Transactional
    def save(NombreCuenta nombreCuenta) {
        if (nombreCuenta == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (nombreCuenta.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond nombreCuenta.errors, view:'create'
            return
        }

        nombreCuenta.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'nombreCuenta.label', default: 'NombreCuenta'), nombreCuenta.id])
                redirect nombreCuenta
            }
            '*' { respond nombreCuenta, [status: CREATED] }
        }
    }

    def edit(NombreCuenta nombreCuenta) {
        respond nombreCuenta
    }

    @Transactional
    def update(NombreCuenta nombreCuenta) {
        if (nombreCuenta == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (nombreCuenta.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond nombreCuenta.errors, view:'edit'
            return
        }

        nombreCuenta.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'nombreCuenta.label', default: 'NombreCuenta'), nombreCuenta.id])
                redirect nombreCuenta
            }
            '*'{ respond nombreCuenta, [status: OK] }
        }
    }

    @Transactional
    def delete(NombreCuenta nombreCuenta) {

        if (nombreCuenta == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        nombreCuenta.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'nombreCuenta.label', default: 'NombreCuenta'), nombreCuenta.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'nombreCuenta.label', default: 'NombreCuenta'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
