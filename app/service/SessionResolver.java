package service;

public interface SessionResolver {
    void setNewContextToSession(String newContext);

    String getContextFromSession();
}
