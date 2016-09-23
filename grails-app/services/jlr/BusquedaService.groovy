package jlr

import grails.transaction.Transactional

@Transactional
class BusquedaService {

    def totalGastadoBusqueda(params) {
    	def criteria = Cuenta.createCriteria()
    	def gastoTotal = criteria.get {
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
            projections {
                sum("importe")
            }
        }
    }

    def busquedaGastos(params) {
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
            order(params.sort, params.order)
        }    
    }
}
