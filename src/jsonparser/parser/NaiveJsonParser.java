package jsonparser.parser;

import jsonparser.data.JSON;
import jsonparser.data.KeyValuePair;
import jsonparser.tokeniser.Tokeniser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NaiveJsonParser implements JsonParser{
    private final Tokeniser tokeniser;

    public NaiveJsonParser(Tokeniser tokeniser) {
        this.tokeniser = tokeniser;
    }

    @Override
    public JSON parse(String jsonText) {
        if(jsonText == null)
            throw new RuntimeException("Invalid json");
        if(!jsonText.contains("{")){
            
        }
        List<KeyValuePair> keyValuePairs = this.tokeniser.tokenise(jsonText);
        Map<String, JSON> keyToValues = new HashMap<>();
        for(KeyValuePair keyValuePair: keyValuePairs){
            keyToValues.put(keyValuePair.getKey(), parse(keyValuePair.getVal()));
        }
        return new JSON(keyToValues);
    }

    @Override
    public String toString(JSON json) {
        return null;
    }
}
