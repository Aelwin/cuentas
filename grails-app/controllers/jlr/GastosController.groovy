package jlr

import java.util.Date

class GastosController {

    def index() { 
    	respond NombreCuenta.list()
    }

    def totalGastos() {
    	def total = Cuenta.gastoTotal()	
    	[total: total]
    }

    def busqueda() {
        def criteria = Cuenta.createCriteria()
        def gastos = criteria.list(params) {
            if (params.descripcion) {
                ilike("descripcion", "%${params.descripcion}%")
            }
            if (params.fechaDesde) {
                between("fecha", params.fechaDesde, params.fechaHasta)
            }
            if (params.nombreGasto) {
                eq("nombre", NombreCuenta.findByNombre(params.nombreGasto))
            }
            eq("tipo", TipoCuenta.GASTO)
            order("fecha", "asc")
        }
    	def gastoTotal = gastos?.sum { it.importe }
    	[gastos: gastos, gastosCount: gastos?.size(), gastoTotal: gastoTotal?:"0"]
    }

}
