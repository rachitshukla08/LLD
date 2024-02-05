package jsonparser.data;

import java.util.Map;

public class JSON {
    private final Map<String, JSON> keyToValues;

    public JSON(Map<String, JSON> keyToValues) {
        this.keyToValues = keyToValues;
    }

    public JSON get(String key) {
        return this.keyToValues.get(key);
    }
}
