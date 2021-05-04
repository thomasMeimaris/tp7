package question2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cache {
    private List<MessagingService> services = new ArrayList<>();

    public MessagingService getService(String serviceName) {
        Iterator e = services.iterator();
        while(e.hasNext()) {
            MessagingService messagingService = (MessagingService) e.next();
            if(messagingService.getServiceName() == serviceName) {
                return messagingService;
            }
        }
        return null;
    }

    public void addService(MessagingService newService) {
        services.add(newService);
    }

    public int getCacheSize() {
        return services.size();
    }
}
