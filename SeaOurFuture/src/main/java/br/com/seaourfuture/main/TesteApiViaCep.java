package br.com.seaourfuture.main;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.apache.http.client.ClientProtocolException;

import br.com.seaourfuture.dao.EnderecoDAO;
import br.com.seaourfuture.model.Endereco;
import br.com.seaourfuture.service.ViaCepService;

public class TesteApiViaCep {
	
	static String texto(String j) {
		return JOptionPane.showInputDialog(j);
	}

	public static void main(String[] args) throws ClientProtocolException, IOException, ClassNotFoundException, SQLException {
		
		//Instanciar objetos
		ViaCepService viaCep = new ViaCepService();
		EnderecoDAO enderecoDao = new EnderecoDAO();
		
		String cep = texto("Informe o CEP a ser pesquisado: ");
		
		Endereco endereco = viaCep.getEndereco(cep);
		
		// Solicitar idEmpresa ao usuário
        int idEmpresa = Integer.parseInt(texto("Informe o ID da empresa relacionado ao endereço: "));
        endereco.setIdEmpresa(idEmpresa);
        
        // Solicitar número ao usuário
        int numero = Integer.parseInt(texto("Informe o número do endereço: "));
        endereco.setNumero(numero);
        
        // Exibir dados do endereço no console
        System.out.println(endereco);
		
		// Salvar endereço no banco de dados
        enderecoDao.salvarEndereco(endereco);
        JOptionPane.showMessageDialog(null, "Endereço salvo no banco de dados com sucesso!");
        
    }


}


