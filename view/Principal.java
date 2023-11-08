package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ManejoExc.CampoVacioException;
import ManejoExc.CorreoInvalidoException;
import kernel.GestorArchivo;
import kernel.Usuario;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtContra;
	private String usuario;
	private String correo;
	private String contraseña;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setBounds(115, 64, 294, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtContra = new JPasswordField();
		txtContra.setBounds(115, 130, 190, 20);
		contentPane.add(txtContra);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(29, 64, 95, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContrasea.setBounds(29, 130, 95, 18);
		contentPane.add(lblContrasea);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuario = txtUser.getText();
				correo = txtEmail.getText();
				char[] contra = txtContra.getPassword();
				contraseña = String.valueOf(contra);
				try {
					 if (correo.isEmpty() || contraseña.isEmpty() || usuario.isEmpty()) {
				            throw new CampoVacioException();
				        }
					if (!correo.contains("@")) {
			            throw new CorreoInvalidoException();
					}
		            Usuario user = new Usuario(usuario, correo, contraseña);
		            GestorArchivo.agregarDatos(user);
				} catch (CorreoInvalidoException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        } catch (CampoVacioException ex) {
		        	JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		btnCrear.setBounds(115, 188, 89, 23);
		contentPane.add(btnCrear);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				correo = txtEmail.getText();
				char[] contra = txtContra.getPassword();
				contraseña = String.valueOf(contra);
				try {
					 if (correo.isEmpty() || contraseña.isEmpty()) {
				            throw new CampoVacioException();
				        }
					if (!correo.contains("@")) {
			            throw new CorreoInvalidoException();
					}
		            GestorArchivo.iniciarSesion(correo, contraseña);
				} catch (CorreoInvalidoException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        } catch (CampoVacioException ex) {
		        	JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
			}
			
		});
		btnLogin.setBounds(250, 188, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(29, 95, 95, 18);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(115, 95, 294, 20);
		contentPane.add(txtEmail);
	}

}
