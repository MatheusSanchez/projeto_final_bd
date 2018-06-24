package atracao;

import java.awt.Container;
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

import main.Main;
import main.TelaInicio;

public class TelaAnimador {
	
	/* Objetos usados pelo swing para a interface da tela */
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
	private String[] options = {"Magico", "Palhaco"};
	
	private Container container;
	
	public TelaAnimador() {
	}

	public TelaAnimador(Container c) {
		this.container = c;		
	}
	
	/* Metodo usado para esconder ou revelar o formulario de insercao ou alteracao de animador */
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
		
		/* Configura botao que direciona para a tela de inserir animador */
		JButton btnInserir = new JButton("Inserir Animador");
		btnInserir.setBounds(275, 110, 215, 49);
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				container.removeAll();
				container.revalidate();
				container.repaint();
				inserir();
			}
		});
		container.setLayout(null);
		container.add(btnInserir);
		
		/* Configura botao que direciona para a tela de alterar animador */
		JButton btnAlterar = new JButton("Alterar Animador");
		btnAlterar.setBounds(275, 199, 215, 49);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				container.revalidate();
				container.repaint();
				alterar();
			}
		});
		container.add(btnAlterar);
		
		/* Configura botao que direciona para a tela de remover animador */
		JButton btnRemover = new JButton("Remover Animador");
		btnRemover.setBounds(275, 288, 215, 49);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				container.revalidate();
				container.repaint();
				remover();
			}
		});
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
	
	/* Metodo que cria a tela de insercao de animador */
	public void inserir() {
		container.setLayout(null);
		
		/* Criacao dos objetos swing para a interface da tela */
		lblTitulo = new JLabel("<html><body><center><h1>Tela de Insercao de Animador</h1></center></body></html>");
		lblTitulo.setVerticalAlignment(SwingConstants.TOP);
		lblTitulo.setBounds(201, 12, 363, 71);
		container.add(lblTitulo);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(119, 159, 70, 15);
		container.add(lblNome);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(119, 203, 70, 15);
		container.add(lblTelefone);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(119, 250, 70, 15);
		container.add(lblEmail);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(281, 159, 221, 19);
		container.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(281, 203, 221, 19);
		container.add(textFieldTelefone);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(281, 250, 221, 19);
		container.add(textFieldEmail);
		
		String[] options = {"Animador", "Banda"};
		dropTipoAnim = new JComboBox(options);
		dropTipoAnim.setBounds(281, 289, 125, 24);
		container.add(dropTipoAnim);
		
		lblTipoAnim = new JLabel("Tipo de Animacao");
		lblTipoAnim.setBounds(119, 294, 147, 15);
		container.add(lblTipoAnim);
		
		/* Configuracao do botao de voltar para o menu inicial */
		btnVoltar = new JButton("<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				container.removeAll();
				container.revalidate();
				container.repaint();
				menuInicial();
			}
		});
		btnVoltar.setBounds(12, 12, 44, 25);
		container.add(btnVoltar);
		
		btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			
			/* Callback para o o botao de cadastrar banda. Realiza a insercao no banco */
			public void actionPerformed(ActionEvent e) {
				
				String nome = textFieldNome.getText(); // pega o nome do animador
				String telefone = textFieldTelefone.getText(); // pega o telefone do animador
				String email = textFieldEmail.getText(); // pega o email do animador
				String tipoAnimacao = (String) dropTipoAnim.getSelectedItem(); // pega o tipo de animacao que o animador faz
				
				Animador.insert(nome, telefone, email, tipoAnimacao); // insere no banco
			}
		});
		btnCadastrar.setBounds(526, 313, 117, 25);
		container.add(btnCadastrar);
		
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
	
	/* Metodo que cria a tela de alteracao de animador */
	public void alterar() {
		container.setLayout(null);
		
		/* Criacao dos objetos swing para a interface da tela */
		lblTitulo = new JLabel("<html><body><center><h1>Tela de Alteracao de Animador</h1></center></body></html>");
		lblTitulo.setVerticalAlignment(SwingConstants.TOP);
		lblTitulo.setBounds(201, 12, 363, 71);
		container.add(lblTitulo);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(119, 134, 70, 15);
		container.add(lblNome);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(119, 203, 70, 15);
		container.add(lblTelefone);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(119, 250, 70, 15);
		container.add(lblEmail);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(281, 132, 221, 19);
		container.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(281, 203, 221, 19);
		container.add(textFieldTelefone);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(281, 250, 221, 19);
		container.add(textFieldEmail);
		
		dropTipoAnim = new JComboBox(options);
		dropTipoAnim.setBounds(281, 289, 125, 24);
		container.add(dropTipoAnim);
		
		lblTipoAnim = new JLabel("Tipo de Animacao");
		lblTipoAnim.setBounds(119, 294, 147, 15);
		container.add(lblTipoAnim);
		
		/* Configuracao do botao de voltar para o menu inicial */
		btnVoltar = new JButton("<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				container.removeAll();
				container.revalidate();
				container.repaint();
				menuInicial();
			}
		});
		btnVoltar.setBounds(12, 12, 44, 25);
		container.add(btnVoltar);
		
		btnCadastrar = new JButton("ALTERAR");
		btnCadastrar.addActionListener(new ActionListener() {
			
			/* Callback para o o botao de alterar animador. Realiza o update no banco */
			public void actionPerformed(ActionEvent e) {
				
				String nome = textFieldNome.getText(); // pega o nome do animador
				String telefone = textFieldTelefone.getText(); // pega o telefone do animador
				String email = textFieldEmail.getText();// pega o email do animador
				String tipoAnimacao = (String) dropTipoAnim.getSelectedItem(); // pega o tipo de animacao
				
				Animador.update(nome, telefone, email, tipoAnimacao); // atualiza o animador no banco
			}
		});
		btnCadastrar.setBounds(524, 312, 117, 25);
		container.add(btnCadastrar);
		
		/* Configuracao do botao de pesquisar animador */
		btnPesquisarAnimador = new JButton("Pesquisar Animador");
		btnPesquisarAnimador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldNome.getText();
				List<String> rs = Animador.select(nome);
				if (rs != null && rs.size() > 0) {
					textFieldTelefone.setText(rs.get(0)); // seta o campo de telefone
					textFieldEmail.setText(rs.get(1)); // seta o campo de email
					dropTipoAnim.setSelectedIndex(rs.get(2).equals(options[0])? 0 : 1); // seta o tipo de animacao escolhido
					
					changeVisibility(true);
					
				} else {
					
					/* Mensagem de erro de animador nao encontrado */
					textFieldTelefone.setText("");
					textFieldEmail.setText("");
					dropTipoAnim.setSelectedIndex(0);
					changeVisibility(false);	
					JOptionPane.showMessageDialog(null, "Animador nao encontrado");
				}
				
			}
		});
		btnPesquisarAnimador.setBounds(524, 129, 181, 25);
		container.add(btnPesquisarAnimador);
		
		textFieldNome.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e){}
			
			@Override
			public void focusGained(FocusEvent e) {
				changeVisibility(false);
			}
		});
		
		changeVisibility(false);
		
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
	
	/* Metodo que cria a tela de remocao de animador */
	public void remover() {
		container.setLayout(null);

		/* Criacao dos objetos swing para a interface da tela */
		lblTitulo = new JLabel("<html><body><center><h1>Tela de Remocao de Animador</h1></center></body></html>");
		lblTitulo.setVerticalAlignment(SwingConstants.TOP);
		lblTitulo.setBounds(201, 12, 363, 71);
		container.add(lblTitulo);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(119, 134, 70, 15);
		container.add(lblNome);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(119, 203, 70, 15);
		container.add(lblTelefone);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(119, 250, 70, 15);
		container.add(lblEmail);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(281, 132, 221, 19);
		container.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(281, 203, 221, 19);
		container.add(textFieldTelefone);
		textFieldTelefone.setEditable(false);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(281, 250, 221, 19);
		container.add(textFieldEmail);
		textFieldEmail.setEditable(false);
		
		dropTipoAnim = new JComboBox(options);
		dropTipoAnim.setBounds(281, 289, 125, 24);
		container.add(dropTipoAnim);
		dropTipoAnim.setEnabled(false);
		
		lblTipoAnim = new JLabel("Tipo de Animacao");
		lblTipoAnim.setBounds(119, 294, 147, 15);
		container.add(lblTipoAnim);
		
		/* Configura botao de voltar para o menu inicial */
		btnVoltar = new JButton("<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				container.removeAll();
				container.revalidate();
				container.repaint();
				menuInicial();
			}
		});
		btnVoltar.setBounds(12, 12, 44, 25);
		container.add(btnVoltar);
		
		/* Configura o botao de remocao de animador */
		btnCadastrar = new JButton("REMOVER");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldNome.getText(); // pega o nome do animador
				Animador.remove(nome); // remove do banco
				
			}
		});
		btnCadastrar.setBounds(524, 312, 117, 25);
		container.add(btnCadastrar);
		
		/* Configuracao do botao de pesquisar animador */
		btnPesquisarAnimador = new JButton("Pesquisar Animador");
		btnPesquisarAnimador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldNome.getText();
				List<String> rs = Animador.select(nome);
				if (rs != null && rs.size() > 0) {
					textFieldTelefone.setText(rs.get(0)); // seta o campo de telefone do animador
					textFieldEmail.setText(rs.get(1)); // seta o campo de email do animador
					dropTipoAnim.setSelectedIndex(rs.get(2).equals(options[0])? 0 : 1); // seta o tipo de animacao escolhido
					
					changeVisibility(true);
					
				} else {
					/* Mensagem de erro de animador nao encontrado */
					textFieldTelefone.setText("");
					textFieldEmail.setText("");
					dropTipoAnim.setSelectedIndex(0);
					changeVisibility(false);	
					JOptionPane.showMessageDialog(null, "Animador nao encontrado");
				}
				
			}
		});
		btnPesquisarAnimador.setBounds(524, 129, 181, 25);
		container.add(btnPesquisarAnimador);
		
		textFieldNome.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e){}
			
			@Override
			public void focusGained(FocusEvent e) {
				changeVisibility(false);
			}
		});
		
		changeVisibility(false);
		
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
