package jlr

import java.util.Date

class GastosController {

    def busquedaService

    def index() { 
    	respond NombreCuenta.list()
    }

    def totalGastos() {
    	def total = Cuenta.gastoTotal()	
    	[total: total]
    }

    def busqueda(Integer max, String sort) {
        params.max = Math.min(max ?: 10, 100)
        params.sort = sort?:"fecha"
        def criteria = Cuenta.createCriteria()
        def gastos = busquedaService.busquedaGastos(params)
    	def gastoTotal = busquedaService.totalGastadoBusqueda(params)            
    	[gastos: gastos, gastosCount: gastos.totalCount, gastoTotal: gastoTotal?:"0"]
    }

}
