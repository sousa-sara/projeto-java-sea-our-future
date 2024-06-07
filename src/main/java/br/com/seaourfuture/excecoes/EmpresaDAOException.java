package br.com.seaourfuture.excecoes;

import java.sql.SQLException;

public class EmpresaDAOException extends Exception {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmpresaDAOException() {
        super("Houve uma falha no DAO da Empresa");
    }
    
    public EmpresaDAOException(Exception e) {
        super("Falha desconhecida no DAO da Empresa", e);
    }
    
    @Override
    public String getMessage() {
        if (getCause() instanceof SQLException) {
            return "Erro SQL ocorreu no DAO da Empresa";
        } else {
            return super.getMessage();
        }
    }
}
