package controle;

import modelo.dominio.No;
import modelo.dao.DadosDAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.dominio.Usuario;

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
        File arquivoCSV;
        BufferedReader bReader;
        FileWriter writer;
                
        String[] d;
        String linha;
        String arquivo;
        
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
        
        // Criando o nó e inserindo as informações
        No novoNo = new No(d[0],d[1],d[2],d[3],d[4],d[5],d[6],d[7],d[8],d[9],d[10],d[11],
                        d[12],d[13],d[14],d[15],d[16],d[17],d[18],d[19],d[20],d[21],d[22],
                        d[23],d[24],d[25],d[26],d[27],d[28],d[29],d[30],d[31],d[32],d[33],
                        d[34],d[35],d[36],d[37],d[38],d[39],d[40],d[41],d[42],d[43],d[44],d[45]);
            
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

            // Percorrendo a lista até encontrar o local certo para inserção do nó
            while((ponteiroAuxiliar != null) && (novoNo.getObjeto().getCodigoUsuario() > ponteiroAuxiliar.getObjeto().getCodigoUsuario())){
                ponteiroAuxiliar = ponteiroAuxiliar.getProximoPonteiro();
            }

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
    private No pesquisarElementoA(UsuarioC listaDE, int codigoAntigo){
        
        if (listaDE.isEmpty(listaDE)){
            
            return null;
        
        }else{
            
            No ponteiroAuxiliar = listaDE.getInicioDaLista();
            
            while (ponteiroAuxiliar != null){
                
                if (codigoAntigo == ponteiroAuxiliar.getObjeto().getCodigoUsuario()){
                    
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
    
    public void alterarDados(UsuarioC listaDE, int codigoAntigo, int novoCodigo, String novoNome){
        
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
    public boolean lerArquivoTXT(DadosC listaDE, File _arquivo){
        
        // Objeto BufferedReader exige try-catch
        try {
            
            // Local onde o arquivo está
            this.arquivo = _arquivo.getPath();
            
            // Cria um buffer para a ler a partir de um arquivo
            this.bReader = new BufferedReader(new FileReader(this.arquivo));
            
            // Percorrendo o arquivo linha a linha
            while((this.linha = this.bReader.readLine())!= null){
                
                // Pega a linha e verifica se existe o delimitador ',' para separar os dados
                // e jogá-los (se existir) no vetor 'dadosTemporarios'.
                this.d = this.linha.split(";");
                
                // Cria-se uma instância da classe 'No'.
                // Acessa o vetor 'dadosTemporarios' e passa o conteúdo de cada posição
                // para a classe 'No'.
                // 

                No novoNo = new No(d[0],d[1],d[2],d[3],d[4],d[5],d[6],d[7],d[8],d[9],d[10],d[11],
                        d[12],d[13],d[14],d[15],d[16],d[17],d[18],d[19],d[20],d[21],d[22],
                        d[23],d[24],d[25],d[26],d[27],d[28],d[29],d[30],d[31],d[32],d[33],
                        d[34],d[35],d[36],d[37],d[38],d[39],d[40],d[41],d[42],d[43],d[44],d[45]);
                
                // Caso 1: Lista vazia
                if (listaDE.isEmpty(listaDE)){

                    novoNo.setPonteiroAnterior(null);
                    novoNo.setProximoPonteiro(null);

                    listaDE.setInicioDaLista(novoNo);
                    listaDE.setFinalDaLista(novoNo);

                }else{
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
            return false;
        } catch (IOException ex){
            return false;
        }
        
        return true;
            
    }
    
    // Método para pegar as informações da lista de forma ordenada e
    // escrever no arquivo .CSV.
    public boolean escreverArquivoCSV(UsuarioC listaDE){
        
        // Local onde será criado o arquivo e os dados serão gravados.
        this.arquivoCSV = new File("C:\\Users\\Jefferson15\\Documents\\NetBeansProjects\\ProjetoLEcBDt\\src\\arquivosCSV\\usuariosNovos.csv");

        // Principal delimitador (separador)
        String delimitador = ",";
        
        // Cabeçalho que será gravado na 1º linha do arquivo .CSV.
        String cabecalho   = "codigo,nome,login,senha";
        
        // Resgatando a referência do início da lista.
        No ponteiro = listaDE.getLista(listaDE);
        
        try {
            
            // Se o arquivo não existir, cria-se um novo.
            if (!this.arquivoCSV.exists()) {
                
                this.arquivoCSV.createNewFile(); // Arquivo vazio
            
            }
            
            // Quando se quer escrever no arquivo sobrescrevendo-o.
            //FileWriter fw = new FileWriter(this.arquivoCSV);

            // Quando se quer escrever no arquivo, contudo quando se
            // utiliza o argumento 'true', o conteúdo a ser escrito será
            // adicionado ao invés de ser substituído.
            // FileWriter -> escreve diretamente no arquivo.
            FileWriter fw = new FileWriter(this.arquivoCSV, true);

            // BufferedWriter -> o comando de escrita vai para um buffer e
            // o conteúdo armazenado será enviado de uma só vez para o Writer.
            BufferedWriter bw = new BufferedWriter(fw);

            // Escrevendo o cabeçalho no arquivo .CSV
            bw.write(cabecalho);

            // Percorrendo a lista duplamente encadeada.
            while(ponteiro != null){

                // Criando uma nova linha
                // Pulando para a próxima linha do arquivo .CSV.
                bw.newLine();

                // Escrevendo os dados no arquivo .CSV
                bw.write(String.valueOf(ponteiro.getObjeto().getCodigoUsuario()));
                bw.write(delimitador);
                bw.write(ponteiro.getObjeto().getNomeUsuario());
                bw.write(delimitador);
                bw.write("A");
                bw.write(delimitador);
                bw.write("B");

                // Indo para o próximo usuário presente na lista.
                ponteiro = ponteiro.getProximoPonteiro();

            }
            
            // Fechando os componentes
            bw.close();
            fw.close();
            
        } catch (IOException ex) {
            
            ex.printStackTrace();
            
        }
        
        return true;    
        
    }
    
    // Método para gravar todos os dados no banco de dados Oracle
    public boolean gravarUsuariosBD(DadosC listaDE){
        
        // Criando instância da classe UsuarioDAO.
        DadosDAO uDAO = new DadosDAO();
        
        // Verificando se é possível conectar ao banco de dados Oracle
        // Se for possível, o atributo conn será diferente de 'null'
        if((this.conn = uDAO.conectarBanco()) != null){
            
            // Pegando o início da lista duplamente encadeada, se existir.
            No proximoUsuario = listaDE.getLista(listaDE);
        
            // O primeiro nó da lista, de forma abstrata, está na posição ZERO.
            int i = 0;

            // Enquanto o ponteiro atual for diferente de null e
            // for menor que a quantidade de nós
            while ((proximoUsuario != null) && (i < listaDE.getQuantidadeDeNos())){

                // Se não foi possível gravar no banco de dados Oracle,
                // retorna falso e então, executaremos o comando 'break' para
                // sair das estruturas 'if' e 'while'.
                // Observação: será passado como parâmetro apenas o campo
                // objeto (onde contém as informações do usuário atual) do nó.
                if(!uDAO.gravarUsuariosBD(proximoUsuario.getObjeto())){

                    break;

                }
                
                // Vai para o próximo nó.
                proximoUsuario = proximoUsuario.getProximoPonteiro();
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
    public boolean selecionarUsuariosBD(UsuarioC listaDE){
        
        // Criando instância da classe UsuarioDAO.
        DadosDAO uDAO = new DadosDAO();
        
        // Verificando se é possível conectar ao banco de dados Oracle
        // Se for possível, o atributo conn será diferente de 'null'
        if((this.conn = uDAO.conectarBanco()) != null){

            try{
            
                // Resgatando todos os usuários do banco de dados Oracle.
                this.setRs(uDAO.selecionarUsuariosBD());

                // Verificando se o resultado retornado é diferente de null.
                if(this.getRs() != null){

                    // Percorrendo o resultado retornado do banco de dados
                    while(this.getRs().next()){

                        // Cria-se uma instância da classe Usuario para armazear
                        // temporariamente.
                        Usuario objeto = new Usuario();

                        // Armazena os dados nos atributos de 'objeto'
                        // através dos dados do ResultSet atual.
                        objeto.setCodigoUsuario(this.getRs().getInt("codigo"));
                        objeto.setNomeUsuario(this.getRs().getString("nome"));
                        objeto.setLoginUsuario(this.getRs().getString("login"));
                        objeto.setSenhaUsuario(this.getRs().getString("senha"));

                        // Inserindo o usuário de forma efetiva na lista.
                        //this.inserirUsuario(listaDE, objeto);

                    }

                    return true;

                }
        
            }catch(SQLException e){

                e.printStackTrace();

            }
        
        }
        
        return false;
        
    }
    
}
