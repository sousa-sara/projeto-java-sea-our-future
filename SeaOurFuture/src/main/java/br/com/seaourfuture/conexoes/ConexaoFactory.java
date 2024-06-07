package br.com.seaourfuture.conexoes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	
	// Método de conexão
	public Connection conexao() throws ClassNotFoundException, SQLException {
		
		// Carrega o driver JDBC necessário para se conectar ao banco de dados Oracle
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// Estabelece a conexão com o banco de dados Oracle usando as credenciais fornecidas
		// O formato do URL de conexão é: jdbc:oracle:thin:@<host>:<port>:<SID>
		// Neste caso, o host é "oracle.fiap.com.br", a porta é 1521 e o SID é "orcl"
		return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl",
				"rm552656", "010202");
	}

}
