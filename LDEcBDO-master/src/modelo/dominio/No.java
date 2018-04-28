package modelo.dominio;

public class No {
    
    /*###################################
              ATRIBUTOS DA CLASSE
      ###################################*/
    private No ponteiroAnterior;
    private Usuario objeto;
    private No proximoPonteiro;
    private DadosCandidato objeto2;

    /*###################################
            CONSTRUTORES DA CLASSE
      ###################################*/
    
    public No(){
        
    }
    
    public No(int c, String n) {
        this.setObjeto(new Usuario(c,n));
    }

    public No(int id, int cpf, String nome, String tse, String nasc, String sexo) {
        this.setObjeto2(new DadosCandidato(id,cpf,nome,tse,nasc,sexo));
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

    public DadosCandidato getObjeto2() {
        return objeto2;
    }

    public void setObjeto2(DadosCandidato objeto2) {
        this.objeto2 = objeto2;
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
