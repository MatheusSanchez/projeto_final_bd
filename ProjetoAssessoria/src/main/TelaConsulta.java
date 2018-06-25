package main;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import conexao.Conexao;

/*
 * Janela que apresenta o resultado de uma consulta
 * 
 */

@SuppressWarnings("serial")
public class TelaConsulta extends JFrame {

	private JTable table;
	private Container container;

	/* Construtor que faz uma consulta que seleciona todos os registros da tabela (tabela) */
	public TelaConsulta(Container container, String tabela) {
		this.container = container;
		telaConsulta(tabela, null, null, null);
	}

	/* Construtor que faz a consulta de titulo (consulta) com o comando SQL sqlConsulta e com nomes de coluna (nomeColunas) */
	public TelaConsulta(Container container, String tabela, String consulta, String sqlConsulta, String[] nomeColunas) {
		this.container = container;
		telaConsulta(tabela, consulta, sqlConsulta, nomeColunas);
	}

	
	// realiza e apresenta a consulta
	public void telaConsulta(String tabela, String nomeConsulta, String sqlConsulta, String[] nomeColunas) {
		container.setLayout(null);

		// cria a tabela que apresenta as consultas
		table = new JTable() {

			public String getToolTipText(MouseEvent e) {
				String tip = null;
				java.awt.Point p = e.getPoint();
				int rowIndex = rowAtPoint(p);
				int colIndex = columnAtPoint(p);

				try {
					tip = getValueAt(rowIndex, colIndex).toString();
				} catch (RuntimeException e1) {

				}

				return tip;
			}
		};
		table.setBounds(10, 78, 732, 316);

		container.add(table);
		final JScrollPane scrollPane = new JScrollPane(table);
		container.add(scrollPane);
		scrollPane.setBounds(10, 78, 732, 316);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
		
		if (nomeConsulta != null) {
			realizarConsulta(nomeConsulta, sqlConsulta, nomeColunas);
			return;
		}

		// apresenta o titulo da consulta
		JLabel lblTitle_1 = new JLabel("<html><h1>Cadastros de " + tabela + "</h1></html>");
		lblTitle_1.setBounds(10, 25, 732, 42);
		container.add(lblTitle_1);


		String s = "";

		Connection c = Conexao.getInstance();

		// formata a string do nome da tabela para ser o nome real da tabela registrado no banco
		if (tabela != null) {
			tabela = tabela.replaceAll(" ", "");
			tabela = tabela.toUpperCase();
		}

		// Realiza a consulta de todos os registros da tabela (tabela)
		try {
			String sql = "select column_name from user_tab_columns where table_name = ?"; // comando sql que pega os nomes das colunas da tabela
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, tabela);
			ResultSet rs = pstm.executeQuery();

			List<String> colunas = new ArrayList<String>();
			while (rs.next()) {
				colunas.add(rs.getString(1));
			}

			sql = "select * from " + tabela; // comando sql que pega todos os registros da tabela tabela
			pstm = c.prepareStatement(sql);
			rs = pstm.executeQuery();
			List<String> resultado = new ArrayList<String>();
			while (rs.next()) {

				for (String string : colunas) {
					s += rs.getString(string) + "\n";
				}
				resultado.add(s);
				s = "";
			}

			TableModel model = new TableModel(colunas.toArray(new String[0]), resultado); 
			table.setModel(model); // apresenta na tabela

		} catch (SQLException e) {
			e.printStackTrace();
		}

		JButton button = new JButton("<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				TelaInicio.consultaBanco();
			}
		});
		button.setBounds(12, 12, 44, 25);
		container.add(button);
	}

	/* Realiza a consulta de nome (nomeConsulta) com o comando SQL (sqlConsulta)*/
	private void realizarConsulta(String nomeConsulta, String sqlConsulta, String[] nomeColunas) {
		
		JLabel lblTitle_1 = new JLabel("<html><h2>"+ nomeConsulta + "</h2></html>");
		lblTitle_1.setBounds(10, 25, 732, 42);
		container.add(lblTitle_1);
		String s = "";

		Connection c = Conexao.getInstance();


		try {
			PreparedStatement pstm = c.prepareStatement(sqlConsulta); // realiza a consulta
			ResultSet rs = pstm.executeQuery();

			List<String> resultado = new ArrayList<String>();
			while (rs.next()) {

				for (String string : nomeColunas) {
					s += rs.getString(string) + "\n";
				}
				resultado.add(s);
				s = "";
			}

			TableModel model = new TableModel(nomeColunas, resultado);
			table.setModel(model); // apresenta o resultado

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
