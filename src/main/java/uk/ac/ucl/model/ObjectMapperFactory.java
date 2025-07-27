package uk.ac.ucl.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ObjectMapperFactory {
// Provides access to the ObjectMapper object, of which there must only be one throughout the program
private static ObjectMapper mapper;

public static ObjectMapper getMapper() {
    if (mapper == null) {
        mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);  // For prettier formatting and indentation
    }
    return mapper;
}
}

