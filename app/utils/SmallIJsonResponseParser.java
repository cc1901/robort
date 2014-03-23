package utils;

import Domain.SmallIResponse;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class SmallIJsonResponseParser {

    public SmallIResponse parse(JsonNode jsonNodes) {
        ObjectMapper objectMapper = new ObjectMapper();
        SmallIResponse smallIResponse = new SmallIResponse();
        try {
            smallIResponse = objectMapper.readValue(jsonNodes, SmallIResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return smallIResponse;
    }
}
