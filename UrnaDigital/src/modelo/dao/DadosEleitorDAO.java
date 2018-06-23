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

    public boolean gravarEleitorBD(DadosEleitor _eleitor, String eleicaoID, String estadoID, String municipioID) {

        try {
            this.setConn(this.conectarBanco());
            this.setSql("INSERT INTO perfil_eleitor(m_id,e_id,el_id,p_sexo,p_faixa_etaria,p_total) VALUES(?,?,?,?,?,?)");

            // Prepara a instrução SQL e monsta a estrutura dos parâmetros.
            this.setPstmt(this.getConn().prepareStatement(this.getSql()));

            this.getPstmt().setString(1, municipioID);
            this.getPstmt().setString(2, estadoID);
            this.getPstmt().setString(3, eleicaoID);
            this.getPstmt().setString(4, (_eleitor.getSexo() == "Feminino") ? "F" : "M");
            this.getPstmt().setString(5, _eleitor.getFaixa_etaria());
            this.getPstmt().setString(6, _eleitor.getTotal());

            this.getPstmt().execute();
            this.getPstmt().close();

            this.fecharConexaoOracle();
            return true;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }

    public ResultSet getResultadoEstadoFiltro() {
        try {
            this.setConn(this.conectarBanco());

            // Definindo a string sql
            this.setSql("SELECT p_total as total, E.e_uf as uf,PE.p_sexo as sexo,PE.p_faixa_etaria as faixa FROM perfil_eleitor PE INNER JOIN estado E ON E.e_id = PE.e_id");

            // Prepara a instrução SQL e monsta a estrutura dos parâmetros.
            this.setPstmt(this.getConn().prepareStatement(this.getSql()));
            this.setRs(this.getPstmt().executeQuery());
            return this.getRs();

        } catch (SQLException e) {

        }

        return null;
    }

    public void fecharConexaoOracle() {
        this.setConn(this.cf.fecharConexaoOracle());
    }
}
