package interceptorAssignment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {
  private String name;
  private List<Rental> rentals = new ArrayList<>();


  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental rental) {
    rentals.add(rental);
  }

  public String getName() {
    return name;
  }

  public String statement() {
    double totalAmount = 0;
    int frequentRenterPoints = 0;
    Iterator<Rental> iterator = rentals.iterator();
    String result = "Rental Record for " + getName() + "\n";
    while (iterator.hasNext()) {
      Rental rental = iterator.next();
      frequentRenterPoints += rental.getFrequentRenterPoints();
      result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";
      totalAmount += rental.getCharge();
    }
    result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
    result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
    return result;
  }

  public double getTotalAmount() {
    double totalAmount = 0;
    for (Rental rental : rentals) {
      totalAmount += rental.getCharge();
    }
    return totalAmount;
  }

  public List<Rental> getRentals() {
    return rentals;
  }
}