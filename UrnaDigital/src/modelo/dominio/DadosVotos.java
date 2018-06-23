/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dominio;

/**
 *
 * @author ALERTRACK
 */
public class DadosVotos {
    /*###################################
              ATRIBUTOS DA CLASSE
      ###################################*/

    

    private String cargo;
    private String municipio;
    

    private String estado;
    private String candidato;
    private String eleicao;
    private String partido;
    private String sigla_partido;
    private String total;

    
    
    /*###################################
              CONSTRUTOR DA CLASSE
      ###################################*/
                        
    public DadosVotos(String eleicao,String estado,String municipio,String candidato,String sigla_p,String id_partido,String total, String cargo) {
        this.cargo = cargo.replaceAll("\"", "");
        this.municipio = municipio.replaceAll("\"", "");
        this.estado = estado.replaceAll("\"", "");
        this.candidato = candidato.replaceAll("\"", "");
        this.eleicao = eleicao.replaceAll("\"", "");
        this.partido = id_partido.replaceAll("\"", "");
        this.total = total.replaceAll("\"", "");
        this.sigla_partido = sigla_p.replaceAll("\"", "");
    }
    
    public DadosVotos(){
    
    }
    
    /*###################################
               MÉTODOS DA CLASSE
      ###################################*/

    public void setSigla_partido(String sigla_partido) {
        this.sigla_partido = sigla_partido;
    }

    public String getSigla_partido() {
        return sigla_partido;
    }

    public String getCargo() {
        return cargo;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getEstado() {
        return estado;
    }

    public String getCandidato() {
        return candidato;
    }

    public String getEleicao() {
        return eleicao;
    }

    public String getPartido() {
        return partido;
    }

    public String getTotal() {
        return total;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCandidato(String candidato) {
        this.candidato = candidato;
    }

    public void setEleicao(String eleicao) {
        this.eleicao = eleicao;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
    
}
