package atracao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class Banda {
	
	static public boolean insert(String nome, String telefone, String email, String[] integrantes) {
		Connection c = Conexao.getInstance();
		
		
		String sql = "insert into banda(nome, telefone, email) values(?, ?, ?)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, nome);
			pstm.setString(2, telefone);
			pstm.setString(3, email);
			pstm.execute();
			
			sql = "insert into integrantes(banda, integrante) values(?, ?)";
			pstm = c.prepareStatement(sql);
			pstm.setString(1, nome);
			for (int i = 0; i < integrantes.length; i++) {
				pstm.setString(2, integrantes[i]);
				pstm.execute();
			}
			
			pstm.close();

			JOptionPane.showMessageDialog(null, "Banda inserida com sucesso");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao inserir decoracao");
			return false;
		}
	}
	
	public static List<String> select(String nome) {
		Connection c = Conexao.getInstance();	
		String sql = "select * from banda where nome = (?)";
		
		List<String> s = new ArrayList<String>();

		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, nome);
			
			ResultSet rs = pstm.executeQuery();
			while (rs.next()){
				s.add(rs.getString(2)); //adiciona telefone
				s.add(rs.getString(3)); //adiciona email
			}
			
			pstm.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao procurar tema");
		}
		
		sql = "select integrante from integrantes where banda = (?)";
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, nome);
			
			ResultSet rs = pstm.executeQuery();
			while (rs.next()){
				s.add(rs.getString(1));
			}
			
			pstm.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao procurar integrantes da banda");
		}
		
		return s;
	}
	
	public static void update(String[] form) {
		Connection c = Conexao.getInstance();
		
		try {
			String sql = "delete from integrantes where banda = ?";
			
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, form[0]);
			pstm.execute();
			
			sql = "update banda set telefone = ?, email = ? where nome = ?";
			pstm = c.prepareStatement(sql);
			pstm.setString(1, form[1]);
			pstm.setString(2, form[2]);
			pstm.setString(3, form[0]);
			pstm.execute();
			
			sql = "insert into integrantes(banda, integrante) values(?, ?)";
			pstm = c.prepareStatement(sql);
			
			pstm.setString(1, form[0]);
			for (int i = 3; i < form.length; i++) {
				pstm.setString(2, form[i]);
				pstm.execute();
			}
			
			pstm.close();

			JOptionPane.showMessageDialog(null, "Banda alterada com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao alterar banda");
		}
	}
		
	public static void remove(String nome) {
		Connection c = Conexao.getInstance();
			
		String sql = "delete from banda where nome = ?";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, nome);
			
			pstm.execute();
			pstm.close();
	
			JOptionPane.showMessageDialog(null, "Banda removida com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao remover banda");
		}
	}

}
