package atracao;

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
import javax.swing.SwingConstants;

public class TelaBanda extends JFrame {
	private JTextField textFieldNome;
	private JTextField textFieldTelefone;
	private JTextField textFieldEmail;
	private JTextField textFieldInteg;
	private JLabel lblTitulo;
	private JLabel lblNome;
	private JLabel lblTelefone;
	private JLabel lblEmail;
	private JLabel lblIntegrantes;
	private JLabel lblDigiteTodosOs;
	private JButton btnCadastrar;
	private JButton btnVoltar;
	private JButton btnPesquisar;
	
	public TelaBanda() {
		//inserir();
		menuInicial();
		//alterar();
		//remover();
	}
	
	public void menuInicial() {
		getContentPane().setLayout(null);
		
		JButton btnInserir = new JButton("Inserir Banda");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				getContentPane().revalidate();
				getContentPane().repaint();
				inserir();
			}
		});
		btnInserir.setBounds(275, 110, 215, 49);
		getContentPane().add(btnInserir);
		
		JButton btnAlterar = new JButton("Alterar Banda");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().revalidate();
				getContentPane().repaint();
				alterar();
			}
		});
		btnAlterar.setBounds(275, 199, 215, 49);
		getContentPane().add(btnAlterar);
		
		JButton btnRemover = new JButton("Remover Banda");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().revalidate();
				getContentPane().repaint();
				remover();
			}
		});
		btnRemover.setBounds(275, 288, 215, 49);
		getContentPane().add(btnRemover);
	}
	
	private void changeVisibility(boolean flag) {
		lblTelefone.setVisible(flag);
		btnCadastrar.setVisible(flag);
		lblEmail.setVisible(flag);
		lblIntegrantes.setVisible(flag);
		textFieldTelefone.setVisible(flag);
		textFieldEmail.setVisible(flag);
		textFieldInteg.setVisible(flag);
		lblDigiteTodosOs.setVisible(flag);
	}
	
	public void inserir() {
		getContentPane().setLayout(null);
		
		lblTitulo = new JLabel("<html><body><center><h1>Tela de Insercao de Banda</h1></center></body></html>");
		lblTitulo.setVerticalAlignment(SwingConstants.TOP);
		lblTitulo.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblTitulo.setBounds(218, 12, 330, 78);
		getContentPane().add(lblTitulo);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(137, 154, 70, 15);
		getContentPane().add(lblNome);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(137, 193, 70, 15);
		getContentPane().add(lblTelefone);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(137, 232, 70, 15);
		getContentPane().add(lblEmail);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(262, 152, 205, 19);
		getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(262, 191, 205, 19);
		getContentPane().add(textFieldTelefone);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(262, 230, 205, 19);
		getContentPane().add(textFieldEmail);
		
		lblIntegrantes = new JLabel("Integrantes");
		lblIntegrantes.setBounds(137, 274, 100, 15);
		getContentPane().add(lblIntegrantes);
		
		textFieldInteg = new JTextField();
		textFieldInteg.setColumns(10);
		textFieldInteg.setBounds(262, 272, 205, 19);
		getContentPane().add(textFieldInteg);
		
		lblDigiteTodosOs = new JLabel("(Digite todos os integrantes separados por virgulas)");
		lblDigiteTodosOs.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblDigiteTodosOs.setBounds(137, 303, 308, 20);
		getContentPane().add(lblDigiteTodosOs);
		
		btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = textFieldNome.getText();
				String telefone = textFieldTelefone.getText();
				String email = textFieldEmail.getText();			
				String integrantes[] = textFieldInteg.getText().split(",");
				for (int i = 0; i < integrantes.length; i++) {
					integrantes[i] = integrantes[i].trim();
				}
				
				Banda.insert(nome, telefone, email, integrantes);
			}
		});
		btnCadastrar.setBounds(515, 318, 117, 25);
		getContentPane().add(btnCadastrar);
		
		btnVoltar = new JButton("<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().revalidate();
				getContentPane().repaint();
				menuInicial();
			}
		});
		
		btnVoltar.setBounds(12, 12, 44, 25);
		getContentPane().add(btnVoltar);
		
	}
	
	public void alterar() {
		getContentPane().setLayout(null);
		
		lblTitulo = new JLabel("<html><body><center><h1>Tela de Alteracao de Banda</h1></center></body></html>");
		lblTitulo.setVerticalAlignment(SwingConstants.TOP);
		lblTitulo.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblTitulo.setBounds(218, 12, 330, 78);
		getContentPane().add(lblTitulo);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(137, 137, 70, 15);
		getContentPane().add(lblNome);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(137, 193, 70, 15);
		getContentPane().add(lblTelefone);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(137, 232, 70, 15);
		getContentPane().add(lblEmail);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(262, 135, 205, 19);
		getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(262, 191, 205, 19);
		getContentPane().add(textFieldTelefone);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(262, 230, 205, 19);
		getContentPane().add(textFieldEmail);
		
		lblIntegrantes = new JLabel("Integrantes");
		lblIntegrantes.setBounds(137, 274, 100, 15);
		getContentPane().add(lblIntegrantes);
		
		textFieldInteg = new JTextField();
		textFieldInteg.setColumns(10);
		textFieldInteg.setBounds(262, 272, 205, 19);
		getContentPane().add(textFieldInteg);
		
		lblDigiteTodosOs = new JLabel("(Digite todos os integrantes separados por virgulas)");
		lblDigiteTodosOs.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblDigiteTodosOs.setBounds(137, 303, 308, 20);
		getContentPane().add(lblDigiteTodosOs);
		
		btnCadastrar = new JButton("ALTERAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = textFieldNome.getText();
				String telefone = textFieldTelefone.getText();
				String email = textFieldEmail.getText();			
				String integrantes[] = textFieldInteg.getText().split(",");
				for (int i = 0; i < integrantes.length; i++) {
					integrantes[i] = integrantes[i].trim();
				}
				
				Banda.update(nome, telefone, email, integrantes);
			}
		});
		btnCadastrar.setBounds(515, 318, 117, 25);
		getContentPane().add(btnCadastrar);
		
		btnVoltar = new JButton("<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().revalidate();
				getContentPane().repaint();
				menuInicial();
			}
		});
		
		btnVoltar.setBounds(12, 12, 44, 25);
		getContentPane().add(btnVoltar);
		
		btnPesquisar = new JButton("Pesquisar banda");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldNome.getText();
				List<String> rs = Banda.select(nome);
				if (rs != null && rs.size() > 0) {
					textFieldTelefone.setText(rs.get(0));
					textFieldEmail.setText(rs.get(1));
					
					String integ = "";
					for (int i = 2; i < rs.size(); i++) {
						integ += rs.get(i);
						if (i != rs.size() - 1) integ += ", ";
					}
					textFieldInteg.setText(integ);
					
					
					changeVisibility(true);
					
				} else {
					textFieldEmail.setText("");
					changeVisibility(false);	
					JOptionPane.showMessageDialog(null, "Banda nao encontrada");
				}
			}
		});
		btnPesquisar.setBounds(515, 132, 163, 25);
		getContentPane().add(btnPesquisar);
		
		changeVisibility(false);
		
		textFieldNome.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e){}
			
			@Override
			public void focusGained(FocusEvent e) {
				changeVisibility(false);
			}
		});
	}
	
	public void remover() {
		getContentPane().setLayout(null);
		
		lblTitulo = new JLabel("<html><body><center><h1>Tela de Remocao de Banda</h1></center></body></html>");
		lblTitulo.setVerticalAlignment(SwingConstants.TOP);
		lblTitulo.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblTitulo.setBounds(218, 12, 330, 78);
		getContentPane().add(lblTitulo);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(137, 137, 70, 15);
		getContentPane().add(lblNome);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(137, 193, 70, 15);
		getContentPane().add(lblTelefone);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(137, 232, 70, 15);
		getContentPane().add(lblEmail);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(262, 135, 205, 19);
		getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(262, 191, 205, 19);
		getContentPane().add(textFieldTelefone);
		textFieldTelefone.setEditable(false);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(262, 230, 205, 19);
		getContentPane().add(textFieldEmail);
		textFieldEmail.setEditable(false);
		
		lblIntegrantes = new JLabel("Integrantes");
		lblIntegrantes.setBounds(137, 274, 100, 15);
		getContentPane().add(lblIntegrantes);
		
		
		textFieldInteg = new JTextField();
		textFieldInteg.setColumns(10);
		textFieldInteg.setBounds(262, 272, 205, 19);
		getContentPane().add(textFieldInteg);
		textFieldInteg.setEditable(false);
		
		lblDigiteTodosOs = new JLabel("(Digite todos os integrantes separados por virgulas)");
		lblDigiteTodosOs.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblDigiteTodosOs.setBounds(137, 303, 308, 20);
		getContentPane().add(lblDigiteTodosOs);
		
		btnCadastrar = new JButton("REMOVER");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = textFieldNome.getText();
				Banda.remove(nome);
			}
		});
		btnCadastrar.setBounds(515, 318, 117, 25);
		getContentPane().add(btnCadastrar);
		
		btnVoltar = new JButton("<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().revalidate();
				getContentPane().repaint();
				menuInicial();
			}
		});
		
		btnVoltar.setBounds(12, 12, 44, 25);
		getContentPane().add(btnVoltar);
		
		btnPesquisar = new JButton("Pesquisar banda");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldNome.getText();
				List<String> rs = Banda.select(nome);
				if (rs != null && rs.size() > 0) {
					textFieldTelefone.setText(rs.get(0));
					textFieldEmail.setText(rs.get(1));
					
					String integ = "";
					for (int i = 2; i < rs.size(); i++) {
						integ += rs.get(i);
						if (i != rs.size() - 1) integ += ", ";
					}
					textFieldInteg.setText(integ);
					
					
					changeVisibility(true);
					
				} else {
					textFieldEmail.setText("");
					changeVisibility(false);	
					JOptionPane.showMessageDialog(null, "Banda nao encontrada");
				}
			}
		});
		btnPesquisar.setBounds(515, 132, 163, 25);
		getContentPane().add(btnPesquisar);
		
		changeVisibility(false);
		
		textFieldNome.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e){}
			
			@Override
			public void focusGained(FocusEvent e) {
				changeVisibility(false);
			}
		});
	}
}
