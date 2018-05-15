package controle;

import modelo.dominio.No;
import modelo.dao.DadosCandidatoDAO;



import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.dominio.DadosCandidato;
import modelo.dominio.Usuario;


import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

/**
 *
 * @author Jefferson
 */
public class DadosC {
    
    /*###################################
              ATRIBUTOS DA CLASSE
      ###################################*/
    
    // Descritor da lista duplamente encadeada
    private int quantidadeDeNos;
    
    private No inicioDaLista;
    private No finalDaLista;
    
    // Atributos para trabalhar com arquivo .CSV
    private
        File arquivoJson;
        BufferedReader bReader;
        FileWriter writer;
                
        String[] d;
        String a;
        String linha;
        String arquivo;
        String arquivoTXT;
        
    // Atributos para trabalhar com banco de dados
    private
        Connection conn;
        ResultSet rs;
        
    /*###################################
             CONSTRUTOR DA CLASSE
      ###################################*/
    
    public DadosC(){
        this.criarLista();
    }
    
    /*##########################################
        MÉTODOS get e set DA CLASSE - Operações
      ##########################################*/
    
    // Método para alterar o atributo quantidadeDeNos.
    public void setQuantidadeDeNos(int quantidadeDeNos){
        this.quantidadeDeNos = quantidadeDeNos;
    }
    
    // Método que retorna a quantidade de usuários.
    public int getQuantidadeDeNos(){
        return this.quantidadeDeNos;
    }
    
    // Método para alterar o atributo inicio.
    public void setInicioDaLista(No inicioDaLista){
        this.inicioDaLista = inicioDaLista;
    }
    
    // Método que retorna o ponteiro para o primeiro nó da lista.
    public No getInicioDaLista(){
        return this.inicioDaLista;
    }
    
    // Método para alterar o atributo inicio.
    public void setFinalDaLista(No finalDaLista){
        this.finalDaLista = finalDaLista;
    }
    
    // Método que retorna o ponteiro para o primeiro nó da lista.
    public No getFinalDaLista(){
        return this.finalDaLista;
    }
    
    /*###################################
        MÉTODOS get e set DA CLASSE - BD
      ###################################*/

    public Connection getConn() {
        return this.conn;
    }

    public void setConn(Connection _conn) {
        this.conn = _conn;
    }

    public ResultSet getRs() {
        return this.rs;
    }

    public void setRs(ResultSet _rs) {
        this.rs = _rs;
    }
    
    
    
    /*#########################################
           OPERAÇÕES DAS ESTRUTURAS DE DADOS
      #########################################*/
    
    // Método para criar a lista.
    private void criarLista(){
        
        this.setInicioDaLista(null);
        this.setQuantidadeDeNos(0);
        this.setFinalDaLista(null);

    }
    
    // Método para limpar a lista.
    public void limparLista(DadosC listaDE){
        
        if (listaDE.isEmpty(listaDE)){
            listaDE = null;
        }else{
            listaDE.setInicioDaLista(null);
            listaDE.setQuantidadeDeNos(0);
            listaDE.setFinalDaLista(null);
        }
        
    }
    
    // Método que verifica se a lista está vazia.
    public boolean isEmpty(DadosC listaDE){
        
        // Se a quantidade de nós da lista tiver o valor 0
        // quer dizer que a lista está vazia.
        if(listaDE.getQuantidadeDeNos() == 0)
            return true;
        else
            return false;
        
    }
    
    // Método para inserir na lista.
    public boolean inserirDados(DadosC listaDE, int id_cargo, int cpf, String nome, String tse_o, String nascimento, String sexo){
        
//        String d1, String d2,String ano, String turno,String descE,String uf,String d7,String municipio,String codigoC,String cargo,String nome,String d12,String d13,
//                   String cpf,String d15,String d16,String d17,String d18,String siglaP,String partido,String d21,String d22,String composicaoLegenda,
//                   String d24,String d25,String d26,String nasc,String d28,String d29,String d30,String sexo,String d32,String d33,String d34,String d35,String d36,String d37,
//                   String d38, String d39, String d40, String d41, String d42, String d43, String d44, String d45, String d46
        // Criando o nó e inserindo as informações
        No novoNo = new No(d[2],d[3],d[4],d[5],d[7],d[8],d[9],d[10],d[13],d[18],d[19],d[22],d[26],d[30]);
            
        // Caso 1: Lista vazia
        if (listaDE.isEmpty(listaDE)){

            novoNo.setPonteiroAnterior(null);
            novoNo.setProximoPonteiro(null);

            listaDE.setInicioDaLista(novoNo);
            listaDE.setFinalDaLista(novoNo);

        }else{

            // A lista contém nós e será inserido um novo nó
            // de acordo com a ordenação crescente.

            // Iniciando pelo ínicio da lista.
            No ponteiroAuxiliar = listaDE.getInicioDaLista();

            // Caso 2:
            // Caso o código seja o menor de todos, será inserido no início da lista
            if(ponteiroAuxiliar == listaDE.getInicioDaLista()){

                novoNo.setPonteiroAnterior(null);
                novoNo.setProximoPonteiro(listaDE.getInicioDaLista());

                listaDE.getInicioDaLista().setPonteiroAnterior(novoNo);
                listaDE.setInicioDaLista(novoNo);

            }else{

                // Caso 3:
                // Caso o código seja o maior de todos, será inserido no final da lista
                if(ponteiroAuxiliar == null){

                    novoNo.setProximoPonteiro(null);
                    novoNo.setPonteiroAnterior(listaDE.getFinalDaLista());

                    listaDE.getFinalDaLista().setProximoPonteiro(novoNo);
                    listaDE.setFinalDaLista(novoNo);

                }else{

                    // Caso 4:
                    // O código está entre dois códigos que estão na lista.
                    novoNo.setProximoPonteiro(ponteiroAuxiliar);
                    ponteiroAuxiliar.getPonteiroAnterior().setProximoPonteiro(novoNo);
                    novoNo.setPonteiroAnterior(ponteiroAuxiliar.getPonteiroAnterior());
                    ponteiroAuxiliar.setPonteiroAnterior(novoNo);

                }

            }
            
        }
        
        listaDE.setQuantidadeDeNos(listaDE.getQuantidadeDeNos()+1);
        return true;
        
    }
    
    // Método para remover dados da lista duplamente encadeada.
    public boolean removerDados(DadosC listaDE, int p){
        
        // Se posiÃ§Ã£o negativa ou maior que a quantidade de nÃ³s
        if (listaDE.isEmpty(listaDE)){
        
            return false;
        
        }else{
            
            // Caso 1 - Se tiver apenas 1 elemento na lista
            if (listaDE.getQuantidadeDeNos() == 1){
                
                listaDE.limparLista(listaDE);
            
            }else{
                
                // Caso 2 - Posição a ser excluida = 0
                if(p == 0){
                    
                    No ponteiroAuxiliar = listaDE.getInicioDaLista();
                    
                    listaDE.setInicioDaLista(ponteiroAuxiliar.getProximoPonteiro());
                    listaDE.getInicioDaLista().setPonteiroAnterior(null);
                    
                    ponteiroAuxiliar.setProximoPonteiro(null);
                
                }else{
                    
                    // Caso 3 - Posição a ser excluida = última
                    if(p == (listaDE.getQuantidadeDeNos()-1)){
                        
                        No ponteiroAuxiliar = listaDE.getFinalDaLista();
                    
                        listaDE.setFinalDaLista(ponteiroAuxiliar.getPonteiroAnterior());
                        listaDE.getFinalDaLista().setProximoPonteiro(null);

                        ponteiroAuxiliar.setPonteiroAnterior(null);
                        
                    }else{
                        
                        // Caso 4 -> Remover quando p > 0 e p <= (meio da lista)
                        
                        // Se a posição p <= meio da lista, então percorrer
                        // do início para o final da lista
                        if (p <= (listaDE.getQuantidadeDeNos()/2)){
                            
                            No ponteiroAnterior = null;
                            No ponteiroAuxiliar = listaDE.getInicioDaLista();
                            
                            for (int i = 0; i < p; i++){
                                ponteiroAnterior = ponteiroAuxiliar;
                                ponteiroAuxiliar = ponteiroAuxiliar.getProximoPonteiro();
                            }
                            
                            ponteiroAnterior.setProximoPonteiro(ponteiroAuxiliar.getProximoPonteiro());
                            ponteiroAuxiliar.getProximoPonteiro().setPonteiroAnterior(ponteiroAnterior);
                            
                            ponteiroAuxiliar.setPonteiroAnterior(null);
                            ponteiroAuxiliar.setProximoPonteiro(null);

                        }else{
                            
                            // Se a posição p > meio da lista, então percorrer
                            // do final para o início da lista
                            
                            No ponteiroAnterior = null;
                            No ponteiroAuxiliar = listaDE.getFinalDaLista();
                            
                            for (int i = (listaDE.getQuantidadeDeNos()-1); i > p; i--){
                                ponteiroAnterior = ponteiroAuxiliar;
                                ponteiroAuxiliar = ponteiroAuxiliar.getPonteiroAnterior();
                            }
                            
                            ponteiroAnterior.setPonteiroAnterior(ponteiroAuxiliar.getPonteiroAnterior());
                            ponteiroAuxiliar.getPonteiroAnterior().setProximoPonteiro(ponteiroAnterior);
                            
                            ponteiroAuxiliar.setPonteiroAnterior(null);
                            ponteiroAuxiliar.setProximoPonteiro(null);
                            
                        }
                        
                    }
                }
            }
        }
        
        listaDE.setQuantidadeDeNos(listaDE.getQuantidadeDeNos()-1);
        return true;
        
    }
    
    // Método para pesquisar um determinado código e caso seja encontrado,
    // será retornada a referência do nó para o método 'alterarDados'.
    private No pesquisarElementoA(UsuarioC listaDE, int cpf){
        
        if (listaDE.isEmpty(listaDE)){
            
            return null;
        
        }else{
            
            No ponteiroAuxiliar = listaDE.getInicioDaLista();
            
            while (ponteiroAuxiliar != null){
                
                if (cpf == ponteiroAuxiliar.getObjeto().getCodigoUsuario()){
                    
                    break;                    
                    
                }
                
                ponteiroAuxiliar = ponteiroAuxiliar.getProximoPonteiro();
                
            }
            
            if (ponteiroAuxiliar != null)
                
                return ponteiroAuxiliar;
            
            else
            
                return null;
            
        }
        
    }
    
    /* Método para alterar dados de um usuário da lista.
       
       A forma de alteração poderá ser:
       1 - Acessando direto a posição, ou;
       2 - Pesquisando pela chave (código) e encontrando o usuário,
           alteram-se os dados. */
    
    public void alterarCadastro(UsuarioC listaDE, int codigoAntigo, int novoCodigo, String novoNome){
        
        // Resgatando a referência do nó que contém o código pesquisado
        No ponteiro = this.pesquisarElementoA(listaDE,codigoAntigo);
        
        // Se ponteiro for diferente de null, quer dizer que o código pesquisado
        // foi encontrado e basta alterar as informações na classe do Usuário.
        if (ponteiro != null){
            
            ponteiro.getObjeto().setCodigoUsuario(novoCodigo);
            ponteiro.getObjeto().setNomeUsuario(novoNome);
            
        }
        
    }
    
    // Método para pesquisar um determinado objeto através de uma chave.
    // Nesta aplicação, a chave será o código do usuário.
    public int pesquisarElemento(UsuarioC listaDE, int codigo){
        
        if (listaDE.isEmpty(listaDE)){
            
            return -1;
        
        }else{
            
            No ponteiroAuxiliar = listaDE.getInicioDaLista();
            int posicao = 0;
            
            while (ponteiroAuxiliar != null){
                
                if (codigo == ponteiroAuxiliar.getObjeto().getCodigoUsuario()){
                    
                    break;
                    
                }
                
                posicao = posicao + 1;
                ponteiroAuxiliar = ponteiroAuxiliar.getProximoPonteiro();
                
            }
            
            if (ponteiroAuxiliar != null)
                
                return posicao;
            
            else
            
                return -1;

        }
        
    }

    // Método para resgatar um elemento de uma determianda posição 'p' da lista.
    public No acessarDados(UsuarioC listaDE, int p){
        
        // Se posição 'p' negativa ou maior que a quantidade de nós
        if ((listaDE.isEmpty(listaDE)) || (p < 0) || (p > (listaDE.getQuantidadeDeNos()-1))){
        
            return null; // Retorna nulo
        
        }else{
            
            // Criando um ponteiro auxiliar para percorrer a lista.
            No ponteiroAuxiliar;
            
            // Se a posição 'p' <= meio da lista, então percorrer
            // do início para o final da lista.
            if (p <= (listaDE.getQuantidadeDeNos()/2)){
                
                // Resgatando o início da lista.
                ponteiroAuxiliar = listaDE.getInicioDaLista();
                
                // Percorrendo a lista da posição 'i' = 0 até (p - 1)
                for (int i = 0; i < p; i++)
                    ponteiroAuxiliar = ponteiroAuxiliar.getProximoPonteiro();
                
            }else{

                // Se a posição 'p' > meio da lista, então percorrer
                // do final para o início da lista.
                
                // Resgatando o final da lista.
                ponteiroAuxiliar = listaDE.getFinalDaLista();
                
                // Percorrendo a lista da posição 'qN - 1' até (p - 1)
                for (int i = (listaDE.getQuantidadeDeNos()-1); i > p; i--)
                    ponteiroAuxiliar = ponteiroAuxiliar.getPonteiroAnterior();

            }
            
            return ponteiroAuxiliar;
            
        }
        
    }
    
    // Retornando o início da lista.
    public No getLista(DadosC listaDE){
        
        if (!listaDE.isEmpty(listaDE)){
            return listaDE.getInicioDaLista();
        }
        
        return null;
        
    }
    
    // Método para unir 2 listas duplamente encadeadas
    /*public void unirListas(UsuarioC LDE1, UsuarioC LDE2){
        
        
        
    }*/
    
    // Método para inserir na lista de forma ordenada através do arquivo .CSV.
    public boolean lerArquivoTXT(DadosC listaDE, File _arquivo, String entrada){
        
        // Objeto BufferedReader exige try-catch
        try {
            
            // Local onde o arquivo está
            this.arquivoTXT = _arquivo.getPath();
            
            // Cria um buffer para a ler a partir de um arquivo
             this.bReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.arquivoTXT), "ISO-8859-1"));
//            this.bReader = new BufferedReader(new FileReader(this.arquivoTXT));
            
            // Percorrendo o arquivo linha a linha
            while((this.linha = this.bReader.readLine())!= null){
                
                // Pega a linha e verifica se existe o delimitador ';' para separar os dados
                // e jogá-los (se existir) no vetor 'dadosTemporarios'.
                //this.a = Arrays.toString(this.linha.split(";"));
                //this.a = this.linha.replaceAll("NULO", "Dado Nulo");
                this.d = this.linha.split(";");

                
                //Apenas para certificar o que está sendo separado na variável d
                //escreverArquivoTeste(d);
                
                //Criando No para substituir dentro do switch
                No novoNo = new No();
                switch(entrada){
                    case "Candidato": 
                        No No1 = new No(d[2],d[3],d[4],d[5],d[7],d[8],d[9],d[10],d[13],d[18],d[19],d[22],d[26],d[30]);
                        novoNo = No1;
                    break;
                    
                    case "Eleitorado": 
                        
                        No No2 = new No(d[0],d[1],d[2],d[5],d[6],d[8]);
                        novoNo = No2;
                    break;
                }
                
                // Caso 1: Lista vazia
                if (listaDE.isEmpty(listaDE)){

                    novoNo.setPonteiroAnterior(null);
                    novoNo.setProximoPonteiro(null);

                    listaDE.setInicioDaLista(novoNo);
                    listaDE.setFinalDaLista(novoNo);

                }else{
                    //Depois que a lista não estiver vazia, será preenchida pelo início
                        novoNo.setProximoPonteiro(null);
                        novoNo.setPonteiroAnterior(listaDE.getFinalDaLista());

                        listaDE.getFinalDaLista().setProximoPonteiro(novoNo);
                        listaDE.setFinalDaLista(novoNo);

                }

                listaDE.setQuantidadeDeNos(listaDE.getQuantidadeDeNos()+1);
               
            }
            
            // Fechan o BufferedReader
            this.bReader.close();
            
        } catch (FileNotFoundException e) {
            Logger.getLogger(DadosC.class.getName()).log(Level.SEVERE, null, e); 
            return false;
        } catch (IOException ex){
            Logger.getLogger(DadosC.class.getName()).log(Level.SEVERE, null, ex); 
            return false;
        }
        return true;
            
    }
    
    // Método para pegar as informações da lista de forma ordenada e
    // escrever no arquivo .CSV.
    public boolean escreverArquivoJson(DadosC listaDE, String entrada){
        
        switch(entrada){
        
            case "Candidato": 
                escreverCandidato(listaDE);
            break;
            
            case "Eleitorado": 
                escreverEleitorado(listaDE);
            break;
        }
        
        return true;    
        
    }
    
    // Ler dados do arquivo TXT referente a candidato
    //
    public void escreverCandidato(DadosC listaDE){
        // Local onde será criado o arquivo e os dados serão gravados.
        this.arquivoJson = new File("C:\\Users\\Bruno\\Documents\\jsonFileCandidato.json");
        
        JSONObject jsonObject = new JSONObject();
        JSONArray tempos = new JSONArray();
        JSONArray y = new JSONArray();
        try {
            
            // Se o arquivo não existir, cria-se um novo.
            if (this.arquivoJson.exists()) {
                arquivoJson.delete();
                this.arquivoJson.createNewFile(); // Arquivo vazio
            }else{
                this.arquivoJson.createNewFile(); // Arquivo vazio
            
            }
            //ponteiro auxiliar para 
            No pAux = listaDE.getInicioDaLista();            
            FileWriter fw = new FileWriter(this.arquivoJson, true);
            BufferedWriter bw = new BufferedWriter(fw);
            int i = 0;
            while(pAux.getProximoPonteiro() != null){
                
                tempos.put(jsonObject.put("nome", pAux.getObjctDados().getNome()));
                tempos.put(jsonObject.put("cpf", pAux.getObjctDados().getCpf()));
                tempos.put(jsonObject.put("nascimento", pAux.getObjctDados().getNasc()));
                tempos.put(jsonObject.put("sexo", pAux.getObjctDados().getSexo()));
                tempos.put(jsonObject.put("descricao", pAux.getObjctDados().getDescE()));
                tempos.put(jsonObject.put("cargo", pAux.getObjctDados().getCargo()));
                tempos.put(jsonObject.put("codigoC", pAux.getObjctDados().getCodigoC()));
                tempos.put(jsonObject.put("uf", pAux.getObjctDados().getUf()));
                tempos.put(jsonObject.put("municipio", pAux.getObjctDados().getMunicipio()));
                tempos.put(jsonObject.put("partido", pAux.getObjctDados().getPartido()));
                tempos.put(jsonObject.put("siglaP", pAux.getObjctDados().getSiglaP()));
                tempos.put(jsonObject.put("turno", pAux.getObjctDados().getTurno()));
                tempos.put(jsonObject.put("ano", pAux.getObjctDados().getAno()));
                tempos.put(jsonObject.put("legenda", pAux.getObjctDados().getComposicaoLegenda()));
                
                i++;
                pAux = pAux.getProximoPonteiro();
                System.out.println(i);
               
            }
            bw.write(tempos.toString());
                
            bw.close();
            fw.close();           
            
        } catch (IOException ex) {
            
            ex.printStackTrace();
            
        } catch (JSONException ex) {
            Logger.getLogger(DadosC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public void escreverEleitorado(DadosC listaDE){
        // Local onde será criado o arquivo e os dados serão gravados.
        this.arquivoJson = new File("C:\\Users\\Bruno\\Documents\\jsonFileEleitorado.json");

        JSONObject jsonObject = new JSONObject();
        JSONArray tempos = new JSONArray();
        JSONArray y = new JSONArray();
        try {
            
            // Se o arquivo não existir, cria-se um novo.
            if (this.arquivoJson.exists()) {
                arquivoJson.delete();
                this.arquivoJson.createNewFile(); // Arquivo vazio
            }else{
                this.arquivoJson.createNewFile(); // Arquivo vazio
            
            }
            //ponteiro auxiliar para 
            No pAux = listaDE.getInicioDaLista();            
            FileWriter fw = new FileWriter(this.arquivoJson, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i = 0; i < listaDE.getQuantidadeDeNos(); i++){
                
                //Inserindo os atributos ao Json
                tempos.put(jsonObject.put("periodo", pAux.getObjctEleitorado().getPeriodo()));
                tempos.put(jsonObject.put("uf", pAux.getObjctEleitorado().getUf()));
                tempos.put(jsonObject.put("municipio", pAux.getObjctEleitorado().getMunicipio()));
                tempos.put(jsonObject.put("sexo", pAux.getObjctEleitorado().getSexo()));
                tempos.put(jsonObject.put("faixa_etaria", pAux.getObjctEleitorado().getFaixa_etaria()));
                tempos.put(jsonObject.put("total", pAux.getObjctEleitorado().getTotal()));
                
                if(i == listaDE.getQuantidadeDeNos() -  1) {
                    bw.write(tempos.toString());
                }else{
                    bw.write(tempos.toString() + ",");
                }
                
                pAux = pAux.getProximoPonteiro();
                System.out.println(tempos.toString());
               
            }
            bw.close();
            fw.close();           
            
        } catch (IOException ex) {
            
            ex.printStackTrace();
            
        } catch (JSONException ex) {
            Logger.getLogger(DadosC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Método para gravar todos os dados no banco de dados Oracle
    public boolean gravarDadosBanco(DadosC listaDE){
        
        // Criando instância da classe UsuarioDAO.
        DadosCandidatoDAO uDAO = new DadosCandidatoDAO();
        
        // Verificando se é possível conectar ao banco de dados Oracle
        // Se for possível, o atributo conn será diferente de 'null'
        if((this.conn = uDAO.conectarBanco()) != null){
            
            // Pegando o início da lista duplamente encadeada, se existir.
            No proximoDado = listaDE.getLista(listaDE);
        
            // O primeiro nó da lista, de forma abstrata, está na posição ZERO.
            int i = 0;

            // Enquanto o ponteiro atual for diferente de null e
            // for menor que a quantidade de nós
            while ((proximoDado != null) && (i < listaDE.getQuantidadeDeNos())){

                // Se não foi possível gravar no banco de dados Oracle,
                // retorna falso e então, executaremos o comando 'break' para
                // sair das estruturas 'if' e 'while'.
                // Observação: será passado como parâmetro apenas o campo
                // objeto (onde contém as informações do usuário atual) do nó.
                if(!uDAO.gravarDadosBanco(proximoDado.getObjctDados())){

                    break;

                }
                
                // Vai para o próximo nó.
                proximoDado = proximoDado.getProximoPonteiro();
                i++;

            }
            
            // Fechando a conexão ao banco de dados
            uDAO.fecharConexaoOracle();
            
            // Setando null para o objeto uDAO
            uDAO = null;
            
            return true;
            
        }
        
        return false;
        
    }
    
    // Método para inserir na lista de forma ordenada através do arquivo .CSV.
    public boolean selecionarDadosBD(DadosC listaDE){
        
        // Criando instância da classe UsuarioDAO.
        DadosCandidatoDAO uDAO = new DadosCandidatoDAO();
        
        // Verificando se é possível conectar ao banco de dados Oracle
        // Se for possível, o atributo conn será diferente de 'null'
        if((this.conn = uDAO.conectarBanco()) != null){

            try{
            
                // Resgatando todos os usuários do banco de dados Oracle.
                this.setRs(uDAO.selecionarDadosBD());

                // Verificando se o resultado retornado é diferente de null.
                if(this.getRs() != null){
                    DadosCandidato objeto = new DadosCandidato();
                    // Percorrendo o resultado retornado do banco de dados
                    while(this.getRs().next()){


                        // Armazena os dados nos atributos de 'objeto'
                        // através dos dados do ResultSet atual.

                        objeto.setNome(this.getRs().getString("NOME"));
                        objeto.setCpf(this.getRs().getString("CPF"));
                        objeto.setNasc(this.getRs().getString("DATA_DASC"));
                        objeto.setSexo(this.getRs().getString("SEXO"));
                        objeto.setDescE(this.getRs().getString("DESCRICAO_ELEICAO"));
                        objeto.setUf(this.getRs().getString("UF"));
                        objeto.setMunicipio(this.getRs().getString("MUNICIPIO"));
                        objeto.setCodigoC(this.getRs().getString("CODIGO_CANDIDATO"));
                        objeto.setAno(this.getRs().getString("ANO"));
                        objeto.setTurno(this.getRs().getString("TURNO"));
                        objeto.setCargo(this.getRs().getString("CARGO"));
                        objeto.setComposicaoLegenda(this.getRs().getString("LEGENDA"));
                        objeto.setPartido(this.getRs().getString("PARTIDO"));
                        objeto.setSiglaP(this.getRs().getString("SIGLA_PARTIDO"));

                        // Inserindo o usuário de forma efetiva na lista.
                        //this.inserirUsuario(listaDE, objeto);
                        criarNoCandidato(objeto, listaDE);
                    }

                    return true;

                }
        
            }catch(SQLException e){

                e.printStackTrace();

            }
        
        }
        
        return false;
        
    }
    public boolean criarNoCandidato(DadosCandidato dado, DadosC listaDE){

        No novoNo = new No(dado.getAno(),dado.getTurno(),dado.getDescE(),dado.getUf(),dado.getMunicipio(),
                           dado.getCodigoC(),dado.getCargo(),dado.getNome(),dado.getCpf(),dado.getSiglaP(),dado.getPartido(),dado.getComposicaoLegenda(),dado.getNasc(),dado.getSexo());
            // Caso 1: Lista vazia
                if (listaDE.isEmpty(listaDE)){

                    novoNo.setPonteiroAnterior(null);
                    novoNo.setProximoPonteiro(null);

                    listaDE.setInicioDaLista(novoNo);
                    listaDE.setFinalDaLista(novoNo);

                }else{
                    //Depois que a lista não estiver vazia, será preenchida pelo início
                        novoNo.setProximoPonteiro(null);
                        novoNo.setPonteiroAnterior(listaDE.getFinalDaLista());

                        listaDE.getFinalDaLista().setProximoPonteiro(novoNo);
                        listaDE.setFinalDaLista(novoNo);

                }

                listaDE.setQuantidadeDeNos(listaDE.getQuantidadeDeNos()+1);
               
        return true;    
        
    }
}
