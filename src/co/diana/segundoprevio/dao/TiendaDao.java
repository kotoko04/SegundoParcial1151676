package co.diana.segundoprevio.dao;

import co.diana.segundoprevio.model.Tienda;
import co.diana.segundoprevio.util.Conexion;

public class TiendaDao extends Conexion<Tienda> implements GenericDao<Tienda> {

	public TiendaDao() {
		super(Tienda.class);
	}

}
