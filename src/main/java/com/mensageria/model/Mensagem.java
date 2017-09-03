package com.mensageria.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "mensagens")
public class Mensagem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String conteudo;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataEnvio;

	@ManyToOne
	private Usuario autor;

	@ManyToOne
	private Conversa chat;
	
	@JsonIgnore
	@OneToMany(mappedBy = "mensagem")
	private List<Recebe> listaRecebidos;

	public Mensagem() {
	}

	public Mensagem(String conteudo, Calendar dataEnvio, Usuario autor, Conversa conversa) {
		super();
		this.conteudo = conteudo;
		this.dataEnvio = dataEnvio;
		this.autor = autor;
		this.chat = conversa;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Calendar getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Calendar dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Conversa getChat() {
		return chat;
	}

	public void setChat(Conversa chat) {
		this.chat = chat;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Mensagem [id=" + id + ", conteudo=" + conteudo + ", dataEnvio=" + dataEnvio.getTime() + ", autor=" + autor
				+ ", conversa=" + chat + "]";
	}

}
