package jlr
import java.util.Date

class Cuenta {

	Date fecha = new Date()
	Float importe = 0
	String descripcion = ""
	TipoCuenta tipo = TipoCuenta.GASTO
	NombreCuenta nombre

    static constraints = {
    	descripcion blank: true
    	importe min: 0f
    }

    static def gastoTotal() {
    	def c = Cuenta.createCriteria()
		def total = c.get {	
			eq("tipo", TipoCuenta.GASTO)	      		   
		    projections {
	        	sum("importe")
	    	}
		}	
    }

    def beforeInsert() {
    	descripcion = descripcion?:""
    }

    def beforeUpdate() {
    	descripcion = descripcion?:""
    }

    def beforeValidate() {
    	descripcion = descripcion?:""
    }
}
