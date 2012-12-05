package service;

import Domain.ChatEngineAnswer;
import Domain.ChatRequest;
import chatEngine.ChatEngine;
import org.codehaus.jackson.JsonNode;
import play.Logger;
import utils.ChatRequestJsonParser;

public class ChatService {
    private ChatEngine chatEngine;
    private ChatRequestJsonParser chatRequestJsonParser;
    private ChatEngineResponseResolver chatEngineResponseResolver;


    public ChatService(ChatEngine chatEngine) {
        this.chatEngine = chatEngine;
        chatRequestJsonParser = new ChatRequestJsonParser();
        chatEngineResponseResolver = new ChatEngineResponseResolver();
    }

    public JsonNode chatWithEngine(JsonNode requestJson) {
        ChatRequest chatRequest = chatRequestJsonParser.parse(requestJson);
        Logger.info(chatRequest.getQuestion() + "--------------------");
        Logger.info(chatRequest.getContext() + "--------------------");
        String chatEngineAnswer = chatEngine.chatWithEngine(chatRequest.getQuestion(), chatRequest.getContext());
        ChatEngineAnswer chatEngineResponse = chatEngineResponseResolver.getChatEngineResponse(chatEngineAnswer);
        return chatEngineResponse.getChatResponse();
    }

}
