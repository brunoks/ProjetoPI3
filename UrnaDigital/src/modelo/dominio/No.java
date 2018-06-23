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
    private DadosVotos objectVotos;

    /*###################################
            CONSTRUTORES DA CLASSE
      ###################################*/
    
    public No(){
        
    }
    
    public No(String periodo, String uf, String municipio, String sexo, String faixa_etaria, String total){
        this.setObjctEleitorado(new DadosEleitor(periodo, uf, municipio, sexo, faixa_etaria, total));
    }

    public No(String ano, String turno,String descE,String uf,String tse,String municipio,String codigoC,String cargo,String nome,
                   String cpf,String siglaP,String partido,String composicaoLegenda,
                   String nasc,String sexo) {
        
        this.setObjctDados(new DadosCandidato(ano,turno,descE,uf,tse,municipio,codigoC,cargo,nome,cpf,siglaP,partido,composicaoLegenda,nasc,sexo));
    }

    public No(String eleicao, String municipio, String estado, String candidato, String sigla_p, String id_partido, String total,String cargo) {
        this.setObjectVotos(new DadosVotos(eleicao,estado,municipio,candidato,sigla_p,id_partido,total,cargo));
    }
    
    /*###################################
               MÉTODOS DA CLASSE
      ###################################*/  
    

    public DadosVotos getObjectVotos() {
        return this.objectVotos;
    }
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
    
        public void setObjectVotos(DadosVotos objectVotos) {
        this.objectVotos = objectVotos;
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
