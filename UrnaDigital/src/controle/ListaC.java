package controle;

import modelo.dominio.No;
import modelo.dao.DadosCandidatoDAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.FileWriter;

import java.io.IOException;
import java.io.InputStreamReader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.dao.DadosEleitorDAO;
import modelo.dao.VerificaDAO;
import modelo.dominio.DadosCandidato;
import modelo.dominio.DadosEleitor;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import visao.JFramePrincipal;

/**
 * Gerenciar Lista
 * @author AC/DC
 */
public class ListaC {

    /*###################################
              ATRIBUTOS DA CLASSE
      ###################################*/
    VerificaDAO verifica = new VerificaDAO();
    
    // Descritor da lista duplamente encadeada
    private int quantidadeDeNos;

    private No inicioDaLista;
    private No finalDaLista;

    // Atributos para trabalhar com arquivos
    private File arquivoJson;
    BufferedReader bReader;
    FileWriter writer;

    String[] d;
    String a;
    String linha;
    String arquivo;
    String arquivoTXT;

    // Atributos para trabalhar com banco de dados
    private Connection conn;
    ResultSet rs;

    /*###################################
             CONSTRUTOR DA CLASSE
      ###################################*/
    public ListaC() {
        this.criarLista();
    }

    /*##########################################
        MÉTODOS get e set DA CLASSE - Operações
      ##########################################*/
    // Método para alterar o atributo quantidadeDeNos.
    public void setQuantidadeDeNos(int quantidadeDeNos) {
        this.quantidadeDeNos = quantidadeDeNos;
    }

    // Método que retorna a quantidade de usuários.
    public int getQuantidadeDeNos() {
        return this.quantidadeDeNos;
    }

    // Método para alterar o atributo inicio.
    public void setInicioDaLista(No inicioDaLista) {
        this.inicioDaLista = inicioDaLista;
    }

    // Método que retorna o ponteiro para o primeiro nó da lista.
    public No getInicioDaLista() {
        return this.inicioDaLista;
    }

    // Método para alterar o atributo inicio.
    public void setFinalDaLista(No finalDaLista) {
        this.finalDaLista = finalDaLista;
    }

    // Método que retorna o ponteiro para o primeiro nó da lista.
    public No getFinalDaLista() {
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
    private void criarLista() {

        this.setInicioDaLista(null);
        this.setQuantidadeDeNos(0);
        this.setFinalDaLista(null);

    }

    // Método para limpar a lista.
    public void limparLista(ListaC listaDE) {

        if (listaDE.isEmpty(listaDE)) {
            listaDE = null;
        } else {
            listaDE.setInicioDaLista(null);
            listaDE.setQuantidadeDeNos(0);
            listaDE.setFinalDaLista(null);
        }

    }

    // Método que verifica se a lista está vazia.
    public boolean isEmpty(ListaC listaDE) {

        // Se a quantidade de nós da lista tiver o valor 0
        // quer dizer que a lista está vazia.
        if (listaDE.getQuantidadeDeNos() == 0) {
            return true;
        } else {
            return false;
        }

    }

    // Retornando o início da lista.
    public No getLista(ListaC listaDE) {

        if (!listaDE.isEmpty(listaDE)) {
            return listaDE.getInicioDaLista();
        }

        return null;

    }
    
    // Método para inserir na lista de forma ordenada através do arquivo .CSV.
    public boolean lerArquivoTXT(ListaC listaDE, File _arquivo, String entrada) {

        // Objeto BufferedReader exige try-catch
        try {

            // Local onde o arquivo está
            this.arquivoTXT = _arquivo.getPath();
            // Cria um buffer para a ler a partir de um arquivo
            this.bReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.arquivoTXT), "ISO-8859-1"));
//            this.bReader = new BufferedReader(new FileReader(this.arquivoTXT));

            // Percorrendo o arquivo linha a linha
            while ((this.linha = this.bReader.readLine()) != null) {

                // Pega a linha e verifica se existe o delimitador ';' para separar os dados
                // e jogá-los (se existir) no vetor 'dadosTemporarios'.
                //this.a = Arrays.toString(this.linha.split(";"));
                //this.a = this.linha.replaceAll("#NULO#", "Nulo");
                this.d = this.linha.split(";");
                //Apenas para certificar o que está sendo separado na variável d
                //escreverArquivoTeste(d);

                //Criando No para substituir dentro do switch
                No novoNo = new No();

                switch (entrada) {
                    case "Candidato":
                        No NoCandidato = new No(d[2], d[3], d[4], d[5], d[7], d[8], d[9], d[10], d[13], d[18], d[19], d[22], d[26], d[30]);
                        novoNo = NoCandidato;
                        break;
                    case "Eleitorado":
                        No NoEleitorado = new No(d[0], d[1], d[2], d[5], d[6], d[8]);
                        novoNo = NoEleitorado;
                        break;
                    case "Voto":
                        No NoVoto = new No(d[15], d[8], d[5], d[14], d[2], d[21], d[22], d[28]);
                        novoNo = NoVoto;
                        break;
                }

                // Caso 1: Lista vazia
                if (listaDE.isEmpty(listaDE)) {
                    novoNo.setPonteiroAnterior(null);
                    novoNo.setProximoPonteiro(null);

                    listaDE.setInicioDaLista(novoNo);
                    listaDE.setFinalDaLista(novoNo);

                } else {
                    //Depois que a lista não estiver vazia, será preenchida pelo início
                    novoNo.setProximoPonteiro(null);
                    novoNo.setPonteiroAnterior(listaDE.getFinalDaLista());

                    listaDE.getFinalDaLista().setProximoPonteiro(novoNo);
                    listaDE.setFinalDaLista(novoNo);

                }
                listaDE.setQuantidadeDeNos(listaDE.getQuantidadeDeNos() + 1);

            }

            // Fechan o BufferedReader
            this.bReader.close();

        } catch (FileNotFoundException e) {
            Logger.getLogger(ListaC.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(ListaC.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;

    }

    // Método para pegar as informações da lista de forma ordenada e
    // escrever no arquivo .CSV.
    public boolean escreverArquivoJson(ListaC listaDE, String entrada) {

        switch (entrada) {

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
    public void escreverCandidato(ListaC listaDE) {
        // Local onde será criado o arquivo e os dados serão gravados.
        this.arquivoJson = new File("C:\\Users\\Bruno\\Documents\\jsonFileCandidato.json");

        JSONObject jsonObject = new JSONObject();
        JSONArray tempos = new JSONArray();
        try {

            // Se o arquivo não existir, cria-se um novo.
            if (this.arquivoJson.exists()) {

            } else {
                this.arquivoJson.createNewFile(); // Arquivo vazio

            }
            //ponteiro auxiliar para 
            No pAux = listaDE.getInicioDaLista();
            FileWriter fw = new FileWriter(this.arquivoJson, true);
            BufferedWriter bw = new BufferedWriter(fw);
            int i = 0;
            while (pAux.getProximoPonteiro() != null) {

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
                System.out.println("a " + i);

            }
            bw.write(tempos.toString());
            bw.close();
            fw.close();

        } catch (IOException ex) {

            ex.printStackTrace();

        } catch (JSONException ex) {
            Logger.getLogger(ListaC.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    // Escrever Dados Eleitorado
    public void escreverEleitorado(ListaC listaDE) {
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
            } else {
                this.arquivoJson.createNewFile(); // Arquivo vazio

            }
            //ponteiro auxiliar para 
            No pAux = listaDE.getInicioDaLista();
            FileWriter fw = new FileWriter(this.arquivoJson, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < listaDE.getQuantidadeDeNos(); i++) {

                //Inserindo os atributos ao Json
                tempos.put(jsonObject.put("periodo", pAux.getObjctEleitorado().getPeriodo()));
                tempos.put(jsonObject.put("uf", pAux.getObjctEleitorado().getUf()));
                tempos.put(jsonObject.put("municipio", pAux.getObjctEleitorado().getMunicipio()));
                tempos.put(jsonObject.put("sexo", pAux.getObjctEleitorado().getSexo()));
                tempos.put(jsonObject.put("faixa_etaria", pAux.getObjctEleitorado().getFaixa_etaria()));
                tempos.put(jsonObject.put("total", pAux.getObjctEleitorado().getTotal()));

                if (i == listaDE.getQuantidadeDeNos() - 1) {
                    bw.write(tempos.toString());
                } else {
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
            Logger.getLogger(ListaC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
}
