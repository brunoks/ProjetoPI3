/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.ResultSet;
import modelo.dao.DadosCandidatoDAO;
import modelo.dao.DadosEleitorDAO;
import modelo.dao.DadosVotosDAO;
import modelo.dao.VerificaDAO;
import modelo.dominio.DadosCandidato;
import modelo.dominio.DadosEleitor;
import modelo.dominio.DadosVotos;
import modelo.dominio.No;

/**
 *
 * @author lucianopezzin
 */
public class VotosC {
    /*###################################
              ATRIBUTOS DA CLASSE
      ###################################*/
    private final DadosVotosDAO dadosDAO;

    private DadosVotos dadosVotos;
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
    public VotosC() {
        this.dadosDAO = new DadosVotosDAO();
        this.dadosVotos = null;
    }
    /**
     * Importar Dados Candidato
     * @param listaDados
     * @return 
     */
    public void importarVotosCandidato(ListaC listaDados) {
       No pAux = listaDados.getInicioDaLista();
        DadosVotos dao = new DadosVotos();
        VerificaDAO v = new VerificaDAO();
        
        for (int i = 0; i < listaDados.getQuantidadeDeNos(); i++) {

            try {
                //Verificar se existe Período da Eleicao
                if(!v.verificaSeExiste("eleicao", "el_ano", pAux.getObjectVotos().getEleicao())){
                    v.setNovaEleicao(pAux.getObjectVotos().getEleicao());
                }

                String eleicaoID = v.getReferencia("eleicao", "el_ano", pAux.getObjectVotos().getEleicao());
                if(eleicaoID.equals("")){
                    throw new Exception("\nOcorreu um erro ao referenciar eleição");
                }
                
                //Verificar se existe Estado
                if(!v.verificaSeExiste("estado", "e_uf", pAux.getObjectVotos().getEstado())){
                    v.setNovoEstado(pAux.getObjectVotos().getEstado());
                }
                
                String estadoID = v.getReferencia("estado", "e_uf", pAux.getObjectVotos().getEstado());
                if(estadoID.equals("")){
                    throw new Exception("\nOcorreu um erro ao referenciar estado");
                }
                
                //Verificar se existe Cargo
                if(!v.verificaSeExiste("cargo", "cr_cargo", pAux.getObjectVotos().getCargo())){
                    v.setNovoCargo(pAux.getObjectVotos().getCargo());
                }
                
                String cargoID = v.getReferencia("cargo", "cr_cargo", pAux.getObjectVotos().getCargo());
                if(cargoID.equals("")){
                    throw new Exception("\nOcorreu um erro ao referenciar estado");
                }
                
                //Verificar se existe Partido
                if(!v.verificaSeExiste("partido", "pr_partido", pAux.getObjectVotos().getPartido())){
                    
                    v.setNovoPartido(pAux.getObjectVotos().getPartido(), pAux.getObjectVotos().getSigla_partido());
                }
                
                String partidoID = v.getReferencia("partido", "pr_partido", pAux.getObjectVotos().getPartido());
                if(partidoID.equals("")){
                    throw new Exception("\nOcorreu um erro ao referenciar município");
                }
                
               //Verificar se existe Município
                if(!v.verificaSeExiste("municipio", "m_municipio", pAux.getObjectVotos().getMunicipio())){
                    v.setNovoMunicipio(estadoID, pAux.getObjectVotos().getMunicipio());
                }
                
                String municipioID = v.getReferencia("municipio", "m_municipio", pAux.getObjectVotos().getMunicipio());
                if(municipioID.equals("")){
                    throw new Exception("\nOcorreu um erro ao referenciar município");
                }
                
                //String cr_id, String id_m, String e_id, String c_id, String el_id, String pr_id
                this.gravarDadosBanco(pAux.getObjectVotos(), cargoID,municipioID,estadoID,cargoID,eleicaoID,partidoID);
            } catch (Exception e) {
                System.out.println("this error " + e.getMessage());
            }

            //Próximo Registro
            pAux = pAux.getProximoPonteiro();
        }
    }

    public boolean gravarDadosBanco(DadosVotos DadosE, String cr_id, String id_m, String e_id, String c_id, String el_id, String pr_id) {

        // Criando instância da classe UsuarioDAO.
        DadosVotosDAO uDAO = new DadosVotosDAO();

        // Verificando se é possível conectar ao banco de dados Oracle
        // Se for possível, o atributo conn será diferente de 'null'
        if ((this.conn = uDAO.conectarBanco()) != null) {
            return uDAO.gravarVotosBD(DadosE, cr_id, id_m, e_id, c_id,el_id,pr_id);

        }

        return false;

    }
}
