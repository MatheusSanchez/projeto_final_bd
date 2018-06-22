package atracao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class Animador {
	static public boolean insert(String nome, String telefone, String email, String tipoAnimacao) {
		Connection c = Conexao.getInstance();
		
		try {
			String sql = "insert into AtracaoCriterio(atracao, tipo) values (?, ?)";
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, nome);
			pstm.setString(2, "ANIMADOR");	
			pstm.execute();
			
			sql = "insert into animador(nome, telefone, email, tipo_animacao) values(?, ?, ?, ?)";
			pstm = c.prepareStatement(sql);
			pstm.setString(1, nome);
			pstm.setString(2, telefone);
			pstm.setString(3, email);
			pstm.setString(4, tipoAnimacao);
			pstm.execute();
			
			pstm.close();

			JOptionPane.showMessageDialog(null, "Animador inserido com sucesso");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao inserir animador");
			return false;
		}
	}
	
	public static List<String> select(String nome) {
		Connection c = Conexao.getInstance();	
		String sql = "select * from animador where nome = (?)";
		
		List<String> s = new ArrayList<String>();

		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, nome);
			
			ResultSet rs = pstm.executeQuery();
			while (rs.next()){
				s.add(rs.getString(2)); //adiciona telefone
				s.add(rs.getString(3)); //adiciona email
				s.add(rs.getString(4)); //adiciona tipo de animacao
			}
			
			pstm.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao procurar animador");
		}
		
		return s;
	}
	
	public static void update(String nome, String telefone, String email, String tipoAnimacao) {
		Connection c = Conexao.getInstance();
		
		try {
			
			String sql = "update animador set telefone = ?, email = ?, tipo_animacao = ? where nome = ?";
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, telefone);
			pstm.setString(2, email);
			pstm.setString(3, tipoAnimacao);
			pstm.setString(4, nome);
			pstm.execute();
		
			pstm.close();

			JOptionPane.showMessageDialog(null, "Animador alterado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao alterar animador");
		}
	}
		
	public static void remove(String nome) {
		Connection c = Conexao.getInstance();
			
		String sql = "delete from animador where nome = ?";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, nome);
			
			pstm.execute();
			pstm.close();
	
			JOptionPane.showMessageDialog(null, "Animador removido com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao remover animador");
		}
	}
}
