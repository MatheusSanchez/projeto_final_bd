package buffet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class BuffetCasamento {
	public static void insert(String s[]) {
		Connection c = Conexao.getInstance();
		
		
		try {
			String sql = "insert into buffetcriterio(buffet, tipo) values(?, 'casamento')";
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, s[0]);
			pstm.execute();
			
			sql = "insert into buffetcasamento(CNPJ, nome, rua, numero, cep, capacidade) "
					+ "values(?, ?, ?, ?, ?, ?)";
			pstm = c.prepareStatement(sql);
			
			for (int i = 0; i < s.length; i++) {
				pstm.setString(i+1, s[i]);
			}
			
			pstm.execute();
			pstm.close();

			JOptionPane.showMessageDialog(null, "Buffet de casamento inserido com sucesso");
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
}
