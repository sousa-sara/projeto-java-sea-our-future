package br.com.seaourfuture.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Contato {
	
	//Visibilidade, tipo de dado e nome da variável
	private int id;
	private String numero;
	private String tipo;
	private int idEmpresa;
	
	public Contato() {
		super();
	}

	public Contato(int id, String numero, String tipo, int idEmpresa) {
		super();
		this.id = id;
		this.numero = numero;
		this.tipo = tipo;
		this.idEmpresa = idEmpresa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	
}
	