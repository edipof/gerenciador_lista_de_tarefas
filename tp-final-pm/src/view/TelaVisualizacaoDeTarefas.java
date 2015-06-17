package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.entidade.Lembrete;
import model.entidade.Tarefa;
import model.entidade.TarefaProgressiva;
import model.entidade.TarefaSimples;
import model.entidade.Usuario;
import model.operacoesBD.ManipuladorBancoDados;
import model.operacoesBD.ManipuladorTarefaLembrete;
import model.operacoesBD.ManipuladorTarefaProgressiva;
import model.operacoesBD.ManipuladorTarefaSimples;
import control.AcaoRemoveTarefa;

public class TelaVisualizacaoDeTarefas extends Tela {

	private static final long serialVersionUID = 1L;
	private javax.swing.JButton jButtonEditar;
	private javax.swing.JButton jButtonCriar;
	private javax.swing.JButton jButtonRemover;
	private javax.swing.JTabbedPane jTabbedPaneContainer;
	
	
	public ArrayList<ArrayList<String>> obtemMatrizDeTarefasSimples(Usuario usuario, ArrayList<Tarefa> listaTarefasParaEditar) {
		
		ManipuladorBancoDados<TarefaSimples> tarefaDTO = new ManipuladorTarefaSimples();
		ArrayList<TarefaSimples>listaTarefasSimples = new ArrayList<TarefaSimples>();
		
		try{
			listaTarefasSimples = tarefaDTO.selectListaEntidadeComParametro(usuario);
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Erro inesperado no servidor");
    		this.dispose();
		}
		
		
		ArrayList<ArrayList<String>> tarefas = new ArrayList<ArrayList<String>>();
		
		for (TarefaSimples tarefa : listaTarefasSimples) {
			
			listaTarefasParaEditar.add(tarefa);
			
			ArrayList<String> listaAux= new ArrayList<String>();
			
			listaAux.add(Long.toString(tarefa.getId()) );
			listaAux.add(tarefa.getTitulo() );
			listaAux.add(tarefa.getDescricao() );
			
			tarefas.add(listaAux);
		}
		
		return tarefas;

	}
	
	public ArrayList<ArrayList<String>> obtemMatrizDeLembretes(Usuario usuario, ArrayList<Tarefa> listaTarefasParaEditar){ /* throws alguma excecao que nao faco ideia qual eh*/
		
		
		ManipuladorBancoDados<Lembrete> lembreteDTO = new ManipuladorTarefaLembrete();
		
		ArrayList<Lembrete> listaLembretes = new ArrayList<Lembrete>();
		
		try{
			listaLembretes = lembreteDTO.selectListaEntidadeComParametro(usuario);
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Erro inesperado no servidor");
    		this.dispose();
		}
		
		ArrayList<ArrayList<String>> lembretes = new ArrayList<ArrayList<String>>();
		
		for (Lembrete lembrete : listaLembretes) {
			
			listaTarefasParaEditar.add(lembrete);
			
			ArrayList<String> listaAux= new ArrayList<String>();
			
			listaAux.add(Long.toString(lembrete.getId()) );
			listaAux.add(lembrete.getTitulo() );
			listaAux.add(lembrete.getDescricao() );
			listaAux.add(lembrete.getData() );
			listaAux.add(lembrete.getHora());
			
			lembretes.add(listaAux);
		}
		return lembretes;
	}

	public ArrayList<ArrayList<String>> obtemMatrizDeTarefasProgressivas(Usuario usuario, ArrayList<Tarefa> listaTarefasParaEditar) {
		
		ManipuladorBancoDados<TarefaProgressiva> tarefaDTO = new ManipuladorTarefaProgressiva();
		ArrayList<TarefaProgressiva> listaTarefasProgressiva = new ArrayList<TarefaProgressiva>();
		
		try{
			listaTarefasProgressiva = tarefaDTO.selectListaEntidadeComParametro(usuario);
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Erro inesperado no servidor");
    		this.dispose();
		}
		
		ArrayList<ArrayList<String>> tarefas = new ArrayList<ArrayList<String>>();
		
		for (TarefaProgressiva tarefa : listaTarefasProgressiva) {
			
			listaTarefasParaEditar.add(tarefa);
			
			ArrayList<String> listaAux= new ArrayList<String>();
			
			listaAux.add(Long.toString(tarefa.getId()) );
			listaAux.add(tarefa.getTitulo() );
			listaAux.add(tarefa.getDescricao() );
			listaAux.add(tarefa.getData() );
			listaAux.add(Long.toString(tarefa.getProgresso()) );
			
			tarefas.add(listaAux);
		}
		return tarefas;
	}
	
    public TelaVisualizacaoDeTarefas(Usuario usuario) {
        geraVisualizacao(usuario);
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
    	
    	//tentando deixar a tabela nao editavel
    	
    	JTextField campoSemEdicao = new JTextField();
    	campoSemEdicao.setEditable(false);
    	DefaultCellEditor editor = new DefaultCellEditor( campoSemEdicao );
    	tabela.setDefaultEditor(Object.class, editor);
    	// fim
    	
    	return tabela;
    }
    
    private void geraVisualizacao(final Usuario usuario) {
    	
    	final ArrayList<Tarefa> listaTarefasParaEditar = new ArrayList<Tarefa>();
    	
    	String[] colunasLembretes = {"Id", "Títutlo", "Descricao", "Data", "Hora"};
	    JTable lembretes = converteMatrizParaJTable(obtemMatrizDeLembretes(usuario, listaTarefasParaEditar), colunasLembretes); 
	    lembretes.setName("Lembretes");
	    
	    String[] colunasTarefasSimples = {"Id", "Título", "Descricao"};
	    JTable tarefasSimples = converteMatrizParaJTable(obtemMatrizDeTarefasSimples(usuario, listaTarefasParaEditar), colunasTarefasSimples);
	    tarefasSimples.setName("Tarefas Simples");
	    
	    String[] colunasTarefasProgressivas = {"Id", "Títutlo", "Descricao", "Data", "Progresso"};
	    JTable tarefasProgressivas = converteMatrizParaJTable(obtemMatrizDeTarefasProgressivas(usuario, listaTarefasParaEditar), colunasTarefasProgressivas);
	    tarefasProgressivas.setName("Tarefas Progressivas");

		// Create and set up the window.
		final JFrame frame = new JFrame("Minhas tarefas");

		// Display the window.
		frame.setSize(1000, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JTabbedPane jTabbedPaneContainer = new JTabbedPane();
		
		jTabbedPaneContainer.addTab("Lembretes", lembretes);
		jTabbedPaneContainer.addTab("Tarefas simples", tarefasSimples);
		jTabbedPaneContainer.addTab("Tarefas progressivas", tarefasProgressivas);

		frame.getContentPane().add(jTabbedPaneContainer);
		
		//configurando o botao de editar
		
		jButtonEditar = new javax.swing.JButton();
		jButtonEditar.setText("Editar...");
		jButtonEditar.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				metodoAcaoClicarBotaoEditar(jTabbedPaneContainer, listaTarefasParaEditar, frame, usuario);
			} 
        });

		//configurando o botao de criar nova tarefa
		jButtonCriar = new javax.swing.JButton();
		jButtonCriar.setText("Criar");
		jButtonCriar.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				metodoAcaoClicarBotaoCriar(frame, usuario);
			} 
        });
		
		//configurando o botao de remover tarefa
		jButtonRemover = new javax.swing.JButton();
		jButtonRemover.setText("Remover");
		jButtonRemover.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				metodoAcaoClicarBotaoRemover(jTabbedPaneContainer, frame, listaTarefasParaEditar, usuario);
			} 
        });
		
		JPanel botoes = new JPanel();
	    BoxLayout layoutBotao = new BoxLayout(botoes, BoxLayout.LINE_AXIS);
	    botoes.setLayout(layoutBotao);
	    botoes.add(jButtonEditar);
	    botoes.add(jButtonCriar);
	    botoes.add(jButtonRemover);
	    
	    JPanel p = new JPanel(new BorderLayout());
	    p.add(botoes, BorderLayout.PAGE_END);

	    //adicionando os elementos a tela
	    jTabbedPaneContainer.add(botoes);
	    frame.add(jTabbedPaneContainer);
		frame.add(botoes, BorderLayout.PAGE_END);
    }

    
    void metodoAcaoClicarBotaoRemover (JTabbedPane jTabbedPaneContainer, JFrame frame, ArrayList<Tarefa> listaTarefasParaEditar, Usuario usuario) {
		
    	int abaAtual = jTabbedPaneContainer.getSelectedIndex();
    	JTable tabela = (JTable) jTabbedPaneContainer.getComponentAt(abaAtual);
    	final String tipoTarefa = tabela.getName();
    	Object idElementoNoBanco = (Object) tabela.getModel().getValueAt(tabela.getSelectedRow(), 0);
    	
    	String idTarefaRemocaoPendente = idElementoNoBanco.toString();
    	
    	Tarefa tarefaRemocaoPendente = buscaTarefaPorId(listaTarefasParaEditar, idTarefaRemocaoPendente);
    	
    	int result = JOptionPane.showConfirmDialog((Component) null, "tem certeza?", "alert", JOptionPane.OK_CANCEL_OPTION);
    	
    	if (result == 0) {
    		AcaoRemoveTarefa a = new AcaoRemoveTarefa();
        	a.remove(tarefaRemocaoPendente);
        	frame.dispose();
        	new TelaVisualizacaoDeTarefas(usuario);
        	JOptionPane.showMessageDialog(null, "Tarefa removida com sucesso!");
    	}
	}
    
    void metodoAcaoClicarBotaoEditar (JTabbedPane jTabbedPaneContainer, final ArrayList<Tarefa> listaTarefasParaEditar, JFrame frame, final Usuario usuario) {
		
    	int abaAtual = jTabbedPaneContainer.getSelectedIndex();
    	
    	JTable tabela = (JTable) jTabbedPaneContainer.getComponentAt(abaAtual);
    	final String tipoTarefa = tabela.getName();
    	Object idElementoNoBanco = (Object) tabela.getModel().getValueAt(tabela.getSelectedRow(), 0);
    	
    	final ArrayList<String> nomesColunas = new ArrayList<String>();
    	final ArrayList<String> conteudoColunas = new ArrayList<String>();
    	
    	for (int i = 0; i < tabela.getColumnCount(); i++) {
    		
    		nomesColunas.add(tabela.getModel().getColumnName(i));
    		conteudoColunas.add(tabela.getModel().getValueAt(tabela.getSelectedRow(), i).toString());
    	}
    	java.awt.EventQueue.invokeLater(new Runnable() {
    		public void run() {
    			new TelaEdicaoDeTarefas(nomesColunas, conteudoColunas, listaTarefasParaEditar, usuario);
    		}
    	});    	
    	frame.dispose();
	}
    
    void metodoAcaoClicarBotaoCriar (JFrame frame, final Usuario usuario) {
    	
    	java.awt.EventQueue.invokeLater(new Runnable() {
    		public void run() {
    			java.awt.EventQueue.invokeLater(new Runnable() {
    	    		public void run() {
    	    			new TelaCriarTarefa(usuario).setVisible(true);;
    	    		}
    	    	});
    		}
    	});    	
    	frame.dispose();
	}

	public javax.swing.JTabbedPane getjTabbedPaneContainer() {
		return jTabbedPaneContainer;
	}

	public void setjTabbedPaneContainer(javax.swing.JTabbedPane jTabbedPaneContainer) {
		this.jTabbedPaneContainer = jTabbedPaneContainer;
	}
}