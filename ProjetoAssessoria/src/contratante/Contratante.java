package contratante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conexao.Conexao;

public class Contratante {
	static public void insert(String[] form) {
		
			Connection c = Conexao.getInstance();
			
			String sql = "insert into contratante(cpf, nome, telefone, email, rua, numero, bairro, cep) values(?, ?, ?, ?, ?, ?, ?, ?)";
			
			try {
				PreparedStatement pstm = c.prepareStatement(sql);
				System.out.println("preparando");
				for (int i = 0; i < 8; i++) {
					pstm.setString(i + 1, form[i]);
				}
				System.out.println("ex");
				pstm.execute();
				System.out.println("f ex");
				
				pstm.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				//botar tela de alerta
			}
			
			System.out.println("fim");
	}
	
	static public void update(String[] form) {
		
		Connection c = Conexao.getInstance();
		
		String sql = "UPDATE CONTRATANTE SET NOME = ?, TELEFONE = ?, EMAIL = ?, RUA = ?, NUMERO = ?, BAIRRO = ?, CEP = ? WHERE CPF = ?";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			
			for (int i = 0; i < 7; i++) {
				pstm.setString(i + 1, form[i+1]);
			}
			pstm.setString(8, form[0]);
			pstm.execute();
			pstm.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			//botar tela de alerta
		}
}
	
	static public String[] selectContratante(String Cpf){
		
		Connection c = Conexao.getInstance();	
		String sql = "select * from contratante where cpf = (?)";
		
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1,Cpf);
			
			ResultSet rs = pstm.executeQuery();
			String[] s = null;
			while (rs.next()){
				s = new String[7];
				for (int i = 0; i < 7; i++) {
					s[i] = rs.getString(i+2);
				}
			}
			
			pstm.close();
			return s;
			
		} catch (Exception e) {
			e.printStackTrace();
			//botar tela de alerta
		}
		
		return null;
	}
}
