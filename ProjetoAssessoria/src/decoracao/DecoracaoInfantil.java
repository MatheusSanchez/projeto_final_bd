package decoracao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class DecoracaoInfantil {
	static public Boolean insert(String tema, String qtdeBaloes, Boolean pinata) {
		Connection c = Conexao.getInstance();
		
		String sql = "insert into decoracaoinfantil(tema, qtde_baloes, pinata) values(?, ?, ?)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, tema);
			pstm.setString(2, qtdeBaloes);
			pstm.setString(3, pinata? "1" : "0");
			
			pstm.execute();
			pstm.close();

			JOptionPane.showMessageDialog(null, "Decoracao de aniversario infantil inserida com sucesso");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao inserir decoracao");
			return false;
		}
	}
}
