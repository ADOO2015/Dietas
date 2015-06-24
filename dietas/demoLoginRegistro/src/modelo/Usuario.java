package modelo;

public class Usuario {
	
	private String usuario;
	
	private String nombre;
	
	private String apellidos;
	
	private String correo;
	
	private String password;
	
	private String tipo;

	private String sexo;
	
	public String getTipo() {
		return tipo;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setSexo(String sexo) {
		this.sexo=sexo;
	}
	
	
}
