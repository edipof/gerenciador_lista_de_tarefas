package control.operacoesBD;

public class ComandosSqlSingleton {
	// INSTANCIA UNICA DA CLASSE
	private static ComandosSqlSingleton instancia;
	// CRUD USUARIO
	private final String SELECT_USUARIO = "";
	private final String INSERT_USUARIO = "";
	private final String DELETE_USUARIO = "";
	private final String UPDATE_USUARIO = "";

	// CRUD TAREFAS POR USUARIO
	private final String SELECT_TAREFA_SIMPLES_POR_USUARIO = "";
	private final String SELECT_TAREFA_LEMBRETE_POR_USUARIO = "";
	private final String SELECT_TAREFA_PROGRESSIVA_POR_USUARIO = "";

	private final String INSERT_TAREFA_SIMPLES_POR_USUARIO = "";
	private final String INSERT_TAREFA_LEMBRETE_POR_USUARIO = "";
	private final String INSERT_TAREFA_PROGRESSIVA_POR_USUARIO = "";

	private final String DELETE_TAREFA_SIMPLES_POR_USUARIO = "";
	private final String DELETE_TAREFA_LEMBRETE_POR_USUARIO = "";
	private final String DELETE_TAREFA_PROGRESSIVA_POR_USUARIO = "";

	private final String UPDATE_TAREFA_SIMPLES_POR_USUARIO = "";
	private final String UPDATE_TAREFA_LEMBRETE_POR_USUARIO = "";
	private final String UPDATE_TAREFA_PROGRESSIVA_POR_USUARIO = "";

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

	public String getINSERT_TAREFA_SIMPLES_POR_USUARIO() {
		return INSERT_TAREFA_SIMPLES_POR_USUARIO;
	}

	public String getINSERT_TAREFA_LEMBRETE_POR_USUARIO() {
		return INSERT_TAREFA_LEMBRETE_POR_USUARIO;
	}

	public String getINSERT_TAREFA_PROGRESSIVA_POR_USUARIO() {
		return INSERT_TAREFA_PROGRESSIVA_POR_USUARIO;
	}

	public String getDELETE_TAREFA_SIMPLES_POR_USUARIO() {
		return DELETE_TAREFA_SIMPLES_POR_USUARIO;
	}

	public String getDELETE_TAREFA_LEMBRETE_POR_USUARIO() {
		return DELETE_TAREFA_LEMBRETE_POR_USUARIO;
	}

	public String getDELETE_TAREFA_PROGRESSIVA_POR_USUARIO() {
		return DELETE_TAREFA_PROGRESSIVA_POR_USUARIO;
	}

	public String getUPDATE_TAREFA_SIMPLES_POR_USUARIO() {
		return UPDATE_TAREFA_SIMPLES_POR_USUARIO;
	}

	public String getUPDATE_TAREFA_LEMBRETE_POR_USUARIO() {
		return UPDATE_TAREFA_LEMBRETE_POR_USUARIO;
	}

	public String getUPDATE_TAREFA_PROGRESSIVA_POR_USUARIO() {
		return UPDATE_TAREFA_PROGRESSIVA_POR_USUARIO;
	}
}
