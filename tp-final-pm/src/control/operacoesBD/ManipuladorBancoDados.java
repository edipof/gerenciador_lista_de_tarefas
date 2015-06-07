package control.operacoesBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class ManipuladorBancoDados {
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

	@SuppressWarnings("rawtypes")
	public abstract <T> ArrayList selectListaEntidade() throws SQLException;
	
	public abstract Boolean insereEntidade(Object o);
	
	public abstract void atualizaEntidade(Object o);
	
	public abstract Boolean removeEntidade(Object object);
}
