package festa;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import buffet.BuffetCasamento;
import buffet.BuffetInfantil;
import buffet.TelaBuffetCasamento;
import buffet.TelaBuffetInfantil;
import contratante.Contratante;
import contratante.TelaContratante;
import main.Main;

@SuppressWarnings("serial")
public class TelaFesta extends JFrame {
	private String cpfContratante;
	private String data;
	private String tipo;
	private String[] convidados;
	private String buffet;
	private String atracao;
	private double preco;
	
	
	/* Tela 1*/
	private JTextField textCPF;
	private JLabel lblContratante;
	private JButton btnNext1;
	private JButton btnNovoContratante;
	private JButton btnPesquisar1;
	private JLabel lblNome;
	private JLabel lblTitle1;
	private JLabel lblNomeContratante;
	private JTextField textFieldNomeCont;
	
	/* Tela 2*/
	private JTextField txtData;
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
	private JButton btnInserirNovo;
	private JButton btnNext3;
	private JLabel lblTitle3;
	private JLabel lblCnpj;
	private JLabel lblNomeBuffet;
	
	public TelaFesta() {	
		tela2();
	}
	
	
	public void tela1() {
		getContentPane().setLayout(null);
		
		lblTitle1 = new JLabel("<html> <h1> 1. Escolha o Contratante </h1> </html>");
		lblTitle1.setBounds(31, 12, 362, 51);
		getContentPane().add(lblTitle1);
		
		textCPF = new JTextField();
		textCPF.setToolTipText("XXX.XXX.XXX-X");
		textCPF.setBounds(239, 154, 114, 19);
		getContentPane().add(textCPF);
		textCPF.setColumns(10);
		textCPF.setText(cpfContratante);
		
		lblContratante = new JLabel("CPF do contratante");
		lblContratante.setBounds(31, 156, 149, 15);
		getContentPane().add(lblContratante);
		
		lblNomeContratante = new JLabel("Nome");
		lblNomeContratante.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNomeContratante.setBounds(31, 202, 46, 14);
		getContentPane().add(lblNomeContratante);
		lblNomeContratante.setVisible(false);
		
		textFieldNomeCont = new JTextField();
		textFieldNomeCont.setBounds(239, 196, 254, 20);
		getContentPane().add(textFieldNomeCont);
		textFieldNomeCont.setColumns(10);
		textFieldNomeCont.setEditable(false);
		textFieldNomeCont.setVisible(false);
		
		btnNext1 = new JButton("Proxima");
		btnNext1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cpfContratante = textCPF.getText();
				Main.novaTela(getContentPane());
				tela2();
			}
		});
		btnNext1.setBounds(612, 389, 117, 25);
		getContentPane().add(btnNext1);
		
		btnNovoContratante = new JButton("Inserir Novo Contratante");
		btnNovoContratante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaContratante tela = new TelaContratante();
				Main.novaJanela(tela);
				tela.cadastroContratante();
			}
		});
		btnNovoContratante.setBounds(31, 252, 226, 25);
		getContentPane().add(btnNovoContratante);
		
		lblNome = new JLabel("");
		lblNome.setBounds(31, 185, 263, 15);
		getContentPane().add(lblNome);
		
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
		getContentPane().add(btnPesquisar1);
		
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
		getContentPane().setLayout(null);
		
		lblTitle2 = new JLabel("<html><h1>2. Escolha a data, o tipo da festa e os convidados</h1></html>");
		lblTitle2.setBounds(81, 48, 602, 49);
		getContentPane().add(lblTitle2);
		
		lblData = new JLabel("Data");
		lblData.setFont(new Font("Dialog", Font.BOLD, 12));
		lblData.setBounds(81, 132, 46, 14);
		getContentPane().add(lblData);
		
		txtData = new JTextField();
		txtData.setToolTipText("99/99/9999");
		txtData.setBounds(243, 130, 137, 20);
		getContentPane().add(txtData);
		txtData.setColumns(10);
		txtData.setText(data);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTipo.setBounds(81, 181, 46, 14);
		getContentPane().add(lblTipo);
		
		comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Casamento", "Aniversario Infantil"}));
		comboBox.setBounds(243, 179, 137, 20);
		getContentPane().add(comboBox);
		comboBox.setSelectedIndex((tipo == null || tipo == "Casamento")? 0 : 1);
		
		lblConvidados = new JLabel("Convidados");
		lblConvidados.setFont(new Font("Dialog", Font.BOLD, 12));
		lblConvidados.setBounds(81, 229, 82, 14);
		getContentPane().add(lblConvidados);
		
		btnVoltar2 = new JButton("<");
		btnVoltar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data = txtData.getText();
				tipo = (String) comboBox.getSelectedItem();
				convidados = editorPane.getText().split(",");
				for (int i = 0; i < convidados.length; i++) convidados[i] = convidados[i].trim();
				
				Main.novaTela(getContentPane());
				tela1();
			}
		});
		btnVoltar2.setBounds(10, 11, 52, 23);
		getContentPane().add(btnVoltar2);
		
		editorPane = new JEditorPane();
		editorPane.setToolTipText("nome1, nome2, nome3");
		editorPane.setBounds(243, 229, 278, 160);
		final JScrollPane scrollPane = new JScrollPane(editorPane);
		getContentPane().add(editorPane);
		getContentPane().add(scrollPane);
		String conv = "";
		for(int i = 0; convidados != null && i < convidados.length; ++i) {
			conv += convidados[i];
			if(i != convidados.length-1) conv += ", ";
		}
		editorPane.setText(conv);
		
		lbldigiteTodosOs = new JLabel("<html><p>(Digite todos os nomes<br> separados por virgulas)</p></html>");
		lbldigiteTodosOs.setBounds(81, 255, 143, 98);
		getContentPane().add(lbldigiteTodosOs);
		
		btnNext2 = new JButton("Proxima");
		btnNext2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				data = txtData.getText();
				tipo = (String) comboBox.getSelectedItem();
				
				convidados = editorPane.getText().split(",");
				for (int i = 0; i < convidados.length; i++) convidados[i] = convidados[i].trim();
				
				Main.novaTela(getContentPane());
				tela3();
			}
		});
		btnNext2.setBounds(645, 370, 89, 23);
		getContentPane().add(btnNext2);
	}
	
	private void tela3() {
		getContentPane().setLayout(null);
		
		btnVoltar3 = new JButton("<");
		btnVoltar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buffet = txtCnpj.getText();
				Main.novaTela(getContentPane());
				tela2();
			}
		});
		btnVoltar3.setBounds(10, 11, 53, 23);
		getContentPane().add(btnVoltar3);
		
		lblTitle3 = new JLabel("<html><h1>3. Escolha o Buffet</h1></html>");
		lblTitle3.setBounds(41, 45, 250, 39);
		getContentPane().add(lblTitle3);
		
		lblCnpj = new JLabel("CNPJ");
		lblCnpj.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCnpj.setBounds(41, 138, 46, 14);
		getContentPane().add(lblCnpj);
		
		txtCnpj = new JTextField();
		txtCnpj.setToolTipText("99.999.999/9999-99");
		txtCnpj.setBounds(143, 136, 163, 20);
		getContentPane().add(txtCnpj);
		txtCnpj.setColumns(10);
		txtCnpj.setText(buffet);
		
		lblNomeBuffet = new JLabel("Nome");
		lblNomeBuffet.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNomeBuffet.setBounds(41, 184, 46, 14);
		getContentPane().add(lblNomeBuffet);
		lblNomeBuffet.setVisible(false);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(143, 182, 163, 20);
		getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		textFieldNome.setEditable(false);
		textFieldNome.setVisible(false);
		
		btnPesquisar3 = new JButton("Pesquisar");
		btnPesquisar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cnpj = txtCnpj.getText();
				boolean ok = true;
				
				if (tipo == "casamento") {
					String[] nome = BuffetCasamento.select(cnpj);
					if (nome != null) textFieldNome.setText(nome[1]);
					else ok = false;
				}
				else if (tipo == "infantil") {
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
		getContentPane().add(btnPesquisar3);
		
		btnInserirNovo = new JButton("Inserir novo");
		btnInserirNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tipo == "Casamento") {
					TelaBuffetCasamento frame = new TelaBuffetCasamento();
					Main.novaJanela(frame);
					frame.cadastrarBuffetCasamento();
				} else {
					TelaBuffetInfantil frame = new TelaBuffetInfantil();
					Main.novaJanela(frame);
					frame.cadastrarBuffetInfantil();
				}
				
			}
		});
		btnInserirNovo.setBounds(41, 285, 120, 23);
		getContentPane().add(btnInserirNovo);
		
		btnNext3 = new JButton("Proxima");
		btnNext3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buffet = txtCnpj.getText();
			}
		});
		btnNext3.setBounds(622, 407, 120, 23);
		getContentPane().add(btnNext3);
		
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
}
