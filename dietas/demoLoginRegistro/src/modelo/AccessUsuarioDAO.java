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
			usuario.setNombre(rs.getString("nombre"));
			usuario.setApellidos(rs.getString("apellido"));
			usuario.setCorreo(rs.getString("correo"));
			usuario.setCorreo(rs.getString("sexo"));
			usuario.setCorreo(rs.getString("TipoUsuario_TipoUsuario"));
			usuario.setPassword(rs.getString("pass"));

			ls.add(usuario);
		}

		return ls;

	}

	public Collection<Usuario> findByMedico(String idMedico) {
		String queryAll = "SELECT * FROM Paciente p JOIN MedicoPaciente mp on p.idUsuarioPaciente = mp.Paciente_idUsuarioPaciente "
				+ "JOIN Medico m on m.idUsuarioMedico = mp.Medico_idUsuarioMedico "
				+ "JOIN Usuario u on p.idUsuarioPaciente = u.idUsuario "
				+ "where m.idUsuarioMedico = " + idMedico; // example es el
															// nombre de la
		// tabla

		ArrayList<Usuario> ls = new ArrayList<Usuario>();

		try {
			ResultSet rs = con.query(queryAll);
			while (rs.next()) {
				// datos de la tabla
				Usuario usuario = new Usuario();
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellidos(rs.getString("apellido"));
				usuario.setCorreo(rs.getString("correo"));
				usuario.setCorreo(rs.getString("sexo"));
				usuario.setCorreo(rs.getString("TipoUsuario_TipoUsuario"));
				usuario.setPassword(rs.getString("pass"));

				ls.add(usuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ls;

	}

	@Override
	public Usuario findByUsuario(String usuario) throws SQLException {
		String queryByUser = "SELECT u.nombre,u.apellido,u.sexo,u.correo,u.pass,t.Descripcion FROM usuario as u"
				+ " INNER JOIN TipoUsuario as t ON u.idUsuario=t.TipoUsuario where u.correo= ? ";

		PreparedStatement prepStmt = con.builldPreparedStatement(queryByUser);

		prepStmt.setString(1, usuario);

		ResultSet rs = prepStmt.executeQuery();

		Usuario usuarioObj = null;

		if (rs.next()) {
			usuarioObj = new Usuario();
			// usuarioObj.setUsuario(rs.getString("correo"));
			usuarioObj.setNombre(rs.getString("nombre"));
			usuarioObj.setApellidos(rs.getString("apellido"));
			usuarioObj.setSexo(rs.getString("sexo"));
			usuarioObj.setCorreo(rs.getString("correo"));
			usuarioObj.setPassword(rs.getString("pass"));
			usuarioObj.setTipo(rs.getString("Descripcion"));
		}

		return usuarioObj;

	}

	public Usuario findByContrasena(String password) throws SQLException {
		String queryByUser = "SELECT u.nombre,u.apellido,u.sexo,u.correo,u.pass,t.Descripcion FROM usuario as u"
				+ " INNER JOIN TipoUsuario as t ON u.idUsuario=t.TipoUsuario where u.correo= ? ";

		PreparedStatement prepStmt = con.builldPreparedStatement(queryByUser);

		prepStmt.setString(1, password);

		ResultSet rs = prepStmt.executeQuery();

		Usuario usuarioObj = null;

		if (rs.next()) {
			usuarioObj = new Usuario();
			// usuarioObj.setUsuario(rs.getString("correo"));
			usuarioObj.setNombre(rs.getString("nombre"));
			usuarioObj.setApellidos(rs.getString("apellido"));
			usuarioObj.setSexo(rs.getString("sexo"));
			usuarioObj.setCorreo(rs.getString("correo"));
			usuarioObj.setPassword(rs.getString("pass"));
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
					.getAllPregistered();
			System.out.println("Iterando en toda la tabla");

			for (Usuario usuario : usuarios) {
				System.out.println("USUARIO " + usuario.getNombre());
			}

			// Usuario usuario = usuarioDAO.findByUsuario("manager");
			//
			// if (usuario != null) {
			// System.out.println("Usuario encontrado por nombre de usuario: " +
			// usuario.getNombre() + " "
			// + usuario.getApellidos());
			// }
			//
			// Usuario otroUsuario = usuarioDAO.create("tester", "pedro",
			// "picapiedra", "pica@gmail.com", "picapass");
			//
			// System.out.println("Nuevo usuario " + otroUsuario.getNombre()
			// + " " + otroUsuario.getApellidos());
			//
			// otroUsuario.setNombre("Pablo");
			// otroUsuario.setApellidos("Marmol");
			//
			// usuarioDAO.update(otroUsuario);
			//
			// Usuario usuarioModificado = usuarioDAO.findByUsuario("tester");
			//
			// if (usuarioModificado != null) {
			// System.out.println("Usuario modificado: " +
			// usuarioModificado.getNombre() + " "
			// + usuarioModificado.getApellidos());
			// }
			//

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

	public void cerrarConexion() {
		con.cerrarConexion();
	}

	@Override
	public Collection<Usuario> getAllPregistered() throws SQLException {
		String q = "SELECT * FROM USUARIO U INNER JOIN PACIENTE P ON U.IDUSUARIO = P.IDUSUARIOPACIENTE " 
				+ "NATURAL JOIN ESTADOPACIENTE WHERE DESCESTADOPACIENTE = 'PreRegistro'";

		ArrayList<Usuario> ls = new ArrayList<Usuario>();

		ResultSet rs = con.query(q);

		while (rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setNombre(rs.getString("nombre"));
			usuario.setApellidos(rs.getString("apellido"));
			usuario.setCorreo(rs.getString("correo"));
			usuario.setCorreo(rs.getString("sexo"));
			usuario.setCorreo(rs.getString("TipoUsuario_TipoUsuario"));
			usuario.setPassword(rs.getString("pass"));
			ls.add(usuario);
		}

		return ls;
	}
	
	@Override
	public void insertUser(String nombre, String apellidos, String correo,
			String password,String sexo) throws SQLException {
		String insertQuery = "INSERT INTO Usuario"
				+ "(nombre, apellido, correo, pass,sexo,TipoUsuario_TipoUsuario) VALUES"
				+ "('"+nombre+"','"+apellidos+"','"+correo+"','"+password+"','"+sexo+"',2)";
		con.insert(insertQuery);
	}

	@Override
	public String isUserResgistered(String correo) throws SQLException {
		String query="SELECT nombre from Usuario where correo='"+correo+"'";
		ResultSet res=con.query(query);
		String nombre="";
		while(res.next())
		nombre=res.getString("nombre");
		return nombre;
	}

	@Override
	public void insertPaciente(String idUsuarioPaciente,
			String idEstadoPaciente, String idDireccion, String FlgPreregistro)
			throws SQLException {
			String insertQuery = "INSERT INTO Paciente"
					+ "(idUsuarioPaciente, idEstadoPaciente, idDireccion, FlgPreregistro) VALUES"
					+ "("+idUsuarioPaciente+","+idEstadoPaciente+","+idDireccion+","+FlgPreregistro+")";
			con.insert(insertQuery);
		
	}

	@Override
	public String getIdUsuarioPaciente(String correo) throws SQLException {
		String query="SELECT idUsuario from Usuario where correo='"+correo+"'";
		ResultSet res=con.query(query);
		String id="";
		while(res.next())
		id=res.getString("idUsuario");
		return id;
	}
}
