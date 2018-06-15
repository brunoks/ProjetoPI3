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
    private No proximoPonteiro;
    //Objeto com os dados do candidato
    private DadosCandidato objctDados;
    private DadosEleitor objectEleitorado;

    /*###################################
            CONSTRUTORES DA CLASSE
      ###################################*/
    
    public No(){
        
    }
    
    public No(String periodo, String uf, String municipio, String sexo, String faixa_etaria, String total){
        this.setObjctEleitorado(new DadosEleitor(periodo, uf, municipio, sexo, faixa_etaria, total));
    }

    public No(String ano, String turno,String descE,String uf,String municipio,String codigoC,String cargo,String nome,
                   String cpf,String siglaP,String partido,String composicaoLegenda,
                   String nasc,String sexo) {
        
        this.setObjctDados(new DadosCandidato(ano,turno,descE,uf,municipio,codigoC,cargo,nome,cpf,siglaP,partido,composicaoLegenda,nasc,sexo));
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


    public void setProximoPonteiro(No proximoPonteiro) {
        this.proximoPonteiro = proximoPonteiro;
    }
}
