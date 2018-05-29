package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.dao.conexao.ConnectionFactory;
import modelo.dominio.DadosCandidato;
import modelo.dominio.DadosEleitor;

/**
 * Classe de Tratamentos das Consultas vinculadas ao Eleitorado
 *
 * @author ALERTRACK
 */
public class DadosEleitorDAO {

    /*###################################
              ATRIBUTOS DA CLASSE
      ###################################*/
    private ConnectionFactory cf;
    private Connection conn;
    private PreparedStatement pstmt; // query
    private Statement stmt;
    private String sql;
    private ResultSet rs;

    /*###################################
             CONSTRUTOR DA CLASSE
      ###################################*/
    public DadosEleitorDAO() {

        this.setConn(null);

    }

    /*###################################
           MÉTODOS get e set DA CLASSE
      ###################################*/
    // Método para retornar o objeto da classe 'ConnectionFactory'
    public ConnectionFactory getCf() {
        return this.cf;
    }

    // Método para armazenar o objeto da classe 'ConnectionFactory'
    public void setCf(ConnectionFactory _cf) {
        this.cf = _cf;
    }

    // Método para resgatar o estado de conexão com o Oracle
    public Connection getConn() {
        return this.conn;
    }

    // Método para armazenar o estado de conexão com o Oracle
    public void setConn(Connection _conn) {
        this.conn = _conn;
    }

    // Método 
    public PreparedStatement getPstmt() {
        return this.pstmt;
    }

    // Método 
    public void setPstmt(PreparedStatement _pstmt) {
        this.pstmt = _pstmt;
    }

    // Método 
    public Statement getStmt() {
        return this.stmt;
    }

    // Método 
    public void setStmt(Statement _stmt) {
        this.stmt = _stmt;
    }

    // Método para resgatar a instrução SQL
    public String getSql() {
        return this.sql;
    }

    // Método para armazenar o instrução SQL
    public void setSql(String _sql) {
        this.sql = _sql;
    }

    // Método para recuperar o ResultSet
    public ResultSet getRs() {
        return this.rs;
    }

    // Método para armazenar o ResultSet
    public void setRs(ResultSet _rs) {
        this.rs = _rs;
    }

    /*###################################
               MÉTODOS DA CLASSE
      ###################################*/
    //Conexão com banco de dados
    public Connection conectarBanco() {

        if (this.getConn() == null) {
            this.setCf(new ConnectionFactory());
            this.setConn(this.getCf().criarConexaoOracle());
        }

        return this.getConn();

    }

    //Verifica se existe estado no banco
    public boolean verificarExisteEstado(String cpf) {

        try {
            //Conectar banco de dados
            this.setConn(this.conectarBanco());

            //SQL
            this.setSql("SELECT COUNT(*) as Total FROM estado WHERE e_estado = ?");

            //Passar parametros
            this.setPstmt(this.getConn().prepareStatement(this.getSql()));
            this.getPstmt().setString(1, cpf);

            //Buscar registros
            this.setRs(this.getPstmt().executeQuery());

            //Resultado
            while (this.getRs().next()) {

                //Total de UF cadastrados
                int total = this.getRs().getInt("Total");

                if (total > 0) {
                    //Fechar conexões
                    this.getPstmt().close();
                    this.setConn(this.getCf().fecharConexaoOracle());

                    //Campo está duplicado
                    return true;
                }
            }
        } catch (SQLException e) {

        }

        return false;
    }

    //Verifica se existe municio
    public boolean verificarExisteMunicipio(String municipio) {

        try {
            //Conectar banco de dados
            this.setConn(this.conectarBanco());

            //SQL
            this.setSql("SELECT * FROM municipio WHERE m_municipio = ?");

            //Passar parametros
            this.setPstmt(this.getConn().prepareStatement(this.getSql()));
            this.getPstmt().setString(1, municipio);

            //Buscar registros
            this.setRs(this.getPstmt().executeQuery());

            //Resultado
            while (this.getRs().next()) {

                //Total de Municipios cadastrados
                int total = this.getRs().getInt("Total");

                if (total > 0) {
                    //Fechar conexões
                    this.getPstmt().close();
                    this.setConn(this.getCf().fecharConexaoOracle());

                    //Campo está duplicado
                    return true;
                }
            }
        } catch (SQLException e) {

        }

        return false;
    }

    //Verifica se existe período dos dados
    public boolean verificarExistePeriodoDados(String eleicao) {

        try {
            //Conectar banco de dados
            this.setConn(this.conectarBanco());

            //SQL
            this.setSql("SELECT el_id FROM eleicao WHERE el_ano = ?");

            //Passar parametros
            this.setPstmt(this.getConn().prepareStatement(this.getSql()));
            this.getPstmt().setString(1, eleicao);

            //Buscar registros
            this.setRs(this.getPstmt().executeQuery());

            //Resultado
            while (this.getRs().next()) {

                //Pega referencia
                eleicao = this.getRs().getString("el_id");
                if (eleicao == "") {

                    //Fechar conexões
                    this.getPstmt().close();
                    this.setConn(this.getCf().fecharConexaoOracle());

                    //Retorna id eleicao
                    return true;
                }
            }
        } catch (SQLException e) {

        }

        return false;
    }

    public boolean verificarExisteFaixaEtaria(String faixa) {

        try {
            //Conectar banco de dados
            this.setConn(this.conectarBanco());

            //SQL
            this.setSql("SELECT p_faixa_etaria FROM perfil_eleitor WHERE el_ano = ?");

            //Passar parametros
            this.setPstmt(this.getConn().prepareStatement(this.getSql()));
            this.getPstmt().setString(1, faixa);

            //Buscar registros
            this.setRs(this.getPstmt().executeQuery());

            //Resultado
            while (this.getRs().next()) {

                //Pega referencia
                faixa = this.getRs().getString("el_id");
                if (faixa == "") {

                    //Fechar conexões
                    this.getPstmt().close();
                    this.setConn(this.getCf().fecharConexaoOracle());

                    //Retorna id eleicao
                    return true;
                }
            }
        } catch (SQLException e) {

        }

        return false;
    }

    public String getReferencia(String tabela, String coluna, String parametro) {
        String resultado = "";
        try {
            //Conectar banco de dados
            this.setConn(this.conectarBanco());

            //SQL
            this.setSql("SELECT * FROM ? WHERE ? = ?");

            //Passar parametros
            this.setPstmt(this.getConn().prepareStatement(this.getSql()));
            this.getPstmt().setString(1, tabela);
            this.getPstmt().setString(2, coluna);
            this.getPstmt().setString(3, parametro);

            //Buscar registros
            this.setRs(this.getPstmt().executeQuery());

            //Resultado
            while (this.getRs().next()) {

                //Pega referencia
                resultado = this.getRs().getString(1);
                if ("".equals(resultado)) {

                    //Fechar conexões
                    this.getPstmt().close();
                    this.setConn(this.getCf().fecharConexaoOracle());

                }
            }
        } catch (SQLException e) {

        }
        return resultado;
    }

    public boolean gravarEleitorBD(DadosEleitor _eleitor, String tabela, String coluna) {

        return false;
    }
    
    public boolean referenciarDado(String tabela, String coluna, String ref) {

        return false;
    }

    public ResultSet selecionarEleitoradoBD() {

        return null;

    }

    public void fecharConexaoOracle() {
        this.setConn(this.cf.fecharConexaoOracle());
    }
}
