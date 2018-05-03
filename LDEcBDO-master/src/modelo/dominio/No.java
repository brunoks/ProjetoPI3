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

    public No(String d1,String d2,String d3,String d4,String d5,String d6,String d7,String d8,String d9,String d10,String d11,String d12,String d13
            ,String d14,String d15,String d16,String d17,String d18,String d19,String d20,String d21,String d22,String d23,String d24,String d25,String d26
            ,String d27,String d28,String d29,String d30,String d31,String d32,String d33,String d34,String d35,String d36,String d37,String d38
            ,String d39,String d40,String d41,String d42,String d43,String d44,String d45,String d46) {
        this.setObjeto2(new DadosCandidato(d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,
                        d12,d13,d14,d15,d16,d17,d18,d19,d20,d21,d22,
                        d23,d24,d25,d26,d27,d28,d29,d30,d31,d32,d33,
                        d34,d35,d36,d37,d38,d39,d40,d41,d42,d43,d44,d45,d46));
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
