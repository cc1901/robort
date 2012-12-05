package Domain;

public class ChatRequest {
    private final String question;
    private final String context;

    public ChatRequest(String question, String context) {
        this.question = question;
        this.context = context;
    }

    public String getQuestion() {
        return question;
    }

    public String getContext() {
        return context;
    }
}
