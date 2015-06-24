package controlador;

import java.sql.SQLException;

import modelo.AccessUsuarioDAO;
import modelo.Usuario;

public class AccessUser {
	
	private String tipo;
	
	public String Accesa(String username, String password){
		AccessUsuarioDAO busca = new AccessUsuarioDAO();
		try {
			Usuario myuser= busca.findByUsuario(username);
			Usuario myuser1 =busca.findByContrasena(password);
			if(myuser==null){
				tipo="UN"; //Not An User
			if(myuser1==null)
				tipo="PN";//P invalido
			}
			else if(myuser.getPassword().equals(password))
					tipo=myuser.getTipo();
			else
					tipo="incorrecto";//Contrasena incorrecta.
			
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
