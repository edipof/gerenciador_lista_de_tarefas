package control;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.entidade.Lembrete;
import model.entidade.TarefaProgressiva;
import model.entidade.TarefaSimples;
import model.entidade.Usuario;
import model.operacoesBD.ManipuladorBancoDados;
import model.operacoesBD.ManipuladorTarefaLembrete;
import model.operacoesBD.ManipuladorTarefaProgressiva;
import model.operacoesBD.ManipuladorTarefaSimples;

public class AcaoVisualizaTarefa {
	
	public ArrayList<TarefaSimples> getListaTarefasSimples(JFrame frame, Usuario usuario){
		ManipuladorBancoDados<TarefaSimples> tarefaDTO = new ManipuladorTarefaSimples();
		ArrayList<TarefaSimples>listaTarefasSimples = new ArrayList<TarefaSimples>();
		
		try{
			listaTarefasSimples = tarefaDTO.selectListaEntidadeComParametro(usuario);
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Erro inesperado na aplicação");
			frame.dispose();
		}
		
		return listaTarefasSimples;
	}
	
	public ArrayList<Lembrete> getListaLembrete(JFrame frame, Usuario usuario){
		ManipuladorBancoDados<Lembrete> lembreteDTO = new ManipuladorTarefaLembrete();
		
		ArrayList<Lembrete> listaLembretes = new ArrayList<Lembrete>();
		
		try{
			listaLembretes = lembreteDTO.selectListaEntidadeComParametro(usuario);
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Erro inesperado na aplicação");
    		frame.dispose();
		}
		return listaLembretes;
	}
	
	public ArrayList<TarefaProgressiva> getListaTarefasProgressiva(JFrame frame, Usuario usuario){
		ManipuladorBancoDados<TarefaProgressiva> tarefaDTO = new ManipuladorTarefaProgressiva();
		ArrayList<TarefaProgressiva> listaTarefasProgressiva = new ArrayList<TarefaProgressiva>();
		
		try{
			listaTarefasProgressiva = tarefaDTO.selectListaEntidadeComParametro(usuario);
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Erro inesperado na aplicação");
    		frame.dispose();
		}
		
		return listaTarefasProgressiva;
	}
	
}
