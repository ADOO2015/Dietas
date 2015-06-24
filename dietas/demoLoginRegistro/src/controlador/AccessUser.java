package controlador;

import java.sql.SQLException;

import modelo.AccessUsuarioDAO;
import modelo.Usuario;

public class AccessUser {
	
	private String tipo;
	
	public String Accesa(String username, String password){
		AccessUsuarioDAO busca = new AccessUsuarioDAO();
		try {
			Usuario myuser= busca.findByCorreo(username);
			if(myuser==null)
				tipo="NAU"; //Not An User
			else 
				if(myuser.getPassword().equals(password))
					tipo=myuser.getTipo();
				else
					tipo="DNV";//Contrasena incorrecta.
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tipo;
	}
	public static void main(String a[]){
		AccessUser as = new AccessUser();
		System.out.println(as.Accesa("moica","moi"));
	}
}
