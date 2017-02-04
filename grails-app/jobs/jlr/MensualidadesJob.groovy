package jlr

import jlr.NombreCuenta
import jlr.Cuenta
import java.util.Date

class MensualidadesJob {
	
    static triggers = {
      	cron name: 'cronTrigger', cronExpression: '0 0 8 1 * ?' //se lanza el primero de cada mes a las 8 de la mañana
    }

    def execute() {                       
        new Cuenta(importe: 50f, nombre: NombreCuenta.findByNombre('Otros'), fecha: new Date(), descripcion: "seguros bilbao").save()        
    }
}
