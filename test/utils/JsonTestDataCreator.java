package utils;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;

public class JsonTestDataCreator {
    public JsonNode createChatRequestJson(String questionContent, String contextContent) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("question", questionContent);
        objectNode.put("context", contextContent);
        return objectNode;
    }
}
