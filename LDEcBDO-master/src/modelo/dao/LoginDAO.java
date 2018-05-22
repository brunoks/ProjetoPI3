package modelo.dao;

import modelo.dao.conexao.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe de Login
 * @author AC/DC
 */
public class LoginDAO {
    
    /*###################################
              ATRIBUTOS DA CLASSE
      ###################################*/
    
    private ConnectionFactory cf;
    
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    
    private String sql;
    
    private String loginBD;
    private String senhaBD;
    
    /*###################################
              CONSTRUTOR DA CLASSE
      ###################################*/
    
    public LoginDAO(){
        
        this.setConn(null);
        this.setPstmt(null);
        this.setRs(null);
        
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
    
    // Método para conectar ao banco de dados Oracle
    public Connection conectarBanco(){
        
        // Verificando se a há conexão com o BD Oracle
        // Caso não tenha, cria uma nova conexão.
        if(this.getConn() == null){
            this.setCf(new ConnectionFactory());
            this.setConn(this.getCf().criarConexaoOracle());
        }
            
        return this.getConn();
        
    }
    
    // Método público para autenticar o usuário.
    public boolean autenticarUsuario(String l, String s){
        
        // Acessando o método privado para autenticar o usuário.
        return this.autenticarUsuarioP(l, s);
        
    }
    
    // Método privado para autenticar o usuário.
    private boolean autenticarUsuarioP(String l, String s){
        
        try{
            
            // Estabelecendo conexão ao Oracle
            this.setConn(this.conectarBanco());
            
            // Cláusula SQL
            this.setSql("SELECT * FROM gestor WHERE g_login=? AND g_senha=?");
            
            // Gravando a consulta SQL
            this.setPstmt(this.getConn().prepareStatement(this.getSql()));
            
            // Preparando os dados para substituir '?' evitando SQL Injection
            this.getPstmt().setString(1, l);
            this.getPstmt().setString(2, s);
            
            // Busca todos os registros e os armazena em 'rs'.
            this.setRs(this.getPstmt().executeQuery());
            
            // Percorrendo o resultado
            while(this.getRs().next()){
                
                // Buscando os valores presentes no BD Oracle.
                this.loginBD = this.getRs().getString("g_login");
                this.senhaBD = this.getRs().getString("g_senha");
                
                // Comparando os dados retornados com os dados passados como parâmetros pelo método.
                // Se forem os mesmos dados, usuário autenticado
                if(l.equals(this.loginBD) && s.equals(this.senhaBD)){
                    
                    // Fechando o PreparedStatement
                    this.getPstmt().close();
                    
                    // Fechando a conexão ao banco de dados
                    this.setConn(this.getCf().fecharConexaoOracle());
                    
                    // Retornando verdadeiro
                    return true;
                
                }
            
            }
            
        }catch(SQLException e){
            
            return false;
            
        }
        
        return false;
        
    }
    
}
