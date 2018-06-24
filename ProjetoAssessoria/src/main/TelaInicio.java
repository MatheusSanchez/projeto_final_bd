package main;

import java.awt.Container;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import contratante.TelaContratante;
import atracao.TelaAnimador;
import atracao.TelaBanda;
import buffet.TelaBuffetCasamento;
import buffet.TelaBuffetInfantil;
import decoracao.TelaDecoracaoCasamento;
import decoracao.TelaDecoracaoInfantil;
import festa.TelaFesta;

@SuppressWarnings("serial")
public class TelaInicio extends JFrame {
	private static Container container;

	public TelaInicio() {
		setLocation(new Point(600, 300));
		container = getContentPane();
	}

	public TelaInicio(Container c) {
		container = c;
	}

	public static void telaInicial() {
		
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

	public static void atualizaBanco() {
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

	public static void consultaBanco() {
		container.setLayout(null);
		
		JButton btnDecoracaoCasamento = new JButton("Decoracao Casamento");
		btnDecoracaoCasamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				new TelaConsulta(container, "Decoracao Casamento");
			}
		});
		btnDecoracaoCasamento.setBounds(161, 176, 198, 25);
		container.add(btnDecoracaoCasamento);
		
		JButton btnDecoracaoInfantil = new JButton("Decoracao Infantil");
		btnDecoracaoInfantil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				new TelaConsulta(container, "Decoracao Infantil");
			}
		});
		btnDecoracaoInfantil.setBounds(389, 176, 198, 25);
		container.add(btnDecoracaoInfantil);
		
		JButton btnFesta = new JButton("Festa");
		btnFesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				new TelaConsulta(container, "Festa");
			}
		});
		btnFesta.setBounds(161, 139, 198, 25);
		container.add(btnFesta);
		
		JButton btnContratante = new JButton("Contratante");
		btnContratante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				new TelaConsulta(container, "Contratante");
			}
		});
		btnContratante.setBounds(389, 139, 198, 25);
		container.add(btnContratante);
		
		JButton btnBanda = new JButton("Banda");
		btnBanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				new TelaConsulta(container, "Banda");
			}
		});
		btnBanda.setBounds(161, 213, 198, 25);
		container.add(btnBanda);
		
		JButton btnAnimador = new JButton("Animador");
		btnAnimador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				new TelaConsulta(container, "Animador");
			}
		});
		btnAnimador.setBounds(389, 213, 198, 25);
		container.add(btnAnimador);
		
		JButton btnBuffetCasamento = new JButton("Buffet Casamento");
		btnBuffetCasamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				new TelaConsulta(container, "Buffet Casamento");
			}
		});
		btnBuffetCasamento.setBounds(161, 250, 198, 25);
		container.add(btnBuffetCasamento);
		
		JButton btnBuffetInfantil = new JButton("Buffet Infantil");
		btnBuffetInfantil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				new TelaConsulta(container, "Buffet Infantil");
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
	
}
