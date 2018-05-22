package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import modelo.dao.conexao.ConnectionFactory;
import modelo.dominio.DadosEleitorado;

/**
 * Classe de Tratamentos das Consultas vinculadas ao Eleitorado
 * @author ALERTRACK
 */
public class DadosEleitoradoDAO {
    
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
    public DadosEleitoradoDAO(){
        
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
    public Connection conectarBanco(){
       
        if(this.getConn() == null){
            this.setCf(new ConnectionFactory());
            this.setConn(this.getCf().criarConexaoOracle());
        }
            
        return this.getConn();
        
    }
    
    public boolean gravarEleitoradoBD(DadosEleitorado _gestor) {
        
        
 
        return false;
    }
    
    public ResultSet selecionarEleitoradoBD() {
        
        
        
        return null;
        
    }
    
    public boolean alterarEleitoradoBD(DadosEleitorado _gestor, int parametro) {
        
        return false;
    }
    
    public void fecharConexaoOracle(){
        this.setConn(this.cf.fecharConexaoOracle());
    }
}
