package br.com.seaourfuture.excecoes;


public class EmpresaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Tratamento de erros
	public EmpresaException() {
		super();
		System.out.println("Houve uma falha");
	}

	public EmpresaException(Exception e) {
		super();

		if (e.getClass().toString().equals("class java.lang.ClassNotFoundException")) {
			System.out.println("\nClasse não encontrada relacionada à empresa");
		}
		else if (e.getClass().toString().equals("class java.lang.NumberFormatException")) {
			System.out.println("\nErro de formato ao converter uma string em um número");
		} else if (e.getClass().toString().equals("class java.sql.SQLIntegrityConstraintViolationException")) {
			System.out.println("Violação de restrição de integridade ao operar no banco de dados");
		} else if (e.getClass().toString().equals("class java.sql.SQLException")) {
			System.out.println("\nErro SQL relacionado à empresa");
		} else if (e instanceof java.sql.SQLDataException) {
			System.out.println("\nFoi localizado um caractere não numérico onde se esperava um numérico");
		} else {
			System.out.println("\nFalha desconhecida");
			e.printStackTrace(); // O que é o erro e onde ele percorreu (detalhes)
		}
	}
}
