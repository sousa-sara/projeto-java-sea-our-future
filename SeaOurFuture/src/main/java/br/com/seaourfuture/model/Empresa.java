package br.com.seaourfuture.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Empresa {

    private int id;
    private String razaoSocial;
    private String cnpj;
    private String proposta;
    private String website;
    private String email;
    private String senha;
    private String dataRegistro;

    public Empresa() {
        super();
    }

	public Empresa(int id, String razaoSocial, String cnpj, String proposta, String website, String email, String senha,
			String dataRegistro) {
		super();
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.proposta = proposta;
		this.website = website;
		this.email = email;
		this.senha = senha;
		this.dataRegistro = dataRegistro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getProposta() {
		return proposta;
	}

	public void setProposta(String proposta) {
		this.proposta = proposta;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(String dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	
}