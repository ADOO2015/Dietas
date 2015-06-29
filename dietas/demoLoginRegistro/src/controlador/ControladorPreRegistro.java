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
		
		// para la tabla usuario
		String correo="";
		String contrasena="";
		String confirmaContrasena="";
		String nombre="";
		String apellidos="";
		String TipoUsuario="";
		String sexo="";
		
		//para tabla tipousuario
		// correo
		String descripcion="Paciente";
		
		//para tabla direccion
		String calle="";
		String numeroExt="";
		String ciudad="";
		String telefono="";


		
		//Jala todos los datos del formulario y se inicializan
		correo=request.getParameter("correo");
		contrasena=request.getParameter("contrasena");
		confirmaContrasena=request.getParameter("confirmaContrasena");
		nombre=request.getParameter("nombre");
		apellidos=request.getParameter("apellidos");
		calle=request.getParameter("calle");
		numeroExt=request.getParameter("numeroExt");
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
		
		
		if(contrasena.equals(confirmaContrasena)&&us.equals("")){//si las contraseÃ±as son iguales se procesan
		try {
			//se registra en tabla tipousuario, obtenemos TipoUsuario
			gestor.insertinTipoUsuario(correo, descripcion);
			TipoUsuario=gestor.getIdTipoUsuario(correo);
			//registramos en tabla Usuario
			gestor.insertinUsuario(nombre, apellidos, correo, contrasena,sexo,TipoUsuario);
			//registramos en tabla dirección
			gestor.insertinDireccion(ciudad, calle, numeroExt);
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
