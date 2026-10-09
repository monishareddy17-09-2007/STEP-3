import java.util.Scanner;

abstract class StaffMember {
    String name;

    StaffMember(String name) {
        this.name = name;
    }

    abstract double pay();
}

class PermanentStaff extends StaffMember {
    double salary;

    PermanentStaff(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    double pay() {
        return salary;
    }
}

class HourlyStaff extends StaffMember {
    double hours, rate;

    HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double pay() {
        if (hours <= 40) {
            return hours * rate;
        }
        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class InternStaff extends StaffMember {
    double stipend;

    InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double pay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StaffMember[] employees = new StaffMember[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            if (type.equals("FULLTIME")) {
                employees[i] =
                    new PermanentStaff(name, sc.nextDouble());
            } else if (type.equals("HOURLY")) {
                double hours = sc.nextDouble();
                double rate = sc.nextDouble();
                employees[i] = new HourlyStaff(name, hours, rate);
            } else if (type.equals("INTERN")) {
                employees[i] =
                    new InternStaff(name, sc.nextDouble());
            }
        }

        for (StaffMember s : employees) {
            double amount = s.pay();
            System.out.printf("%s: %.2f%n", s.name, amount);
            total += amount;
        }

        System.out.printf("Total Payroll: %.2f%n", total);
        sc.close();
    }
}