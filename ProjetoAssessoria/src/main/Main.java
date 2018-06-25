package main;

import javax.swing.JFrame;
import java.awt.Container;

import conexao.Conexao;
import festa.TelaFesta;

/*
 * Main
 * 
 */

public class Main {
	
	// cria uma novaJanela
	public static void novaJanela(JFrame jan) {
		jan.setVisible(true);
		jan.setSize(768, 480);
	}
	
	// limpa o conteudo da janela, para a geracao de uma nova tela
	public static void novaTela(Container c) {
		c.removeAll();
		c.revalidate();
		c.repaint();
	}

	public static void main(String[] args) {
		Conexao.getInstance(); // pede os dados da conexao antes de rodar
		
		TelaInicio c = new TelaInicio(); // nova tela de inicio
		c.telaInicial(); // invoca o metodo de apresentacao da tela inicial
		c.setSize(768, 480); // seta as dimensoes da janela
		c.setVisible(true);
		
	}
}