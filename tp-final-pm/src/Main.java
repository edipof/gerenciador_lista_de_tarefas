import view.TelaInicial;
import view.TelaCriarTarefa;
import view.TelaVisualizacaoDeTarefas;


public class Main {

	public static void main(String[] args) {
		
		java.awt.EventQueue.invokeLater(new Runnable() {
			
    		public void run() {
    			
    			new TelaInicial();
    		}
    	});
	}

}
