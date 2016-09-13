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
    	/*def gastos
    	def ordenacion = [sort: "fecha", order: "asc"]
        if (params.descripcion) {            
            gastos = Cuenta.findAllByDescripcionIlikeAndTipo("%${params.descripcion}%", TipoCuenta.GASTO, ordenacion)
        } else if (params.fechaDesde && params.fechaHasta && params.nombreGasto) {    		
    		gastos = Cuenta.findAllByFechaBetweenAndNombreAndTipo(params.fechaDesde, params.fechaHasta, NombreCuenta.findByNombre(params.nombreGasto), TipoCuenta.GASTO, ordenacion)
    	} else if (params.nombreGasto) {
    		gastos = Cuenta.findAllByNombreAndTipo(NombreCuenta.findByNombre(params.nombreGasto), TipoCuenta.GASTO, ordenacion)
    	} else if (params.fechaDesde) {    		
    		gastos = Cuenta.findAllByFechaBetweenAndTipo(params.fechaDesde, params.fechaHasta, TipoCuenta.GASTO, ordenacion)
    	}*/
        def criteria = Cuenta.createCriteria()
        def gastos = criteria.list {
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
