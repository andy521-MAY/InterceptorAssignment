package interceptorAssignment;

// Define the Concrete Interceptor class
public class LoggingInterceptor implements Interceptor {
    @Override
    public void intercept(RentalContext context) {
        Customer customer = context.getCustomer();
        System.out.println("Logging customer name: " + customer.getName());
    }
}
