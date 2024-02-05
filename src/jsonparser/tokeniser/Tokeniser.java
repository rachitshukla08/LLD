package jsonparser.tokeniser;

import jsonparser.data.KeyValuePair;

import java.util.List;

public interface Tokeniser {
    List<KeyValuePair> tokenise(String string);
}
