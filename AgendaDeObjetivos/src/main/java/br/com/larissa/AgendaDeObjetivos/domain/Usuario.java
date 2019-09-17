package br.com.larissa.AgendaDeObjetivos.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private Long id;
	
	@JsonProperty
	private String login;
	
	@JsonProperty
	private Integer senha;
	
/*
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Integer getSenha() {
		return senha;
	}

	public void setSenha(Integer senha) {
		this.senha = senha;
	}
	
*/
	
	
	
	
	
	
}
