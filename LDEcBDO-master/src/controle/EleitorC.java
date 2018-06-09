/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.dao.DadosCandidatoDAO;
import modelo.dao.DadosEleitorDAO;
import modelo.dao.GestorDAO;
import modelo.dominio.DadosEleitor;
import modelo.dominio.Gestor;
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
    //Verificar se Municipio está duplicado
    public boolean MunicipioExistente(String municipio) {

        if (!"".equals(municipio)) {
            return this.eleitorDAO.verificarExisteMunicipio(municipio);
        }

        return false;
    }

    //Verificar se o UF está duplicado
    public boolean EstadoExistente(String estado) {

        if (!"".equals(estado)) {
            return this.eleitorDAO.verificarExisteEstado(estado);
        }

        return false;
    }

    //Verificar se o Partido está duplicado
    public boolean PariodoExistente(String periodo) {

        if (!"".equals(periodo)) {
            return this.eleitorDAO.verificarExistePeriodoDados(periodo);
        }

        return false;
    }

    //Verificar se nome de eleição está duplicado
    public boolean FaixaEtariaExistente(String faixa) {

        if (!"".equals(faixa)) {
            return this.eleitorDAO.verificarExisteFaixaEtaria(faixa);
        }

        return false;
    }

    //Criar objeto com caracteristicas do gestor 
    //--> Precisa colocar método pela lista <--
    public void setDadosEleitor(String periodo, String uf, String municipio, String sexo, String faixa_etaria, String total) {
        this.EleitorDados = new DadosEleitor(periodo, uf, municipio, sexo, faixa_etaria, total);
    }

    //String periodo, String uf, String municipio, String sexo, String faixa_etaria, String total
    // Método para gravar todos os dados no banco de dados Oracle aproveitando a classe DadosC
    public boolean gravarDadosBanco(DadosC listaDE, String p1, String p2) {

        // Criando instância da classe UsuarioDAO.
        DadosEleitorDAO uDAO = new DadosEleitorDAO();

        // Verificando se é possível conectar ao banco de dados Oracle
        // Se for possível, o atributo conn será diferente de 'null'
        if ((this.conn = uDAO.conectarBanco()) != null) {

            // Pegando o início da lista duplamente encadeada, se existir.
            No proximoDado = listaDE.getLista(listaDE);

            // O primeiro nó da lista, de forma abstrata, está na posição ZERO.
            int i = 0;

            // Enquanto o ponteiro atual for diferente de null e
            // for menor que a quantidade de nós
            while ((proximoDado != null) && (i < listaDE.getQuantidadeDeNos())) {

                // Se não foi possível gravar no banco de dados Oracle,
                // retorna falso e então, executaremos o comando 'break' para
                // sair das estruturas 'if' e 'while'.
                // Observação: será passado como parâmetro apenas o campo
                // objeto (onde contém as informações do usuário atual) do nó.
                if (!uDAO.gravarEleitorBD(proximoDado.getObjctEleitorado(), p1, p2)) {

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

    public boolean refDadosBanco(String p1, String p2, String p3) {

        // Criando instância da classe UsuarioDAO.
        DadosEleitorDAO uDAO = new DadosEleitorDAO();

        // Verificando se é possível conectar ao banco de dados Oracle
        // Se for possível, o atributo conn será diferente de 'null'
        if ((this.conn = uDAO.conectarBanco()) != null) {

            if (!uDAO.referenciarDado(p1, p2, p3)) {

                return true;
            }
        }

        // Fechando a conexão ao banco de dados
        uDAO.fecharConexaoOracle();

        // Setando null para o objeto uDAO
        uDAO = null;

        return false;
    }

    public void importarDadosEleitor(DadosC listaDados) {
        No pAux = listaDados.getInicioDaLista();
        EleitorC eleitor = new EleitorC();
        DadosEleitorDAO dao = new DadosEleitorDAO();
        int erros = 0;
        for (int i = 0; i < listaDados.getQuantidadeDeNos(); i++) {

            try {
                //Verifica se existe estado no banco
                if (eleitor.EstadoExistente(pAux.getObjctEleitorado().getUf())) {
                    if (eleitor.refDadosBanco("estado", "e_uf", dao.getReferencia("estado", "e_uf", pAux.getObjctEleitorado().getUf()))) {
                        System.out.println("Referência Identificada");
                    } else {
                        System.out.println("Ocorreu um erro ao referenciar - ID não encontrado");
                        throw new Exception("Ocorreu um erro ao referenciar estado");
                    }
                } else {
                    eleitor.gravarDadosBanco(listaDados, "estado", "e_estado");
                }

                //Verifica se existe municipio no banco
                if (eleitor.MunicipioExistente(pAux.getObjctEleitorado().getMunicipio())) {
                    if (eleitor.refDadosBanco("municipio", "m_municipio", dao.getReferencia("perfil_eleitor", "municipio", pAux.getObjctEleitorado().getMunicipio()))) {
                        System.out.println("Municipio inserido");
                    } else {
                        System.out.println("Municipio não inserido");
                    }

                } else {
                    eleitor.gravarDadosBanco(listaDados, "municipio", "m_municipio");
                }

                //Verifica se existe esta faixa no banco de dados
                if (eleitor.FaixaEtariaExistente(pAux.getObjctEleitorado().getFaixa_etaria())) {
                    if (eleitor.refDadosBanco("perfil_eleitor", "p_faixa_etaria", dao.getReferencia("perfil_eleitor", "p_faixa_etaria", pAux.getObjctEleitorado().getMunicipio()))) {
                        System.out.println("Perfil inserido");
                    } else {
                        System.out.println("Perfil não inserido");
                    }
                } else {
                    eleitor.gravarDadosBanco(listaDados, "perfil_eleitor", "p_faixa_etaria");
                }

                if (eleitor.gravarDadosBanco(listaDados, "", "")) {
                    JOptionPane.showMessageDialog(null, "Dados gravados no BD Oracle com sucesso...");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao gravar os dados no BD Oracle...");
                }
            } catch (Exception e) {

            }

            //Próximo
            pAux = pAux.getProximoPonteiro();
        }
    }

}
