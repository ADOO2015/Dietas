package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
			usuario.setSexo(rs.getString("sexo"));
			usuario.setTipo(rs.getString("TipoUsuario_TipoUsuario"));
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
	public int estaRegistrado(String id) throws SQLException{
		String query ="select * from MedicoPaciente where Paciente_idUsuarioPaciente= ?";
		PreparedStatement prepStmt = con.builldPreparedStatement(query);
		prepStmt.setString(1, id);
		ResultSet rs = prepStmt.executeQuery();
		if(rs.next()){
			return 1;
		}else
			return 0;
	}
	public Usuario findByUsuario(String usuario) throws SQLException {
		String queryByUser = "SELECT d.estado,d.delMun,d.colonia,d.cp,d.calle,d.numExt,d.numInt, u.idUsuario,u.nombre,u.apellido,u.sexo,u.correo,u.pass,t.Descripcion FROM direccion as d INNER JOIN usuario as u on d.idDireccion=u.idUsuario "
				+ " INNER JOIN TipoUsuario as t ON u.TipoUsuario_TipoUsuario=t.TipoUsuario  where u.correo= ?";
		
		PreparedStatement prepStmt = con.builldPreparedStatement(queryByUser);

		prepStmt.setString(1, usuario);

		ResultSet rs = prepStmt.executeQuery();

		Usuario usuarioObj = null;

		if (rs.next()) {
			usuarioObj = new Usuario();
			//usuarioObj.setUsuario(rs.getString("correo"));
			usuarioObj.setId(rs.getString("idUsuario"));
			usuarioObj.setNombre(rs.getString("nombre"));
			usuarioObj.setApellidos(rs.getString("apellido"));
			usuarioObj.setSexo(rs.getString("sexo"));
			usuarioObj.setCorreo(rs.getString("correo"));
			usuarioObj.setPassword(rs.getString("pass"));
			usuarioObj.setTipo(rs.getString("Descripcion"));
			Direccion dir = new Direccion();
			dir.setEstado(rs.getString("estado"));
			dir.setDelmun(rs.getString("delMun"));
			dir.setColonia(rs.getString("colonia"));
			dir.setCp(rs.getString("cp"));
			dir.setNumE(rs.getString("numExt"));
			dir.setNumI(rs.getString("numInt"));
			usuarioObj.setDireccion(dir);
		}

		return usuarioObj;

	}
	
	public Usuario findByContrasena(String password) throws SQLException {
		String queryByUser = "SELECT d.estado,d.delMun,d.colonia,d.cp,d.calle,d.numExt,d.numInt, u.idUsuario,u.nombre,u.apellido,u.sexo,u.correo,u.pass,t.Descripcion FROM direccion as d INNER JOIN usuario as u on d.idDireccion=u.idUsuario "
				+ " INNER JOIN TipoUsuario as t ON u.idUsuario=t.TipoUsuario  where u.pass= ? ";
		
		
		PreparedStatement prepStmt = con.builldPreparedStatement(queryByUser);

		prepStmt.setString(1, password);

		ResultSet rs = prepStmt.executeQuery();

		Usuario usuarioObj = null;

		if (rs.next()) {
			usuarioObj = new Usuario();
			//usuarioObj.setUsuario(rs.getString("correo"));
			usuarioObj.setId(rs.getString("idUsuario"));
			usuarioObj.setNombre(rs.getString("nombre"));
			usuarioObj.setApellidos(rs.getString("apellido"));
			usuarioObj.setSexo(rs.getString("sexo"));
			usuarioObj.setCorreo(rs.getString("correo"));
			usuarioObj.setPassword(rs.getString("pass"));
			usuarioObj.setTipo(rs.getString("Descripcion"));
			Direccion dir = new Direccion();
			dir.setEstado(rs.getString("estado"));
			dir.setDelmun(rs.getString("delMun"));
			dir.setColonia(rs.getString("colonia"));
			dir.setCp(rs.getString("cp"));
			dir.setNumE(rs.getString("numExt"));
			dir.setNumI(rs.getString("numInt"));
			usuarioObj.setDireccion(dir);
			
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
			usuario.setSexo(rs.getString("sexo"));
			usuario.setTipo(rs.getString("TipoUsuario_TipoUsuario"));
			usuario.setPassword(rs.getString("pass"));
			ls.add(usuario);
		}

		return ls;
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


	
	public String getIdUsuario(String correo) throws SQLException {
		String query="SELECT idUsuario from Usuario where correo='"+correo+"'";
		ResultSet res=con.query(query);
		String id="";
		while(res.next())
		id=res.getString("idUsuario");
		return id;
	}

	@Override
	public void insertinTipoUsuario(String correo, String descripcion)
			throws SQLException {
		String insertQuery = "INSERT INTO tipousuario"
				+ "(correo,Descripcion) VALUES"
				+ "("+correo+","+descripcion+")";
		con.insert(insertQuery);
	}

	@Override
	public String getIdTipoUsuario(String correo) throws SQLException {
		String query="SELECT TipoUsuario from tipousuario where correo='"+correo+"'";
		ResultSet res=con.query(query);
		String id="";
		while(res.next())
		id=res.getString("TipoUsuario");
		return id;
	}

	@Override
	public void insertinUsuario(String nombre, String apellidos, String correo,
			String password, String sexo, String TipoUsuario)
			throws SQLException {
		String insertQuery = "INSERT INTO Usuario"
				+ "(nombre, apellido, correo, pass,sexo,TipoUsuario_TipoUsuario) VALUES"
				+ "('"+nombre+"','"+apellidos+"','"+correo+"','"+password+"','"+sexo+"',"+TipoUsuario+")";
		con.insert(insertQuery);
		
	}

	@Override
	public void insertinDireccion(String delMun, String calle,String numeroExt)
			throws SQLException {
		String insertQuery = "INSERT INTO Direccion"
				+ "(delMun, calle, numExt) VALUES"
				+ "('"+delMun+"','"+calle+"','"+numeroExt+"')";
		con.insert(insertQuery);
	}

	@Override
	public void insertPaciente(String idUsuarioPaciente, String idEstadoPaciente , String idDireccion)
			throws SQLException {	
		String insertQuery = "INSERT INTO Paciente"
				+ "(idUsuarioPaciente, idEstadoPaciente, idDireccion) VALUES"
				+ "('"+idUsuarioPaciente+"','"+idEstadoPaciente+"','"+idDireccion+"')";
		con.insert(insertQuery);
	}
	

	@Override
	public String selectLastID() throws SQLException {
		String query="SELECT LAST_INSERT_ID()";
		ResultSet res=con.query(query);
		String id=null;
		while(res.next())
		id=res.getString(1);
		return id;
	}

	@Override
	public Collection<Usuario> bySearchPregistered(String q)
			throws SQLException {
		String searchQuery = "SELECT * FROM USUARIO U INNER JOIN PACIENTE P ON U.IDUSUARIO = P.IDUSUARIOPACIENTE " 
				+ "NATURAL JOIN ESTADOPACIENTE WHERE (nombre LIKE ? OR apellido LIKE ? OR correo LIKE ?) AND DESCESTADOPACIENTE = 'PreRegistro'";

		PreparedStatement prepStmt = con.builldPreparedStatement(searchQuery);
		ArrayList<Usuario> ls = new ArrayList<Usuario>();
		
		prepStmt.setString(1, "%" + q + "%");
		prepStmt.setString(2, "%" + q + "%");
		prepStmt.setString(3, "%" + q + "%");
		
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setNombre(rs.getString("nombre"));
			usuario.setApellidos(rs.getString("apellido"));
			usuario.setCorreo(rs.getString("correo"));
			usuario.setSexo(rs.getString("sexo"));
			usuario.setTipo(rs.getString("TipoUsuario_TipoUsuario"));
			usuario.setPassword(rs.getString("pass"));
			ls.add(usuario);
		}

		return ls;
	}
}
