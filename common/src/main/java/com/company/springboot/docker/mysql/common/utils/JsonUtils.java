package com.company.springboot.docker.mysql.common.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Objects;

public enum JsonUtils {
	;
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
	
	public static <T> T fromJson(String json, TypeReference<T> typeReference) {
		try {
			return readJson(json, typeReference);
		} catch (Exception e) {
			throw new RuntimeException("failed parsing from " + json + " with type " + typeReference.toString(), e);
		}
	}
	
	
	public static <T> T fromJson(String json, Class<T> clazz) {
		try {
			return readJson(json, clazz);
		} catch (Exception e) {
			throw new RuntimeException("failed parsing from " + json + " to class " + clazz.getSimpleName(), e);
		}
	}
	
	
	public static String toJson(Object object) {
		try {
			return writeJson(object);
		} catch (Exception e) {
			throw new RuntimeException("failed parsing object " + Objects.toString(object) , e);
		}
	}
	
	/**
	 * Parse the given JSON string if not {@code null} / empty
	 * 
	 * @param json - The JSON string, ignore if {@code null} / empty
	 * @param typeReference - The expected object {@link TypeReference}, never {@code null} 
	 * @return The parse object or {@code null}
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	public static <T> T readJson(String json, TypeReference<T> typeReference) throws JsonProcessingException, IOException{
		if(StringUtils.isBlank( json )){
		   return null;	
		}
		
		ObjectReader reader = mapper.reader(typeReference);
		return reader.readValue( json );
	}

	
	public static <T> T readJson(String json, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
		if (StringUtils.isBlank( json )) {
			return null;
		}

		return mapper.readValue(json, clazz);
	}
	
	/**
	 * Convert the object to JSON string 
	 *  
	 * @param object - The object to convert - ignore if {@code null}
	 * @param prettyPrint - indicates if serialised object should be pretty printed
	 * @return The JSON of object
	 * @throws JsonProcessingException
	 */
	public static String writeJson(Object object, boolean prettyPrint) throws JsonProcessingException{
		if(object == null){
			return null;
		}
		
		if(prettyPrint){
		   return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);	
		}
		
		return mapper.writeValueAsString(object);
	}
	
	
	public static String writeJson(Object object) throws JsonProcessingException{
		return writeJson(object, false);
	}
	
	public static ObjectMapper getMapper() {
		return mapper;
	}
	
}
