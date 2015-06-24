package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import modelo.ConexionBD;
import modelo.DAOFactoria;
import modelo.Usuario;
import modelo.UsuarioDAO;

public class AccessUsuarioDAO implements UsuarioDAO {

	private ConexionBD con = ConexionBD.getInstance();

	@Override
	public Usuario create(String usuario, String nombre, String apellidos,
			String correo, String password) throws SQLException {
		String insertUserSQL = "INSERT INTO USUARIO"
				+ "(USUARIO, NOMBRE, APELLIDOS, CORREO, PASSWORD) VALUES"
				+ "(?,?,?,?,?)";

		Usuario usuarioObj = null;

		PreparedStatement prepStmt = con.builldPreparedStatement(insertUserSQL);
		prepStmt.setString(1, usuario);
		prepStmt.setString(2, nombre);
		prepStmt.setString(3, apellidos);
		prepStmt.setString(4, correo);
		prepStmt.setString(5, password);

		if (prepStmt.executeUpdate() != 0) {
			usuarioObj = new Usuario();
			usuarioObj.setUsuario(usuario);
			usuarioObj.setNombre(nombre);
			usuarioObj.setApellidos(apellidos);
			usuarioObj.setCorreo(correo);
			usuarioObj.setPassword(password);
		}

		return usuarioObj;
	}

	@Override
	public Collection<Usuario> findAll() throws SQLException {
		String queryAll = "SELECT * FROM usuario"; // example es el nombre de la
													// tabla

		ArrayList<Usuario> ls = new ArrayList<Usuario>();

		ResultSet rs = con.query(queryAll);

		while (rs.next()) {
			// datos de la tabla
			Usuario usuario = new Usuario();
			usuario.setUsuario(rs.getString("usuario"));
			usuario.setNombre(rs.getString("nombre"));
			usuario.setApellidos(rs.getString("apellidos"));
			usuario.setCorreo(rs.getString("correo"));
			usuario.setPassword(rs.getString("password"));

			ls.add(usuario);
		}

		return ls;

	}

	@Override
	public Usuario findByUsuario(String usuario) throws SQLException {
		String queryByUser = "SELECT u.nombre,u.apellido,u.sexo,u.correo,u.pass,t.Descripcion FROM Usuario as u"
				+ " INNER JOIN TipoUsuario as t ON u.idUsuario=t.TipoUsuario";

		PreparedStatement prepStmt = con.builldPreparedStatement(queryByUser);

		prepStmt.setString(1, usuario);

		ResultSet rs = prepStmt.executeQuery();

		Usuario usuarioObj = null;

		if (rs.next()) {
			usuarioObj = new Usuario();
			//usuarioObj.setUsuario(rs.getString("correo"));
			usuarioObj.setNombre(rs.getString("nombre"));
			usuarioObj.setApellidos(rs.getString("apellido"));
			usuarioObj.setSexo(rs.getString("sexo"));
			usuarioObj.setCorreo(rs.getString("correo"));
			usuarioObj.setPassword(rs.getString("password"));
			usuarioObj.setTipo(rs.getString("Descripcion"));
		}

		return usuarioObj;

	}

	@Override
	public void update(Usuario usuario) throws SQLException {
		String updateUserSQL = "UPDATE USUARIO SET nombre = ?, "
				+ "apellidos = ?, correo = ?, password = ? WHERE usuario = ?";
		
		PreparedStatement prepStmt = con.builldPreparedStatement(updateUserSQL);
		
		prepStmt.setString(1, usuario.getNombre());
		prepStmt.setString(2, usuario.getApellidos());
		prepStmt.setString(3, usuario.getCorreo());
		prepStmt.setString(4, usuario.getPassword());
		prepStmt.setString(5, usuario.getUsuario());
		prepStmt.executeUpdate();

	}

	public static void main(String[] args) {
		DAOFactoria fact = DAOFactoria.getDAOFactoria(1);
		UsuarioDAO usuarioDAO = fact.getUsuarioDAO();
		try {
			ArrayList<Usuario> usuarios = (ArrayList<Usuario>) usuarioDAO
					.findAll();
			System.out.println("Iterando en toda la tabla");
			
			for (Usuario usuario : usuarios) {
				System.out.println("USUARIO " + usuario.getNombre());
			}

			Usuario usuario = usuarioDAO.findByUsuario("manager");

			if (usuario != null) {
				System.out.println("Usuario encontrado por nombre de usuario: " + usuario.getNombre() + " "
						+ usuario.getApellidos());
			}

			Usuario otroUsuario = usuarioDAO.create("tester", "pedro",
					"picapiedra", "pica@gmail.com", "picapass");
			
			System.out.println("Nuevo usuario " + otroUsuario.getNombre()
					+ " " + otroUsuario.getApellidos());
			
			otroUsuario.setNombre("Pablo");
			otroUsuario.setApellidos("Marmol");
			
			usuarioDAO.update(otroUsuario);
			
			Usuario usuarioModificado = usuarioDAO.findByUsuario("tester");
			
			if (usuarioModificado != null) {
				System.out.println("Usuario modificado: " + usuarioModificado.getNombre() + " "
						+ usuarioModificado.getApellidos());
			}
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Usuario findByCorreo(String correo) throws SQLException {
		String queryByUser = "SELECT * FROM USUARIO WHERE usuario.correo = ?";

		PreparedStatement prepStmt = con.builldPreparedStatement(queryByUser);

		prepStmt.setString(1, correo);

		ResultSet rs = prepStmt.executeQuery();

		Usuario usuarioObj = null;

		if (rs.next()) {
			usuarioObj = new Usuario();
			usuarioObj.setUsuario(rs.getString("usuario"));
			usuarioObj.setNombre(rs.getString("nombre"));
			usuarioObj.setApellidos(rs.getString("apellidos"));
			usuarioObj.setCorreo(rs.getString("correo"));
			usuarioObj.setPassword(rs.getString("password"));
		}

		return usuarioObj;

	}

}
