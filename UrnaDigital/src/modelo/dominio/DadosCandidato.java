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
    
    
    /*###################################
              CONSTRUTOR DA CLASSE
      ###################################*/

    public DadosCandidato(String ano, String turno,String descE,String uf,String municipio,String codigoC,String cargo,String nome,
                          String cpf,String siglaP,String partido,String composicaoLegenda,
                          String nasc,String sexo) {
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
    }
    
    public DadosCandidato(){
    
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

   
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNasc(String nasc) {
        this.nasc = nasc;
    }

    public void setComposicaoLegenda(String composicaoLegenda) {
        this.composicaoLegenda = composicaoLegenda;
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

    public String getNasc() {
        return nasc;
    }

    public String getSexo() {
        return sexo;
    }

}
