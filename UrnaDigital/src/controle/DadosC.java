package controle;

import modelo.dominio.No;
import modelo.dao.DadosCandidatoDAO;

import java.io.BufferedReader;

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
import modelo.dao.VerificaDAO;
import modelo.dominio.DadosCandidato;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Dados Candidato
 *
 * @author AC/DC
 */
public class DadosC {

    /*###################################
              ATRIBUTOS DA CLASSE
      ###################################*/
    private final DadosCandidatoDAO candidatoDAO;

    // Atributos para trabalhar com arquivo .CSV
    private Connection conn;
    ResultSet rs;

    /*###################################
             CONSTRUTOR DA CLASSE
      ###################################*/
    public DadosC() {
        this.candidatoDAO = new DadosCandidatoDAO();
    }

    /*##########################################
        MÉTODOS get e set DA CLASSE - Operações
      ##########################################*/
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
    
    /**
     * Importar Dados Candidato
     * @param listaDE2
     * @return 
     */
    public boolean importarDadosCandidato(ListaC listaDE2) {
        String ref = "";
        No pAux = listaDE2.getInicioDaLista();
        DadosC candidato = new DadosC();
        VerificaDAO dao = new VerificaDAO();
        VerificaDAO verifica = new VerificaDAO();
        int let = 0;
        for (int i = 0; i < listaDE2.getQuantidadeDeNos(); i++) {

            try {
                //Verifica se existe ano da eleição no banco
                if (!verifica.verificaSeExiste("eleicao", "el_ano", pAux.getObjctDados().getAno())) {
                    dao.setNovaEleicao(pAux.getObjctDados().getAno());
                }
                String ano = verifica.getReferencia("eleicao", "el_ano", pAux.getObjctDados().getPartido());
                if (ano.equals("")) {
                    throw new Exception("\nOcorreu um erro ao salvar ano");
                }

                //Verifica se existe partido no banco
                if (!verifica.verificaSeExiste("partido", "pr_partido", pAux.getObjctDados().getPartido())) {
                    dao.setNovoPartido(pAux.getObjctDados().getPartido(), pAux.getObjctDados().getSiglaP());
                }
                String partido = verifica.getReferencia("partido", "pr_partido", pAux.getObjctDados().getPartido());
                if (partido.equals("")) {
                    throw new Exception("\nOcorreu um erro ao salvar ano");
                }

                //Verifica se existe cargo no banco
                if (!verifica.verificaSeExiste("cargo", "cr_cargo", pAux.getObjctDados().getCargo())) {
                    dao.setNovoCargo(pAux.getObjctDados().getPartido());
                }
                String cargo = verifica.getReferencia("cargo", "cr_cargo", pAux.getObjctDados().getCargo());
                if (cargo.equals("")) {
                    throw new Exception("\nOcorreu um erro ao salvar cargo");
                }

                if (this.gravarDadosBanco(pAux.getObjctDados(), ano, partido, cargo)) {

                } else {
                    throw new Exception("\nOcorreu um erro ao salvar dados de candidato");
                }

            } catch (Exception error) {

            }
            pAux = pAux.getProximoPonteiro();
        }
        return true;
    }

    /**
     * Gravar Dados no Banco
     *
     * @param DadosE
     * @param refAno
     * @param refPartido
     * @param refCargo
     * @return
     */
    public boolean gravarDadosBanco(DadosCandidato DadosE, String refAno, String refPartido, String refCargo) {

        // Criando instância da classe UsuarioDAO
        DadosCandidatoDAO uDAO = new DadosCandidatoDAO();

        // Verificando se é possível conectar ao banco de dados Oracle
        // Se for possível, o atributo conn será diferente de 'null'
        if ((this.conn = uDAO.conectarBanco()) != null) {
            return uDAO.gravarNoBanco(DadosE, refAno, refPartido, refCargo);

        }

        return false;

    }
}
