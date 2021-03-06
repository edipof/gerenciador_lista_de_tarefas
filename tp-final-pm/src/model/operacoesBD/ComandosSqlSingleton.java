package model.operacoesBD;

public class ComandosSqlSingleton {
	// INSTANCIA UNICA DA CLASSE
	private static ComandosSqlSingleton instancia;
	// CRUD USUARIO
	private final String SELECT_USUARIO = "SELECT * FROM USUARIO";
	private final String INSERT_USUARIO = "INSERT INTO USUARIO (NOME) VALUES (?);";
	private final String DELETE_USUARIO = "DELETE FROM USUARIO WHERE ID = ?";
	private final String UPDATE_USUARIO = "UPDATE USUARIO SET NOME = ? WHERE ID = ?";

	// CRUD TAREFAS POR USUARIO
	private final String SELECT_TAREFA_SIMPLES_POR_USUARIO = "SELECT DISTINCT T.ID, T.TITULO, T.DESCRICAO " 
							+"FROM TAREFA T, USUARIO U " 
							+"WHERE T.USUARIO_ID = ? AND DATA IS NULL " 
							+"AND HORA IS NULL AND PROGRESSO IS NULL ";
	
	private final String SELECT_TAREFA_LEMBRETE_POR_USUARIO = "SELECT DISTINCT T.ID, T.TITULO, T.DESCRICAO,T.DATA,T.HORA, U.NOME " 
							+"FROM TAREFA T, USUARIO U " 
							+"WHERE T.USUARIO_ID = U.ID AND  U.ID = ?  " 
							+"AND HORA IS NOT NULL AND PROGRESSO IS NULL";																
					
	private final String SELECT_TAREFA_PROGRESSIVA_POR_USUARIO = "SELECT DISTINCT T.ID, T.TITULO, T.DESCRICAO,T.DATA, T.PROGRESSO, U.NOME "
							+ "FROM TAREFA T, USUARIO U "
							+ "WHERE T.USUARIO_ID = ? AND  U.ID = ?  AND HORA IS NULL "
							+ "AND PROGRESSO IS NOT NULL";
	
	private final String INSERT_TAREFA_SIMPLES_POR_USUARIO = "INSERT INTO TAREFA(TITULO, "
			+ "DESCRICAO,USUARIO_ID) VALUES (?, ?,?)";
	
	private final String INSERT_TAREFA_LEMBRETE_POR_USUARIO = "INSERT INTO TAREFA(TITULO, "
			+ "DESCRICAO,DATA,HORA, USUARIO_ID) VALUES (?, ?,?,?,?);";
	
	private final String INSERT_TAREFA_PROGRESSIVA_POR_USUARIO = "INSERT INTO TAREFA(TITULO, "
			+ "DESCRICAO,DATA,PROGRESSO, USUARIO_ID) VALUES (?, ?,?,?,?)";

	private final String DELETE_TAREFA = "DELETE FROM TAREFA WHERE ID = ?";

	private final String UPDATE_TAREFA_SIMPLES = "UPDATE TAREFA SET TITULO = ? ,"
			+ "DESCRICAO = ? WHERE ID = ?";
	
	private final String UPDATE_TAREFA_LEMBRETE = "UPDATE TAREFA SET TITULO = ? ,"
			+ "DESCRICAO = ?, HORA = ?,DATA = ? WHERE ID = ?";
	
	private final String UPDATE_TAREFA_PROGRESSIVA = "UPDATE TAREFA SET TITULO = ? , "
			+ "DESCRICAO = ?, DATA = ?,PROGRESSO = ? WHERE ID = ?";
	
	private final String UPDATE_PROGRESSO_TAREFA_PROGRESSIVA_POR_USUARIO = "UPDATE TAREFA SET PROGRESSO = '?' "
			+ "WHERE ID = ?";
	
	// criando singleton
	private ComandosSqlSingleton() {
	}

	public static synchronized ComandosSqlSingleton getInstance() {
		if (instancia == null)
			instancia = new ComandosSqlSingleton();
		return instancia;
	}

	public String getSELECT_USUARIO() {
		return SELECT_USUARIO;
	}

	public String getINSERT_USUARIO() {
		return INSERT_USUARIO;
	}

	public String getDELETE_USUARIO() {
		return DELETE_USUARIO;
	}

	public String getUPDATE_USUARIO() {
		return UPDATE_USUARIO;
	}

	public String getSELECT_TAREFA_SIMPLES_POR_USUARIO() {
		return SELECT_TAREFA_SIMPLES_POR_USUARIO;
	}

	public String getSELECT_TAREFA_LEMBRETE_POR_USUARIO() {
		return SELECT_TAREFA_LEMBRETE_POR_USUARIO;
	}

	public String getSELECT_TAREFA_PROGRESSIVA_POR_USUARIO() {
		return SELECT_TAREFA_PROGRESSIVA_POR_USUARIO;
	}

	public static ComandosSqlSingleton getInstancia() {
		return instancia;
	}

	public String getUPDATE_PROGRESSO_TAREFA_PROGRESSIVA_POR_USUARIO() {
		return UPDATE_PROGRESSO_TAREFA_PROGRESSIVA_POR_USUARIO;
	}

	public String getINSERT_TAREFA_SIMPLES_POR_USUARIO() {
		return INSERT_TAREFA_SIMPLES_POR_USUARIO;
	}

	public String getINSERT_TAREFA_LEMBRETE_POR_USUARIO() {
		return INSERT_TAREFA_LEMBRETE_POR_USUARIO;
	}

	public String getINSERT_TAREFA_PROGRESSIVA_POR_USUARIO() {
		return INSERT_TAREFA_PROGRESSIVA_POR_USUARIO;
	}

	public String getDELETE_TAREFA() {
		return DELETE_TAREFA;
	}

	public String getUPDATE_TAREFA_SIMPLES() {
		return UPDATE_TAREFA_SIMPLES;
	}

	public String getUPDATE_TAREFA_LEMBRETE() {
		return UPDATE_TAREFA_LEMBRETE;
	}

	public String getUPDATE_TAREFA_PROGRESSIVA() {
		return UPDATE_TAREFA_PROGRESSIVA;
	}
}
