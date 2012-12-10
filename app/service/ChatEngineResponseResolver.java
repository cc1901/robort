package service;

import Domain.ChatEngineAnswer;

class ChatEngineResponseResolver {
    public static final String CONTEXT_CONTAINER = "<ChatStateContainer>";
    public static final String CONTEXT_CONTAINER_END = "</ChatStateContainer>";

    public ChatEngineAnswer getChatEngineResponse(String chatEngineAnswer) {
        if (chatEngineAnswer.contains(CONTEXT_CONTAINER)) {
            return new ChatEngineAnswer(chatEngineAnswer, "");
        }
        int indexOfContext = chatEngineAnswer.indexOf(CONTEXT_CONTAINER);
        String newContext = chatEngineAnswer.substring(indexOfContext);
        String answer = chatEngineAnswer.substring(0, indexOfContext);
        return new ChatEngineAnswer(answer, newContext);
    }
}
