package controllers;

import org.codehaus.jackson.JsonNode;
import play.cache.Cache;
import play.mvc.Controller;
import play.mvc.Result;
import service.ChatService;
import service.SessionResolver;
import views.html.index;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result chatWithEngine() {
        ChatService chatService = (ChatService) Cache.get("chatService");
        JsonNode requestJson = request().body().asJson();
        if (requestJson == null) {
            return badRequest("Expecting Json data");
        } else {
            JsonNode responseJsonNode = chatService.chatWithEngine(requestJson);
            return ok(responseJsonNode);
        }
    }

}