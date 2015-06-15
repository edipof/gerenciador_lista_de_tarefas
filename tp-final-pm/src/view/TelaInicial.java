package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

import model.Usuario;
import control.AcaoTelaInicial;

public class TelaInicial extends JFrame {
	
	AcaoTelaInicial tl = new AcaoTelaInicial();
	JComboBox<String> listaUsuarios;
	private JTextField novoUsuario;
	//private JList<Usuario> listaSelecionavel;
	private JButton entrar;
	
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
            listaUsuarios.addItem(item);
//            System.out.println(usuario.getNome());
        }    
	}
	
	
	public void entrarActionPerformed(ActionEvent e) {
		// TODO Stub de método gerado automaticamente
		boolean dadosInseridos = false;
		String nome = novoUsuario.getText();
		if (nome.length() == 0){
			JOptionPane.showMessageDialog(null, "Favor, entre com um nome de usuario!");
		} else {
			AcaoTelaInicial tl = new AcaoTelaInicial();
			tl.adicionaNovoUsuario(nome);
			dadosInseridos = true;
		}
		
		if (dadosInseridos){
			JOptionPane.showMessageDialog(null, "Bem Vindo, " + nome + ", ao Sistema EFIFO - Gerenciador de Tarefas!");
			new TelaVisualizacaoDeTarefas(nome).setVisible(true);
		}
	}
	private void initComponents() {
		
		
		Box caixa[] = new Box[3];
		Container container = getContentPane();
		JLabel mot = new JLabel("Entre com um Novo Usuario, ou selecione um pré-existente", SwingConstants.CENTER);
		JPanel painelUsuario = new JPanel();
		JLabel usuarioNovo = new JLabel("Usuário: ");		
		
		
		//Configura o Layout com o BorderLayout
		container.setLayout( new BorderLayout(30, 30));
				
		
		caixa[0] = Box.createHorizontalBox();
		caixa[1] = Box.createHorizontalBox();
		caixa[2] = Box.createHorizontalBox();  
		
		caixa[0].add(Box.createHorizontalStrut(20));
		caixa[0].add(mot);
		
		//Criando um leaiute relativo para os usuarios, tanto o novo quantos os pre-selecionados
				
		novoUsuario = new JTextField(15);

		//Configura o layout do painel na horizotal
		painelUsuario.add(usuarioNovo);
		painelUsuario.add(novoUsuario);

		entrar = new JButton("Entrar");
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });
		
		painelUsuario.add(entrar);
		caixa[1].add(Box.createHorizontalStrut(20));
		caixa[1].add(painelUsuario);
		
	
		//Lista de Usuarios
		
		JPanel painelLista = new JPanel();
		listaUsuarios = new JComboBox<String>();
		buscaTodosUsuarios();
		painelLista.add(listaUsuarios);
		caixa[2].add(Box.createHorizontalStrut(50));
		caixa[2].add(painelLista);
		
		JPanel painelCentral = new JPanel();
		painelCentral.add(caixa[1]);
		painelCentral.add(caixa[2]);
		
		JPanel rodape = new JPanel(new FlowLayout(FlowLayout.LEFT));
		rodape.add(new JButton("Entrar"));
		caixa[2].add(rodape);
		//Anexa paineis na região do Container
		container.add(caixa[0], BorderLayout.NORTH);
		container.add(caixa[1], BorderLayout.CENTER);
		container.add(caixa[2], BorderLayout.SOUTH);
		setVisible(true);
		setSize(500, 250);

	}
	
	/* Comenta Tudo 
	public void exibirTela(){
		prepararJanela();
		preparPainel();
		BotaoSair();
		mostrarJanela();
	}

	private void inserirUsuario() {
		
		JPanel dadoUsuario = new JPanel();
		dadoUsuario.add(new JLabel("Usuário: "));
		dadoUsuario.add(new JTextField("Insira um novo Usuário"));
		
		JPanel dadoUsuarioBotao = new JPanel();
		dadoUsuarioBotao.add(new JButton("Iniciar"));
		
		painelUsuario.add(dadoUsuario);
		painelUsuario.add(dadoUsuarioBotao);
	}

	private void prepararJanela() {
		// TODO Stub de método gerado automaticamente
		tela = new JFrame("ÉFIFO - Gerenciador de Tarefas");
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void BotaoSair() {
		// TODO Stub de método gerado automaticamente
		JButton botaoSair = new JButton("Sair");
			botaoSair.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		tela.add(botaoSair);
	}

	private void preparPainel() {
		// prepara o painel superior (Usuario)
		painelPrincipal = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		painelUsuario = new JPanel();
		inserirUsuario();
		painelPrincipal.add(painelUsuario);
		//==========================================================
		
		//Prepara Painel Inferior (Lista de Usuario)
		
		listaUsuarios = new JPanel();
		criarListaUsuarios();
		painelPrincipal.add(listaUsuarios);
		
		tela.setContentPane(painelPrincipal);
	}

	private void criarListaUsuarios() {
		String teste[] = {"Fulano", "Ciclano", "Beltrano"}; 
		JPanel painelCombo = new JPanel();
		JComboBox dropdown = new JComboBox(teste);
		
		dropdown.setMaximumRowCount(3);
		
		painelCombo.add(dropdown);
		listaUsuarios.add(painelCombo);
		
		
	}

	private void mostrarJanela() {
		// TODO Stub de método gerado automaticamente
		tela.setSize(500, 250);
		tela.setVisible(true);	
	}
	
	Fim Do Comentario */
	

}
