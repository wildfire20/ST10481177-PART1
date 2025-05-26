package Assignment_1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_Lub
 */

import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Message {
    private String messageId;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private boolean sent;
    private boolean received;
    private boolean read;

    public Message(String messageId, int messageNumber, String recipient, String messageText) {
        this.messageId = messageId;
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.sent = false;
        this.received = false;
        this.read = false;
    }

    public static boolean checkRecipientCell(String cellNumber) {
        return cellNumber != null && cellNumber.matches("^\\d{1,3}\\d{1,10}$") && cellNumber.length() <= 13;
    }

    public String createMessageHash() {
        String[] words = messageText.split("\\s+");
        
        //take the first and last words to creat the hash
        String firstWord = words.length > 0 ? words[0] : "";
        String lastWord = words.length > 0 ? words[words.length - 1] : "";
        
        //take first 2 chars for ID
        String firstTwoDigits = messageId.substring(0, Math.min(2, messageId.length()));
        return String.format("%s:%d:%s%s", 
            firstTwoDigits, 
            messageNumber, 
            firstWord.toUpperCase(), 
            lastWord.toUpperCase()
        );
    }

    public void storeMessage() {
        JSONObject messageJson = new JSONObject();
        messageJson.put("messageId", messageId);
        messageJson.put("messageNumber", messageNumber);
          messageJson.put("recipient", recipient);
          messageJson.put("messageText", messageText);
          messageJson.put("sent", sent);
        messageJson.put("received", received);
        messageJson.put("read", read);
        
        try (FileWriter file = new FileWriter("messages.json", true)) {
               file.write(messageJson.toString() + "\n");
               
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getters and Setters
    public String getMessageId() { return messageId; }
    public int getMessageNumber() { return messageNumber; }
    public String getRecipient() { return recipient; }
    public String getMessageText() { return messageText; }
    public boolean isSent() { return sent; }
    public boolean isReceived() { return received; }
    public boolean isRead() { return read; }
    public void setSent(boolean sent) { this.sent = sent; }
    public void setReceived(boolean received) { this.received = received; }
    public void setRead(boolean read) { this.read = read; }

public static boolean checkMessageLength(String message) {
    if (message == null) return false;
    return message.length() <= 250;
}

public String getMessageLengthError() {
    if (messageText.length() > 250) {
        int excess = messageText.length() - 250;
        return String.format(
            "Message exceeds 250 characters by %d, please reduce size.",
            excess
        );
    }
    return "Message ready to send.";
}//message
    }

