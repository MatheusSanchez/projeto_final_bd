package atracao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class Animador {
	
	/* Cadastro de animador no banco */
	static public boolean insert(String nome, String telefone, String email, String tipoAnimacao) {
		Connection c = Conexao.getInstance();
		
		try {
			/* Insere o tipo "ANIMADOR" na tabela de AtracaoCriterio" */
			String sql = "insert into AtracaoCriterio(atracao, tipo) values (?, ?)"; // comando SQL
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, nome);
			pstm.setString(2, "ANIMADOR");	
			pstm.execute();
			
			/* Insere o animador */
			sql = "insert into animador(nome, telefone, email, tipo_animacao) values(?, ?, ?, ?)"; // comando SQL
			pstm = c.prepareStatement(sql);
			pstm.setString(1, nome);
			pstm.setString(2, telefone);
			pstm.setString(3, email);
			pstm.setString(4, tipoAnimacao);
			pstm.execute();
			
			pstm.close();
			c.commit();

			JOptionPane.showMessageDialog(null, "Animador inserido com sucesso");
			return true;
		} catch (SQLException e) { // Tratamento de erro
			try {
				c.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			e.printStackTrace();
			if (e.getErrorCode() == 1) JOptionPane.showMessageDialog(null, "Erro: Um animador com este nome ja foi cadastrado");
			else if (e.getErrorCode() == 2290) JOptionPane.showMessageDialog(null, "Erro: O telefone do animador deve estar formatado corretamente");
			else JOptionPane.showMessageDialog(null, "Erro ao inserir animador");
			return false;
		}
	}
	
	/* Seleciona um animador pelo seu nome (sua chave primaria) */
	public static List<String> select(String nome) {
		Connection c = Conexao.getInstance();	
		String sql = "select * from animador where nome = (?)"; // comando SQL
		
		List<String> s = new ArrayList<String>(); // resultado da selecao

		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, nome);
			
			ResultSet rs = pstm.executeQuery();
			while (rs.next()){
				s.add(rs.getString(2)); // adiciona telefone
				s.add(rs.getString(3)); // adiciona email
				s.add(rs.getString(4)); // adiciona tipo de animacao
			}
			
			pstm.close();
			c.commit();
			
		} catch (Exception e) { // Tratamento de erro
			try {
				c.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Erro ao procurar animador");
		}
		
		return s;
	}
	
	/* Update do animador no banco de dados */
	public static void update(String nome, String telefone, String email, String tipoAnimacao) {
		Connection c = Conexao.getInstance();
		
		try {
			
			String sql = "update animador set telefone = ?, email = ?, tipo_animacao = ? where nome = ?"; // comando SQL
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, telefone); // seta o telefone no comando
			pstm.setString(2, email); // seta o email no comando
			pstm.setString(3, tipoAnimacao); // seta o tipoAnimacao no comando
			pstm.setString(4, nome); // seta o nome no comando
			pstm.execute();
		
			pstm.close();
			c.commit();

			JOptionPane.showMessageDialog(null, "Animador alterado com sucesso");
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/* Tratamento de erro */
			if (e.getErrorCode() == 2290) JOptionPane.showMessageDialog(null, "Erro: O telefone do animador deve estar formatado corretamente");
			else JOptionPane.showMessageDialog(null, "Erro ao alterar animador");
		}
	}
	
	
	/* Remocao do animador do banco de dados */
	public static void remove(String nome) {
		Connection c = Conexao.getInstance();
			
		String sql = "delete from animador where nome = ?"; // comando SQL
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, nome); // coloca o nome no comando SQL
			
			pstm.execute();
			pstm.close();
			c.commit();
	
			JOptionPane.showMessageDialog(null, "Animador removido com sucesso");
		} catch (Exception e) { // tratamento de erro
			try {
				c.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao remover animador");
		}
	}
}
