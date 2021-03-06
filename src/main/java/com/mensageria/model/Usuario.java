package com.mensageria.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuarios")
@Inheritance
@DiscriminatorColumn(name = "tipo_usuario")
@DiscriminatorValue("U")

public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique=true)
	private String email;
	private boolean emailConfirmado;
	private String nome;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar ultimoAcesso;

	@JsonIgnore
	@OneToMany(mappedBy = "proprietario")
	private List<Dispositivo> listaDispositivos;

	@JsonIgnore
	@OneToMany(mappedBy = "autor")
	private List<Mensagem> listaMensagensEnviadas;

	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Recebe> listaRecebidas;

	public Usuario() {
	}

	public Usuario(String email, boolean emailConfirmado, String nome, Calendar ultimoAcesso) {
		super();
		this.email = email;
		this.emailConfirmado = emailConfirmado;
		this.nome = nome;
		this.ultimoAcesso = ultimoAcesso;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEmailConfirmado() {
		return emailConfirmado;
	}

	public void setEmailConfirmado(boolean emailConfirmado) {
		this.emailConfirmado = emailConfirmado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(Calendar ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	public List<Dispositivo> getListaDispositivos() {
		return listaDispositivos;
	}

	public void setListaDispositivos(List<Dispositivo> listaDispositivos) {
		this.listaDispositivos = listaDispositivos;
	}

	public List<Mensagem> getListaMensagens() {
		return listaMensagensEnviadas;
	}

	public void setListaMensagens(List<Mensagem> listaMensagens) {
		this.listaMensagensEnviadas = listaMensagens;
	}

	public List<Recebe> getListaConfirmacoes() {
		return listaRecebidas;
	}

	public void setListaConfirmacoes(List<Recebe> listaConfirmacoes) {
		this.listaRecebidas = listaConfirmacoes;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", emailConfirmado=" + emailConfirmado + ", nome=" + nome
				+ ", ultimoAcesso=" + ultimoAcesso.getTime() + "]";
	}
	
}
