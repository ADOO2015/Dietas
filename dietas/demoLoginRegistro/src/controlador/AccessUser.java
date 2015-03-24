package controlador;

import java.sql.SQLException;

import modelo.AccessUsuarioDAO;
import modelo.Usuario;

public class AccessUser {
	
	private String tipo;
	private Usuario usuario;
	public Usuario getUsuario(){
		return usuario;
	}
	public String Accesa(String username, String password){
		AccessUsuarioDAO busca = new AccessUsuarioDAO();

		try {
			Usuario myuser= busca.findByUsuario(username);
			Usuario myuser1 =busca.findByContrasena(password);
			
			if(myuser !=null && myuser.getPassword().equals(password)){
				tipo =myuser.getTipo();
				usuario=myuser;
				if(tipo.equals("Paciente")){
					int esr= busca.estaRegistrado(usuario.getId());
					if(esr==0)
						tipo ="PN";
				}
			}else if(myuser==null && myuser1==null)
				tipo ="incorrecto";
			else if(myuser1==null && myuser!=null){
				tipo="PN";
			}else if(myuser1!=null && myuser==null){
				tipo="UN";
			}
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(tipo);
		return tipo;
	}
	
}
