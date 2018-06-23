package main;


import conexao.Conexao;
import festa.Tela3;

public class Main {

	public static void main(String[] args) {
		Conexao.getInstance(); // pede os dados da conexao antes de rodar


		// TelaContratante c = new TelaContratante();
		// TelaDecoracaoCasamento c = new TelaDecoracaoCasamento();
		//TelaDecoracaoInfantil c = new TelaDecoracaoInfantil();
		// TelaBuffetCasamento c = new TelaBuffetCasamento();
		//TelaBuffetInfantil c = new TelaBuffetInfantil();
		//TelaBanda c = new TelaBanda();
		//TelaFesta c = new TelaFesta();
		Tela3 c = new Tela3("casamento");
		c.setSize(768, 480);
		c.setVisible(true);
		
		
	}
}