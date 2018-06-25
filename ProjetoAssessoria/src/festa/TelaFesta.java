package festa;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import buffet.BuffetCasamento;
import buffet.BuffetInfantil;
import contratante.Contratante;
import contratante.TelaContratante;
import main.Main;
import main.TelaInicio;

@SuppressWarnings("serial")
public class TelaFesta extends JFrame {
	private String cpfContratante;
	private String data;
	private String tipo;
	private String[] convidados;
	private String buffet;
	private String atracao;
	private String decoracao;
	private double preco = 0.0;
	private Container container;
	private Boolean alterando = false;
	private String numeroContrato;
	
	/* Tela inicio */
	private JButton btnInserir;
	private JButton btnAlterar;
	private JButton btnVoltar;
	
	/* Tela 0 */
	private JLabel lblNumCont;
	private JLabel lblTitle0;
	private JTextField textNumCont;
	private JButton btnVoltar0;
	private JButton btnNext0;
	
	/* Tela 1*/
	private JTextField textCPF;
	private JLabel lblContratante;
	private JButton btnNext1;
	private JButton btnNovoContratante;
	private JButton btnPesquisar1;
	private JLabel lblNome;
	private JLabel lblTitle1;
	private JButton btnVoltar1;
	private JLabel lblNomeContratante;
	private JTextField textFieldNomeCont;
	
	/* Tela 2*/
	private JFormattedTextField txtData;
	private JLabel lblTitle2;
	private JLabel lblData;
	private JLabel lblTipo;
	private JLabel lblConvidados;
	private JLabel lbldigiteTodosOs;
	private JComboBox comboBox;
	private JButton btnVoltar2;
	private JButton btnNext2;
	private JEditorPane editorPane;

	/* Tela 3*/
	private JTextField txtCnpj;
	private JTextField textFieldNome;
	private JButton btnVoltar3;
	private JButton btnPesquisar3;
	private JButton btnNext3;
	private JLabel lblTitle3;
	private JLabel lblCnpj;
	private JLabel lblNomeBuffet;
	
	/* Tela 4*/
	private JTextField txtTema;
	private JTextField txtNomeAt;
	private JButton btnVoltar4;
	private JButton btnNext4;
	private JLabel lblTitle4;
	private JLabel lblTema;
	private JLabel lblNomeAt;
	private JTextField textFieldPreco;
	
	public TelaFesta(Container c) {	
		this.container = c;
		//menuInicial();
	}

	public TelaFesta() {	
		this.container = getContentPane();
		//menuInicial();
		tela0();
		//tela1();
		//tela2();
		//tela3();
		//tela4();
	}

	public void menuInicial() {
		container.setLayout(null);
	
		/* Configura botao que direciona para a tela de inserir Festa */
		btnInserir = new JButton("Inserir Festa");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				container.removeAll();
				container.revalidate();
				container.repaint();
				alterando = false;
				tela1();
			}
		});
		btnInserir.setBounds(275, 110, 215, 49);
		container.add(btnInserir);
		
		/* Configura botao que direciona para a tela de alterar Contratante */
		btnAlterar = new JButton("Alterar Festa");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				container.revalidate();
				container.repaint();
				alterando = true;
				Main.novaTela(container);
				tela0();
				//TODO coisas de alter
			}
		});
		btnAlterar.setBounds(275, 199, 215, 49);
		container.add(btnAlterar);
		
		/* Configura botao que direciona para a tela de remover Contratante 
		JButton btnRemover = new JButton("Remover Contratante");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				container.revalidate();
				container.repaint();
				remocaoContratante();
			}
		});
		btnRemover.setBounds(275, 288, 215, 49);
		container.add(btnRemover);*/
		
		btnVoltar = new JButton("<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				TelaInicio t = new TelaInicio(container);
				t.atualizaBanco();
			}
		});
		btnVoltar.setBounds(12, 12, 44, 25);
		container.add(btnVoltar);
	}
	
	// h5fgnmhi1uKdLVcornRgPWCtH
	public boolean seleciona() {
		System.out.println(numeroContrato);
		String[] res = Festa.select(numeroContrato);
		if(res != null) {
			for(int i = 0; i < res.length; ++i) {
				System.out.println(res[i]);
			}
			preco = res[0] == null? 0.0 : Double.parseDouble(res[0]);
			data = res[1];
			
			data = data.substring(8, 10) + "/" + data.substring(5, 7) + "/" + data.substring(0, 4);
			System.out.println(data);
			tipo = res[2];
			cpfContratante = res[3];
			buffet = res[4];
			decoracao = res[5];
			atracao = res[6];
		} else return false;
		convidados = (String[]) Festa.selectConvidados(numeroContrato).toArray(new String[0]);
		return true;
	}

	public void tela0() {
		container.setLayout(null);
		lblTitle0 = new JLabel("<html> <h1>  Escolha a festa para ser alterada</h1> </html>");
		lblTitle0.setBounds(31, 60, 547, 51);
		container.add(lblTitle0);
		
		textNumCont = new JTextField();
		textNumCont.setBounds(239, 154, 114, 19);
		container.add(textNumCont);
		textNumCont.setText(numeroContrato);
		
		lblNumCont = new JLabel("Numero de contrato");
		lblNumCont.setBounds(31, 156, 149, 15);
		container.add(lblNumCont);
		
		btnVoltar0 = new JButton("<");
		btnVoltar0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				menuInicial();
			}
		});
		btnVoltar0.setBounds(10, 11, 52, 23);
		container.add(btnVoltar0);
		
		btnNext0 = new JButton("Proxima");
		btnNext0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroContrato = textNumCont.getText();
				if(seleciona()) {
					Main.novaTela(container);
					tela1();
				}
			}
		});
		btnNext0.setBounds(612, 389, 117, 25);
		container.add(btnNext0);
	}

	public void tela1() {
		container.setLayout(null);
		
		btnVoltar1 = new JButton("<");
		btnVoltar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				if(alterando == false) menuInicial();
				else tela0();
			}
		});
		btnVoltar1.setBounds(10, 11, 52, 23);
		container.add(btnVoltar1);
		
		lblTitle1 = new JLabel("<html> <h1> 1. Escolha o Contratante </h1> </html>");
		lblTitle1.setBounds(31, 60, 362, 51);
		container.add(lblTitle1);
		
		textCPF = new JTextField();
		textCPF.setToolTipText("XXX.XXX.XXX-X");
		textCPF.setBounds(239, 154, 114, 19);
		container.add(textCPF);
		textCPF.setColumns(10);
		textCPF.setText(cpfContratante);
		
		lblContratante = new JLabel("CPF do contratante");
		lblContratante.setBounds(31, 156, 149, 15);
		container.add(lblContratante);
		
		lblNomeContratante = new JLabel("Nome");
		lblNomeContratante.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNomeContratante.setBounds(31, 202, 46, 14);
		container.add(lblNomeContratante);
		lblNomeContratante.setVisible(false);
		
		textFieldNomeCont = new JTextField();
		textFieldNomeCont.setBounds(239, 196, 254, 20);
		container.add(textFieldNomeCont);
		textFieldNomeCont.setColumns(10);
		textFieldNomeCont.setEditable(false);
		textFieldNomeCont.setVisible(false);
		
		btnNext1 = new JButton("Proxima");
		btnNext1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cpfContratante = textCPF.getText();
				try{
					preco = Double.parseDouble(textFieldPreco.getText());
				} catch (Exception ex) {
					preco = 0.0;
				}
				Main.novaTela(container);
				tela2();
			}
		});
		btnNext1.setBounds(612, 389, 117, 25);
		container.add(btnNext1);
		
		btnNovoContratante = new JButton("Inserir Novo Contratante");
		btnNovoContratante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaContratante tela = new TelaContratante();
				Main.novaJanela(tela);
				tela.cadastroContratante();
			}
		});
		btnNovoContratante.setBounds(31, 252, 226, 25);
		container.add(btnNovoContratante);
		
		lblNome = new JLabel("");
		lblNome.setBounds(31, 185, 263, 15);
		container.add(lblNome);
		
		btnPesquisar1 = new JButton("Pesquisar");
		btnPesquisar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = textCPF.getText();
				boolean ok = true;
				
				String[] nome = Contratante.select(cpf);
				if (nome != null) textFieldNomeCont.setText(nome[0]);
				else ok = false;
				
				if (!ok) {
					textFieldNomeCont.setVisible(false);
					lblNomeContratante.setVisible(false);
					JOptionPane.showMessageDialog(null, "CPF nao encontrado");
					textFieldNomeCont.setText("");
				} else {
					textFieldNomeCont.setVisible(true);
					lblNomeContratante.setVisible(true);
				}
			}
		});
		btnPesquisar1.setBounds(379, 154, 114, 19);
		container.add(btnPesquisar1);
		
		textFieldPreco = new JTextField();
		textFieldPreco.setToolTipText("XXX.XXX.XXX-X");
		textFieldPreco.setText(preco == 0.0? "" : Double.toString(preco));
		textFieldPreco.setColumns(10);
		textFieldPreco.setBounds(239, 326, 114, 19);
		container.add(textFieldPreco);
		
		JLabel lblPreco = new JLabel("Preco");
		lblPreco.setBounds(31, 328, 149, 15);
		container.add(lblPreco);
		
		textCPF.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e){}
			
			@Override
			public void focusGained(FocusEvent e) {
				textFieldNomeCont.setVisible(false);
				lblNomeContratante.setVisible(false);
			}
		});
	}
	
	public void tela2() {
		container.setLayout(null);
		
		lblTitle2 = new JLabel("<html><h1>2. Escolha a data, o tipo da festa e os convidados</h1></html>");
		lblTitle2.setBounds(81, 48, 602, 49);
		container.add(lblTitle2);
		
		lblData = new JLabel("Data");
		lblData.setFont(new Font("Dialog", Font.BOLD, 12));
		lblData.setBounds(81, 132, 46, 14);
		container.add(lblData);
		
		MaskFormatter dateMask = null;
		try {
		    dateMask = new MaskFormatter("##/##/####");
		    dateMask.setPlaceholderCharacter(' ');
		    dateMask.setValidCharacters("0123456789");
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		txtData = new JFormattedTextField(dateMask); 
		txtData.setToolTipText("99/99/9999");
		txtData.setBounds(243, 130, 137, 20);
		container.add(txtData);
		txtData.setText(data);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTipo.setBounds(81, 181, 46, 14);
		container.add(lblTipo);
		
		comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Casamento", "Aniversario Infantil"}));
		comboBox.setBounds(243, 179, 137, 20);
		container.add(comboBox);
		comboBox.setSelectedIndex((tipo == null || tipo.equals("Casamento"))? 0 : 1);
		
		lblConvidados = new JLabel("Convidados");
		lblConvidados.setFont(new Font("Dialog", Font.BOLD, 12));
		lblConvidados.setBounds(81, 229, 82, 14);
		container.add(lblConvidados);
		
		btnVoltar2 = new JButton("<");
		btnVoltar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data = txtData.getText();
				tipo = (String) comboBox.getSelectedItem();
				convidados = editorPane.getText().split(",");
				for (int i = 0; i < convidados.length; i++) convidados[i] = convidados[i].trim();
				
				Main.novaTela(container);
				tela1();
			}
		});
		btnVoltar2.setBounds(10, 11, 52, 23);
		container.add(btnVoltar2);
		
		editorPane = new JEditorPane();
		editorPane.setToolTipText("nome1, nome2, nome3");

		final JScrollPane scrollPane = new JScrollPane(editorPane);
		container.add(scrollPane);
		scrollPane.setBounds(243, 229, 278, 160);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);

		String conv = "";
		for(int i = 0; convidados != null && i < convidados.length; ++i) {
			conv += convidados[i];
			if(i != convidados.length-1) conv += ", ";
		}
		editorPane.setText(conv);
		
		lbldigiteTodosOs = new JLabel("<html><p>(Digite todos os nomes<br> separados por virgulas)</p></html>");
		lbldigiteTodosOs.setBounds(81, 255, 143, 98);
		container.add(lbldigiteTodosOs);
		
		btnNext2 = new JButton("Proxima");
		btnNext2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				data = txtData.getText();
				tipo = (String) comboBox.getSelectedItem();
				
				convidados = editorPane.getText().split(",");
				for (int i = 0; i < convidados.length; i++) convidados[i] = convidados[i].trim();
				
				Main.novaTela(container);
				tela3();
			}
		});
		btnNext2.setBounds(635, 396, 103, 23);
		container.add(btnNext2);
	}
	
	private void tela3() {
		container.setLayout(null);
		
		btnVoltar3 = new JButton("<");
		btnVoltar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buffet = txtCnpj.getText();
				Main.novaTela(container);
				tela2();
			}
		});
		btnVoltar3.setBounds(10, 11, 53, 23);
		container.add(btnVoltar3);
		
		lblTitle3 = new JLabel("<html><h1>3. Escolha o Buffet</h1></html>");
		lblTitle3.setBounds(41, 58, 250, 39);
		container.add(lblTitle3);
		
		lblCnpj = new JLabel("CNPJ");
		lblCnpj.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCnpj.setBounds(41, 138, 46, 14);
		container.add(lblCnpj);
		
		txtCnpj = new JTextField();
		txtCnpj.setToolTipText("99.999.999/9999-99");
		txtCnpj.setBounds(143, 136, 163, 20);
		container.add(txtCnpj);
		txtCnpj.setColumns(10);
		txtCnpj.setText(buffet);
		
		lblNomeBuffet = new JLabel("Nome");
		lblNomeBuffet.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNomeBuffet.setBounds(41, 184, 46, 14);
		container.add(lblNomeBuffet);
		lblNomeBuffet.setVisible(false);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(143, 182, 163, 20);
		container.add(textFieldNome);
		textFieldNome.setColumns(10);
		textFieldNome.setEditable(false);
		textFieldNome.setVisible(false);
		
		btnPesquisar3 = new JButton("Pesquisar");
		btnPesquisar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cnpj = txtCnpj.getText();
				boolean ok = true;
				
				if (tipo.equals("Casamento")) {
					String[] nome = BuffetCasamento.select(cnpj);
					if (nome != null) textFieldNome.setText(nome[1]);
					else ok = false;
				}
				else if (tipo.equals("Aniversario Infantil")) {
					List<String> nome = BuffetInfantil.select(cnpj);
					if (nome != null && nome.size() > 0) textFieldNome.setText(nome.get(1));
					else ok = false;
				}
				
				
				if (!ok) {
					textFieldNome.setVisible(false);
					lblNomeBuffet.setVisible(false);
					JOptionPane.showMessageDialog(null, "CNPJ nao encontrado");
					textFieldNome.setText("");
				} else {
					textFieldNome.setVisible(true);
					lblNomeBuffet.setVisible(true);
				}
			}
		});
		btnPesquisar3.setBounds(379, 135, 110, 23);
		container.add(btnPesquisar3);
		
		btnNext3 = new JButton("Proxima");
		btnNext3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buffet = txtCnpj.getText();
				Main.novaTela(container);
				tela4();
			}
		});
		btnNext3.setBounds(622, 407, 120, 23);
		container.add(btnNext3);
		
		//quando clica no campo de escrever o tema chama a funcao de alterar visibilidade
		txtCnpj.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e){}
			
			@Override
			public void focusGained(FocusEvent e) {
				textFieldNome.setVisible(false);
				lblNomeBuffet.setVisible(false);
			}
		});
		
	}
	
	public void tela4() {
		container.setLayout(null);
		
		btnVoltar4 = new JButton("<");
		btnVoltar4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atracao = txtNomeAt.getText();
				decoracao = txtTema.getText();
				Main.novaTela(container);
				tela3();
			}
		});
		btnVoltar4.setBounds(10, 11, 53, 23);
		container.add(btnVoltar4);
		
		lblTitle4 = new JLabel("<html><h1> 4. Escolha a Decoracao e " + (tipo == null || tipo.equals("Casamento")? "a Banda" : "o Animador") + "</h1></html>");
		lblTitle4.setBounds(41, 58, 500, 39);
		container.add(lblTitle4);
		
		lblTema = new JLabel("Tema");
		lblTema.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTema.setBounds(41, 274, 46, 14);
		container.add(lblTema);
		
		txtTema = new JTextField();
		txtTema.setToolTipText("99.999.999/9999-99");
		txtTema.setBounds(143, 272, 163, 20);
		container.add(txtTema);
		txtTema.setColumns(10);
		txtTema.setText(decoracao);
		
		lblNomeAt = new JLabel("Nome");
		lblNomeAt.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNomeAt.setBounds(41, 178, 46, 14);
		container.add(lblNomeAt);
		
		txtNomeAt = new JTextField();
		txtNomeAt.setBounds(143, 176, 163, 20);
		container.add(txtNomeAt);
		txtNomeAt.setColumns(10);
		txtNomeAt.setText(atracao);
		
		btnNext4 = new JButton("Finalizar");
		btnNext4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atracao = txtNomeAt.getText();
				decoracao = txtTema.getText();
				if(alterando == false) Festa.insert(preco, data, tipo, cpfContratante, buffet, decoracao, atracao, convidados);
				else Festa.update(numeroContrato, preco, data, tipo, cpfContratante, buffet, decoracao, atracao, convidados);
			}
		});
		btnNext4.setBounds(622, 407, 120, 23);
		container.add(btnNext4);
		
		JLabel lblTitleAt = new JLabel("<html> <h2>" + (tipo == null || tipo.equals("Casamento")? "Banda" : "Animador") + "<h2> </html>");
		lblTitleAt.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTitleAt.setBounds(41, 135, 163, 31);
		container.add(lblTitleAt);
		
		JLabel lblTituloDec = new JLabel("<html> <h2> Decoracao </h2> </html>");
		lblTituloDec.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTituloDec.setBounds(41, 231, 163, 31);
		container.add(lblTituloDec);
	}
}
