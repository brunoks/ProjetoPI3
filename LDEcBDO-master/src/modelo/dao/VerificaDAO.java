package modelo.dao;

import controle.DadosC;
import modelo.dao.conexao.ConnectionFactory;
import modelo.dominio.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * Tratamento das Consultas Gerais
 * @author AC/DC
 */
public class VerificaDAO {
    
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
    public VerificaDAO(){
        this.setConn(null); // Conexão será null incialmente
        
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
    
    //Verificar existencia de alguma informação no banco
    public boolean verificaSeExiste(String tabela, String coluna, String filtro) {
        
        try{
            //Conectar banco de dados
            this.setConn(this.conectarBanco());
            
            //SQL
            this.setSql("SELECT COUNT(*) as Total FROM ? WHERE ? = ?");
            
            //Passar parametros
            this.setPstmt(this.getConn().prepareStatement(this.getSql()));
            this.getPstmt().setString(1, tabela);
            this.getPstmt().setString(2, coluna);
            this.getPstmt().setString(3, filtro);
            
            //Buscar registros
            this.setRs(this.getPstmt().executeQuery());
            
            //Resultado
            while(this.getRs().next()){
                
                //Total de Pessoas com CPF
                int total = this.getRs().getInt("Total");
                
                if(total > 0){
                    //Fechar conexões
                    this.getPstmt().close();
                    this.setConn(this.getCf().fecharConexaoOracle());
                    
                    //Campo está duplicado
                    return true;
                }
            }
        } catch(SQLException e){
            
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
        
    // Fechando a conexão com o banco de dados Oracle
    public void fecharConexaoOracle(){
        
        this.setConn(this.cf.fecharConexaoOracle());

    }
        
}
