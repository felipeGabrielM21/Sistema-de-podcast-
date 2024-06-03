package view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felip
 */
public class Listagem extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    private Cadastro telaCadastro;

    public Listagem() {
        initComponents();
        preencherTabela();
        Permissao(3);
    }

    private void preencherTabela() {

        modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        try (Connection conn = Conexao.obterConexao(); Statement stmt = conn.createStatement()) {
            String query = "SELECT * FROM cadastros";
            try (ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nomeEpisodio = rs.getString("nome_do_Episodio");
                    String numeroEpisodio = rs.getString("NumeroEp");
                    String duracao = rs.getString("DURACAO");
                    String urlRepo = rs.getString("URLRepo");
                    String produtor = rs.getString("produtor");

                    modelo.addRow(new Object[]{id, nomeEpisodio, numeroEpisodio, duracao, urlRepo, produtor});
                }

            }
        } catch (SQLException ex) {
            System.out.println("Erro ao preencher tabela: " + ex.getMessage());
        }
    }

    private void pesquisarPorProdutor(String produtor) {
        modelo.setNumRows(0); // Limpa os dados atuais da tabela

        try (Connection conn = Conexao.obterConexao(); Statement stmt = conn.createStatement()) {
            String query = "SELECT * FROM cadastros WHERE produtor LIKE '%" + produtor + "%'";
            try (ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String produtorResultado = rs.getString("produtor");
                    String nomeEpisodio = rs.getString("nome_do_Episodio");
                    String numeroEpisodio = rs.getString("NumeroEp");
                    String duracao = rs.getString("DURACAO");
                    String urlRepo = rs.getString("URLRepo");

                    modelo.addRow(new Object[]{id, nomeEpisodio, produtorResultado, numeroEpisodio, duracao, urlRepo});
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao pesquisar por produtor: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btCadastar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("CENAFILX");

        jLabel2.setText("LISTAGEM");

        jLabel3.setText("Pesquisar podcast por produtor");

        txtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome do Episódio", "N° episódio", "Duração", "URL do Repo", "Produtor"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btCadastar.setText("Cadastar");
        btCadastar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btExcluir)
                .addGap(44, 44, 44)
                .addComponent(btCadastar)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastar)
                    .addComponent(btExcluir))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastarActionPerformed

        telaCadastro = new Cadastro();
        telaCadastro.setVisible(true);

    }//GEN-LAST:event_btCadastarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

        int linhaSelecionada = jTable1.getSelectedRow();
        if (linhaSelecionada != -1) {
            int id = (int) jTable1.getValueAt(linhaSelecionada, 0);
            if (excluirRegistro(id)) {
                DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
                modelo.removeRow(linhaSelecionada);
                JOptionPane.showMessageDialog(this, "Registro excluído com sucesso.");

            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir o registro.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um registro para excluir.");
        }
    }

    private boolean excluirRegistro(int id) {
        UsuarioDao usuarioDao = new UsuarioDao(Conexao.obterConexao());
        int status = usuarioDao.excluirPorId(id);
        if (status == 1) {
            return true; // Exclusão bem-sucedida
        } else {
            return false; // Falha na exclusão
        }

    }//GEN-LAST:event_btExcluirActionPerformed

    private void txtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarActionPerformed

        String produtorPesquisa = txtPesquisar.getText();
        pesquisarPorProdutor(produtorPesquisa);

    }//GEN-LAST:event_txtPesquisarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Listagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Listagem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables

    public void Permissao(int i) {
        switch (i) {
            case 1: // Administrador
                btCadastar.setEnabled(true);
                btExcluir.setEnabled(true);
                break;
            case 2: // Operador
                btCadastar.setEnabled(true);
                btExcluir.setEnabled(false);

                break;
            case 3: // Usuário
                btCadastar.setEnabled(false);
                btExcluir.setEnabled(false);
                break;
            default:
                // Permissões padrão, por exemplo, desabilitar todos os botões
                btCadastar.setEnabled(false);
                btExcluir.setEnabled(false);
                break;
        }
    }
}
