package jlr

class GraficasController {

    static responseFormats = ['json', 'html']
    static defaultAction = "gastosPorTipo"

    def busquedaService
    def chartService

    def gastosPorTipo() { }

    def rellenarDatos() {
        def datos = chartService.parsearDatosChart(busquedaService.gastosPorNombreAlMes(params.nombreCuenta))
        println "Datos: $datos"
        //render(contentType: "application/json") { datos }
        respond datos
    }

}
