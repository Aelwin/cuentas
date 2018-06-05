package jlr

import static java.lang.reflect.Modifier.isStatic

class GastosController {

    def busquedaService

    def index() {
    	respond NombreCuenta.list()
    }

    def totalGastos() {
    	def total = Cuenta.gastoTotal()	
    	[total: total]
    }

    def busqueda(BusquedaCommand paramsBusqueda) {
        if (paramsBusqueda.fechaMes) {
            //Calculamos el último día del mes seleccionado para hacer la búsqueda         
            paramsBusqueda.fechaDesde = paramsBusqueda.fechaMes
            Calendar calendar = Calendar.instance
            calendar.set(Calendar.MONTH, paramsBusqueda.fechaMes.month)
            calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH))
            paramsBusqueda.fechaHasta = calendar.time
        }
        params << paramsBusqueda.asMap()
        def gastos = busquedaService.busquedaGastos(params)
    	def gastoTotal = busquedaService.totalGastadoBusqueda(params)
    	[gastos: gastos, gastosCount: gastos.totalCount, gastoTotal: gastoTotal?:"0"]
    }

}

class BusquedaCommand implements grails.validation.Validateable {

    Integer max = 10
    String sort = "fecha"
    String order = "asc"
    Date fechaDesde
    Date fechaHasta
    Date fechaMes
    String nombreGasto
    String descripcion

    //indicamos que todos los campos son nullables
    static boolean defaultNullable() {
        true
    }

    Map asMap() {
        //La JVM marca los campos generados como SYNTHETIC
        //A synthetic field is a compiler-created field that links a local inner class
        // to a block's local variable or reference type parameter
        this.class.declaredFields.findAll { !it.synthetic && !isStatic(it.modifiers) }.collectEntries {
            [ (it.name):this."$it.name" ]
        }
    }
}
