import java.util.Scanner;

class Shapes {
    double area;

    Shapes() { this.area = 0; }

    Shapes(double side) { this.area = side * side; }

    void calculateArea(double r) {
        System.out.println("Circle Area (r=" + r + "): " + (3.14 * r * r));
    }

    void calculateArea(double l, double w) {
        System.out.println("Rectangle Area (" + l + "x" + w + "): " + (l * w));
    }

    void calculateArea(double a, double b, double c) {
        double s = (a + b + c) / 2;
        System.out.println("Triangle Area (" + a + "," + b + "," + c + "): " + Math.sqrt(s*(s-a)*(s-b)*(s-c)));
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shapes obj = new Shapes();
        int ch;

        do {
            System.out.println("\n1.Square  2.Circle  3.Rectangle  4.Triangle  5.Exit");
            System.out.print("Choice: ");
            ch = sc.nextInt();

            if (ch == 1) {
                System.out.print("Side: ");
                Shapes sq = new Shapes(sc.nextDouble());
                System.out.println("Square Area: " + sq.area);
            } else if (ch == 2) {
                System.out.print("Radius: ");
                obj.calculateArea(sc.nextDouble());
            } else if (ch == 3) {
                System.out.print("Length & Width: ");
                obj.calculateArea(sc.nextDouble(), sc.nextDouble());
            } else if (ch == 4) {
                System.out.print("3 sides: ");
                obj.calculateArea(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
            } else if (ch != 5) System.out.println("Invalid choice!");

        } while (ch != 5);
        sc.close();
    }
}
