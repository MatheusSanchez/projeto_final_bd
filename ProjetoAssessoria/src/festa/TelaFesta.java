package festa;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JTextPane;

import buffet.BuffetCasamento;
import buffet.BuffetInfantil;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TelaFesta extends JFrame {
	private String cpfContratante;
	private String data;
	private String tipo;
	private String convidados;
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
	
	TelaFesta() {	
		tela1();
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
		
		lblContratante = new JLabel("CPF do contratante");
		lblContratante.setBounds(31, 156, 149, 15);
		getContentPane().add(lblContratante);
		
		btnNext1 = new JButton("Proxima");
		btnNext1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNext1.setBounds(612, 389, 117, 25);
		getContentPane().add(btnNext1);
		
		btnNovoContratante = new JButton("Inserir Novo Contratante");
		btnNovoContratante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNovoContratante.setBounds(31, 252, 226, 25);
		getContentPane().add(btnNovoContratante);
		
		lblNome = new JLabel("");
		lblNome.setBounds(31, 185, 263, 15);
		getContentPane().add(lblNome);
		
		btnPesquisar1 = new JButton("Pesquisar");
		btnPesquisar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnPesquisar1.setBounds(379, 154, 114, 19);
		getContentPane().add(btnPesquisar1);
	}
	
	public void tela2() {
		getContentPane().setLayout(null);
		
		lblTitle2 = new JLabel("<html><h1>2. Escolha a data, o tipo da festa e os convidados</h1></html>");
		lblTitle2.setBounds(45, 35, 602, 49);
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
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTipo.setBounds(81, 181, 46, 14);
		getContentPane().add(lblTipo);
		
		comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Casamento", "Aniversario Infantil"}));
		comboBox.setBounds(243, 179, 137, 20);
		getContentPane().add(comboBox);
		
		lblConvidados = new JLabel("Convidados");
		lblConvidados.setFont(new Font("Dialog", Font.BOLD, 12));
		lblConvidados.setBounds(81, 229, 82, 14);
		getContentPane().add(lblConvidados);
		
		btnVoltar2 = new JButton("<");
		btnVoltar2.setBounds(10, 11, 41, 23);
		getContentPane().add(btnVoltar2);
		
		editorPane = new JEditorPane();
		editorPane.setToolTipText("nome1, nome2, nome3");
		editorPane.setBounds(243, 229, 278, 160);
		getContentPane().add(editorPane);
		
		lbldigiteTodosOs = new JLabel("<html><p>(Digite todos os nomes<br> separados por virgulas)</p></html>");
		lbldigiteTodosOs.setBounds(59, 254, 162, 41);
		getContentPane().add(lbldigiteTodosOs);
		
		btnNext2 = new JButton("NEXT");
		btnNext2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] convidados = editorPane.getText().split(",");
				for (int i = 0; i < convidados.length; i++) convidados[i] = convidados[i].trim();
				
				new Tela3((String)comboBox.getSelectedItem());
			}
		});
		btnNext2.setBounds(653, 366, 89, 23);
		getContentPane().add(btnNext2);
	}
	
	private void tela3() {
		getContentPane().setLayout(null);
		
		btnVoltar3 = new JButton("<");
		btnVoltar3.setBounds(10, 11, 41, 23);
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
				//abre nova janela
			}
		});
		btnInserirNovo.setBounds(41, 285, 120, 23);
		getContentPane().add(btnInserirNovo);
		
		btnNext3 = new JButton("NEXT");
		btnNext3.setBounds(653, 407, 89, 23);
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
