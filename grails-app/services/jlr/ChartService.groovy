package jlr

class ChartService {

    def parsearDatosChart(datos) {
        def etiquetas = []
        def valores = []
        datos.each { anyo, datosAnyo ->
            datosAnyo.each { mes, datosMes ->
                etiquetas << "$mes/$anyo"
                valores << datosMes
            }
        }
        ["etiquetas": etiquetas, "datos": valores]
    }
}
