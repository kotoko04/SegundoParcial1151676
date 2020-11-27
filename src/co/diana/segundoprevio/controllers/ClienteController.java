package co.diana.segundoprevio.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.diana.segundoprevio.dao.ClienteDao;
import co.diana.segundoprevio.model.Cliente;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet("/cliente")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDao clienteDao  = new ClienteDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String path = request.getServletPath();
			String action = request.getParameter("action");
			switch (action) {
			case "registrar":
				registrarCliente(request, response);
				break;
			default:
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}

	private void registrarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente= new Cliente();
		cliente.setClave(request.getParameter("password"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setNombre(request.getParameter("nombre"));
		clienteDao.insert(cliente);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
