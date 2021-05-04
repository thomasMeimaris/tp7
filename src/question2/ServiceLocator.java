package question2;

public class ServiceLocator {

    public static Cache cache = new Cache();

    public static MessagingService getService(String serviceName) {

        MessagingService service = cache.getService(serviceName);

        if (service != null) {
            return service;
        }

        InitialContext context = new InitialContext();
        service = (MessagingService) context
                .lookup(serviceName);
        cache.addService(service);
        return service;
    }
}
