package modelo;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

    static Connection con;
    
    private static ConexionBD INSTANCE = null;  
    private Statement statement;
    /**Método constructor que ejecuta el método para conectar con la base de datos
     *
     */
    private ConexionBD() {
        realizarConexion();
    }
    /**Crea una instancia de la base de datos en caso de no estar creada.
     *
     */
    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConexionBD();
        }
    }

    /**Metodo para retorna una instancia de la conexion. Si no esta creada la crea, y si esta creada la retorna
     * @return retorna una instancia de la conexión a la base de datos
     */
    public static ConexionBD getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }

    /**Método para eliminar la instancia de la conexión
     *
     */
    public static void delInstance() {
        INSTANCE = null;
        cerrarConexion();
    }

    /**Método que crea la conexión a la base de datos
     *
     */
    public void realizarConexion() {

        String host = "localhost:3306";//cambiar por tu host de la base de datos
        String user = "root";//cambiar por tu usuario de la base de datos
        String pass = "";//cambiar por tu contraseña de la base de datos
        String dtbs = "dietas";//cambiar por tu nombre de la base de datos

        try { // preparamos la conexión
            Class.forName("com.mysql.jdbc.Driver");
            String newConnectionURL = "jdbc:mysql://" + host + "/" + dtbs + "?"
                    + "user=" + user + "&password=" + pass;
            con = DriverManager.getConnection(newConnectionURL);
        } catch (Exception e) {
            System.out.println("Error al abrir la conexión.");
        }
    }

    /**Método para cerrar la conexión con la base de dades
     *
     */
    public static void cerrarConexion() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión.");
        }
    }
    
   public ResultSet query(String query) throws SQLException{
       statement = con.createStatement();
       ResultSet res = statement.executeQuery(query);
       return res;
   }
   
   public int insert(String insertQuery) throws SQLException {
       statement = con.createStatement();
       int result = statement.executeUpdate(insertQuery);
       return result;

   }
   
   public PreparedStatement builldPreparedStatement(String query) throws SQLException {
       PreparedStatement prepStmt = con.prepareStatement(query);
       return prepStmt;
   }
    
}
