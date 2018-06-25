package festa;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import conexao.Conexao;

@SuppressWarnings("serial")
public class Festa extends JFrame {
	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();

	/* Funcao que cria um numero de contrato aleatorio unico */
	public static String randomString( int len ){
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}
	
	/* Insere uma festa */
	public static void insert(double preco, String data, String tipo, String contratante, String buffet, String decoracao, String atracao, String[] convidados) {
		Connection c = Conexao.getInstance();
		
		String numeroContrato = randomString(25); // cria um numero de contrato unico
		
		String sql = "insert into festa(nro_contrato, pdf_contrato, preco, data, tipo, contratante)"
				+ " values(?, ?, ?, ?, ?, ?)";
		
		
		// Transforma a string data passada para o tipo Date
		DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date dataa;
		try {
			dataa = new java.sql.Date(fmt.parse(data).getTime());
		} catch (ParseException e2) {
			dataa = null;
			e2.printStackTrace();
		}
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1,  numeroContrato);
			pstm.setString(2,  "NULL");
			pstm.setDouble(3,  preco);
			pstm.setDate(4,  dataa);
			pstm.setString(5,  tipo);
			pstm.setString(6,  contratante);
			pstm.execute();
			
			insereTabelasExternas(numeroContrato, preco, dataa, tipo, contratante, buffet, decoracao, atracao, convidados);
			
			// Insere a o casamento se a festa for casamento ou no aniversario infantil se a festa for um aniversario infantl
			if(tipo.equals("Casamento")) {
				sql = "insert into casamento(nro_contrato, decoracao) values (?, ?)";
			} else {
				sql = "insert into aniversarioinfantil(nro_contrato, decoracao) values (?, ?)";
			}
			
			pstm = c.prepareStatement(sql);
			pstm.setString(1, numeroContrato);
			pstm.setString(2, decoracao);
			pstm.execute();
			
			// Insere o buffet
			if(tipo.equals("Casamento")) {
				sql = "insert into contratobuffetcasamento(data, buffet_casamento, casamento) values(?, ?, ?)";
			} else {
				sql = "insert into contratobuffetinfantil(data, buffet_infantil, aniversario_infantil) values(?, ?, ?)";
			}
			pstm = c.prepareStatement(sql);
			pstm.setDate(1, dataa);
			pstm.setString(2, buffet);
			pstm.setString(3, numeroContrato);			
			pstm.execute();
			
			// Insere a atracao
			if(tipo.equals("Casamento")) {
				sql = "insert into contratobanda(data, banda, casamento) values(?, ?, ?)";
			} else {
				sql = "insert into contratoanimador(data, animador, aniversario_infantil) values(?, ?, ?)";
			}
			
			pstm = c.prepareStatement(sql);
			pstm.setDate(1, dataa);
			pstm.setString(2, atracao);
			pstm.setString(3, numeroContrato);			
			pstm.execute();
			
			c.commit();
			JOptionPane.showMessageDialog(null, "Festa inserida com sucesso");
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
	
	/* Insere tuplas em tabelas de atributos multivalorados que referenciam festa (convidadosfesta) */
	public static void insereTabelasExternas(String numeroContrato, double preco, Date dataa, String tipo, String contratante, String buffet, String decoracao, String atracao, String[] convidados) throws SQLException {
		Connection c = Conexao.getInstance();
		
		// Insere os convidados
		String sql = "insert into convidadosfesta(festa, nome) values (?, ?)";
		PreparedStatement pstm = c.prepareStatement(sql);
		
		pstm.setString(1, numeroContrato);
		for(int i = 0; i < convidados.length; ++i) {
			pstm.setString(2, convidados[i]);
			System.out.println(convidados[i]);
			pstm.execute();
		}
		
	}
	
	/* Seleciona atributos de festa */
	public static String[] select(String numeroContrato) {
		Connection c = Conexao.getInstance();	
		
		String[] s = new String[7]; // resultado do select

		try {
			String sql = "select preco, data, tipo, contratante from festa where nro_contrato = (?)"; // comando SQL
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, numeroContrato);
			
			ResultSet rs = pstm.executeQuery();
			
			if(!rs.next()) return s;
			for(int i = 0; i < 4; ++i)
				s[i] = rs.getString(i+1);

			// Pega a decoracao
	
			// se o tipo for casamento
			if(s[2].equals("Casamento")) {
				System.out.println("entrei no if");
				sql = "select decoracao from Casamento where nro_contrato = ?"; // comando SQL
			} else {
				sql = "select decoracao from AniversarioInfantil where nro_contrato = ?"; // comando SQL
			}
			
			pstm = c.prepareStatement(sql);
			pstm.setString(1, numeroContrato);
			
			rs = pstm.executeQuery();
			while (rs.next()){
				System.out.println("Feito o 1");
				s[5] = rs.getString(1);
			}
			
			// Pega o buffet
			
			// se o tipo for casamento
			if(s[2].equals("Casamento")){
				sql = "select buffet_casamento from contratobuffetcasamento where casamento = ?"; // comando SQL
			} else {
				sql = "select buffet_infantil from contratobuffetinfantil where aniversario_infantil = ?"; // comando SQL
			}
			
			pstm = c.prepareStatement(sql);
			pstm.setString(1, numeroContrato);
			
			rs = pstm.executeQuery();
			while (rs.next()){
				s[4] = rs.getString(1);
			}
			
			// Pega a atracao	
			
			// se o tipo for casamento
			if(s[2].equals("Casamento")) {
				sql = "select banda from contratobanda where casamento = ?"; // comando SQL
			} else {
				sql = "select animador from contratoanimador where aniversario_infantil = ?"; // comando SQL
			}
			
			pstm = c.prepareStatement(sql);
			pstm.setString(1, numeroContrato);
			
			rs = pstm.executeQuery();
			while (rs.next()){
				s[6] = rs.getString(1);
			}
			
			pstm.close();
			c.commit(); // faz o commit das alteracoes

		} catch (Exception e) {
			s = null;
			e.printStackTrace();
			try {
				c.rollback(); // faz o rollback das alteracoes
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Erro ao procurar festa");
		}
		
		return s;
	}
	
	/* Seleciona os convidados da festa com numero de contrato numeroContrato */
	public static ArrayList<String> selectConvidados(String numeroContrato) {
		Connection c = Conexao.getInstance();	

		
		ArrayList<String> s = new ArrayList<String>(); // resultado do select

		try {
			String sql = "select nome from convidadosfesta where festa = ?"; // comando SQL
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, numeroContrato);
			
			ResultSet rs = pstm.executeQuery();
			while (rs.next()){
				s.add(rs.getString(1)); //adiciona telefonel
			}
			pstm.close();
			c.commit(); // faz o commit das alteracoes
			
		} catch (Exception e) {
			try {
				c.rollback(); // faz o rollback das alteracoes
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Erro ao procurar banda");
		}
		
		return s;
	}
	
	/* Faz o update da festa com numero de contrato = numeroContrato */
	public static void update(String numeroContrato, double preco, String data, String tipo, String contratante, String buffet, String decoracao, String atracao, String[] convidados) {
		Connection c = Conexao.getInstance();
		
		// Transforma a string data passada para o tipo Date
		DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date dataa;
		try {
			dataa = new java.sql.Date(fmt.parse(data).getTime());
		} catch (ParseException e2) {
			dataa = null;
			e2.printStackTrace();
		}
		
		try {
			String sql = "delete from convidadosfesta where festa = ?"; // deleta todos os convidados da festa a ser atualizada
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, numeroContrato);
			pstm.execute();
			
			sql = "update festa set preco = ?, data = ?, tipo = ?, contratante = ? where nro_contrato = ?"; // atualiza a festa
			pstm = c.prepareStatement(sql);
			pstm.setDouble(1, preco);
			pstm.setDate(2, dataa);//to_date('" + data + "', 'DD/MM/YYYY')");
			pstm.setString(3, tipo);
			pstm.setString(4, contratante);
			pstm.setString(5, numeroContrato);
			pstm.execute();
			
			// altera decoracao
			if(tipo.equals("Casamento")) {
				sql = "update casamento set decoracao = ? where nro_contrato = ?";
			} else {
				sql = "update aniversarioinfantil set decoracao = ? where nro_contrato = ?";
			}
			pstm = c.prepareStatement(sql);
			pstm.setString(1, decoracao);
			pstm.setString(2, numeroContrato);
			pstm.execute();
			
			// altera casamento
			if(tipo.equals("Casamento")) {
				sql = "update contratobuffetcasamento set data = ?, buffet_casamento = ? where casamento = ?";
			} else {
				sql = "update aniversarioinfantil set data = ?, buffet_infantil = ? where aniversario_infantil = ?";
			}
			pstm = c.prepareStatement(sql);
			pstm.setDate(1, dataa);
			pstm.setString(2, buffet);
			pstm.setString(3, numeroContrato);
			pstm.execute();

			
			// Altera atracao
			if(tipo.equals("Casamento")) {
				sql = "update contratobanda set data = ?, banda = ? where casamento = ?";
			} else {
				sql = "update contratoanimador set data = ?, animador = ? where aniversario_infantil = ?";
			}
			
			pstm = c.prepareStatement(sql);
			pstm.setDate(1, dataa);
			pstm.setString(2, atracao);
			pstm.setString(3, numeroContrato);
			pstm.execute();
			
			insereTabelasExternas(numeroContrato, preco, dataa, tipo, contratante, buffet, decoracao, atracao, convidados);
			
			pstm.close();
			c.commit();
			JOptionPane.showMessageDialog(null, "Festa alterada com sucesso");
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			
			// Mensagens de erro de insercao de festa
			if (e.getErrorCode() == 1) JOptionPane.showMessageDialog(null, "Erro: Numero de contrato da festa ja cadastrado");
			else if (e.getErrorCode() == 1722) JOptionPane.showMessageDialog(null, "Erro: Preco deve ser um dado numerico");
			else if (e.getErrorCode() == 2290) JOptionPane.showMessageDialog(null, "Erro: Os campos de preco, data ou tipo da festa nao foram inseridos corretamente");
			else JOptionPane.showMessageDialog(null, "Erro ao atualizar festa");
		}
	}
	
}
