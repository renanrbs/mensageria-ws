package com.mensageria.interfaces;

import com.mensageria.model.Usuario;
import com.mensageria.model.Mensagem;

public interface InterfaceCliente {
	
	void ConfirmarMensagem(Usuario cliente);
	
	Mensagem ReceberMensagem(Usuario cliente);
	
	boolean TemMensagem(Usuario cliente);

}
