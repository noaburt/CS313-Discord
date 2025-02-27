package NotSoSimple;

import java.util.ArrayList;

public class group {

    private String groupCode;
    private ArrayList<String> messages;

    public group(String code) {
        this.groupCode = code;
        messages = new ArrayList<>();
    }
    public String getGroupCode() {
        return groupCode;
    }
    public ArrayList<String> getMessages() {
        return messages;
    }
    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }
    public void addMessage(String message) {
        messages.add(message);
    }

}
