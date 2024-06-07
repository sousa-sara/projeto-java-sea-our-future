package br.com.seaourfuture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.seaourfuture.conexoes.ConexaoFactory;
import br.com.seaourfuture.excecoes.EmpresaDAOException;
import br.com.seaourfuture.model.Empresa;

public class EmpresaDAO {

    public Connection minhaConexao;

    public EmpresaDAO() throws EmpresaDAOException {
        try {
            this.minhaConexao = new ConexaoFactory().conexao();
        } catch (ClassNotFoundException | SQLException e) {
            throw new EmpresaDAOException(e);
        }
    }

    public String inserir(Empresa empresa) throws EmpresaDAOException, ParseException {
        try {
            String sql = "INSERT INTO T_SOF_EMPRESA (ID_EMPRESA, RAZAO_SOCIAL, CNPJ, PROPOSTA, WEBSITE, EMAIL, SENHA, DATA_REGISTRO) values (seq_empresa.NEXTVAL,?,?,?,?,?,?,?)";
            PreparedStatement stmt = minhaConexao.prepareStatement(sql);
            stmt.setString(1, empresa.getRazaoSocial());
            stmt.setString(2, empresa.getCnpj());
            stmt.setString(3, empresa.getProposta());
            stmt.setString(4, empresa.getWebsite());
            stmt.setString(5, empresa.getEmail());
            stmt.setString(6, empresa.getSenha());
            
         // Converter a string de data para java.sql.Date
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date date = sdf.parse(empresa.getDataRegistro());
            stmt.setDate(7, new java.sql.Date(date.getTime()));
            stmt.execute();
            stmt.close();
            return "Inserido com sucesso!";
        } catch (SQLException e) {
            throw new EmpresaDAOException(e);
        }
    }

    public String deletar(int id) throws EmpresaDAOException {
        try {
            PreparedStatement stmt = minhaConexao.prepareStatement("DELETE from T_SOF_EMPRESA where ID_EMPRESA = ?");
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            return "Deletado com sucesso!";
        } catch (SQLException e) {
            throw new EmpresaDAOException(e);
        }
    }

    public String atualizar(Empresa empresa) throws EmpresaDAOException {
        try {
            PreparedStatement stmt = minhaConexao.prepareStatement("UPDATE T_SOF_EMPRESA set RAZAO_SOCIAL = ?, CNPJ = ?, PROPOSTA = ?, WEBSITE = ?, EMAIL = ?, SENHA = ?, DATA_REGISTRO = ? where ID_EMPRESA = ?");
            stmt.setString(1, empresa.getRazaoSocial());
            stmt.setString(2, empresa.getCnpj());
            stmt.setString(3, empresa.getProposta());
            stmt.setString(4, empresa.getWebsite());
            stmt.setString(5, empresa.getEmail());
            stmt.setString(6, empresa.getSenha());
            stmt.setString(7, empresa.getDataRegistro());
            stmt.setInt(8, empresa.getId());
            stmt.executeUpdate();
            stmt.close();
            return "Atualizado com sucesso!";
        } catch (SQLException e) {
            throw new EmpresaDAOException(e);
        }
    }

    public List<Empresa> selecionar() throws EmpresaDAOException {
        try {
            List<Empresa> listaEmpresas = new ArrayList<Empresa>();
            PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM T_SOF_EMPRESA");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Empresa empresa = new Empresa();
                empresa.setId(rs.getInt(1));
                empresa.setRazaoSocial(rs.getString(2));
                empresa.setCnpj(rs.getString(3));
                empresa.setProposta(rs.getString(4));
                empresa.setWebsite(rs.getString(5));
                empresa.setEmail(rs.getString(6));
                empresa.setSenha(rs.getString(7));
                empresa.setDataRegistro(rs.getString(8));
                listaEmpresas.add(empresa);
            }
            rs.close();
            stmt.close();
            return listaEmpresas;
        } catch (SQLException e) {
            throw new EmpresaDAOException(e);
        }
    }
}
