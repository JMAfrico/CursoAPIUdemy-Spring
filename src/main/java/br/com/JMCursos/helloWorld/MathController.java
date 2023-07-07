package br.com.JMCursos.helloWorld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.JMCursos.utils.UtilitariosMath;

@RestController
public class MathController {

	Double total = 0.0;
	UtilitariosMath operacao = new UtilitariosMath();
	
	// path params= obrigatório, rota/variaveis e método/ == 
	//é a própria rota em SI, separada pela "/"
	// QueryParam,ou Query String é o conjunto que setamos na URL . ?Chave=Valor
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
			return operacao.soma(numberOne, numberTwo);
	}
	
	@RequestMapping(value = "/multi/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplicar(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
			return operacao.multiplicacao(numberOne, numberTwo);
	}
	
	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double dividir(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
			return operacao.divisao(numberOne, numberTwo);
	}
	
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sub(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
			return operacao.substracao(numberOne, numberTwo);
	}
	
	@RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double media(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
		return operacao.media(numberOne, numberTwo);
	}
	
	@RequestMapping(value = "/raiz/{numberOne}", method = RequestMethod.GET)
	public Double raizQuadrada(@PathVariable(value = "numberOne") String numberOne) {
		return operacao.raiz(numberOne);
	}
	
	@RequestMapping(value = "/pot/{numberOne}", method = RequestMethod.GET)
	public Double potencia(@PathVariable(value = "numberOne") String numberOne) {
	return operacao.potencia(numberOne);
	}

	
}
