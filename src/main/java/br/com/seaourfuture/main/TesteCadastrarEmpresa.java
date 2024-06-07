package br.com.seaourfuture.main;

import javax.swing.JOptionPane;

import br.com.seaourfuture.dao.EmpresaDAO;
import br.com.seaourfuture.excecoes.EmpresaDAOException;
import br.com.seaourfuture.excecoes.EmpresaException;
import br.com.seaourfuture.model.Empresa;

public class TesteCadastrarEmpresa {

    // Texto
    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    // Inteiro
    static int inteiro(String j) throws EmpresaException {
        try {
            return Integer.parseInt(JOptionPane.showInputDialog(j));
        } catch (NumberFormatException e) {
            throw new EmpresaException(e);
        }
    }

    public static void main(String[] args) throws EmpresaException, EmpresaDAOException {

        // Instanciar objetos
        Empresa empresa = new Empresa();
        EmpresaDAO empresaDao = new EmpresaDAO();

        try {
            // Obter dados da empresa para cadastrar
            empresa.setId(inteiro("ID: "));
            empresa.setRazaoSocial(texto("Razão Social: "));
            empresa.setCnpj(texto("CNPJ: "));
            empresa.setProposta(texto("Proposta: "));
            empresa.setWebsite(texto("Website: "));
            empresa.setEmail(texto("Email: "));
            empresa.setSenha(texto("Senha: "));
            empresa.setDataRegistro(texto("Data de Registro: "));

            // SQLDataException
            //Inserir a empresa no banco de dados e exibir o resultado
            System.out.println(empresaDao.inserir(empresa));
        } catch (Exception e) {
            throw new EmpresaException(e);
   
        } finally {
        	System.out.println("\nCheck");
        }
        
    }
}
