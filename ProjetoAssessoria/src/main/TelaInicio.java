package main;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;

import atracao.TelaAnimador;
import atracao.TelaBanda;
import buffet.TelaBuffetCasamento;
import buffet.TelaBuffetInfantil;
import contratante.TelaContratante;
import decoracao.TelaDecoracaoCasamento;
import decoracao.TelaDecoracaoInfantil;
import festa.TelaFesta;

@SuppressWarnings("serial")
public class TelaInicio extends JFrame {
	private Container container;

	public TelaInicio() {
		this.container = getContentPane();
		display();
	}

	public TelaInicio(Container c) {
		this.container = c;
		display();
	}

	public void display() {
		container.setLayout(null);
		
		JButton btnDecoracaoCasamento = new JButton("Decoracao Casamento");
		btnDecoracaoCasamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				TelaDecoracaoCasamento t = new TelaDecoracaoCasamento(container);
				t.menuInicial();
			}
		});
		btnDecoracaoCasamento.setBounds(12, 98, 198, 25);
		container.add(btnDecoracaoCasamento);
		
		JButton btnDecoracaoInfantil = new JButton("Decoracao Infantil");
		btnDecoracaoInfantil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				TelaDecoracaoInfantil t = new TelaDecoracaoInfantil(container);
				t.menuInicial();
			}
		});
		btnDecoracaoInfantil.setBounds(240, 98, 198, 25);
		container.add(btnDecoracaoInfantil);
		
		JButton btnFesta = new JButton("Festa");
		btnFesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				TelaFesta t = new TelaFesta(container);
				t.menuInicial();
			}
		});
		btnFesta.setBounds(12, 61, 198, 25);
		container.add(btnFesta);
		
		JButton btnContratante = new JButton("Contratante");
		btnContratante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				TelaContratante t = new TelaContratante(container);
				t.menuInicial();
			}
		});
		btnContratante.setBounds(240, 61, 198, 25);
		container.add(btnContratante);
		
		JButton btnBanda = new JButton("Banda");
		btnBanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				new TelaBanda();
			}
		});
		btnBanda.setBounds(12, 135, 198, 25);
		container.add(btnBanda);
		
		JButton btnAnimador = new JButton("Animador");
		btnAnimador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				new TelaAnimador();
			}
		});
		btnAnimador.setBounds(240, 135, 198, 25);
		container.add(btnAnimador);
		
		JButton btnBuffetCasamento = new JButton("Buffet Casamento");
		btnBuffetCasamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				new TelaBuffetCasamento();
			}
		});
		btnBuffetCasamento.setBounds(12, 172, 198, 25);
		container.add(btnBuffetCasamento);
		
		JButton btnBuffetInfantil = new JButton("Buffet Infantil");
		btnBuffetInfantil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				new TelaBuffetInfantil();
			}
		});
		btnBuffetInfantil.setBounds(240, 172, 198, 25);
		container.add(btnBuffetInfantil);
		//telaInicial();
		atualizaBanco();
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
		
		JButton btnGerar = new JButton("Gerar Relatorios");
		GroupLayout groupLayout = new GroupLayout(container);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(101)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAtualizar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
						.addComponent(btnConsultar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
						.addComponent(btnGerar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
					.addGap(100))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(80)
					.addComponent(btnAtualizar)
					.addGap(18)
					.addComponent(btnConsultar)
					.addGap(18)
					.addComponent(btnGerar)
					.addContainerGap(109, Short.MAX_VALUE))
		);
		container.setLayout(groupLayout);
	}

	public void atualizaBanco() {
		
	}
}
