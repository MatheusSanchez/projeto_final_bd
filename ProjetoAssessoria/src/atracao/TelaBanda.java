package atracao;

import java.awt.Container;
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

import main.Main;
import main.TelaInicio;

public class TelaBanda extends JFrame {
	
	/* Objetos usados pelo swing para a interface da tela */
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
	
	private Container container;

	public TelaBanda() {
		this.container = getContentPane();
	}

	public TelaBanda(Container c) {
		this.container = c;
	}
	
	public void menuInicial() {
		container.setLayout(null);
		
		
		/* Configura botao que direciona para a tela de inserir banda */
		JButton btnInserir = new JButton("Inserir Banda");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				container.removeAll();
				container.revalidate();
				container.repaint();
				inserir();
			}
		});
		btnInserir.setBounds(275, 110, 215, 49);
		container.add(btnInserir);
		
		/* Configura botao que direciona para a tela de alterar banda */
		JButton btnAlterar = new JButton("Alterar Banda");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				container.revalidate();
				container.repaint();
				alterar();
			}
		});
		btnAlterar.setBounds(275, 199, 215, 49);
		container.add(btnAlterar);
		
		/* Configura botao que direciona para a tela de remover banda */
		JButton btnRemover = new JButton("Remover Banda");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				container.revalidate();
				container.repaint();
				remover();
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
	
	
	/* Metodo usado para esconder ou revelar o formulario de insercao ou alteracao de banda */
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
	
	/* Metodo que cria a tela de insercao de banda */
	public void inserir() {
		container.setLayout(null);
		
		/* Criacao dos objetos swing para a interface da tela */
		lblTitulo = new JLabel("<html><body><center><h1>Tela de Insercao de Banda</h1></center></body></html>");
		lblTitulo.setVerticalAlignment(SwingConstants.TOP);
		lblTitulo.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblTitulo.setBounds(218, 12, 330, 78);
		container.add(lblTitulo);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(137, 154, 70, 15);
		container.add(lblNome);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(137, 193, 70, 15);
		container.add(lblTelefone);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(137, 232, 70, 15);
		container.add(lblEmail);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(262, 152, 205, 19);
		container.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(262, 191, 205, 19);
		container.add(textFieldTelefone);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(262, 230, 205, 19);
		container.add(textFieldEmail);
		
		lblIntegrantes = new JLabel("Integrantes");
		lblIntegrantes.setBounds(137, 274, 100, 15);
		container.add(lblIntegrantes);
		
		textFieldInteg = new JTextField();
		textFieldInteg.setColumns(10);
		textFieldInteg.setBounds(262, 272, 205, 19);
		container.add(textFieldInteg);
		
		lblDigiteTodosOs = new JLabel("(Digite todos os integrantes separados por virgulas)");
		lblDigiteTodosOs.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblDigiteTodosOs.setBounds(137, 303, 308, 20);
		container.add(lblDigiteTodosOs);
		
		btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			
			/* Callback para o o botao de cadastrar banda. Realiza a insercao no banco */
			public void actionPerformed(ActionEvent e) {
				
				String nome = textFieldNome.getText(); // pega o nome da banda
				String telefone = textFieldTelefone.getText(); // pega o telefone da banda 
				String email = textFieldEmail.getText(); // pega o email da banda
				String integrantes[] = textFieldInteg.getText().split(","); // pega os integrantes da banda, separando por virgulas
				for (int i = 0; i < integrantes.length; i++) {
					integrantes[i] = integrantes[i].trim();
				}
				
				Banda.insert(nome, telefone, email, integrantes); // insere no banco
			}
		});
		btnCadastrar.setBounds(515, 318, 117, 25);
		container.add(btnCadastrar);
		
		/* Configuracao do botao de voltar para o menu inicial */
		btnVoltar = new JButton("<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				container.revalidate();
				container.repaint();
				menuInicial();
			}
		});
		
		btnVoltar.setBounds(12, 12, 44, 25);
		container.add(btnVoltar);
		
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
	
	/* Metodo que cria a tela de alteracao de banda */
	public void alterar() {
		container.setLayout(null);
		
		/* Criacao dos objetos swing para a interface da tela */
		lblTitulo = new JLabel("<html><body><center><h1>Tela de Alteracao de Banda</h1></center></body></html>");
		lblTitulo.setVerticalAlignment(SwingConstants.TOP);
		lblTitulo.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblTitulo.setBounds(218, 12, 330, 78);
		container.add(lblTitulo);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(137, 137, 70, 15);
		container.add(lblNome);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(137, 193, 70, 15);
		container.add(lblTelefone);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(137, 232, 70, 15);
		container.add(lblEmail);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(262, 135, 205, 19);
		container.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(262, 191, 205, 19);
		container.add(textFieldTelefone);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(262, 230, 205, 19);
		container.add(textFieldEmail);
		
		lblIntegrantes = new JLabel("Integrantes");
		lblIntegrantes.setBounds(137, 274, 100, 15);
		container.add(lblIntegrantes);
		
		textFieldInteg = new JTextField();
		textFieldInteg.setColumns(10);
		textFieldInteg.setBounds(262, 272, 205, 19);
		container.add(textFieldInteg);
		
		lblDigiteTodosOs = new JLabel("(Digite todos os integrantes separados por virgulas)");
		lblDigiteTodosOs.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblDigiteTodosOs.setBounds(137, 303, 308, 20);
		container.add(lblDigiteTodosOs);
		
		btnCadastrar = new JButton("ALTERAR");
		btnCadastrar.addActionListener(new ActionListener() {
			
			/* Callback para o o botao de alterar banda. Realiza o update no banco */
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
		container.add(btnCadastrar);
		
		/* Configuracao do botao de voltar para o menu inicial */
		btnVoltar = new JButton("<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				container.revalidate();
				container.repaint();
				menuInicial();
			}
		});
		
		btnVoltar.setBounds(12, 12, 44, 25);
		container.add(btnVoltar);
		
		/* Configuracao do botao de pesquisar banda */
		btnPesquisar = new JButton("Pesquisar banda");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldNome.getText();
				List<String> rs = Banda.select(nome); // realiza um select no banco e retorna os dados da banda selecionada
				if (rs != null && rs.size() > 0) {
					textFieldTelefone.setText(rs.get(0)); // atualiza o texto do campo de telefone
					textFieldEmail.setText(rs.get(1)); // atualiza o texto do campo de email
					
					String integ = "";
					for (int i = 2; i < rs.size(); i++) {
						integ += rs.get(i);
						if (i != rs.size() - 1) integ += ", ";
					}
					textFieldInteg.setText(integ);
					
					
					changeVisibility(true);
					
				} else {
					
					// Mensagem de erro
					textFieldEmail.setText("");
					changeVisibility(false);	
					JOptionPane.showMessageDialog(null, "Banda nao encontrada");
				}
			}
		});
		btnPesquisar.setBounds(515, 132, 163, 25);
		container.add(btnPesquisar);
		
		changeVisibility(false);
		
		textFieldNome.addFocusListener(new FocusListener() {
			
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
	
	/* Metodo que cria a tela de remocao de banda */
	public void remover() {
		container.setLayout(null);
		
		/* Criacao dos objetos swing para a interface da tela */
		lblTitulo = new JLabel("<html><body><center><h1>Tela de Remocao de Banda</h1></center></body></html>");
		lblTitulo.setVerticalAlignment(SwingConstants.TOP);
		lblTitulo.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblTitulo.setBounds(218, 12, 330, 78);
		container.add(lblTitulo);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(137, 137, 70, 15);
		container.add(lblNome);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(137, 193, 70, 15);
		container.add(lblTelefone);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(137, 232, 70, 15);
		container.add(lblEmail);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(262, 135, 205, 19);
		container.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(262, 191, 205, 19);
		container.add(textFieldTelefone);
		textFieldTelefone.setEditable(false);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(262, 230, 205, 19);
		container.add(textFieldEmail);
		textFieldEmail.setEditable(false);
		
		lblIntegrantes = new JLabel("Integrantes");
		lblIntegrantes.setBounds(137, 274, 100, 15);
		container.add(lblIntegrantes);
		
		
		textFieldInteg = new JTextField();
		textFieldInteg.setColumns(10);
		textFieldInteg.setBounds(262, 272, 205, 19);
		container.add(textFieldInteg);
		textFieldInteg.setEditable(false);
		
		lblDigiteTodosOs = new JLabel("(Digite todos os integrantes separados por virgulas)");
		lblDigiteTodosOs.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblDigiteTodosOs.setBounds(137, 303, 308, 20);
		container.add(lblDigiteTodosOs);
		
		btnCadastrar = new JButton("REMOVER");
		btnCadastrar.addActionListener(new ActionListener() {
			
			/* Callback do botao de remover, que realiza a remocao da banda do banco*/
			public void actionPerformed(ActionEvent e) {
				
				String nome = textFieldNome.getText();
				Banda.remove(nome);
			}
		});
		btnCadastrar.setBounds(515, 318, 117, 25);
		container.add(btnCadastrar);
		
		/* Configura o botao de voltar para o menu inicial */
		btnVoltar = new JButton("<");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				container.revalidate();
				container.repaint();
				menuInicial();
			}
		});
		
		btnVoltar.setBounds(12, 12, 44, 25);
		container.add(btnVoltar);
		
		/* Configura o botao de selecionar a banda */
		btnPesquisar = new JButton("Pesquisar banda");
		btnPesquisar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldNome.getText();
				List<String> rs = Banda.select(nome); // realiza um select no banco da banda
				if (rs != null && rs.size() > 0) {
					textFieldTelefone.setText(rs.get(0)); // seta o texto do telefone da banda
					textFieldEmail.setText(rs.get(1)); // seta o campo de email da banda
					
					/* Seta o campo de integrantes da banda */
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
		container.add(btnPesquisar);
		
		changeVisibility(false);
		
		textFieldNome.addFocusListener(new FocusListener() {
			
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
