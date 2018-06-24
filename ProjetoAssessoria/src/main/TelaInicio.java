package main;

import java.awt.Container;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import atracao.TelaAnimador;
import atracao.TelaBanda;
import buffet.TelaBuffetCasamento;
import buffet.TelaBuffetInfantil;
import conexao.Conexao;
import contratante.TelaContratante;
import decoracao.TelaDecoracaoCasamento;
import decoracao.TelaDecoracaoInfantil;
import festa.TelaFesta;

@SuppressWarnings("serial")
public class TelaInicio extends JFrame {
	private Container container;

	public TelaInicio() {
		setLocation(new Point(600, 300));
		this.container = getContentPane();
	}

	public TelaInicio(Container c) {
		this.container = c;
	}

	public void telaInicial() {
		
		JButton btnAtualizar = new JButton("Atualizar Banco");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				atualizaBanco();
			}
		});
		
		JButton btnConsultar = new JButton("Consultar Banco");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.novaTela(container);
				consultaBanco();
			}
		});
		
		JButton btnGerar = new JButton("Gerar Relatorios");
		
		JLabel lblTitle = new JLabel("<html><h1>Assessoria de Eventos</h1></html>");
		lblTitle.setLocation(new Point(500, 300));
		GroupLayout groupLayout = new GroupLayout(container);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(241)
							.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(212)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnAtualizar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnConsultar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnGerar, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(212, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(78)
					.addComponent(lblTitle)
					.addGap(32)
					.addComponent(btnAtualizar)
					.addGap(18)
					.addComponent(btnConsultar)
					.addGap(18)
					.addComponent(btnGerar)
					.addContainerGap(177, Short.MAX_VALUE))
		);
		container.setLayout(groupLayout);
	}

	public void atualizaBanco() {
		container.setLayout(null);
		
		JButton btnDecoracaoCasamento = new JButton("Decoracao Casamento");
		btnDecoracaoCasamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				TelaDecoracaoCasamento t = new TelaDecoracaoCasamento(container);
				t.menuInicial();
			}
		});
		btnDecoracaoCasamento.setBounds(161, 176, 198, 25);
		container.add(btnDecoracaoCasamento);
		
		JButton btnDecoracaoInfantil = new JButton("Decoracao Infantil");
		btnDecoracaoInfantil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				TelaDecoracaoInfantil t = new TelaDecoracaoInfantil(container);
				t.menuInicial();
			}
		});
		btnDecoracaoInfantil.setBounds(389, 176, 198, 25);
		container.add(btnDecoracaoInfantil);
		
		JButton btnFesta = new JButton("Festa");
		btnFesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				TelaFesta t = new TelaFesta(container);
				t.menuInicial();
			}
		});
		btnFesta.setBounds(161, 139, 198, 25);
		container.add(btnFesta);
		
		JButton btnContratante = new JButton("Contratante");
		btnContratante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				TelaContratante t = new TelaContratante(container);
				t.menuInicial();
			}
		});
		btnContratante.setBounds(389, 139, 198, 25);
		container.add(btnContratante);
		
		JButton btnBanda = new JButton("Banda");
		btnBanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				TelaBanda t = new TelaBanda(container);
				t.menuInicial();
			}
		});
		btnBanda.setBounds(161, 213, 198, 25);
		container.add(btnBanda);
		
		JButton btnAnimador = new JButton("Animador");
		btnAnimador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				TelaAnimador t = new TelaAnimador(container);
				t.menuInicial();
			}
		});
		btnAnimador.setBounds(389, 213, 198, 25);
		container.add(btnAnimador);
		
		JButton btnBuffetCasamento = new JButton("Buffet Casamento");
		btnBuffetCasamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				TelaBuffetCasamento t = new TelaBuffetCasamento(container);
				t.menuInicial();
			}
		});
		btnBuffetCasamento.setBounds(161, 250, 198, 25);
		container.add(btnBuffetCasamento);
		
		JButton btnBuffetInfantil = new JButton("Buffet Infantil");
		btnBuffetInfantil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				TelaBuffetInfantil t = new TelaBuffetInfantil(container);
				t.menuInicial();
			}
		});
		btnBuffetInfantil.setBounds(389, 250, 198, 25);
		container.add(btnBuffetInfantil);
		
		JButton button = new JButton("<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				telaInicial();
			}
		});
		button.setBounds(12, 12, 44, 25);
		container.add(button);
	}

	public void consultaBanco() {
		container.setLayout(null);
		
		JButton btnDecoracaoCasamento = new JButton("Decoracao Casamento");
		btnDecoracaoCasamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				telaConsulta("Decoracao Casamento");
			}
		});
		btnDecoracaoCasamento.setBounds(161, 176, 198, 25);
		container.add(btnDecoracaoCasamento);
		
		JButton btnDecoracaoInfantil = new JButton("Decoracao Infantil");
		btnDecoracaoInfantil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				telaConsulta("Decoracao Infantil");
			}
		});
		btnDecoracaoInfantil.setBounds(389, 176, 198, 25);
		container.add(btnDecoracaoInfantil);
		
		JButton btnFesta = new JButton("Festa");
		btnFesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				telaConsulta("Festa");
			}
		});
		btnFesta.setBounds(161, 139, 198, 25);
		container.add(btnFesta);
		
		JButton btnContratante = new JButton("Contratante");
		btnContratante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				telaConsulta("Contratante");
			}
		});
		btnContratante.setBounds(389, 139, 198, 25);
		container.add(btnContratante);
		
		JButton btnBanda = new JButton("Banda");
		btnBanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				telaConsulta("Banda");
			}
		});
		btnBanda.setBounds(161, 213, 198, 25);
		container.add(btnBanda);
		
		JButton btnAnimador = new JButton("Animador");
		btnAnimador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				telaConsulta("Animador");
			}
		});
		btnAnimador.setBounds(389, 213, 198, 25);
		container.add(btnAnimador);
		
		JButton btnBuffetCasamento = new JButton("Buffet Casamento");
		btnBuffetCasamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				telaConsulta("Buffet Casamento");
			}
		});
		btnBuffetCasamento.setBounds(161, 250, 198, 25);
		container.add(btnBuffetCasamento);
		
		JButton btnBuffetInfantil = new JButton("Buffet Infantil");
		btnBuffetInfantil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				telaConsulta("Buffet Infantil");
			}
		});
		btnBuffetInfantil.setBounds(389, 250, 198, 25);
		container.add(btnBuffetInfantil);
		
		JButton button = new JButton("<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				telaInicial();
			}
		});
		button.setBounds(12, 12, 44, 25);
		container.add(button);
	}
	
	public void telaConsulta(String tabela) {
		getContentPane().setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(10, 114, 732, 316);
		getContentPane().add(editorPane);
		
		JLabel lblTitle_1 = new JLabel("<html><h1>Cadastros de " + tabela + "</h1></html>");
		lblTitle_1.setBounds(10, 25, 732, 42);
		getContentPane().add(lblTitle_1);
		
		JTextField lblColunas = new JTextField("");
		lblColunas.setBounds(10, 78, 732, 25);
		getContentPane().add(lblColunas);
		
		String s = "";
		
		Connection c = Conexao.getInstance();
		
		try {
			switch (tabela) {
				case "Decoracao Casamento":
					tabela = "DECORACAOCASAMENTO";
					break;
				case "Decoracao Infantil":
					tabela = "DECORACAOINFANTIL";
					break;
				case "Buffet Casamento":
					tabela = "BUFFETCASAMENTO";
					break;
				case "Buffet Infantil":
					tabela = "BUFFETINFANTIL";
					break;
				case "Contratante":
					tabela = "CONTRATANTE";
					break;
				case "Banda":
					tabela = "BANDA";
					break;
				case "Animador":
					tabela = "ANIMADOR";
					break;
				default:
					break;
			}
			
			String sql = "select column_name from user_tab_columns where table_name = ?";
			PreparedStatement pstm = c.prepareStatement(sql);
			pstm.setString(1, tabela);
			ResultSet rs = pstm.executeQuery();
			
			List<String> colunas = new ArrayList<String>();
			while (rs.next()) {
				colunas.add(rs.getString(1));
			}
			
			String aux = "";
			for (String string : colunas) {
				aux += string + "\t";
			}
			
			lblColunas.setText(aux);
			
			sql = "select * from " + tabela;
			pstm = c.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				for (String string : colunas) {
					s += rs.getString(string) + "\t";
				}
				s += "\n";
			}
			
			editorPane.setText(s);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JButton button = new JButton("<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				consultaBanco();
			}
		});
		button.setBounds(12, 12, 44, 25);
		container.add(button);
	}
}
