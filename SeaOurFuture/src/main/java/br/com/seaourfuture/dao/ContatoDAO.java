package br.com.seaourfuture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.seaourfuture.conexoes.ConexaoFactory;
import br.com.seaourfuture.model.Contato;

public class ContatoDAO {

    // Atributo para armazenar a conexão com o banco de dados
    public Connection minhaConexao;

    // Construtor da classe que inicializa a conexão com o banco de dados
    public ContatoDAO() throws ClassNotFoundException, SQLException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Método para inserir um contato no banco de dados
    public String inserir(Contato contato) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("INSERT INTO T_SOF_CONTATO (ID_CONTATO, NUMERO, TIPO, ID_EMPRESA) values (seq_contato.NEXTVAL, ?, ?, ?)");
        stmt.setString(1, contato.getNumero());
        stmt.setString(2, contato.getTipo());
        stmt.setInt(3, contato.getIdEmpresa());
        stmt.execute();
        stmt.close();

        return "Inserido com sucesso!";
    }

    // Método para deletar um contato do banco de dados
    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE from T_SOF_CONTATO where ID_CONTATO = ?");
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();

        return "Deletado com sucesso!";
    }

    // Método para atualizar os dados de um contato no banco de dados
    public String atualizar(Contato contato) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("UPDATE T_SOF_CONTATO set NUMERO = ?, TIPO = ?, ID_EMPRESA = ? where ID_CONTATO = ?");
        stmt.setString(1, contato.getNumero());
        stmt.setString(2, contato.getTipo());
        stmt.setInt(3, contato.getIdEmpresa());
        stmt.setInt(4, contato.getId());
        stmt.executeUpdate();
        stmt.close();

        return "Atualizado com sucesso!";
    }

    // Método para selecionar todos os contatos do banco de dados e retornar uma lista de objetos Telefone
    public List<Contato> selecionar() throws SQLException {
        List<Contato> listaContato = new ArrayList<Contato>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT ID_CONTATO, NUMERO, TIPO, ID_EMPRESA FROM T_SOF_CONTATO");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
        	Contato contato = new Contato();
            contato.setId(rs.getInt(1));
            contato.setNumero(rs.getString(2));
            contato.setTipo(rs.getString(3));
            contato.setIdEmpresa(rs.getInt(4));

            listaContato.add(contato);
        }

        rs.close();
        stmt.close();

        return listaContato;
    }
}
