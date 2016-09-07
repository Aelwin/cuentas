package jlr

class NombreCuenta {

	String nombre
	static hasMany = [cuentas: Cuenta]

    static constraints = {
    	nombre nullable: false, blank: false, unique: true
    	cuentas nullable: true
    }

    String toString() {
    	nombre
    }
}
