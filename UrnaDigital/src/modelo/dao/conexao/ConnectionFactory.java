package modelo.dao.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * Classe de Conexáo com Banco de Dados
 *
 * @author Jefferson
 */
public class ConnectionFactory {

    /*#####################
       Atributos da classe
    #####################*/
    private Connection conn;

    String usuarioBanco;
    String senhaBanco;

    String servidor;
    String porta;
    String sid;
    String url;

    /*######################
       Construtor da classe
      ######################*/
    public ConnectionFactory() {

//        this.setUsuarioBanco("URNADIGITAL");
//        this.setSenhaBanco("urn4dugit4l#");
//        this.setServidor("localhost");
//        this.setPorta("1521");
//        this.setSid("projetopiiii");

        this.setUsuarioBanco("URNADIGITAL");
        this.setSenhaBanco("urn4dugit4l#");
        this.setServidor("localhost");
        this.setPorta("1521");
        this.setSid("projetopiiii");

        this.setUrl();

    }

    /*###################################
           MÉTODOS get e set DA CLASSE
      ###################################*/
    
    // Método para resgatar o estado de conexão com o Oracle
    public Connection getConn() {
        return this.conn;
    }

    // Método para armazenar o estado de conexão com o Oracle
    public void setConn(Connection _conn) {
        this.conn = _conn;
    }

    // Método para resgatar o usuário de acesso ao banco de dados Oracle
    public String getUsuarioBanco() {
        return this.usuarioBanco;
    }

    // Método para armazenar o usuário de acesso ao banco de dados Oracle
    public void setUsuarioBanco(String _usuarioBanco) {
        this.usuarioBanco = _usuarioBanco;
    }

    // Método para resgatar a senha de acesso ao banco de dados Oracle
    public String getSenhaBanco() {
        return this.senhaBanco;
    }

    // Método para armazenar a senha de acesso ao banco de dados Oracle
    public void setSenhaBanco(String _senhaBanco) {
        this.senhaBanco = _senhaBanco;
    }

    // Método para resgatar o endereço do servidor de acesso ao banco de dados Oracle
    public String getServidor() {
        return this.servidor;
    }

    // Método para armazenar o endereço do servidor de acesso ao banco de dados Oracle
    public void setServidor(String _servidor) {
        this.servidor = _servidor;
    }

    // Método para resgatar o número da porta para conexão ao banco de dados Oracle
    public String getPorta() {
        return this.porta;
    }

    // Método para armazenar o número da porta para conexão ao banco de dados Oracle
    public void setPorta(String _porta) {
        this.porta = _porta;
    }

    // Método para resgatar o SID global ou local para o banco de dados Oracle
    public String getSid() {
        return this.sid;
    }

    // Método para armazenar o SID global ou local para o banco de dados Oracle
    public void setSid(String _sid) {
        this.sid = _sid;
    }

    // Método para resgatar a URL de conexão ao banco de dados Oracle
    public String getUrl() {
        return this.url;
    }

    // Método para armazenar a URL de conexão ao banco de dados Oracle
    public void setUrl() {
        this.url = "jdbc:oracle:thin:@"
                + this.getServidor() + ":"
                + this.getPorta() + ":" + this.getSid();
    }

    /*###################################
                 Outros métodos
      ###################################*/
    public Connection criarConexaoOracle() {
        return this.conn = this.criarDriverManager();

    }

    // Método para criar o Driver de conexão ao banco de dados Oracle
    private Connection criarDriverManager() {

        try {

            // Definindo a classe que será utilizada para acesso ao banco de dados.
            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            JOptionPane.showMessageDialog(null, "Classe não encontrada!");
            System.exit(1);
        }

        try {

            // Retorna driver pronto para login.
            return DriverManager.getConnection(this.getUrl(), this.getUsuarioBanco(), this.getSenhaBanco());

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());

        }

        return null;
    }
    
    // Fechando a conexão com o banco de dados Oracle
    public Connection fecharConexaoOracle() {

        this.setConn(null);
        return this.getConn();

    }

}
