package co.diana.segundoprevio.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tienda database table.
 * 
 */
@Entity
@NamedQuery(name="Tienda.findAll", query="SELECT t FROM Tienda t")
public class Tienda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String clave;

	@Lob
	private String descripcion;

	private String email;

	private String facebook;

	private String imagen;

	private String lema;

	private String nombre;

	private String propietario;

	private String web;

	//bi-directional many-to-many association to Cliente
	@ManyToMany
	@JoinTable(
		name="seguir"
		, joinColumns={
			@JoinColumn(name="tienda")
			}
		, inverseJoinColumns={
			@JoinColumn(name="cliente")
			}
		)
	private List<Cliente> clientes;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="tiendaBean")
	private List<Servicio> servicios;

	public Tienda() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFacebook() {
		return this.facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getLema() {
		return this.lema;
	}

	public void setLema(String lema) {
		this.lema = lema;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPropietario() {
		return this.propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getWeb() {
		return this.web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Servicio addServicio(Servicio servicio) {
		getServicios().add(servicio);
		servicio.setTiendaBean(this);

		return servicio;
	}

	public Servicio removeServicio(Servicio servicio) {
		getServicios().remove(servicio);
		servicio.setTiendaBean(null);

		return servicio;
	}

}