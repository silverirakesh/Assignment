package com.framework.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class JsonConfigReader {
   	/**
	 * Reads a property value from a JSON configuration file.
	 *
	 * @param key      The key of the property to read.
	 * @param filePath The path to the JSON configuration file.
	 * @return The value of the property as a String, or null if an error occurs.
   	 * @throws IOException 
	 */
	public String getValueFromJson(File jsonFile, String key) throws IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(jsonFile);
		return rootNode.get(key).asText();
		
	}

	
	public String getNestedValueFromJson(File jsonFile, String parentKey, String childKey) throws IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(jsonFile);
		
		JsonNode parentNode = rootNode.get(parentKey);
		if (parentNode != null) {
			return parentNode.get(childKey).asText();
		}
		return null;
		
	}
	
}
	

	
	

