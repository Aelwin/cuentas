package jlr

class GraficasController {

    def busquedaService
    def chartService

    def gastosPorTipo() { }

    def rellenarDatos() {
        println "Entrando a rellenarDatos con nombreCuenta: $params.nombreCuenta"
        render(contentType: "application/json") { chartService.parsearDatosChart(busquedaService.gastosPorNombreAlMes(params.nombreCuenta)) }
    }

}
