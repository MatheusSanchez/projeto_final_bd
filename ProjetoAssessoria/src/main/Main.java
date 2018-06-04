package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;

import decoracao.Decoracao;
import festa.CadastroFesta;

public class Main extends JFrame {
	public Main() {
		System.out.println("aa");
		
		JButton btnCadastrarNovaFesta = new JButton("Cadastrar nova festa");
		btnCadastrarNovaFesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroFesta festa = new CadastroFesta();
				festa.setVisible(true);
				//festa.close();
			}
		});
		
		JButton btnInserirNovaDecoracao = new JButton("Inserir nova decoracao");
		btnInserirNovaDecoracao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Decoracao dec = new Decoracao();
				dec.metodozinho();
				//dec.close();
			}
		});
		
		JButton btnInserirNovaAtracao = new JButton("Inserir nova atracao");
		
		JButton btnCadastrarNovaEmpresa = new JButton("Cadastrar nova empresa");
		
		JButton btnRealizarConsulta = new JButton("Realizar consulta");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(89, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnRealizarConsulta, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCadastrarNovaEmpresa, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCadastrarNovaFesta, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnInserirNovaDecoracao, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
						.addComponent(btnInserirNovaAtracao, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(128))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addComponent(btnCadastrarNovaFesta)
					.addGap(18)
					.addComponent(btnInserirNovaDecoracao)
					.addGap(18)
					.addComponent(btnInserirNovaAtracao)
					.addGap(18)
					.addComponent(btnCadastrarNovaEmpresa)
					.addGap(18)
					.addComponent(btnRealizarConsulta)
					.addContainerGap(62, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		m.setSize(500, 500);
		m.setVisible(true);
	}
}