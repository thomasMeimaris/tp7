package question2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceLocatorTest {
    @Test
    public void testMessageService() {
        MessagingService service
                = ServiceLocator.getService("EmailService");
        String email = service.getMessageBody();
        assertEquals("email message", email);
        assertEquals(1, ServiceLocator.cache.getCacheSize());

        MessagingService smsService
                = ServiceLocator.getService("SMSService");
        String sms = smsService.getMessageBody();
        assertEquals("sms message", sms);
        assertEquals(2, ServiceLocator.cache.getCacheSize());

        MessagingService emailService
                = ServiceLocator.getService("EmailService");
        String newEmail = emailService.getMessageBody();
        assertEquals("email message", newEmail);
        assertEquals(2, ServiceLocator.cache.getCacheSize());
    }
}
