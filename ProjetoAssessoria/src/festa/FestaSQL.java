package festa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.swing.JFrame;

import conexao.Conexao;

public class FestaSQL extends JFrame {
	public FestaSQL() {
				
	}
	
	public void insert(String contrato, String pdf, Double preco, String inicio, String fim, String tipo, String contratante) {
		Connection c = Conexao.getInstance();
		
		String sql = "insert into festa(nro_contrato, pdf_contrato, preco, inicio, fim, tipo, contratante)"
				+ " values(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1,  contrato);
			pstm.setString(2,  pdf);
			pstm.setString(3,  preco.toString());
			pstm.setString(4,  inicio);
			pstm.setString(5,  fim);
			pstm.setString(6,  tipo);
			pstm.setString(7,  contratante);
			pstm.execute();
			pstm.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
