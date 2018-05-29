package festa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.swing.JFrame;

import conexao.Conexao;

public class CadastroFesta extends JFrame {
	
	public CadastroFesta(String Time, String Estado, String Tipo,String Saldo) {
		System.out.println("Cadastro da Festa Inicado");
		Connection c = Conexao.getInstance();
		
		String values = Time + ',' + Estado + ',' + Tipo + ',' + Saldo;
		System.out.println("String SQL " + values);
		
		String sql = "insert into TIME(NOME,ESTADO,TIPO,SALDO_GOLS) values(?,?,?,?)";
		
		try{
				
			PreparedStatement pstm = c.prepareStatement(sql);
			
			pstm.setString(1,  Time); // NOME // faz o parsing colocando na posicao da interrogação a string passada por parâmetro
			pstm.setString(2,  Estado); // ESTADO
			pstm.setString(3,  Tipo); // TIPO
			pstm.setString(4,  Saldo); // SALDO_GOLS
		
			pstm.execute();	 // executa a query
			pstm.close();	
		
			System.out.println("Cadastro de Festa Feito com Sucesso !");
				
		}catch (Exception e){
				e.printStackTrace();
		}
		
		
	}	
	
	public CadastroFesta() {
		System.out.println("Nao sei oq eu to fazendo mas sei mais ou menos");
		
		Connection c = Conexao.getInstance();
		
		String sql = "insert into TIME(NOME,ESTADO,TIPO,SALDO_GOLS) values(?,?,?,?)";
		//String sql = "insert into TIME(NOME) values(?)";
		
		Scanner s = new Scanner(System.in);
			
		try {
			
			PreparedStatement pstm = c.prepareStatement(sql);
		
			String str = s.nextLine();
			pstm.setString(1,  str);
			str = s.nextLine();
			pstm.setString(2,  str);
			str = s.nextLine();
			pstm.setString(3,  str);
			str = s.nextLine();
			pstm.setString(4,  str);
			
			pstm.execute();
		
			pstm.close();
			
			s.close();
			System.out.println("Cadastro de Festa Feito com Sucesso !0");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
