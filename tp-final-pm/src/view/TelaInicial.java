package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TelaInicial extends JFrame {

	private JFrame tela;
	private JPanel painel;
	public void exibirTela(){
		prepararJanela();
		preparPainelPrincipal();
		inserirUsuario();
		BotaoSair();
		mostrarJanela();
	}

	private void inserirUsuario() {
		// TODO Stub de método gerado automaticamente
		JLabel usuario = new JLabel("Novo Usuario");
		
	}

	private void prepararJanela() {
		// TODO Stub de método gerado automaticamente
		tela = new JFrame("ÉFIFO");
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
        setLayout(new FlowLayout());
	}

	private void BotaoSair() {
		// TODO Stub de método gerado automaticamente
		JButton botaoSair = new JButton("Sair");
			botaoSair.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		painel.add(botaoSair);
	}

	private void preparPainelPrincipal() {
		// TODO Stub de método gerado automaticamente
		painel = new JPanel();
		tela.add(painel);
	}

	private void mostrarJanela() {
		// TODO Stub de método gerado automaticamente
		tela.pack();
		tela.setSize(500, 250);
		tela.setVisible(true);	
	}
	

}
