package atracao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class Banda {
	
	/* Cadastro de banda no banco*/
	static public boolean insert(String nome, String telefone, String email, String[] integrantes) {
		Connection c = Conexao.getInstance();
		
		
		try {
			/* Insere o tipo "BANDA" na tabela de AtracaoCriterio" */
			String sql = "insert into AtracaoCriterio(atracao, tipo) values (?, ?)";
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, nome);
			pstm.setString(2, "BANDA");	
			pstm.execute();
			
			/* Insere a banda */
			sql = "insert into banda(nome, telefone, email) values(?, ?, ?)";
			pstm = c.prepareStatement(sql);
			pstm.setString(1, nome);
			pstm.setString(2, telefone);
			pstm.setString(3, email);
			pstm.execute();
			
			/* Insere os integrantes da banda */
			sql = "insert into integrantes(banda, integrante) values(?, ?)";
			pstm = c.prepareStatement(sql);
			pstm.setString(1, nome);
			for (int i = 0; i < integrantes.length; i++) {
				pstm.setString(2, integrantes[i]);
				pstm.execute();
			}
			
			pstm.close();
			c.commit();

			JOptionPane.showMessageDialog(null, "Banda inserida com sucesso");
			return true;
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (e.getErrorCode() == 1) JOptionPane.showMessageDialog(null, "Erro: Uma banda com este nome ja foi cadastrada");
			else if (e.getErrorCode() == 2290) JOptionPane.showMessageDialog(null, "Erro: O telefone da banda deve estar formatado corretamente");
			else JOptionPane.showMessageDialog(null, "Erro ao inserir banda");
			
			e.printStackTrace();
			return false;
		}
	}
	
	/* Selecao de banda do banco */
	public static List<String> select(String nome) {
		Connection c = Conexao.getInstance();	
		String sql = "select * from banda where nome = (?)";
		
		List<String> s = new ArrayList<String>(); // resultado do select

		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, nome);
			
			ResultSet rs = pstm.executeQuery();
			while (rs.next()){
				s.add(rs.getString(2)); //adiciona telefone
				s.add(rs.getString(3)); //adiciona email
			}

			sql = "select integrante from integrantes where banda = (?)"; // comando SQL
			pstm = c.prepareStatement(sql);
			pstm.setString(1, nome); // coloca o nome da banda no comando
			
			rs = pstm.executeQuery();
			while (rs.next()){
				s.add(rs.getString(1));
			}
			
			pstm.close();
			c.commit(); // faz o commit das alteracoes
			
		} catch (Exception e) {
			try {
				c.rollback(); // faz o rollback das alteracoes
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Erro ao procurar banda");
		}
		
		return s;
	}
	
	/* Alteracao de banda no banco */
	public static void update(String nome, String telefone, String email, String[] integrantes) {
		Connection c = Conexao.getInstance();
		
		try {
			String sql = "delete from integrantes where banda = ?"; // comando SQL de remocao dos integrantes da banda
			
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, nome);
			pstm.execute();
			
			sql = "update banda set telefone = ?, email = ? where nome = ?"; // faz a alteracao de banda
			pstm = c.prepareStatement(sql);
			pstm.setString(1, telefone);
			pstm.setString(2, email);
			pstm.setString(3, nome);
			pstm.execute();
			
			sql = "insert into integrantes(banda, integrante) values(?, ?)"; // faz a insercao dos novos integrantes da banda
			pstm = c.prepareStatement(sql);
			
			pstm.setString(1, nome);
			for (int i = 0; i < integrantes.length; i++) {
				pstm.setString(2, integrantes[i]);
				pstm.execute();
			}
			
			pstm.close();
			c.commit();

			JOptionPane.showMessageDialog(null, "Banda alterada com sucesso");
		} catch (SQLException e) { // Tratamento de erro
			try {
				c.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if (e.getErrorCode() == 2290) JOptionPane.showMessageDialog(null, "Erro: O telefone da banda deve estar formatado corretamente");
			else JOptionPane.showMessageDialog(null, "Erro ao inserir banda");
			
			e.printStackTrace();
		}
	}
	
	
	/* Remocao de banda do banco */
	public static void remove(String nome) {
		Connection c = Conexao.getInstance();
			
		String sql = "delete from banda where nome = ?"; //comando sql de remocao
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, nome); // coloca o nome da banda no comando
			
			pstm.execute();
			pstm.close();
			c.commit();
	
			JOptionPane.showMessageDialog(null, "Banda removida com sucesso");
		} catch (Exception e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao remover banda");
		}
	}

}
