package br.com.seaourfuture.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Perfil {
	
	//Visibilidade, tipo de dado e nome da variável
	private int id;
	private String logoEmpresa; //URL da imagem
	private String atividade; //URL da imagem
	private String descricao;
	private int idEmpresa;
	
	//Construtor vazio
	public Perfil() {
		super();
	}

	public Perfil(int id, String logoEmpresa, String atividade, String descricao, int idEmpresa) {
		super();
		this.id = id;
		this.logoEmpresa = logoEmpresa;
		this.atividade = atividade;
		this.descricao = descricao;
		this.idEmpresa = idEmpresa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogoEmpresa() {
		return logoEmpresa;
	}

	public void setLogoEmpresa(String logoEmpresa) {
		this.logoEmpresa = logoEmpresa;
	}

	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

}