import java.util.*;

public class flight{
    static int id = 0;
    int flightID;
    int tickets;
    int price;

    ArrayList<String> passengerDetails; 
    ArrayList<Integer> passengerIDs; //list of all passenger IDs
    ArrayList<Integer> bookedTicketsPerPassenger; //list of number of tickets booked by every passenger ID                           
    ArrayList<Integer> passengerCost; //list of cost paid by every passenger ID, used to calculate refund while cancelling

    public flight(){
         // constructor called when we create object for the class !
        id += 1;
        flightID = id;
        tickets = 50;
        price = 5000; 
        passengerDetails = new ArrayList<String>();
        passengerIDs = new ArrayList<Integer>();
        bookedTicketsPerPassenger = new ArrayList<>();
        passengerCost = new ArrayList<>();
 
    }
    public void cancelticket(int passengerID)
    {
        //find the index to remove from all lists
       int indexToRemove = passengerIDs.indexOf(passengerID);
       if(indexToRemove < 0)
       {
           System.out.println("Passenger ID not found!");
           return;
       }
       int ticketsToCancel = bookedTicketsPerPassenger.get(indexToRemove);

       //increase number of available tickets
       tickets+=ticketsToCancel;
       //change price to new value after cancellation
       price-= 200 * ticketsToCancel;

       //calculate refund
       System.out.println("Refund Amount after cancel : " + passengerCost.get(indexToRemove));

       //remove details of passenger from all lists
       bookedTicketsPerPassenger.remove(indexToRemove);
       passengerIDs.remove(Integer.valueOf(passengerID));
       passengerDetails.remove(indexToRemove);
       passengerCost.remove(indexToRemove);

       System.out.println("Cancelled Booked Tickets Successfully!");

    }
    public void addPassengerDetails(String passengerDetail , int numberOfTickets , int passengerID){

            passengerDetails.add(passengerDetail); // entering the string value to print it in the BILL !!

            passengerIDs.add(passengerID); // corresponding id of the passenger 
            bookedTicketsPerPassenger.add(numberOfTickets);  // corresponding tickets of the passenger 
            passengerCost.add(price * numberOfTickets); // total cost of that particular purchase of tickets in the application !

            price += 200 * numberOfTickets;
            tickets -= numberOfTickets;
            System.out.println("------------------------");
            System.out.println("Booked Successfully !!");
            System.out.println("------------------------\n");
    }
    public void printdetails(){
        if(passengerDetails.size() == 0) {
            System.out.println("NO BOOKINGS YET !! , BOOK YOUR TICKETS NOW !");
        }
        else{
            System.out.println("-- PLEASE SEE YOUR DETAILS --");
            System.out.println();    
        System.out.println("Current Flight ID = " + flightID);
        for(String detail : passengerDetails){
            System.out.println(detail);
        }
    }
    }
}