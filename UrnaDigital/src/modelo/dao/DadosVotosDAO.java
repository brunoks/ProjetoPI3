package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.dao.conexao.ConnectionFactory;
import modelo.dominio.DadosCandidato;
import modelo.dominio.DadosVotos;

/**
 * Tratamentos das consultas vinculadas aos resultados de votos
 * @author AC/DC
 */
public class DadosVotosDAO {
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
    public DadosVotosDAO(){
        
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
    
    // Método para gravar todos os usuários presentes na lista
    public boolean gravarVotosBD(DadosVotos _dados, String cr_id, String id_m, String e_id, String c_id, String el_id, String pr_id) {
  
        // Definindo a string sql
        this.setSql("INSERT INTO resultado_votos (cr_id,m_id,e_id,c_id,el_id,pr_id,p_total) VALUES (?, ?, ?, ?, ?, ?, ?)");
        
        try {
            
            // Prepara a instrução SQL e monsta a estrutura dos parâmetros.
            this.setPstmt(this.getConn().prepareStatement(this.getSql()));
            
            // Setando os parâmetros que irão substituir '?'
            //String ano, String turno,String descE,String uf,String municipio,String codigoC,String cargo,String nome,
            //              String cpf,String siglaP,String partido,String composicaoLegenda,
            //             String nasc,String sexo
            
            this.getPstmt().setString(1, cr_id);
            this.getPstmt().setString(2, id_m);
            this.getPstmt().setString(3, e_id);
            this.getPstmt().setString(4, c_id);
            this.getPstmt().setString(5, el_id);
            this.getPstmt().setString(6, pr_id);
            System.out.print(_dados.getTotal());
            this.getPstmt().setString(7, _dados.getTotal());
            
            
            // Executa o comando SQL com os parâmteros.
            this.getPstmt().execute();
            // Encerra o componente 'PrepareStatement'
            this.getPstmt().close();
            
            return true;
 
        }catch(SQLException e) {
            
            e.printStackTrace();
            
        }
 
        return false;
    }

    
    public ResultSet getResultadoEstadoFiltro() {
        
        // Definindo a string sql
        this.setSql("SELECT SUM(p_total),E.e_uf,V.p_sexo,V.p_faixa_etaria FROM resultado_votos V INNER JOIN estado E ON E.e_id = V.e_id GROUP BY E.e_uf");
        
        
        try {
            
            // Prepara a instrução SQL e monsta a estrutura dos parâmetros.
            this.setPstmt(this.getConn().prepareStatement(this.getSql()));
            this.setRs(this.getPstmt().executeQuery());
            
            return this.getRs();
            
        }catch(SQLException e) {
            
            e.printStackTrace();
            
        }
        
        return null;
    }

    
    public void fecharConexaoOracle(){
        this.setConn(this.cf.fecharConexaoOracle());
    }
}
