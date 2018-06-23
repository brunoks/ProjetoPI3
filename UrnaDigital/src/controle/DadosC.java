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
import modelo.dao.DadosEleitorDAO;
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
     * @param listaDados
     * @return 
     */
    public void importarDadosCandidato(ListaC listaDados) {
       No pAux = listaDados.getInicioDaLista();
        DadosCandidatoDAO dao = new DadosCandidatoDAO();
        VerificaDAO v = new VerificaDAO();
        
        for (int i = 0; i < listaDados.getQuantidadeDeNos(); i++) {

            try {
                //Verificar se existe Período da Eleicao
                if(!v.verificaSeExiste("eleicao", "el_ano", pAux.getObjctDados().getAno())){
                    v.setNovaEleicao(pAux.getObjctDados().getAno());
                }

                String eleicaoID = v.getReferencia("eleicao", "el_ano", pAux.getObjctDados().getAno());
                if(eleicaoID.equals("")){
                    throw new Exception("\nOcorreu um erro ao referenciar eleição");
                }
                
                
                //Verificar se existe Cargo
                if(!v.verificaSeExiste("cargo", "cr_cargo", pAux.getObjctDados().getCargo())){
                    v.setNovoCargo(pAux.getObjctDados().getCargo());
                }
                
                String cargoID = v.getReferencia("cargo", "cr_cargo", pAux.getObjctDados().getCargo());
                if(cargoID.equals("")){
                    throw new Exception("\nOcorreu um erro ao referenciar estado");
                }
                
                //Verificar se existe Partido
                if(!v.verificaSeExiste("partido", "pr_partido", pAux.getObjctDados().getPartido())){
                    
                    v.setNovoPartido(pAux.getObjctDados().getPartido(), pAux.getObjctDados().getSiglaP());
                }
                
                String partidoID = v.getReferencia("partido", "pr_partido", pAux.getObjctDados().getPartido());
                if(partidoID.equals("")){
                    throw new Exception("\nOcorreu um erro ao referenciar município");
                }
                
                this.gravarDadosBanco(pAux.getObjctDados(), eleicaoID, partidoID, cargoID);
            } catch (Exception e) {
                System.out.println("this error " + e.getMessage());
            }

            //Próximo Registro
            pAux = pAux.getProximoPonteiro();
        }
    }
    
    /**
     * Exportar Dados Candidato
     * @param listaDados
     * @return 
     */
    public void exmportarDadosCandidato(ListaC listaDados) {
       No pAux = listaDados.getInicioDaLista();
        DadosCandidatoDAO dao = new DadosCandidatoDAO();
        VerificaDAO v = new VerificaDAO();
        
        for (int i = 0; i < listaDados.getQuantidadeDeNos(); i++) {

            try {
                //Verificar se existe Período da Eleicao
                if(v.verificaSeExiste("eleicao", "el_ano", pAux.getObjctDados().getAno().replaceAll("\"", ""))){
                    
                }

                String eleicaoID = v.getReferencia("eleicao", "el_ano", pAux.getObjctDados().getAno().replaceAll("\"", ""));
                if(eleicaoID.equals("")){
                    throw new Exception("\nOcorreu um erro ao referenciar eleição");
                }
                
                
                //Verificar se existe Cargo
                if(!v.verificaSeExiste("cargo", "cr_cargo", pAux.getObjctDados().getCargo().replaceAll("\"", ""))){
                    v.setNovoCargo(pAux.getObjctDados().getCargo().replaceAll("\"", ""));
                }
                
                String cargoID = v.getReferencia("cargo", "cr_cargo", pAux.getObjctDados().getCargo().replaceAll("\"", ""));
                if(cargoID.equals("")){
                    throw new Exception("\nOcorreu um erro ao referenciar estado");
                }
                
                //Verificar se existe Partido
                if(!v.verificaSeExiste("partido", "pr_partido", pAux.getObjctDados().getPartido().replaceAll("\"", ""))){
                    
                    v.setNovoPartido(pAux.getObjctDados().getPartido().replaceAll("\"", ""), pAux.getObjctDados().getSiglaP().replaceAll("\"", ""));
                }
                
                String partidoID = v.getReferencia("partido", "pr_partido", pAux.getObjctDados().getPartido().replaceAll("\"", ""));
                if(partidoID.equals("")){
                    throw new Exception("\nOcorreu um erro ao referenciar município");
                }
                
                this.gravarDadosBanco(pAux.getObjctDados(), eleicaoID, partidoID, cargoID);
            } catch (Exception e) {
                System.out.println("this error " + e.getMessage());
            }

            //Próximo Registro
            pAux = pAux.getProximoPonteiro();
        }
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
