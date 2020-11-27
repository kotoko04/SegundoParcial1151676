package co.diana.segundoprevio.test;

import java.util.List;

import co.diana.segundoprevio.dao.ClienteDao;
import co.diana.segundoprevio.dao.ServicioDao;
import co.diana.segundoprevio.dao.TiendaDao;
import co.diana.segundoprevio.model.Cliente;
import co.diana.segundoprevio.model.Servicio;
import co.diana.segundoprevio.model.Tienda;

public class Test {
	static ClienteDao clienteDao = new ClienteDao();
	static ServicioDao servicioDao = new ServicioDao();
	static TiendaDao tiendaDao = new TiendaDao();

	public Test() {
	}

	public static void main(String[] args) {
		try {
			Cliente cliente = new Cliente();
			cliente.setNombre("Diana");
			cliente.setEmail("diana@gmail.com");
			cliente.setClave("789456123");
			clienteDao.insert(cliente);
			
			Tienda tienda = new Tienda();
			tienda.setClave("789456132");
			tienda.setDescripcion("Esta es una descripción");
			tienda.setEmail("dianatienda@gmail.com");
			tienda.setFacebook("www.facebook.com");
			tienda.setLema("diana descripcin");
			tienda.setImagen("imagen.com");
			tienda.setNombre("diana strore");
			tienda.setPropietario("Diana");
			tienda.setWeb("www.dianastore.com");
			tiendaDao.insert(tienda);
			
			Servicio servicio = new Servicio();
			servicio.setNombre("A domicilio");
			servicio.setDescripcion("Entregas seguras");
			servicio.setTiendaBean(tienda);
			servicioDao.insert(servicio);
			
			ClienteDao dao2 = new ClienteDao();
			Cliente prueba2 = dao2.find(2);
			TiendaDao dao = new TiendaDao();
			Tienda prueba = dao.find(1);
			List <Cliente> clientes = prueba.getClientes();		
			clientes.add(prueba2);
			prueba.setClientes(clientes);
			dao.update(prueba);
			
			TiendaDao actualizarDao = new TiendaDao();
			Tienda actualizar = actualizarDao.find(3);
			actualizar.setEmail("tienda.com");
			actualizarDao.update(actualizar);
			
		} catch (Exception e) {
		}
		

	}
}
