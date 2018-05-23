/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.dao.DadosEleitorDAO;
import modelo.dao.GestorDAO;
import modelo.dominio.DadosEleitor;
import modelo.dominio.Gestor;

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
    public boolean PartidoExistente(String partido) {

        if (!"".equals(partido)) {
            return this.eleitorDAO.verificarExistePartido(partido);
        }

        return false;
    }

    //Verificar se nome de eleição está duplicado
    public boolean EleicaoExistente(String eleicao) {

        if (!"".equals(eleicao)) {
            return this.eleitorDAO.verificarExisteEleicao(eleicao);
        }

        return false;
    }

    //Criar objeto com caracteristicas do gestor 
    //--> Precisa colocar método pela lista <--
    public void setDadosEleitor(String periodo, String uf, String municipio, String sexo, String faixa_etaria, String total) {
        this.EleitorDados = new DadosEleitor(periodo, uf, municipio, sexo, faixa_etaria, total);
    }

    //Cadastrar Novo Gestor
    public boolean setCadastrarEleitor() {

        DadosEleitorDAO eDAO = new DadosEleitorDAO();

        if ((this.conn = eDAO.conectarBanco()) != null) {

            //Salvar dados
            if (!eDAO.gravarEleitorBD(this.EleitorDados)) {
                eDAO.fecharConexaoOracle();
                eDAO = null;

                return false;
            }

            // Fechar conexão
            eDAO.fecharConexaoOracle();
            eDAO = null;

            return true;

        }

        return false;
    }

//    //Retorna dados do gestor logado
//    public Gestor getSessaoGestor(String login) {
//
//        GestorDAO gDAO = new GestorDAO();
//
//        if ((this.conn = gDAO.conectarBanco()) != null) {
//
//            try {
//
//                // Resgatando os dados do Banco
//                this.setRs(gDAO.selecionarUsuarioBD(login));
//
//                // Verificando retorno
//                if (this.getRs() != null) {
//
//                    // Salvar objeto
//                    while (this.getRs().next()) {
//                        this.gestorDados = new Gestor();
//                        this.gestorDados.setId(this.getRs().getInt("g_id"));
//                        this.gestorDados.setNome(this.getRs().getString("g_nome"));
//                        this.gestorDados.setCpf(this.getRs().getString("g_cpf"));
//                        this.gestorDados.setNascimento(this.getRs().getString("g_nascimento"));
//                        this.gestorDados.setSexo(this.getRs().getString("g_sexo"));
//                        this.gestorDados.setLogin(this.getRs().getString("g_login"));
//                        this.gestorDados.setSenha(this.getRs().getString("g_senha"));
//                        this.gestorDados.setEmail(this.getRs().getString("g_email"));
//                        this.gestorDados.setTelefone(this.getRs().getString("g_telefone"));
//                    }
//
//                }
//
//            } catch (SQLException e) {
//
//                e.printStackTrace();
//
//            }
//
//        }
//
//        return this.gestorDados;
//    }
     
}
