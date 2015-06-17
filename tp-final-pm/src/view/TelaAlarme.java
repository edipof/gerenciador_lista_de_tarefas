package view;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.entidade.Lembrete;

import java.awt.Color;
import java.awt.Font;

public class TelaAlarme extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JLabel aviso = new JLabel();
	private JLabel titulo = new JLabel();
	private JLabel descricao_tarefa = new JLabel();
	
	public TelaAlarme(Lembrete l){
		prepararJanela();
		preparPainelUsuario();
		this.aviso.setText("Eh hora de realizar a tarefa:");
		this.titulo.setText(l.getTitulo());
		this.descricao_tarefa.setText(l.getDescricao());
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
	}


	private void preparPainelUsuario() {
		// TODO Stub de método gerado automaticamente
		painel = new JPanel();
		
		//painel.setBounds(101, 650, 480, 173);
		//inserirUsuario();
		Font fonte_aviso = new Font(null, Font.BOLD, 24);
		Font fonte_titulo = new Font(null, Font.PLAIN, 20);
		Font fonte_descricao = new Font(null, Font.PLAIN, 16);
		painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
		this.aviso.setFont(fonte_aviso);
		this.titulo.setFont(fonte_titulo);
		this.descricao_tarefa.setFont(fonte_descricao);
		painel.add(this.aviso);
		painel.add(this.titulo);
		painel.add(this.descricao_tarefa);
		painel.setBackground(Color.yellow);
		this.setContentPane(painel);
		
	}

	private void mostrarJanela() {
		// TODO Stub de método gerado automaticamente
		this.setSize(350, 200);
		this.setLocation(500, 250);
		this.setVisible(true);
	}

}
