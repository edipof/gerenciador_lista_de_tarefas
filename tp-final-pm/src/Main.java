import view.TelaCriarTarefa;
import view.TelaInicial;
import view.TelaCriarTarefa;
import view.TelaVisualizacaoDeTarefas;
import view.TelaAlarme;
import control.Alarme;
import model.Usuario;
import model.Lembrete;


public class Main {

	public static void main(String[] args) {
		// TODO Stub de método gerado automaticamente
		//TelaInicial index = new TelaInicial();
		//index.exibirTela();
		
		//TelaCriarTarefa criar_tarefa = new TelaCriarTarefa();
		//criar_tarefa.exibirTela();
		//TelaCriarTarefa app = new TelaCriarTarefa();
		
		Usuario u = new Usuario();
		u.setId(3);
		u.setNome("Bruno");
		Thread alarme = new Thread(new Alarme(u));
		alarme.start();
		java.awt.EventQueue.invokeLater(new Runnable() {
    		public void run() {
    			new TelaCriarTarefa().setVisible(true);
    		}
    	});
		/*Lembrete l = new Lembrete("teste", "descricao", u, "10/10/2010", "21:23");
		TelaAlarme a = new TelaAlarme(l);*/
		
		/*java.awt.EventQueue.invokeLater(new Runnable() {
    		public void run() {
    			new TelaVisualizacaoDeTarefas("Édipo").setVisible(true);
    		}
    	});*/
		/**
	     * @param args the command line arguments
	    *//*
	    public static void main(String args[]) {
	    	java.awt.EventQueue.invokeLater(new Runnable() {
	    		public void run() {
	    			new TelaCriarTarefa().setVisible(true);
	    		}
	    	});
	    }*/
		
	}

}
