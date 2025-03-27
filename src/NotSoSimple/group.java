package NotSoSimple;

import java.util.ArrayList;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.List;
import java.util.ArrayList;

public class group {
    private String groupCode;
    private ConcurrentLinkedQueue<String> messages;

    public group(String code) {
        this.groupCode = code;
        messages = new ConcurrentLinkedQueue<>();
    }

    public String getGroupCode() {
        return groupCode;
    }

    public List<String> getMessages() {
        return new ArrayList<>(messages); // Convert queue to list
    }

    public void addMessage(String message) {
        messages.add(message);
    }
}

