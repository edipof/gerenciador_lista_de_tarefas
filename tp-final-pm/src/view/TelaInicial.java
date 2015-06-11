package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

public class TelaInicial extends JFrame {

	private JFrame tela;
	
	public void exibirTela(){
		prepararJanela();
		preparPainelPrincipal();
		prepararBotaoCarregar();
		prepararBotaoSair();
		mostrarJanela();
	}

	private void prepararJanela() {
		// TODO Stub de método gerado automaticamente
		tela = new JFrame("TasksManager");
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	private void prepararBotaoSair() {
		// TODO Stub de método gerado automaticamente
		
	}

	private void prepararBotaoCarregar() {
		// TODO Stub de método gerado automaticamente
		
	}

	private void preparPainelPrincipal() {
		// TODO Stub de método gerado automaticamente
		
	}

	private void mostrarJanela() {
		// TODO Stub de método gerado automaticamente
		tela.pack();
		tela.setSize(500, 250);
		tela.setVisible(true);	
	}
	

}
