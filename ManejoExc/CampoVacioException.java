package ManejoExc;

public class CampoVacioException extends Exception{
	public CampoVacioException () {
		super("Por favor, digite un usuario o contraseña");
	}
}
