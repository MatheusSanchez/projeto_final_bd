package festa;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Tela2 extends JFrame {

	private JTextField txtData;
	
	public Tela2() {
		getContentPane().setLayout(null);
		
		JLabel lblEscolhaO = new JLabel("<html><h1>2. Escolha a data, o tipo da festa e os convidados</h1></html>");
		lblEscolhaO.setBounds(45, 35, 602, 49);
		getContentPane().add(lblEscolhaO);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Dialog", Font.BOLD, 12));
		lblData.setBounds(81, 132, 46, 14);
		getContentPane().add(lblData);
		
		txtData = new JTextField();
		txtData.setToolTipText("99/99/9999");
		txtData.setBounds(243, 130, 137, 20);
		getContentPane().add(txtData);
		txtData.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTipo.setBounds(81, 181, 46, 14);
		getContentPane().add(lblTipo);
		
		JComboBox comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Casamento", "Aniversario Infantil"}));
		comboBox.setBounds(243, 179, 137, 20);
		getContentPane().add(comboBox);
		
		JLabel lblConvidados = new JLabel("Convidados");
		lblConvidados.setFont(new Font("Dialog", Font.BOLD, 12));
		lblConvidados.setBounds(81, 229, 82, 14);
		getContentPane().add(lblConvidados);
		
		JButton button = new JButton("<");
		button.setBounds(10, 11, 41, 23);
		getContentPane().add(button);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setToolTipText("nome1, nome2, nome3");
		editorPane.setBounds(243, 229, 278, 160);
		getContentPane().add(editorPane);
		
		JLabel lbldigiteTodosOs = new JLabel("<html><p>(Digite todos os nomes<br> separados por virgulas)</p></html>");
		lbldigiteTodosOs.setBounds(59, 254, 162, 41);
		getContentPane().add(lbldigiteTodosOs);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] convidados = editorPane.getText().split(",");
				for (int i = 0; i < convidados.length; i++) convidados[i] = convidados[i].trim();
				
				new Tela3((String)comboBox.getSelectedItem());
			}
		});
		btnNext.setBounds(653, 366, 89, 23);
		getContentPane().add(btnNext);
	}
}
