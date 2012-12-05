package service;

import Domain.ChatEngineAnswer;

class ChatEngineResponseResolver {
    public static final String CONTEXT_CONTAINER = "<ChatStateContainer>";
    public static final String CONTEXT_CONTAINER_END = "</ChatStateContainer>";

    public ChatEngineAnswer getChatEngineResponse(String chatEngineAnswer) {
        int indexOfContext = chatEngineAnswer.indexOf(CONTEXT_CONTAINER);
        int indexOfContextEnd = chatEngineAnswer.indexOf(CONTEXT_CONTAINER_END);
        int startOfNewContext = indexOfContext + CONTEXT_CONTAINER.length();
        String newContext = chatEngineAnswer.substring(startOfNewContext, indexOfContextEnd);
        String answer = chatEngineAnswer.substring(0, indexOfContext);
        return new ChatEngineAnswer(answer, newContext);
    }
}
