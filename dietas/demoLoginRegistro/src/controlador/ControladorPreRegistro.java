package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.AccessUsuarioDAO;
import modelo.ConexionBD;
import modelo.Usuario;

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
		String sexo="";
		
		correo=request.getParameter("correo");
		contrasena=request.getParameter("contrasena");
		confirmaContrasena=request.getParameter("confirmaContrasena");
		nombre=request.getParameter("nombre");
		apellidos=request.getParameter("apellidos");
		calle=request.getParameter("calle");
		numeroConsulturio=request.getParameter("numeroConsulturio");
		ciudad=request.getParameter("ciudad");
		telefono=request.getParameter("telefono");
		sexo=request.getParameter("sexo");
		AccessUsuarioDAO gestor=new AccessUsuarioDAO();
		String us="";
		try {
			us=gestor.isUserResgistered(correo);
			//System.out.println("usuario: "+us.getNombre());
		} catch (SQLException e1) {
			System.out.println("Error buscando usuario por correo");
			e1.printStackTrace();
		}
		
		
		if(contrasena.equals(confirmaContrasena)&&us.equals("")){//si las contraseñas son iguales se procesan
		try {
			gestor.insertUser(nombre, apellidos, correo, contrasena,sexo);
			gestor.insertPaciente(gestor.getIdUsuarioPaciente(correo), "1", "1", "1");
		} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("Error al insertar usuario");
		}
		response.sendRedirect("index.html");
		}else{
			response.sendRedirect("ErrorPassPreRegistro.html");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
