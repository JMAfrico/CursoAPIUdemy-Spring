package br.com.JMCursos.exception;

import java.io.Serializable;
import java.util.Date;

/*Responsavel por capturar os campos do erro, todas as exceptions passarão por aqui
 * Aqui ficam os dados da exceção que veremos em tela, hora, mensagem e detalhes
 * */
public class ExceptionResponse implements Serializable{

	private static final long serialVersionUID = 1L;

	private Date timestamp;
	private String message;
	private String details;
	
	public ExceptionResponse(Date timestamp, String message, String details) {
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}	
	
}
