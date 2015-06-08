package bancoDeDados;

import java.sql.*;
/*
 * CLASSE COM METODO MAIN PROPRIO USADAS APENAS PARA
 * CRIAR O BANCO DE DADOS.
 * 
 * NAO RODA JUNTO COM O PROGRAMA PRINCIPAL
 */

public class CriaBancoDeDados {
	public static void main( String args[] )
	  {
	    Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:banco.db");
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      String tabelaUsuario = "CREATE  TABLE IF NOT EXISTS USUARIO "
	      		+ "( ID INTEGER PRIMARY KEY AUTOINCREMENT, "
	      		+ "NOME VARCHAR(45) ); ";
	      
	      String tabelaTarefa = "CREATE  TABLE IF NOT EXISTS TAREFA "
	      		+ "( ID INTEGER PRIMARY KEY AUTOINCREMENT,"
	      		+ " TITULO VARCHAR(45) ,"
	      		+ "DESCRICAO VARCHAR(45),"
	      		+ "DATA VARCHAR(10),"
	      		+ "HORA VARCHAR(10),"
	      		+ "PROGRESSO VARCHAR(45),"
	      		+ "USUARIO_ID INTEGER NOT NULL ,"
	      		+"FOREIGN KEY(USUARIO_ID) REFERENCES USUARIO(ID)"
	      		+ "ON DELETE NO ACTION "
	      		+ "ON UPDATE NO ACTION);";
	      
	      String sql =  tabelaUsuario + tabelaTarefa;
	      stmt.executeUpdate(sql);
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Table created successfully");
	  }
}
