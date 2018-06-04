package jlr

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class CuentaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Cuenta.list(params), model:[cuentaCount: Cuenta.count()]
    }

    def show(Cuenta cuenta) {
        respond cuenta
    }

    def create() {
        respond new Cuenta(params)
    }

    @Transactional
    def save(Cuenta cuenta) {
        if (cuenta == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (cuenta.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond cuenta.errors, view:'create'
            return
        }

        cuenta.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'cuenta.label', default: 'Cuenta'), cuenta.id])
                redirect cuenta
            }
            '*' { respond cuenta, [status: CREATED] }
        }
    }

    def edit(Cuenta cuenta) {
        respond cuenta
    }

    @Transactional
    def update(Cuenta cuenta) {
        if (cuenta == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (cuenta.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond cuenta.errors, view:'edit'
            return
        }

        cuenta.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'cuenta.label', default: 'Cuenta'), cuenta.id])
                redirect cuenta
            }
            '*'{ respond cuenta, [status: OK] }
        }
    }

    @Transactional
    def delete(Cuenta cuenta) {

        if (cuenta == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        cuenta.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'cuenta.label', default: 'Cuenta'), cuenta.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'cuenta.label', default: 'Cuenta'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
