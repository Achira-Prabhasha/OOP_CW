public class Vendor implements Runnable{
    private int vendorId;
    private int ticketsPerRelease;
    private int releaseInterval;
    private TicketPool ticketPool;

    public Vendor(int vendorId, int ticketsPerRelease, int releaseInterval, TicketPool ticketPool){
        this.vendorId = vendorId;
        this.ticketsPerRelease = ticketsPerRelease;
        this.releaseInterval = releaseInterval;
        this.ticketPool = ticketPool;
    }
    public int getVendorId(){
        return vendorId;
    }
    public void setVendorId(int vendorId){
        this.vendorId = vendorId;
    }
    public int getTicketsPerRelease(){
        return ticketsPerRelease;
    }
    public void setTicketsPerRelease(int ticketsPerRelease){
        this.ticketsPerRelease = ticketsPerRelease;
    }
    public int getReleaseInterval(){
        return releaseInterval;
    }
    public void setReleaseInterval(int releaseInterval){
        this.releaseInterval = releaseInterval;
    }
    public TicketPool getTicketPool(){
        return ticketPool;
    }
    public void setTicketPool(TicketPool ticketPool){
        this.ticketPool = ticketPool;
    }
    @Override
    public void run(){
        for (int i = 0; i < 5 ; i++){
            Ticket ticket = new Ticket(10+i, "aaa", 4500 );
            ticketPool.addTicket(ticket);
        }
    }
}
