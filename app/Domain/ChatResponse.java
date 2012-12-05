package Domain;

import org.codehaus.jackson.JsonNode;

public class ChatResponse {
    public JsonNode responseJsonNode;

    public ChatResponse(JsonNode responseJsonNode) {
        this.responseJsonNode = responseJsonNode;
    }

    public JsonNode getResponseJsonNode() {
        return responseJsonNode;
    }

}
