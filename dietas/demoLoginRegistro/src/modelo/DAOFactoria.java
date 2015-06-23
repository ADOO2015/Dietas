package modelo;

public abstract class DAOFactoria {
	
	public abstract UsuarioDAO getUsuarioDAO();
	
	public final static int ACCESS = 1;
	
	public static DAOFactoria getDAOFactoria (int tipo) {
		switch (tipo) {
			case ACCESS:
				return new AccessDAOFactoria(); 
			default:
				return null;
		}
	}
}
