package br.com.seaourfuture.main;
import java.sql.SQLException;
import java.util.List;

import br.com.seaourfuture.dao.EmpresaDAO;
import br.com.seaourfuture.excecoes.EmpresaDAOException;
import br.com.seaourfuture.model.Empresa;


public class TesteSelecionarEmpresa {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, EmpresaDAOException {
        
        // Instanciar objeto EmpresaDAO para acessar os métodos de seleção
        EmpresaDAO empresaDao = new EmpresaDAO();
        
        // Chamar o método selecionar() para obter a lista de empresas do banco de dados
        List<Empresa> listaEmpresas = empresaDao.selecionar();
        
        // Verificar se a lista não está vazia
        if(listaEmpresas != null) {
            // Iterar sobre a lista de empresas e imprimir os detalhes de cada empresa
            for (Empresa empresa : listaEmpresas) {
                System.out.println(empresa.getId() + " " +
                                   empresa.getRazaoSocial() + " " +
                                   empresa.getCnpj() + " " +
                                   empresa.getProposta() + " " +
                                   empresa.getWebsite() + " " +
                                   empresa.getEmail() + " " +
                                   empresa.getSenha() + " " +
                                   empresa.getDataRegistro() + " " + "\n"
                                   );
            }
        }
    }
}
