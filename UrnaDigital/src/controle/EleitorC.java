/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.ResultSet;
import modelo.dao.DadosEleitorDAO;
import modelo.dao.VerificaDAO;
import modelo.dominio.DadosEleitor;
import modelo.dominio.No;

/**
 *
 * @author Bruno
 */
public class EleitorC {

    /*###################################
              ATRIBUTOS DA CLASSE
      ###################################*/
    private final DadosEleitorDAO eleitorDAO;

    private DadosEleitor EleitorDados;
    Connection conn;
    ResultSet rs;
    

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

    /*###################################
              CONSTRUTOR DA CLASSE
      ###################################*/
    public EleitorC() {
        this.eleitorDAO = new DadosEleitorDAO();
        this.EleitorDados = null;
    }

    /*###################################
               MÉTODOS DA CLASSE
      ###################################*/
    
    /**
     * Dados do Eleitorado
     * @param periodo
     * @param uf
     * @param municipio
     * @param sexo
     * @param faixa_etaria
     * @param total 
     */
    public void setDadosEleitor(String periodo, String uf, String municipio, String sexo, String faixa_etaria, String total) {
        this.EleitorDados = new DadosEleitor(periodo, uf, municipio, sexo, faixa_etaria, total);
    }

    
    /**
     * Gravar Linha no Banco
     * @param DadosE
     * @param refEleicao
     * @param refEstado
     * @param refMunicipio
     * @return 
     */
    public boolean gravarDadosBanco(DadosEleitor DadosE, String refEleicao, String refEstado, String refMunicipio) {

        // Criando instância da classe UsuarioDAO.
        DadosEleitorDAO uDAO = new DadosEleitorDAO();

        // Verificando se é possível conectar ao banco de dados Oracle
        // Se for possível, o atributo conn será diferente de 'null'
        if ((this.conn = uDAO.conectarBanco()) != null) {
            return uDAO.gravarEleitorBD(DadosE, refEleicao, refEstado, refMunicipio);

        }

        return false;

    }

    /**
     * Importar Lista
     * @param listaDados 
     */
    public void importarDadosEleitor(ListaC listaDados) {
        No pAux = listaDados.getInicioDaLista();
        DadosEleitorDAO dao = new DadosEleitorDAO();
        VerificaDAO v = new VerificaDAO();
        
        for (int i = 0; i < listaDados.getQuantidadeDeNos(); i++) {

            try {
                //Verificar se existe Período da Eleicao
                if(!v.verificaSeExiste("eleicao", "el_ano", pAux.getObjctEleitorado().getPeriodo())){
                    v.setNovaEleicao(pAux.getObjctEleitorado().getPeriodo());
                }
                
                String eleicaoID = v.getReferencia("eleicao", "el_ano", pAux.getObjctEleitorado().getPeriodo());
                if(eleicaoID.equals("")){
                    throw new Exception("\nOcorreu um erro ao referenciar eleição");
                }
                
                
                //Verificar se existe Estado
                if(!v.verificaSeExiste("estado", "e_uf", pAux.getObjctEleitorado().getUf())){
                    v.setNovoEstado(pAux.getObjctEleitorado().getUf());
                }
                
                String estadoID = v.getReferencia("estado", "e_uf", pAux.getObjctEleitorado().getUf());
                if(estadoID.equals("")){
                    throw new Exception("\nOcorreu um erro ao referenciar estado");
                }
                
                //Verificar se existe Município
                if(!v.verificaSeExiste("municipio", "m_municipio", pAux.getObjctEleitorado().getMunicipio())){
                    v.setNovoMunicipio(estadoID, pAux.getObjctEleitorado().getMunicipio());
                }
                
                String municipioID = v.getReferencia("municipio", "m_municipio", pAux.getObjctEleitorado().getMunicipio());
                if(municipioID.equals("")){
                    throw new Exception("\nOcorreu um erro ao referenciar município");
                }
                
                this.gravarDadosBanco(pAux.getObjctEleitorado(), eleicaoID, estadoID, municipioID);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            //Próximo Registro
            pAux = pAux.getProximoPonteiro();
        }
    }

}
