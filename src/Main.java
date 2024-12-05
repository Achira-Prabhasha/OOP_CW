import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner1 = new Scanner (System.in);
        System.out.println("Enter the total of tickets : ");
        int totalTickets = scanner1.nextInt();
        System.out.println("Total Tickets : " + totalTickets);

        Scanner scanner2 = new Scanner (System.in);
        System.out.println("Enter the ticket release rate : ");
        int ticketReleaseRate = scanner2.nextInt();
        System.out.println("Total Tickets : " + ticketReleaseRate);

        Scanner scanner3 = new Scanner (System.in);
        System.out.println("Enter the customer retrieval rate : ");
        int customerRetrievalRate = scanner3.nextInt();
        System.out.println("Total Tickets : " + customerRetrievalRate);

        Scanner scanner4 = new Scanner (System.in);
        System.out.println("Enter the max ticket capacity : ");
        int maxTicketCapacity = scanner4.nextInt();
        System.out.println("Total Tickets : " + maxTicketCapacity);

        ConfigurationInterface config = new ConfigurationInterface(totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity);

        config.saveData(config);
        config.load();

        TicketPool ticketPool = new TicketPool(100);
        Vendor vendor1 = new Vendor(10, 12, 45, ticketPool);
        Thread thread1 = new Thread(vendor1, "Vendor");
        thread1.start();

        Customer customer1 = new Customer(77, 4, ticketPool);
        Thread thread2 = new Thread(customer1, "Customer");
        thread2.start();

    }

}