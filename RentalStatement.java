package interceptorAssignment;

import java.util.ArrayList;
import java.util.List;

public class RentalStatement {
    private Customer customer;
    private List<Interceptor> interceptors = new ArrayList<>();

    public RentalStatement(Customer customer) {
        this.customer = customer;
    }

    public void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }

    public String generate() {
        StringBuilder statementBuilder = new StringBuilder();

        RentalContext context = new RentalContext(customer);

        for (Interceptor interceptor : interceptors) {
            interceptor.intercept(context);
            if(interceptor instanceof DiscountInterceptor){
                statementBuilder.append("Applying 10% discount to rental statement total amount").append("\n");

            } else if (interceptor instanceof LoggingInterceptor) {
                statementBuilder.append("Logging customer name: " + customer.getName()).append("\n");
            }
        }

        statementBuilder.append("Rental statement for customer: ").append(customer.getName()).append("\n");
        statementBuilder.append("Total amount: $").append(context.getTotalAmount()).append("\n");
        statementBuilder.append("Rentals:\n");
        for (Rental rental : customer.getRentals()) {
            statementBuilder.append("- ").append(rental.getMovie().getTitle()).append(": $").append(rental.getCharge()).append("\n");
        }

        return statementBuilder.toString();
    }
}