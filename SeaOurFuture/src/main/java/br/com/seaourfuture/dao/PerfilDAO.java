package br.com.seaourfuture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.seaourfuture.conexoes.ConexaoFactory;
import br.com.seaourfuture.model.Perfil;

public class PerfilDAO {

    // Atributo para armazenar a conexão com o banco de dados
    public Connection minhaConexao;

    // Construtor da classe que inicializa a conexão com o banco de dados
    public PerfilDAO() throws ClassNotFoundException, SQLException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Método para inserir um perfil no banco de dados
    public String inserir(Perfil perfil) throws SQLException {
        String sql = "INSERT INTO T_SOF_PERFIL (ID_PERFIL, LOGO_EMPRESA, ATIVIDADE, DESCRICAO, ID_EMPRESA) values (seq_perfil.NEXTVAL,?,?,?,?)";
        PreparedStatement stmt = minhaConexao.prepareStatement(sql);
        stmt.setString(1, perfil.getLogoEmpresa());
        stmt.setString(2, perfil.getAtividade());
        stmt.setString(3, perfil.getDescricao());
        stmt.setInt(4, perfil.getIdEmpresa());
        stmt.execute();
        stmt.close();

        return "Inserido com sucesso!";
    }

    // Método para deletar um perfil do banco de dados
    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE from T_SOF_PERFIL where ID_PERFIL = ?");
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();

        return "Deletado com sucesso!";
    }

    // Método para atualizar os dados de um perfil no banco de dados
    public String atualizar(Perfil perfil) throws SQLException {
        String sql = "UPDATE T_SOF_PERFIL set LOGO_EMPRESA = ?, ATIVIDADE = ?, DESCRICAO = ?, ID_EMPRESA = ? where ID_PERFIL = ?";
        PreparedStatement stmt = minhaConexao.prepareStatement(sql);
        stmt.setString(1, perfil.getLogoEmpresa());
        stmt.setString(2, perfil.getAtividade());
        stmt.setString(3, perfil.getDescricao());
        stmt.setInt(4, perfil.getIdEmpresa());
        stmt.setInt(5, perfil.getId());
        stmt.executeUpdate();
        stmt.close();

        return "Atualizado com sucesso!";
    }

    // Método para selecionar todos os perfis do banco de dados e retornar uma lista de objetos Perfil
    public List<Perfil> selecionar() throws SQLException {
        List<Perfil> listaPerfis = new ArrayList<Perfil>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM T_SOF_PERFIL");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Perfil perfil = new Perfil();
            perfil.setId(rs.getInt(1));
            perfil.setLogoEmpresa(rs.getString(2));
            perfil.setAtividade(rs.getString(3));
            perfil.setDescricao(rs.getString(4));
            perfil.setIdEmpresa(rs.getInt(5));

            listaPerfis.add(perfil);
        }

        rs.close();
        stmt.close();

        return listaPerfis;
        
        
    }
    
    
}
