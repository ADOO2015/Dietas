package modelo;

public class AccessDAOFactoria extends DAOFactoria {

	@Override
	public UsuarioDAO getUsuarioDAO() {
		return (UsuarioDAO) new AccessUsuarioDAO(); 
	}

}
