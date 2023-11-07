package kernel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ManejoExc.PasswordExcepcion;
import ManejoExc.UserNotFoundExcepcion;
import gui.Saludo;

public class GestorArchivo {
	public static void agregarDatos (Usuario usuario) {
		try {
	        ArrayList<Usuario> usuarios;
	        File archivo = new File("DBUsers.ser");

	        if (archivo.exists() && archivo.length() > 0) {
	            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
	                usuarios = (ArrayList<Usuario>) in.readObject();
	            } catch (IOException | ClassNotFoundException e) {
	                e.printStackTrace();
	                usuarios = new ArrayList<>();
	            }
	        } else {
	            usuarios = new ArrayList<>();
	        }

	       usuarios.add(usuario);

	        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("DBUsers.ser"))) {
	            out.writeObject(usuarios);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public static void iniciarSesion(String correo, String contrasena) {
        try {
        	int id;
            ArrayList<Usuario> usuarios;
            File archivo = new File("DBUsers.ser");

            if (archivo.exists() && archivo.length() > 0) {
                try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
                    usuarios = (ArrayList<Usuario>) in.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                    usuarios = new ArrayList<>();
                }
            } else {
                usuarios = new ArrayList<>();
            }

            for (int i = 0; i < usuarios.size(); i++) {
                Usuario u = usuarios.get(i);
                if (u.getEmail().equals(correo)) {
                    if (u.getContrasena().equals(contrasena)) {
                        id = i; // Inicio de sesión exitoso, se retorna la posición del usuario
                        Saludo ventana = new Saludo(id, usuarios);
                        ventana.setVisible(true);
                        return;
                    } else {
                        throw new PasswordExcepcion();
                    }
                }
            }
            throw new UserNotFoundExcepcion();
        } catch (PasswordExcepcion e) {
        	JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (UserNotFoundExcepcion e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
        //Crear la nueva ventana
    }
}
