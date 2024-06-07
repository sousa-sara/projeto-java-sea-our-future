package br.com.seaourfuture.model;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Endereco {
	
	//Visibilidade, tipo de dado e nome da variável
	private int id;
	private String cep;
	private String logradouro;
	private String localidade;
	private String bairro;
	private int numero;
	private String uf;
	private int idEmpresa;
	
	//Construtor vazio
	public Endereco() {
		super();
	}

	public Endereco(int id, String cep, String logradouro, String localidade, String bairro, int numero, String uf,
			int idEmpresa) {
		super();
		this.id = id;
		this.cep = cep;
		this.logradouro = logradouro;
		this.localidade = localidade;
		this.bairro = bairro;
		this.numero = numero;
		this.uf = uf;
		this.idEmpresa = idEmpresa;
	}

	@Override
	public String toString() {
		return "Busca das Informações de Endereço (API ViaCep): " + "\n\nCEP: " + cep + "\nLogradouro: " + logradouro + "\nCidade: " + localidade
				+ "\nBairro: " + bairro + "\nNúmero: " + numero + "\nEstado: " + uf + "\nID da empresa relacionada (FK): " + idEmpresa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

}
