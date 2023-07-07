package br.com.JMCursos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Anotação que retorna o status, nesse caso captura para essa exception
//Todas as classes com essa anotação, representam uma classe para erro
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnssuportedMathOperationException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UnssuportedMathOperationException(String message) {
		super(message);
	}
}
