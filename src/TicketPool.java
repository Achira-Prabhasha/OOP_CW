import org.apache.log4j.Logger;

import java.util.List;
import java.util.Vector;

public class TicketPool {
    private int maximumTicketCapacity;
    private List <Ticket> ticketList;
    private static Logger logger = Logger.getLogger(TicketPool.class);

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
                logger.error(e);
                throw new RuntimeException(e.getMessage());
            }
        }

        this.ticketList.add(ticket);
        logger.info("Ticket added by - " + Thread.currentThread().getName() + " - current size is - " + ticketList.size());
        notifyAll();

    }

    public synchronized Ticket removeTicket(){
        while (ticketList.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                logger.error(e);
                throw new RuntimeException(e.getMessage());
            }
        }

        Ticket ticket = ticketList.removeFirst();
        logger.info("Ticket bought by - " + Thread.currentThread().getName() + " - current size is - " + ticketList.size() + " - Ticket is - " + ticket);
        notifyAll();
        return ticket;
    }
}
