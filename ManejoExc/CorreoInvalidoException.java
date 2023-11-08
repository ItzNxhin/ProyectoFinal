package ManejoExc;

public class CorreoInvalidoException extends Exception{
	 public CorreoInvalidoException() {
	        super("El correo que ha digitado no es valido");
	    }
}
