package jlr

class GraficasController {

    def busquedaService
    def chartService

    def gastosPorTipo() { }

    def rellenarDatos() {
        render(contentType: "application/json") { chartService.parsearDatosChart(busquedaService.gastosPorNombreAlMes(params.nombreCuenta)) }
    }

}
