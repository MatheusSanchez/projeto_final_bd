package festa;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import buffet.BuffetCasamento;
import buffet.BuffetInfantil;

public class Tela3 extends JFrame {
	private JTextField txtCnpj;
	private JTextField textFieldNome;
	
	public Tela3(String tipo) {
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
