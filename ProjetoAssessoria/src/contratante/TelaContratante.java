package contratante;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import main.Main;
import main.TelaInicio;

@SuppressWarnings("serial")
public class TelaContratante extends JFrame {
	private JTextField textFieldNome;
	private JFormattedTextField textFieldCpf;
	private JFormattedTextField textFieldTelefone;
	private JTextField textFieldBairro;
	private JFormattedTextField textFieldCep;
	private JTextField textFieldRua;
	private JTextField textFieldNumero;
	private JTextField textFieldEmail;

	private JLabel lblNomeCompleto;
	private JLabel lblCpf;
	private JLabel lblTelefone;
	private JLabel lblBairro;
	private JLabel lblCep;
	private JLabel lblRua;
	private JLabel lblNumero;
	private JLabel lblEmail;
	
	private JButton btnCadastrar;
	
	private Container container;
	
	private MaskFormatter cpfMask;
	private MaskFormatter telefoneMask;
	private MaskFormatter cepMask;

	public TelaContratante() {
		this.container = getContentPane();
		createMasks();
		//menuInicial();
	}

	public TelaContratante(Container c) {
		//menuInicial();
		this.container = c;
		createMasks();
	}
	
	private void createMasks() {
		
		try {
		    cpfMask = new MaskFormatter("###.###.###-##");
		    cpfMask.setPlaceholderCharacter(' ');
		    cpfMask.setValidCharacters("0123456789");
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		
		try {
		    telefoneMask = new MaskFormatter("(##)#####-####");
		    telefoneMask.setPlaceholderCharacter(' ');
		    telefoneMask.setValidCharacters("0123456789");
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		
		try {
		    cepMask = new MaskFormatter("##.###-###");
		    cepMask.setPlaceholderCharacter(' ');
		    cepMask.setValidCharacters("0123456789");
		} catch (ParseException e) {
		    e.printStackTrace();
		}
	}
	
	public void menuInicial() {
		container.setLayout(null);
	
		/* Configura botao que direciona para a tela de inserir Contratante */
		JButton btnInserir = new JButton("Inserir Contratante");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				container.removeAll();
				container.revalidate();
				container.repaint();
				cadastroContratante();
			}
		});
		btnInserir.setBounds(275, 110, 215, 49);
		container.add(btnInserir);
		
		/* Configura botao que direciona para a tela de alterar Contratante */
		JButton btnAlterar = new JButton("Alterar Contratante");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				container.revalidate();
				container.repaint();
				alteracaoContratante();
			}
		});
		btnAlterar.setBounds(275, 199, 215, 49);
		container.add(btnAlterar);
		
		/* Configura botao que direciona para a tela de remover Contratante */
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
		container.add(btnRemover);
		
		JButton button = new JButton("<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				new TelaInicio(container);
			}
		});
		button.setBounds(12, 12, 44, 25);
		container.add(button);
	}

	
	public void changeVisibility(boolean flag) {
		textFieldNome.setVisible(flag);
		textFieldTelefone.setVisible(flag);
		textFieldBairro.setVisible(flag);
		textFieldCep.setVisible(flag);
		textFieldRua.setVisible(flag);
		textFieldNumero.setVisible(flag);
		textFieldEmail.setVisible(flag);
		
		lblNomeCompleto.setVisible(flag);
		lblTelefone.setVisible(flag);
		lblBairro.setVisible(flag);
		lblCep.setVisible(flag);
		lblRua.setVisible(flag);
		lblNumero.setVisible(flag);
		lblEmail.setVisible(flag);
		
		btnCadastrar.setVisible(flag);
	}
	
	public void cadastroContratante() {
		container.setLayout(null);
		
		lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setBounds(86, 50, 115, 39);
		lblNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		container.add(lblNomeCompleto);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(234, 62, 136, 20);
		container.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(86, 148, 41, 39);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		container.add(lblEmail);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(86, 86, 41, 29);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		container.add(lblCpf);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(86, 112, 70, 39);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		container.add(lblTelefone);
		
		lblCep = new JLabel("Cep");
		lblCep.setBounds(86, 209, 41, 39);
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 15));
		container.add(lblCep);
		
		lblRua = new JLabel("Rua");
		lblRua.setBounds(86, 244, 41, 39);
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		container.add(lblRua);
		
		lblNumero = new JLabel("Numero");
		lblNumero.setBounds(86, 276, 57, 39);
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		container.add(lblNumero);
		
		lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(86, 178, 51, 39);
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		container.add(lblBairro);
		
		textFieldCpf = new JFormattedTextField(cpfMask);
		textFieldCpf.setToolTipText("xxx.xxx.xxx-xx");
		textFieldCpf.setColumns(10);
		textFieldCpf.setBounds(234, 93, 136, 20);
		container.add(textFieldCpf);
		
		textFieldTelefone = new JFormattedTextField(telefoneMask);
		textFieldTelefone.setToolTipText("(xx)xxxx-xxxx ou (xx)xxxxx-xxxx");
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(234, 124, 136, 20);
		container.add(textFieldTelefone);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(234, 190, 136, 20);
		container.add(textFieldBairro);
		
		textFieldCep = new JFormattedTextField(cepMask);
		textFieldCep.setToolTipText("xxxxx-xxx");
		textFieldCep.setColumns(10);
		textFieldCpf.setBounds(234, 93, 136, 20);
		container.add(textFieldCep);
		
		textFieldRua = new JTextField();
		textFieldRua.setColumns(10);
		textFieldRua.setBounds(234, 256, 136, 20);
		container.add(textFieldRua);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(234, 288, 136, 20);
		container.add(textFieldNumero);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(234, 160, 136, 20);
		container.add(textFieldEmail);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] s = new String[8];
				s[0] = textFieldCpf.getText();
				s[1] = textFieldNome.getText();
				s[2] = textFieldTelefone.getText();
				s[3] = textFieldEmail.getText();
				s[4] = textFieldRua.getText();
				s[5] = textFieldNumero.getText();
				s[6] = textFieldBairro.getText();
				s[7] = textFieldCep.getText();
								
				if (s[2].charAt(13) == ' ') {
					System.out.println("s2 antes: " + s[2]);
					s[2] = s[2].substring(0, 9).concat("-").concat(s[2].substring(10, 13));
					System.out.println("s2 = " + s[2]);
				}
					
				
				Contratante.insert(s);
			}
		});
		btnCadastrar.setBounds(459, 256, 115, 46);
		container.add(btnCadastrar);
		
		JLabel lblCadasroDeNovo = new JLabel("Cadastro de Novo Contratante");
		lblCadasroDeNovo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadasroDeNovo.setBounds(184, 0, 285, 29);
		container.add(lblCadasroDeNovo);
		
		JButton button = new JButton("<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				menuInicial();
			}
		});
		button.setBounds(12, 12, 44, 25);
		container.add(button);
	}


	public void alteracaoContratante() {
		container.setLayout(null);
		
		lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setBounds(86, 82, 115, 39);
		lblNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		container.add(lblNomeCompleto);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(234, 93, 136, 20);
		container.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(86, 148, 41, 39);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		container.add(lblEmail);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(86, 41, 41, 29);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		container.add(lblCpf);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(86, 112, 70, 39);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		container.add(lblTelefone);
		
		lblCep = new JLabel("Cep");
		lblCep.setBounds(86, 209, 41, 39);
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 15));
		container.add(lblCep);
		
		lblRua = new JLabel("Rua");
		lblRua.setBounds(86, 244, 41, 39);
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		container.add(lblRua);
		
		lblNumero = new JLabel("Numero");
		lblNumero.setBounds(86, 276, 57, 39);
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		container.add(lblNumero);
		
		lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(86, 178, 51, 39);
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		container.add(lblBairro);
		
		textFieldCpf = new JFormattedTextField(cpfMask);
		textFieldCpf.setToolTipText("xxx.xxx.xxx-xx");
		textFieldCpf.setColumns(10);
		textFieldCpf.setBounds(234, 47, 136, 20);
		container.add(textFieldCpf);
		
		textFieldTelefone = new JFormattedTextField(telefoneMask);
		textFieldTelefone.setToolTipText("(xx)xxxx-xxxx ou (xx)xxxxx-xxxx");
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(234, 124, 136, 20);
		container.add(textFieldTelefone);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(234, 190, 136, 20);
		container.add(textFieldBairro);
		
		textFieldCep = new JFormattedTextField(cepMask);
		textFieldCep.setToolTipText("xxxxx-xxx");
		textFieldCep.setColumns(10);
		textFieldCep.setBounds(234, 221, 136, 20);
		container.add(textFieldCep);
		
		textFieldRua = new JTextField();
		textFieldRua.setColumns(10);
		textFieldRua.setBounds(234, 256, 136, 20);
		container.add(textFieldRua);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(234, 288, 136, 20);
		container.add(textFieldNumero);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(234, 160, 136, 20);
		container.add(textFieldEmail);
		
		
		btnCadastrar = new JButton("ALTERAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] s = new String[8];
				s[0] = textFieldCpf.getText();
				s[1] = textFieldNome.getText();
				s[2] = textFieldTelefone.getText();
				s[3] = textFieldEmail.getText();
				s[4] = textFieldRua.getText();
				s[5] = textFieldNumero.getText();
				s[6] = textFieldBairro.getText();
				s[7] = textFieldCep.getText();
				Contratante.update(s);
			}
		});
		btnCadastrar.setBounds(459, 256, 115, 46);
		container.add(btnCadastrar);
		
		JLabel lblCadasroDeNovo = new JLabel("Alteracao de Contratante");
		lblCadasroDeNovo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadasroDeNovo.setBounds(184, 0, 285, 29);
		container.add(lblCadasroDeNovo);
		
		changeVisibility(false);
		
		JButton btnRetornaContratante = new JButton("Pesquisar por CPF");
		btnRetornaContratante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = textFieldCpf.getText();
				String[] rs = Contratante.select(cpf);
				//System.out.println("rs " + rs.toString());
				if (rs != null) {
					textFieldNome.setText(rs[0]);
					textFieldTelefone.setText(rs[1]);
					textFieldEmail.setText(rs[2]);
					textFieldRua.setText(rs[3]);
					textFieldNumero.setText(rs[4]);
					textFieldBairro.setText(rs[5]);
					textFieldCep.setText(rs[6]);
					changeVisibility(true);
				} else {
					textFieldNome.setText("");
					textFieldTelefone.setText("");
					textFieldEmail.setText("");
					textFieldRua.setText("");
					textFieldNumero.setText("");
					textFieldBairro.setText("");
					textFieldCep.setText("");
					changeVisibility(false);
					JOptionPane.showMessageDialog(null, "Contratante nao encontrado");
				}
			}
		});
		btnRetornaContratante.setBounds(392, 46, 182, 23);
		container.add(btnRetornaContratante);
		
		textFieldCpf.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e){}
			
			@Override
			public void focusGained(FocusEvent e) {
				changeVisibility(false);
			}
		});
		
		JButton button = new JButton("<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				menuInicial();
			}
		});
		button.setBounds(12, 12, 44, 25);
		container.add(button);
	}
	

	public void remocaoContratante() {
		container.setLayout(null);
		
		lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setBounds(86, 82, 115, 39);
		lblNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		container.add(lblNomeCompleto);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(234, 93, 136, 20);
		container.add(textFieldNome);
		textFieldNome.setColumns(10);
		textFieldNome.setEditable(false);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(86, 148, 41, 39);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		container.add(lblEmail);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(86, 41, 41, 29);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		container.add(lblCpf);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(86, 112, 70, 39);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		container.add(lblTelefone);
		
		lblCep = new JLabel("Cep");
		lblCep.setBounds(86, 209, 41, 39);
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 15));
		container.add(lblCep);
		
		lblRua = new JLabel("Rua");
		lblRua.setBounds(86, 244, 41, 39);
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		container.add(lblRua);
		
		lblNumero = new JLabel("Numero");
		lblNumero.setBounds(86, 276, 57, 39);
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		container.add(lblNumero);
		
		lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(86, 178, 51, 39);
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		container.add(lblBairro);
		
		textFieldCpf = new JFormattedTextField(cpfMask);
		textFieldCpf.setToolTipText("xxx.xxx.xxx-xx");
		textFieldCpf.setColumns(10);
		textFieldCpf.setBounds(234, 47, 136, 20);
		container.add(textFieldCpf);
		
		textFieldTelefone = new JFormattedTextField(telefoneMask);
		textFieldTelefone.setToolTipText("(xx)xxxx-xxxx ou (xx)xxxxx-xxxx");
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(234, 124, 136, 20);
		textFieldTelefone.setEditable(false);
		container.add(textFieldTelefone);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(234, 190, 136, 20);
		textFieldBairro.setEditable(false);
		container.add(textFieldBairro);
		
		textFieldCep = new JFormattedTextField(cepMask);
		textFieldCep.setToolTipText("xxxxx-xxx");
		textFieldCep.setColumns(10);
		textFieldCep.setBounds(234, 221, 136, 20);
		textFieldCep.setEditable(false);
		container.add(textFieldCep);
		
		textFieldRua = new JTextField();
		textFieldRua.setColumns(10);
		textFieldRua.setBounds(234, 256, 136, 20);
		textFieldRua.setEditable(false);
		container.add(textFieldRua);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(234, 288, 136, 20);
		textFieldNumero.setEditable(false);
		container.add(textFieldNumero);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(234, 160, 136, 20);
		textFieldEmail.setEditable(false);
		container.add(textFieldEmail);
		
		
		btnCadastrar = new JButton("REMOVER");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s;
				s = textFieldCpf.getText();
				Contratante.remove(s);
				changeVisibility(false);
			}
		});
		btnCadastrar.setBounds(459, 256, 115, 46);
		container.add(btnCadastrar);
		
		JLabel lblCadasroDeNovo = new JLabel("Remocao de Contratante");
		lblCadasroDeNovo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadasroDeNovo.setBounds(184, 0, 285, 29);
		container.add(lblCadasroDeNovo);
		
		changeVisibility(false);
		
		JButton btnRetornaContratante = new JButton("Pesquisar por CPF");
		btnRetornaContratante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = textFieldCpf.getText();
				String[] rs = Contratante.select(cpf);
				//System.out.println("rs " + rs.toString());
				if (rs != null) {
					textFieldNome.setText(rs[0]);
					textFieldTelefone.setText(rs[1]);
					textFieldEmail.setText(rs[2]);
					textFieldRua.setText(rs[3]);
					textFieldNumero.setText(rs[4]);
					textFieldBairro.setText(rs[5]);
					textFieldCep.setText(rs[6]);
					changeVisibility(true);
				} else {
					textFieldNome.setText("");
					textFieldTelefone.setText("");
					textFieldEmail.setText("");
					textFieldRua.setText("");
					textFieldNumero.setText("");
					textFieldBairro.setText("");
					textFieldCep.setText("");
					changeVisibility(false);
					JOptionPane.showMessageDialog(null, "Contratante nao encontrado");
				}
			}
		});
		btnRetornaContratante.setBounds(392, 46, 182, 23);
		container.add(btnRetornaContratante);
		
		textFieldCpf.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e){}
			
			@Override
			public void focusGained(FocusEvent e) {
				changeVisibility(false);
			}
		});
		
		JButton button = new JButton("<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				menuInicial();
			}
		});
		button.setBounds(12, 12, 44, 25);
		container.add(button);
	}
}
