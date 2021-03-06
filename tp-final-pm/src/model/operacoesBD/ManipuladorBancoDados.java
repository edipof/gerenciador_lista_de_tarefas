package model.operacoesBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class ManipuladorBancoDados<T> {
	private ComandosSqlSingleton sql = ComandosSqlSingleton.getInstance();
	
	public Connection getConnection() throws SQLException {
		Connection con = null;
		con = DriverManager
				.getConnection("jdbc:sqlite:banco.db");
		return con;
	}
	
	public void closeConnnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ComandosSqlSingleton getComandosSQL(){
		return sql;
	}

	public abstract  ArrayList<T> selectListaEntidade() throws SQLException;
	
	public abstract ArrayList<T> selectListaEntidadeComParametro(Object o) throws SQLException;
	
	public abstract Boolean insereEntidade(Object... objects);
	
	public abstract void atualizaEntidade(Object... objects);
	
	public abstract Boolean removeEntidade(Object... objects);
}
