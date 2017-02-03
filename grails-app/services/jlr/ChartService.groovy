package jlr

class ChartService {

    def parsearDatosChart(datos) {
        println "Entrando a parsearDatosChart"
        def etiquetas = []
        def valores = []
        datos.each { anyo, datosAnyo ->
            datosAnyo.each { mes, datosMes ->
                etiquetas << "$mes/$anyo"
                valores << datosMes
            }
        }
        println "Etiquetas: $etiquetas"
        println "Valores: $valores"
        ["etiquetas": etiquetas, "datos": valores]
    }
}
