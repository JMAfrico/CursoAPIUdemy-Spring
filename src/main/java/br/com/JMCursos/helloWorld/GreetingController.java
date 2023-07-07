package br.com.JMCursos.helloWorld;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Camada controller da aplicação
@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private static AtomicLong counter = new AtomicLong();
	private static String data = "22/04/2023";

	//Query param ou query string
	@RequestMapping("/greeting")
	public Greeting greeting(
			@RequestParam(value = "name",defaultValue = "Word")
			String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
