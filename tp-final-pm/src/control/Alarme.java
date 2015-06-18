package control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.entidade.Lembrete;
import model.entidade.Usuario;
import model.operacoesBD.ManipuladorTarefaLembrete;
import view.TelaAlarme;


public class Alarme implements Runnable{
	ArrayList<Lembrete> lembretes;
	Usuario usuario;
	
	public Alarme(Usuario usuario){
		this.usuario = usuario;
	}
	
	public Date getDataHoraAtual(){
		Date trialTime = new Date();
        return  trialTime;
	}
	
	private void getLembretes(){
		ManipuladorTarefaLembrete l = ManipuladorTarefaLembrete.getInstance();
		this.lembretes = l.selectListaEntidadeComParametro(this.usuario);
	}
	
	@Override
	public void run(){
		String data_atual;
		String hora_atual;
		String data_formato = "dd/MM/yyyy";
		String hora_formato = "HH:mm";
		while(true){
			getLembretes();
			
			//Pegando a data e hora do sistema
			java.util.Date agora = new java.util.Date();;
			SimpleDateFormat formata = new SimpleDateFormat(data_formato);
			data_atual = formata.format(agora);
			formata = new SimpleDateFormat(hora_formato);
			hora_atual = formata.format(agora);
			//--------------
			if (!this.lembretes.isEmpty()){
				for (Lembrete l: this.lembretes){
					if (l.getData().equals(data_atual)  && l.getHora().equals(hora_atual)){
						@SuppressWarnings("unused")
						TelaAlarme ta = new TelaAlarme(l);
					}
				}
			}
			try {
				Thread.sleep(59000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
