/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.UsuarioC;
import java.sql.Date;
import javax.swing.JOptionPane;
import modelo.dominio.No;

/**
 *
 * @author Bruno
 */
public class JFrameCadastrarGerente extends javax.swing.JFrame {

    private UsuarioC ListaCG;
    private String parametroCPF;
    JFramePrincipal jfp = new JFramePrincipal();
    public JFrameCadastrarGerente() {
        initComponents();
        
        setLocationRelativeTo(null);
    }

   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCodigo = new javax.swing.JPanel();
        jLNome = new javax.swing.JLabel();
        jLNascimento = new javax.swing.JLabel();
        jLCPF = new javax.swing.JLabel();
        jLEmail = new javax.swing.JLabel();
        jCSexo = new javax.swing.JComboBox<>();
        jLSexo = new javax.swing.JLabel();
        jTXNome = new javax.swing.JTextField();
        jTXCPF = new javax.swing.JTextField();
        jTXEmail = new javax.swing.JTextField();
        jTXNascimento = new javax.swing.JTextField();
        jLSexo1 = new javax.swing.JLabel();
        jTXLogin = new javax.swing.JTextField();
        jLSenha = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTXCodigo = new javax.swing.JTextField();
        jPSenha = new javax.swing.JPasswordField();
        jBCadastrar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jTXPesquisarCPF = new javax.swing.JTextField();
        jLCpf = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPCodigo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPCodigo.setToolTipText("");
        jPCodigo.setName("JPanelDados"); // NOI18N

        jLNome.setText("Nome:");

        jLNascimento.setText("Nascimento:");

        jLCPF.setText("CPF:");

        jLEmail.setText("Email:");

        jCSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Masculino", "Feminino" }));

        jLSexo.setText("Sexo:");

        jTXNome.setText("sadsa");
        jTXNome.setToolTipText("");
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

        jLSexo1.setText("Login:");

        jLSenha.setText("Senha:");

        jLabel1.setText("Codigo:");

        jTXCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTXCodigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCodigoLayout = new javax.swing.GroupLayout(jPCodigo);
        jPCodigo.setLayout(jPCodigoLayout);
        jPCodigoLayout.setHorizontalGroup(
            jPCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCodigoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPCodigoLayout.createSequentialGroup()
                        .addGroup(jPCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLSexo1)
                            .addComponent(jLSenha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTXLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jPSenha))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPCodigoLayout.createSequentialGroup()
                        .addGroup(jPCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPCodigoLayout.createSequentialGroup()
                                .addComponent(jLNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTXNome))
                            .addGroup(jPCodigoLayout.createSequentialGroup()
                                .addComponent(jLCPF)
                                .addGap(18, 18, 18)
                                .addComponent(jTXCPF))
                            .addGroup(jPCodigoLayout.createSequentialGroup()
                                .addComponent(jLNascimento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTXNascimento))
                            .addGroup(jPCodigoLayout.createSequentialGroup()
                                .addComponent(jLEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTXEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPCodigoLayout.createSequentialGroup()
                                .addComponent(jLSexo)
                                .addGap(18, 18, 18)
                                .addComponent(jCSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTXCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))))
        );
        jPCodigoLayout.setVerticalGroup(
            jPCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCodigoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNome)
                    .addComponent(jTXNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTXCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCPF)
                    .addComponent(jTXCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNascimento)
                    .addComponent(jTXNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTXEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLEmail))
                .addGap(18, 18, 18)
                .addGroup(jPCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLSexo))
                .addGap(22, 22, 22)
                .addGroup(jPCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLSexo1)
                    .addComponent(jTXLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLSenha)
                    .addComponent(jPSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTXNome.getAccessibleContext().setAccessibleName("");

        jBCadastrar.setText("Cadastrar");
        jBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarActionPerformed(evt);
            }
        });

        jBAlterar.setText("Alterar Cadastro");
        jBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarActionPerformed(evt);
            }
        });

        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jLCpf.setText("Digite o CPF");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jPCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTXPesquisarCPF)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLCpf)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jBCadastrar)
                .addGap(18, 18, 18)
                .addComponent(jBAlterar)
                .addGap(18, 18, 18)
                .addComponent(jTXPesquisarCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLCpf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBCancelar)
                .addGap(23, 23, 23))
        );

        jPCodigo.getAccessibleContext().setAccessibleName("Preencha os campos");
        jPCodigo.getAccessibleContext().setAccessibleDescription("Preencha os campos");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        
        jfp.setVisible(true);
        
        dispose();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarActionPerformed
        
        this.ListaCG = new UsuarioC();
        
        String erro = "";
        // Verificando se os campos da interface estão sem valor,
        // caso estejam, será montada uma string com as informações de erro.
            if (jTXNome.getText().trim().isEmpty()) erro = erro + "Campo Nome não preenchido...\n";
            if(jTXCPF.getText().trim().isEmpty())   erro = erro + "Campo CPF não preenchido...\n";
            if (jTXNascimento.getText().isEmpty())           erro = erro + "campo nascimento não preenchido...";
            if (jTXEmail.getText().isEmpty())           erro = erro + "campo Email não preenchido...";
            if (jTXLogin.getText().isEmpty())           erro = erro + "campo Login não preenchido...";
            if (jPSenha.getText().isEmpty())           erro = erro + "campo Senha não preenchido...";
            if (jCSexo.getSelectedItem().equals("Selecionar"))           erro = erro + "Sexo não selecionado...";
        
        
        // Verificando se o atributo erro está vazio
        if(erro.length() == 0){
            
            // Resgatando os valores dos campos do painel dados.
            int codigo = Integer.parseInt(jTXCodigo.getText().trim());
            String nome = jTXNome.getText().trim(); 
            String cpf  = jTXCPF.getText().trim();
            String nascimento = jTXNascimento.getText().trim();
            String email = jTXEmail.getText().trim();
            String login = jTXLogin.getText().trim();
            String senha = new String(jPSenha.getPassword());
            Object sexo = jCSexo.getSelectedItem();
            Date date = new Date(System.currentTimeMillis());
            String data = date.toString();
            
            // Verificando se foi possível inserir os dados em uma determinada posição válida da lista
            if(this.ListaCG.inserirDados(this.ListaCG,codigo, nome,cpf,nascimento,data,email,login,senha,sexo.toString())){
                
                if(this.ListaCG.gravarUsuariosBD(this.ListaCG)) {
                    
                JOptionPane.showMessageDialog(null, "Novo gerente cadastrado com sucesso!!");
                jfp.setVisible(true);
                dispose();
                
                }else{
                    JOptionPane.showMessageDialog(null, "Banco indisponível no momento!!");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível cadastrar novo gerente...");
            }
            
        }else{
            JOptionPane.showMessageDialog(null, erro);
        }
        
    }//GEN-LAST:event_jBCadastrarActionPerformed

    private void jTXCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTXCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTXCodigoActionPerformed

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        
        
        this.parametroCPF = this.jTXPesquisarCPF.getText();
        JOptionPane.showMessageDialog(null, this.parametroCPF);
        UsuarioC usuario = new UsuarioC();
        
        if(usuario.pegarCPF(usuario,parametroCPF)){
            
            No pAux = usuario.getLista(usuario);
            jTXNome.setText(pAux.getObjeto().getNomeUsuario());
            jTXCodigo.setText(String.valueOf(pAux.getObjeto().getCodigoUsuario()));
            jTXCPF.setText(pAux.getObjeto().getCpf());
            jTXNascimento.setText(pAux.getObjeto().getNascimento());
            jTXEmail.setText(pAux.getObjeto().getEmail());
            jCSexo.setEnabled(false);
            jTXLogin.setText(pAux.getObjeto().getLoginUsuario());
            jPSenha.setText(pAux.getObjeto().getSenhaUsuario());
                        
        }else{
            JOptionPane.showMessageDialog(null, "CPF não encontrado");
        }
        
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jTXNomeComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jTXNomeComponentAdded
        
    }//GEN-LAST:event_jTXNomeComponentAdded

    private void jTXNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTXNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTXNomeActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(JFrameCadastrarGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameCadastrarGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameCadastrarGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameCadastrarGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameCadastrarGerente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBCadastrar;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JComboBox<String> jCSexo;
    private javax.swing.JLabel jLCPF;
    private javax.swing.JLabel jLCpf;
    private javax.swing.JLabel jLEmail;
    private javax.swing.JLabel jLNascimento;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLSenha;
    private javax.swing.JLabel jLSexo;
    private javax.swing.JLabel jLSexo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPCodigo;
    private javax.swing.JPasswordField jPSenha;
    private javax.swing.JTextField jTXCPF;
    private javax.swing.JTextField jTXCodigo;
    private javax.swing.JTextField jTXEmail;
    private javax.swing.JTextField jTXLogin;
    private javax.swing.JTextField jTXNascimento;
    private javax.swing.JTextField jTXNome;
    private javax.swing.JTextField jTXPesquisarCPF;
    // End of variables declaration//GEN-END:variables
}
