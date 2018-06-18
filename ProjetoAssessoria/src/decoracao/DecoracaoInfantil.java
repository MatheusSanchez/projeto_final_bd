package decoracao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class DecoracaoInfantil {
	static public boolean insert(String tema, String qtdeBaloes, boolean pinata, String[] cores) {
		Connection c = Conexao.getInstance();
		
		System.out.println(tema + " " + qtdeBaloes + " " + pinata + " " + cores.length);
		for (int i = 0; i < cores.length; i++) {
			System.out.println(cores[i]);
		}
		
		String sql = "insert into decoracaoinfantil(tema, qtde_baloes, pinata) values(?, ?, ?)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, tema);
			pstm.setString(2, qtdeBaloes);
			pstm.setString(3, pinata? "1" : "0");
			pstm.execute();
			
			sql = "insert into corbaloes(decoracao, cor) values(?, ?)";
			pstm = c.prepareStatement(sql);
			pstm.setString(1, tema);
			for (int i = 0; i < cores.length; i++) {
				pstm.setString(2, cores[i]);
				pstm.execute();
			}
			
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
