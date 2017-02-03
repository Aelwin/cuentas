package jlr

class GraficasController {

    static responseFormats = ['json', 'html']
    static defaultAction = "gastosPorTipo"

    def busquedaService
    def chartService

    def gastosPorTipo() { }

    def rellenarDatos() {
        respond chartService.parsearDatosChart(busquedaService.gastosPorNombreAlMes(params.nombreCuenta))
    }

}
