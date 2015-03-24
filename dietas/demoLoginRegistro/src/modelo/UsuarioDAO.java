package modelo;

import java.sql.SQLException;
import java.util.Collection;

public interface UsuarioDAO {
	
	public Usuario create(String usuario, String nombre, String apellidos, String correo, String password) throws SQLException;
	
	public Collection<Usuario> findAll() throws SQLException;
	
	public Usuario findByUsuario(String usuario) throws SQLException;
	
	public Usuario findByCorreo(String correo) throws SQLException;
	
	public Collection<Usuario> getAllPregistered() throws SQLException;
	
	public Collection<Usuario> bySearchPregistered(String q) throws SQLException;
	
	public void update(Usuario usuario) throws SQLException;
	
	public void insertinUsuario(String nombre, String apellidos, String correo, String password,String sexo,String TipoUsuario) throws SQLException;
	
	public String isUserResgistered(String correo) throws SQLException;
	
	public String getIdUsuario(String correo) throws SQLException;
	
	public String getIdTipoUsuario(String correo) throws SQLException;
	
	public void insertinTipoUsuario(String correo,String descripcion) throws SQLException;
	
	public void insertinDireccion(String ciudad,String calle,String numeroExt) throws SQLException;
	
	public void insertPaciente(String idUsuarioPaciente, String idEstadoPaciente , String idDireccion) throws SQLException;
	
	public String selectLastID() throws SQLException;

	int estaRegistrado(String id) throws SQLException;


}


