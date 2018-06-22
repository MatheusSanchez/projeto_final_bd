package decoracao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class DecoracaoCasamento {
	public DecoracaoCasamento() {

	}

	public static boolean insert(String tema, String qtde) {
		Connection c = Conexao.getInstance();
		
		String sql = "insert into decoracaocasamento(tema, qtde_flores) values(?, ?)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, tema);
			pstm.setString(2, qtde);
			
			pstm.execute();
			pstm.close();

			JOptionPane.showMessageDialog(null, "Decoracao de casamento inserida com sucesso");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao inserir decoracao");
			return false;
		}
	}
	
	public static void insertTipo(String tema, String[] tipos) {
		Connection c = Conexao.getInstance();
		
		String sql = "insert into tiposflores(decoracao, tipo_flor) values(?, ?)";
		
		for (String string : tipos) {
			try {
				PreparedStatement pstm = c.prepareStatement(sql);
				pstm.setString(1, tema);
				pstm.setString(2, string);
				
				pstm.execute();
				pstm.close();
	
			} catch (Exception e) {
				e.printStackTrace();
			}
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
			
			pstm.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao procurar tema");
		}
		
		sql = "select * from tiposflores where decoracao = (?)";
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, tema);
			
			ResultSet rs = pstm.executeQuery();
			while (rs.next()){
				s.add(rs.getString(2));
			}
			
			pstm.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao procurar tipos de flores");
		}
		
		return s;
	}
	
	public static void update(String[] form) {
		Connection c = Conexao.getInstance();
		
		String sql = "delete from tiposflores where decoracao = ?";
		
		
		try {
			//Statement s = c.createStatement();
			//ResultSet rs = s.executeQuery("select * from decoracaocasamento where tema = 'classico'");
			//if (rs.next())
			//	System.out.println(rs.getString(1) + " / " + rs.getString(2));
			
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, form[0]);
			pstm.execute();
			
			//s = c.createStatement();
			//rs = s.executeQuery("select * from decoracaocasamento where tema = 'classico'");
			//if (rs.next())
			//	System.out.println(rs.getString(1) + " / " + rs.getString(2));
			//rs = s.executeQuery("select * from tiposflores where decoracao = 'classico'");
			//while (rs.next()) {
			//	System.out.println(rs.getString(1) + " / " + rs.getString(2));
			//}
			
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

			JOptionPane.showMessageDialog(null, "Decoracao alterada com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao alterar decoracao");
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

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao remover decoracao");
		}
	}
}
