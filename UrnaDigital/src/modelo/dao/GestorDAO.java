package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.dao.conexao.ConnectionFactory;
import modelo.dominio.Gestor;

/**
 * Classe de Tratamento das Consultas SQL vinculadas ao Gestor
 *
 * @author AC/DC
 */
public class GestorDAO {

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
    public GestorDAO() {

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

    //Verificar existencia do CPF vinculado a algum usuário do sistema
    public boolean verificarExisteCPF(String cpf) {

        try {
            //Conectar banco de dados
            this.setConn(this.conectarBanco());

            //SQL
            this.setSql("SELECT COUNT(*) as Total FROM gestor WHERE g_cpf = ?");

            //Passar parametros
            this.setPstmt(this.getConn().prepareStatement(this.getSql()));
            this.getPstmt().setString(1, cpf);

            //Buscar registros
            this.setRs(this.getPstmt().executeQuery());

            //Resultado
            while (this.getRs().next()) {

                //Total de Pessoas com CPF
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

    //Verificar existencia do CPF vinculado a algum usuário do sistema
    public boolean verificarExisteLogin(String login) {

        try {
            //Conectar banco de dados
            this.setConn(this.conectarBanco());

            //SQL
            this.setSql("SELECT COUNT(*) as Total FROM gestor WHERE g_login = ?");

            //Passar parametros
            this.setPstmt(this.getConn().prepareStatement(this.getSql()));
            this.getPstmt().setString(1, login);

            //Buscar registros
            this.setRs(this.getPstmt().executeQuery());

            //Resultado
            while (this.getRs().next()) {

                //Total de Pessoas com CPF
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

    //Gravar dados do usuário no banco de dados
    public boolean gravarUsuariosBD(Gestor _gestor) {

        try {
            this.setConn(this.conectarBanco());
            // Definindo a string sql
            this.setSql("INSERT INTO gestor(g_cpf,g_nome,g_nascimento,g_sexo,g_login,g_senha,g_email,g_telefone) VALUES (?,?,?,?,?,?,?,?)");

            // Substituir parametros por valores
            this.setPstmt(this.getConn().prepareStatement(this.getSql()));

            //Valores
            this.getPstmt().setString(1, (_gestor.getCpf()));
            this.getPstmt().setString(2, (_gestor.getNome()));
            this.getPstmt().setString(3, (_gestor.getNascimento()));
            this.getPstmt().setString(4, (_gestor.getSexo()));
            this.getPstmt().setString(5, (_gestor.getLogin()));
            this.getPstmt().setString(6, (_gestor.getSenha()));
            this.getPstmt().setString(7, (_gestor.getEmail()));
            this.getPstmt().setString(8, (_gestor.getTelefone()));

            // Executa
            this.getPstmt().execute();
            this.getPstmt().close();

            return true;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }

    //Selecionar dados do usuário
    public ResultSet selecionarUsuarioBD(String login) {

        try {

            // Definindo a string sql
            this.setConn(this.conectarBanco());
            this.setSql("SELECT * FROM gestor WHERE g_login = ?");

            // Prepara a instrução SQL e monsta a estrutura dos parâmetros.
            this.setPstmt(this.getConn().prepareStatement(this.getSql()));
            this.getPstmt().setString(1, (login));
            this.setRs(this.getPstmt().executeQuery());

            return this.getRs();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;
    }

    //Altera senha do gestor
    public boolean alterarSenhaUsuarioBD(int gestorID, String senha) {

        try {
            // Definindo a string sql
            this.setConn(this.conectarBanco());
            this.setSql("UPDATE gestor SET g_senha = ?, data_modificado = CURRENT_DATE WHERE g_id = " + gestorID);

            // Prepara a instrução SQL e monsta a estrutura dos parâmetros.
            this.setPstmt(this.getConn().prepareStatement(this.getSql()));
            this.getPstmt().setString(1, senha);

            // Executa o comando SQL com os parâmteros.
            this.getPstmt().execute();
            // Encerra o componente 'PrepareStatement'
            this.getPstmt().close();

            return true;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }

    //Alterar Dados de Contato do gestor
    public boolean alterarContatoUsuarioBD(int gestorID, String email, String telefone) {

        try {
            // Definindo a string sql
            this.setConn(this.conectarBanco());
            this.setSql("UPDATE gestor SET g_email = ?, g_telefone = ?, data_modificado = CURRENT_DATE WHERE g_id = " + gestorID);

            // Prepara a instrução SQL e monsta a estrutura dos parâmetros.
            this.setPstmt(this.getConn().prepareStatement(this.getSql()));

            this.getPstmt().setString(1, email);
            this.getPstmt().setString(2, telefone);

            // Executa o comando SQL com os parâmteros.
            this.getPstmt().execute();
            // Encerra o componente 'PrepareStatement'
            this.getPstmt().close();

            return true;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }

    public void fecharConexaoOracle() {
        this.setConn(this.cf.fecharConexaoOracle());
    }
}
