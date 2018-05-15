package modelo.dominio;

/**
 *
 * @author Jefferson
 */
public class Usuario {
    
    /*###################################
              ATRIBUTOS DA CLASSE
      ###################################*/
    
    private int codigoUsuario;
    
    private String nomeUsuario;
    private String loginUsuario;
    private String senhaUsuario;
    private String cpf;
            String nascimento;
            String sexo;
            String data_criaçao;
            String email;
                   
    
    /*###################################
              CONSTRUTOR DA CLASSE
      ###################################*/
    
    public Usuario(){
        
    }
    
    public Usuario(int _codigoUsuario, String _nomeUsuario) {
        this.setCodigoUsuario(_codigoUsuario);
        this.setNomeUsuario(_nomeUsuario);
    }

    public Usuario(int codigoUsuario, String nomeUsuario, String loginUsuario, String senhaUsuario, String cpf, String nascimento, String sexo, String data_criaçao, String email) {
        this.codigoUsuario = codigoUsuario;
        this.nomeUsuario = nomeUsuario;
        this.loginUsuario = loginUsuario;
        this.senhaUsuario = senhaUsuario;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.data_criaçao = data_criaçao;
        this.email = email;
    }
    
    /*###################################
               MÉTODOS DA CLASSE
      ###################################*/
    
    public int getCodigoUsuario() {
        return this.codigoUsuario;
    }

    public void setCodigoUsuario(int _codigoUsuario) {
        this.codigoUsuario = _codigoUsuario;
    }

    public String getNomeUsuario() {
        return this.nomeUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNascimento() {
        return nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public String getData_criaçao() {
        return data_criaçao;
    }

    public String getEmail() {
        return email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setData_criaçao(String data_criaçao) {
        this.data_criaçao = data_criaçao;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setNomeUsuario(String _nomeUsuario) {
        this.nomeUsuario = _nomeUsuario;
    }
    
    public String getLoginUsuario() {
        return this.loginUsuario;
    }

    public void setLoginUsuario(String _loginUsuario) {
        this.loginUsuario = _loginUsuario;
    }
    
    public String getSenhaUsuario() {
        return this.senhaUsuario;
    }

    public void setSenhaUsuario(String _senhaUsuario) {
        this.senhaUsuario = _senhaUsuario;
    }
    
}
