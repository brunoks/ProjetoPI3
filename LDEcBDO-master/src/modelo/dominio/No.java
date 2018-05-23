package modelo.dominio;

/**
 * Nós das Listas
 * @author AC/DC
 */
public class No {
    
    /*###################################
              ATRIBUTOS DA CLASSE
      ###################################*/
    private No ponteiroAnterior;
    private Usuario objeto;
    private No proximoPonteiro;
    //Objeto com os dados do candidato
    private DadosCandidato objctDados;
    private DadosEleitor objectEleitorado;

    /*###################################
            CONSTRUTORES DA CLASSE
      ###################################*/
    
    public No(){
        
    }
    
    public No(int c, String n) {
        this.setObjeto(new Usuario(c,n));
    }
    
    public No(String periodo, String uf, String municipio, String sexo, String faixa_etaria, String total){
        this.setObjctEleitorado(new DadosEleitor(periodo, uf, municipio, sexo, faixa_etaria, total));
    }

    public No(String ano, String turno,String descE,String uf,String municipio,String codigoC,String cargo,String nome,
                   String cpf,String siglaP,String partido,String composicaoLegenda,
                   String nasc,String sexo) {
        
        this.setObjctDados(new DadosCandidato(ano,turno,descE,uf,municipio,codigoC,cargo,nome,cpf,siglaP,partido,composicaoLegenda,nasc,sexo));
    }
    
    public No(int c, String n, String l, String s, String cpf, String nascimento, String sexo, String data_criacao, String email) {
        this.setObjeto(new Usuario(c,n,l,s,cpf,nascimento,sexo,data_criacao, email));
    }
    
    /*###################################
               MÉTODOS DA CLASSE
      ###################################*/  
    
    public No getPonteiroAnterior() {
        return this.ponteiroAnterior;
    }

    public DadosEleitor getObjctEleitorado() {
        return this.objectEleitorado;
    }

    public DadosCandidato getObjctDados() {
        return this.objctDados;
    }
    
    public Usuario getObjeto() {
        return this.objeto;
    }
    
    public No getProximoPonteiro() {
        return this.proximoPonteiro;
    }

    public void setObjctDados(DadosCandidato dados) {
        this.objctDados = dados;
    }
    
    public void setPonteiroAnterior(No ponteiroAnterior) {
        this.ponteiroAnterior = ponteiroAnterior;
    }

    public void setObjctEleitorado(DadosEleitor eleitorado) {
        this.objectEleitorado = eleitorado;
    }

    public void setObjeto(Usuario objeto) {
        this.objeto = objeto;
    }


    public void setProximoPonteiro(No proximoPonteiro) {
        this.proximoPonteiro = proximoPonteiro;
    }
}
