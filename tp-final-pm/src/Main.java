import view.TelaInicial;
import view.TelaCriarTarefa;
import view.TelaVisualizacaoDeTarefas;


public class Main {

	public static void main(String[] args) {
		// TODO Stub de método gerado automaticamente
		//TelaInicial index = new TelaInicial();
		//index.exibirTela();
		
		//TelaCriarTarefa criar_tarefa = new TelaCriarTarefa();
		//criar_tarefa.exibirTela();
		//TelaCriarTarefa app = new TelaCriarTarefa();
//		java.awt.EventQueue.invokeLater(new Runnable() {
//    		public void run() {
//    			new TelaCriarTarefa().setVisible(true);
//    		}
//    	});
		java.awt.EventQueue.invokeLater(new Runnable() {
    		public void run() {
//    			new TelaVisualizacaoDeTarefas("Bruno");
    			new TelaInicial();
    		}
    	});
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
