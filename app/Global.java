import chatEngine.ChatEngine;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.Play;
import play.cache.Cache;
import service.ChatService;
import service.SessionResolverLocal;

public class Global extends GlobalSettings {
    @Override
    public void onStart(Application application) {
        super.onStart(application);
        Logger.info("Application has started");
        String configFile = Play.application().configuration().getString("chatEngine.configFile");
        String libPath = Play.application().configuration().getString("chatEngine.libPath");
        ChatEngine chatEngine = new ChatEngine(configFile, libPath);
        Cache.set("chatService", new ChatService(chatEngine));
        Cache.set("sessionResolver", new SessionResolverLocal());
    }

    @Override
    public void onStop(Application application) {
        Logger.info("Application shutdown...");
        super.onStop(application);
    }
}
