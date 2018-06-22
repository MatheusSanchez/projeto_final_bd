package buffet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class BuffetInfantil{
	public static void insert(String s[], String brinquedos[]) {
		Connection c = Conexao.getInstance();
		
		try {
			String sql = "insert into buffetcriterio(buffet, tipo) values(?, 'infantil')";
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, s[0]);
			pstm.execute();
			
			sql = "insert into buffetinfantil(CNPJ, nome, rua, numero, cep, capacidade) "
					+ "values(?, ?, ?, ?, ?, ?)";
			pstm = c.prepareStatement(sql);
			
			for (int i = 0; i < s.length; i++) {
				pstm.setString(i+1, s[i]);
			}
			pstm.execute();
			
			sql = "insert into brinquedos(buffet_infantil,brinquedo) values(?, ?)";
			pstm = c.prepareStatement(sql);
			pstm.setString(1, s[0]);
			
			for (int i = 0; i < brinquedos.length; i++) {
				pstm.setString(2, brinquedos[i]);
				pstm.execute();
			}
			
			pstm.close();

			JOptionPane.showMessageDialog(null, "Buffet infantil inserido com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			
			
			String sql = "delete buffetcriterio where buffet = ?";
			PreparedStatement pstm;
			try {
				pstm = c.prepareStatement(sql);
				pstm.setString(1, s[0]);
				pstm.execute();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (e.getErrorCode() == 1) JOptionPane.showMessageDialog(null, "Erro: CNPJ ja cadastrado");
			else if (e.getErrorCode() == 1722) JOptionPane.showMessageDialog(null, "Erro: Numero e capacidade devem ser dados numericos");
			else if (e.getErrorCode() == 2290) JOptionPane.showMessageDialog(null, "Erro: CNPJ e CEP devem estar formatados corretamente");
			else JOptionPane.showMessageDialog(null, "Erro ao inserir buffet");
		}
	}
	
	public static List<String> select(String cnpj) {
		Connection c = Conexao.getInstance();
		List<String> s = null;
		
		try {
			String sql = "select * from buffetinfantil where CNPJ = ?";
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, cnpj);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				s = new ArrayList<String>();
				
				for (int i = 0; i < 6; i++) {
					s.add(rs.getString(i+1));
				}
			}
			
			sql = "select brinquedo from brinquedos where buffet_infantil = ?";
			pstm = c.prepareStatement(sql);
			pstm.setString(1, cnpj);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				s.add(rs.getString(1));
			}
			
			pstm.close();

		} catch (SQLException e) {
			e.printStackTrace();
			
			if (e.getErrorCode() == 1) JOptionPane.showMessageDialog(null, "Erro: CNPJ ja cadastrado");
			else if (e.getErrorCode() == 1722) JOptionPane.showMessageDialog(null, "Erro: Numero e capacidade devem ser dados numericos");
			else if (e.getErrorCode() == 2290) JOptionPane.showMessageDialog(null, "Erro: CNPJ e CEP devem estar formatados corretamente");
			else JOptionPane.showMessageDialog(null, "Buffet nao encontradoo");
		}
		
		return s;
	}
	
	public static void update(String s[], String brinq[]) {
		Connection c = Conexao.getInstance();
		
		
		try {
			String sql = "update buffetinfantil set nome = ?, rua = ?, numero = ?, cep = ?, capacidade = ?"
					+ " where cnpj = ?";
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(6, s[0]);
			
			for (int i = 1; i < s.length; i++) {
				pstm.setString(i, s[i]);
			}
			pstm.execute();
			
			sql = "delete brinquedos where buffet_infantil = ?";
			pstm = c.prepareStatement(sql);
			pstm.setString(1, s[0]);
			pstm.execute();
			
			sql = "insert into brinquedos(buffet_infantil,brinquedo) values(?, ?)";
			pstm = c.prepareStatement(sql);
			pstm.setString(1, s[0]);
			
			for (int i = 0; i < brinq.length; i++) {
				pstm.setString(2, brinq[i]);
				pstm.execute();
			}
			
			pstm.close();

			JOptionPane.showMessageDialog(null, "Buffet infantil alterado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			
			if (e.getErrorCode() == 1722) JOptionPane.showMessageDialog(null, "Erro: Numero e capacidade devem ser dados numericos");
			else if (e.getErrorCode() == 2290) JOptionPane.showMessageDialog(null, "Erro: CNPJ e CEP devem estar formatados corretamente");
			else JOptionPane.showMessageDialog(null, "Erro ao alterar buffet");
		}
	}
	
	public static void remove(String cnpj) {
		Connection c = Conexao.getInstance();
		
		try {
			String sql = "delete buffetcriterio where buffet = ?";
			
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, cnpj);
			
			pstm.execute();
			pstm.close();

			JOptionPane.showMessageDialog(null, "Buffet de removido com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao remover buffet");
		}
	}
}
