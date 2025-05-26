/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Assignment_1;


import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MessageTest {

    @Test
    public void testMessageConstructor() {
        Message message = new Message("123", 1, "+1234567890", "Hello World");
        
        assertEquals("123", message.getMessageId());
        assertEquals(1, message.getMessageNumber());
        assertEquals("+1234567890", message.getRecipient());
        assertEquals("Hello World", message.getMessageText());
        assertFalse(message.isSent());
        assertFalse(message.isReceived());
        assertFalse(message.isRead());
    }

    @Test
    public void testCheckRecipientCellValid() {
       
        assertFalse(Message.checkRecipientCell(null));
assertFalse(Message.checkRecipientCell(""));
assertFalse(Message.checkRecipientCell("abc123"));
assertFalse(Message.checkRecipientCell("+12-345"));
    }

    @Test
    public void testCheckRecipientCellInvalid() {
        assertFalse(Message.checkRecipientCell(null));
        assertFalse(Message.checkRecipientCell("+12345678901234")); 
        assertFalse(Message.checkRecipientCell("abc"));
    }

    @Test
    public void testCreateMessageHash() {
        Message message = new Message("12345", 1, "+1234567890", "Hello World");
        String hash = message.createMessageHash();
        assertEquals("12:1:HELLOWORLD", hash);
        
        
        Message emptyMessage = new Message("12", 2, "+123", "");
        assertEquals("12:2:", emptyMessage.createMessageHash());
    }

    @Test
    public void testStoreMessage() throws IOException {
        
        Files.deleteIfExists(Paths.get("messages.json"));
        
        Message message = new Message("123", 1, "+123", "Test");
        message.storeMessage();
        
       
        String content = Files.readString(Paths.get("messages.json"));
        assertTrue(content.contains("\"messageId\":\"123\""));
        assertTrue(content.contains("\"messageText\":\"Test\""));
    }

    @Test
    public void testCheckMessageLength() {
        assertTrue(Message.checkMessageLength("a".repeat(250)));
        assertFalse(Message.checkMessageLength("a".repeat(251)));
        assertFalse(Message.checkMessageLength(null));
    }

    @Test
    public void testMessageLengthError() {
        Message shortMessage = new Message("1", 1, "+1", "Short");
        assertEquals("Message ready to send.", shortMessage.getMessageLengthError());
        
        Message longMessage = new Message("1", 1, "+1", "a".repeat(251));
        assertTrue(longMessage.getMessageLengthError().contains("exceeds 250 characters"));
    }

    @Test
    public void testSetters() {
        Message message = new Message("1", 1, "+1", "Test");
        
        message.setSent(true);
        assertTrue(message.isSent());
        
        message.setReceived(true);
        assertTrue(message.isReceived());
        
        message.setRead(true);
        assertTrue(message.isRead());
    }
}

