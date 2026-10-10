import java.util.Scanner;

abstract class Connection {
    abstract double calculateBill();
}

class Home extends Connection {
    double units;

    Home(double units) {
        this.units = units;
    }

    double calculateBill() {
        if (units <= 100)
            return units * 2;
        else if (units <= 200)
            return 100 * 2 + (units - 100) * 3;
        else
            return 100 * 2 + 100 * 3 + (units - 200) * 5;
    }
}

class Shop extends Connection {
    double units;

    Shop(double units) {
        this.units = units;
    }

    double calculateBill() {
        return units * 7;
    }
}

class Factory extends Connection {
    double units;

    Factory(double units) {
        this.units = units;
    }

    double calculateBill() {
        return units * 10;
    }
}

public class ElectricityBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Connection[] connections = new Connection[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();

            if (type.equalsIgnoreCase("HOME")) {
                connections[i] = new Home(units);
            } else if (type.equalsIgnoreCase("SHOP")) {
                connections[i] = new Shop(units);
            } else if (type.equalsIgnoreCase("FACTORY")) {
                connections[i] = new Factory(units);
            } else {
                System.out.println("Invalid connection type");
                sc.close();
                return;
            }
        }

        double total = 0;

        for (int i = 0; i < n; i++) {
            double bill = connections[i].calculateBill();

            String type = "";

            if (connections[i] instanceof Home) {
                type = "HOME";
            } else if (connections[i] instanceof Shop) {
                type = "SHOP";
            } else if (connections[i] instanceof Factory) {
                type = "FACTORY";
            }

            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}