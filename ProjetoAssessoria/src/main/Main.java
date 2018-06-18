package main;

import conexao.Conexao;
import contratante.TelaContratante;
import decoracao.TelaDecoracaoCasamento;
import decoracao.TelaDecoracaoInfantil;

public class Main {

	public static void main(String[] args) {
		Conexao.getInstance(); //pede os dados da conexao antes de rodar

		//TelaContratante c = new TelaContratante();
		TelaDecoracaoCasamento c = new TelaDecoracaoCasamento();
		c.setSize(768, 480);
		c.setVisible(true);
	}
}