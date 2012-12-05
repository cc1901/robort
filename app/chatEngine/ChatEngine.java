package chatEngine;


import play.Logger;

public class ChatEngine implements ChatEngineInterface {
    private static String configFile;
    private String jniLibPath;

    public ChatEngine(String configFile, String jniLibPath) {
        ChatEngine.configFile = configFile;
        this.jniLibPath = jniLibPath;
        loadJniLib();
    }

    private void loadJniLib() {
        try {
            System.load(jniLibPath);
        } catch (Exception e) {
            System.out.println(e);
        }
//        System.load("/Users/twer/homeideas/Spring-Session/springWeb/src/main/java/libChatEngine.jnilib");
    }

    public static String configFile() {
        return ChatEngine.configFile;
    }

    private native String chat(String text, String context);

    public static void main(String[] args) {
        new ChatEngine("test...", "libpath").chat("", "");
    }

    public String chatWithEngine(String question, String context) {
        Logger.debug(question + "++++++++++++++++++++");
        Logger.debug(context + "++++++++++++++++++++");
        return chat(question, context);
    }
}
