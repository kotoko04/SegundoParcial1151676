package co.diana.segundoprevio.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the servicio database table.
 * 
 */
@Entity
@NamedQuery(name="Servicio.findAll", query="SELECT s FROM Servicio s")
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Tienda
	@ManyToOne
	@JoinColumn(name="tienda")
	private Tienda tiendaBean;

	public Servicio() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Tienda getTiendaBean() {
		return this.tiendaBean;
	}

	public void setTiendaBean(Tienda tiendaBean) {
		this.tiendaBean = tiendaBean;
	}

}