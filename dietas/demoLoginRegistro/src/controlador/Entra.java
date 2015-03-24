package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Entra")
public class Entra extends HttpServlet {
	private String tipo;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Entra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccessUser a= new AccessUser();
		tipo=a.Accesa(request.getParameter("txtEmail"), request.getParameter("txtPass"));
		response.setContentType("text/html");
		HttpSession sesion = request.getSession();
		
		sesion.setAttribute("tipo", tipo);
		if(tipo.equals("UN") || tipo.equals("PN")||tipo.equals("incorrecto")){
			response.sendRedirect("index.jsp");
		}else if(tipo.equals("Medico") ){
			sesion.setAttribute("Usuario",a.getUsuario());
			response.sendRedirect("doctor.jsp");
		}else if( tipo.equals("Paciente")){
			sesion.setAttribute("Usuario",a.getUsuario());
			response.sendRedirect("doctor.jsp");
		}
	}

}
