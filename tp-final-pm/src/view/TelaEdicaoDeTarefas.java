package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import model.entidade.Lembrete;
import model.entidade.Tarefa;
import model.entidade.TarefaProgressiva;
import model.entidade.TarefaSimples;
import model.entidade.Usuario;
import control.AcaoEditaTarefa;

public class TelaEdicaoDeTarefas extends Tela {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TelaEdicaoDeTarefas(ArrayList<String> nomesColunas,ArrayList<String> 
		conteudoColunas, ArrayList<Tarefa> listaTarefasParaEditar,Usuario usuario) {
		
        geraVisualizacao(nomesColunas, conteudoColunas, listaTarefasParaEditar, usuario);
    }
    
    private void geraVisualizacao(ArrayList<String> nomesColunas,
    		ArrayList<String> conteudoColunas, final ArrayList<Tarefa> listaTarefasParaEditar, 
    		final Usuario usuario) {
    	
        final JFrame frame = new JFrame("Editar tarefa");
        final Container painel = frame.getContentPane();
        painel.setLayout(new GridBagLayout());
        painel.setBackground(UIManager.getColor("control"));
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.anchor = GridBagConstraints.EAST;

        for (String nome : nomesColunas) {
        	
            painel.add(new JLabel(nome, SwingConstants.RIGHT), gbc);
		}
        
      //configurando o botao de fechar
      		JButton jButtonFechar = new javax.swing.JButton();
      		jButtonFechar.setText("Fechar");
      		jButtonFechar.addActionListener(new ActionListener() { 
      			@Override
      			public void actionPerformed(ActionEvent e) {
      				metodoAcaoClicarBotaoFechar(frame, usuario);
      			} 
              });
      		painel.add(jButtonFechar, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        //desabilitando edicao para o campo de id
        String id = conteudoColunas.remove(0);
        JTextField campo = new JTextField(id);
    	campo.setPreferredSize(new Dimension(400, 20));
    	campo.setEnabled(false);
    	painel.add(campo, gbc);
        gbc.gridy = GridBagConstraints.RELATIVE;
        
        for (String conteudo : conteudoColunas) {
			
        	campo = new JTextField(conteudo);
        	campo.setPreferredSize(new Dimension(400, 20));
        	painel.add(campo, gbc);
            gbc.gridy = GridBagConstraints.RELATIVE;

		}

        gbc.gridx = 1;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.weightx = 0.0;
        gbc.fill = GridBagConstraints.NONE;

		//configurando o botao de salvar
		JButton jButtonSalvar = new javax.swing.JButton();
		jButtonSalvar.setText("Salvar");
		jButtonSalvar.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				metodoAcaoClicarBotaoSalvar(painel, listaTarefasParaEditar, frame, usuario);
			} 
        });
		painel.add(jButtonSalvar, gbc);
		
        frame.pack();
        frame.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent evt) {
            System.exit(0);
          }
        });
        frame.setVisible(true);
    }
    
    public void metodoAcaoClicarBotaoSalvar (Container painel, ArrayList<Tarefa> listaTarefasParaEditar, JFrame frame, Usuario usuario) {
		
		ArrayList<String> dadosFormulario = new ArrayList<String>(); 
    	
    	for (int i = 0; i < painel.getComponentCount(); i ++) {
    		
    		Component componente = painel.getComponent(i);
    		
    		if (componente.getClass().toString().equals("class javax.swing.JTextField")) {
    			JTextField campo = (JTextField) componente;
    			dadosFormulario.add(campo.getText());
    		}
    	}
    	String idTarefa = dadosFormulario.remove(0);
    	
    	Tarefa tarefa = buscaTarefaPorId(listaTarefasParaEditar, idTarefa);
    	
    	if (tarefa != null) {
    		
        	AcaoEditaTarefa a = new AcaoEditaTarefa();
        	
        	if (isValido(tarefa, dadosFormulario)) {
        		
        		a.atualizaTarefa(tarefa, dadosFormulario);
        		/*depois da validacao: */ 
        		JOptionPane.showMessageDialog(null, "Tarefa alterada com sucesso!");
        		
        	} else {
        		
        		frame.dispose();
        		new TelaVisualizacaoDeTarefas(usuario);
        	}
		}
    }
    public Boolean isValido(Tarefa tarefa, ArrayList<String> dadosFormulario){
		Boolean isValido = true;
    	if (tarefa instanceof TarefaSimples) {
			return isValido;
		} else if (tarefa instanceof TarefaProgressiva) {
			//se for instancia de tarefa progressiva verifica data e progresso
			if (dadosFormulario.get(2).matches("([0-9]{2})/([0-9]{2})/([0-9]{4})") == false){
				JOptionPane.showMessageDialog(null, "A data deve estar no formato dd/mm/aaaa");
				isValido=false;
				return isValido;
        	}else if(Long.parseLong(dadosFormulario.get(3)) < 0 || 
        			Long.parseLong(dadosFormulario.get(3)) > 100 ){
        		JOptionPane.showMessageDialog(null, "O progresso deve estrar entre 0 e 100");
        		isValido=false;
        		return isValido;
        	}
			
		} else if (tarefa instanceof Lembrete) {
			//se for instancia de tarefa lembrete verifica data e hora
			if (dadosFormulario.get(2).matches("([0-9]{2})/([0-9]{2})/([0-9]{4})") == false){
				JOptionPane.showMessageDialog(null, "A data deve estar no formato dd/mm/aaaa");
				isValido=false;
				return isValido;
			}
			else if (dadosFormulario.get(3).matches("([0-9]{2}):([0-9]{2})") == false){
				JOptionPane.showMessageDialog(null, "A hora deve estar no formato HH:MM");
				isValido=false;
				return isValido;
        	}
		}
    	return false;
    }
    
    public void metodoAcaoClicarBotaoFechar(JFrame frame, final Usuario usuario) {
    	frame.dispose();
    	java.awt.EventQueue.invokeLater(new Runnable() {
    		public void run() {
    			new TelaVisualizacaoDeTarefas(usuario);
    		}
    	});
	}
}