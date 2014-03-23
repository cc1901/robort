package Domain;

import org.codehaus.jackson.annotate.JsonProperty;

public class SmallIResponse {
    @JsonProperty("result")
    private String result;

    @JsonProperty("sessionid")
    private String sessionId;

    @JsonProperty("message")
    private String message;

    public String getResult() {
        return result;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getMessage() {
        return message;
    }
}
