package co.diana.segundoprevio.dao;

import co.diana.segundoprevio.model.Servicio;
import co.diana.segundoprevio.util.Conexion;

public class ServicioDao extends Conexion<Servicio> implements GenericDao<Servicio> {

	public ServicioDao() {
		super(Servicio.class);
	}

}
