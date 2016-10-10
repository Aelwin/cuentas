package jlr

import java.util.Date
import jlr.security.User
import jlr.security.Role
import jlr.security.UserRole

class GastosController {

    def busquedaService

    def index() {        
    	respond NombreCuenta.list()
    }

    def totalGastos() {
    	def total = Cuenta.gastoTotal()	
    	[total: total]
    }

    def busqueda(Integer max, String sort, String order) {
        params.max = Math.min(max ?: 10, 100)
        params.sort = sort?:"fecha"
        params.order = order?:"asc"        
        def gastos = busquedaService.busquedaGastos(params)
    	def gastoTotal = busquedaService.totalGastadoBusqueda(params)            
    	[gastos: gastos, gastosCount: gastos.totalCount, gastoTotal: gastoTotal?:"0"]
    }

    def crearUsuario() {
        def me = new User(username: params.nombre, password: params.contrasenya).save(flush: true)        
        def rol = new Role(authority: params.rol).save(flush: true)        
 
        UserRole.create me, rol

        UserRole.withSession {
            it.flush()
            it.clear()
        }
 
        render "Usuario creado"
    }

}
