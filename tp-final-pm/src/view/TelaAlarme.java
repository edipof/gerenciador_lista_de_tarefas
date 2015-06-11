package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Tarefa;

public class TelaAlarme extends JFrame{
	private JPanel painel;
	private JLabel aviso;
	private JLabel descricao_tarefa;
	
	public TelaAlarme(Tarefa t){
		prepararJanela();
		preparPainelUsuario();
		this.add(this.aviso);
		this.add(this.descricao_tarefa);
		mostrarJanela();
	}
	public void exibirTela(){
		prepararJanela();
		preparPainelUsuario();
		mostrarJanela();
	}

	private void prepararJanela() {
		// TODO Stub de método gerado automaticamente
		this.setTitle("ALARME - Gerenciador de Tarefas");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	private void preparPainelUsuario() {
		// TODO Stub de método gerado automaticamente
		painel = new JPanel();
		
		//painel.setBounds(101, 650, 480, 173);
		//inserirUsuario();
		this.setContentPane(painel);
		
	}

	private void mostrarJanela() {
		// TODO Stub de método gerado automaticamente
		this.setSize(300, 500);
		this.setVisible(true);	
	}

}
