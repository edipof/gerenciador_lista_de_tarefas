package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import model.Lembrete;
import model.Tarefa;
import model.TarefaSimples;
import model.Usuario;
import model.dao.DAO;
import model.dao.DaoLembrete;
import model.dao.DaoTarefaSimples;
import model.dao.DaoUsuario;

import java.awt.FlowLayout;
//import java.awt.List;


import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;



public class TelaVisualizacaoDeTarefas extends javax.swing.JFrame {
	
	private javax.swing.JButton jButtonSalvar;
	  
	private javax.swing.JLabel jLabelTSTitulo;
	private javax.swing.JLabel jLabelTSDescricao;
	private javax.swing.JLabel jLabelTPTitulo;
	private javax.swing.JLabel jLabelTPDescricao;
	private javax.swing.JLabel jLabelTPData;
	private javax.swing.JLabel jLabelTPProgresso;
	private javax.swing.JLabel jLabelLTitulo;
	private javax.swing.JLabel jLabelLDescricao;
	private javax.swing.JLabel jLabelLData;
	private javax.swing.JLabel jLabelLHora;
	private javax.swing.JPanel jPanelTarefaSimples;	
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTabbedPane jTabbedPaneContainer;
	private javax.swing.JTextField jTextFieldTSTitulo;
	private JTextArea jTextAreaFieldTSDescricao;
	private JTextArea jTextAreaFieldTPDescricao;
	private JTextArea jTextAreaFieldLDescricao;
	
	
	public int buscaUsuario (String nomeUsuario) {
		
		DAO<Usuario,Tarefa> usuarioDTO = new DaoUsuario();
		
		int indiceUsuarioEncontrado = -1;
		
		// procura pelo nome de usuario passado como parametro vindo da tela que chama esta classe
		for (int i = 0; i < usuarioDTO.getLista().size(); i++) {
			 
			if (usuarioDTO.getLista().get(i).getNome().equals(nomeUsuario)){ 
				//pode usar if nesse caso ou o que?
				indiceUsuarioEncontrado = i;
			}
		}//tem que lancar excecao se usuarioEncontrado ainda for -1? 
		
		return indiceUsuarioEncontrado;
	}
	
	public List<String> obtemListaDeTarefasSimples(String nomeUsuario) {
		
		
		DAO<Usuario,Tarefa> usuarioDTO = new DaoUsuario();
		DAO<TarefaSimples,Usuario> tarefaDTO = new DaoTarefaSimples();

		int indiceUsuarioEncontrado = buscaUsuario(nomeUsuario);
		
		System.out.println("indice: " + indiceUsuarioEncontrado);
		
		Usuario usuario = (Usuario) usuarioDTO.getLista().get(indiceUsuarioEncontrado);

		ArrayList<TarefaSimples> listaTarefaSimples = new ArrayList<TarefaSimples>();
		listaTarefaSimples = tarefaDTO.getLista(usuario);
		
		Lembrete t1 = null;
		List<String> tarefas = new ArrayList<String>();
		
		for (TarefaSimples tarefa : listaTarefaSimples) {
			
			tarefas.add(tarefa.getDescricao());
		}
		
		return tarefas;

	}
	
	public List<String> obtemListaDeLembretes(String nomeUsuario){ /* throws alguma excecao que nao faco ideia qual eh*/
		
		DAO<Usuario,Tarefa> usuarioDTO = new DaoUsuario();
		DAO<Lembrete,Usuario> lembreteDTO = new DaoLembrete();
		int indiceUsuarioEncontrado = buscaUsuario(nomeUsuario);
		
		System.out.println("indice: " + indiceUsuarioEncontrado);
		
		Usuario usuario = (Usuario) usuarioDTO.getLista().get(indiceUsuarioEncontrado);
		ArrayList<Lembrete> listaLembrete = new ArrayList<Lembrete>();
		listaLembrete = lembreteDTO.getLista(usuario);
		
		Lembrete t1 = null;
		List<String> lembretes = new ArrayList<String>();
		
		for (Lembrete tarefa : listaLembrete) {
			
			lembretes.add(tarefa.getDescricao());
		}
		
		return lembretes;
		
	}
   
    public TelaVisualizacaoDeTarefas(String nomeUsuario) {
        initComponents(nomeUsuario);
    }
    
  
    private void initComponents(String nomeUsuario) {

//	    List lembretes = obtemListaDeLembretes(nomeUsuario);
	    JList<String> listaLembretes = new JList(obtemListaDeLembretes(nomeUsuario).toArray());
	    JList<String> listaTarefas = new JList(obtemListaDeTarefasSimples(nomeUsuario).toArray());
	    
    	//(1)
    	jTabbedPaneContainer = new javax.swing.JTabbedPane();
    	jPanelTarefaSimples = new javax.swing.JPanel();
//        jPanelTarefaProgressiva = new javax.swing.JPanel();
//        jPanelLembrete = new javax.swing.JPanel();
        jTabbedPaneContainer.add("Lembretes", new JScrollPane(listaLembretes));
        jTabbedPaneContainer.add("Tarefas", new JScrollPane(listaTarefas));

//        jTabbedPaneContainer.add("Tarefa Progressiva", jPanelTarefaProgressiva);
//        jTabbedPaneContainer.add("Lembrete", jPanelLembrete);
        //(2)
        jScrollPane1 = new javax.swing.JScrollPane();
        //jTextAreaObservacao = new javax.swing.JTextArea();
        jButtonSalvar = new javax.swing.JButton();
        jLabelTSTitulo = new javax.swing.JLabel();
        jLabelTSDescricao = new javax.swing.JLabel();
        jLabelTPTitulo = new javax.swing.JLabel();
        jLabelTPDescricao = new javax.swing.JLabel();
        jLabelTPData = new javax.swing.JLabel();
        jLabelTPProgresso = new javax.swing.JLabel();
        jLabelLTitulo = new javax.swing.JLabel();
        jLabelLDescricao = new javax.swing.JLabel();
        jLabelLData = new javax.swing.JLabel();
        jLabelLHora = new javax.swing.JLabel();
      
        jTextFieldTSTitulo = new javax.swing.JTextField();
        jTextAreaFieldTSDescricao = new javax.swing.JTextArea();
        jTextAreaFieldTPDescricao = new javax.swing.JTextArea();
        jTextAreaFieldLDescricao = new javax.swing.JTextArea();


        //(3)
        jLabelTSTitulo.setText("Titulo");
        jLabelTSDescricao.setText("Descricao");
        
        jLabelTPTitulo.setText("Titulo");
        jLabelTPDescricao.setText("Descricao");
        jLabelTPData.setText("Data");
        jLabelTPProgresso.setText("Progresso");
        
        jLabelLTitulo.setText("Titulo");
        jLabelLDescricao.setText("Descricao");
        jLabelLData.setText("Data");
        jLabelLHora.setText("Hora");
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Criar Tarefa");
        jTextAreaFieldTSDescricao.setColumns(20);
        jTextAreaFieldTSDescricao.setRows(5);
        jTextAreaFieldTPDescricao.setColumns(20);
        jTextAreaFieldTPDescricao.setRows(5);
        jTextAreaFieldLDescricao.setColumns(20);
        jTextAreaFieldLDescricao.setRows(5);
        jScrollPane1.setViewportView(jTextAreaFieldTSDescricao);
        //jTextAreaObservacao.setColumns(20);
        //jTextAreaObservacao.setRows(5);
        //jScrollPane1.setViewportView(jTextAreaObservacao);
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        //(4)
        javax.swing.GroupLayout jPanelTarefaSimplesLayout = new javax.swing.GroupLayout(jPanelTarefaSimples);
        jPanelTarefaSimples.setLayout(jPanelTarefaSimplesLayout);
        jPanelTarefaSimplesLayout.setHorizontalGroup(
          jPanelTarefaSimplesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTarefaSimplesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTarefaSimplesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldTSTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTSTitulo)
                    .addComponent(jTextAreaFieldTSDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTSDescricao))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        jPanelTarefaSimplesLayout.setVerticalGroup(
          jPanelTarefaSimplesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTarefaSimplesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTSTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTSTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelTSDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextAreaFieldTSDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        
//        javax.swing.GroupLayout jPanelTarefaProgressivaLayout = new javax.swing.GroupLayout(jPanelTarefaProgressiva);
//        jPanelTarefaProgressiva.setLayout(jPanelTarefaProgressivaLayout);
//        jPanelTarefaProgressivaLayout.setHorizontalGroup(
//          jPanelTarefaProgressivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(jPanelTarefaProgressivaLayout.createSequentialGroup()
//                .addContainerGap()
//                .addGroup(jPanelTarefaProgressivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addComponent(jTextFieldTPTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(jLabelTPTitulo)
//                    .addComponent(jTextAreaFieldTPDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(jLabelTPDescricao)
//                    .addComponent(jTextFieldTPData, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(jLabelTPData)
//                    .addComponent(jTextFieldTPProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(jLabelTPProgresso))
//                .addContainerGap(154, Short.MAX_VALUE))
//        );
//        jPanelTarefaProgressivaLayout.setVerticalGroup(
//          jPanelTarefaProgressivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(jPanelTarefaProgressivaLayout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(jLabelTPTitulo)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(jTextFieldTPTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addComponent(jLabelTPDescricao)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(jTextAreaFieldTPDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addComponent(jLabelTPData)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(jTextFieldTPData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addComponent(jLabelTPProgresso)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(jTextFieldTPProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addContainerGap(28, Short.MAX_VALUE))
//        );
        
           
//        javax.swing.GroupLayout jPanelLembreteLayout = new javax.swing.GroupLayout(jPanelLembrete);
//        jPanelLembrete.setLayout(jPanelLembreteLayout);
//        jPanelLembreteLayout.setHorizontalGroup(
//          jPanelLembreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(jPanelLembreteLayout.createSequentialGroup()
//                .addContainerGap()
//                .addGroup(jPanelLembreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
//                    .addComponent(jTextFieldLTitulo, javax.swing.GroupLayout.Alignment.LEADING)
//                    .addComponent(jLabelLTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addComponent(jTextAreaFieldLDescricao, javax.swing.GroupLayout.Alignment.LEADING)
//                    .addComponent(jLabelLDescricao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addComponent(jTextFieldLData, javax.swing.GroupLayout.Alignment.LEADING)
//                    .addComponent(jLabelLData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addComponent(jTextFieldLHora, javax.swing.GroupLayout.Alignment.LEADING)
//                    .addComponent(jLabelLHora, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                .addContainerGap(255, Short.MAX_VALUE))
//        );
//        jPanelLembreteLayout.setVerticalGroup(
//          jPanelLembreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(jPanelLembreteLayout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(jLabelLTitulo)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(jTextFieldLTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addComponent(jLabelLDescricao)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(jTextAreaFieldLDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addComponent(jLabelLData)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(jTextFieldLData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addComponent(jLabelLHora)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(jTextFieldLHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addContainerGap(28, Short.MAX_VALUE))
//        );  
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addContainerGap(182, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButtonSalvar))
                .addContainerGap())
        );
        pack();
    }
    
    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
    	int i = jTabbedPaneContainer.getSelectedIndex();
     
    	if (jTabbedPaneContainer.getComponentCount() - 1 == i){
           jTabbedPaneContainer.setSelectedIndex(0);
    	}else{
    		jTabbedPaneContainer.setSelectedIndex(i+1);
    	}
    }//GEN-LAST:event_jButtonSalvarActionPerformed
  	      
}