package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TelaInicial extends JFrame {
	
	private String listaUsuario[] = {"Fulano", "Ciclano", "Beltrano"};
	private JTextField novoUsuario;
	private JList listaSelecionavel;
	private JButton entrar;
	
	public TelaInicial() {
		// TODO Stub de construtor gerado automaticamente
		super("EFIFO - Gerenciador de Tarefas");
		
		//Obtém painel de conteudo
		Container container = getContentPane();
		
		//Configura o Layout com o BorderLayout
		container.setLayout( new BorderLayout(30, 30));
		
		Box caixa[] = new Box[3];
		
		
		
		caixa[0] = Box.createHorizontalBox();
		caixa[1] = Box.createHorizontalBox();
		caixa[2] = Box.createHorizontalBox();
		
		JLabel mot = new JLabel("Entre com um Novo Usuario, ou selecione um pré-existente", SwingConstants.CENTER);  
		
		caixa[0].add(Box.createHorizontalStrut(20));
		
		caixa[0].add(mot);
		
		//Criando um leaiute relativo para os usuarios, tanto o novo quantos os pre-selecionados
		
		JPanel painelUsuario = new JPanel();
		
		
		novoUsuario = new JTextField(15);
		JLabel usuarioNovo = new JLabel("Usuário: ");
		//Configura o layout do painel na horizotal
		painelUsuario.add(usuarioNovo);
		painelUsuario.add(novoUsuario);

		entrar = new JButton("Entrar");
		painelUsuario.add(entrar);
		caixa[1].add(Box.createHorizontalStrut(20));
		caixa[1].add(painelUsuario);
		
	
		//Lista de Usuarios
		
		JPanel painelLista = new JPanel();
		
		listaSelecionavel = new JList(listaUsuario);
		listaSelecionavel.setVisibleRowCount(5);
		listaSelecionavel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaSelecionavel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		listaSelecionavel.setFixedCellWidth(210);
		painelLista.add(listaSelecionavel);
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
