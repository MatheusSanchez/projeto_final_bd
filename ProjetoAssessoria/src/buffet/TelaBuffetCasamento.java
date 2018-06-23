package buffet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TelaBuffetCasamento extends JFrame {
	private JTextField textFieldCnpj;
	private JTextField textFieldNome;
	private JTextField textFieldRua;
	private JTextField textFieldNumero;
	private JTextField textFieldCep;
	private JTextField textFieldCap;
	private JLabel lblCadastroDeBuffet;
	private JLabel lblCnpj;
	private JLabel lblNome;
	private JLabel lblRua;
	private JLabel lblNumero;
	private JLabel lblCep;
	private JLabel lblCapacidade;
	private JButton btnCadastrar;

	public TelaBuffetCasamento() {
		cadastrarBuffetCasamento();
		//alterarBuffetCasamento();
		//removerBuffetCasamento();
	}
	
	// muda a visibilidade dos elementos
	private void changeVisibility(boolean flag) {
		textFieldNome.setVisible(flag);
		textFieldRua.setVisible(flag);
		textFieldNumero.setVisible(flag);
		textFieldCep.setVisible(flag);
		textFieldCap.setVisible(flag);
		lblCadastroDeBuffet.setVisible(flag);
		lblNome.setVisible(flag);
		lblRua.setVisible(flag);
		lblNumero.setVisible(flag);
		lblCep.setVisible(flag);
		lblCapacidade.setVisible(flag);
		btnCadastrar.setVisible(flag);
	}

	public void cadastrarBuffetCasamento() {
		getContentPane().setLayout(null);
		
		lblCadastroDeBuffet = new JLabel("Cadastro de Buffet de Casamento");
		lblCadastroDeBuffet.setBounds(89, 12, 282, 15);
		getContentPane().add(lblCadastroDeBuffet);
		
		lblCnpj = new JLabel("CNPJ");
		lblCnpj.setToolTipText("99.999.999/9999-99");
		lblCnpj.setBounds(29, 60, 70, 15);
		getContentPane().add(lblCnpj);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(29, 87, 70, 15);
		getContentPane().add(lblNome);
		
		lblRua = new JLabel("Rua");
		lblRua.setBounds(29, 114, 70, 15);
		getContentPane().add(lblRua);
		
		lblNumero = new JLabel("Numero");
		lblNumero.setBounds(29, 141, 70, 15);
		getContentPane().add(lblNumero);
		
		lblCep = new JLabel("CEP");
		lblCep.setBounds(29, 168, 70, 15);
		getContentPane().add(lblCep);
		
		lblCapacidade = new JLabel("Capacidade");
		lblCapacidade.setBounds(29, 195, 89, 15);
		getContentPane().add(lblCapacidade);
		
		textFieldCnpj = new JTextField();
		textFieldCnpj.setToolTipText("99.999.999/9999-99");
		textFieldCnpj.setBounds(177, 58, 114, 19);
		getContentPane().add(textFieldCnpj);
		textFieldCnpj.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(177, 85, 114, 19);
		getContentPane().add(textFieldNome);
		
		textFieldRua = new JTextField();
		textFieldRua.setColumns(10);
		textFieldRua.setBounds(177, 112, 114, 19);
		getContentPane().add(textFieldRua);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(177, 139, 114, 19);
		getContentPane().add(textFieldNumero);
		
		textFieldCep = new JTextField();
		textFieldCep.setColumns(10);
		textFieldCep.setBounds(177, 166, 114, 19);
		getContentPane().add(textFieldCep);
		
		textFieldCap = new JTextField();
		textFieldCap.setColumns(10);
		textFieldCap.setBounds(177, 193, 114, 19);
		getContentPane().add(textFieldCap);
		
		btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s[] = new String[6];
				s[0] = textFieldCnpj.getText();
				s[1] = textFieldNome.getText();
				s[2] = textFieldRua.getText();
				s[3] = textFieldNumero.getText();
				s[4] = textFieldCep.getText();
				s[5] = textFieldCap.getText();
				
				//insere no banco
				BuffetCasamento.insert(s);
			}
		});
		btnCadastrar.setBounds(321, 224, 117, 25);
		getContentPane().add(btnCadastrar);
	}

	public void alterarBuffetCasamento() {
		getContentPane().setLayout(null);
		
		lblCadastroDeBuffet = new JLabel("Alteracao de Buffet de Casamento");
		lblCadastroDeBuffet.setBounds(89, 12, 282, 15);
		getContentPane().add(lblCadastroDeBuffet);
		
		lblCnpj = new JLabel("CNPJ");
		lblCnpj.setToolTipText("99.999.999/9999-99");
		lblCnpj.setBounds(29, 60, 70, 15);
		getContentPane().add(lblCnpj);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(29, 112, 70, 15);
		getContentPane().add(lblNome);
		
		lblRua = new JLabel("Rua");
		lblRua.setBounds(29, 139, 70, 15);
		getContentPane().add(lblRua);
		
		lblNumero = new JLabel("Numero");
		lblNumero.setBounds(29, 166, 70, 15);
		getContentPane().add(lblNumero);
		
		lblCep = new JLabel("CEP");
		lblCep.setBounds(29, 193, 70, 15);
		getContentPane().add(lblCep);
		
		lblCapacidade = new JLabel("Capacidade");
		lblCapacidade.setBounds(29, 220, 89, 15);
		getContentPane().add(lblCapacidade);
		
		textFieldCnpj = new JTextField();
		textFieldCnpj.setToolTipText("99.999.999/9999-99");
		textFieldCnpj.setBounds(177, 58, 114, 19);
		getContentPane().add(textFieldCnpj);
		textFieldCnpj.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(177, 110, 114, 19);
		getContentPane().add(textFieldNome);
		
		textFieldRua = new JTextField();
		textFieldRua.setColumns(10);
		textFieldRua.setBounds(177, 137, 114, 19);
		getContentPane().add(textFieldRua);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(177, 164, 114, 19);
		getContentPane().add(textFieldNumero);
		
		textFieldCep = new JTextField();
		textFieldCep.setColumns(10);
		textFieldCep.setBounds(177, 191, 114, 19);
		getContentPane().add(textFieldCep);
		
		textFieldCap = new JTextField();
		textFieldCap.setColumns(10);
		textFieldCap.setBounds(177, 218, 114, 19);
		getContentPane().add(textFieldCap);
		
		btnCadastrar = new JButton("ALTERAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s[] = new String[6];
				s[0] = textFieldCnpj.getText();
				s[1] = textFieldNome.getText();
				s[2] = textFieldRua.getText();
				s[3] = textFieldNumero.getText();
				s[4] = textFieldCep.getText();
				s[5] = textFieldCap.getText();
				
				//atualiza o banco
				BuffetCasamento.update(s);
			}
		});
		btnCadastrar.setBounds(321, 224, 117, 25);
		getContentPane().add(btnCadastrar);
		
		JButton btnBuscarPorCnpj = new JButton("Buscar por CNPJ");
		btnBuscarPorCnpj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//recupera as informacoes referentes aquele cnpj
				String s[] = BuffetCasamento.select(textFieldCnpj.getText());
				
				if (s != null) {
					textFieldNome.setText(s[1]);
					textFieldRua.setText(s[2]);
					textFieldNumero.setText(s[3]);
					textFieldCep.setText(s[4]);
					textFieldCap.setText(s[5]);
					changeVisibility(true);
				}
				else {
					changeVisibility(false);
					JOptionPane.showMessageDialog(null, "Buffet nao encontrado");
				}
			}
		});
		btnBuscarPorCnpj.setBounds(321, 55, 163, 25);
		getContentPane().add(btnBuscarPorCnpj);
		
		//quando clicar no campo de escrever cnpj chama a funcao de alterar visibilidade
		textFieldCnpj.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e){}
			
			@Override
			public void focusGained(FocusEvent e) {
				changeVisibility(false);
			}
		});

		changeVisibility(false);
	}


	public void removerBuffetCasamento() {
		getContentPane().setLayout(null);
		
		lblCadastroDeBuffet = new JLabel("Remocao de Buffet de Casamento");
		lblCadastroDeBuffet.setBounds(89, 12, 282, 15);
		getContentPane().add(lblCadastroDeBuffet);
		
		lblCnpj = new JLabel("CNPJ");
		lblCnpj.setToolTipText("99.999.999/9999-99");
		lblCnpj.setBounds(29, 60, 70, 15);
		getContentPane().add(lblCnpj);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(29, 112, 70, 15);
		getContentPane().add(lblNome);
		
		lblRua = new JLabel("Rua");
		lblRua.setBounds(29, 139, 70, 15);
		getContentPane().add(lblRua);
		
		lblNumero = new JLabel("Numero");
		lblNumero.setBounds(29, 166, 70, 15);
		getContentPane().add(lblNumero);
		
		lblCep = new JLabel("CEP");
		lblCep.setBounds(29, 193, 70, 15);
		getContentPane().add(lblCep);
		
		lblCapacidade = new JLabel("Capacidade");
		lblCapacidade.setBounds(29, 220, 89, 15);
		getContentPane().add(lblCapacidade);
		
		textFieldCnpj = new JTextField();
		textFieldCnpj.setToolTipText("99.999.999/9999-99");
		textFieldCnpj.setBounds(177, 58, 114, 19);
		getContentPane().add(textFieldCnpj);
		textFieldCnpj.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(177, 110, 114, 19);
		getContentPane().add(textFieldNome);
		
		textFieldRua = new JTextField();
		textFieldRua.setColumns(10);
		textFieldRua.setBounds(177, 137, 114, 19);
		getContentPane().add(textFieldRua);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(177, 164, 114, 19);
		getContentPane().add(textFieldNumero);
		
		textFieldCep = new JTextField();
		textFieldCep.setColumns(10);
		textFieldCep.setBounds(177, 191, 114, 19);
		getContentPane().add(textFieldCep);
		
		textFieldCap = new JTextField();
		textFieldCap.setColumns(10);
		textFieldCap.setBounds(177, 218, 114, 19);
		getContentPane().add(textFieldCap);
		
		btnCadastrar = new JButton("REMOVER");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//remove do banco
				BuffetCasamento.remove(textFieldCnpj.getText());
			}
		});
		btnCadastrar.setBounds(321, 224, 117, 25);
		getContentPane().add(btnCadastrar);
		
		JButton btnBuscarPorCnpj = new JButton("Buscar por CNPJ");
		btnBuscarPorCnpj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//recupera os dados daquele cnpj
				String s[] = BuffetCasamento.select(textFieldCnpj.getText());
				
				if (s != null) {
					//preenche os campos com o que esta cadastrado sem deixar editar
					textFieldNome.setText(s[1]);
					textFieldNome.setEditable(false);
					textFieldRua.setText(s[2]);
					textFieldRua.setEditable(false);
					textFieldNumero.setText(s[3]);
					textFieldNumero.setEditable(false);
					textFieldCep.setText(s[4]);
					textFieldCep.setEditable(false);
					textFieldCap.setText(s[5]);
					textFieldCap.setEditable(false);
					changeVisibility(true);
				}
				else {
					changeVisibility(false);
					JOptionPane.showMessageDialog(null, "Buffet nao encontrado");
				}
			}
		});
		btnBuscarPorCnpj.setBounds(321, 55, 163, 25);
		getContentPane().add(btnBuscarPorCnpj);
		
		//quando clica no campo de preencher cnpj chama a funcao de mudar visibilidade
		textFieldCnpj.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e){}
			
			@Override
			public void focusGained(FocusEvent e) {
				changeVisibility(false);
			}
		});

		changeVisibility(false);
	}

}
