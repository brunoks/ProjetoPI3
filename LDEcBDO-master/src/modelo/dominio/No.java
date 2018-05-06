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

    public No(String ano, String turno,String descE,String uf,String municipio,String codigoC,String cargo,String nome,
                   String cpf,String siglaP,String partido,String composicaoLegenda,
                   String nasc,String sexo) {
        
        this.setObjeto2(new DadosCandidato(ano,turno,descE,uf,municipio,codigoC,cargo,nome,cpf,siglaP,partido,composicaoLegenda,nasc,sexo));
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
