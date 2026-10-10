import java.util.Scanner;

abstract class Ticket {
    static final double FEE = 20.0;
    abstract double getPrice();
}

class Regular extends Ticket {
    double getPrice() {
        return 150.0;
    }
}

class Premium extends Ticket {
    double getPrice() {
        return 250.0;
    }
}

class Recliner extends Ticket {
    double getPrice() {
        return 400.0;
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next().toUpperCase();
            int count = sc.nextInt();

            Ticket ticket;

            switch (seat) {
                case "REGULAR":
                    ticket = new Regular();
                    break;
                case "PREMIUM":
                    ticket = new Premium();
                    break;
                case "RECLINER":
                    ticket = new Recliner();
                    break;
                default:
                    continue;
            }

            double amount = (ticket.getPrice() + Ticket.FEE) * count;
            total += amount;

            System.out.printf("%s: %.2f%n", seat, amount);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}