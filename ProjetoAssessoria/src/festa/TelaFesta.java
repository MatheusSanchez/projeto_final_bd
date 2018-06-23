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
	
	/* Tela 2*/
	private JTextField txtData;
	
	/* Tela 3*/
	private JTextField txtCnpj;
	private JTextField textFieldNome;
	
	TelaFesta() {	
		tela1();
	}
	
	public void tela1() {
		getContentPane().setLayout(null);
		
		//JlblTitle = new JLabel("<html> <h1> 1. Escolha o Contratante </h1> </html>");
		//lblTitle.setBounds(31, 12, 362, 51);
		//getContentPane().add(lblTitle);
		
		textCPF = new JTextField();
		textCPF.setToolTipText("XXX.XXX.XXX-X");
		textCPF.setBounds(239, 154, 114, 19);
		getContentPane().add(textCPF);
		textCPF.setColumns(10);
		
		lblContratante = new JLabel("CPF do contratante");
		lblContratante.setBounds(31, 156, 149, 15);
		getContentPane().add(lblContratante);
		
		JButton btnProxima = new JButton("Proxima");
		btnProxima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProxima.setBounds(612, 389, 117, 25);
		getContentPane().add(btnProxima);
		
		JButton btnNovoContratante = new JButton("Inserir Novo Contratante");
		btnNovoContratante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNovoContratante.setBounds(31, 252, 226, 25);
		getContentPane().add(btnNovoContratante);
		
		JLabel lblNome = new JLabel("");
		lblNome.setBounds(31, 185, 263, 15);
		getContentPane().add(lblNome);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnPesquisar.setBounds(379, 154, 114, 19);
		getContentPane().add(btnPesquisar);
	}
	
	public void tela2() {
	getContentPane().setLayout(null);
		
		JLabel lblEscolhaO = new JLabel("<html><h1>2. Escolha a data, o tipo da festa e os convidados</h1></html>");
		lblEscolhaO.setBounds(45, 35, 602, 49);
		getContentPane().add(lblEscolhaO);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Dialog", Font.BOLD, 12));
		lblData.setBounds(81, 132, 46, 14);
		getContentPane().add(lblData);
		
		txtData = new JTextField();
		txtData.setToolTipText("99/99/9999");
		txtData.setBounds(243, 130, 137, 20);
		getContentPane().add(txtData);
		txtData.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTipo.setBounds(81, 181, 46, 14);
		getContentPane().add(lblTipo);
		
		JComboBox comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Casamento", "Aniversario Infantil"}));
		comboBox.setBounds(243, 179, 137, 20);
		getContentPane().add(comboBox);
		
		JLabel lblConvidados = new JLabel("Convidados");
		lblConvidados.setFont(new Font("Dialog", Font.BOLD, 12));
		lblConvidados.setBounds(81, 229, 82, 14);
		getContentPane().add(lblConvidados);
		
		JButton button = new JButton("<");
		button.setBounds(10, 11, 41, 23);
		getContentPane().add(button);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setToolTipText("nome1, nome2, nome3");
		editorPane.setBounds(243, 229, 278, 160);
		getContentPane().add(editorPane);
		
		JLabel lbldigiteTodosOs = new JLabel("<html><p>(Digite todos os nomes<br> separados por virgulas)</p></html>");
		lbldigiteTodosOs.setBounds(59, 254, 162, 41);
		getContentPane().add(lbldigiteTodosOs);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] convidados = editorPane.getText().split(",");
				for (int i = 0; i < convidados.length; i++) convidados[i] = convidados[i].trim();
				
				new Tela3((String)comboBox.getSelectedItem());
			}
		});
		btnNext.setBounds(653, 366, 89, 23);
		getContentPane().add(btnNext);
	}
	
	private void tela3() {
		getContentPane().setLayout(null);
		
		JButton button = new JButton("<");
		button.setBounds(10, 11, 41, 23);
		getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("<html><h1>3. Escolha o Buffet</h1></html>");
		lblNewLabel.setBounds(41, 45, 250, 39);
		getContentPane().add(lblNewLabel);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCnpj.setBounds(41, 138, 46, 14);
		getContentPane().add(lblCnpj);
		
		txtCnpj = new JTextField();
		txtCnpj.setToolTipText("99.999.999/9999-99");
		txtCnpj.setBounds(143, 136, 163, 20);
		getContentPane().add(txtCnpj);
		txtCnpj.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNome.setBounds(41, 184, 46, 14);
		getContentPane().add(lblNome);
		lblNome.setVisible(false);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(143, 182, 163, 20);
		getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		textFieldNome.setEditable(false);
		textFieldNome.setVisible(false);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
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
					lblNome.setVisible(false);
					JOptionPane.showMessageDialog(null, "CNPJ nao encontrado");
					textFieldNome.setText("");
				} else {
					textFieldNome.setVisible(true);
					lblNome.setVisible(true);
				}
			}
		});
		btnPesquisar.setBounds(379, 135, 110, 23);
		getContentPane().add(btnPesquisar);
		
		JButton btnInserirNovo = new JButton("Inserir novo");
		btnInserirNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//abre nova janela
			}
		});
		btnInserirNovo.setBounds(41, 285, 120, 23);
		getContentPane().add(btnInserirNovo);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.setBounds(653, 407, 89, 23);
		getContentPane().add(btnNext);
		
		//quando clica no campo de escrever o tema chama a funcao de alterar visibilidade
		txtCnpj.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e){}
			
			@Override
			public void focusGained(FocusEvent e) {
				textFieldNome.setVisible(false);
				lblNome.setVisible(false);
			}
		});
		
	}
	}
}
