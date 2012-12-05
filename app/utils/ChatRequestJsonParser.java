package utils;

import Domain.ChatRequest;
import org.codehaus.jackson.JsonNode;

import static com.google.common.base.Strings.nullToEmpty;

public class ChatRequestJsonParser {
    public static final String REQUEST_QUESTION_KEY = "question";
    public static final String REQUEST_CONTEXT_KEY = "context";

    public ChatRequest parse(JsonNode json) {
        String question = json.findPath(REQUEST_QUESTION_KEY).getTextValue();
        String context = json.findPath(REQUEST_CONTEXT_KEY).getTextValue();
        return new ChatRequest(nullToEmpty(question), nullToEmpty(context));
    }
}
