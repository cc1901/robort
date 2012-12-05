package service;

import play.mvc.Controller;

public class SessionResolverLocal implements SessionResolver {
    @Override
    public void setNewContextToSession(String newContext) {
        Controller.session("context", newContext);
    }

    @Override
    public String getContextFromSession() {
        return Controller.session("context");
    }
}
