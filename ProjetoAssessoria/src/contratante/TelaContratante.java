package contratante;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaContratante extends JFrame {
	private JTextField textFieldNome;
	private JTextField textFieldCpf;
	private JTextField textFieldTelefone;
	private JTextField textFieldBairro;
	private JTextField textFieldCep;
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
	
	public TelaContratante() {
		//cadastroContratante();
		//alteracaoContratante();
		remocaoContratante();
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
		getContentPane().setLayout(null);
		
		lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setBounds(86, 50, 115, 39);
		lblNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblNomeCompleto);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(234, 62, 136, 20);
		getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(86, 148, 41, 39);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblEmail);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(86, 86, 41, 29);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblCpf);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(86, 112, 70, 39);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblTelefone);
		
		lblCep = new JLabel("Cep");
		lblCep.setBounds(86, 209, 41, 39);
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblCep);
		
		lblRua = new JLabel("Rua");
		lblRua.setBounds(86, 244, 41, 39);
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblRua);
		
		lblNumero = new JLabel("Numero");
		lblNumero.setBounds(86, 276, 57, 39);
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblNumero);
		
		lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(86, 178, 51, 39);
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblBairro);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setToolTipText("xxx.xxx.xxx-xx");
		textFieldCpf.setColumns(10);
		textFieldCpf.setBounds(234, 93, 136, 20);
		getContentPane().add(textFieldCpf);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setToolTipText("(xx)xxxx-xxxx ou (xx)xxxxx-xxxx");
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(234, 124, 136, 20);
		getContentPane().add(textFieldTelefone);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(234, 190, 136, 20);
		getContentPane().add(textFieldBairro);
		
		textFieldCep = new JTextField();
		textFieldCep.setToolTipText("xxxxx-xxx");
		textFieldCep.setColumns(10);
		textFieldCep.setBounds(234, 221, 136, 20);
		getContentPane().add(textFieldCep);
		
		textFieldRua = new JTextField();
		textFieldRua.setColumns(10);
		textFieldRua.setBounds(234, 256, 136, 20);
		getContentPane().add(textFieldRua);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(234, 288, 136, 20);
		getContentPane().add(textFieldNumero);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(234, 160, 136, 20);
		getContentPane().add(textFieldEmail);
		
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
				Contratante.insert(s);
			}
		});
		btnCadastrar.setBounds(459, 256, 115, 46);
		getContentPane().add(btnCadastrar);
		
		JLabel lblCadasroDeNovo = new JLabel("Cadastro de Novo Contratante");
		lblCadasroDeNovo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadasroDeNovo.setBounds(184, 0, 285, 29);
		getContentPane().add(lblCadasroDeNovo);
	}


	public void alteracaoContratante() {
		getContentPane().setLayout(null);
		
		lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setBounds(86, 82, 115, 39);
		lblNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblNomeCompleto);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(234, 93, 136, 20);
		getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(86, 148, 41, 39);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblEmail);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(86, 41, 41, 29);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblCpf);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(86, 112, 70, 39);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblTelefone);
		
		lblCep = new JLabel("Cep");
		lblCep.setBounds(86, 209, 41, 39);
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblCep);
		
		lblRua = new JLabel("Rua");
		lblRua.setBounds(86, 244, 41, 39);
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblRua);
		
		lblNumero = new JLabel("Numero");
		lblNumero.setBounds(86, 276, 57, 39);
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblNumero);
		
		lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(86, 178, 51, 39);
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblBairro);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setToolTipText("xxx.xxx.xxx-xx");
		textFieldCpf.setColumns(10);
		textFieldCpf.setBounds(234, 47, 136, 20);
		getContentPane().add(textFieldCpf);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setToolTipText("(xx)xxxx-xxxx ou (xx)xxxxx-xxxx");
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(234, 124, 136, 20);
		getContentPane().add(textFieldTelefone);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(234, 190, 136, 20);
		getContentPane().add(textFieldBairro);
		
		textFieldCep = new JTextField();
		textFieldCep.setToolTipText("xxxxx-xxx");
		textFieldCep.setColumns(10);
		textFieldCep.setBounds(234, 221, 136, 20);
		getContentPane().add(textFieldCep);
		
		textFieldRua = new JTextField();
		textFieldRua.setColumns(10);
		textFieldRua.setBounds(234, 256, 136, 20);
		getContentPane().add(textFieldRua);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(234, 288, 136, 20);
		getContentPane().add(textFieldNumero);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(234, 160, 136, 20);
		getContentPane().add(textFieldEmail);
		
		
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
		getContentPane().add(btnCadastrar);
		
		JLabel lblCadasroDeNovo = new JLabel("Alteracao de Contratante");
		lblCadasroDeNovo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadasroDeNovo.setBounds(184, 0, 285, 29);
		getContentPane().add(lblCadasroDeNovo);
		
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
		getContentPane().add(btnRetornaContratante);
		
		textFieldCpf.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e){}
			
			@Override
			public void focusGained(FocusEvent e) {
				changeVisibility(false);
			}
		});
	}
	

	public void remocaoContratante() {
		getContentPane().setLayout(null);
		
		lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setBounds(86, 82, 115, 39);
		lblNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblNomeCompleto);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(234, 93, 136, 20);
		getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		textFieldNome.setEditable(false);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(86, 148, 41, 39);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblEmail);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(86, 41, 41, 29);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblCpf);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(86, 112, 70, 39);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblTelefone);
		
		lblCep = new JLabel("Cep");
		lblCep.setBounds(86, 209, 41, 39);
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblCep);
		
		lblRua = new JLabel("Rua");
		lblRua.setBounds(86, 244, 41, 39);
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblRua);
		
		lblNumero = new JLabel("Numero");
		lblNumero.setBounds(86, 276, 57, 39);
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblNumero);
		
		lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(86, 178, 51, 39);
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblBairro);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setToolTipText("xxx.xxx.xxx-xx");
		textFieldCpf.setColumns(10);
		textFieldCpf.setBounds(234, 47, 136, 20);
		getContentPane().add(textFieldCpf);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setToolTipText("(xx)xxxx-xxxx ou (xx)xxxxx-xxxx");
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(234, 124, 136, 20);
		textFieldTelefone.setEditable(false);
		getContentPane().add(textFieldTelefone);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(234, 190, 136, 20);
		textFieldBairro.setEditable(false);
		getContentPane().add(textFieldBairro);
		
		textFieldCep = new JTextField();
		textFieldCep.setToolTipText("xxxxx-xxx");
		textFieldCep.setColumns(10);
		textFieldCep.setBounds(234, 221, 136, 20);
		textFieldCep.setEditable(false);
		getContentPane().add(textFieldCep);
		
		textFieldRua = new JTextField();
		textFieldRua.setColumns(10);
		textFieldRua.setBounds(234, 256, 136, 20);
		textFieldRua.setEditable(false);
		getContentPane().add(textFieldRua);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(234, 288, 136, 20);
		textFieldNumero.setEditable(false);
		getContentPane().add(textFieldNumero);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(234, 160, 136, 20);
		textFieldEmail.setEditable(false);
		getContentPane().add(textFieldEmail);
		
		
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
		getContentPane().add(btnCadastrar);
		
		JLabel lblCadasroDeNovo = new JLabel("Remocao de Contratante");
		lblCadasroDeNovo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadasroDeNovo.setBounds(184, 0, 285, 29);
		getContentPane().add(lblCadasroDeNovo);
		
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
		getContentPane().add(btnRetornaContratante);
		
		textFieldCpf.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e){}
			
			@Override
			public void focusGained(FocusEvent e) {
				changeVisibility(false);
			}
		});
	}
}
