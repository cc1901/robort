package Domain;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;
import play.libs.Json;

public class ChatEngineAnswer {
    private String answer;
    private String context;

    public ChatEngineAnswer(String answer, String context) {
        this.answer = answer;
        this.context = context;
    }

    public JsonNode getChatResponse() {
        ObjectNode jsonNodes = Json.newObject();
        jsonNodes.put("answer", answer);
        jsonNodes.put("context", context);
        return jsonNodes;
    }
}
