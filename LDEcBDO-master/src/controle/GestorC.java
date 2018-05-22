package controle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.dao.GestorDAO;
import modelo.dominio.Gestor;

/**
 * Controle de Funções Relacionadas aos Gestores
 *
 * @author AC/DC
 */
public class GestorC {

    /*###################################
              ATRIBUTOS DA CLASSE
      ###################################*/
    private final GestorDAO gestorDAO;

    private Gestor gestorDados;
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
    public GestorC() {
        this.gestorDAO = new GestorDAO();
        this.gestorDados = null;
    }

    /*###################################
               MÉTODOS DA CLASSE
      ###################################*/
    //Verificar se o CPF está duplicado
    public boolean CPFExistente(String cpf) {

        if (!"".equals(cpf)) {
            return this.gestorDAO.verificarExisteCPF(cpf);
        }

        return false;
    }

    //Verificar se nome de usuário está duplicado
    public boolean LoginExistente(String login) {

        if (!"".equals(login)) {
            return this.gestorDAO.verificarExisteLogin(login);
        }

        return false;
    }

    //Criar objeto com caracteristicas do gestor
    public void setDadosGestor(String cpf, String nome, String nascimento, String sexo, String login, String senha, String email, String telefone) {
        this.gestorDados = new Gestor(cpf, nome, nascimento, sexo, login, senha, email, telefone);
    }

    //Cadastrar Novo Gestor
    public boolean setCadastrarGestor() {

        GestorDAO gDAO = new GestorDAO();

        if ((this.conn = gDAO.conectarBanco()) != null) {

            //Salvar dados
            if (!gDAO.gravarUsuariosBD(this.gestorDados)) {
                gDAO.fecharConexaoOracle();
                gDAO = null;

                return false;
            }

            // Fechar conexão
            gDAO.fecharConexaoOracle();
            gDAO = null;

            return true;

        }

        return false;
    }

    //Retorna dados do gestor logado
    public Gestor getSessaoGestor(String login) {

        GestorDAO gDAO = new GestorDAO();

        if ((this.conn = gDAO.conectarBanco()) != null) {

            try {

                // Resgatando os dados do Banco
                this.setRs(gDAO.selecionarUsuarioBD(login));

                // Verificando retorno
                if (this.getRs() != null) {

                    // Salvar objeto
                    while (this.getRs().next()) {
                        this.gestorDados = new Gestor();
                        this.gestorDados.setId(this.getRs().getInt("g_id"));
                        this.gestorDados.setNome(this.getRs().getString("g_nome"));
                        this.gestorDados.setCpf(this.getRs().getString("g_cpf"));
                        this.gestorDados.setNascimento(this.getRs().getString("g_nascimento"));
                        this.gestorDados.setSexo(this.getRs().getString("g_sexo"));
                        this.gestorDados.setLogin(this.getRs().getString("g_login"));
                        this.gestorDados.setSenha(this.getRs().getString("g_senha"));
                        this.gestorDados.setEmail(this.getRs().getString("g_email"));
                        this.gestorDados.setTelefone(this.getRs().getString("g_telefone"));
                    }

                }

            } catch (SQLException e) {

                e.printStackTrace();

            }

        }

        return this.gestorDados;
    }
    
    //Alterar senha
    public boolean setAlterarSenhaGestor(int gestorID, String senha) {

        GestorDAO gDAO = new GestorDAO();

        if ((this.conn = gDAO.conectarBanco()) != null) {

            //Salvar dados
            if (!gDAO.alterarSenhaUsuarioBD(gestorID, senha)) {
                gDAO.fecharConexaoOracle();
                gDAO = null;

                return false;
            }

            // Fechar conexão
            gDAO.fecharConexaoOracle();
            gDAO = null;

            return true;

        }

        return false;
    }
    
    
    
    //Alterar dados de contato da conta
    public boolean setAlterarContatoGestor(int gestorID, String telefone, String email) {

        GestorDAO gDAO = new GestorDAO();

        if ((this.conn = gDAO.conectarBanco()) != null) {

            //Salvar dados
            if (!gDAO.alterarContatoUsuarioBD(gestorID, email, telefone)) {
                gDAO.fecharConexaoOracle();
                gDAO = null;

                return false;
            }

            // Fechar conexão
            gDAO.fecharConexaoOracle();
            gDAO = null;

            return true;

        }

        return false;
    }

}
