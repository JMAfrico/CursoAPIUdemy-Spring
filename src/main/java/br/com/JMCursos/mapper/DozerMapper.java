package br.com.JMCursos.mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

//Classe para converter o PersonVO para Person, pois quando o service chamar do repository, apresentar somente os dados
//que fazem sentido para a transação, com o intuito de apresentar somente os dados necessários na chamada
public class DozerMapper {

	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	public static <O,D> D parseObject(O origin, Class<D> destination){
		return mapper.map(origin, destination);
	}
	
	public static <O,D> List<D> parseListObject(List<O> origin, Class<D> destination){
		List<D> destinationObjects = new ArrayList<D>();
		for (O o : origin) {
			destinationObjects.add(mapper.map(o, destination));
		}
		return destinationObjects;
	}
}
