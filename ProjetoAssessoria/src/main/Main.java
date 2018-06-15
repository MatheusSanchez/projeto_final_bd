package main;

import javax.swing.SingleSelectionModel;

import conexao.Conexao;
import contratante.TelaContratante;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conexao.getInstance();
		System.out.println("testando");
		TelaContratante c = new TelaContratante();
		c.setSize(768, 480);
		c.setVisible(true);
	}
}