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
import oracle.jrockit.jfr.JFR;

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
		btnGerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				geraRelatorios();
			}
		});

		JLabel lblTitle = new JLabel("<html><h1>Assessoria de Eventos</h1></html>");
		lblTitle.setLocation(new Point(500, 300));
		GroupLayout groupLayout = new GroupLayout(container);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(241).addComponent(lblTitle,
										GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(212)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(btnAtualizar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnConsultar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnGerar, Alignment.LEADING, GroupLayout.PREFERRED_SIZE,
														329, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(212, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				groupLayout.createSequentialGroup().addGap(78).addComponent(lblTitle).addGap(32)
						.addComponent(btnAtualizar).addGap(18).addComponent(btnConsultar).addGap(18)
						.addComponent(btnGerar).addContainerGap(177, Short.MAX_VALUE)));
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

	private static void geraRelatorios() {
		container.setLayout(null);

		JButton btnConsulta = new JButton("Media de preco da festa por cep do contratante");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consulta1();
			}
		});
		btnConsulta.setBounds(69, 115, 598, 23);
		container.add(btnConsulta);

		JButton btnConsulta2 = new JButton("Listar festa, contratante, decoracao, buffet e atracao");
		btnConsulta2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consulta2();
			}
		});
		btnConsulta2.setBounds(69, 149, 598, 23);
		container.add(btnConsulta2);

		JButton btnConsulta3 = new JButton(
				"Para todas com as festas com mais de 100 convidados, selecionar contratante, nro_contrato e nro_convidados");
		btnConsulta3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consulta3();
			}
		});
		btnConsulta3.setBounds(69, 183, 598, 23);
		container.add(btnConsulta3);

		JButton btnConsulta_1 = new JButton("Encontrar banda mais popular");
		btnConsulta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consulta4();
			}
		});
		btnConsulta_1.setBounds(69, 217, 598, 23);
		container.add(btnConsulta_1);

		JButton btnConsulta_2 = new JButton("Encontrar animador mais popular");
		btnConsulta_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consulta5();
			}
		});
		btnConsulta_2.setBounds(69, 251, 598, 23);
		container.add(btnConsulta_2);

		JButton btnConsulta_3 = new JButton("Encontrar buffet mais popular");
		btnConsulta_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consulta6();
			}
		});
		btnConsulta_3.setBounds(69, 285, 598, 23);
		container.add(btnConsulta_3);

		JButton button = new JButton("<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				telaInicial();
			}
		});
		button.setBounds(12, 12, 44, 25);
		container.add(button);

		JLabel lblRelatorios = new JLabel("<html><h1>Relatorios</h1></html>");
		lblRelatorios.setBounds(69, 55, 598, 32);
		container.add(lblRelatorios);
	}

	private static void consulta1() {
		String[] col = new String[2];
		col[0] = "CEP";
		col[1] = "media_preco";
		JFrame f = new JFrame("aaa");
		Main.novaJanela(f);
		new TelaConsulta(f.getContentPane(), null, "Media de preco da festa por cep do contratante",
				"select c.cep, avg(preco)as media_preco\r\n" + "	from festa f\r\n" + "	join contratante c\r\n"
						+ "	on f.contratante = c.cpf\r\n" + "	group by c.cep\r\n" + "	order by c.cep",
				col);
	}

	private static void consulta2() {
		String[] col = new String[5];
		col[0] = "nro_contrato";
		col[1] = "contratante";
		col[2] = "decoracao";
		col[3] = "buffet";
		col[4] = "animador_banda";
		JFrame f = new JFrame("aaa");
		Main.novaJanela(f);
		
		String s = "select * from\r\n" + 
				"	(select f.nro_contrato, ct.nome as contratante, c.decoracao, t.nome as buffet, bb.banda as animador_banda\r\n" + 
				"		from casamento c\r\n" + 
				"		join festa f\r\n" + 
				"		on f.nro_contrato = c.nro_contrato\r\n" + 
				"		left join contratante ct \r\n" + 
				"		on ct.cpf = f.contratante\r\n" + 
				"		left join (select * from contratobuffetcasamento cb join buffetcasamento b on b.cnpj = cb.buffet_casamento) t\r\n" + 
				"		on t.casamento = c.nro_contrato\r\n" + 
				"		left join contratobanda bb \r\n" + 
				"		on bb.casamento = c.nro_contrato)\r\n" + 
				"\r\n" + 
				"union\r\n" + 
				"\r\n" + 
				"	(select f.nro_contrato, ct.nome as contratante, c.decoracao, t.nome as buffet, bb.animador as animador_banda\r\n" + 
				"		from aniversarioinfantil c\r\n" + 
				"		join festa f\r\n" + 
				"		on f.nro_contrato = c.nro_contrato\r\n" + 
				"		left join contratante ct \r\n" + 
				"		on ct.cpf = f.contratante\r\n" + 
				"		left join (select * from contratobuffetinfantil cb join buffetinfantil b on b.cnpj = cb.buffet_infantil) t\r\n" + 
				"		on t.aniversario_infantil = c.nro_contrato\r\n" + 
				"		left join contratoanimador bb \r\n" + 
				"		on bb.aniversario_infantil = c.nro_contrato)";
		
		new TelaConsulta(f.getContentPane(), null, "Listar festa, contratante, decoracao, buffet e atracao", s, col);
	}
	
	private static void consulta3() {
		String[] col = new String[4];
		col[0] = "nro_contrato";
		col[1] = "contratante";
		col[2] = "nro_convidados";
		col[3] = "preco";
		JFrame f = new JFrame("aaa");
		Main.novaJanela(f);
		
		String s = "select f.nro_contrato, c.nome, count(*) as numero_de_convidados, f.preco\r\n" + 
				"	from festa f\r\n" + 
				"	left join contratante c\r\n" + 
				"	on f.contratante = c.cpf\r\n" + 
				"	join convidadosfesta cf\r\n" + 
				"	on cf.festa = f.nro_contrato\r\n" + 
				"	group by f.nro_contrato, c.nome, f.preco\r\n" + 
				"		having count(*) > 100\r\n" + 
				"	order by f.preco";
		
		new TelaConsulta(f.getContentPane(), null, "Para todas com as festas com mais de 100 convidados, selecionar contratante, nro_contrato e nro_convidados", s, col);
	}
	
	private static void consulta4() {
		String[] col = new String[2];
		col[0] = "nome";
		col[1] = "vezes";
		JFrame f = new JFrame("aaa");
		Main.novaJanela(f);
		String s = "\r\n" + 
				"select b.nome, count(*) as vezes\r\n" + 
				"    from casamento c\r\n" + 
				"	join contratobanda cb\r\n" + 
				"	on cb.casamento = c.nro_contrato\r\n" + 
				"	join banda b\r\n" + 
				"	on cb.banda = b.nome\r\n" + 
				"	group by b.nome\r\n" + 
				"	    having count (*) = (select max(count(*)) from casamento c join contratobanda cb on cb.casamento = c.nro_contrato join banda b on cb.banda = b.nome group by b.nome)";
	
		new TelaConsulta(f.getContentPane(), null, "Encontrar banda mais popular", s, col);
	}

	private static void consulta5() {
		String[] col = new String[2];
		col[0] = "nome";
		col[1] = "vezes";
		JFrame f = new JFrame("aaa");
		Main.novaJanela(f);
		String s = "select a.nome, count(*) as vezes\r\n"
				+ "    from aniversarioinfantil ai\r\n" + "	join contratoanimador ca\r\n"
				+ "	on ca.aniversario_infantil = ai.nro_contrato\r\n" + "	join animador a\r\n"
				+ "	on ca.animador = a.nome\r\n" + "	group by a.nome\r\n"
				+ "	    having count (*) = (select max(count(*)) from aniversarioinfantil ai join contratoanimador ca on ca.aniversario_infantil = ai.nro_contrato join animador a on ca.animador = a.nome group by a.nome)";
		new TelaConsulta(f.getContentPane(), null, "Encontrar animador mais popular", s, col);
	}
	
	private static void consulta6() {
		String[] col = new String[2];
		col[0] = "nome";
		col[1] = "vezes";
		JFrame f = new JFrame("aaa");
		Main.novaJanela(f);
		String s = "select * from\r\n" + 
				"	(\r\n" + 
				"		select bc.nome, count(*) as vezes\r\n" + 
				"		from casamento c\r\n" + 
				"		join contratobuffetcasamento cbc\r\n" + 
				"		on cbc.casamento = c.nro_contrato\r\n" + 
				"		join buffetcasamento bc\r\n" + 
				"		on cbc.buffet_casamento = bc.cnpj\r\n" + 
				"		group by bc.nome, bc.cnpj\r\n" + 
				"			having count(*) = (\r\n" + 
				"				select max(vezes) from (\r\n" + 
				"					select max(count(*)) as vezes from aniversarioinfantil ai join contratobuffetinfantil cbi on cbi.aniversario_infantil = ai.nro_contrato join buffetinfantil bi on bi.cnpj = cbi.buffet_infantil group by bi.cnpj\r\n" + 
				"				UNION\r\n" + 
				"					select max(count(*)) as vezes from casamento c join contratobuffetcasamento cbc on cbc.casamento = c.nro_contrato join buffetcasamento bc on cbc.buffet_casamento = bc.cnpj group by bc.cnpj\r\n" + 
				"				)\r\n" + 
				"			)\r\n" + 
				"	)\r\n" + 
				"UNION\r\n" + 
				"	(\r\n" + 
				"		select bi.nome, count(*) as vezes\r\n" + 
				"		from aniversarioinfantil ai\r\n" + 
				"		join contratobuffetinfantil cbi\r\n" + 
				"		on cbi.aniversario_infantil = ai.nro_contrato\r\n" + 
				"		join buffetinfantil bi\r\n" + 
				"		on cbi.buffet_infantil = bi.cnpj\r\n" + 
				"		group by bi.nome, bi.cnpj\r\n" + 
				"			having count (*) = (\r\n" + 
				"				select max(vezes) from (\r\n" + 
				"					select max(count(*)) as vezes from aniversarioinfantil ai join contratobuffetinfantil cbi on cbi.aniversario_infantil = ai.nro_contrato join buffetinfantil bi on bi.cnpj = cbi.buffet_infantil group by bi.cnpj\r\n" + 
				"				UNION\r\n" + 
				"					select max(count(*)) as vezes from casamento c join contratobuffetcasamento cbc on cbc.casamento = c.nro_contrato join buffetcasamento bc on cbc.buffet_casamento = bc.cnpj group by bc.cnpj\r\n" + 
				"				)\r\n" + 
				"		)\r\n" + 
				"	)\r\n" + 
				"";
		new TelaConsulta(f.getContentPane(), null, "Encontrar buffet mais popular", s, col);
	}
}
