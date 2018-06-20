package visao;

import controle.DadosC;
import modelo.dominio.Gestor;
import controle.ListaC;
import controle.EleitorC;
import java.io.File;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Painel Principal
 * @author AC/DC
 */
public class JFramePrincipal extends javax.swing.JFrame {

    private JFileChooser jFCEscolherArquivo;
    private Gestor sessaoAtiva = new Gestor();

    
    // Atributo para acessar a classe de controle da Lista
    private ListaC listaDados;
    /**
     * Creates new form JFramePrincipal
     */
    public JFramePrincipal() {
        initComponents();

        // Posicionando a tela JFramePrincipal ao centro da tela do usuário
        setLocationRelativeTo(null);
    }

    public void showSaudacao() {
        JOptionPane.showMessageDialog(null, "Seja Bem Vindo(a) " + this.sessaoAtiva.getNome());
    }

    //Salvar as informações da Sessão Ativa
    public void setSessaoAtiva(Gestor _gestor) {
        this.sessaoAtiva = _gestor;
    }

    public JComboBox<String> getSelectItem() {
        return this.jCBTipo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPLista = new javax.swing.JPanel();
        jBCL = new javax.swing.JButton();
        jBLL = new javax.swing.JButton();
        jPanelOperacoes = new javax.swing.JPanel();
        jBEditarCadastro = new javax.swing.JButton();
        jBCandidatos = new javax.swing.JButton();
        jBEleitorado = new javax.swing.JButton();
        jBVotos = new javax.swing.JButton();
        JBSair = new javax.swing.JButton();
        jPImportar = new javax.swing.JPanel();
        jBLerTXT = new javax.swing.JButton();
        jCBTipo = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jBGravarBD = new javax.swing.JButton();
        jBSelecionarBD = new javax.swing.JButton();
        lBTitulo = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estruturas de Dados");

        jPLista.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tratamento da Lista", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jBCL.setText("Criar Lista");
        jBCL.setMaximumSize(new java.awt.Dimension(370, 35));
        jBCL.setMinimumSize(new java.awt.Dimension(370, 35));
        jBCL.setPreferredSize(new java.awt.Dimension(370, 35));
        jBCL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCLActionPerformed(evt);
            }
        });

        jBLL.setText("Limpar lista");
        jBLL.setEnabled(false);
        jBLL.setMaximumSize(new java.awt.Dimension(370, 35));
        jBLL.setMinimumSize(new java.awt.Dimension(370, 35));
        jBLL.setPreferredSize(new java.awt.Dimension(370, 35));
        jBLL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPListaLayout = new javax.swing.GroupLayout(jPLista);
        jPLista.setLayout(jPListaLayout);
        jPListaLayout.setHorizontalGroup(
            jPListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPListaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBCL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPListaLayout.createSequentialGroup()
                        .addComponent(jBLL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPListaLayout.setVerticalGroup(
            jPListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBCL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jBLL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelOperacoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jBEditarCadastro.setText("Editar Perfil");
        jBEditarCadastro.setMaximumSize(new java.awt.Dimension(120, 35));
        jBEditarCadastro.setMinimumSize(new java.awt.Dimension(120, 35));
        jBEditarCadastro.setPreferredSize(new java.awt.Dimension(120, 35));
        jBEditarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarCadastroActionPerformed(evt);
            }
        });

        jBCandidatos.setText("Candidatos");
        jBCandidatos.setEnabled(false);
        jBCandidatos.setMaximumSize(new java.awt.Dimension(120, 35));
        jBCandidatos.setMinimumSize(new java.awt.Dimension(120, 35));
        jBCandidatos.setPreferredSize(new java.awt.Dimension(120, 35));

        jBEleitorado.setText("Eleitorado");
        jBEleitorado.setEnabled(false);
        jBEleitorado.setMaximumSize(new java.awt.Dimension(120, 35));
        jBEleitorado.setMinimumSize(new java.awt.Dimension(120, 35));
        jBEleitorado.setPreferredSize(new java.awt.Dimension(120, 35));

        jBVotos.setText("Votos");
        jBVotos.setEnabled(false);
        jBVotos.setMaximumSize(new java.awt.Dimension(120, 35));
        jBVotos.setMinimumSize(new java.awt.Dimension(120, 35));
        jBVotos.setPreferredSize(new java.awt.Dimension(120, 35));

        JBSair.setText("Sair");
        JBSair.setMaximumSize(new java.awt.Dimension(120, 35));
        JBSair.setMinimumSize(new java.awt.Dimension(120, 35));
        JBSair.setPreferredSize(new java.awt.Dimension(120, 35));
        JBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOperacoesLayout = new javax.swing.GroupLayout(jPanelOperacoes);
        jPanelOperacoes.setLayout(jPanelOperacoesLayout);
        jPanelOperacoesLayout.setHorizontalGroup(
            jPanelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOperacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBEleitorado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBEditarCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCandidatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBVotos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanelOperacoesLayout.setVerticalGroup(
            jPanelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOperacoesLayout.createSequentialGroup()
                .addComponent(jBEditarCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBEleitorado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBCandidatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBVotos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(JBSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPImportar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Importar Dados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jBLerTXT.setText("Selecione o TXT");
        jBLerTXT.setEnabled(false);
        jBLerTXT.setMaximumSize(new java.awt.Dimension(180, 35));
        jBLerTXT.setMinimumSize(new java.awt.Dimension(180, 35));
        jBLerTXT.setPreferredSize(new java.awt.Dimension(180, 35));
        jBLerTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLerTXTActionPerformed(evt);
            }
        });

        jCBTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Eleitorado", "Candidato", "Votos" }));
        jCBTipo.setMaximumSize(new java.awt.Dimension(180, 35));
        jCBTipo.setMinimumSize(new java.awt.Dimension(180, 35));
        jCBTipo.setName(""); // NOI18N
        jCBTipo.setPreferredSize(new java.awt.Dimension(180, 35));
        jCBTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBTipoItemStateChanged(evt);
            }
        });
        jCBTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPImportarLayout = new javax.swing.GroupLayout(jPImportar);
        jPImportar.setLayout(jPImportarLayout);
        jPImportarLayout.setHorizontalGroup(
            jPImportarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPImportarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBLerTXT, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPImportarLayout.setVerticalGroup(
            jPImportarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPImportarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPImportarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBLerTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Banco de Dados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jBGravarBD.setText("Importar Dados");
        jBGravarBD.setEnabled(false);
        jBGravarBD.setMaximumSize(new java.awt.Dimension(370, 35));
        jBGravarBD.setMinimumSize(new java.awt.Dimension(370, 35));
        jBGravarBD.setPreferredSize(new java.awt.Dimension(370, 35));
        jBGravarBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGravarBDActionPerformed(evt);
            }
        });

        jBSelecionarBD.setText("Exportar JSON");
        jBSelecionarBD.setEnabled(false);
        jBSelecionarBD.setMaximumSize(new java.awt.Dimension(370, 35));
        jBSelecionarBD.setMinimumSize(new java.awt.Dimension(370, 35));
        jBSelecionarBD.setPreferredSize(new java.awt.Dimension(370, 35));
        jBSelecionarBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSelecionarBDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBSelecionarBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBGravarBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBGravarBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBSelecionarBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lBTitulo.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        lBTitulo.setText("URNA DIGITAL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelOperacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPImportar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lBTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lBTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jPImportar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelOperacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBEditarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarCadastroActionPerformed

        JFrameEditarPerfil jfp = new JFrameEditarPerfil();
        jfp.setSessaoAtiva(this.sessaoAtiva);
        jfp.setVisible(true);

        dispose();

    }//GEN-LAST:event_jBEditarCadastroActionPerformed

    private void jBLerTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLerTXTActionPerformed

        // Cria uma instância do selecionador de arquivos.
        this.jFCEscolherArquivo = new JFileChooser();

        // Define o diretório atual.
        // Nesse caso, a caixa será aberta em c:\\urnadigital
        this.jFCEscolherArquivo.setCurrentDirectory(new File("C:\\urnadigital"));

        // Permite que seja seleciodo apenas arquivos, diretórios ou arquivos e diretórios.
        // FILES_ONLY = instrução para exibir apenas arquivos.
        this.jFCEscolherArquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // Coloca a opção 'Todos os arquivos' disponível e quando selecionada, qualquer extensão de arquivo poderá ser utilizada,
        // desde que se tenha um método para trabalhar o arquivo.
        this.jFCEscolherArquivo.setAcceptAllFileFilterUsed(true);

        // Adiciona na caixa de diálogo os tipos de arquivos que poderão ser selecionados.
        this.jFCEscolherArquivo.addChoosableFileFilter(new FileNameExtensionFilter("PDF Documents", "pdf"));
        this.jFCEscolherArquivo.addChoosableFileFilter(new FileNameExtensionFilter("MS Office Documents", ".csv", "docx", "xlsx", "pptx"));
        this.jFCEscolherArquivo.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
        this.jFCEscolherArquivo.addChoosableFileFilter(new FileNameExtensionFilter("Txt", "txt", "txt"));

        // Verifica se algum arquivo foi selecionado
        if (this.jFCEscolherArquivo.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

            JOptionPane.showMessageDialog(null, "Arquivo carregado com sucesso!");

            // Passa a lista e o caminho onde o arquivo .csv está.
            // Se foi possível ler o arquivo, apresenta os dados.
            
            if (this.listaDados.lerArquivoTXT(this.listaDados, this.jFCEscolherArquivo.getSelectedFile(), jCBTipo.getSelectedItem().toString())) {
                
                //this.mostrarListaCSVeBD(); // Mostrando os dados no JTable
                jBLerTXT.setEnabled(false);      // Desabilitando o botão CSV

                jBGravarBD.setEnabled(true);     // Haabilitando o botão gravar
                jBSelecionarBD.setEnabled(true); // Habilitando o botão selecionar

            } else {
                JOptionPane.showMessageDialog(null, "Erro ao importar os dados...");
            }
//            if (this.listaCandidato.lerArquivoTXT(this.listaCandidato, this.jFCEscolherArquivo.getSelectedFile(), jCBTipo.getSelectedItem().toString())) {
//                
//                //this.mostrarListaCSVeBD(); // Mostrando os dados no JTable
//                jBLerTXT.setEnabled(false);      // Desabilitando o botão CSV
//
//                jBGravarBD.setEnabled(true);     // Haabilitando o botão gravar
//                jBSelecionarBD.setEnabled(true); // Habilitando o botão selecionar
//
//            } else {
//                JOptionPane.showMessageDialog(null, "Erro ao importar os dados de candidato...");
//            }
            

        } else {
            JOptionPane.showMessageDialog(null, "Arquivo não selecionado!");
        }
        

    }//GEN-LAST:event_jBLerTXTActionPerformed

    private void jBGravarBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGravarBDActionPerformed
        jBSelecionarBD.setEnabled(true);
        
        String tipoDado = jCBTipo.getSelectedItem().toString();
        
        JOptionPane.showMessageDialog(null, "Aguarde enquanto importamos os dados...");
        
        switch(tipoDado){
            case "Eleitorado":
                EleitorC eleitorC = new EleitorC();
                eleitorC.importarDadosEleitor(this.listaDados);
                break;
            case "Candidato":
                DadosC dadosc = new DadosC();
                dadosc.importarDadosCandidato(this.listaDados);
                System.out.println(tipoDado);
                break;
        }
        
        JOptionPane.showMessageDialog(null, "Dados carregados com sucesso...");
        
    }//GEN-LAST:event_jBGravarBDActionPerformed

    private void jBSelecionarBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSelecionarBDActionPerformed

        JOptionPane.showMessageDialog(null, "Aguarde enquanto consultamos os dados");
        
        String tipoDado = jCBTipo.getSelectedItem().toString();
        
        switch(tipoDado){
            case "Eleitorado":
                EleitorC eleitorC = new EleitorC();
                eleitorC.exportarDadosJSON();
                break;
        }
        
//        for (int i = 0; i < uf.length; i++) {
//            // Verificando se foi possível inserir os dados em uma determinada posição válida da lista
//            if (this.listaDados.selecionarDadosBD(this.listaDados, this.uf[i])) {
//                if (this.listaDados.getQuantidadeDeNos() > 1) {
//                    System.out.println(this.uf[i]);
//                    this.listaDE2.escreverArquivoJson(this.listaDE2, this.jCBTipo.getSelectedItem().toString());
//                    this.listaDE2.limparLista(this.listaDE2);
//                    this.listaDE2 = new DadosC();
//                } else {
//                    System.out.println("Estado não existe, pegando próximo.." + this.uf[i]);
//                }
//            }
//
//        }
        jBSelecionarBD.setEnabled(false); // habilitando o botão Selecionar BD
        jBGravarBD.setEnabled(true);      // habilitando o botão Gravar BD

    }//GEN-LAST:event_jBSelecionarBDActionPerformed

    private void jCBTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTipoActionPerformed

    }//GEN-LAST:event_jCBTipoActionPerformed

    private void jCBTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBTipoItemStateChanged

    }//GEN-LAST:event_jCBTipoItemStateChanged

    // Método da interface JFramePrincipal para limpar lista
    private void jBLLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLLActionPerformed

        this.listaDados.limparLista(this.listaDados);  // Tornando a lista vazia

        jBLL.setEnabled(false); // Habilitando o botão Limpar lista
        jBCL.setEnabled(true);  // Habilitando o botão Criar lista

        jBLerTXT.setEnabled(false);        // Habilitando o botão CSV

        jBGravarBD.setEnabled(false);     // Desabilitando o botão gravar
        jBSelecionarBD.setEnabled(false); // Desabilitando o botão selecionar

    }//GEN-LAST:event_jBLLActionPerformed

    // Método da interface JFramePrincipal para criar lista
    private void jBCLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCLActionPerformed

        // Cria uma instância da classe Estruturas de Dados
        this.listaDados = new ListaC();
        jBCL.setEnabled(false);  // Desabilitando o botão Criar lista

        jBLL.setEnabled(true);        // habilitando o botão Limpar lista
        jBLerTXT.setEnabled(true);    // habilitando o botão CSV

        jBSelecionarBD.setEnabled(false); // habilitando o botão Selecionar BD

    }//GEN-LAST:event_jBCLActionPerformed

    private void JBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSairActionPerformed
        dispose();

        JFrameLogin jfp = new JFrameLogin();
        jfp.setVisible(true);
//        System.exit(0);
    }//GEN-LAST:event_JBSairActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new JFramePrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBSair;
    private javax.swing.JButton jBCL;
    private javax.swing.JButton jBCandidatos;
    private javax.swing.JButton jBEditarCadastro;
    private javax.swing.JButton jBEleitorado;
    private javax.swing.JButton jBGravarBD;
    private javax.swing.JButton jBLL;
    private javax.swing.JButton jBLerTXT;
    private javax.swing.JButton jBSelecionarBD;
    private javax.swing.JButton jBVotos;
    private javax.swing.JComboBox<String> jCBTipo;
    private javax.swing.JPanel jPImportar;
    private javax.swing.JPanel jPLista;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelOperacoes;
    private java.awt.Label lBTitulo;
    // End of variables declaration//GEN-END:variables
}
