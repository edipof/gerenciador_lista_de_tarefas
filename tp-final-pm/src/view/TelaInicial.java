package view;

import java.awt.BorderLayout;
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
		preparPainelUsuario();
		BotaoSair();
		mostrarJanela();
	}

	private void inserirUsuario() {
		
		JPanel painelUsuario = new JPanel();
		painelUsuario.add(new JLabel("Usuário: "));
		painelUsuario.add(new JTextField("Insira um novo Usuário"));
		
		JPanel painelUsuarioBotao = new JPanel();
		painelUsuarioBotao.add(new JButton("Iniciar"));
		
		painel.add(painelUsuario, BorderLayout.WEST);
		painel.add(painelUsuarioBotao, BorderLayout.EAST);
	}

	private void prepararJanela() {
		// TODO Stub de método gerado automaticamente
		tela = new JFrame("ÉFIFO - Gerenciador de Tarefas");
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

	private void preparPainelUsuario() {
		// TODO Stub de método gerado automaticamente
		painel = new JPanel();
		
		//painel.setBounds(101, 650, 480, 173);
		inserirUsuario();
		tela.setContentPane(painel);
		
	}

	private void mostrarJanela() {
		// TODO Stub de método gerado automaticamente
		tela.setSize(500, 250);
		tela.setVisible(true);	
	}
	

}
