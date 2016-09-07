package jlr

class BorrameController {

    def index() {
    	def nombreCuenta = NombreCuenta.findByNombre("Tren")
    	println "Total registros NombreCuenta: ${NombreCuenta.getAll().size}"
    	println "Cuenta: " + nombreCuenta?.cuentas[0].nombre
    	render "HOLA " + nombreCuenta?.nombre
    }
}
