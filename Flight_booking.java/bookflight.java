
import java.util.ArrayList;
import java.util.Scanner;

public class bookflight {
    

    public static void book (flight currentflight , int tickets , int passengerid){
        String passengerDetail = "";
        passengerDetail = "Passenger ID = " + passengerid + "\n" + "Number of Tickets Booked = " 
        + tickets + "\n" + "Total cost = " + currentflight.price * tickets + "\n";

        currentflight.addPassengerDetails(passengerDetail, tickets, passengerid);
        currentflight.printdetails();
    }

    public static void cancel(flight currentflight , int passid){
        if(passid < 0) {
            System.out.println("INVALID PASSENGER ID");
        }
        currentflight.cancelticket(passid);
    }
    public static void printuser(flight currentflight){
        currentflight.printdetails();
    }
    public static void main(String args[]){

        // create flights with objects for class in FLIGHT 

        ArrayList<flight> flights = new ArrayList<>();
        for(int i = 0;i < 2;i += 1){
            flight f = new flight();
            flights.add(f);
        }
        int passengerid = 1;
        int r = 0;
        while(true){
        if(r == 1) break;
        System.out.println("1. Book 2. Cancel 3. Print 4.Exit APP ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        flight currentflight = null;
        
        switch(choice){

            case 1:
            {
                System.out.println("Enter Flight ID");
                int fid = sc.nextInt();

                //check if flight id is valid
                if(fid > flights.size())
                {
                    System.out.println("Invalid flight ID");
                    break;
                }

            for(flight f : flights){
                if(f.flightID == fid){
                    currentflight = f;
                    break;
                }
            }
            
            System.out.println("Enter number of tickets");
            int t = sc.nextInt();

            if(t > currentflight.tickets){
                System.out.println(" Not Enought tickets for Booking !");
            }
            book(currentflight , t , passengerid);
            passengerid += 1;
            break;
             // END OF BOOKING PART IN CASE 1 
        }
        case 2 : 
        {
            System.out.println("Enter the flight ID nad passenger ID to cancel tickets !");
            int flid = sc.nextInt();
            int passid = sc.nextInt();
            
            flight currflight = null;
            for(flight f : flights){
                if(f.flightID == flid){
                    currflight = f;
                    break;
                }
            }
            cancel(currflight , passid);
            break;
        }
        //END OF CANCELLING PROCESS
        case 3 : 
        {
            System.out.println("Enter your flight ID : ");
            int fl = sc.nextInt();
            flight cflight = null;
            for(flight f : flights){
                if(fl == f.flightID){
                    cflight = f;
                    break;
                }
            }
            printuser(cflight);
        }
        case 4:
            {
                r = 1;
                break;
            }

        }
    }

    }
}
