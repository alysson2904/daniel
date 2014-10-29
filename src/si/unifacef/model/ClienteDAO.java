package si.unifacef.model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import si.unifacef.pojo.Cliente;

public class ClienteDAO {
    public int insere(Cliente cliente){
        int result = 0;
        String nome = cliente.getNome();
        String endereco = cliente.getEndereco();
       // String rg = cliente.getRg();
        String cpf = cliente.getCpf();
        String cidade = cliente.getCidade();
        String estado = cliente.getEstado();
        PreparedStatement canal;
        try{
            BancoDados.conexao(); // método
            String sql;
            sql = "insert into tb_cliente (cpf, nome, endereco, cidade, estado) values (?, ?, ?, ?, ?)";
            // cria o canal de comunicação com o banco de dados
            canal = BancoDados.conexao.prepareStatement(sql); // variável
            canal.setString(1, cpf);
            canal.setString(2, nome);
            //canal.setString(3, rg);
            canal.setString(3, endereco);
            canal.setString(4, cidade);
            canal.setString(5, estado);
            result = canal.executeUpdate();
            return result; // retorna 1
        }
        catch(Exception e){
            System.out.println(e);
            return -1; // indica o erro
        }
    }
    //**************************remove**********************
    public int remove(Cliente cliente){
        int result = 0;
        int codigo = cliente.getCodigo();
        PreparedStatement canal;
        try{
            BancoDados.conexao(); // método
            String sql = "delete from tb_cliente where codigo = ?";
            // cria o canal de comunicação com o banco de dados
            canal = BancoDados.conexao.prepareStatement(sql);
            canal.setInt(1, codigo);
            result = canal.executeUpdate();
            return result;
        }
        catch(Exception e){
            System.out.println(e);
            return -1;
        }
    }
    //*******************ATUALIZAR*************************
   public int atualiza(Cliente cliente){
        int result = 0;
        int codigo = cliente.getCodigo();
        PreparedStatement canal;
        try{
            BancoDados.conexao(); // método
            String sql = "select * from tb_cliente where codigo = ?";
            // cria o canal de comunicação com o banco de dados
            canal = BancoDados.conexao.prepareStatement(sql);
            canal.setInt(1, codigo);
            result = canal.executeUpdate();
            return result;
        }
        catch(Exception e){
            System.out.println(e);
            return -1;
        }
    }

        
        
    

    //**************atualiza******************
    public int atualizar(Cliente cliente){
        int result = 0;
        int codigo = cliente.getCodigo();
        String nome = cliente.getNome();
        String cpf = cliente.getCpf();
        String endereco = cliente.getEndereco();
        String cidade = cliente.getCidade();
        String estado = cliente.getEstado();
        PreparedStatement canal;
        try{
            BancoDados.conexao(); // método
            String sql = "update tb_cliente set nome = ? cpf = ? endereco = ? cidade = ? estado = ? where codigo = ?";
            // cria o canal de comunicação com o banco de dados
            canal = BancoDados.conexao.prepareStatement(sql);
            canal.setInt(1, codigo);
            canal.setString(2, nome);
            canal.setString(3, cpf);
            canal.setString(4, endereco);
            canal.setString(5, estado);
            result = canal.executeUpdate();
            return result;
        }
        catch(Exception e){
            System.out.println(e);
            return -1;
        }
    }

    //*************consulta*************
   
    public ArrayList<Cliente> consulta(){
        PreparedStatement canal;
        ResultSet rs;
        ArrayList<Cliente> clientes = new ArrayList();
        try{
            BancoDados.conexao(); // método
            String sql;
            sql = "select * from tb_cliente";
            // cria o canal de comunicação com o banco de dados
            canal = BancoDados.conexao.prepareStatement(sql); // variável
            rs = canal.executeQuery();
                while(rs.next()){
                    Cliente cliente = new Cliente();
                    cliente.setCodigo(rs.getInt("codigo"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setEndereco(rs.getString("endereco"));
                    //cliente.setRg(rs.getString("rg"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setCidade(rs.getString("cidade"));
                    cliente.setEstado(rs.getString("estado"));
                    clientes.add(cliente);
                }
            return clientes;
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    //CONSULTAR CLIENTE POR CPF
    public Cliente consultaCpf(int cpf){
        return null;
    }
    public ArrayList<Cliente> consultaCpf(){
        PreparedStatement canal;
        ResultSet rs;
        ArrayList<Cliente> clientes = new ArrayList();
        try{
            BancoDados.conexao(); // método
            String sql;
            sql = "select * from tb_cliente where cpf = ? ";
            // cria o canal de comunicação com o banco de dados
            canal = BancoDados.conexao.prepareStatement(sql); // variável
            rs = canal.executeQuery();
                while(rs.next()){
                    Cliente clientecpf = new Cliente();
                    clientecpf.setCodigo(rs.getInt("codigo"));
                    clientecpf.setNome(rs.getString("nome"));
                    clientecpf.setEndereco(rs.getString("endereco"));
                    //cliente.setRg(rs.getString("rg"));
                    clientecpf.setCpf(rs.getString("cpf"));
                    clientecpf.setCidade(rs.getString("cidade"));
                    clientecpf.setEstado(rs.getString("estado"));
                    clientes.add(clientecpf);
                }
            return clientes;
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    //BOTÃO PROCURA DO ATUALIZA CLIENTE
    public Cliente procura(){
        PreparedStatement canal;
        ResultSet rs;
        Cliente clientes = new Cliente();
        try{
            BancoDados.conexao(); // método
            String sql;
            sql = "select * from tb_cliente where codigo = ?";
            // cria o canal de comunicação com o banco de dados
            canal = BancoDados.conexao.prepareStatement(sql); // variável
            rs = canal.executeQuery();
                while(rs.next()){
                    Cliente cliente = new Cliente();
                    cliente.setCodigo(rs.getInt("codigo"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setEndereco(rs.getString("endereco"));
                    //cliente.setRg(rs.getString("rg"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setCidade(rs.getString("cidade"));
                    cliente.setEstado(rs.getString("estado"));
                    return clientes;
                }
            return clientes;
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    //PREENCHER CAMPOS AUTOMATICOS DE ACORDO COM O CODIGO
    public Cliente preenche(int codigo){
        return null;
    }
    public ArrayList<Cliente> preenche(){
        PreparedStatement canal;
        ResultSet rs;
        ArrayList<Cliente> clientes = new ArrayList();
        try{
            BancoDados.conexao(); // método
            String sql;
            sql = "select * from tb_cliente where codigo = ?";
            // cria o canal de comunicação com o banco de dados
            canal = BancoDados.conexao.prepareStatement(sql); // variável
            rs = canal.executeQuery();
                while(rs.next()){
                    

                }
            return clientes;
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
}
