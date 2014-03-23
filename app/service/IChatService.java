package service;

import org.codehaus.jackson.JsonNode;

public interface IChatService {
    public JsonNode chatWithEngine(JsonNode requestJson);
}
