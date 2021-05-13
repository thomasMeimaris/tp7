package question2;

public class SmsService implements MessagingService{

    @Override
    public String getMessageBody() {
        return "sms message";
    }

    @Override
    public String getServiceName() {
        return "SmsService";
    }
}
