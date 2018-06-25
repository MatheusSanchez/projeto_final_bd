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
	
	public synchronized static Connection getInstance() {
		if (conn == null) {
			try {
				//recebendo dados de conexao do ususario
				if (host == null) {
					host = JOptionPane.showInputDialog(null, "Host: ");
					port = JOptionPane.showInputDialog(null, "Port: ");
					user = JOptionPane.showInputDialog(null, "User: ");
					password = JOptionPane.showInputDialog(null, "Password: ");
				}
				
				conn = DriverManager.getConnection("jdbc:oracle:thin:@" + host + ":" + port + ":orcl", user, password); //conecta com o banco
				conn.setAutoCommit(false);
				System.out.println("Conexao estabelecida");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Nao foi possivel conectar"); //mensagem de erro
				host = null; // para pedir os dados de novo
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
	
}
