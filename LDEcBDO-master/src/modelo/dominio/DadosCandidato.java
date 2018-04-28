package modelo.dominio;

/**
 *
 * @author Jefferson
 */
public class DadosCandidato {
    
    /*###################################
              ATRIBUTOS DA CLASSE
      ###################################*/
    
    private int id_cargo;
    private int cpf;
    private String nome;
    private String tse_o;
    private String nascimento;
    private String sexo;
    
    /*###################################
              CONSTRUTOR DA CLASSE
      ###################################*/
    
    public DadosCandidato(){
        
    }
    
    public DadosCandidato(int _id_cargo,String _nome) {
        this.setId_cargo(_id_cargo);
        this.setNome(_nome);
    }
    
    public DadosCandidato(int _id_cargo, int _cpf, String _nome, String _tse_o, String _nascimento, String _sexo) {
        this.setId_cargo(_id_cargo);
        this.setCpf(_cpf);
        this.setNome(_nome);
        this.setTse_o(_tse_o);
        this.setNascimento(_nascimento);
        this.setSexo(_sexo);
        //teste23
    }

    /*###################################
               MÉTODOS DA CLASSE
      ###################################*/
    
    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTse_o(String tse_o) {
        this.tse_o = tse_o;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public int getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getTse_o() {
        return tse_o;
    }

    public String getNascimento() {
        return nascimento;
    }

    public String getSexo() {
        return sexo;
    }

}
