import jlr.NombreCuenta
import jlr.Cuenta
import java.util.Date

class BootStrap {

    def init = { servletContext ->

    	NombreCuenta desayunos = new NombreCuenta(nombre: "Desayunos").save()
    	NombreCuenta ropa = new NombreCuenta(nombre: "Ropa").save()
    	NombreCuenta videojuegos = new NombreCuenta(nombre: "Videojuegos").save()
    	NombreCuenta libros = new NombreCuenta(nombre: "Libros").save()
    	NombreCuenta copas = new NombreCuenta(nombre: "Copas").save()
    	NombreCuenta otros = new NombreCuenta(nombre: "Otros").save()
    	NombreCuenta coche = new NombreCuenta(nombre: "Coche").save()
    	NombreCuenta tren = new NombreCuenta(nombre: "Tren").save()
    	NombreCuenta comidasCenas = new NombreCuenta(nombre: "Comidas/Cenas").save()
    	
        new Cuenta(importe: 2.8f, nombre: desayunos, fecha: Date.parse("dd-MM-yyyy", "01-09-2016")).save()
        new Cuenta(importe: 2.8f, nombre: desayunos, fecha: Date.parse("dd-MM-yyyy", "02-09-2016")).save()
        new Cuenta(importe: 2.8f, nombre: desayunos, fecha: Date.parse("dd-MM-yyyy", "05-09-2016")).save()
        new Cuenta(importe: 2.8f, nombre: desayunos, fecha: Date.parse("dd-MM-yyyy", "06-09-2016")).save()
        new Cuenta(importe: 3.0f, nombre: desayunos, fecha: Date.parse("dd-MM-yyyy", "07-09-2016")).save()
        new Cuenta(importe: 13f, nombre: otros, fecha: Date.parse("dd-MM-yyyy", "07-09-2016"), descripcion: "peluqería").save()
    }
    def destroy = {
    }
}
