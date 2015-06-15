package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

import model.Usuario;
import control.AcaoTelaInicial;

public class TelaInicial extends JFrame {
	
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
	
	public TelaInicial() {
		// TODO Stub de construtor gerado automaticamente
		super("EFIFO - Gerenciador de Tarefas");
		initComponents();
	}
	
	private void buscaTodosUsuarios(){
		 
		ArrayList<Usuario> array = null;
		String item = null;
		try {
			array = tl.buscarListaUsuarios();
		} catch (SQLException e) {
			e.printStackTrace();
		}        
        
        for (Usuario usuario : array) {
        //	System.out.println(usuario.getNome());
            item = usuario.getNome();    
            jComboBoxListaUsuarios.addItem(item);
//            System.out.println(usuario.getNome());
        }    
	}
	
	
	public void entrarNovoUsuarioActionPerformed(ActionEvent e) {
		// TODO Stub de método gerado automaticamente
		boolean dadosInseridos = false;
		String nomeUsuario = jTextFieldNovoUsuario.getText();
		if (nomeUsuario.length() == 0){
			JOptionPane.showMessageDialog(null, "Favor, entre com um nome de usuario!");
		} else {
			tl.adicionaNovoUsuario(nomeUsuario);
			dadosInseridos = true;
		}
		
		if (dadosInseridos){
			JOptionPane.showMessageDialog(null, "Bem Vindo, " + nomeUsuario + ", ao Sistema EFIFO - Gerenciador de Tarefas!");
			new TelaVisualizacaoDeTarefas(nomeUsuario);
		}
	}
	
	private void entrarUsuarioExistenteActionPerformed(ActionEvent evt) {
		// TODO Stub de método gerado automaticamente
		String nomeUsuario = jComboBoxListaUsuarios.getSelectedItem().toString();
		if (nomeUsuario.length() == 0){
			JOptionPane.showMessageDialog(null, "Favor, Selecione um Usuário!");
		} else {
			JOptionPane.showMessageDialog(null, "Bem Vindo, " + nomeUsuario + ", ao Sistema EFIFO - Gerenciador de Tarefas!");
			new TelaVisualizacaoDeTarefas(nomeUsuario);
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
		jButtonEntrarNovoUsuario = new JButton("Entrar");
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
		jPanelSelecionaUsuario.add(jComboBoxListaUsuarios);
		jPanelSelecionaUsuario.add(jButtonEntrarUsuarioExistente);
		
		add(jLabelCabecalhoNovoUsuario);
		add(jPanelUsuario);
		add(jLabelCabecalhoSelecionaUsuario);
		add(jPanelSelecionaUsuario);
		
		setVisible(true);
	}
	
}