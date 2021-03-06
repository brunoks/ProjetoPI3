package modelo.dao;

import controle.DadosC;
import modelo.dao.conexao.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.dominio.DadosCandidato;

/**
 * Tratamento das Consultas vinculadas ao Candidatos
 * @author AC/DC
 */
public class DadosCandidatoDAO {
    
    /*###################################
              ATRIBUTOS DA CLASSE
      ###################################*/
    
    private ConnectionFactory cf;
    private Connection conn;
    private PreparedStatement pstmt; // query
    private Statement stmt;
    private String sql;
    private ResultSet rs;
    
    /*###################################
             CONSTRUTOR DA CLASSE
      ###################################*/
    public DadosCandidatoDAO(){
        
        this.setConn(null); // Conexão será null incialmente
        
    }
    
    /*###################################
           MÉTODOS get e set DA CLASSE
      ###################################*/

    // Método para retornar o objeto da classe 'ConnectionFactory'
    public ConnectionFactory getCf() {
        return this.cf;
    }

    // Método para armazenar o objeto da classe 'ConnectionFactory'
    public void setCf(ConnectionFactory _cf) {
        this.cf = _cf;
    }

    // Método para resgatar o estado de conexão com o Oracle
    public Connection getConn() {
        return this.conn;
    }

    // Método para armazenar o estado de conexão com o Oracle
    public void setConn(Connection _conn) {
        this.conn = _conn;
    }

    // Método 
    public PreparedStatement getPstmt() {
        return this.pstmt;
    }

    // Método 
    public void setPstmt(PreparedStatement _pstmt) {
        this.pstmt = _pstmt;
    }
    
    // Método 
    public Statement getStmt() {
        return this.stmt;
    }

    // Método 
    public void setStmt(Statement _stmt) {
        this.stmt = _stmt;
    }

    // Método para resgatar a instrução SQL
    public String getSql() {
        return this.sql;
    }

    // Método para armazenar o instrução SQL
    public void setSql(String _sql) {
        this.sql = _sql;
    }

    // Método para recuperar o ResultSet
    public ResultSet getRs() {
        return this.rs;
    }
    
    // Método para armazenar o ResultSet
    public void setRs(ResultSet _rs) {
        this.rs = _rs;
    }
    
    /*###################################
               MÉTODOS DA CLASSE
      ###################################*/
    
    // Método para conectar ao banco de dados Oracle
    public Connection conectarBanco(){
        
        // Verificando se a há conexão com o BD Oracle
        // Caso não tenha, cria uma nova conexão.
        if(this.getConn() == null){
            this.setCf(new ConnectionFactory());
            this.setConn(this.getCf().criarConexaoOracle());
        }
            
        return this.getConn();
        
    }
       
    // Método para gravar todos os usuários presentes na lista
    public boolean gravarDadosBanco(DadosCandidato _dados, String refAno, String refPartido, String refCargo) {
  
        // Definindo a string sql
        this.setSql("INSERT INTO candidato (C_TSE,C_CPF,C_NOME,C_NASCIMENTO,C_SEXO) VALUES (?, ?, ?, ?, ?)");
        
        try {
            
            // Prepara a instrução SQL e monsta a estrutura dos parâmetros.
            this.setPstmt(this.getConn().prepareStatement(this.getSql()));
            
            // Setando os parâmetros que irão substituir '?'
            //String ano, String turno,String descE,String uf,String municipio,String codigoC,String cargo,String nome,
            //              String cpf,String siglaP,String partido,String composicaoLegenda,
            //             String nasc,String sexo
            
            this.getPstmt().setString(1, _dados.getTse_o());
            this.getPstmt().setString(2, _dados.getCpf());
            this.getPstmt().setString(3, _dados.getNome());
            this.getPstmt().setString(4, _dados.getNasc());
            this.getPstmt().setString(5, _dados.getSexo());
            
            
            // Executa o comando SQL com os parâmteros.
            this.getPstmt().execute();
            // Encerra o componente 'PrepareStatement'
            this.getPstmt().close();
            
            return true;
 
        }catch(SQLException e) {
            
            e.printStackTrace();
            
        }
 
        return false;
    }
    
    // Método para gravar todos os usuários presentes na lista
    public boolean gravarNoBanco(DadosCandidato _dado, String refAno, String refPartido, String refCargo, String refEstado) {
  
        // Definindo a string sql
        this.setSql("INSERT INTO candidato(cr_id,el_id,pr_id,c_tse,c_cpf,c_nome,c_nascimento,c_sexo,e_id) VALUES(?,?,?,?,?,?,?,?,?)");

        try {
            
            // Prepara a instrução SQL e monsta a estrutura dos parâmetros.
            this.setPstmt(this.getConn().prepareStatement(this.getSql()));
            
            // Setando os parâmetros que irão substituir '?'
            //String ano, String turno,String descE,String uf,String municipio,String codigoC,String cargo,String nome,
            //              String cpf,String siglaP,String partido,String composicaoLegenda,
            //             String nasc,String sexo
            
            this.getPstmt().setString(1, refCargo);
            this.getPstmt().setString(2, refAno);
            this.getPstmt().setString(3, refPartido);
            this.getPstmt().setString(4, _dado.getTse_o());
            this.getPstmt().setString(5, _dado.getCpf().replaceAll("\"", ""));
            this.getPstmt().setString(6, _dado.getNome().replaceAll("\"", ""));
            this.getPstmt().setString(7, _dado.getNasc().replaceAll("\"", ""));
            String sexo = _dado.getSexo().replaceAll("\"", "");
            this.getPstmt().setString(8,  (sexo == "Feminino") ? "F" : "M");
            this.getPstmt().setString(9,  refEstado);
            // Executa o comando SQL com os parâmteros.
            this.getPstmt().execute();
            // Encerra o componente 'PrepareStatement'
            this.getPstmt().close();
            
            return true;
 
        }catch(SQLException e) {
            
            e.printStackTrace();
            
        }
 
        return false;
    }
    
    public ResultSet getResultadoEstadoFiltro() {
        
        // Definindo a string sql
        this.setSql("SELECT SUM(p_total),E.e_uf,C.p_sexo,C.p_faixa_etaria FROM candidatos C INNER JOIN estado E ON E.e_id = C.e_id GROUP BY E.e_uf");
        
        
        try {
            
            // Prepara a instrução SQL e monsta a estrutura dos parâmetros.
            this.setPstmt(this.getConn().prepareStatement(this.getSql()));
            this.setRs(this.getPstmt().executeQuery());
            
            return this.getRs();
            
        }catch(SQLException e) {
            
            e.printStackTrace();
            
        }
        
        return null;
    }
   
        
    // Fechando a conexão com o banco de dados Oracle
    public void fecharConexaoOracle(){
        
        this.setConn(this.cf.fecharConexaoOracle());

    }
    
   // Configura essas variáveis de acordo com o seu banco  
   /*private final String URL = "jdbc:mysql://localhost/javafx_crud",  
         NOME = "root", SENHA = "senha";  
  
   private Connection con;  
   private Statement comando;  
  
   public void apagar(String rg) {  
      conectar();  
      try {  
         comando  
               .executeUpdate("DELETE FROM pessoa WHERE rg = '" + rg  
                     + "';");  
      } catch (SQLException e) {  
         imprimeErro("Erro ao apagar pessoas", e.getMessage());  
      } finally {  
         fechar();  
      }  
   }  
  
   public Vector<Pessoa> buscarTodos() {  
      conectar();  
      Vector<Pessoa> resultados = new Vector<Pessoa>();  
      ResultSet rs;  
      try {  
         rs = comando.executeQuery("SELECT * FROM pessoa");  
         while (rs.next()) {  
            Pessoa temp = new Pessoa();  
            // pega todos os atributos da pessoa  
            temp.setRg(rs.getString("rg"));  
            temp.setNome(rs.getString("nome"));  
            temp.setIdade(rs.getInt("idade"));  
            temp.setCidade(rs.getString("cidade"));  
            temp.setEstado(rs.getString("estado"));  
            resultados.add(temp);  
         }  
         return resultados;  
      } catch (SQLException e) {  
         imprimeErro("Erro ao buscar pessoas", e.getMessage());  
         return null;  
      }  
   }  
  
   public void atualizar(Pessoa pessoa) {  
      conectar();  
      String com = "UPDATE pessoa SET nome = '" + pessoa.getNome()  
            + "', idade =" + pessoa.getIdade() + ", cidade = '"  
            + pessoa.getCidade() + "', estado ='" + pessoa.getEstado()  
            + "' WHERE  rg = '" + pessoa.getRg() + "';";  
      System.out.println("Atualizada!");  
      try {  
         comando.executeUpdate(com);  
      } catch (SQLException e) {  
         e.printStackTrace();  
      } finally {  
         fechar();  
      }  
   }  
  
   public Vector<Pessoa> buscar(String rg) {  
      conectar();  
      Vector<Pessoa> resultados = new Vector<Pessoa>();  
      ResultSet rs;  
      try {  
         rs = comando.executeQuery("SELECT * FROM pessoa WHERE rg LIKE '"  
               + rg + "%';");  
         while (rs.next()) {  
            Pessoa temp = new Pessoa();  
            // pega todos os atributos da pessoa  
            temp.setRg(rs.getString("rg"));  
            temp.setNome(rs.getString("nome"));  
            temp.setIdade(rs.getInt("idade"));  
            temp.setCidade(rs.getString("cidade"));  
            temp.setEstado(rs.getString("estado"));  
            resultados.add(temp);  
         }  
         return resultados;  
      } catch (SQLException e) {  
         imprimeErro("Erro ao buscar pessoa", e.getMessage());  
         return null;  
      }  
  
   }  
  
   public void insere(Pessoa pessoa){  
      conectar();  
      try {  
         comando.executeUpdate("INSERT INTO Pessoa VALUES('"  
               + pessoa.getRg() + "', '" + pessoa.getNome() + "',"  
               + pessoa.getIdade() + ",'" + pessoa.getCidade() + "','"  
               + pessoa.getEstado() + "')");  
         System.out.println("Inserida!");  
      } catch (SQLException e) {  
         imprimeErro("Erro ao inserir Pessoa", e.getMessage());  
      } finally {  
         fechar();  
      }  
   }  
  
   private void conectar() {  
      try {  
         con = ConFactory.conexao(URL, NOME, SENHA, ConFactory.MYSQL);  
         comando = con.createStatement();  
         System.out.println("Conectado!");  
      } catch (ClassNotFoundException e) {  
         imprimeErro("Erro ao carregar o driver", e.getMessage());  
      } catch (SQLException e) {  
         imprimeErro("Erro ao conectar", e.getMessage());  
      }  
   }  
  
   private void fechar() {  
      try {  
         comando.close();  
         con.close();  
         System.out.println("Conexão Fechada");  
      } catch (SQLException e) {  
         imprimeErro("Erro ao fechar conexão", e.getMessage());  
      }  
   }  
  
   private void imprimeErro(String msg, String msgErro) {  
      JOptionPane.showMessageDialog(null, msg, "Erro crítico", 0);  
      System.err.println(msg);  
      System.out.println(msgErro);  
      System.exit(0);  
   } */ 
        
}
