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
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class TelaDecoracaoInfantil extends JFrame {
	private JTextField textFieldTema;
	private JTextField textFieldQtdeBaloes;
	
	JCheckBox chckbxPinata;
	private JLabel lblDigiteTodosOs;
	private JButton btnCadastrar;
	private JLabel lblTipoDeFlor;
	private JLabel lblQuantidadeDeFlores;
	
	public TelaDecoracaoInfantil() {
		inserirDecoracaoInfantil();
		//alterarDecoracaoCasamento();
		//removerDecoracaoCasamento();
	}
	public void inserirDecoracaoInfantil() {
		getContentPane().setLayout(null);
		
		JLabel lblCadastroDeNovaDecoracaoInfantil = new JLabel("<html> <center> <p>Cadastro de decoracao de Aniversário Infantil</p> </center> </html>");
		lblCadastroDeNovaDecoracaoInfantil.setVerticalAlignment(SwingConstants.TOP);
		lblCadastroDeNovaDecoracaoInfantil.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblCadastroDeNovaDecoracaoInfantil.setBounds(63, 16, 345, 69);
		getContentPane().add(lblCadastroDeNovaDecoracaoInfantil);
		
		JLabel lblTema = new JLabel("Tema");
		lblTema.setBounds(49, 81, 70, 15);
		getContentPane().add(lblTema);
		
		JLabel lblQtdBaloes = new JLabel("Quantidade de Balões");
		lblQtdBaloes.setBounds(49, 108, 153, 15);
		getContentPane().add(lblQtdBaloes);
		
		textFieldTema = new JTextField();
		textFieldTema.setBounds(230, 79, 140, 19);
		getContentPane().add(textFieldTema);
		textFieldTema.setColumns(10);
		
		textFieldQtdeBaloes = new JTextField();
		textFieldQtdeBaloes.setColumns(10);
		textFieldQtdeBaloes.setBounds(230, 106, 140, 19);
		getContentPane().add(textFieldQtdeBaloes);
		
		JLabel lblCorBaloes= new JLabel("Cores dos baloes");
		lblCorBaloes.setBounds(49, 162, 153, 15);
		getContentPane().add(lblCorBaloes);
		
		JTextField textFieldCorBaloes= new JTextField();
		textFieldCorBaloes.setToolTipText("cor1, cor2");
		textFieldCorBaloes.setColumns(10);
		textFieldCorBaloes.setBounds(230, 160, 140, 19);
		getContentPane().add(textFieldCorBaloes);
		
		JLabel lblDigiteTodosOs = new JLabel("(Digite todas as cores desejadas separadas por virgulas)");
		lblDigiteTodosOs.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblDigiteTodosOs.setBounds(49, 179, 308, 20);
		getContentPane().add(lblDigiteTodosOs);
		
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
				
				boolean ok = DecoracaoInfantil.insert(tema, qtdeBaloes, pinata, cores);
			}
		});
		btnCadastrar.setBounds(356, 228, 117, 25);
		getContentPane().add(btnCadastrar);
		
		chckbxPinata = new JCheckBox("Pinata");
		chckbxPinata.setBounds(49, 131, 128, 23);
		getContentPane().add(chckbxPinata);
		
	}

	private void changeVisibility(boolean flag) {
		lblDigiteTodosOs.setVisible(flag);
		textFieldQtdeBaloes.setVisible(flag);
		btnCadastrar.setVisible(flag);
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
		
		textFieldQtdeBaloes = new JTextField();
		textFieldQtdeBaloes.setColumns(10);
		textFieldQtdeBaloes.setBounds(230, 139, 140, 19);
		getContentPane().add(textFieldQtdeBaloes);
		textFieldQtdeBaloes.setVisible(false);
		
		
		btnCadastrar = new JButton("ALTERAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tema = textFieldTema.getText();
				String qtde = textFieldQtdeBaloes.getText();

				//DecoracaoCasamento.update(form);
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
					textFieldQtdeBaloes.setText(rs.get(0));
					String tipos = "";
					for (int i = 1; i < rs.size(); i++) {
						tipos += rs.get(i);
						if (i != rs.size() - 1) tipos += ", ";
					}
					
					changeVisibility(true);
					
				} else {
					textFieldQtdeBaloes.setText("");
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
		
		textFieldQtdeBaloes = new JTextField();
		textFieldQtdeBaloes.setColumns(10);
		textFieldQtdeBaloes.setBounds(230, 139, 140, 19);
		getContentPane().add(textFieldQtdeBaloes);
		textFieldQtdeBaloes.setVisible(false);
		textFieldQtdeBaloes.setEditable(false);
		
		
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
					textFieldQtdeBaloes.setText(rs.get(0));
					String tipos = "";
					for (int i = 1; i < rs.size(); i++) {
						tipos += rs.get(i);
						if (i != rs.size() - 1) tipos += ", ";
					}
					//textFieldTipoFlor.repaint();

					changeVisibility(true);
					
				} else {
					textFieldQtdeBaloes.setText("");
					changeVisibility(false);	
					JOptionPane.showMessageDialog(null, "Tema nao encontrado");
				}
			}
		});
		btnPesquisarPorTema.setBounds(289, 72, 184, 25);
		getContentPane().add(btnPesquisarPorTema);
		
	}
}
