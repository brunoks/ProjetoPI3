package modelo.dao;

import modelo.dao.conexao.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Tratamento das Consultas Gerais
 *
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
    public VerificaDAO() {
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
    public Connection conectarBanco() {

        // Verificando se a há conexão com o BD Oracle
        // Caso não tenha, cria uma nova conexão.
        if (this.getConn() == null) {
            this.setCf(new ConnectionFactory());
            this.setConn(this.getCf().criarConexaoOracle());
        }
        return this.getConn();

    }

    /**
     * Verificar se informação da tabela está duplicada
     *
     * @param tabela
     * @param coluna
     * @param filtro
     * @return
     */
    public boolean verificaSeExiste(String tabela, String coluna, String filtro) {

        try {
            //Conectar banco de dados
            this.setConn(this.conectarBanco());

            //SQL
            this.setSql("SELECT COUNT(*) as Total FROM " + tabela + " WHERE " + coluna + " = '" + filtro + "'");

            //Passar parametros
            this.setPstmt(this.getConn().prepareStatement(this.getSql()));

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

    /**
     * Buscar ID de Referência nas Tabelas
     *
     * @param tabela
     * @param coluna
     * @param parametro
     * @return
     */
    public String getReferencia(String tabela, String coluna, String parametro) {
        String resultado = "";
        try {
            //Conectar banco de dados
            this.setConn(this.conectarBanco());

            //SQL
            this.setSql("SELECT * FROM " + tabela + " WHERE " + coluna + " = '" + parametro + "'");

            //Passar parametros
            this.setPstmt(this.getConn().prepareStatement(this.getSql()));

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

    /**
     * Cadastrar Eleicao
     *
     * @param ano
     * @return
     */
    public boolean setNovaEleicao(String ano) {

        this.setSql("INSERT INTO eleicao (el_ano,el_tipo) VALUES(?,?)");

        try {

            // Prepara a instrução SQL e monsta a estrutura dos parâmetros.
            this.setPstmt(this.getConn().prepareStatement(this.getSql()));

            this.getPstmt().setInt(1, Integer.parseInt(ano));
            this.getPstmt().setString(2, "M");

            this.getPstmt().execute();
            this.getPstmt().close();

            return true;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }

    /**
     * Cadastrar Estado
     *
     * @param uf
     * @return
     */
    public boolean setNovoEstado(String uf) {

        this.setSql("INSERT INTO estado (e_estado,e_uf) VALUES(?,?)");

        try {

            // Prepara a instrução SQL e monsta a estrutura dos parâmetros.
            this.setPstmt(this.getConn().prepareStatement(this.getSql()));

            this.getPstmt().setString(1, this.getNomeEstado(uf));
            this.getPstmt().setString(2, uf);

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

    /**
     * Cadastrar Municipio
     *
     * @param estadoID
     * @param municipio
     * @return
     */
    public boolean setNovoMunicipio(String estadoID, String municipio) {

        this.setSql("INSERT INTO municipio (e_id,m_municipio) VALUES(?,?)");

        try {

            // Prepara a instrução SQL e monsta a estrutura dos parâmetros.
            this.setPstmt(this.getConn().prepareStatement(this.getSql()));

            this.getPstmt().setString(1, estadoID);
            this.getPstmt().setString(2, municipio);

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

    /**
     * Cadastrar Cargo
     *
     * @param cargo
     * @return
     */
    public boolean setNovoCargo(String cargo) {

        this.setSql("INSERT INTO cargo (cr_cargo) VALUES(?)");

        try {

            // Prepara a instrução SQL e monsta a estrutura dos parâmetros.
            this.setPstmt(this.getConn().prepareStatement(this.getSql()));

            this.getPstmt().setString(1, cargo);

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

    /**
     * Cadastrar Cargo
     *
     * @param cargo
     * @return
     */
    public boolean setNovoPartido(String partido, String sigla) {

        this.setSql("INSERT INTO partido (pr_partido, pr_sigla) VALUES(?,?)");

        try {

            // Prepara a instrução SQL e monsta a estrutura dos parâmetros.
            this.setPstmt(this.getConn().prepareStatement(this.getSql()));

            this.getPstmt().setString(1, partido);
            this.getPstmt().setString(2, sigla);

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

    /**
     * Nome do Estado
     *
     * @param uf
     * @return
     */
    public String getNomeEstado(String uf) {
        String retorno = "";

        switch (uf) {
            case "AC":
                retorno = "Acre";
                break;
            case "AL":
                retorno = "Alagoas";
                break;
            case "AP":
                retorno = "Amapá";
                break;
            case "AM":
                retorno = "Acre";
                break;
            case "BA":
                retorno = "Bahia";
                break;
            case "CE":
                retorno = "Ceará";
                break;
            case "DF":
                retorno = "Distrito Federal";
                break;
            case "ES":
                retorno = "Espírito Santo";
                break;
            case "GO":
                retorno = "Goiás";
                break;
            case "MA":
                retorno = "Maranhão";
                break;
            case "MT":
                retorno = "Mato Grosso";
                break;
            case "MS":
                retorno = "Mato Grosso do Sul";
                break;
            case "MG":
                retorno = "Minas Gerais";
                break;
            case "PA":
                retorno = "Pará";
                break;
            case "PB":
                retorno = "Paraíba";
                break;
            case "PR":
                retorno = "Paraná";
                break;
            case "PE":
                retorno = "Pernambuco";
                break;
            case "PI":
                retorno = "Piauí";
                break;
            case "RJ":
                retorno = "Rio de Janeiro";
                break;
            case "RN":
                retorno = "Rio Grande no Norte";
                break;
            case "RRS":
                retorno = "Rio Grande do Sul";
                break;
            case "RO":
                retorno = "Rondônia";
                break;
            case "RR":
                retorno = "Roraima";
                break;
            case "SC":
                retorno = "Santa Catarina";
                break;
            case "SP":
                retorno = "São Paulo";
                break;
            case "SE":
                retorno = "Sergipe";
                break;
            case "TO":
                retorno = "Tocantins";
                break;
        }

        return retorno;
    }

    // Fechando a conexão com o banco de dados Oracle
    public void fecharConexaoOracle() {

        this.setConn(this.cf.fecharConexaoOracle());

    }

}
