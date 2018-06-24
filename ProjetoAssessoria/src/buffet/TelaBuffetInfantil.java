package buffet;

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
public class TelaBuffetInfantil {
	private JTextField textFieldCnpj;
	private JTextField textFieldNome;
	private JTextField textFieldRua;
	private JTextField textFieldNumero;
	private JTextField textFieldCep;
	private JTextField textFieldCap;
	private JLabel lblCadastroDeBuffet;
	private JLabel lblCnpj;
	private JLabel lblNome;
	private JLabel lblRua;
	private JLabel lblNumero;
	private JLabel lblCep;
	private JLabel lblCapacidade;
	private JButton btnCadastrar;
	private JTextField textFieldBrinquedos;
	private JLabel lblBrinquedos;

	private Container container;

	public TelaBuffetInfantil() {
	}

	public TelaBuffetInfantil(Container c) {
		this.container = c;
	}
	
	public void menuInicial() {
		container.setLayout(null);
	
		/* Configura botao que direciona para a tela de inserir buffet Infantil */
		JButton btnInserir = new JButton("Inserir Buffet Infantil");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				container.removeAll();
				container.revalidate();
				container.repaint();
				cadastrarBuffetInfantil();
			}
		});
		btnInserir.setBounds(275, 110, 215, 49);
		container.add(btnInserir);
		
		/* Configura botao que direciona para a tela de alterar Buffet Casamento */
		JButton btnAlterar = new JButton("Alterar Buffet Infantil");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				container.revalidate();
				container.repaint();
				alterarBuffetInfantil();
			}
		});
		btnAlterar.setBounds(275, 199, 215, 49);
		container.add(btnAlterar);
		
		/* Configura botao que direciona para a tela de remover Buffet Infantil */
		JButton btnRemover = new JButton("Remover Buffet Infantil");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				container.removeAll();
				container.revalidate();
				container.repaint();
				removerBuffetInfantil();
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

	
	private void changeVisibility(boolean flag) {
		textFieldNome.setVisible(flag);
		textFieldRua.setVisible(flag);
		textFieldNumero.setVisible(flag);
		textFieldCep.setVisible(flag);
		textFieldCap.setVisible(flag);
		lblCadastroDeBuffet.setVisible(flag);
		lblNome.setVisible(flag);
		lblRua.setVisible(flag);
		lblNumero.setVisible(flag);
		lblCep.setVisible(flag);
		lblCapacidade.setVisible(flag);
		btnCadastrar.setVisible(flag);
		lblBrinquedos.setVisible(flag);
		textFieldBrinquedos.setVisible(flag);
	}
	
	public void cadastrarBuffetInfantil() {
		container.setLayout(null);
		
		lblCadastroDeBuffet = new JLabel("Cadastro de Buffet Infantil");
		lblCadastroDeBuffet.setBounds(89, 12, 282, 15);
		container.add(lblCadastroDeBuffet);
		
		lblCnpj = new JLabel("CNPJ");
		lblCnpj.setToolTipText("99.999.999/9999-99");
		lblCnpj.setBounds(29, 60, 70, 15);
		container.add(lblCnpj);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(29, 87, 70, 15);
		container.add(lblNome);
		
		lblRua = new JLabel("Rua");
		lblRua.setBounds(29, 114, 70, 15);
		container.add(lblRua);
		
		lblNumero = new JLabel("Numero");
		lblNumero.setBounds(29, 141, 70, 15);
		container.add(lblNumero);
		
		lblCep = new JLabel("CEP");
		lblCep.setBounds(29, 168, 70, 15);
		container.add(lblCep);
		
		lblCapacidade = new JLabel("Capacidade");
		lblCapacidade.setBounds(29, 195, 89, 15);
		container.add(lblCapacidade);
		
		textFieldCnpj = new JTextField();
		textFieldCnpj.setToolTipText("99.999.999/9999-99");
		textFieldCnpj.setBounds(177, 58, 114, 19);
		container.add(textFieldCnpj);
		textFieldCnpj.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(177, 85, 114, 19);
		container.add(textFieldNome);
		
		textFieldRua = new JTextField();
		textFieldRua.setColumns(10);
		textFieldRua.setBounds(177, 112, 114, 19);
		container.add(textFieldRua);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(177, 139, 114, 19);
		container.add(textFieldNumero);
		
		textFieldCep = new JTextField();
		textFieldCep.setColumns(10);
		textFieldCep.setBounds(177, 166, 114, 19);
		container.add(textFieldCep);
		
		textFieldCap = new JTextField();
		textFieldCap.setColumns(10);
		textFieldCap.setBounds(177, 193, 114, 19);
		container.add(textFieldCap);
		
		btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s[] = new String[6];
				s[0] = textFieldCnpj.getText();
				s[1] = textFieldNome.getText();
				s[2] = textFieldRua.getText();
				s[3] = textFieldNumero.getText();
				s[4] = textFieldCep.getText();
				s[5] = textFieldCap.getText();
				
				String[] brinquedos = textFieldBrinquedos.getText().split(",");
				
				for (int i = 0; i < brinquedos.length; i++) {
					brinquedos[i] = brinquedos[i].trim();
				}
				
				BuffetInfantil.insert(s, brinquedos);
			}
		});
		btnCadastrar.setBounds(321, 224, 117, 25);
		container.add(btnCadastrar);
		
		lblBrinquedos = new JLabel("Brinquedos");
		lblBrinquedos.setBounds(29, 218, 89, 15);
		container.add(lblBrinquedos);
		
		textFieldBrinquedos = new JTextField();
		textFieldBrinquedos.setColumns(10);
		textFieldBrinquedos.setBounds(177, 216, 114, 19);
		container.add(textFieldBrinquedos);
		
		JLabel lbldigiteTodosOs = new JLabel("(Digite todos os brinquedos separados por virgulas)");
		lbldigiteTodosOs.setFont(new Font("Dialog", Font.PLAIN, 9));
		lbldigiteTodosOs.setBounds(29, 231, 312, 15);
		container.add(lbldigiteTodosOs);
		
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

	public void alterarBuffetInfantil() {
		container.setLayout(null);
		
		lblCadastroDeBuffet = new JLabel("Alteracao de Buffet Infantil");
		lblCadastroDeBuffet.setBounds(89, 12, 282, 15);
		container.add(lblCadastroDeBuffet);
		
		lblCnpj = new JLabel("CNPJ");
		lblCnpj.setToolTipText("99.999.999/9999-99");
		lblCnpj.setBounds(29, 60, 70, 15);
		container.add(lblCnpj);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(29, 112, 70, 15);
		container.add(lblNome);
		
		lblRua = new JLabel("Rua");
		lblRua.setBounds(29, 139, 70, 15);
		container.add(lblRua);
		
		lblNumero = new JLabel("Numero");
		lblNumero.setBounds(29, 166, 70, 15);
		container.add(lblNumero);
		
		lblCep = new JLabel("CEP");
		lblCep.setBounds(29, 193, 70, 15);
		container.add(lblCep);
		
		lblCapacidade = new JLabel("Capacidade");
		lblCapacidade.setBounds(29, 220, 89, 15);
		container.add(lblCapacidade);
		
		textFieldCnpj = new JTextField();
		textFieldCnpj.setToolTipText("99.999.999/9999-99");
		textFieldCnpj.setBounds(177, 58, 114, 19);
		container.add(textFieldCnpj);
		textFieldCnpj.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(177, 110, 114, 19);
		container.add(textFieldNome);
		
		textFieldRua = new JTextField();
		textFieldRua.setColumns(10);
		textFieldRua.setBounds(177, 137, 114, 19);
		container.add(textFieldRua);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(177, 164, 114, 19);
		container.add(textFieldNumero);
		
		textFieldCep = new JTextField();
		textFieldCep.setColumns(10);
		textFieldCep.setBounds(177, 191, 114, 19);
		container.add(textFieldCep);
		
		textFieldCap = new JTextField();
		textFieldCap.setColumns(10);
		textFieldCap.setBounds(177, 218, 114, 19);
		container.add(textFieldCap);
		
		lblBrinquedos = new JLabel("Brinquedos");
		lblBrinquedos.setBounds(29, 247, 89, 15);
		container.add(lblBrinquedos);
		
		textFieldBrinquedos = new JTextField();
		textFieldBrinquedos.setColumns(10);
		textFieldBrinquedos.setBounds(177, 245, 114, 19);
		container.add(textFieldBrinquedos);
		
		btnCadastrar = new JButton("ALTERAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s[] = new String[6];
				s[0] = textFieldCnpj.getText();
				s[1] = textFieldNome.getText();
				s[2] = textFieldRua.getText();
				s[3] = textFieldNumero.getText();
				s[4] = textFieldCep.getText();
				s[5] = textFieldCap.getText();
				
				String brinquedos[] = textFieldBrinquedos.getText().split(",");
				
				for (int i = 0; i < brinquedos.length; i++) brinquedos[i] = brinquedos[i].trim();
				
				BuffetInfantil.update(s, brinquedos);
			}
		});
		btnCadastrar.setBounds(321, 224, 117, 25);
		container.add(btnCadastrar);
		
		JButton btnBuscarPorCnpj = new JButton("Buscar por CNPJ");
		btnBuscarPorCnpj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List <String> s = BuffetInfantil.select(textFieldCnpj.getText());
				
				if (s != null) {
					textFieldNome.setText(s.get(1));
					textFieldRua.setText(s.get(2));
					textFieldNumero.setText(s.get(3));
					textFieldCep.setText(s.get(4));
					textFieldCap.setText(s.get(5));
					
					String brinq = "";
					for (int i = 6; i < s.size(); i++) {
						brinq += s.get(i);
						if (i != s.size() - 1) brinq += ", ";
					}
					changeVisibility(true);
					
					textFieldBrinquedos.setText(brinq);
				}
				else {
					changeVisibility(false);
					JOptionPane.showMessageDialog(null, "Buffet nao encontrado");
				}
			}
		});
		btnBuscarPorCnpj.setBounds(321, 55, 163, 25);
		container.add(btnBuscarPorCnpj);
		
		textFieldCnpj.addFocusListener(new FocusListener() {
			
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


	public void removerBuffetInfantil() {
		container.setLayout(null);
		
		lblCadastroDeBuffet = new JLabel("Remocao de Buffet Infantil");
		lblCadastroDeBuffet.setBounds(89, 12, 282, 15);
		container.add(lblCadastroDeBuffet);
		
		lblCnpj = new JLabel("CNPJ");
		lblCnpj.setToolTipText("99.999.999/9999-99");
		lblCnpj.setBounds(29, 60, 70, 15);
		container.add(lblCnpj);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(29, 112, 70, 15);
		container.add(lblNome);
		
		lblRua = new JLabel("Rua");
		lblRua.setBounds(29, 139, 70, 15);
		container.add(lblRua);
		
		lblNumero = new JLabel("Numero");
		lblNumero.setBounds(29, 166, 70, 15);
		container.add(lblNumero);
		
		lblCep = new JLabel("CEP");
		lblCep.setBounds(29, 193, 70, 15);
		container.add(lblCep);
		
		lblCapacidade = new JLabel("Capacidade");
		lblCapacidade.setBounds(29, 220, 89, 15);
		container.add(lblCapacidade);
		
		textFieldCnpj = new JTextField();
		textFieldCnpj.setToolTipText("99.999.999/9999-99");
		textFieldCnpj.setBounds(177, 58, 114, 19);
		container.add(textFieldCnpj);
		textFieldCnpj.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(177, 110, 114, 19);
		container.add(textFieldNome);
		
		textFieldRua = new JTextField();
		textFieldRua.setColumns(10);
		textFieldRua.setBounds(177, 137, 114, 19);
		container.add(textFieldRua);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(177, 164, 114, 19);
		container.add(textFieldNumero);
		
		textFieldCep = new JTextField();
		textFieldCep.setColumns(10);
		textFieldCep.setBounds(177, 191, 114, 19);
		container.add(textFieldCep);
		
		textFieldCap = new JTextField();
		textFieldCap.setColumns(10);
		textFieldCap.setBounds(177, 218, 114, 19);
		container.add(textFieldCap);
		
		lblBrinquedos = new JLabel("Brinquedos");
		lblBrinquedos.setBounds(29, 247, 89, 15);
		container.add(lblBrinquedos);
		
		textFieldBrinquedos = new JTextField();
		textFieldBrinquedos.setColumns(10);
		textFieldBrinquedos.setBounds(177, 245, 114, 19);
		container.add(textFieldBrinquedos);
		
		btnCadastrar = new JButton("REMOVER");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuffetInfantil.remove(textFieldCnpj.getText());
			}
		});
		btnCadastrar.setBounds(321, 242, 117, 25);
		container.add(btnCadastrar);
		
		JButton btnBuscarPorCnpj = new JButton("Buscar por CNPJ");
		btnBuscarPorCnpj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> s = BuffetInfantil.select(textFieldCnpj.getText());
				
				if (s != null) {
					textFieldNome.setText(s.get(1));
					textFieldNome.setEditable(false);
					textFieldRua.setText(s.get(2));
					textFieldRua.setEditable(false);
					textFieldNumero.setText(s.get(3));
					textFieldNumero.setEditable(false);
					textFieldCep.setText(s.get(4));
					textFieldCep.setEditable(false);
					textFieldCap.setText(s.get(5));
					textFieldCap.setEditable(false);
					
					String brinq = "";
					for (int i = 6; i < s.size(); i++) {
						brinq += s.get(i);
						if (i != s.size() - 1) brinq += ", ";
					}
					changeVisibility(true);
					
					textFieldBrinquedos.setText(brinq);
					textFieldBrinquedos.setEditable(false);
					
					changeVisibility(true);
				}
				else {
					changeVisibility(false);
					JOptionPane.showMessageDialog(null, "Buffet nao encontrado");
				}
			}
		});
		btnBuscarPorCnpj.setBounds(321, 55, 163, 25);
		container.add(btnBuscarPorCnpj);
		
		textFieldCnpj.addFocusListener(new FocusListener() {
			
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
