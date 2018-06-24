package main;

import javax.swing.JFrame;

import java.awt.Container;

import conexao.Conexao;
import festa.TelaFesta;

public class Main {
	
	public static void novaJanela(JFrame jan) {
		jan.setVisible(true);
		jan.setSize(768, 480);
	}
	
	public static void novaTela(Container c) {
		c.removeAll();
		c.revalidate();
		c.repaint();
	}

	public static void main(String[] args) {
		Conexao.getInstance(); // pede os dados da conexao antes de rodar

		//TelaFesta c = new TelaFesta();
		// TelaContratante c = new TelaContratante();
		// TelaDecoracaoCasamento c = new TelaDecoracaoCasamento();
		//TelaDecoracaoInfantil c = new TelaDecoracaoInfantil();
		// TelaBuffetCasamento c = new TelaBuffetCasamento();
		//TelaBuffetInfantil c = new TelaBuffetInfantil();
		//TelaBanda c = new TelaBanda();
		
		TelaInicio c = new TelaInicio();
		c.telaInicial();
		c.setSize(768, 480);
		c.setVisible(true);
		
		
		
	
	}
}