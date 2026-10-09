import java.util.Scanner;

abstract class GardenShape {
    String owner;

    GardenShape(String owner) {
        this.owner = owner;
    }

    abstract double area();
    abstract String shapeName();
}

class GardenCircle extends GardenShape {
    double radius;

    GardenCircle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }

    String shapeName() {
        return "CIRCLE";
    }
}

class GardenRectangle extends GardenShape {
    double length, width;

    GardenRectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double area() {
        return length * width;
    }

    String shapeName() {
        return "RECTANGLE";
    }
}

class GardenTriangle extends GardenShape {
    double base, height;

    GardenTriangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double area() {
        return 0.5 * base * height;
    }

    String shapeName() {
        return "TRIANGLE";
    }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        GardenShape[] plots = new GardenShape[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String owner = sc.next();

            if (type.equals("CIRCLE")) {
                plots[i] = new GardenCircle(owner, sc.nextDouble());
            } else if (type.equals("RECTANGLE")) {
                double l = sc.nextDouble();
                double w = sc.nextDouble();
                plots[i] = new GardenRectangle(owner, l, w);
            } else if (type.equals("TRIANGLE")) {
                double b = sc.nextDouble();
                double h = sc.nextDouble();
                plots[i] = new GardenTriangle(owner, b, h);
            }
        }

        for (GardenShape p : plots) {
            double a = p.area();
            System.out.printf("%s (%s): %.2f%n",
                    p.owner, p.shapeName(), a);
            total += a;
        }

        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}