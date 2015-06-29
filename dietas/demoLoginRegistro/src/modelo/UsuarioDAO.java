package modelo;

import java.sql.SQLException;
import java.util.Collection;

public interface UsuarioDAO {
	
	public Usuario create(String usuario, String nombre, String apellidos, String correo, String password) throws SQLException;
	
	public Collection<Usuario> findAll() throws SQLException;
	
	public Usuario findByUsuario(String usuario) throws SQLException;
	
	public Usuario findByCorreo(String correo) throws SQLException;
	
	public Collection<Usuario> getAllPregistered() throws SQLException;
	
	public void update(Usuario usuario) throws SQLException;
	
	public void insertUser(String nombre, String apellidos, String correo, String password,String sexo) throws SQLException;
	
	public String isUserResgistered(String correo) throws SQLException;
	
	public String getIdUsuarioPaciente(String correo) throws SQLException;
	
	public void insertPaciente(String idUsuarioPaciente, String idEstadoPaciente , String idDireccion,
			String FlgPreregistro) throws SQLException;
}

}
