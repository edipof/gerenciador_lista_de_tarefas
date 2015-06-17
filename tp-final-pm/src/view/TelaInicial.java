package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

import model.entidade.Usuario;
import control.AcaoTelaInicial;
import control.Alarme;

public class TelaInicial extends Tela {
	
	private static final long serialVersionUID = 5222388480306127381L;

	AcaoTelaInicial tl = new AcaoTelaInicial();
	
	private JTextField jTextFieldNovoUsuario; 
	
	private JLabel jLabelUsuarioNovo;
	private JLabel jLabelCabecalhoNovoUsuario;
	private JLabel jLabelCabecalhoSelecionaUsuario;
	
	private JPanel jPanelUsuario;
	private JPanel jPanelSelecionaUsuario;
	
	private JComboBox<String> jComboBoxListaUsuarios;
	
	private JButton jButtonEntrarNovoUsuario;
	private JButton jButtonEntrarUsuarioExistente;	
	private JButton jButtonRemoveUsuario;
	
	public TelaInicial() {
		initComponents();
	}
	
	private void buscaTodosUsuarios(){
		 
		ArrayList<Usuario> array = new ArrayList<Usuario>();
		String item = "";
		try {
			array = tl.buscarListaUsuarios();
		} catch (SQLException e) {
			e.printStackTrace();
		}        
        
        for (Usuario usuario : array) {
            item = usuario.getNome();    
            jComboBoxListaUsuarios.addItem(item);
        }    
	}
	
	
	public void entrarNovoUsuarioActionPerformed(ActionEvent e) {
		
		boolean dadosInseridos = false;
		String nomeUsuario = jTextFieldNovoUsuario.getText();
		if (nomeUsuario.length() == 0){
			JOptionPane.showMessageDialog(null, "Favor, entre com um nome de usuario!");
		} else {
			tl.adicionaNovoUsuario(nomeUsuario);
			dadosInseridos = true;
		}
		
		if (dadosInseridos){
			 mensagemBoasVindas(nomeUsuario);
		}
	}

	private void entrarUsuarioExistenteActionPerformed(ActionEvent evt) {
		
		String nomeUsuario = jComboBoxListaUsuarios.getSelectedItem().toString();
		if (nomeUsuario.length() == 0){
			JOptionPane.showMessageDialog(null, "Favor, Selecione um Usuário!");
		} else {
			 mensagemBoasVindas(nomeUsuario);
		}
	}
	
	private void mensagemBoasVindas(String nomeUsuario){
		JOptionPane.showMessageDialog(null, "Bem Vindo, " + nomeUsuario + ", ao Sistema ÉFIFOTaskManager!");
		Usuario usuario = tl.buscaUmUsuario(nomeUsuario);
		Thread alarme = new Thread(new Alarme(usuario));
		alarme.start();
		new TelaVisualizacaoDeTarefas(usuario);
		this.dispose();
	}
	private void removerUsuarioExistenteActionPerformed(ActionEvent e) {
		String nomeUsuario = jComboBoxListaUsuarios.getSelectedItem().toString();
		Usuario usuarioExcluido = tl.buscaUmUsuario(nomeUsuario);
		if (usuarioExcluido == null){
			JOptionPane.showMessageDialog(null, "Usuário Inexistente!!");
		} else {
			tl.removeUsuario(usuarioExcluido);
			JOptionPane.showMessageDialog(null, "Usuario Excluido com Sucesso");
			this.dispose();
			java.awt.EventQueue.invokeLater(new Runnable() {
	    		public void run() {
	    			new TelaInicial();
	    		}
	    	});

		}
	}
	
	private void initComponents(){
		
		setSize(600,280);
		setLayout(new GridLayout(4, 1));
		//Painel com instrução para criação de novo Usuario
		jLabelCabecalhoNovoUsuario = new JLabel("Entre com um Novo Usuario:", JLabel.CENTER);
		jLabelCabecalhoNovoUsuario.setSize(150, 70);
		
		//Painel de criação de novo usuario
		jPanelUsuario = new JPanel();
		jPanelUsuario.setLayout(new FlowLayout());
		jLabelUsuarioNovo = new JLabel("Usuário: ");
		jTextFieldNovoUsuario = new JTextField(15);
		jButtonEntrarNovoUsuario = new JButton("Criar");
		jButtonEntrarNovoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
                entrarNovoUsuarioActionPerformed(evt);
            }
        });
		jPanelUsuario.add(jLabelUsuarioNovo);
		jPanelUsuario.add(jTextFieldNovoUsuario);
		jPanelUsuario.add(jButtonEntrarNovoUsuario);
		
		
		//Painel com instrução para a Seleção usuarios
		jLabelCabecalhoSelecionaUsuario = new JLabel("Selecione um já existente na lista abaixo:", JLabel.CENTER);
		jLabelCabecalhoSelecionaUsuario.setSize(150, 70);
		
		//Painel com JComboBox para seleção dos usuarios
		jPanelSelecionaUsuario = new JPanel();
		jPanelSelecionaUsuario.setLayout(new FlowLayout());
		jComboBoxListaUsuarios = new JComboBox<String>();
		jComboBoxListaUsuarios.setMaximumRowCount(5);
		buscaTodosUsuarios();
		jButtonEntrarUsuarioExistente = new JButton("Entrar");
		jButtonEntrarUsuarioExistente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
                entrarUsuarioExistenteActionPerformed(evt);
            }
        });
		jButtonRemoveUsuario = new JButton("Remover");
		jButtonRemoveUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerUsuarioExistenteActionPerformed(e);
			}
		});
		jPanelSelecionaUsuario.add(jComboBoxListaUsuarios);
		jPanelSelecionaUsuario.add(jButtonEntrarUsuarioExistente);
		jPanelSelecionaUsuario.add(jButtonRemoveUsuario);
		add(jLabelCabecalhoNovoUsuario);
		add(jPanelUsuario);
		add(jLabelCabecalhoSelecionaUsuario);
		add(jPanelSelecionaUsuario);
		
		setVisible(true);
	}
	
}