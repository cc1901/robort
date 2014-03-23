package service;

import Domain.ChatEngineAnswer;
import Domain.ChatRequest;
import chatEngine.ChatEngine;
import chatEngine.SmallIChatEngine;
import org.codehaus.jackson.JsonNode;
import play.Logger;
import utils.ChatRequestJsonParser;

public class SmallIChatService implements IChatService {
    private ChatEngine chatEngine;
    private SmallIChatEngine smallIChatEngine;
    private ChatRequestJsonParser chatRequestJsonParser;
    private ChatEngineResponseResolver chatEngineResponseResolver;


    public SmallIChatService(ChatEngine chatEngine, SmallIChatEngine smallIChatEngine) {
        this.chatEngine = chatEngine;
        this.smallIChatEngine = smallIChatEngine;
        chatRequestJsonParser = new ChatRequestJsonParser();
        chatEngineResponseResolver = new ChatEngineResponseResolver();
    }

    @Override
    public JsonNode chatWithEngine(JsonNode requestJson) {
        ChatRequest chatRequest = chatRequestJsonParser.parse(requestJson);
        Logger.info(chatRequest.getQuestion() + "--------------------");
        Logger.info(chatRequest.getContext() + "--------------------");
        String chatEngineAnswer = chatEngine.chatWithEngine(chatRequest.getQuestion(), chatRequest.getContext());
        ChatEngineAnswer chatEngineResponse = chatEngineResponseResolver.getChatEngineResponse(chatEngineAnswer);
        if (chatEngineResponse.getChatResponse().get("answer").equals("")) {
            String answer = smallIChatEngine.chatWithEngine(chatRequest.getQuestion(), chatRequest.getContext());
        }
        return null;
    }
}
