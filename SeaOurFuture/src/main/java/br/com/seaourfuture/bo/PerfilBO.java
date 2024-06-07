package br.com.seaourfuture.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.seaourfuture.dao.PerfilDAO;
import br.com.seaourfuture.model.Perfil;


public class PerfilBO {
	
PerfilDAO perfilDao;
	
	// Selecionar 
	public ArrayList<Perfil> selecionarBo() throws ClassNotFoundException, SQLException{
		perfilDao = new PerfilDAO();
		return (ArrayList<Perfil>) perfilDao.selecionar();
		
	}
	
	// Inserir 
	public void inserirBo(Perfil perfil) throws ClassNotFoundException, SQLException {
		PerfilDAO perfilDao = new PerfilDAO();
		perfilDao.inserir(perfil);
	}
	
	// Atualizar 
	public void atualizarBo(Perfil perfil) throws ClassNotFoundException, SQLException {
		PerfilDAO perfilDao = new PerfilDAO();
		perfilDao.atualizar(perfil);
	}
	
	// Deletar
	public void deletarBo (int id) throws ClassNotFoundException, SQLException {
		PerfilDAO perfilDao = new PerfilDAO();
		perfilDao.deletar(id);		
	}


}
