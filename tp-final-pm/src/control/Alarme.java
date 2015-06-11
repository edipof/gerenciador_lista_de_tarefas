package control;

import view.TelaAlarme;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import model.dao.DaoLembrete;
import model.Lembrete;
import java.util.ArrayList;
import view.TelaAlarme;

public class Alarme implements Runnable{
	ArrayList<Lembrete> lembretes = new ArrayList<Lembrete>();
	
	public Alarme(){
		Thread a = new Thread(new Alarme());
		a.run();
	}
	
	public Date getDataHoraAtual(){
		Date trialTime = new Date();
        return  trialTime;
	}
	
	private void getLembretes(){
		DaoLembrete l = new DaoLembrete();
		this.lembretes = l.getLista();
	}
	
	@Override
	public void run(){
		Date data_hora;
		String data_atual;
		String hora_atual;
		while(true){
			getLembretes();
			data_hora = getDataHoraAtual();
			data_atual = data_hora.toString();//Tem que pegar a data sozinha e a hora sozinha ainda
			hora_atual = data_hora.toString();//Tem que pegar a data sozinha e a hora sozinha ainda
			for (Lembrete l: this.lembretes){
				if (l.getData() == data_atual  && l.getHora() == hora_atual){
					TelaAlarme ta = new TelaAlarme(l);
				}
			}
		}
	}
}
