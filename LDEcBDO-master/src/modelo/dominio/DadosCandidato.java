package modelo.dominio;

/**
 *
 * @author Jefferson
 */
public class DadosCandidato {
    
    /*###################################
              ATRIBUTOS DA CLASSE
      ###################################*/
    
    //tabela cargo
    private String cargo;
    private String codigoC;
    
    //tabela candidato
    private String cpf;
    private String nome;
    private String tse_o;
    private String nasc;
    private String sexo;
    
    //tabela partido
    private String partido;
    private String siglaP;
    private String composicaoLegenda;
    
    //tabela eleição
    private String ano;
    private String tipoE;
    private String turno;
    private String descE;
    
    //tabela municipio
    private String municipio;
    
    //tabela resultado votos
    private String total;
    
    //tabela estado
    private String estado;
    private String uf;
    
    //perfil eleitorado
    private String sexoE;
    private String faixa_etaria;
    private String totalE;
    

    /*d1,d2,ano3, turno4,desc,uf6,d7,municio8,cdcargo9,cargo10,nome11,d12, d13,
                   cpf14,d15,d16,d17,d18,siglaP19,nomeP20,d21,d22,composicaoLegenda23,
                   d24,d25,d26,nasc27,d28,d29,d30,sexo31,d32,d33,d34,d35,d36,d37,d38,
                   d39,d40,d41,d42,d43,d44,d45,d46;
    */
    private String d1,d2,d7,d12, d13,d15,d16,d17,d18,d21,d22,
                   d24,d25,d26,d28,d29,d30,d32,d33,d34,d35,d36,
                   d37,d38,d39,d40,d41,d42,d43,d44,d45,d46;
    
    
    /*###################################
              CONSTRUTOR DA CLASSE
      ###################################*/

    public DadosCandidato(String d1, String d2,String ano, String turno,String descE,String uf,String d7,String municipio,String codigoC,String cargo,String nome,String d12,String d13,
                   String cpf,String d15,String d16,String d17,String d18,String siglaP,String partido,String d21,String d22,String composicaoLegenda,
                   String d24,String d25,String d26,String nasc,String d28,String d29,String d30,String sexo,String d32,String d33,String d34,String d35,String d36,String d37,
                   String d38, String d39, String d40, String d41, String d42, String d43, String d44, String d45, String d46) {
        this.cargo = cargo;
        this.codigoC = codigoC;
        this.cpf = cpf;
        this.nome = nome;
        this.nasc = nasc;
        this.sexo = sexo;
        this.partido = partido;
        this.siglaP = siglaP;
        this.composicaoLegenda = composicaoLegenda;
        this.ano = ano;
        this.tipoE = tipoE;
        this.turno = turno;
        this.descE = descE;
        this.municipio = municipio;
        this.uf = uf;
        this.d1 = d1;
        this.d2 = d2;
        this.d7 = d7;
        this.d12 = d12;
        this.d13 = d13;
        this.d15 = d15;
        this.d16 = d16;
        this.d17 = d17;
        this.d18 = d18;
        this.d21 = d21;
        this.d22 = d22;
        this.d24 = d24;
        this.d25 = d25;
        this.d26 = d26;
        this.d28 = d28;
        this.d29 = d29;
        this.d30 = d30;
        this.d32 = d32;
        this.d33 = d33;
        this.d34 = d34;
        this.d35 = d35;
        this.d36 = d36;
        this.d37 = d37;
        this.d38 = d38;
        this.d39 = d39;
        this.d40 = d40;
        this.d41 = d41;
        this.d42 = d42;
        this.d43 = d43;
        this.d44 = d44;
        this.d45 = d45;
        this.d46 = d46;
    }
    
    


    /*###################################
               MÉTODOS DA CLASSE
      ###################################*/
    
    public void setId_cargo(String id_cargo) {
        this.cargo = id_cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setCodigoC(String codigoC) {
        this.codigoC = codigoC;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public void setSiglaP(String siglaP) {
        this.siglaP = siglaP;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public void setTipoE(String tipoE) {
        this.tipoE = tipoE;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setDescE(String descE) {
        this.descE = descE;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setSexoE(String sexoE) {
        this.sexoE = sexoE;
    }

    public void setFaixa_etaria(String faixa_etaria) {
        this.faixa_etaria = faixa_etaria;
    }

    public void setTotalE(String totalE) {
        this.totalE = totalE;
    }

    public String getCodigoC() {
        return codigoC;
    }

    public String getPartido() {
        return partido;
    }

    public String getSiglaP() {
        return siglaP;
    }

    public String getComposicaoLegenda() {
        return composicaoLegenda;
    }

    public String getAno() {
        return ano;
    }

    public String getTipoE() {
        return tipoE;
    }

    public String getTurno() {
        return turno;
    }

    public String getDescE() {
        return descE;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getTotal() {
        return total;
    }

    public String getEstado() {
        return estado;
    }

    public String getUf() {
        return uf;
    }

    public String getSexoE() {
        return sexoE;
    }

    public String getFaixa_etaria() {
        return faixa_etaria;
    }

    public String getTotalE() {
        return totalE;
    }
    
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTse_o(String tse_o) {
        this.tse_o = tse_o;
    }

    public void setNascimento(String nascimento) {
        this.nasc = nascimento;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCargo() {
        return cargo;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getTse_o() {
        return tse_o;
    }

    public String getNascimento() {
        return nasc;
    }

    public String getSexo() {
        return sexo;
    }

}
