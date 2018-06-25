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
 * Classe de operacoes SQL de DecoracaoCasamento
 */
public class DecoracaoCasamento {

	/* Insere uma decoracao casamento */
	public static void insert(String tema, String qtde, String[] tipos) {
		Connection c = Conexao.getInstance();
		
		String sql = "insert into decoracaocasamento(tema, qtde_flores) values(?, ?)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, tema);
			pstm.setString(2, qtde);
			
			pstm.execute(); //insere em decoracaocasamento
			
			sql = "insert into tiposflores(decoracao, tipo_flor) values(?, ?)"; 
			pstm = c.prepareStatement(sql);
			
			for (String string : tipos) {
				pstm.setString(1, tema);
				pstm.setString(2, string);
				
				pstm.execute(); //insere cada tipo de flor
			}
			
			pstm.close();

			c.commit(); //se deu tudo certo commita
			JOptionPane.showMessageDialog(null, "Decoracao de casamento inserida com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();	
			
			//caso tenha dado algum erro da um rollback
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			// Tratamento de erros de alteracao de decoracao Casamento
			if (e.getErrorCode() == 1) JOptionPane.showMessageDialog(null, "Erro: tema ja cadastrado");
			else if (e.getErrorCode() == 1400) JOptionPane.showMessageDialog(null, "Erro: Campo tema deve ser preenchido");
			else if (e.getErrorCode() == 1438) JOptionPane.showMessageDialog(null, "Erro: Quantidade de flores grande demais");
			else if (e.getErrorCode() == 1722) JOptionPane.showMessageDialog(null, "Erro: Quantidade de flores deve ser um dado numerico e nao negativo");
			else JOptionPane.showMessageDialog(null, "Erro ao inserir decoracao");
		}
	}
	
	// Realiza a selecao de uma decoracao de casamento pelo tema
	public static List<String> select(String tema) {
		Connection c = Conexao.getInstance();	
		String sql = "select * from decoracaocasamento where tema = (?)"; // comando SQL
		
		List<String> s = new ArrayList<String>();

		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, tema);
			
			ResultSet rs = pstm.executeQuery();
			while (rs.next()){
				s.add(rs.getString(2));
			}
			
			sql = "select * from tiposflores where decoracao = (?)"; // seleciona os tipos de flores
			pstm = c.prepareStatement(sql);
			pstm.setString(1, tema);
			
			rs = pstm.executeQuery();
			while (rs.next()){
				s.add(rs.getString(2));
			}
			
			pstm.close();
			c.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				c.rollback(); //caso tenha dado erro
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Erro ao procurar tipos de flores");
		}
		
		return s; //retorna uma lista com as colunas pedidas ou vazia caso nao tenha encontrado
	}
	
	
	/* Realiza a alteracao de uma decoracao casamento */
	public static void update(String[] form) {
		Connection c = Conexao.getInstance();
		
		String sql = "delete from tiposflores where decoracao = ?"; //apaga os tipos de flores pra inserir de novo
		
		try {
			
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, form[0]);
			pstm.execute();
			
			sql = "update decoracaocasamento set qtde_flores = ? where tema = ?"; // comando SQL de alteracao
			pstm = c.prepareStatement(sql);
			pstm.setString(1, form[1]);
			pstm.setString(2, form[0]);
			pstm.execute();
			
			sql = "insert into tiposflores(decoracao, tipo_flor) values(?, ?)"; // reinsere os tipos de flores
			pstm = c.prepareStatement(sql);
			pstm.setString(1, form[0]);
			
			for (int i = 2; i < form.length; i++) {
				pstm.setString(2, form[i]);
				pstm.execute();
			}
			
			pstm.close();

			c.commit(); //commita se deu certo
			JOptionPane.showMessageDialog(null, "Decoracao alterada com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				c.rollback(); //caso tenha dado erro
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			// Tratamento de erro para alteracao de decoracao casamento
			if (e.getErrorCode() == 1438) JOptionPane.showMessageDialog(null, "Erro: Quantidade de flores grande demais");
			else if (e.getErrorCode() == 1722) JOptionPane.showMessageDialog(null, "Erro: Quantidade de flores deve ser um dado numerico e nao negativo");
			else JOptionPane.showMessageDialog(null, "Erro ao alterar decoracao");
		}

	}
	
	/* Remocao de decoracao casamento */
	public static void remove(String tema) {
		Connection c = Conexao.getInstance();
		
		String sql = "delete from decoracaocasamento where tema = ?"; // comando SQL
		
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
