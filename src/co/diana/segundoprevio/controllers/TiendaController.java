package co.diana.segundoprevio.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.diana.segundoprevio.dao.TiendaDao;
import co.diana.segundoprevio.model.Tienda;

/**
 * Servlet implementation class TiendaController
 */
@WebServlet("/tienda")
public class TiendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TiendaDao tiendaDao = new TiendaDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TiendaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String path = request.getServletPath();
			String action = request.getParameter("action");
			switch (action) {
			case "registrar":
				registrarTienda(request, response);
				break;
			case "servicios":
				listarServicios(request, response);
				break;
			case "misservicios":
				misServicios(request, response);
				break;
			default:
				response.sendRedirect("/SegundoPrevio/");
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String path = request.getServletPath();
			String action = request.getParameter("action");
			switch (action) {
			case "registrar":
				registrarTienda(request, response);
				break;
			default:
				response.sendRedirect("/SegundoPrevio/");
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void listarServicios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Tienda tienda = tiendaDao.find(id);
		if (tienda != null) {
			request.getSession().setAttribute("nombredetienda", tienda.getNombre());
			request.getSession().setAttribute("mensajeservicios",
					tienda.getServicios().size() > 0 ? "" : "No hay servicios registrados");
			request.getSession().setAttribute("servicios", tienda.getServicios());
			request.getRequestDispatcher("servicios.jsp").forward(request, response);
			return;
		}
		response.sendRedirect("/SegundoPrevio/");
	}

	private void misServicios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Tienda tienda = (Tienda) request.getSession().getAttribute("tienda");
		request.getSession().setAttribute("nombredetienda", tienda.getNombre());
		if (tienda.getServicios() != null) {
			request.getSession().setAttribute("mensajeservicios",
					tienda.getServicios().size() > 0 ? "" : "No hay servicios registrados");
		} else {
			request.getSession().setAttribute("mensajeservicios", "No hay servicios registrados");
		}
		request.getSession().setAttribute("servicios", tienda.getServicios());
		request.getRequestDispatcher("servicios.jsp").forward(request, response);
		return;
	}

	private void registrarTienda(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Tienda tienda = new Tienda();
		tienda.setClave(request.getParameter("clave"));
		tienda.setDescripcion(request.getParameter("descripcion"));
		tienda.setEmail(request.getParameter("email"));
		tienda.setFacebook(request.getParameter("facebook"));
		tienda.setImagen(request.getParameter("imagen"));
		tienda.setLema(request.getParameter("lema"));
		tienda.setNombre(request.getParameter("nombre"));
		tienda.setPropietario(request.getParameter("propietario"));
		tienda.setWeb(request.getParameter("web"));
		Tienda tiendaDB = tiendaDao.findByField("email", tienda.getEmail());
		if (tiendaDB == null) {
			tiendaDao.insert(tienda);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			response.sendRedirect("/SegundoPrevio/");
		}
	}

}
