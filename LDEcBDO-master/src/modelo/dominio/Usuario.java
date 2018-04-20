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
    
    /*###################################
              CONSTRUTOR DA CLASSE
      ###################################*/
    
    public Usuario(){
        
    }
    
    public Usuario(int _codigoUsuario, String _nomeUsuario) {
        this.setCodigoUsuario(_codigoUsuario);
        this.setNomeUsuario(_nomeUsuario);
    }
    
    public Usuario(int _codigoUsuario, String _nomeUsuario, String _loginUsuario, String _senhaUsuario) {
        this.setCodigoUsuario(_codigoUsuario);
        this.setNomeUsuario(_nomeUsuario);
        this.setLoginUsuario(_loginUsuario);
        this.setSenhaUsuario(_senhaUsuario);
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
