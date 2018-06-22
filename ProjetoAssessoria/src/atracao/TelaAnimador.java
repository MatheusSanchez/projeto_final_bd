package atracao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaAnimador extends JFrame {
	private JTextField textFieldNome;
	private JTextField textFieldTelefone;
	private JTextField textFieldEmail;
	private JComboBox dropTipoAnim;
	private JLabel lblTitulo;
	private JLabel lblNome;
	private JLabel lblEmail;
	private JLabel lblTelefone;
	private JLabel lblTipoAnim;
	private JButton btnVoltar;
	private JButton btnCadastrar;
	private JButton btnPesquisarAnimador;
	private String[] options = {"Animador", "Banda"};
	
	
	public TelaAnimador() {
		
		menuInicial();
		//inserir();
		//alterar();
		
	}
	
	private void changeVisibility(boolean flag) {
		lblTelefone.setVisible(flag);
		btnCadastrar.setVisible(flag);
		lblEmail.setVisible(flag);
		dropTipoAnim.setVisible(flag);
		textFieldTelefone.setVisible(flag);
		textFieldEmail.setVisible(flag);
		lblTipoAnim.setVisible(flag);
	}
	
	public void menuInicial() {
		
		JButton btnInserir = new JButton("Inserir Animador");
		btnInserir.setBounds(275, 110, 215, 49);
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				getContentPane().revalidate();
				getContentPane().repaint();
				inserir();
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(btnInserir);
		
		JButton btnAlterar = new JButton("Alterar Animador");
		btnAlterar.setBounds(275, 199, 215, 49);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().revalidate();
				getContentPane().repaint();
				alterar();
			}
		});
		getContentPane().add(btnAlterar);
		
		JButton btnRemover = new JButton("Remover Animador");
		btnRemover.setBounds(275, 288, 215, 49);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().revalidate();
				getContentPane().repaint();
				remover();
			}
		});
		getContentPane().add(btnRemover);
	}
	
	public void inserir() {
		getContentPane().setLayout(null);
		
		lblTitulo = new JLabel("<html><body><center><h1>Tela de Insercao de Animador</h1></center></body></html>");
		lblTitulo.setVerticalAlignment(SwingConstants.TOP);
		lblTitulo.setBounds(201, 12, 363, 71);
		getContentPane().add(lblTitulo);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(119, 159, 70, 15);
		getContentPane().add(lblNome);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(119, 203, 70, 15);
		getContentPane().add(lblTelefone);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(119, 250, 70, 15);
		getContentPane().add(lblEmail);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(281, 159, 221, 19);
		getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(281, 203, 221, 19);
		getContentPane().add(textFieldTelefone);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(281, 250, 221, 19);
		getContentPane().add(textFieldEmail);
		
		String[] options = {"Animador", "Banda"};
		dropTipoAnim = new JComboBox(options);
		dropTipoAnim.setBounds(281, 289, 125, 24);
		getContentPane().add(dropTipoAnim);
		
		lblTipoAnim = new JLabel("Tipo de Animacao");
		lblTipoAnim.setBounds(119, 294, 147, 15);
		getContentPane().add(lblTipoAnim);
		
		btnVoltar = new JButton("<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				getContentPane().revalidate();
				getContentPane().repaint();
				menuInicial();
			}
		});
		btnVoltar.setBounds(12, 12, 44, 25);
		getContentPane().add(btnVoltar);
		
		btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = textFieldNome.getText();
				String telefone = textFieldTelefone.getText();
				String email = textFieldEmail.getText();			
				String tipoAnimacao = (String) dropTipoAnim.getSelectedItem();
				
				Animador.insert(nome, telefone, email, tipoAnimacao);
			}
		});
		btnCadastrar.setBounds(526, 313, 117, 25);
		getContentPane().add(btnCadastrar);
		
	}
	
	public void alterar() {
		getContentPane().setLayout(null);
		
		lblTitulo = new JLabel("<html><body><center><h1>Tela de Alteracao de Animador</h1></center></body></html>");
		lblTitulo.setVerticalAlignment(SwingConstants.TOP);
		lblTitulo.setBounds(201, 12, 363, 71);
		getContentPane().add(lblTitulo);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(119, 134, 70, 15);
		getContentPane().add(lblNome);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(119, 203, 70, 15);
		getContentPane().add(lblTelefone);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(119, 250, 70, 15);
		getContentPane().add(lblEmail);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(281, 132, 221, 19);
		getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(281, 203, 221, 19);
		getContentPane().add(textFieldTelefone);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(281, 250, 221, 19);
		getContentPane().add(textFieldEmail);
		
		dropTipoAnim = new JComboBox(options);
		dropTipoAnim.setBounds(281, 289, 125, 24);
		getContentPane().add(dropTipoAnim);
		
		lblTipoAnim = new JLabel("Tipo de Animacao");
		lblTipoAnim.setBounds(119, 294, 147, 15);
		getContentPane().add(lblTipoAnim);
		
		btnVoltar = new JButton("<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				getContentPane().revalidate();
				getContentPane().repaint();
				menuInicial();
			}
		});
		btnVoltar.setBounds(12, 12, 44, 25);
		getContentPane().add(btnVoltar);
		
		btnCadastrar = new JButton("ALTERAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = textFieldNome.getText();
				String telefone = textFieldTelefone.getText();
				String email = textFieldEmail.getText();			
				String tipoAnimacao = (String) dropTipoAnim.getSelectedItem();
				
				Animador.update(nome, telefone, email, tipoAnimacao);
			}
		});
		btnCadastrar.setBounds(524, 312, 117, 25);
		getContentPane().add(btnCadastrar);
		
		btnPesquisarAnimador = new JButton("Pesquisar Animador");
		btnPesquisarAnimador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldNome.getText();
				List<String> rs = Animador.select(nome);
				if (rs != null && rs.size() > 0) {
					textFieldTelefone.setText(rs.get(0));
					textFieldEmail.setText(rs.get(1));
					dropTipoAnim.setSelectedIndex(rs.get(2).equals(options[0])? 0 : 1);
					
					changeVisibility(true);
					
				} else {
					textFieldTelefone.setText("");
					textFieldEmail.setText("");
					dropTipoAnim.setSelectedIndex(0);
					changeVisibility(false);	
					JOptionPane.showMessageDialog(null, "Animador nao encontrado");
				}
				
			}
		});
		btnPesquisarAnimador.setBounds(524, 129, 181, 25);
		getContentPane().add(btnPesquisarAnimador);
		
		textFieldNome.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e){}
			
			@Override
			public void focusGained(FocusEvent e) {
				changeVisibility(false);
			}
		});
		
		changeVisibility(false);
		
	}
	
	public void remover() {
		getContentPane().setLayout(null);
		
		lblTitulo = new JLabel("<html><body><center><h1>Tela de Remocao de Animador</h1></center></body></html>");
		lblTitulo.setVerticalAlignment(SwingConstants.TOP);
		lblTitulo.setBounds(201, 12, 363, 71);
		getContentPane().add(lblTitulo);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(119, 134, 70, 15);
		getContentPane().add(lblNome);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(119, 203, 70, 15);
		getContentPane().add(lblTelefone);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(119, 250, 70, 15);
		getContentPane().add(lblEmail);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(281, 132, 221, 19);
		getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(281, 203, 221, 19);
		getContentPane().add(textFieldTelefone);
		textFieldTelefone.setEditable(false);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(281, 250, 221, 19);
		getContentPane().add(textFieldEmail);
		textFieldEmail.setEditable(false);
		
		dropTipoAnim = new JComboBox(options);
		dropTipoAnim.setBounds(281, 289, 125, 24);
		getContentPane().add(dropTipoAnim);
		dropTipoAnim.setEnabled(false);
		
		lblTipoAnim = new JLabel("Tipo de Animacao");
		lblTipoAnim.setBounds(119, 294, 147, 15);
		getContentPane().add(lblTipoAnim);
		
		btnVoltar = new JButton("<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				getContentPane().revalidate();
				getContentPane().repaint();
				menuInicial();
			}
		});
		btnVoltar.setBounds(12, 12, 44, 25);
		getContentPane().add(btnVoltar);
		
		btnCadastrar = new JButton("REMOVER");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldNome.getText();
				Animador.remove(nome);
				
			}
		});
		btnCadastrar.setBounds(524, 312, 117, 25);
		getContentPane().add(btnCadastrar);
		
		btnPesquisarAnimador = new JButton("Pesquisar Animador");
		btnPesquisarAnimador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldNome.getText();
				List<String> rs = Animador.select(nome);
				if (rs != null && rs.size() > 0) {
					textFieldTelefone.setText(rs.get(0));
					textFieldEmail.setText(rs.get(1));
					dropTipoAnim.setSelectedIndex(rs.get(2).equals(options[0])? 0 : 1);
					
					changeVisibility(true);
					
				} else {
					textFieldTelefone.setText("");
					textFieldEmail.setText("");
					dropTipoAnim.setSelectedIndex(0);
					changeVisibility(false);	
					JOptionPane.showMessageDialog(null, "Animador nao encontrado");
				}
				
			}
		});
		btnPesquisarAnimador.setBounds(524, 129, 181, 25);
		getContentPane().add(btnPesquisarAnimador);
		
		textFieldNome.addFocusListener(new FocusListener() {
			
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
