package decoracao;

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

@SuppressWarnings("serial")
public class TelaDecoracaoCasamento extends JFrame {
	private JTextField textFieldTema;
	private JTextField textFieldQtdeFlores;
	private JTextField textFieldTipoFlor;
	
	private JLabel lblDigiteTodosOs;
	private JButton btnCadastrar;
	private JLabel lblTipoDeFlor;
	private JLabel lblQuantidadeDeFlores;
	
	public TelaDecoracaoCasamento() {
		inserirDecoracaoCasamento();
		//alterarDecoracaoCasamento();
		//apagarDecoracaoCasamento();
	}
	public void inserirDecoracaoCasamento() {
		getContentPane().setLayout(null);
		
		JLabel lblCadastroDeNova = new JLabel("Cadastro de decoracao de casamento");
		lblCadastroDeNova.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblCadastroDeNova.setBounds(64, 33, 409, 15);
		getContentPane().add(lblCadastroDeNova);
		
		JLabel lblTema = new JLabel("Tema");
		lblTema.setBounds(49, 114, 70, 15);
		getContentPane().add(lblTema);
		
		JLabel lblQuantidadeDeFlores = new JLabel("Quantidade de Flores");
		lblQuantidadeDeFlores.setBounds(49, 141, 153, 15);
		getContentPane().add(lblQuantidadeDeFlores);
		
		JLabel lblTipoDeFlor = new JLabel("Tipos de Flor");
		lblTipoDeFlor.setBounds(49, 168, 153, 15);
		getContentPane().add(lblTipoDeFlor);
		
		textFieldTema = new JTextField();
		textFieldTema.setBounds(230, 112, 140, 19);
		getContentPane().add(textFieldTema);
		textFieldTema.setColumns(10);
		
		textFieldQtdeFlores = new JTextField();
		textFieldQtdeFlores.setColumns(10);
		textFieldQtdeFlores.setBounds(230, 139, 140, 19);
		getContentPane().add(textFieldQtdeFlores);
		
		textFieldTipoFlor = new JTextField();
		textFieldTipoFlor.setToolTipText("tipo1, tipo2");
		textFieldTipoFlor.setColumns(10);
		textFieldTipoFlor.setBounds(230, 166, 140, 19);
		getContentPane().add(textFieldTipoFlor);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tema = textFieldTema.getText();
				String qtde = textFieldQtdeFlores.getText();
				
				boolean ok = DecoracaoCasamento.insert(tema, qtde);
				
				String tipos[] = textFieldTipoFlor.getText().split(",");
				for (int i = 0; i < tipos.length; i++) {
					tipos[i] = tipos[i].trim();
				}
				
				if (ok) DecoracaoCasamento.insertTipo(tema, tipos);
			}
		});
		btnCadastrar.setBounds(356, 228, 117, 25);
		getContentPane().add(btnCadastrar);
		
		JLabel lblDigiteTodosOs = new JLabel("(Digite todos os tipos desejados separados por virgulas)");
		lblDigiteTodosOs.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblDigiteTodosOs.setBounds(49, 179, 308, 20);
		getContentPane().add(lblDigiteTodosOs);
		
	}

	private void changeVisibility(boolean flag) {
		lblDigiteTodosOs.setVisible(flag);
		textFieldTipoFlor.setVisible(flag);
		textFieldQtdeFlores.setVisible(flag);
		btnCadastrar.setVisible(flag);
		lblTipoDeFlor.setVisible(flag);
		lblQuantidadeDeFlores.setVisible(flag);
	}
	
	public void alterarDecoracaoCasamento() {
		getContentPane().setLayout(null);
		
		JLabel lblCadastroDeNova = new JLabel("Alteracao de decoracao de casamento");
		lblCadastroDeNova.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblCadastroDeNova.setBounds(64, 33, 409, 15);
		getContentPane().add(lblCadastroDeNova);
		
		JLabel lblTema = new JLabel("Tema");
		lblTema.setBounds(49, 77, 70, 15);
		getContentPane().add(lblTema);
		
		lblQuantidadeDeFlores = new JLabel("Quantidade de Flores");
		lblQuantidadeDeFlores.setBounds(49, 141, 153, 15);
		getContentPane().add(lblQuantidadeDeFlores);
		lblQuantidadeDeFlores.setVisible(false);
		
		lblTipoDeFlor = new JLabel("Tipos de Flor");
		lblTipoDeFlor.setBounds(49, 168, 153, 15);
		getContentPane().add(lblTipoDeFlor);
		lblTipoDeFlor.setVisible(false);
		
		textFieldTema = new JTextField();
		textFieldTema.setBounds(137, 77, 140, 19);
		getContentPane().add(textFieldTema);
		textFieldTema.setColumns(10);
		
		textFieldQtdeFlores = new JTextField();
		textFieldQtdeFlores.setColumns(10);
		textFieldQtdeFlores.setBounds(230, 139, 140, 19);
		getContentPane().add(textFieldQtdeFlores);
		textFieldQtdeFlores.setVisible(false);
		
		textFieldTipoFlor = new JTextField();
		textFieldTipoFlor.setToolTipText("tipo1, tipo2");
		textFieldTipoFlor.setColumns(10);
		textFieldTipoFlor.setBounds(230, 166, 140, 19);
		getContentPane().add(textFieldTipoFlor);
		textFieldTipoFlor.setVisible(false);
		
		btnCadastrar = new JButton("ALTERAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tema = textFieldTema.getText();
				String qtde = textFieldQtdeFlores.getText();
				
				String tipos[] = textFieldTipoFlor.getText().split(",");
				for (int i = 0; i < tipos.length; i++) {
					tipos[i] = tipos[i].trim();
				}
				
				String[] form = new String[2 + tipos.length];
			
				form[0] = tema;
				form[1] = qtde;
				
				for (int i = 2; i < 2 + tipos.length; i++) {
					form[i] = tipos[i - 2];
				}
				
				DecoracaoCasamento.update(form);
			}
		});
		btnCadastrar.setBounds(356, 228, 117, 25);
		getContentPane().add(btnCadastrar);
		btnCadastrar.setVisible(false);
		
		lblDigiteTodosOs = new JLabel("(Digite todos os tipos desejados separados por virgulas)");
		lblDigiteTodosOs.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblDigiteTodosOs.setBounds(49, 179, 308, 20);
		getContentPane().add(lblDigiteTodosOs);
		lblDigiteTodosOs.setVisible(false);
		
		textFieldTema.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e){}
			
			@Override
			public void focusGained(FocusEvent e) {
				changeVisibility(false);
			}
		});
		
		JButton btnPesquisarPorTema = new JButton("Pesquisar por tema");
		btnPesquisarPorTema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String tema = textFieldTema.getText();
				List<String> rs = DecoracaoCasamento.select(tema);
				if (rs != null && rs.size() > 0) {
					textFieldQtdeFlores.setText(rs.get(0));
					String tipos = "";
					for (int i = 1; i < rs.size(); i++) {
						tipos += rs.get(i);
						if (i != rs.size() - 1) tipos += ", ";
					}
					textFieldTipoFlor.setText(tipos);
					
					changeVisibility(true);
					
				} else {
					textFieldQtdeFlores.setText("");
					textFieldTipoFlor.setText("");
					changeVisibility(false);	
					JOptionPane.showMessageDialog(null, "Tema nao encontrado");
				}
			}
		});
		btnPesquisarPorTema.setBounds(289, 72, 184, 25);
		getContentPane().add(btnPesquisarPorTema);
		
	}

	public void apagarDecoracaoCasamento() {
		getContentPane().setLayout(null);
		
		JLabel lblCadastroDeNova = new JLabel("Remocao de decoracao de casamento");
		lblCadastroDeNova.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblCadastroDeNova.setBounds(64, 33, 409, 15);
		getContentPane().add(lblCadastroDeNova);
		
		JLabel lblTema = new JLabel("Tema");
		lblTema.setBounds(49, 77, 70, 15);
		getContentPane().add(lblTema);
		
		lblQuantidadeDeFlores = new JLabel("Quantidade de Flores");
		lblQuantidadeDeFlores.setBounds(49, 141, 153, 15);
		getContentPane().add(lblQuantidadeDeFlores);
		lblQuantidadeDeFlores.setVisible(false);
		
		lblTipoDeFlor = new JLabel("Tipos de Flor");
		lblTipoDeFlor.setBounds(49, 168, 153, 15);
		getContentPane().add(lblTipoDeFlor);
		lblTipoDeFlor.setVisible(false);
		
		textFieldTema = new JTextField();
		textFieldTema.setBounds(137, 77, 140, 19);
		getContentPane().add(textFieldTema);
		textFieldTema.setColumns(10);
		
		textFieldQtdeFlores = new JTextField();
		textFieldQtdeFlores.setColumns(10);
		textFieldQtdeFlores.setBounds(230, 139, 140, 19);
		getContentPane().add(textFieldQtdeFlores);
		textFieldQtdeFlores.setVisible(false);
		textFieldQtdeFlores.setEditable(false);
		
		textFieldTipoFlor = new JTextField();
		textFieldTipoFlor.setColumns(10);
		textFieldTipoFlor.setBounds(230, 166, 140, 19);
		getContentPane().add(textFieldTipoFlor);
		textFieldTipoFlor.setVisible(false);
		textFieldTipoFlor.setEditable(false);
		
		btnCadastrar = new JButton("REMOVER");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tema = textFieldTema.getText();
				DecoracaoCasamento.remove(tema);
				changeVisibility(false);
			}
		});
		btnCadastrar.setBounds(356, 228, 117, 25);
		getContentPane().add(btnCadastrar);
		btnCadastrar.setVisible(false);
		
		lblDigiteTodosOs = new JLabel("(Digite todos os tipos desejados separados por virgulas)");
		lblDigiteTodosOs.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblDigiteTodosOs.setBounds(49, 179, 308, 20);
		getContentPane().add(lblDigiteTodosOs);
		lblDigiteTodosOs.setVisible(false);
		
		textFieldTema.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e){}
			
			@Override
			public void focusGained(FocusEvent e) {
				changeVisibility(false);
			}
		});
		
		JButton btnPesquisarPorTema = new JButton("Pesquisar por tema");
		btnPesquisarPorTema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String tema = textFieldTema.getText();
				List<String> rs = DecoracaoCasamento.select(tema);
				if (rs != null && rs.size() > 0) {
					textFieldQtdeFlores.setText(rs.get(0));
					String tipos = "";
					for (int i = 1; i < rs.size(); i++) {
						tipos += rs.get(i);
						if (i != rs.size() - 1) tipos += ", ";
					}
					textFieldTipoFlor.setSize(tipos.length() * 7, textFieldTipoFlor.getHeight());
					textFieldTipoFlor.setText(tipos);
					//textFieldTipoFlor.repaint();

					changeVisibility(true);
					
				} else {
					textFieldQtdeFlores.setText("");
					textFieldTipoFlor.setText("");
					changeVisibility(false);	
					JOptionPane.showMessageDialog(null, "Tema nao encontrado");
				}
			}
		});
		btnPesquisarPorTema.setBounds(289, 72, 184, 25);
		getContentPane().add(btnPesquisarPorTema);
		
	}

	
}
