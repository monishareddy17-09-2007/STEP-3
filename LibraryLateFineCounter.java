import java.util.Scanner;

abstract class LibraryItem {
    String title;
    int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double fine();
}

class FineBook extends LibraryItem {
    FineBook(String title, int daysLate) {
        super(title, daysLate);
    }

    double fine() {
        return daysLate * 2.0;
    }
}

class FineDVD extends LibraryItem {
    FineDVD(String title, int daysLate) {
        super(title, daysLate);
    }

    double fine() {
        return Math.min(daysLate * 5.0, 50.0);
    }
}

class FineMagazine extends LibraryItem {
    FineMagazine(String title, int daysLate) {
        super(title, daysLate);
    }

    double fine() {
        return daysLate * 1.0;
    }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        LibraryItem[] items = new LibraryItem[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int days = sc.nextInt();

            if (type.equals("BOOK")) {
                items[i] = new FineBook(title, days);
            } else if (type.equals("DVD")) {
                items[i] = new FineDVD(title, days);
            } else if (type.equals("MAGAZINE")) {
                items[i] = new FineMagazine(title, days);
            }
        }

        for (LibraryItem item : items) {
            double amount = item.fine();
            System.out.printf("%s: %.2f%n", item.title, amount);
            total += amount;
        }

        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}