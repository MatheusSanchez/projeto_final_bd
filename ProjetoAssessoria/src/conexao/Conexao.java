package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;
/*
 * Classe singleton que conecta a aplicacao ao banco
 */
public class Conexao {
	private static Connection conn;

	private Conexao() {
	}

	/* Cria uma instancia ou retorna a existente */
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
				
				conn = DriverManager.getConnection("jdbc:oracle:thin:@" + host + ":" + port + ":orcl", user, password); // conecta ao banco
				conn.setAutoCommit(false);
				System.out.println("Conexao estabelecida");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Nao foi possivel conectar");
			}
		}
		return conn;
	}

	/* Fecha a conexao */
	public synchronized static void fecharConnexao() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
