package Assignment_1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_Lub
 */

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickChatApp {
    List<Message> messages = new ArrayList<>();//stores all messages
    int returnTotalMessagesSent = 0;
    private int totalMessagesSent;
    private Message validMessage;
    

    public void startApplication() {
        JOptionPane.showMessageDialog(null, "Welcome to QuickChat.");
        
        boolean appRunning = true;
        while (appRunning) {
            String input = JOptionPane.showInputDialog(
                "Choose an option:\n" +
                "1) Send Messages\n" +
                "2) Show recently sent messages\n" +
                "3) Quit"
            );
            
            if (input == null) {
                appRunning = false; // exit
                continue;
            }
            
            try {
                int optionChosen = Integer.parseInt(input);
                switch (optionChosen) {
                    case 1:
                        sendMessages();
                    break;
                    case 2:
                          JOptionPane.showMessageDialog(null, "Coming Soon.");
                          
                        break;

                    case 3:
                        appRunning = false;
                            break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
        
        JOptionPane.showMessageDialog(null, "Total messages sent: " + returnTotalMessagesSent);
    }
    
    private void sendMessages() {
        String numMessagesStr = JOptionPane.showInputDialog("How many messages do you want to send?");
        try {
            int numMessages = Integer.parseInt(numMessagesStr);
            for (int i = 0; i < numMessages; i++) {
                Message message = createMessage(i + 1, validMessage);
                if (message != null) {
                    message.setSent(true);
                    messages.add(message);
                    returnTotalMessagesSent++;
                    
                    
                    
                    displayMessageDetails(message);// WILL SHOW MESSAGE DETAILS
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number.");
        }
    }
    
    private Message createMessage(int messageNumber, Message validMessage) {
        String recipient = JOptionPane.showInputDialog("Enter recipient cell number (with international code):");
            if (recipient == null || !Message.checkRecipientCell(recipient)) {
                
                JOptionPane.showMessageDialog(null, "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.");
            return null;
        }else {JOptionPane.showMessageDialog(null,"Cellphone number successfully captured");
            }
        
            
        String messageText = JOptionPane.showInputDialog("Enter your message (max 250 chars):");
            if (messageText == null || messageText.length() > 250) {
                JOptionPane.showMessageDialog(null, "Message too long. Max 250 characters allowed.");
                 return null;
        }
        
        String messageId = generateMessageId();
Message message = new Message(messageId, messageNumber, recipient, messageText);

String action = JOptionPane.showInputDialog(
    "Message Details:\n" +
    "ID: " + messageId + "\n" +
    "Hash: " + message.createMessageHash() + "\n\n" +
    "Choose an action:\n" +
    "1) Send Message\n" +
    "2) Disregard Message\n" +  // Modified option text
    "3) Store Message to send later"
);

if (action == null) {
    return null;
} else if (action.equals("2")) {
    // Handle disregard/delete option
    String deleteChoice = JOptionPane.showInputDialog(
        "Press 0 to delete this message\n"
    );
    
    if (deleteChoice != null && deleteChoice.equals("0")) {
        JOptionPane.showMessageDialog(null, "Message deleted");
        return null;  // Return null to indicate deletion
    } else {
        JOptionPane.showMessageDialog(null, "Message kept (not sent)");
        return null;  // Return null to indicate disregard without deletion
    }
} else if (action.equals("3")) {
    // Store message logic
    message.storeMessage();
    JOptionPane.showMessageDialog(null,
        "Message successfully stored:\n" +
        "ID: " + messageId + "\n" +
        "Hash: " + message.createMessageHash() + "\n" +
        "Recipient: " + recipient);
    return null;
} else if (action.equals("1")) {
    return message;  // Return message for sending
}

return null;  // Default return for invalid options

}
       
    
    
public int getTotalMessagesSent() {
    return returnTotalMessagesSent;
}//chat
    
    void printRecentMessages() {
        if (messages.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No messages sent yet.");
            return;
        }
        
        
        
        
        
             StringBuilder sb = new StringBuilder("Recently sent messages:\n");
        for (Message msg : messages) {
            sb.append(String.format(
                "To: %s | Message: %s (ID: %s)\n",
                msg.getRecipient(),
                msg.getMessageText().length() > 20 ? 
                    msg.getMessageText().substring(0, 17) + "..." : 
                    msg.getMessageText(),
                
                 msg.getMessageId()
            ));
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
    //message ID
    public String generateMessageId() {
        Random random = new Random();
        long id = 1000000000L + random.nextInt(900000000);
          return String.valueOf(id);
    }
    //WILL SHOW MESSAGE DITAILS
    private void displayMessageDetails(Message message) {
        String details = String.format(
    "=== Message Sent Successfully ===\n" +
            "Message ID: %s\n" +
            "Message Hash: %s\n" +
            "Recipient: %s\n" +
            //"Message: %s\n" +
            //"Status: %s",
               message.getMessageId(),
               message.createMessageHash(),
               message.getRecipient(),
               message.getMessageText(), 
               getMessageStatus(message)
            );
        
        JOptionPane.showMessageDialog(null, details);
    }
   //part 3 
   public String getMessageStatus(Message message) {
        if (message.isRead()) return "READ";
       else if (message.isReceived()) return "RECEIVED";
       else if (message.isSent()) return "SENT";
        return "PENDING";
    
}

    String processUserSelection(int i, Message message1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    }

