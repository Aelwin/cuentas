package jlr

import groovy.transform.CompileStatic

@CompileStatic
enum TipoCuenta {
	GASTO("Gasto"),
	INGRESO("Ingreso")

	final String valor

	TipoCuenta(String valor) {
		this.valor = valor
	}

    String toString() {
    	valor
    }

    String getKey() {
    	name()
    }

    static list() {
  		[GASTO, INGRESO]
 	}
}