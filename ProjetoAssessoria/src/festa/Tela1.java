package festa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class Tela1 extends JFrame {
	private JTextField textCPF;
	//JlblTitle
	//lblContratante
	//btnProxima
	
	Tela1() {
		display();
	}
	
	void display() {
		getContentPane().setLayout(null);
		
		//JlblTitle = new JLabel("<html> <h1> 1. Escolha o Contratante </h1> </html>");
		//lblTitle.setBounds(31, 12, 362, 51);
		//getContentPane().add(lblTitle);
		
		textCPF = new JTextField();
		textCPF.setToolTipText("XXX.XXX.XXX-X");
		textCPF.setBounds(239, 154, 114, 19);
		getContentPane().add(textCPF);
		textCPF.setColumns(10);
		
		JLabel lblContratante = new JLabel("CPF do contratante");
		lblContratante.setBounds(31, 156, 149, 15);
		getContentPane().add(lblContratante);
		
		JButton btnProxima = new JButton("Proxima");
		btnProxima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProxima.setBounds(612, 389, 117, 25);
		getContentPane().add(btnProxima);
		
		JButton btnNovoContratante = new JButton("Inserir Novo Contratante");
		btnNovoContratante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNovoContratante.setBounds(31, 252, 226, 25);
		getContentPane().add(btnNovoContratante);
		
		JLabel lblNome = new JLabel("");
		lblNome.setBounds(31, 185, 263, 15);
		getContentPane().add(lblNome);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnPesquisar.setBounds(379, 154, 114, 19);
		getContentPane().add(btnPesquisar);
	}
}
