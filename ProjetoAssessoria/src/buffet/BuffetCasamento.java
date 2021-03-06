package buffet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class BuffetCasamento {
	
	/*cadastro de buffet de casamento no banco*/
	public static void insert(String s[]) {
		Connection c = Conexao.getInstance();
		
		
		try {
			/* Insere o tipo "casamento" na tabela de buffetcriterio" */
			String sql = "insert into buffetcriterio(buffet, tipo) values(?, 'casamento')";
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, s[0]);
			pstm.execute();
			/* Insere o Buffet */
			sql = "insert into buffetcasamento(CNPJ, nome, rua, numero, cep, capacidade) "
					+ "values(?, ?, ?, ?, ?, ?)";
			pstm = c.prepareStatement(sql);
			
			for (int i = 0; i < s.length; i++) {
				pstm.setString(i+1, s[i]);
			}
			
			pstm.execute();
			pstm.close();

			JOptionPane.showMessageDialog(null, "Buffet de casamento inserido com sucesso");
			
		} catch (SQLException e) { // tratamento de poss�veis erros
			e.printStackTrace();
			
			
			String sql = "delete buffetcriterio where buffet = ?";
			PreparedStatement pstm;
			try {
				pstm = c.prepareStatement(sql);
				pstm.setString(1, s[0]);
				pstm.execute();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			if (e.getErrorCode() == 1) JOptionPane.showMessageDialog(null, "Erro: CNPJ ja cadastrado");
			else if (e.getErrorCode() == 1722) JOptionPane.showMessageDialog(null, "Erro: Numero e capacidade devem ser dados numericos");
			else if (e.getErrorCode() == 2290) JOptionPane.showMessageDialog(null, "Erro: CNPJ e CEP devem estar formatados corretamente");
			else JOptionPane.showMessageDialog(null, "Erro ao inserir buffet");
		}
	}
	
	// select de todos os atributos de um determinado CNPJ (Chave prim�ria)
	public static String[] select(String cnpj) {
		Connection c = Conexao.getInstance();
		String[] s = null;
		
		try {
			String sql = "select * from buffetcasamento where CNPJ = ?";
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, cnpj);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				s = new String[6];
				for (int i = 0; i < 6; i++) {
					s[i] = rs.getString(i+1);
				}
			}
			
			pstm.close();

		} catch (SQLException e) { // tratamento de erros
			e.printStackTrace();
		
			JOptionPane.showMessageDialog(null, "Buffet nao encontradoo");
		}
		
		return s;
	}
	
	// realiza update pela chave prim�ria da tabela (CNPJ)
	public static void update(String s[]) {
		Connection c = Conexao.getInstance();
		
		
		try {
			String sql = "update buffetcasamento set nome = ?, rua = ?, numero = ?, cep = ?, capacidade = ?"
					+ " where cnpj = ?";
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(6, s[0]);
			
			for (int i = 1; i < s.length; i++) {
				pstm.setString(i, s[i]);
			}
			
			pstm.execute();
			pstm.close();

			JOptionPane.showMessageDialog(null, "Buffet de casamento alterado com sucesso");
			
		} catch (SQLException e) { // tratamento de erros
			e.printStackTrace();
			
			if (e.getErrorCode() == 1722) JOptionPane.showMessageDialog(null, "Erro: Numero e capacidade devem ser dados numericos");
			else if (e.getErrorCode() == 2290) JOptionPane.showMessageDialog(null, "Erro: CNPJ e CEP devem estar formatados corretamente");
			else JOptionPane.showMessageDialog(null, "Erro ao alterar buffet");
		}
	}
	
	
	// remove um unico buffet pela chave prim�ria da tabela (CNPJ)
	// note que a tabela buffetcasamento ja foi tratada para exclus�o de sua foreign key
	
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
