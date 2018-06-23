package main;


import atracao.TelaAnimador;
import conexao.Conexao;

public class Main {

	public static void main(String[] args) {
		Conexao.getInstance(); // pede os dados da conexao antes de rodar


		// TelaContratante c = new TelaContratante();
		// TelaDecoracaoCasamento c = new TelaDecoracaoCasamento();
		//TelaDecoracaoInfantil c = new TelaDecoracaoInfantil();
		// TelaBuffetCasamento c = new TelaBuffetCasamento();
		//TelaBuffetInfantil c = new TelaBuffetInfantil();
		TelaAnimador c = new TelaAnimador();
		c.setSize(768, 480);
		c.setVisible(true);
	}
}