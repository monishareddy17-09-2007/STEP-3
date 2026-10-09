import java.util.Scanner;

abstract class Travel {
    double distance;
    static final double BOOKING_FEE = 50.0;

    Travel(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    double calculateTotal() {
        return calculateFare() + BOOKING_FEE;
    }
}

class BusBooking extends Travel {
    BusBooking(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 2.0;
    }
}

class TrainBooking extends Travel {
    TrainBooking(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 1.5;
    }
}

class FlightBooking extends Travel {
    FlightBooking(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 2500 + distance * 4.0;
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Travel[] bookings = new Travel[n];
        String[] modes = new String[n];

        for (int i = 0; i < n; i++) {
            modes[i] = sc.next();
            double distance = sc.nextDouble();

            if (modes[i].equals("BUS")) {
                bookings[i] = new BusBooking(distance);
            } else if (modes[i].equals("TRAIN")) {
                bookings[i] = new TrainBooking(distance);
            } else if (modes[i].equals("FLIGHT")) {
                bookings[i] = new FlightBooking(distance);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("%s: %.2f%n",
                    modes[i], bookings[i].calculateTotal());
        }

        sc.close();
    }
}