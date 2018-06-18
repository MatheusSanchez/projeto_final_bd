package main;

import conexao.Conexao;
import decoracao.TelaDecoracaoCasamento;
import decoracao.TelaDecoracaoInfantil;

public class Main {

	public static void main(String[] args) {
		Conexao.getInstance(); //pede os dados da conexao antes de rodar
		//TelaContratante c = new TelaContratante();
		TelaDecoracaoInfantil c = new TelaDecoracaoInfantil();
		c.setSize(768, 480);
		c.setVisible(true);
	}
}