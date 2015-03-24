package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgresoDAO {
	private ConexionBD con = ConexionBD.getInstance();
	public Progreso[] MiProgreso(String id){
		Progreso progresos[]; 
		List<Progreso> progreso= new ArrayList<Progreso>();
		String query="SELECT fechaRegistro,peso,altura,perimetroCintura,perimetroCadera,imc,icc from Progreso where idUsuarioPaciente= ? order by fechaRegistro ASC";
		
		PreparedStatement prepStmt;
		try {
			prepStmt = con.builldPreparedStatement(query);
			prepStmt.setString(1, id);
			ResultSet rs = prepStmt.executeQuery();

			while(rs.next()){
				Progreso e= new Progreso();
				e.setAltura(Float.parseFloat(rs.getString("altura")));
				e.setPeso(Float.parseFloat(rs.getString("peso")));
				e.setCintura(Float.parseFloat(rs.getString("perimetroCintura")));
				e.setCadera(Float.parseFloat(rs.getString("perimetroCadera")));
				e.setFecha(rs.getString("fechaRegistro"));
				e.setImc(Float.parseFloat(rs.getString("imc")));
				e.setIcc(Float.parseFloat(rs.getString("icc")));
				progreso.add(e);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		progresos= new Progreso[progreso.size()];
		progresos=progreso.toArray(progresos);
	
		return progresos;
	}
	public void insertProgreso(String id, String fecha,String altura,String peso,String cintura,String cadera)throws SQLException {
			String insertUserSQL = "INSERT INTO Progreso"
					+ "(idUsuarioPaciente,fechaRegistro,altura,peso,perimetroCintura,perimetroCadera,imc,icc,idActividad) VALUES"
					+ "(?,?,?,?,?,?,?,?,1)";
			
			PreparedStatement prepStmt = con.builldPreparedStatement(insertUserSQL);
			prepStmt.setString(1, id);
			prepStmt.setString(2, fecha);
			prepStmt.setString(3, altura);
			prepStmt.setString(4, peso);
			prepStmt.setString(5, cintura);
			prepStmt.setString(6, cadera);
			prepStmt.setString(7, String.valueOf((Float)Float.parseFloat(peso)/(Float.parseFloat(altura)/100)));
			prepStmt.setString(8, String.valueOf((Float)Float.parseFloat(cintura)/Float.parseFloat(cadera)));
			prepStmt.executeUpdate();
		}
}
