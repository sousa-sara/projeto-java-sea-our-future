package br.com.seaourfuture.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.seaourfuture.dao.EnderecoDAO;
import br.com.seaourfuture.model.Endereco;

public class EnderecoBO {
	
	EnderecoDAO enderecoDao;
	
	// Selecionar 
	public ArrayList<Endereco> selecionarBo() throws ClassNotFoundException, SQLException{
		enderecoDao = new EnderecoDAO();
		
		return (ArrayList<Endereco>) enderecoDao.selecionar();
		
	}
	
	// Inserir 
	public void inserirBo(Endereco endereco) throws ClassNotFoundException, SQLException {
		EnderecoDAO enderecoDao = new EnderecoDAO();
		
		if (endereco == null) {
			throw new IllegalArgumentException("Endereço não pode ser nulo");
		}
		
		enderecoDao.inserir(endereco);
	}
	
	// Atualizar 
	public void atualizarBo(Endereco endereco) throws ClassNotFoundException, SQLException {
		EnderecoDAO enderecoDao = new EnderecoDAO();
		
		if (endereco == null) {
			throw new IllegalArgumentException("Endereço não pode ser nulo");
		}
		
		enderecoDao.atualizar(endereco);
	}
	
	// Deletar
	public void deletarBo (int id) throws ClassNotFoundException, SQLException {
		EnderecoDAO enderecoDao = new EnderecoDAO();
		
		enderecoDao.deletar(id);		
	}

}
