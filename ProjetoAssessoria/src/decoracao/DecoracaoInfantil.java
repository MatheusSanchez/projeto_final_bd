package decoracao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class DecoracaoInfantil {
	
	public DecoracaoInfantil(){
		
	}
	
	static public void insert(String tema, String qtdeBaloes, boolean pinata, String[] cores) {
		Connection c = Conexao.getInstance(); //inicia a conexao
		
		String sql = "insert into decoracaoinfantil(tema, qtde_baloes, pinata) values(?, ?, ?)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, tema);
			pstm.setString(2, qtdeBaloes);
			pstm.setString(3, pinata? "1" : "0");
			pstm.execute(); //insere na tabela decoracaoinfantil
			
			sql = "insert into corbaloes(decoracao, cor) values(?, ?)";
			pstm = c.prepareStatement(sql);
			pstm.setString(1, tema);
			for (int i = 0; i < cores.length; i++) {
				pstm.setString(2, cores[i]);
				pstm.execute(); //insere na tabela corbaloes 
			}
			
			pstm.close();
			
			c.commit();
			JOptionPane.showMessageDialog(null, "Decoracao de aniversario infantil inserida com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Erro ao inserir decoracao");
		}
	}
	
	public static List<String> select(String tema) {
		Connection c = Conexao.getInstance();	
		String sql = "select * from decoracaoinfantil where tema = (?)";
		
		List<String> s = new ArrayList<String>();

		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, tema);
			
			ResultSet rs = pstm.executeQuery();
			while (rs.next()){
				s.add(rs.getString(2)); //adiciona qtdeBaloes
				s.add(rs.getString(3).trim()); //adiciona pinata
			}
			
		
			sql = "select cor from corbaloes where decoracao = (?)";
			pstm = c.prepareStatement(sql);
			pstm.setString(1, tema);
			
			rs = pstm.executeQuery();
			while (rs.next()){
				s.add(rs.getString(1));
			}
			
			pstm.close();
			c.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Erro ao procurar decoracao");
		}
		
		return s; //retorna uma lista com as colunas obtidas ou null quando nao encontrou
	}
	
	public static void update(String[] form) {
		Connection c = Conexao.getInstance();
		
		try {
			String sql = "delete from corbaloes where decoracao = ?";
			
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, form[0]);
			pstm.execute(); //apaga as cores que ja existiam
			
			for(int i = 0; i < form.length; ++i) System.out.println(form[i]);
			
			//atualiza decoracaoinfantil
			sql = "update decoracaoinfantil set qtde_baloes = ?, pinata = ? where tema = ?";
			pstm = c.prepareStatement(sql);
			pstm.setString(1, form[1]);
			pstm.setString(2, form[2]);
			pstm.setString(3, form[0]);
			pstm.execute();
			
			sql = "insert into corbaloes(decoracao, cor) values(?, ?)";
			pstm = c.prepareStatement(sql);
			
			pstm.setString(1, form[0]);
			for (int i = 3; i < form.length; i++) {
				pstm.setString(2, form[i]);
				pstm.execute(); //insere as cores novas aqui
			}
			
			pstm.close();
			
			c.commit();
			JOptionPane.showMessageDialog(null, "Decoracao alterada com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				c.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Erro ao alterar decoracao");
		}

	}
	
	public static void remove(String tema) {
		Connection c = Conexao.getInstance();
		
		String sql = "delete from decoracaoinfantil where tema = ?";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, tema);
			
			pstm.execute();
			pstm.close();

			JOptionPane.showMessageDialog(null, "Decoracao removida com sucesso");
			c.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Erro ao remover decoracao");
		}
	}
}
