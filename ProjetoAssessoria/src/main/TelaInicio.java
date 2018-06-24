package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;

import festa.Festa;

@SuppressWarnings("serial")
public class TelaInicio extends JFrame {
	public TelaInicio() {
		telaInicial();
		//TelaInicio m = new TelaIncio();
		//m.setSize(500, 500);
		//m.setVisible(true);
	}
	
	public void telaInicial() {
		
		JButton btnAtualizar = new JButton("Atualizar Banco");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DecoracaoCasamento dec = new DecoracaoCasamento();
				//dec.metodozinho();
				//dec.close();
			}
		});
		
		JButton btnConsultar = new JButton("Consultar Banco");
		
		JButton btnGerar = new JButton("Gerar Relatorios");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
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
		getContentPane().setLayout(groupLayout);
	}
	
}
