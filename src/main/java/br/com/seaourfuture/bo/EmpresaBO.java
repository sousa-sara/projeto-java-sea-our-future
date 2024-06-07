package br.com.seaourfuture.bo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import br.com.seaourfuture.dao.EmpresaDAO;
import br.com.seaourfuture.excecoes.EmpresaDAOException;
import br.com.seaourfuture.model.Empresa;

public class EmpresaBO {
    
    EmpresaDAO empresaDao;
    
    // Selecionar
    public ArrayList<Empresa> selecionarBo() throws ClassNotFoundException, SQLException, EmpresaDAOException {
        empresaDao = new EmpresaDAO();    
        return (ArrayList<Empresa>) empresaDao.selecionar();
    }
    
    // Inserir
    public void inserirBo(Empresa empresa) throws ClassNotFoundException, SQLException, EmpresaDAOException, ParseException {
        empresaDao = new EmpresaDAO();
        empresaDao.inserir(empresa);
    }
    
    // Atualizar
    public void atualizarBo(Empresa empresa) throws ClassNotFoundException, SQLException, EmpresaDAOException {
        empresaDao = new EmpresaDAO();
        empresaDao.atualizar(empresa);
    }
    
    // Deletar
    public void deletarBo(int id) throws ClassNotFoundException, SQLException, EmpresaDAOException {
        empresaDao = new EmpresaDAO();
        empresaDao.deletar(id);        
    }
}
