package view;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import control.AcaoCriaTarefa;
import model.Lembrete;
import model.TarefaProgressiva;
import model.TarefaSimples;
import model.Usuario;
import model.dao.DAO;
import model.dao.DaoLembrete;
import model.dao.DaoTarefaProgressiva;
import model.dao.DaoTarefaSimples;

public class TelaCriarTarefa extends javax.swing.JFrame {
	
	private javax.swing.JButton jButtonSalvar;
	  
	private javax.swing.JLabel jLabelTSTitulo;
	private javax.swing.JLabel jLabelTSDescricao;
	private javax.swing.JLabel jLabelTPTitulo;
	private javax.swing.JLabel jLabelTPDescricao;
	private javax.swing.JLabel jLabelTPData;
	private javax.swing.JLabel jLabelTPProgresso;
	private javax.swing.JLabel jLabelLTitulo;
	private javax.swing.JLabel jLabelLDescricao;
	private javax.swing.JLabel jLabelLData;
	private javax.swing.JLabel jLabelLHora;
	
	private javax.swing.JPanel jPanelTarefaSimples;
	private javax.swing.JPanel jPanelTarefaProgressiva;
	private javax.swing.JPanel jPanelLembrete;
	
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTabbedPane jTabbedPaneContainer;
	
	private javax.swing.JTextField jTextFieldTSTitulo;
	private JTextArea jTextAreaFieldTSDescricao;
	private javax.swing.JTextField jTextFieldTPTitulo;
	private JTextArea jTextAreaFieldTPDescricao;
	private javax.swing.JTextField jTextFieldTPData;
	private javax.swing.JTextField jTextFieldTPProgresso;
	private javax.swing.JTextField jTextFieldLTitulo;
	private JTextArea jTextAreaFieldLDescricao;
	private javax.swing.JTextField jTextFieldLData;
	private javax.swing.JTextField jTextFieldLHora;
   
    public TelaCriarTarefa(Usuario u) {
        initComponents(u);
    }
  
    private void initComponents(final Usuario u) {
    	//(1)
    	jTabbedPaneContainer = new javax.swing.JTabbedPane();
    	jPanelTarefaSimples = new javax.swing.JPanel();
        jPanelTarefaProgressiva = new javax.swing.JPanel();
        jPanelLembrete = new javax.swing.JPanel();
        jTabbedPaneContainer.add("Tarefa Simples", jPanelTarefaSimples);
        jTabbedPaneContainer.add("Tarefa Progressiva", jPanelTarefaProgressiva);
        jTabbedPaneContainer.add("Lembrete", jPanelLembrete);
        //(2)
        jScrollPane1 = new javax.swing.JScrollPane();
        //jTextAreaObservacao = new javax.swing.JTextArea();
        jButtonSalvar = new javax.swing.JButton();
        jLabelTSTitulo = new javax.swing.JLabel();
        jLabelTSDescricao = new javax.swing.JLabel();
        jLabelTPTitulo = new javax.swing.JLabel();
        jLabelTPDescricao = new javax.swing.JLabel();
        jLabelTPData = new javax.swing.JLabel();
        jLabelTPProgresso = new javax.swing.JLabel();
        jLabelLTitulo = new javax.swing.JLabel();
        jLabelLDescricao = new javax.swing.JLabel();
        jLabelLData = new javax.swing.JLabel();
        jLabelLHora = new javax.swing.JLabel();
      
        jTextFieldTSTitulo = new javax.swing.JTextField();
        jTextAreaFieldTSDescricao = new javax.swing.JTextArea();
        
        jTextFieldTPTitulo = new javax.swing.JTextField();
        jTextAreaFieldTPDescricao = new javax.swing.JTextArea();
        jTextFieldTPData = new javax.swing.JTextField();
        jTextFieldTPProgresso = new javax.swing.JTextField();
        
        jTextFieldLTitulo = new javax.swing.JTextField();
        jTextAreaFieldLDescricao = new javax.swing.JTextArea();
        jTextFieldLData = new javax.swing.JTextField();
        jTextFieldLHora = new javax.swing.JTextField();
        //(3)
        jLabelTSTitulo.setText("Titulo");
        jLabelTSDescricao.setText("Descricao");
        
        jLabelTPTitulo.setText("Titulo");
        jLabelTPDescricao.setText("Descricao");
        jLabelTPData.setText("Data");
        jLabelTPProgresso.setText("Progresso");
        
        jLabelLTitulo.setText("Titulo");
        jLabelLDescricao.setText("Descricao");
        jLabelLData.setText("Data");
        jLabelLHora.setText("Hora");
        
        setTitle("Criar Tarefa");
        jTextAreaFieldTSDescricao.setColumns(20);
        jTextAreaFieldTSDescricao.setRows(5);
        jTextAreaFieldTPDescricao.setColumns(20);
        jTextAreaFieldTPDescricao.setRows(5);
        jTextAreaFieldLDescricao.setColumns(20);
        jTextAreaFieldLDescricao.setRows(5);
        jScrollPane1.setViewportView(jTextAreaFieldTSDescricao);
        //jTextAreaObservacao.setColumns(20);
        //jTextAreaObservacao.setRows(5);
        //jScrollPane1.setViewportView(jTextAreaObservacao);
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt, u);
            }
        });
        //(4)
        javax.swing.GroupLayout jPanelTarefaSimplesLayout = new javax.swing.GroupLayout(jPanelTarefaSimples);
        jPanelTarefaSimples.setLayout(jPanelTarefaSimplesLayout);
        jPanelTarefaSimplesLayout.setHorizontalGroup(
          jPanelTarefaSimplesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTarefaSimplesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTarefaSimplesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldTSTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTSTitulo)
                    .addComponent(jTextAreaFieldTSDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTSDescricao))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        jPanelTarefaSimplesLayout.setVerticalGroup(
          jPanelTarefaSimplesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTarefaSimplesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTSTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTSTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelTSDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextAreaFieldTSDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        
        javax.swing.GroupLayout jPanelTarefaProgressivaLayout = new javax.swing.GroupLayout(jPanelTarefaProgressiva);
        jPanelTarefaProgressiva.setLayout(jPanelTarefaProgressivaLayout);
        jPanelTarefaProgressivaLayout.setHorizontalGroup(
          jPanelTarefaProgressivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTarefaProgressivaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTarefaProgressivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldTPTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTPTitulo)
                    .addComponent(jTextAreaFieldTPDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTPDescricao)
                    .addComponent(jTextFieldTPData, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTPData)
                    .addComponent(jTextFieldTPProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTPProgresso))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        jPanelTarefaProgressivaLayout.setVerticalGroup(
          jPanelTarefaProgressivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTarefaProgressivaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTPTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTPTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelTPDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextAreaFieldTPDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelTPData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTPData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelTPProgresso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTPProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        
           
        javax.swing.GroupLayout jPanelLembreteLayout = new javax.swing.GroupLayout(jPanelLembrete);
        jPanelLembrete.setLayout(jPanelLembreteLayout);
        jPanelLembreteLayout.setHorizontalGroup(
          jPanelLembreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLembreteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLembreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextFieldLTitulo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextAreaFieldLDescricao, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLDescricao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldLData, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldLHora, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLHora, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(255, Short.MAX_VALUE))
        );
        jPanelLembreteLayout.setVerticalGroup(
          jPanelLembreteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLembreteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldLTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelLDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextAreaFieldLDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelLData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldLData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelLHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldLHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );  
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addContainerGap(182, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButtonSalvar))
                .addContainerGap())
        );
        pack();
    }
    
    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt, Usuario u) {//GEN-FIRST:event_jButtonSalvarActionPerformed
    	int i = jTabbedPaneContainer.getSelectedIndex();
    	Boolean dados_inseridos = false;

    	if (i == 0){
    		String ts_titulo = jTextFieldTSTitulo.getText();
        	String ts_desc = jTextAreaFieldTSDescricao.getText();
    		
        	if (ts_titulo.length() == 0 || ts_desc.length() == 0){
    			JOptionPane.showMessageDialog(null, "Preencha todos os campos");
    		}
    		else{
    			AcaoCriaTarefa a = new AcaoCriaTarefa(u);
    			a.insereTarefaSimples(ts_titulo, ts_desc);
				dados_inseridos = true;
    		}
    	}
    	else if (i == 1){
    		String tp_titulo = jTextFieldTPTitulo.getText();
        	String tp_desc = jTextAreaFieldTPDescricao.getText();
        	String tp_data = jTextFieldTPData.getText();
        	Long tp_progresso;
        	try{
        		tp_progresso = Long.parseLong(jTextFieldTPProgresso.getText());
        	}
        	catch (Exception e){
        		JOptionPane.showMessageDialog(null, "O campo progresso deve possuir um inteiro");
        		return;
        	}
        	if (tp_titulo.length() == 0 || tp_desc.length() == 0 || tp_data.length() == 0){//Olhar tp_progresso
    			JOptionPane.showMessageDialog(null, "Preencha todos os campos");
    		}
    		else{
    			if (tp_data.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})") == false){
    				JOptionPane.showMessageDialog(null, "A data deve estar no formato dd/mm/aaaa");
    				return;
            	}
    			AcaoCriaTarefa a = new AcaoCriaTarefa(u);
    			a.insereTarefaProgressiva(tp_titulo, tp_desc, tp_data, tp_progresso);
	    		dados_inseridos = true;
    		}
    	}
    	else if (i == 2){
    		String l_titulo = jTextFieldLTitulo.getText();
        	String l_desc = jTextAreaFieldLDescricao.getText();
        	String l_data = jTextFieldLData.getText();
        	String l_hora = jTextFieldLHora.getText();
    		
        	if (l_titulo.length() == 0 || l_desc.length() == 0 || l_data.length() == 0 || l_hora.length() == 0){
    			JOptionPane.showMessageDialog(null, "Preencha todos os campos");
    		}
    		else{
    			if (l_data.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})") == false){
    				JOptionPane.showMessageDialog(null, "A data deve estar no formato dd/mm/aaaa");
    				return;
            	}
    			else if (l_hora.matches("([0-9]{2}):([0-9]{2})") == false){
    				JOptionPane.showMessageDialog(null, "A hora deve estar no formato HH:MM");
    				return;
            	}
    			AcaoCriaTarefa a = new AcaoCriaTarefa(u);
    			a.insereLembrete(l_titulo, l_desc, l_data, l_hora);
				dados_inseridos = true;
    		}
    	}
    	if (dados_inseridos){
    		JOptionPane.showMessageDialog(null, "Tarefa salva com sucesso");
    		this.dispose();
    		new TelaVisualizacaoDeTarefas(u.getNome());
    	}
    }//GEN-LAST:event_jButtonSalvarActionPerformed
  	      
}