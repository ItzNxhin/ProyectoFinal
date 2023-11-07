package kernel;

import java.io.Serializable;

public class Usuario implements Serializable{
	private String nombreUsuario;
	private String email;
    private String contrasena;

    public Usuario(String nombreUsuario, String email, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.contrasena = contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    public String getEmail() {
		return email;
	}

	public String getContrasena() {
        return contrasena;
    }
}
