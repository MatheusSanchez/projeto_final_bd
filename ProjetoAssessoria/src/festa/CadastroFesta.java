package festa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.swing.JFrame;

import conexao.Conexao;

public class CadastroFesta extends JFrame {
	public CadastroFesta() {
		System.out.println("Nao sei oq eu to fazendo mas sei mais ou menos");
		Connection c = Conexao.getInstance();
		
		String sql = "insert into TIME(NOME) values(?)";
		
		Scanner s = new Scanner(System.in);
		
		String str = s.nextLine();
		
		s.close();
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1,  str);
			pstm.execute();
			pstm.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
