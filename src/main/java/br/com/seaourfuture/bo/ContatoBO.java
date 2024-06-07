package br.com.seaourfuture.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.seaourfuture.dao.ContatoDAO;
import br.com.seaourfuture.model.Contato;

public class ContatoBO {
    
    ContatoDAO contatoDao;
    
    // Selecionar
    public ArrayList<Contato> selecionarBo() throws ClassNotFoundException, SQLException {
        contatoDao = new ContatoDAO();
        
        // REGRA DE NEGÓCIOS
        
        return (ArrayList<Contato>) contatoDao.selecionar();
    }
    
    // Inserir
    public void inserirBo(Contato contato) throws ClassNotFoundException, SQLException {
        contatoDao = new ContatoDAO();
        
        // REGRA DE NEGÓCIOS
        
        contatoDao.inserir(contato);
    }
    
    // Atualizar
    public void atualizarBo(Contato contato) throws ClassNotFoundException, SQLException {
        contatoDao = new ContatoDAO();
        
        // REGRA DE NEGÓCIOS
        
        contatoDao.atualizar(contato);
    }
    
    // Deletar
    public void deletarBo(int id) throws ClassNotFoundException, SQLException {
        contatoDao = new ContatoDAO();
        
        // REGRA DE NEGÓCIOS
        
        contatoDao.deletar(id);        
    }
}
