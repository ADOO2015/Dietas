package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.DAOFactoria;
import modelo.Usuario;
import modelo.UsuarioDAO;

/**
 * Servlet implementation class ConfirmacionPacientesControlador
 */
@WebServlet("/ConfirmacionPacientesControlador")
public class ConfirmacionPacientesControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmacionPacientesControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOFactoria fact = DAOFactoria.getDAOFactoria(1);
		UsuarioDAO usuarioDAO = fact.getUsuarioDAO();
		Collection<Usuario> usuarios = null;
		
		try {
			usuarios = usuarioDAO.getAllPregistered();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (usuarios.size() != 0) {
				request.setAttribute("hola", "HOLA");
			}
			request.setAttribute("usuariosPreregistrados", usuarios);
		}
		
		RequestDispatcher view = request.getRequestDispatcher("confirmacionPacientes.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
