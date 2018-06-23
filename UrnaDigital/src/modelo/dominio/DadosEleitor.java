package modelo.dominio;

/**
 * Objeto Eleitorado
 * @author AC/DC
 */
public class DadosEleitor {
        
    /*###################################
              ATRIBUTOS DA CLASSE
    ###################################*/
    
    private String sexo;
            String faixa_etaria;
            String total;
            String municipio;
            String uf;
            String periodo;

    /*###################################
            CONSTRUTORES DA CLASSE
      ###################################*/
            
    public DadosEleitor(String periodo, String uf, String municipio, String sexo, String faixa_etaria, String total) {
        this.sexo = sexo.replaceAll("\"", "");
        this.faixa_etaria = faixa_etaria.replaceAll("\"", "");
        this.total = total.replaceAll("\"", "");
        this.municipio = municipio.replaceAll("\"", "");
        this.uf = uf.replaceAll("\"", "");
        this.periodo = periodo.replaceAll("\"", "");
    }

    /*###################################
               MÉTODOS DA CLASSE
      ###################################*/  
    
    public String getSexo() {
        return sexo;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getUf() {
        return uf;
    }

    public String getPeriodo() {
        return periodo;
    }
    
    public String getFaixa_etaria() {
        return faixa_etaria;
    }

    public String getTotal() {
        return total;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    
    public void setFaixa_etaria(String faixa_etaria) {
        this.faixa_etaria = faixa_etaria;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
