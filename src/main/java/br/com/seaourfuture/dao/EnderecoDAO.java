package br.com.seaourfuture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.seaourfuture.conexoes.ConexaoFactory;
import br.com.seaourfuture.model.Endereco;

public class EnderecoDAO {

	// Atributo para armazenar a conexão com o banco de dados
    public Connection minhaConexao;
    
    public void salvarEndereco(Endereco endereco) throws SQLException, ClassNotFoundException {
    	PreparedStatement stmt = minhaConexao.prepareStatement("INSERT INTO T_SOF_ENDERECO (id_endereco, cep, logradouro, localidade, bairro, numero, uf, id_empresa) VALUES (seq_endereco.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)");
    	stmt.setString(1, endereco.getCep());
        stmt.setString(2, endereco.getLogradouro());
        stmt.setString(3, endereco.getLocalidade());
        stmt.setString(4, endereco.getBairro());
        stmt.setInt(5, endereco.getNumero());
        stmt.setString(6, endereco.getUf());
        stmt.setInt(7, endereco.getIdEmpresa());
        stmt.executeUpdate();
        }
    


    // Construtor da classe que inicializa a conexão com o banco de dados
    public EnderecoDAO() throws ClassNotFoundException, SQLException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Método para inserir um endereço no banco de dados
    public String inserir(Endereco endereco) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("INSERT INTO T_SOF_ENDERECO (ID_ENDERECO, CEP, LOGRADOURO, LOCALIDADE, BAIRRO, NUMERO, UF, ID_EMPRESA) values (seq_endereco.NEXTVAL,?,?,?,?,?,?,?)");
        stmt.setString(1, endereco.getCep());
        stmt.setString(2, endereco.getLogradouro());
        stmt.setString(3, endereco.getLocalidade());
        stmt.setString(4, endereco.getBairro());
        stmt.setInt(5, endereco.getNumero());
        stmt.setString(6, endereco.getUf());
        stmt.setInt(7, endereco.getIdEmpresa());
        stmt.execute();
        stmt.close();

        return "Inserido com sucesso!";
    }


    // Método para deletar um endereço do banco de dados
    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE from T_SOF_ENDERECO where ID_ENDERECO = ?");
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();

        return "Deletado com sucesso!";
    }

    // Método para atualizar os dados de um endereço no banco de dados
    public String atualizar(Endereco endereco) throws SQLException {

        PreparedStatement stmt = minhaConexao.prepareStatement("UPDATE T_SOF_ENDERECO set CEP = ?, LOGRADOURO = ?, LOCALIDADE = ?, BAIRRO = ?, NUMERO = ?, UF = ?, ID_EMPRESA = ? where ID_ENDERECO = ?");
        stmt.setString(1, endereco.getCep());
        stmt.setString(2, endereco.getLogradouro());
        stmt.setString(3, endereco.getLocalidade());
        stmt.setString(4, endereco.getBairro());
        stmt.setInt(5, endereco.getNumero());
        stmt.setString(6, endereco.getUf());
        stmt.setInt(7, endereco.getIdEmpresa());
        stmt.setInt(8, endereco.getId());
        stmt.executeUpdate();
        stmt.close();

        return "Atualizado com sucesso!";
    }

    // Método para selecionar todos os endereços do banco de dados e retornar uma lista de objetos Pais
    public List<Endereco> selecionar() throws SQLException {
        List<Endereco> listaEnderecos = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM T_SOF_ENDERECO");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Endereco endereco = new Endereco();
            endereco.setId(rs.getInt(1));
            endereco.setCep(rs.getString(2));
            endereco.setLogradouro(rs.getString(3));
            endereco.setLocalidade(rs.getString(4));
            endereco.setBairro(rs.getString(5));
            endereco.setNumero(rs.getInt(6));
            endereco.setUf(rs.getString(7));
            endereco.setIdEmpresa(rs.getInt(8));

            listaEnderecos.add(endereco);
        }

        return listaEnderecos;
    
    }
}
