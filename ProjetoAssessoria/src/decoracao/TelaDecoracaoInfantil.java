package decoracao;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.Main;
import main.TelaInicio;

@SuppressWarnings("serial")
public class TelaDecoracaoInfantil extends JFrame {
	private JTextField textFieldTema;
	private JTextField textFieldQtdeBaloes;
	
	JCheckBox chckbxPinata;
	private JButton btnCadastrar;
	private JLabel lblQtdeBaloes;
	private JLabel lblCadastroDeNovaDecoracaoInfantil;
	private JLabel lblTema;
	private JLabel lblQtdBaloes;
	private JTextField textFieldCorBaloes;
	private JLabel lblDigiteTodosOs;
	private JLabel lblCorBaloes;
	
	private Container container;

	public TelaDecoracaoInfantil() {
		this.container = getContentPane();
	}
	
	public TelaDecoracaoInfantil(Container c) {
		this.container = c;
	}
	
	public void menuInicial() {
		container.setLayout(null);
	
		/* Configura botao que direciona para a tela de inserir decoracao infantil */
		JButton btnInserir = new JButton("Inserir Decoracao Infantil");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				container.removeAll();
				container.revalidate();
				container.repaint();
				inserirDecoracaoInfantil();
			}
		});
		btnInserir.setBounds(275, 110, 215, 49);
		container.add(btnInserir);
		
		/* Configura botao que direciona para a tela de alterar decoracao infantil */
		JButton btnAlterar = new JButton("Alterar Decoracao Infantil");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				container.revalidate();
				container.repaint();
				alterarDecoracaoInfantil();
			}
		});
		btnAlterar.setBounds(275, 199, 215, 49);
		container.add(btnAlterar);
		
		/* Configura botao que direciona para a tela de remover decoracao infantil */
		JButton btnRemover = new JButton("Remover Decoracao Infantil");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				container.revalidate();
				container.repaint();
				removerDecoracaoInfantil();
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

	public void inserirDecoracaoInfantil() {
		container.setLayout(null);
		
		lblCadastroDeNovaDecoracaoInfantil = new JLabel("<html> <center> <p>Cadastro de decoracao de Aniversario Infantil</p> </center> </html>");
		lblCadastroDeNovaDecoracaoInfantil.setVerticalAlignment(SwingConstants.TOP);
		lblCadastroDeNovaDecoracaoInfantil.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblCadastroDeNovaDecoracaoInfantil.setBounds(63, 16, 345, 69);
		container.add(lblCadastroDeNovaDecoracaoInfantil);
		
		lblTema = new JLabel("Tema");
		lblTema.setBounds(49, 81, 70, 15);
		container.add(lblTema);
		
		lblQtdBaloes = new JLabel("Quantidade de Baloes");
		lblQtdBaloes.setBounds(49, 108, 153, 15);
		container.add(lblQtdBaloes);
		
		textFieldTema = new JTextField();
		textFieldTema.setBounds(230, 79, 140, 19);
		container.add(textFieldTema);
		textFieldTema.setColumns(10);
		
		textFieldQtdeBaloes = new JTextField();
		textFieldQtdeBaloes.setColumns(10);
		textFieldQtdeBaloes.setBounds(230, 106, 140, 19);
		container.add(textFieldQtdeBaloes);
		
		lblCorBaloes= new JLabel("Cores dos baloes");
		lblCorBaloes.setBounds(49, 162, 153, 15);
		container.add(lblCorBaloes);
		
		textFieldCorBaloes= new JTextField();
		textFieldCorBaloes.setToolTipText("cor1, cor2");
		textFieldCorBaloes.setColumns(10);
		textFieldCorBaloes.setBounds(230, 160, 140, 19);
		container.add(textFieldCorBaloes);
		
		lblDigiteTodosOs = new JLabel("(Digite todas as cores desejadas separadas por virgulas)");
		lblDigiteTodosOs.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblDigiteTodosOs.setBounds(49, 179, 308, 20);
		container.add(lblDigiteTodosOs);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tema = textFieldTema.getText();
				String qtdeBaloes = textFieldQtdeBaloes.getText();
				boolean pinata = chckbxPinata.isSelected(); 
				
				String cores[] = textFieldCorBaloes.getText().split(",");
				for (int i = 0; i < cores.length; i++) {
					cores[i] = cores[i].trim();
				}
				
				//insere no banco
				DecoracaoInfantil.insert(tema, qtdeBaloes, pinata, cores);
			}
		});
		btnCadastrar.setBounds(356, 228, 117, 25);
		container.add(btnCadastrar);
		
		chckbxPinata = new JCheckBox("Pinata");
		chckbxPinata.setBounds(49, 131, 128, 23);
		container.add(chckbxPinata);
		
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

	private void changeVisibility(boolean flag) {
		textFieldQtdeBaloes.setVisible(flag);
		btnCadastrar.setVisible(flag);
		lblQtdeBaloes.setVisible(flag);
		lblCorBaloes.setVisible(flag);
		chckbxPinata.setVisible(flag);
		textFieldCorBaloes.setVisible(flag);
		lblDigiteTodosOs.setVisible(flag);
	}
	
	public void alterarDecoracaoInfantil() {
		container.setLayout(null);
		
		JLabel lblAltTitle = new JLabel("<html><center>Alteracao de decoracao de Aniversario Infantil</center></html>");
		lblAltTitle.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblAltTitle.setBounds(35, 6, 409, 74);
		container.add(lblAltTitle);
		
		lblTema = new JLabel("Tema");
		lblTema.setBounds(49, 77, 70, 15);
		container.add(lblTema);
		
		lblQtdeBaloes = new JLabel("Quantidade de Baloes");
		lblQtdeBaloes.setBounds(49, 130, 153, 15);
		container.add(lblQtdeBaloes);
		lblQtdeBaloes.setVisible(false);
		
		textFieldTema = new JTextField();
		textFieldTema.setBounds(137, 77, 140, 19);
		container.add(textFieldTema);
		textFieldTema.setColumns(10);
		
		textFieldQtdeBaloes = new JTextField();
		textFieldQtdeBaloes.setColumns(10);
		textFieldQtdeBaloes.setBounds(230, 127, 140, 19);
		container.add(textFieldQtdeBaloes);
		textFieldQtdeBaloes.setVisible(false);
		
		lblCorBaloes= new JLabel("Cores dos baloes");
		lblCorBaloes.setBounds(49, 168, 153, 15);
		container.add(lblCorBaloes);
		
		textFieldCorBaloes= new JTextField();
		textFieldCorBaloes.setToolTipText("cor1, cor2");
		textFieldCorBaloes.setColumns(10);
		textFieldCorBaloes.setBounds(230, 165, 140, 19);
		container.add(textFieldCorBaloes);
		
		lblDigiteTodosOs = new JLabel("(Digite todas as cores desejadas separadas por virgulas)");
		lblDigiteTodosOs.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblDigiteTodosOs.setBounds(49, 183, 308, 20);
		container.add(lblDigiteTodosOs);
		
		chckbxPinata = new JCheckBox("Piñata");
		chckbxPinata.setBounds(49, 215, 128, 23);
		container.add(chckbxPinata);
		
		btnCadastrar = new JButton("ALTERAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tema = textFieldTema.getText();
				String qtde = textFieldQtdeBaloes.getText();
				String pinata = chckbxPinata.isSelected()? "1" : "0";
				String cores[] = textFieldCorBaloes.getText().split(",");
				for (int i = 0; i < cores.length; i++) {
					cores[i] = cores[i].trim();
				}
				
				String[] form = new String[3 + cores.length];
			
				form[0] = tema;
				form[1] = qtde;
				form[2] = pinata;
				
				for (int i = 3; i < 3 + cores.length; i++) {
					form[i] = cores[i - 3];
				}

				//atualiza o banco
				DecoracaoInfantil.update(form);
			}
		});
		btnCadastrar.setBounds(356, 228, 117, 25);
		container.add(btnCadastrar);
		btnCadastrar.setVisible(false);
		
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
				List<String> rs = DecoracaoInfantil.select(tema);
				if (rs != null && rs.size() > 0) {
					textFieldQtdeBaloes.setText(rs.get(0));
					
					chckbxPinata.setSelected(rs.get(1).equals("1")? true : false);
					String cores = "";
					for (int i = 2; i < rs.size(); i++) {
						cores += rs.get(i);
						if (i != rs.size() - 1) cores += ", ";
					}

					textFieldCorBaloes.setText(cores);
					changeVisibility(true); //mostra os campos com valores buscados no banco
					
				} else {
					textFieldQtdeBaloes.setText("");
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

	public void removerDecoracaoInfantil() {
		container.setLayout(null);
		
		JLabel lblAltTitle = new JLabel("<html><center>Remocao de decoracao de Aniversario Infantil</center></html>");
		lblAltTitle.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblAltTitle.setBounds(35, 6, 409, 74);
		container.add(lblAltTitle);
		
		lblTema = new JLabel("Tema");
		lblTema.setBounds(49, 77, 70, 15);
		container.add(lblTema);
		
		lblQtdeBaloes = new JLabel("Quantidade de Baloes");
		lblQtdeBaloes.setBounds(49, 130, 153, 15);
		container.add(lblQtdeBaloes);
		lblQtdeBaloes.setVisible(false);
		
		textFieldTema = new JTextField();
		textFieldTema.setBounds(137, 77, 140, 19);
		container.add(textFieldTema);
		textFieldTema.setColumns(10);
		
		textFieldQtdeBaloes = new JTextField();
		textFieldQtdeBaloes.setColumns(10);
		textFieldQtdeBaloes.setBounds(230, 127, 140, 19);
		container.add(textFieldQtdeBaloes);
		textFieldQtdeBaloes.setVisible(false);
		textFieldQtdeBaloes.setEditable(false);
		
		lblCorBaloes= new JLabel("Cores dos baloes");
		lblCorBaloes.setBounds(49, 168, 153, 15);
		container.add(lblCorBaloes);
		
		textFieldCorBaloes= new JTextField();
		textFieldCorBaloes.setToolTipText("cor1, cor2");
		textFieldCorBaloes.setColumns(10);
		textFieldCorBaloes.setBounds(230, 165, 140, 19);
		container.add(textFieldCorBaloes);
		textFieldCorBaloes.setEditable(false);
		
		lblDigiteTodosOs = new JLabel("(Digite todas as cores desejadas separadas por virgulas)");
		lblDigiteTodosOs.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblDigiteTodosOs.setBounds(49, 183, 308, 20);
		container.add(lblDigiteTodosOs);
		
		chckbxPinata = new JCheckBox("Piñata");
		chckbxPinata.setBounds(49, 215, 128, 23);
		chckbxPinata.setEnabled(false);
		container.add(chckbxPinata);
		
		btnCadastrar = new JButton("REMOVER");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tema = textFieldTema.getText();
				DecoracaoInfantil.remove(tema);
				changeVisibility(false);
			}
		});
		btnCadastrar.setBounds(356, 228, 117, 25);
		container.add(btnCadastrar);
		btnCadastrar.setVisible(false);
		
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
				List<String> rs = DecoracaoInfantil.select(tema);
				if (rs != null && rs.size() > 0) {
					textFieldQtdeBaloes.setText(rs.get(0));
					
					chckbxPinata.setSelected(rs.get(1).equals("1")? true : false);
					String cores = "";
					for (int i = 2; i < rs.size(); i++) {
						cores += rs.get(i);
						if (i != rs.size() - 1) cores += ", ";
					}

					textFieldCorBaloes.setText(cores);
					changeVisibility(true); //mostra todos os campos com os valores buscados no banco e nao deixa editar
				} else {
					textFieldQtdeBaloes.setText("");
					textFieldCorBaloes.setText("");
					chckbxPinata.setSelected(false);
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
