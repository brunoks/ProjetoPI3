package modelo.dominio;

public class No {
    
    /*###################################
              ATRIBUTOS DA CLASSE
      ###################################*/
    private No ponteiroAnterior;
    private Usuario objeto;
    private No proximoPonteiro;

    /*###################################
            CONSTRUTORES DA CLASSE
      ###################################*/
    
    public No(){
        
    }
    
    public No(int c, String n) {
        this.setObjeto(new Usuario(c,n));
    }
    
    public No(int c, String n, String l, String s) {
        this.setObjeto(new Usuario(c,n,l,s));
    }
    
    /*###################################
               MÉTODOS DA CLASSE
      ###################################*/  
    
    public No getPonteiroAnterior() {
        return this.ponteiroAnterior;
    }

    public void setPonteiroAnterior(No ponteiroAnterior) {
        this.ponteiroAnterior = ponteiroAnterior;
    }

    public Usuario getObjeto() {
        return this.objeto;
    }

    public void setObjeto(Usuario objeto) {
        this.objeto = objeto;
    }

    public No getProximoPonteiro() {
        return this.proximoPonteiro;
    }

    public void setProximoPonteiro(No proximoPonteiro) {
        this.proximoPonteiro = proximoPonteiro;
    }
}
