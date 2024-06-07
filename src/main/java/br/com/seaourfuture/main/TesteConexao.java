package br.com.seaourfuture.main;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.seaourfuture.conexoes.ConexaoFactory;

public class TesteConexao {
    
    // Método principal
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        // Obtém uma conexão com o banco de dados usando a fábrica de conexões
        Connection cn = new ConexaoFactory().conexao();
        
        // Exibe uma mensagem indicando que a conexão foi estabelecida com sucesso
        System.out.println("Conectado com o banco de dados!");
        
        // Fecha a conexão
        cn.close();
    }
}
