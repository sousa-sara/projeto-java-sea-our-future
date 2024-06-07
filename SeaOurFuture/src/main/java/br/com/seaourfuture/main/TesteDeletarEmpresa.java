package br.com.seaourfuture.main;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.seaourfuture.dao.EmpresaDAO;
import br.com.seaourfuture.excecoes.EmpresaDAOException;
import br.com.seaourfuture.model.Empresa;



public class TesteDeletarEmpresa {

	// Inteiro
	static int inteiro (String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, EmpresaDAOException {
	

	//Instanciar objetos
	Empresa empresa = new Empresa();	
	EmpresaDAO empresaDao = new EmpresaDAO();
	
	// Obter o ID da empresa a ser deletada
	empresa.setId(inteiro("Informe o identificador(ID) da empresa a ser deletado: "));
	
	// Deletar o id da empresa do banco de dados e exibir o resultado
	System.out.println(empresaDao.deletar(empresa.getId()));

	}

}
