package Webservice;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import Beans.*;

public class Translator  {

	public static String toJson(Etudiant a) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
		
		try {

			// Convert object to JSON string and pretty print
        	jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(a);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		}
		
		return jsonInString;
	}
	
	public static String toJsonLE(List<Etudiant> a) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
		
		try {

			// Convert object to JSON string and pretty print
        	jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(a);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		}
		
		return jsonInString;
	}
	
	
	public static String toJson(SeanceUV a) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
		
		try {

			// Convert object to JSON string and pretty print
        	jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(a);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		}
		
		return jsonInString;
	}
	
	public static String toJson(UV a) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
		
		try {

			// Convert object to JSON string and pretty print
        	jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(a);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		}
		
		return jsonInString;
	}

	public static String toJsonLS(List<SeanceUV> a) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
		
		try {

			// Convert object to JSON string and pretty print
        	jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(a);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		}
		
		return jsonInString;
	}
	
	public static String toJsonLU(List<UV> a) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
		
		try {

			// Convert object to JSON string and pretty print
        	jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(a);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		}
		
		return jsonInString;
	}
	
}
