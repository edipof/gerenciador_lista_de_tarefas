package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Lembrete;
import model.Tarefa;
import model.TarefaSimples;
import model.Usuario;
import model.dao.DAO;
import model.dao.DaoLembrete;
import model.dao.DaoTarefaSimples;
import model.dao.DaoUsuario;

public class TelaVisualizacaoDeTarefas extends javax.swing.JFrame {
	
	private javax.swing.JButton jButtonEditar;
	private javax.swing.JTabbedPane jTabbedPaneContainer;
	
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
	
	public ArrayList<ArrayList<String>> obtemMatrizDeTarefasSimples(String nomeUsuario) {
		
		
		DAO<Usuario,Tarefa> usuarioDTO = new DaoUsuario();
		DAO<TarefaSimples,Usuario> tarefaDTO = new DaoTarefaSimples();
		int indiceUsuarioEncontrado = buscaUsuario(nomeUsuario);
		
		
		Usuario usuario = (Usuario) usuarioDTO.getLista().get(indiceUsuarioEncontrado);
		ArrayList<TarefaSimples> listaTarefaSimples = new ArrayList<TarefaSimples>();
		listaTarefaSimples = tarefaDTO.getLista(usuario);
		
		ArrayList<ArrayList<String>> tarefas = new ArrayList<ArrayList<String>>();
		
		for (TarefaSimples tarefa : listaTarefaSimples) {
			
			ArrayList<String> listaAux= new ArrayList<String>();
			
			listaAux.add(Long.toString(tarefa.getId()) );
			listaAux.add(tarefa.getDescricao() );
			
			tarefas.add(listaAux);
		}
		
		return tarefas;

	}
	
	public ArrayList<ArrayList<String>> obtemMatrizDeLembretes(String nomeUsuario){ /* throws alguma excecao que nao faco ideia qual eh*/
		
		DAO<Usuario,Tarefa> usuarioDTO = new DaoUsuario();
		DAO<Lembrete,Usuario> lembreteDTO = new DaoLembrete();
		int indiceUsuarioEncontrado = buscaUsuario(nomeUsuario);
		
		
		Usuario usuario = (Usuario) usuarioDTO.getLista().get(indiceUsuarioEncontrado);
		ArrayList<Lembrete> listaLembrete = new ArrayList<Lembrete>();
		listaLembrete = lembreteDTO.getLista(usuario);
		
		ArrayList<ArrayList<String>> lembretes = new ArrayList<ArrayList<String>>();
		
		for (Lembrete lembrete : listaLembrete) {
			
			ArrayList<String> listaAux= new ArrayList<String>();
			
			listaAux.add(Long.toString(lembrete.getId()) );
			listaAux.add(lembrete.getDescricao() );
			listaAux.add(lembrete.getData() );
			listaAux.add(lembrete.getHora());
			
			lembretes.add(listaAux);
		}
		
		return lembretes;
		
	}
   
    public TelaVisualizacaoDeTarefas(String nomeUsuario) {
        geraVisualizacao(nomeUsuario);
    }
    
    public JTable converteMatrizParaJTable (ArrayList<ArrayList<String>> matriz, String[] colunas) {
    	
    	DefaultTableModel modelo = new DefaultTableModel();
    	
    	for (String coluna : colunas) {
    		
    		modelo.addColumn(coluna);	
    	}
    	
        JTable tabela = new JTable(modelo);
        
    	for (ArrayList<String> i : matriz) {
    		
    		modelo.addRow(new Vector<Object>(i));
    	}
    	
    	return tabela;
    }
    
    private void geraVisualizacao(String nomeUsuario) {

    	String[] colunasLembretes = {"Id", "Descricao", "Data", "Hora"};
	    JTable lembretes = converteMatrizParaJTable(obtemMatrizDeLembretes(nomeUsuario), colunasLembretes); 
	    
	    String[] colunasTarefasSimples = {"Id", "Descricao"};
	    JTable tarefasSimples = converteMatrizParaJTable(obtemMatrizDeTarefasSimples(nomeUsuario), colunasTarefasSimples);


		// Create and set up the window.
		final JFrame frame = new JFrame("Minhas tarefas");

		// Display the window.
		frame.setSize(1000, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JTabbedPane jTabbedPaneContainer = new JTabbedPane();

		jTabbedPaneContainer.addTab("Lembretes", lembretes);
		jTabbedPaneContainer.addTab("Tarefas simples", tarefasSimples);

		frame.getContentPane().add(jTabbedPaneContainer);
		
		//configurando o botao de editar
		
		jButtonEditar = new javax.swing.JButton();
		jButtonEditar.setText("Editar...");
		jButtonEditar.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				metodoAcaoClicarBotaoEditar(jTabbedPaneContainer);
			} 
        });
		JPanel botao = new JPanel();
	    BoxLayout layoutBotao = new BoxLayout(botao, BoxLayout.LINE_AXIS);
	    botao.setLayout(layoutBotao);
	    botao.add(jButtonEditar);
	    JPanel p = new JPanel(new BorderLayout());
	    p.add(botao, BorderLayout.PAGE_END);

	    //adicionando os elementos a tela
	    jTabbedPaneContainer.add(botao);
	    frame.add(jTabbedPaneContainer);
		frame.add(botao, BorderLayout.PAGE_END);
    }
    
    void metodoAcaoClicarBotaoEditar (JTabbedPane jTabbedPaneContainer) {
		
    	int abaAtual = jTabbedPaneContainer.getSelectedIndex();
    	
    	System.out.println("aba:" + abaAtual);
    	
//    	Component aba = jTabbedPaneContainer.getComponentAt(abaAtual).getName();
    	JTable tabela = (JTable) jTabbedPaneContainer.getComponentAt(abaAtual);
//    	System.out.println(aba);
    	System.out.println("linha:" + tabela.getSelectedRow());
    	Object idElementoNoBanco = (Object) tabela.getModel().getValueAt(tabela.getSelectedRow(), 0);
    	System.out.println("id da tarefa no banco:" + idElementoNoBanco.toString());
//    	System.out.println(jTabbedPaneContainer.getTabComponentAt(abaAtual).getName());
    	System.out.println("---------------------------------------------------");
    	
    	final ArrayList<String> nomesColunas = new ArrayList<String>();
    	final ArrayList<String> conteudoColunas = new ArrayList<String>();
    	
    	for (int i = 0; i < tabela.getColumnCount(); i++) {
    		
    		nomesColunas.add(tabela.getModel().getColumnName(i));
    		conteudoColunas.add(tabela.getModel().getValueAt(tabela.getSelectedRow(), i).toString());
    		
    	}
    	
    	System.out.println(nomesColunas.toString());
    	System.out.println(conteudoColunas.toString());
    	
    	java.awt.EventQueue.invokeLater(new Runnable() {
    		public void run() {
    			new TelaEdicaoDeTarefas(nomesColunas, conteudoColunas);
    		}
    	});    	
	}

}