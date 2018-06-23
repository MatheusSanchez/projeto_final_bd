package decoracao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class DecoracaoCasamento {
	public DecoracaoCasamento() {

	}

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
			
			if (e.getErrorCode() == 1) JOptionPane.showMessageDialog(null, "Erro: tema ja cadastrado");
			else if (e.getErrorCode() == 1722) JOptionPane.showMessageDialog(null, "Erro: Quantidade de flores deve ser um dado numerico e nao negativo");
			else JOptionPane.showMessageDialog(null, "Erro ao inserir decoracao");
		}
	}
	
	public static List<String> select(String tema) {
		Connection c = Conexao.getInstance();	
		String sql = "select * from decoracaocasamento where tema = (?)";
		
		List<String> s = new ArrayList<String>();

		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, tema);
			
			ResultSet rs = pstm.executeQuery();
			while (rs.next()){
				s.add(rs.getString(2));
			}
			
			sql = "select * from tiposflores where decoracao = (?)";
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
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Erro ao procurar tipos de flores");
		}
		
		return s; //retorna uma lista com as colunas pedidas ou vazia caso nao tenha encontrado
	}
	
	public static void update(String[] form) {
		Connection c = Conexao.getInstance();
		
		String sql = "delete from tiposflores where decoracao = ?"; //apaga os tipos de flores pra inserir de novo
		
		try {
			
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, form[0]);
			pstm.execute();
			
			sql = "update decoracaocasamento set qtde_flores = ? where tema = ?";
			pstm = c.prepareStatement(sql);
			pstm.setString(1, form[1]);
			pstm.setString(2, form[0]);
			pstm.execute();
			
			sql = "insert into tiposflores(decoracao, tipo_flor) values(?, ?)";
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
			
			if (e.getErrorCode() == 1) JOptionPane.showMessageDialog(null, "Erro: tema ja cadastrado");
			else if (e.getErrorCode() == 1722) JOptionPane.showMessageDialog(null, "Erro: Quantidade de flores deve ser um dado numerico e nao negativo");
			else JOptionPane.showMessageDialog(null, "Erro ao alterar decoracao");
		}

	}
	
	public static void remove(String tema) {
		Connection c = Conexao.getInstance();
		
		String sql = "delete from decoracaocasamento where tema = ?";
		
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
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Erro ao remover decoracao");
		}
	}
}
