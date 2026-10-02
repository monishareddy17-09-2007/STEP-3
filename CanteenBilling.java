import java.util.*;

abstract class CanteenCustomer {
    protected double amount;

    CanteenCustomer(double amount) {
        this.amount = amount;
    }

    abstract double calculateAmount();

    abstract String getType();
}

class StudentCustomer extends CanteenCustomer {
    StudentCustomer(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount - (amount * 0.10);
    }

    String getType() {
        return "STUDENT";
    }
}

class StaffCustomer extends CanteenCustomer {
    StaffCustomer(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount - (amount * 0.05);
    }

    String getType() {
        return "STAFF";
    }
}

class GuestCustomer extends CanteenCustomer {
    GuestCustomer(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount + 10;
    }

    String getType() {
        return "GUEST";
    }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            CanteenCustomer customer;

            if (type.equals("STUDENT"))
                customer = new StudentCustomer(amount);
            else if (type.equals("STAFF"))
                customer = new StaffCustomer(amount);
            else
                customer = new GuestCustomer(amount);

            double finalAmount = customer.calculateAmount();

            System.out.printf("%s: %.2f%n",
                    customer.getType(), finalAmount);

            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}