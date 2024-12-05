import java.util.List;
import java.util.Vector;

public class TicketPool {
    private int maximumTicketCapacity;
    private List <Ticket> ticketList;

    public TicketPool(int maximumTicketCapacity){
        this.maximumTicketCapacity = maximumTicketCapacity;
        this.ticketList = new Vector<>();
    }

    public int getMaximumTicketCapacity() {
        return maximumTicketCapacity;
    }

    public void setMaximumTicketCapacity(int maximumTicketCapacity) {
        this.maximumTicketCapacity = maximumTicketCapacity;
    }

    public synchronized void addTicket(Ticket ticket){
        while (ticketList.size() >= maximumTicketCapacity){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        this.ticketList.add(ticket);
        notifyAll();
        System.out.println("Ticket added by - " + Thread.currentThread().getName() + " - current size is - " + ticketList.size());

    }

    public synchronized Ticket removeTicket(){
        while (ticketList.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        Ticket ticket = ticketList.removeFirst();
        notifyAll();
        System.out.println("Ticket bought by - " + Thread.currentThread().getName() + " - current size is - " + ticketList.size() + " - Ticket is - " + ticket);
        return ticket;
    }
}
