package festa;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import conexao.Conexao;








@SuppressWarnings("serial")
public class Festa extends JFrame {
	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();

	public static String randomString( int len ){
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}
	
	public Festa() {
				
	}
	
	public static void insert(double preco, String data, String tipo, String contratante, String buffet, String decoracao, String atracao, String[] convidados) {
		Connection c = Conexao.getInstance();
		
		// Pega o maior valor de nro_contrato
		
		String numeroContrato = randomString(25);
		
		String sql = "insert into festa(nro_contrato, pdf_contrato, preco, data, tipo, contratante)"
				+ " values(?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1,  numeroContrato);
			pstm.setString(2,  "NULL");
			pstm.setString(3,  Double.toString(preco));
			pstm.setString(4,  "to_date(" + data + ", DD/MM/YYYY)");
			pstm.setString(5,  tipo);
			pstm.setString(6,  contratante);
			pstm.execute();
			pstm.close();
			
			
			// Insere os convidados
			sql = "insert into convidadosfesta(festa, nome) values (?, ?);";
			pstm = c.prepareStatement(sql);
			
			pstm.setString(1, numeroContrato);
			for(int i = 0; i < convidados.length; ++i) {
				pstm.setString(2, convidados[i]);
				pstm.execute();
			}
			
			// Insere o buffet
			if(tipo == "Casamento") {
				sql = "insert into contratobuffetcasamento(data, buffet_casamento, casamento) values(?, ?, ?)";
			} else {
				sql = "insert into contratobuffetinfantil(data, buffet_infantil, aniversario_infantil) values(?, ?, ?)";
			}
			pstm = c.prepareStatement(sql);
			pstm.setString(1, "to_date(" + data + ", DD/MM/YYYY)");
			pstm.setString(2, buffet);
			pstm.setString(3, numeroContrato);			
			pstm.execute();
			
			// Insere a atracao
			if(tipo == "Casamento") {
				sql = "insert into contratobanda(data, banda, casamento) values(?, ?, ?)";
			} else {
				sql = "insert into contratoanimador(data, animador, aniversario_infantil) values(?, ?, ?)";
			}
			
			pstm = c.prepareStatement(sql);
			pstm.setString(1, "to_date(" + data + ", DD/MM/YYYY)");
			pstm.setString(2, atracao);
			pstm.setString(3, numeroContrato);			
			pstm.execute();
			
			c.commit();
			
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			
			// Mensagens de erro de insercao de festa
			if (e.getErrorCode() == 1) JOptionPane.showMessageDialog(null, "Erro: Numero de contrato da festa ja cadastrado");
			else if (e.getErrorCode() == 1722) JOptionPane.showMessageDialog(null, "Erro: Preco deve ser um dado numerico");
			else if (e.getErrorCode() == 2290) JOptionPane.showMessageDialog(null, "Erro: Os campos de preco, data ou tipo da festa nao foram inseridos corretamente");
			else JOptionPane.showMessageDialog(null, "Erro ao inserir festa");
		}
	}
	
}
