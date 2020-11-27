package co.diana.segundoprevio.dao;

import co.diana.segundoprevio.model.Cliente;
import co.diana.segundoprevio.util.Conexion;

public class ClienteDao extends Conexion<Cliente> implements GenericDao<Cliente> {

	public ClienteDao() {
		super(Cliente.class);
	}

}
