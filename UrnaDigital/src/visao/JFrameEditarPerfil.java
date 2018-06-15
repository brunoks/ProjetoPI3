package visao;

import controle.GestorC;
import javax.swing.JOptionPane;
import modelo.dominio.Gestor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Editar Perfil do GESTOR
 *
 * @author AC/DC
 */
public class JFrameEditarPerfil extends javax.swing.JFrame {

    private GestorC gestorC = new GestorC();
    private Gestor sessaoAtiva = new Gestor();
    JFramePrincipal jfp = new JFramePrincipal();

    public JFrameEditarPerfil() {
        initComponents();
        setLocationRelativeTo(null);
    }

    //Salvar as informações da Sessão Ativa
    public void setSessaoAtiva(Gestor _gestor) {
        this.sessaoAtiva = _gestor;

        String date_s = this.sessaoAtiva.getNascimento();

        try {
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = dt.parse(date_s);
            SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
            date_s = dt1.format(date);
        } catch (ParseException e) {

        }

        this.jTXCPF.setText(this.sessaoAtiva.getCpf());
        this.jTXNome.setText(this.sessaoAtiva.getNome());
        this.jTXNascimento.setText(date_s);
        this.jTXLogin.setText(this.sessaoAtiva.getLogin());
        this.jTXEmail.setText(this.sessaoAtiva.getEmail());
        this.jTXTelefone.setText(this.sessaoAtiva.getTelefone());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCodigo = new javax.swing.JPanel();
        jLSexo1 = new javax.swing.JLabel();
        jTXLogin = new javax.swing.JTextField();
        jLSenha = new javax.swing.JLabel();
        jPSenha = new javax.swing.JPasswordField();
        jBAlterarSenha = new javax.swing.JButton();
        jBVoltar = new javax.swing.JButton();
        lBTitulo = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        jLCPF = new javax.swing.JLabel();
        jTXCPF = new javax.swing.JTextField();
        jLNome = new javax.swing.JLabel();
        jTXNome = new javax.swing.JTextField();
        jLNascimento = new javax.swing.JLabel();
        jTXNascimento = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jTXEmail = new javax.swing.JTextField();
        jLEmail = new javax.swing.JLabel();
        jLTelefone = new javax.swing.JLabel();
        jTXTelefone = new javax.swing.JTextField();
        jBAlterarContato = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Editar Perfil");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPCodigo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPCodigo.setToolTipText("");
        jPCodigo.setName("JPanelDados"); // NOI18N

        jLSexo1.setText("Login:");

        jTXLogin.setEditable(false);
        jTXLogin.setBackground(new java.awt.Color(237, 237, 237));
        jTXLogin.setBorder(null);
        jTXLogin.setMaximumSize(new java.awt.Dimension(150, 35));
        jTXLogin.setMinimumSize(new java.awt.Dimension(150, 35));
        jTXLogin.setPreferredSize(new java.awt.Dimension(150, 35));

        jLSenha.setText("Senha:");

        jPSenha.setMaximumSize(new java.awt.Dimension(150, 35));
        jPSenha.setMinimumSize(new java.awt.Dimension(150, 35));
        jPSenha.setPreferredSize(new java.awt.Dimension(150, 35));

        jBAlterarSenha.setText("Altera Senha");
        jBAlterarSenha.setMaximumSize(new java.awt.Dimension(120, 35));
        jBAlterarSenha.setMinimumSize(new java.awt.Dimension(120, 35));
        jBAlterarSenha.setPreferredSize(new java.awt.Dimension(120, 35));
        jBAlterarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCodigoLayout = new javax.swing.GroupLayout(jPCodigo);
        jPCodigo.setLayout(jPCodigoLayout);
        jPCodigoLayout.setHorizontalGroup(
            jPCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCodigoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBAlterarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPCodigoLayout.createSequentialGroup()
                        .addGroup(jPCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLSexo1)
                            .addComponent(jLSenha))
                        .addGap(18, 18, 18)
                        .addGroup(jPCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTXLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPCodigoLayout.setVerticalGroup(
            jPCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCodigoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTXLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLSexo1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLSenha)
                    .addComponent(jPSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBAlterarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBVoltar.setText("Voltar");
        jBVoltar.setMaximumSize(new java.awt.Dimension(120, 35));
        jBVoltar.setMinimumSize(new java.awt.Dimension(120, 35));
        jBVoltar.setPreferredSize(new java.awt.Dimension(120, 35));
        jBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVoltarActionPerformed(evt);
            }
        });

        lBTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lBTitulo.setText("Editar Perfil");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Pessoais"));

        jLCPF.setText("CPF:");

        jTXCPF.setEditable(false);
        jTXCPF.setBackground(new java.awt.Color(237, 237, 237));
        jTXCPF.setBorder(null);
        jTXCPF.setMaximumSize(new java.awt.Dimension(150, 35));
        jTXCPF.setMinimumSize(new java.awt.Dimension(150, 35));
        jTXCPF.setPreferredSize(new java.awt.Dimension(150, 35));

        jLNome.setText("Nome:");

        jTXNome.setEditable(false);
        jTXNome.setBackground(new java.awt.Color(237, 237, 237));
        jTXNome.setToolTipText("");
        jTXNome.setBorder(null);
        jTXNome.setPreferredSize(new java.awt.Dimension(200, 35));
        jTXNome.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jTXNomeComponentAdded(evt);
            }
        });
        jTXNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTXNomeActionPerformed(evt);
            }
        });

        jLNascimento.setText("Nascimento:");

        jTXNascimento.setEditable(false);
        jTXNascimento.setBackground(new java.awt.Color(237, 237, 237));
        jTXNascimento.setBorder(null);
        jTXNascimento.setPreferredSize(new java.awt.Dimension(150, 35));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLNascimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTXNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLNome)
                            .addComponent(jLCPF))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTXNome, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTXCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCPF)
                    .addComponent(jTXCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNome)
                    .addComponent(jTXNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNascimento)
                    .addComponent(jTXNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTXNome.getAccessibleContext().setAccessibleName("");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados de Contato", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jTXEmail.setPreferredSize(new java.awt.Dimension(150, 35));

        jLEmail.setText("Email:");

        jLTelefone.setText("Telefone:");

        jTXTelefone.setMaximumSize(new java.awt.Dimension(150, 35));
        jTXTelefone.setMinimumSize(new java.awt.Dimension(150, 35));
        jTXTelefone.setPreferredSize(new java.awt.Dimension(150, 35));

        jBAlterarContato.setText("Editar Contatos");
        jBAlterarContato.setMaximumSize(new java.awt.Dimension(120, 35));
        jBAlterarContato.setMinimumSize(new java.awt.Dimension(120, 35));
        jBAlterarContato.setPreferredSize(new java.awt.Dimension(120, 35));
        jBAlterarContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarContatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBAlterarContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLTelefone)
                            .addComponent(jLEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTXEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTXTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(46, 46, 46))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTelefone)
                    .addComponent(jTXTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTXEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBAlterarContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jPCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(lBTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lBTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jPCodigo.getAccessibleContext().setAccessibleName("Preencha os campos");
        jPCodigo.getAccessibleContext().setAccessibleDescription("Preencha os campos");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVoltarActionPerformed

        jfp.setSessaoAtiva(this.sessaoAtiva);
        jfp.setVisible(true);

        dispose();
    }//GEN-LAST:event_jBVoltarActionPerformed

    private void jTXNomeComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jTXNomeComponentAdded

    }//GEN-LAST:event_jTXNomeComponentAdded

    private void jTXNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTXNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTXNomeActionPerformed

    private void jBAlterarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarSenhaActionPerformed

        String erro = "";
        
        // Verificando se os campos da interface estão sem valor,
        // caso estejam, será montada uma string com as informações de erro.
            if (jPSenha.getText().isEmpty())           erro = erro + "campo Senha não preenchido...";
        
        
        // Verificando se o atributo erro está vazio
        if(erro.length() == 0){
            
            String senha = new String(jPSenha.getPassword());
            
            if(this.gestorC.setAlterarSenhaGestor(this.sessaoAtiva.getId(), senha) == true){
                this.sessaoAtiva.setSenha(senha);
                JOptionPane.showMessageDialog(null, "Dados do gestor foram atualizado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Atenção, ocorreu um erro ao editar a sua senha, tente novamenteø");
            }
            
        }else{
            JOptionPane.showMessageDialog(null, erro);
        }
    }//GEN-LAST:event_jBAlterarSenhaActionPerformed

    private void jBAlterarContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarContatoActionPerformed
        String erro = "";
        
        // Verificando se os campos da interface estão sem valor,
        // caso estejam, será montada uma string com as informações de erro.
            if (jTXTelefone.getText().isEmpty())           erro = erro + "campo TELEFONE não preenchido...";
            if (jTXEmail.getText().isEmpty())           erro = erro + "campo E-MAIL não preenchido...";
        
        
        // Verificando se o atributo erro está vazio
        if(erro.length() == 0){
            
            String telefone = new String(jTXTelefone.getText());
            String email = new String(jTXEmail.getText());
            
            
            if(this.gestorC.setAlterarContatoGestor(this.sessaoAtiva.getId(), telefone, email) == true){
                this.sessaoAtiva.setTelefone(telefone);
                this.sessaoAtiva.setEmail(email);
                JOptionPane.showMessageDialog(null, "Dados do gestor foram atualizado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Atenção, ocorreu um erro ao editar a sua senha, tente novamenteø");
            }
            
        }else{
            JOptionPane.showMessageDialog(null, erro);
        }
    }//GEN-LAST:event_jBAlterarContatoActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameEditarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameEditarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameEditarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameEditarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameEditarPerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterarContato;
    private javax.swing.JButton jBAlterarSenha;
    private javax.swing.JButton jBVoltar;
    private javax.swing.JLabel jLCPF;
    private javax.swing.JLabel jLEmail;
    private javax.swing.JLabel jLNascimento;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLSenha;
    private javax.swing.JLabel jLSexo1;
    private javax.swing.JLabel jLTelefone;
    private javax.swing.JPanel jPCodigo;
    private javax.swing.JPasswordField jPSenha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTXCPF;
    private javax.swing.JTextField jTXEmail;
    private javax.swing.JTextField jTXLogin;
    private javax.swing.JTextField jTXNascimento;
    private javax.swing.JTextField jTXNome;
    private javax.swing.JTextField jTXTelefone;
    private java.awt.Label lBTitulo;
    // End of variables declaration//GEN-END:variables
}
