package controle;

import modelo.dao.LoginDAO;

public class LoginC {
    
    /*###################################
              ATRIBUTOS DA CLASSE
      ###################################*/
    
    private final LoginDAO loginDao;

    /*###################################
              CONSTRUTOR DA CLASSE
      ###################################*/
    
    public LoginC() {
        
       this.loginDao = new LoginDAO();
        
    }
    
    /*###################################
               MÉTODOS DA CLASSE
      ###################################*/
    
    public boolean autenticarUsuario(String l, String s){
        
        if (!"".equals(l) || !"".equals(s)){
            return this.loginDao.autenticarUsuario(l, s);
        }
       
        return false;
        
    }
    
}
