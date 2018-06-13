package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;

import decoracao.DecoracaoCasamento;
import festa.Festa;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TelaInicio extends JFrame {
	public TelaInicio() {
		tela();
		//TelaInicio m = new TelaIncio();
		//m.setSize(500, 500);
		//m.setVisible(true);
	}
	
	public void tela() {
		JButton btnCadastrarNovaFesta = new JButton("Cadastrar nova festa");
		btnCadastrarNovaFesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Festa festa = new Festa();
				festa.setVisible(true);
				//festa.close();
			}
		});
		
		JButton btnInserirNovaDecoracao = new JButton("Inserir nova decoracao");
		btnInserirNovaDecoracao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DecoracaoCasamento dec = new DecoracaoCasamento();
				//dec.metodozinho();
				//dec.close();
			}
		});
		
		JButton btnInserirNovaAtracao = new JButton("Inserir nova atracao");
		
		JButton btnCadastrarNovaEmpresa = new JButton("Cadastrar nova empresa");
		
		JButton btnRealizarConsulta = new JButton("Realizar consulta");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(101)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCadastrarNovaFesta, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
						.addComponent(btnInserirNovaDecoracao, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
						.addComponent(btnInserirNovaAtracao, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
						.addComponent(btnCadastrarNovaEmpresa, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
						.addComponent(btnRealizarConsulta, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
					.addGap(100))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(37)
					.addComponent(btnCadastrarNovaFesta)
					.addGap(18)
					.addComponent(btnInserirNovaDecoracao)
					.addGap(18)
					.addComponent(btnInserirNovaAtracao)
					.addGap(18)
					.addComponent(btnCadastrarNovaEmpresa)
					.addGap(18)
					.addComponent(btnRealizarConsulta)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
}
