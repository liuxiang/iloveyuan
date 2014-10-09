package test;
import java.util.*;

public class Hello {
    private Map<String, String> messages;
    
    public Hello() {
        messages = new HashMap<String, String>();
        messages.put("caterpillar", "Hello");
        messages.put("Justin", "Welcome");
        messages.put("momor", "Hi");
    }

    public String doHello(String user) {
        String message = messages.get(user);
        return message + ", " + user + "!";
    }
}