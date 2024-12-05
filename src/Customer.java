public class Customer implements Runnable {
    private int customerId;
    private int retrievalInterval;
    private TicketPool ticketPool;

    public Customer (int customerId, int retrievalInterval, TicketPool ticketPool){
        this. customerId = customerId;
        this. retrievalInterval = retrievalInterval;
        this.ticketPool = ticketPool;
    }

    public int getCustomerId(){
        return customerId;
    }

    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }

    public int getRetrievalInterval(){
        return retrievalInterval;
    }

    public void setRetrievalInterval(int retrievalInterval){
        this.retrievalInterval = retrievalInterval;
    }

    public TicketPool getTicketPool() {
        return ticketPool;
    }

    public void setTicketPool(TicketPool ticketPool) {
        this.ticketPool = ticketPool;
    }
    @Override
    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 5; i++){
            Ticket ticket = ticketPool.removeTicket();
            System.out.println(ticket.toString());
        }

    }
}
