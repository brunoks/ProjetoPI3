package controle;

import java.sql.Connection;
import java.sql.ResultSet;
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
              CONSTRUTOR DA CLASSE
      ###################################*/
    public GestorC() {
        this.gestorDAO = new GestorDAO();
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

    //Cadastrar Novo Gestoe
    public boolean setCadastrarGestor() {

        GestorDAO gDAO = new GestorDAO();
        
        if((this.conn = gDAO.conectarBanco()) != null){
            
            //Salvar dados
            if(!gDAO.gravarUsuariosBD(this.gestorDados)){
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
