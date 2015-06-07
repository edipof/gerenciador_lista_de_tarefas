package control.operacoesBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tarefa;
import model.Usuario;

public class TESTE {
	private final String SELECT_tarefa = "SELECT * FROM tarefa WHERE TEL_NUMERO = ?";
	private final String INSERT_usuario = "INSERT INTO usuarioS (PES_ID,PES_NOME) VALUES (?,?)";
	private final String SELECT_ALL_usuario = "SELECT * FROM usuarioS PES, tarefaS TEL WHERE PES.PES_ID=TEL.PES_ID";
	private final String INSERT_tarefa = "INSERT INTO tarefaS (TEL_ID,TEL_NUMERO,PES_ID) values ((SELECT NEXTVAL('SEQUENCE_ID')),?,?)";
	private final String DELETE_usuario = "DELETE FROM tarefas WHERE pes_id = ?;DELETE FROM usuarios WHERE pes_id = ?;";
	private final String SELECT_NEXT_SEQUENCE = "SELECT NEXTVAL('SEQUENCE_ID')";
	private boolean retorno = false;

	public Connection getConnection() throws SQLException {
		Connection con = null;
		con = DriverManager
				.getConnection("jdbc:postgresql://localhost/agenda_tarefa?user=postgres&password=postgres");
		return con;
	}

	public void closeConnnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	public boolean insertUsuario(USUARIO usuario) {
//		Connection con = null;
//		try {
//			con = getConnection();
//			PreparedStatement prepared = con.prepareStatement(INSERT_usuario);
//			prepared.setLong(1, usuario.getId());
//			prepared.setString(2, usuario.getNome());
//			retorno = prepared.execute();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			closeConnnection(con);
//		}
//		return retorno;
//	}

	public boolean removeusuario(Usuario usuario) throws SQLException {
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement prepared = con.prepareStatement(DELETE_usuario);
			prepared.setLong(1, usuario.getId());
			prepared.setLong(2, usuario.getId());
			retorno = prepared.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnnection(con);
		}
		return retorno;
	}

//	public List<usuario> selectusuario(usuario usuario) throws SQLException {
//		Connection con = null;
//		List<usuario> listusuario = new ArrayList<usuario>();
//		try {
//			con = getConnection();
//			PreparedStatement prepared = con
//					.prepareStatement(SELECT_ALL_usuario);
//			ResultSet resultSet = prepared.executeQuery();
//			while (resultSet.next()) {
//				usuario usuarioTmp = new usuario();
//				usuarioTmp.setId(resultSet.getLong("PES_ID"));
//				usuarioTmp.setNome(resultSet.getString("PES_NOME"));
//				usuarioTmp.settarefa(resultSet.getString("TEL_NUMERO"));
//				listusuario.add(usuarioTmp);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			closeConnnection(con);
//		}
//		return listusuario;
//	}

//	public boolean inserttarefa(Tarefa tarefa) throws SQLException {
//		Connection con = null;
//		try {
//			con = getConnection();
//			PreparedStatement prepared = con.prepareStatement(INSERT_tarefa);
//			prepared.setString(1, tarefa.getNumero());
//			prepared.setLong(2, tarefa.getusuario().getId());
//			retorno = prepared.execute();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			closeConnnection(con);
//		}
//		return retorno;
//	}

	public long getId() throws SQLException {
		Connection con = null;
		long id = 0;
		try {
			con = getConnection();
			PreparedStatement prepared = con
					.prepareStatement(SELECT_NEXT_SEQUENCE);
			ResultSet resultSet = prepared.executeQuery();
			while (resultSet.next())
				id = resultSet.getLong("nextval");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnnection(con);
		}
		return id;
	}

//	public List<Tarefa> selecttarefas(Tarefa tarefa)
//			throws SQLException {
//		Connection con = null;
//		List<Tarefa> listtarefa = new ArrayList<Tarefa>();
//		try {
//			con = getConnection();
//			PreparedStatement prepared = con.prepareStatement(SELECT_tarefa);
//			prepared.setString(1, tarefa.getNumero());
//			ResultSet resultSet = prepared.executeQuery();
//			while (resultSet.next()) {
//				Tarefa tarefaTmp = new Tarefa();
//				tarefaTmp.setId(resultSet.getLong("TEL_ID"));
//				tarefaTmp.setNumero(resultSet.getString("TEL_NUMERO"));
//				listtarefa.add(tarefaTmp);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			closeConnnection(con);
//		}
//		return listtarefa;
//	}

}
