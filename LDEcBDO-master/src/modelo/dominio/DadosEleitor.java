/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dominio;

import controle.DadosC;

/**
 *
 * @author Bruno
 */
public class DadosEleitor {
        
    //perfil eleitorado
    private String sexo;
            String faixa_etaria;
            String total;
            String municipio;
            String uf;
            String periodo;

    public DadosEleitor(String periodo, String uf, String municipio, String sexo, String faixa_etaria, String total) {
        this.sexo = sexo;
        this.faixa_etaria = faixa_etaria;
        this.total = total;
        this.municipio = municipio;
        this.uf = uf;
        this.periodo = periodo;
    }
            
    public DadosEleitor(){
    
    }

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
