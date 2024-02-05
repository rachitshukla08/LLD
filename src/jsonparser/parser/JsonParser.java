package jsonparser.parser;

import jsonparser.data.JSON;

public interface JsonParser {
    JSON parse(String jsonString);
    String toString(JSON json);
}
