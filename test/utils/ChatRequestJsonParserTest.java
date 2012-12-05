package utils;

import Domain.ChatRequest;
import org.codehaus.jackson.JsonNode;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ChatRequestJsonParserTest {
    @Test
    public void should_parse_json_request() throws IOException {
        JsonNode chatRequestJson = new JsonTestDataCreator().createChatRequestJson("question content", "context content");
        ChatRequest chatRequest = new ChatRequestJsonParser().parse(chatRequestJson);

        assertThat(chatRequest.getQuestion(), is("question content"));
        assertThat(chatRequest.getContext(), is("context content"));
    }

    @Test
    public void should_parse_json_request_although_field_is_empty() throws IOException {
        JsonNode chatRequestJson = new JsonTestDataCreator().createChatRequestJson(null, "context content");
        ChatRequest chatRequest = new ChatRequestJsonParser().parse(chatRequestJson);

        assertThat(chatRequest.getQuestion(), is(""));
        assertThat(chatRequest.getContext(), is("context content"));
    }
}


