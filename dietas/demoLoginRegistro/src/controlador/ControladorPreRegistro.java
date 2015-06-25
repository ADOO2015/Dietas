package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControladorPreRegistro
 */
@WebServlet("/ControladorPreRegistro")
public class ControladorPreRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorPreRegistro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String correo="";
		String contrasena="";
		String confirmaContrasena="";
		String nombre="";
		String apellidos="";
		String calle="";
		String numeroConsulturio="";
		String ciudad="";
		String telefono="";
		
		correo=request.getParameter("correo");
		contrasena=request.getParameter("contrasena");
		//confirmaContrasena=request.getParameter("confirmaContrasena");
		nombre=request.getParameter("nombre");
		apellidos=request.getParameter("apellidos");
		calle=request.getParameter("calle");
		numeroConsulturio=request.getParameter("numeroConsulturio");
		ciudad=request.getParameter("ciudad");
		telefono=request.getParameter("telefono");
		System.out.println(correo);
		System.out.println(contrasena);
		System.out.println(confirmaContrasena);
		System.out.println(nombre);
		System.out.println(apellidos);
		System.out.println(calle);
		System.out.println(numeroConsulturio);
		System.out.println(ciudad);
		System.out.println(telefono);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}