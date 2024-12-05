import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConfigurationInterface {
    private  int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;

    public ConfigurationInterface(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity){
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maxTicketCapacity = maxTicketCapacity;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.totalTickets = ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        this.totalTickets = customerRetrievalRate;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public void setMaxTicketCapacity(int maxTicketCapacity) {
        this.totalTickets = maxTicketCapacity;
    }

    public void saveData(ConfigurationInterface configurationInterface){
        Gson gson = new Gson();

        try(FileWriter fileWriter = new FileWriter("Example.json")){
            gson.toJson(configurationInterface, fileWriter);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public void load(){
        Gson gson = new Gson();

        try{
            FileReader reader = new FileReader("Example.json");
            ConfigurationInterface data = gson.fromJson(reader,ConfigurationInterface.class);
            System.out.println(data.toString());
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }

}


