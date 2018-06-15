package main;

import javax.swing.SingleSelectionModel;

import conexao.Conexao;
import contratante.TelaContratante;

public class Main {

	public static void main(String[] args) {
		Conexao.getInstance(); //pede os dados da conexao antes de rodar
		TelaContratante c = new TelaContratante();
		c.setSize(768, 480);
		c.setVisible(true);
	}
}