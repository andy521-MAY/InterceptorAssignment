package interceptorAssignment;

// Define the Context Object class
public class RentalContext {
    private Customer customer;
    private double totalAmount;

    public RentalContext(Customer customer) {
        this.customer = customer;
        this.totalAmount = customer.getTotalAmount();
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}