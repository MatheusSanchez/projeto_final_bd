package decoracao;

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

import main.Main;
import main.TelaInicio;

@SuppressWarnings("serial")
public class TelaDecoracaoCasamento extends JFrame {
	private JTextField textFieldTema;
	private JTextField textFieldQtdeFlores;
	private JTextField textFieldTipoFlor;
	
	private JLabel lblDigiteTodosOs;
	private JButton btnCadastrar;
	private JLabel lblTipoDeFlor;
	private JLabel lblQuantidadeDeFlores;
	
	private Container container;

	public TelaDecoracaoCasamento() {
		this.container = getContentPane();
	}

	public TelaDecoracaoCasamento(Container c) {
		this.container = c;
	}
	
	public void menuInicial() {
		container.setLayout(null);
	
		/* Configura botao que direciona para a tela de inserir decoracao Casamento */
		JButton btnInserir = new JButton("Inserir Decoracao Casamento");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				container.removeAll();
				container.revalidate();
				container.repaint();
				inserirDecoracaoCasamento();
			}
		});
		btnInserir.setBounds(275, 110, 215, 49);
		container.add(btnInserir);
		
		/* Configura botao que direciona para a tela de alterar decoracao Casamento */
		JButton btnAlterar = new JButton("Alterar Decoracao Casamento");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				container.revalidate();
				container.repaint();
				alterarDecoracaoCasamento();
			}
		});
		btnAlterar.setBounds(275, 199, 215, 49);
		container.add(btnAlterar);
		
		/* Configura botao que direciona para a tela de remover decoracao Casamento */
		JButton btnRemover = new JButton("Remover Decoracao Casamento");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				container.revalidate();
				container.repaint();
				apagarDecoracaoCasamento();
			}
		});
		btnRemover.setBounds(275, 288, 215, 49);
		container.add(btnRemover);
		
		JButton button = new JButton("<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.novaTela(container);
				TelaInicio t = new TelaInicio(container);
				t.atualizaBanco();
			}
		});
		button.setBounds(12, 12, 44, 25);
		container.add(button);
	}

	
	public void inserirDecoracaoCasamento() {
		container.setLayout(null);
		
		JLabel lblCadastroDeNova = new JLabel("Cadastro de decoracao de casamento");
		lblCadastroDeNova.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblCadastroDeNova.setBounds(64, 33, 409, 15);
		container.add(lblCadastroDeNova);
		
		JLabel lblTema = new JLabel("Tema");
		lblTema.setBounds(49, 114, 70, 15);
		container.add(lblTema);
		
		JLabel lblQuantidadeDeFlores = new JLabel("Quantidade de Flores");
		lblQuantidadeDeFlores.setBounds(49, 141, 153, 15);
		container.add(lblQuantidadeDeFlores);
		
		JLabel lblTipoDeFlor = new JLabel("Tipos de Flor");
		lblTipoDeFlor.setBounds(49, 168, 153, 15);
		container.add(lblTipoDeFlor);
		
		textFieldTema = new JTextField();
		textFieldTema.setBounds(230, 112, 140, 19);
		container.add(textFieldTema);
		textFieldTema.setColumns(10);
		
		textFieldQtdeFlores = new JTextField();
		textFieldQtdeFlores.setColumns(10);
		textFieldQtdeFlores.setBounds(230, 139, 140, 19);
		container.add(textFieldQtdeFlores);
		
		textFieldTipoFlor = new JTextField();
		textFieldTipoFlor.setToolTipText("tipo1, tipo2");
		textFieldTipoFlor.setColumns(10);
		textFieldTipoFlor.setBounds(230, 166, 140, 19);
		container.add(textFieldTipoFlor);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tema = textFieldTema.getText();
				String qtde = textFieldQtdeFlores.getText();
			
				String tipos[] = textFieldTipoFlor.getText().split(",");
				for (int i = 0; i < tipos.length; i++) {
					tipos[i] = tipos[i].trim();
				}
				
				DecoracaoCasamento.insert(tema, qtde, tipos);
			}
		});
		btnCadastrar.setBounds(356, 228, 117, 25);
		container.add(btnCadastrar);
		
		JLabel lblDigiteTodosOs = new JLabel("(Digite todos os tipos desejados separados por virgulas)");
		lblDigiteTodosOs.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblDigiteTodosOs.setBounds(49, 179, 308, 20);
		container.add(lblDigiteTodosOs);
		
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

	//altera a visibilidade de determiandos atributos de acordo com a flag
	private void changeVisibility(boolean flag) {
		lblDigiteTodosOs.setVisible(flag);
		textFieldTipoFlor.setVisible(flag);
		textFieldQtdeFlores.setVisible(flag);
		btnCadastrar.setVisible(flag);
		lblTipoDeFlor.setVisible(flag);
		lblQuantidadeDeFlores.setVisible(flag);
	}
	
	public void alterarDecoracaoCasamento() {
		container.setLayout(null);
		
		JLabel lblCadastroDeNova = new JLabel("Alteracao de decoracao de casamento");
		lblCadastroDeNova.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblCadastroDeNova.setBounds(64, 33, 409, 15);
		container.add(lblCadastroDeNova);
		
		JLabel lblTema = new JLabel("Tema");
		lblTema.setBounds(49, 77, 70, 15);
		container.add(lblTema);
		
		lblQuantidadeDeFlores = new JLabel("Quantidade de Flores");
		lblQuantidadeDeFlores.setBounds(49, 141, 153, 15);
		container.add(lblQuantidadeDeFlores);
		lblQuantidadeDeFlores.setVisible(false);
		
		lblTipoDeFlor = new JLabel("Tipos de Flor");
		lblTipoDeFlor.setBounds(49, 168, 153, 15);
		container.add(lblTipoDeFlor);
		lblTipoDeFlor.setVisible(false);
		
		textFieldTema = new JTextField();
		textFieldTema.setBounds(137, 77, 140, 19);
		container.add(textFieldTema);
		textFieldTema.setColumns(10);
		
		textFieldQtdeFlores = new JTextField();
		textFieldQtdeFlores.setColumns(10);
		textFieldQtdeFlores.setBounds(230, 139, 140, 19);
		container.add(textFieldQtdeFlores);
		textFieldQtdeFlores.setVisible(false);
		
		textFieldTipoFlor = new JTextField();
		textFieldTipoFlor.setToolTipText("tipo1, tipo2");
		textFieldTipoFlor.setColumns(10);
		textFieldTipoFlor.setBounds(230, 166, 140, 19);
		container.add(textFieldTipoFlor);
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
		container.add(btnCadastrar);
		btnCadastrar.setVisible(false);
		
		lblDigiteTodosOs = new JLabel("(Digite todos os tipos desejados separados por virgulas)");
		lblDigiteTodosOs.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblDigiteTodosOs.setBounds(49, 179, 308, 20);
		container.add(lblDigiteTodosOs);
		lblDigiteTodosOs.setVisible(false);
		
		//quando clica no campo de escrever o tema chama a funcao de alterar visibilidade
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
					
					changeVisibility(true); //mostra os campos com os valores buscados no banco
					
				} else {
					textFieldQtdeFlores.setText("");
					textFieldTipoFlor.setText("");
					changeVisibility(false);	
					JOptionPane.showMessageDialog(null, "Tema nao encontrado");
				}
			}
		});
		btnPesquisarPorTema.setBounds(289, 72, 184, 25);
		container.add(btnPesquisarPorTema);
		
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

	public void apagarDecoracaoCasamento() {
		container.setLayout(null);
		
		JLabel lblCadastroDeNova = new JLabel("Remocao de decoracao de casamento");
		lblCadastroDeNova.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblCadastroDeNova.setBounds(64, 33, 409, 15);
		container.add(lblCadastroDeNova);
		
		JLabel lblTema = new JLabel("Tema");
		lblTema.setBounds(49, 77, 70, 15);
		container.add(lblTema);
		
		lblQuantidadeDeFlores = new JLabel("Quantidade de Flores");
		lblQuantidadeDeFlores.setBounds(49, 141, 153, 15);
		container.add(lblQuantidadeDeFlores);
		lblQuantidadeDeFlores.setVisible(false);
		
		lblTipoDeFlor = new JLabel("Tipos de Flor");
		lblTipoDeFlor.setBounds(49, 168, 153, 15);
		container.add(lblTipoDeFlor);
		lblTipoDeFlor.setVisible(false);
		
		textFieldTema = new JTextField();
		textFieldTema.setBounds(137, 77, 140, 19);
		container.add(textFieldTema);
		textFieldTema.setColumns(10);
		
		textFieldQtdeFlores = new JTextField();
		textFieldQtdeFlores.setColumns(10);
		textFieldQtdeFlores.setBounds(230, 139, 140, 19);
		container.add(textFieldQtdeFlores);
		textFieldQtdeFlores.setVisible(false);
		textFieldQtdeFlores.setEditable(false);
		
		textFieldTipoFlor = new JTextField();
		textFieldTipoFlor.setColumns(10);
		textFieldTipoFlor.setBounds(230, 166, 140, 19);
		container.add(textFieldTipoFlor);
		textFieldTipoFlor.setVisible(false);
		textFieldTipoFlor.setEditable(false);
		
		btnCadastrar = new JButton("REMOVER");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//remove o tema e altera a visibilidade
				String tema = textFieldTema.getText();
				DecoracaoCasamento.remove(tema);
				changeVisibility(false);
			}
		});
		btnCadastrar.setBounds(356, 228, 117, 25);
		container.add(btnCadastrar);
		btnCadastrar.setVisible(false);
		
		lblDigiteTodosOs = new JLabel("(Digite todos os tipos desejados separados por virgulas)");
		lblDigiteTodosOs.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblDigiteTodosOs.setBounds(49, 179, 308, 20);
		container.add(lblDigiteTodosOs);
		lblDigiteTodosOs.setVisible(false);

		//quando clica no campo de escrever o tema chama a funcao de alterar visibilidade
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
				List<String> rs = DecoracaoCasamento.select(tema); //busca no banco pelo tema
				if (rs != null && rs.size() > 0) {
					textFieldQtdeFlores.setText(rs.get(0));
					String tipos = "";
					for (int i = 1; i < rs.size(); i++) {
						tipos += rs.get(i);
						if (i != rs.size() - 1) tipos += ", ";
					}
					textFieldTipoFlor.setSize(tipos.length() * 7, textFieldTipoFlor.getHeight());
					textFieldTipoFlor.setText(tipos);

					changeVisibility(true); //deixa visivel os campos atualizados com as infos buscadas no banco
					
				} else {
					textFieldQtdeFlores.setText("");
					textFieldTipoFlor.setText("");
					changeVisibility(false);	
					JOptionPane.showMessageDialog(null, "Tema nao encontrado");
				}
			}
		});
		btnPesquisarPorTema.setBounds(289, 72, 184, 25);
		container.add(btnPesquisarPorTema);
		
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
