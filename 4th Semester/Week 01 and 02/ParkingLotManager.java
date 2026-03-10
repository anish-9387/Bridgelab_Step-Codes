import java.util.*;

enum SpotStatus{
    EMPTY, OCCUPIED, DELETED
}

class ParkingSpot{
    String licensePlate;
    long entryTime;
    SpotStatus status;

    public ParkingSpot(){
        status=SpotStatus.EMPTY;
    }
}

public class ParkingLotManager{
    private ParkingSpot[] parkingTable;
    private int capacity;
    private int occupiedSpots=0;
    private int totalProbes=0;
    private int totalParks=0;

    public ParkingLotManager(int capacity){
        this.capacity=capacity;
        parkingTable=new ParkingSpot[capacity];

        for(int i=0; i<capacity; i++){
            parkingTable[i]=new ParkingSpot();
        }
    }

    private int hash(String licensePlate){
        return Math.abs(licensePlate.hashCode())%capacity;
    }

    public void parkVehicle(String licensePlate){
        int index=hash(licensePlate);
        int probes=0;

        while(parkingTable[index].status==SpotStatus.OCCUPIED){
            index=(index+1)%capacity;
            probes++;
        }

        parkingTable[index].licensePlate=licensePlate;
        parkingTable[index].entryTime=System.currentTimeMillis();
        parkingTable[index].status=SpotStatus.OCCUPIED;

        occupiedSpots++;
        totalProbes+=probes;
        totalParks++;

        System.out.println("Vehicle "+licensePlate+" assigned spot #"+index+" ("+probes+" probes)");
    }

    public void exitVehicle(String licensePlate){
        int index=hash(licensePlate);

        while(parkingTable[index].status!=SpotStatus.EMPTY){
            if(parkingTable[index].status==SpotStatus.OCCUPIED && parkingTable[index].licensePlate.equals(licensePlate)){
                long exitTime=System.currentTimeMillis();
                long durationMillis=exitTime-parkingTable[index].entryTime;

                double hours=durationMillis/(1000.0*60*60);
                double fee=Math.ceil(hours)*5;

                parkingTable[index].status=SpotStatus.DELETED;
                occupiedSpots--;

                System.out.println("Vehicle "+licensePlate+" exited from spot #"+index+", Duration: "+String.format("%.2f",hours)+"h"+", Fee: $"+fee);

                return;
            }

            index=(index+1)%capacity;
        }

        System.out.println("Vehicle not found");
    }

    public int findNearestAvailableSpot(){
        for(int i=0; i<capacity; i++){
            if(parkingTable[i].status==SpotStatus.EMPTY || parkingTable[i].status==SpotStatus.DELETED){
                return i;
            }
        }
        return -1;
    }

    public void getStatistics(){
        double occupancy=(occupiedSpots*100.0)/capacity;

        double avgProbes=totalParks==0 ? 0 : (double)totalProbes/totalParks;

        System.out.println("\n====== Parking Statistics ======");
        System.out.println("Capacity: "+capacity);
        System.out.println("Occupied: "+occupiedSpots);
        System.out.println("Occupancy: "+String.format("%.2f",occupancy)+"%");
        System.out.println("Average Probes: "+String.format("%.2f",avgProbes));
    }

    public static void main(String[] args) throws InterruptedException{
        ParkingLotManager parking=new ParkingLotManager(10);

        parking.parkVehicle("ABC-1234");
        parking.parkVehicle("ABC-1235");
        parking.parkVehicle("XYZ-9999");

        Thread.sleep(2000);

        parking.exitVehicle("ABC-1234");

        int spot=parking.findNearestAvailableSpot();
        System.out.println("Nearest available spot: #"+spot);

        parking.getStatistics();
    }
}