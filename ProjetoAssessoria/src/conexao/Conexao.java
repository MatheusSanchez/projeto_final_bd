package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Conexao {
	private static Connection conn;

	private Conexao() {
	}

	public synchronized static Connection getInstance() {
		if (conn == null) {
			try {
				// pegando os dados da conexao com o usuario
				Scanner s = new Scanner(System.in);
				System.out.print("Host: ");
				String host = s.nextLine();
				System.out.print("Port: ");
				String port = s.nextLine();
				System.out.print("User: ");
				String user = s.nextLine();
				System.out.print("Password: ");
				String password = s.nextLine();
				s.close();
				
				conn = DriverManager.getConnection("jdbc:oracle:thin:@" + host + ":" + port + ":orcl", user, password);
				System.out.println("Conexao estabelecida");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Nao foi possivel conectar");
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
