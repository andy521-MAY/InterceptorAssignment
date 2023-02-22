package interceptorAssignment;

// Define the Concrete Interceptor class for applying discount
public class DiscountInterceptor implements Interceptor {
    @Override
    public void intercept(RentalContext context) {
        Customer customer = context.getCustomer();
        double totalAmount = context.getTotalAmount();

        // Apply 10% discount for customers with more than 2 rentals
        if (customer.getRentals().size() > 2) {
            totalAmount *= 0.9;
            System.out.println("Applying 10% discount to rental statement total amount");
        }

        context.setTotalAmount(totalAmount);
    }
}
