package buffet;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class BuffetCasamento {
	public static void insert(String s[]) {
		Connection c = Conexao.getInstance();
		
		String sql = "insert into buffetcasamento(CNPJ, nome, rua, numero, cep, capacidade) "
						+ "values(?, ?, ?, ?, ?, ?);";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			for (int i = 0; i < s.length; i++) {
				pstm.setString(i+1, s[i]);
			}
			
			pstm.execute();
			pstm.close();

			JOptionPane.showMessageDialog(null, "Buffet de casamento inserida com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao inserir buffet");
		}
	}
}
