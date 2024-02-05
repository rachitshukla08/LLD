package jsonparser.data;

public class KeyValuePair {
    private final String key;
    private final String val;

    public KeyValuePair(String key, String val) {
        this.key = key;
        this.val = val;
    }

    public String getKey() {
        return key;
    }

    public String getVal() {
        return val;
    }
}
