package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static Connection conn;

	public Conexao() {
		this.conn = getInstance();
	}

	public synchronized static Connection getInstance() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.183.15:1521:orcl", "M9081453", "matxd96114974!!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Conectou com o banco");
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
