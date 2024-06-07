package br.com.seaourfuture.main;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.seaourfuture.dao.EmpresaDAO;
import br.com.seaourfuture.excecoes.EmpresaDAOException;
import br.com.seaourfuture.model.Empresa;


public class TesteAtualizarEmpresa {
	
	//Texto
	static String texto (String j) {
		return JOptionPane.showInputDialog(j);
	}
	
	//Inteiro
	static int inteiro (String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}
	//Decimal 
	static double decimal (String j) {
		return Double.parseDouble(JOptionPane.showInputDialog(j));
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, EmpresaDAOException {
	
	//Instanciar objetos
	Empresa empresa= new Empresa();		
	EmpresaDAO empresaDao = new EmpresaDAO();
	
	// Obter dados do usuário para atualizar o país
	empresa.setId(inteiro("Para atualizar, digite o ID: "));
	empresa.setRazaoSocial(texto("Razão Social: "));
	empresa.setCnpj(texto("CNPJ: "));
	empresa.setProposta(texto("Proposta: "));
	empresa.setWebsite(texto("Website: "));
	empresa.setEmail(texto("Email: "));
	empresa.setSenha(texto("Senha: "));
	empresa.setDataRegistro(texto("Data de Registro: "));
	
	// Atualizar o país no banco de dados e exibir o resultado
	System.out.println(empresaDao.atualizar(empresa));

	}

}
