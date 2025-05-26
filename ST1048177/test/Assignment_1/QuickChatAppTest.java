/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Assignment_1;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
public class QuickChatAppTest {

    @Test
    public void testGenerateMessageId() {
        QuickChatApp app = new QuickChatApp();
        String id1 = app.generateMessageId();
        String id2 = app.generateMessageId();
        
        assertNotNull(id1);
        assertEquals(10, id1.length());
        assertNotEquals(id1, id2);
        
       
        assertDoesNotThrow(() -> Long.parseLong(id1));
    }

    @Test
    public void testGetMessageStatus() {
        QuickChatApp app = new QuickChatApp();
        Message message = new Message("1", 1, "+1", "Test");
        
        assertEquals("PENDING", app.getMessageStatus(message));
        
        message.setSent(true);
        assertEquals("SENT", app.getMessageStatus(message));
        
        message.setReceived(true);
        assertEquals("RECEIVED", app.getMessageStatus(message));
        
        message.setRead(true);
        assertEquals("READ", app.getMessageStatus(message));
    }

    @Test
    public void testPrintRecentMessagesEmpty() {
        QuickChatApp app = new QuickChatApp();
        
        app.printRecentMessages();
    }

    @Test
    public void testPrintRecentMessagesWithContent() {
        QuickChatApp app = new QuickChatApp();
        app.messages.add(new Message("1", 1, "+123", "Short message"));
        app.messages.add(new Message("2", 2, "+456", "This is a longer message that should be truncated"));
        
        
        app.printRecentMessages();
    }

    @Test
    public void testGetTotalMessagesSent() {
        QuickChatApp app = new QuickChatApp();
        assertEquals(0, app.getTotalMessagesSent());
        
        app.returnTotalMessagesSent = 5;
        assertEquals(5, app.getTotalMessagesSent());
    }

    
}
