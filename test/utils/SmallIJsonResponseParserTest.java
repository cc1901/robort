package utils;

import Domain.SmallIResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SmallIJsonResponseParserTest {
    @Test
    public void should_parse_small_i_json_response() {
        String sessionId = "session id";
        String result = "true";
        String responseMessage = "response message";

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("result", result);
        objectNode.put("sessionid", sessionId);
        objectNode.put("message", responseMessage);
        SmallIResponse smallIResponse = new SmallIJsonResponseParser().parse(objectNode);

        assertThat(smallIResponse.getResult(), is(result));
        assertThat(smallIResponse.getSessionId(), is(sessionId));
        assertThat(smallIResponse.getMessage(), is(responseMessage));
    }
}
