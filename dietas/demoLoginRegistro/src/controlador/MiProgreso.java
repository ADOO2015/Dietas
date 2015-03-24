package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.AccessUsuarioDAO;
import modelo.Progreso;
import modelo.ProgresoDAO;
import modelo.Usuario;

/**
 * Servlet implementation class MiProgreso
 */
@WebServlet("/MiProgreso")
public class MiProgreso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MiProgreso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession();
		ProgresoDAO pro = new ProgresoDAO();
		Usuario user = (Usuario)s.getAttribute("Usuario");
		System.out.println(user.getId());
		Progreso progresos[] = pro.MiProgreso(user.getId());
		int contador=0;
		List<String> x= new ArrayList<String>();
		List<String> y= new ArrayList<String>();
		if(progresos.length > 0){
			String mes = progresos[0].getFecha().substring(5, 7);
		
		if(progresos.length==1)
			
		System.out.println(mes);
		for(int i=1;i<progresos.length;i++){
			System.out.println(mes);

			if(progresos[i].getFecha().substring(5, 7).equals(progresos[i-1].getFecha().substring(5, 7)) ){
				
			}else{
				if(progresos[i-1].getFecha().substring(5, 7).equals("01")){
					x.add("Enero");
				}else if(progresos[i-1].getFecha().substring(5, 7).equals("02"))
					x.add("Febrero");
				else if(progresos[i-1].getFecha().substring(5, 7).equals("03"))
					x.add("Marzo");
				else if(progresos[i-1].getFecha().substring(5, 7).equals("04"))
					x.add("Abril");
				else if(progresos[i-1].getFecha().substring(5, 7).equals("05"))
					x.add("Mayo");
				else if(progresos[i-1].getFecha().substring(5, 7).equals("06"))
					x.add("Junio");
				else if(progresos[i-1].getFecha().substring(5, 7).equals("07"))
					x.add("Julio");
				else if(progresos[i-1].getFecha().substring(5, 7).equals("08"))
					x.add("Agosto");
				else if(progresos[i-1].getFecha().substring(5, 7).equals("09"))
					x.add("Septiembre");
				else if(progresos[i-1].getFecha().substring(5, 7).equals("10"))
					x.add("Octubre");
				else if(progresos[i-1].getFecha().substring(5, 7).equals("11"))
					x.add("Noviembre");
				else if(progresos[i-1].getFecha().substring(5, 7).equals("12"))
					x.add("Diciembre");
				y.add(String.valueOf(progresos[i-1].getPeso()));
			}
			if(i==progresos.length-1){
				if(progresos[i].getFecha().substring(5, 7).equals("01")){
					x.add("Enero");
				}else if(progresos[i].getFecha().substring(5, 7).equals("02"))
					x.add("Febrero");
				else if(progresos[i].getFecha().substring(5, 7).equals("03"))
					x.add("Marzo");
				else if(progresos[i].getFecha().substring(5, 7).equals("04"))
					x.add("Abril");
				else if(progresos[i].getFecha().substring(5, 7).equals("05"))
					x.add("Mayo");
				else if(progresos[i].getFecha().substring(5, 7).equals("06"))
					x.add("Junio");
				else if(progresos[i].getFecha().substring(5, 7).equals("07"))
					x.add("Julio");
				else if(progresos[i].getFecha().substring(5, 7).equals("08"))
					x.add("Agosto");
				else if(progresos[i].getFecha().substring(5, 7).equals("09"))
					x.add("Septiembre");
				else if(progresos[i].getFecha().substring(5, 7).equals("10"))
					x.add("Octubre");
				else if(progresos[i].getFecha().substring(5, 7).equals("11"))
					x.add("Noviembre");
				else if(progresos[i].getFecha().substring(5, 7).equals("12"))
					x.add("Diciembre");
				y.add(String.valueOf(progresos[i].getPeso()));
			}
				
		}
		}
		String xs[]= new String[x.size()];
		xs=x.toArray(xs);
		String ys[]= new String[y.size()];
		ys=y.toArray(ys);
		s.setAttribute("x", xs);
		s.setAttribute("y", ys);
		
		response.sendRedirect("Progreso.jsp");
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProgresoDAO usuario = new ProgresoDAO();

		ProgresoDAO altaP = new ProgresoDAO();
	HttpSession a = request.getSession();
	Usuario user = new Usuario();
	user=(Usuario)a.getAttribute("Usuario");
	 Date ahora = new Date();
     SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     
	try {
		altaP.insertProgreso(String.valueOf(user.getId()), formateador.format(ahora), request.getParameter("altura"), request.getParameter("peso"), request.getParameter("cintura"), request.getParameter("cadera"));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	System.out.println(user.getId());
	Progreso progresos[] = usuario.MiProgreso(user.getId());
	int contador=0;
	List<String> x= new ArrayList<String>();
	List<String> y= new ArrayList<String>();
	if(progresos.length > 0){
		String mes = progresos[0].getFecha().substring(5, 7);
	
	
	System.out.println(mes);
	for(int i=1;i<progresos.length;i++){
		System.out.println(mes);

		if(progresos[i].getFecha().substring(5, 7).equals(progresos[i-1].getFecha().substring(5, 7)) ){
			
		}else{
			if(progresos[i-1].getFecha().substring(5, 7).equals("01")){
				x.add("Enero");
			}else if(progresos[i-1].getFecha().substring(5, 7).equals("02"))
				x.add("Febrero");
			else if(progresos[i-1].getFecha().substring(5, 7).equals("03"))
				x.add("Marzo");
			else if(progresos[i-1].getFecha().substring(5, 7).equals("04"))
				x.add("Abril");
			else if(progresos[i-1].getFecha().substring(5, 7).equals("05"))
				x.add("Mayo");
			else if(progresos[i-1].getFecha().substring(5, 7).equals("06"))
				x.add("Junio");
			else if(progresos[i-1].getFecha().substring(5, 7).equals("07"))
				x.add("Julio");
			else if(progresos[i-1].getFecha().substring(5, 7).equals("08"))
				x.add("Agosto");
			else if(progresos[i-1].getFecha().substring(5, 7).equals("09"))
				x.add("Septiembre");
			else if(progresos[i-1].getFecha().substring(5, 7).equals("10"))
				x.add("Octubre");
			else if(progresos[i-1].getFecha().substring(5, 7).equals("11"))
				x.add("Noviembre");
			else if(progresos[i-1].getFecha().substring(5, 7).equals("12"))
				x.add("Diciembre");
			y.add(String.valueOf(progresos[i-1].getPeso()));
		}
		if(i==progresos.length-1){
			if(progresos[i].getFecha().substring(5, 7).equals("01")){
				x.add("Enero");
			}else if(progresos[i].getFecha().substring(5, 7).equals("02"))
				x.add("Febrero");
			else if(progresos[i].getFecha().substring(5, 7).equals("03"))
				x.add("Marzo");
			else if(progresos[i].getFecha().substring(5, 7).equals("04"))
				x.add("Abril");
			else if(progresos[i].getFecha().substring(5, 7).equals("05"))
				x.add("Mayo");
			else if(progresos[i].getFecha().substring(5, 7).equals("06"))
				x.add("Junio");
			else if(progresos[i].getFecha().substring(5, 7).equals("07"))
				x.add("Julio");
			else if(progresos[i].getFecha().substring(5, 7).equals("08"))
				x.add("Agosto");
			else if(progresos[i].getFecha().substring(5, 7).equals("09"))
				x.add("Septiembre");
			else if(progresos[i].getFecha().substring(5, 7).equals("10"))
				x.add("Octubre");
			else if(progresos[i].getFecha().substring(5, 7).equals("11"))
				x.add("Noviembre");
			else if(progresos[i].getFecha().substring(5, 7).equals("12"))
				x.add("Diciembre");
			y.add(String.valueOf(progresos[i].getPeso()));
		}
			
	}
	}
	String xs[]= new String[x.size()];
	xs=x.toArray(xs);
	String ys[]= new String[y.size()];
	ys=y.toArray(ys);
	a.setAttribute("x", xs);
	a.setAttribute("y", ys);
	
	response.sendRedirect("Progreso.jsp");
	}
	}
