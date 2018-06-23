package contratante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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
				pstm.execute();
				
				pstm.close();

				JOptionPane.showMessageDialog(null, "Contratante inserido com sucesso");
				c.commit();
			} catch (SQLException e) {
				try {
					c.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				if (e.getErrorCode() == 1) JOptionPane.showMessageDialog(null, "Erro: CPF ja cadastrado");
				else if (e.getErrorCode() == 1722) JOptionPane.showMessageDialog(null, "Erro: Numero deve ser um dado numerico");
				else if (e.getErrorCode() == 2290) JOptionPane.showMessageDialog(null, "Erro: Telefone, CPF e CEP devem estar formatados corretamente");
				else JOptionPane.showMessageDialog(null, "Erro ao inserir buffet");
			}
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

			c.commit();
			JOptionPane.showMessageDialog(null, "Contratante alterado com sucesso");
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			if (e.getErrorCode() == 1722) JOptionPane.showMessageDialog(null, "Erro: Numero deve ser um dado numerico");
			else if (e.getErrorCode() == 2290) JOptionPane.showMessageDialog(null, "Erro: Telefone, CPF e CEP devem estar formatados corretamente");
			else JOptionPane.showMessageDialog(null, "Erro ao inserir buffet");
		}
	}
	
	static public String[] select(String Cpf){
		
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
			c.commit();
			return s;
			
		} catch (Exception e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Erro ao procurar contratante");
		}
		
		return null;
	}
	
	static public void remove(String Cpf){
		
		Connection c = Conexao.getInstance();	
		String sql = "delete from contratante where cpf = (?)";
		
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1,Cpf);
			
			pstm.execute();
			
			pstm.close();

			JOptionPane.showMessageDialog(null, "Contratante removido com sucesso");
			c.commit();
		} catch (Exception e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Erro ao remover contratante");
		}
	}
}
