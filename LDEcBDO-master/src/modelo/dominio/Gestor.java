package modelo.dominio;

/**
 * Classe Gestor - Usuário do Sistema
 * @author AC/DC
 */
public class Gestor {
    
    /*###################################
    ATRIBUTOS DA CLASSE
    ###################################*/
 
    private int id;
    private String cpf;
    private String nome;
    private String nascimento;
    private char sexo;
    private String login;
    private String senha;
    private String email;
    private String telefone;
    
    public Gestor(){
        
    }
    
    public Gestor(int id, String cpf, String nome, String nascimento, char sexo, String login, String senha, String email, String telefone){
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
