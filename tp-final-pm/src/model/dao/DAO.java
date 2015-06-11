package model.dao;

import java.util.ArrayList;

public abstract class DAO<T,P> {
	
	public ArrayList<T> getLista(){
		return null;
	}
	public ArrayList<T> getLista(P p){
		return null;
	}
	public void insere(T t){
		
	}
	
	public void insere(T t, P p){
		
	}
	
	public void atualiza(T t){
		
	}
	
	public void delete(T t){
		
	}
}
