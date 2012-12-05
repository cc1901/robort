package service;

import Domain.ChatEngineAnswer;
import Domain.ChatRequest;
import Domain.ChatResponse;
import chatEngine.ChatEngine;
import org.codehaus.jackson.JsonNode;
import org.junit.Test;
import play.Logger;
import utils.JsonTestDataCreator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ChatServiceTest {
    @Test
    public void should_chat_with_chat_engine() {
        String answer = "answer<ChatStateContainer>new context</ChatStateContainer>";
        String context = "context";
        String question = "question";
        ChatEngine chatEngine = createChatEngine(answer, context, question);
        JsonNode chatRequestJson = new JsonTestDataCreator().createChatRequestJson(question, "context");
        JsonNode chatResponse = new ChatService(chatEngine).chatWithEngine(chatRequestJson);

        assertThat(chatResponse.findPath("answer").getTextValue(), is("answer"));
        assertThat(chatResponse.findPath("context").getTextValue(), is("new context"));
    }

    private ChatEngine createChatEngine(String answer, String context, String question) {
        ChatEngine chatEngine = mock(ChatEngine.class);
        when(chatEngine.chatWithEngine(question, context)).thenReturn(answer);
        return chatEngine;
    }
}
