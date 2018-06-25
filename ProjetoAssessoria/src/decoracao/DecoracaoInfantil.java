package decoracao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conexao;
/*
 * Classe de operacoes SQL de DecoracaoInfantil
 */
public class DecoracaoInfantil {
	
	public DecoracaoInfantil(){
		
	}
	
	/* Insercao de uma decoracao infantil */
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
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			// Tratamento de erros da insercao da decoracao infantil
			if (e.getErrorCode() == 1) JOptionPane.showMessageDialog(null, "Erro: tema ja cadastrado");
			else if (e.getErrorCode() == 1400) JOptionPane.showMessageDialog(null, "Erro: Campo tema deve ser preenchido");
			else if (e.getErrorCode() == 1438) JOptionPane.showMessageDialog(null, "Erro: Quantidade de flores grande demais");
			else if (e.getErrorCode() == 1722) JOptionPane.showMessageDialog(null, "Erro: Quantidade de baloes deve ser um dado numerico e nao negativo");
			else JOptionPane.showMessageDialog(null, "Erro ao inserir decoracao");
		}
	}
	
	/* Selecao de uma decoracao infantil */
	public static List<String> select(String tema) {
		Connection c = Conexao.getInstance();	
		String sql = "select * from decoracaoinfantil where tema = (?)"; // comando SQL
		
		List<String> s = new ArrayList<String>();

		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, tema);
			
			ResultSet rs = pstm.executeQuery();
			while (rs.next()){
				s.add(rs.getString(2)); //adiciona qtdeBaloes na resposta
				s.add(rs.getString(3).trim()); //adiciona pinata na resposta
			}
			
			// Seleciona as cores dos baloes
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
	
	
	/* Atualiza uma decoracao infantil */
	public static void update(String[] form) {
		Connection c = Conexao.getInstance();
		
		try {
			String sql = "delete from corbaloes where decoracao = ?"; // remove as tuplas do atributo multivalorado corbaloes
			
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, form[0]);
			pstm.execute();
			
			//atualiza decoracaoinfantil
			sql = "update decoracaoinfantil set qtde_baloes = ?, pinata = ? where tema = ?";
			pstm = c.prepareStatement(sql);
			pstm.setString(1, form[1]);
			pstm.setString(2, form[2]);
			pstm.setString(3, form[0]);
			pstm.execute();
			
			sql = "insert into corbaloes(decoracao, cor) values(?, ?)"; // reinsere as cores, atualizadas
			pstm = c.prepareStatement(sql);
			
			pstm.setString(1, form[0]);
			for (int i = 3; i < form.length; i++) {
				pstm.setString(2, form[i]);
				pstm.execute(); //insere as cores novas aqui
			}
			
			pstm.close();
			
			c.commit();
			JOptionPane.showMessageDialog(null, "Decoracao alterada com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			// Tratamento de erros da alteracao de decoracao infantil
			if (e.getErrorCode() == 1722) JOptionPane.showMessageDialog(null, "Erro: Quantidade de baloes deve ser um dado numerico e nao negativo");
			else if (e.getErrorCode() == 1438) JOptionPane.showMessageDialog(null, "Erro: Quantidade de flores grande demais");
			else JOptionPane.showMessageDialog(null, "Erro ao inserir decoracao");
		}

	}
	
	/* Remove uma decoracao infantil */
	public static void remove(String tema) {
		Connection c = Conexao.getInstance();
		
		String sql = "delete from decoracaoinfantil where tema = ?"; // comando sql
		
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
