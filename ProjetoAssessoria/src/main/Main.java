package main;


import atracao.TelaAnimador;
import atracao.TelaBanda;
import conexao.Conexao;

public class Main {

	public static void main(String[] args) {
		Conexao.getInstance(); // pede os dados da conexao antes de rodar


		// TelaContratante c = new TelaContratante();
		// TelaDecoracaoCasamento c = new TelaDecoracaoCasamento();
		//TelaDecoracaoInfantil c = new TelaDecoracaoInfantil();
		// TelaBuffetCasamento c = new TelaBuffetCasamento();
		//TelaBuffetInfantil c = new TelaBuffetInfantil();
		//TelaBanda c = new TelaBanda();
		//c.setSize(768, 480);
		//c.setVisible(true);
		
		/*
		 * Para descobrir qual a versao do oracle: (versao 11)
		Connection con = Conexao.getInstance();
		
		String sql = "SELECT * FROM V$VERSION";
		PreparedStatement pstm;
		try {
			pstm = con.prepareStatement(sql);
			ResultSet rs;
			rs = pstm.executeQuery();
			while (rs.next()) {
				for(int i = 0; i < rs.getMetaData().getColumnCount(); ++i) {
					System.out.println(rs.getString(i+1));
				}
			}
			pstm.execute();
			pstm.close();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		
		
		
	
	}
}