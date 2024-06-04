
import java.util.*;
public class Taxi{

    static int TaxiCount = 1;
    int id;
    char CurrentSpot;
    int totearnings;
    int freeTime;
    List<String>trips;

    public Taxi(){
        id = TaxiCount ;
        TaxiCount += 1;
        totearnings = 0;
        CurrentSpot = 'A';
        freeTime = 6;
        trips = new ArrayList<String>();
    }
    public void setDetails(char currentspot , int freetime , int totearnings , String tripDetail){
        this.CurrentSpot = currentspot;
        this.freeTime = freetime;
        this.totearnings = totearnings;
        this.trips.add(tripDetail);

    }

    public void printDetails()
    {
        //print all trips details
        System.out.println("Taxi - "+ this.id + " Total Earnings - " + this.totearnings);
        System.out.println("TaxiID    BookingID    CustomerID    From    To    PickupTime    DropTime    Amount");
        for(String trip : trips)
        {
            System.out.println(id + "          " + trip);
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public void printTaxiDetails()
    {
        //print total earningand taxi details like current location and free time
        System.out.println("Taxi - "+ this.id + " Total Earnings - " + this.totearnings + " Current spot - " + this.CurrentSpot +" Free Time - " + this.freeTime);
    }


}