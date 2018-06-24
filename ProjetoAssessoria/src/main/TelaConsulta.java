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

@SuppressWarnings("serial")
public class TelaConsulta extends JFrame {

	private Container container;

	public TelaConsulta(Container container, String tabela) {
		this.container = container;
		telaConsulta(tabela);
	}

	public void telaConsulta(String tabela) {
		container.setLayout(null);

		JTable table = new JTable() {

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

		JLabel lblTitle_1 = new JLabel("<html><h1>Cadastros de " + tabela
				+ "</h1></html>");
		lblTitle_1.setBounds(10, 25, 732, 42);
		container.add(lblTitle_1);

		final JScrollPane scrollPane = new JScrollPane(table);
		container.add(scrollPane);
		scrollPane.setBounds(10, 78, 732, 316);
		scrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);

		String s = "";

		Connection c = Conexao.getInstance();

		tabela = tabela.replaceAll(" ", "");
		tabela = tabela.toUpperCase();

		try {
			String sql = "select column_name from user_tab_columns where table_name = ?";
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, tabela);
			ResultSet rs = pstm.executeQuery();

			List<String> colunas = new ArrayList<String>();
			while (rs.next()) {
				colunas.add(rs.getString(1));
			}

			sql = "select * from " + tabela;
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

			TableModel model = new TableModel(colunas.toArray(new String[0]),
					resultado);
			table.setModel(model);

			// model.updateModel(objects);
			// editorPane.setText(s);

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

}