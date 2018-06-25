package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Conexao extends JFrame {
	private static Connection conn;
	private JTextField txtHost;
	private JTextField txtPort;
	private JTextField txtUser;
	private JPasswordField pwdPassword;
	
	private static String host;
	private static String port;
	private static String user;
	private static String password;

	public Conexao() {
		//tela();
	}
	
	public synchronized static Connection getInstance() {
		if (conn == null) {
			try {
				if (host == null) {
					host = JOptionPane.showInputDialog(null, "Host: ");
					port = JOptionPane.showInputDialog(null, "Port: ");
					user = JOptionPane.showInputDialog(null, "User: ");
					password = JOptionPane.showInputDialog(null, "Password: ");
				}
				
				conn = DriverManager.getConnection("jdbc:oracle:thin:@" + host + ":" + port + ":orcl", user, password);
				conn.setAutoCommit(false);
				System.out.println("Conexao estabelecida");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Nao foi possivel conectar");
				host = null;
			}
		}
		return conn;
	}

	public synchronized static void fecharConnexao() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void tela() {
		this.setVisible(true);
		this.setSize(768, 480);
		
		setSize(new Dimension(768, 480));
		getContentPane().setLayout(null);
		
		JLabel lblConexoComO = new JLabel("<html><h1>Conexao com o banco</h1></html>");
		lblConexoComO.setBounds(10, 11, 528, 51);
		getContentPane().add(lblConexoComO);
		
		JLabel lblHost = new JLabel("Host");
		lblHost.setFont(new Font("Dialog", Font.BOLD, 12));
		lblHost.setBounds(153, 126, 46, 14);
		getContentPane().add(lblHost);
		
		JLabel lblPort = new JLabel("Port");
		lblPort.setFont(new Font("Dialog", Font.BOLD, 12));
		lblPort.setBounds(153, 165, 46, 14);
		getContentPane().add(lblPort);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Dialog", Font.BOLD, 12));
		lblUser.setBounds(153, 202, 46, 14);
		getContentPane().add(lblUser);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 12));
		lblPassword.setBounds(153, 239, 64, 14);
		getContentPane().add(lblPassword);
		
		txtHost = new JTextField();
		txtHost.setBounds(263, 124, 183, 20);
		getContentPane().add(txtHost);
		txtHost.setColumns(10);
		
		txtPort = new JTextField();
		txtPort.setBounds(263, 163, 183, 20);
		getContentPane().add(txtPort);
		txtPort.setColumns(10);
		
		txtUser = new JTextField();
		txtUser.setBounds(263, 200, 183, 20);
		getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(263, 237, 183, 20);
		getContentPane().add(pwdPassword);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				host = txtHost.getText();
				port = txtPort.getText();
				user = txtUser.getText();
				password = pwdPassword.getText();
				
			}
		});
		btnConectar.setBounds(528, 323, 89, 23);
		getContentPane().add(btnConectar);
	}
}
