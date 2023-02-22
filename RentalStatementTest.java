package interceptorAssignment;

import interceptorAssignment.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RentalStatementTest {

    @Test
    public void testGenerateStatement() {
        // Create customer
        Customer customer = new Customer("John Doe");

        // Add rentals
        Movie newReleaseMovie = new Movie("The Matrix", Movie.NEW_RELEASE);
        Rental rental1 = new Rental(newReleaseMovie, 2);
        customer.addRental(rental1);

        Movie childrenMovie = new Movie("The Lion King", Movie.NEW_RELEASE);
        Rental rental2 = new Rental(childrenMovie, 3);
        customer.addRental(rental2);

        Movie regular = new Movie("Titanic", Movie.NEW_RELEASE);
        Rental rental3 = new Rental(regular, 3);
        customer.addRental(rental3);

        // Create rental statement
        RentalContext rentalContext = new RentalContext(customer);

        Interceptor discountInterceptor = new DiscountInterceptor();
        Interceptor loggingInterceptor = new LoggingInterceptor();


        RentalStatement rentalStatement = new RentalStatement(customer);
        // Add interceptors
        rentalStatement.addInterceptor(discountInterceptor);
        rentalStatement.addInterceptor(loggingInterceptor);

        // Generate statement
        System.out.println(rentalStatement.generate());
       String  actualStatement =rentalStatement.generate();


        // Verify statement
        String expectedStatement = "Applying 10% discount to rental statement total amount\n" +
                "Logging customer name: John Doe\n" +
                "Rental statement for customer: John Doe\n" +
                "Total amount: $21.6\n" +
                "Rentals:\n" +
                "- The Matrix: $6.0\n" +
                "- The Lion King: $9.0\n" +
                "- Titanic: $9.0\n";

        assertEquals(expectedStatement, actualStatement);
    }
}