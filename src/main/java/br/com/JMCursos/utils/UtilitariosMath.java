package br.com.JMCursos.utils;

import br.com.JMCursos.exception.ResourceNotFoundException;

public class UtilitariosMath {

	private double executar(String number) {
		if(number==null) {
			return 0D;
		}
		
		String um = number.replaceAll(",", ".");
		Boolean validacao = um.matches("[-+]?[0-9]*\\.?[0-9]+");
	
		if(validacao.equals(false)) {
			throw new ResourceNotFoundException("Erro , você não digitou numero");
		}
		return Double.parseDouble(um);
	}

	public Double soma(String numberOne, String numberTwo) {
		return executar(numberOne) + executar(numberTwo);
	}

	public Double substracao(String numberOne, String numberTwo) {
		return executar(numberOne) - executar(numberTwo);
	}

	public Double multiplicacao(String numberOne, String numberTwo) {
		return executar(numberOne) * executar(numberTwo);
	}

	public Double divisao(String numberOne, String numberTwo) {
		return executar(numberOne) / executar(numberTwo);
	}

	public Double media(String numberOne, String numberTwo) {
		return (executar(numberOne) + executar(numberTwo)) / 2;
	}

	public Double raiz(String numberOne) {
		return Math.sqrt(executar(numberOne));
	}

	public Double potencia(String numberOne) {
		return (executar(numberOne) * executar(numberOne));
	}

}
