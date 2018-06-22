package buffet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TelaBuffetCasamento extends JFrame {
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

	public TelaBuffetCasamento() {
		cadastrarBuffetCasamento();
	}

	public void cadastrarBuffetCasamento() {
		getContentPane().setLayout(null);
		
		lblCadastroDeBuffet = new JLabel("Cadastro de Buffet de Casamento");
		lblCadastroDeBuffet.setBounds(89, 12, 282, 15);
		getContentPane().add(lblCadastroDeBuffet);
		
		lblCnpj = new JLabel("CNPJ");
		lblCnpj.setToolTipText("99.999.999/9999-99");
		lblCnpj.setBounds(29, 60, 70, 15);
		getContentPane().add(lblCnpj);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(29, 87, 70, 15);
		getContentPane().add(lblNome);
		
		lblRua = new JLabel("Rua");
		lblRua.setBounds(29, 114, 70, 15);
		getContentPane().add(lblRua);
		
		lblNumero = new JLabel("Numero");
		lblNumero.setBounds(29, 141, 70, 15);
		getContentPane().add(lblNumero);
		
		lblCep = new JLabel("CEP");
		lblCep.setBounds(29, 168, 70, 15);
		getContentPane().add(lblCep);
		
		lblCapacidade = new JLabel("Capacidade");
		lblCapacidade.setBounds(29, 195, 89, 15);
		getContentPane().add(lblCapacidade);
		
		textFieldCnpj = new JTextField();
		textFieldCnpj.setBounds(177, 58, 114, 19);
		getContentPane().add(textFieldCnpj);
		textFieldCnpj.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(177, 85, 114, 19);
		getContentPane().add(textFieldNome);
		
		textFieldRua = new JTextField();
		textFieldRua.setColumns(10);
		textFieldRua.setBounds(177, 112, 114, 19);
		getContentPane().add(textFieldRua);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(177, 139, 114, 19);
		getContentPane().add(textFieldNumero);
		
		textFieldCep = new JTextField();
		textFieldCep.setColumns(10);
		textFieldCep.setBounds(177, 166, 114, 19);
		getContentPane().add(textFieldCep);
		
		textFieldCap = new JTextField();
		textFieldCap.setColumns(10);
		textFieldCap.setBounds(177, 193, 114, 19);
		getContentPane().add(textFieldCap);
		
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
				
				BuffetCasamento.insert(s);
			}
		});
		btnCadastrar.setBounds(321, 224, 117, 25);
		getContentPane().add(btnCadastrar);
	}
}
