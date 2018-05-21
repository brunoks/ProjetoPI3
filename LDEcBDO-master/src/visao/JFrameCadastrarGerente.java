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
        
        this.ListaCG = new UsuarioC();
        setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCodigo = new javax.swing.JPanel();
        jLSexo1 = new javax.swing.JLabel();
        jTXLogin = new javax.swing.JTextField();
        jLSenha = new javax.swing.JLabel();
        jPSenha = new javax.swing.JPasswordField();
        jBCadastrar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jBAlterarCadastro = new javax.swing.JButton();
        lBTitulo = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        jLCPF = new javax.swing.JLabel();
        jTXCPF = new javax.swing.JTextField();
        jLNome = new javax.swing.JLabel();
        jTXNome = new javax.swing.JTextField();
        jLNascimento = new javax.swing.JLabel();
        jTXNascimento = new javax.swing.JTextField();
        jCSexo = new javax.swing.JComboBox<>();
        jLSexo = new javax.swing.JLabel();
        jBAlterar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTXEmail = new javax.swing.JTextField();
        jLEmail = new javax.swing.JLabel();
        jLTelefone = new javax.swing.JLabel();
        jTFTelefone = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPCodigo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPCodigo.setToolTipText("");
        jPCodigo.setName("JPanelDados"); // NOI18N

        jLSexo1.setText("Login:");

        jTXLogin.setMaximumSize(new java.awt.Dimension(150, 35));
        jTXLogin.setMinimumSize(new java.awt.Dimension(150, 35));
        jTXLogin.setPreferredSize(new java.awt.Dimension(150, 35));

        jLSenha.setText("Senha:");

        jPSenha.setMaximumSize(new java.awt.Dimension(150, 35));
        jPSenha.setMinimumSize(new java.awt.Dimension(150, 35));
        jPSenha.setPreferredSize(new java.awt.Dimension(150, 35));

        javax.swing.GroupLayout jPCodigoLayout = new javax.swing.GroupLayout(jPCodigo);
        jPCodigo.setLayout(jPCodigoLayout);
        jPCodigoLayout.setHorizontalGroup(
            jPCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCodigoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLSexo1)
                    .addComponent(jLSenha))
                .addGap(18, 18, 18)
                .addGroup(jPCodigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTXLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jBCadastrar.setText("Cadastrar");
        jBCadastrar.setMaximumSize(new java.awt.Dimension(120, 35));
        jBCadastrar.setMinimumSize(new java.awt.Dimension(120, 35));
        jBCadastrar.setPreferredSize(new java.awt.Dimension(120, 35));
        jBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarActionPerformed(evt);
            }
        });

        jBCancelar.setText("Cancelar");
        jBCancelar.setMaximumSize(new java.awt.Dimension(120, 35));
        jBCancelar.setMinimumSize(new java.awt.Dimension(120, 35));
        jBCancelar.setPreferredSize(new java.awt.Dimension(120, 35));
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jBAlterarCadastro.setText("Alterar Cadastro");
        jBAlterarCadastro.setMaximumSize(new java.awt.Dimension(120, 35));
        jBAlterarCadastro.setMinimumSize(new java.awt.Dimension(120, 35));
        jBAlterarCadastro.setPreferredSize(new java.awt.Dimension(120, 35));
        jBAlterarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarCadastroActionPerformed(evt);
            }
        });

        lBTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lBTitulo.setText("Cadastro de Gestor");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Pessoais"));

        jLCPF.setText("CPF:");

        jTXCPF.setMaximumSize(new java.awt.Dimension(150, 35));
        jTXCPF.setMinimumSize(new java.awt.Dimension(150, 35));
        jTXCPF.setPreferredSize(new java.awt.Dimension(150, 35));

        jLNome.setText("Nome:");

        jTXNome.setToolTipText("");
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

        jTXNascimento.setPreferredSize(new java.awt.Dimension(150, 35));

        jCSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Masculino", "Feminino" }));
        jCSexo.setMaximumSize(new java.awt.Dimension(120, 35));
        jCSexo.setMinimumSize(new java.awt.Dimension(120, 35));
        jCSexo.setPreferredSize(new java.awt.Dimension(120, 35));

        jLSexo.setText("Sexo:");

        jBAlterar.setText("Pesuisar CPF");
        jBAlterar.setMaximumSize(new java.awt.Dimension(120, 35));
        jBAlterar.setMinimumSize(new java.awt.Dimension(120, 35));
        jBAlterar.setPreferredSize(new java.awt.Dimension(120, 35));
        jBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLNascimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTXNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLSexo)
                        .addGap(18, 18, 18)
                        .addComponent(jCSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLNome)
                            .addComponent(jLCPF))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTXCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTXNome, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCPF)
                    .addComponent(jTXCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNome)
                    .addComponent(jTXNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNascimento)
                    .addComponent(jTXNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLSexo)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTXNome.getAccessibleContext().setAccessibleName("");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados de Contato", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jTXEmail.setPreferredSize(new java.awt.Dimension(150, 35));

        jLEmail.setText("Email:");

        jLTelefone.setText("Telefone:");

        jTFTelefone.setMaximumSize(new java.awt.Dimension(150, 35));
        jTFTelefone.setMinimumSize(new java.awt.Dimension(150, 35));
        jTFTelefone.setPreferredSize(new java.awt.Dimension(150, 35));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLTelefone)
                    .addComponent(jLEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTXEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTelefone)
                    .addComponent(jTFTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTXEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLEmail))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(lBTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBAlterarCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAlterarCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
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
//            int codigo = Integer.parseInt(jTXCodigo.getText().trim());
int codigo = 1;
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

    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        
        
        this.parametroCPF = this.jTXCPF.getText();
        No pAux = null;
        if(this.ListaCG.pegarCPF(this.ListaCG,parametroCPF,pAux)){
            
            pAux = ListaCG.getInicioDaLista();
            jTXNome.setText(pAux.getObjeto().getNomeUsuario());
//            jTXCodigo.setText(String.valueOf(pAux.getObjeto().getCodigoUsuario()));
            jTXCPF.setText(pAux.getObjeto().getCpf());
            jTXNascimento.setText(pAux.getObjeto().getNascimento());
            jTXEmail.setText(pAux.getObjeto().getEmail());
            jCSexo.setSelectedIndex(pAux.getObjeto().getSexo() == "Feminino" ? 1 : 2);
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

    private void jBAlterarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarCadastroActionPerformed
        
        this.ListaCG.limparLista(this.ListaCG);
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
//            int codigo = Integer.parseInt(jTXCodigo.getText().trim());
int codigo = 1;
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
                
                if(this.ListaCG.alterarUsuarioBD(this.ListaCG,codigo)) {
                    
                JOptionPane.showMessageDialog(null, "Dados do Gerente alterarado com sucesso!!");
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
    }//GEN-LAST:event_jBAlterarCadastroActionPerformed
    
    
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
    private javax.swing.JButton jBAlterarCadastro;
    private javax.swing.JButton jBCadastrar;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JComboBox<String> jCSexo;
    private javax.swing.JLabel jLCPF;
    private javax.swing.JLabel jLEmail;
    private javax.swing.JLabel jLNascimento;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLSenha;
    private javax.swing.JLabel jLSexo;
    private javax.swing.JLabel jLSexo1;
    private javax.swing.JLabel jLTelefone;
    private javax.swing.JPanel jPCodigo;
    private javax.swing.JPasswordField jPSenha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTFTelefone;
    private javax.swing.JTextField jTXCPF;
    private javax.swing.JTextField jTXEmail;
    private javax.swing.JTextField jTXLogin;
    private javax.swing.JTextField jTXNascimento;
    private javax.swing.JTextField jTXNome;
    private java.awt.Label lBTitulo;
    // End of variables declaration//GEN-END:variables
}
