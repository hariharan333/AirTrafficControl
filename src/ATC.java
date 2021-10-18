import java.util.ArrayList;
import java.util.Scanner;
import java.lang.*;

public class ATC extends Thread{
    String fname;
    int weight;
    int computeTime;
    int ch;
    String cho = "";
    ArrayList<Flight>flight = new ArrayList<Flight>();
    ArrayList<Runway>runway = new ArrayList<Runway>();
    ATC()
    {
        Flight ATR = new Flight("ATR",12,30);
        Flight Airbus= new Flight("Airbus",20,40);
        Flight Boeing = new Flight("Boeing",40,50);
        Flight Cargo = new Flight("Cargo",100,60);
        flight.add(ATR);
        flight.add(Airbus);
        flight.add(Boeing);
        flight.add(Cargo);

        Runway r1 = new Runway("Runway1",40,true);
        Runway r2 = new Runway("Runway2",60,true);
        Runway r3 = new Runway("Runway3",80,true);
        Runway r4 = new Runway("Runway4",90,true);

        runway.add(r1);
        runway.add(r2);
        runway.add(r3);
        runway.add(r4);
    }
    Scanner scan = new Scanner(System.in);
    public void getDetails(int ch)
    {
        System.out.println("enter plane type");
        fname = scan.nextLine();
        System.out.println(fname);
        System.out.println("enter weight of flight (in tons):");
        weight = scan.nextInt();
        if(ch == 0)
            cho = "Takeoff";
        else if(ch == 1)
            cho = "landing";
        else
            cho = "emergency landing";
    }
    public void runwayAssign()
    {
        int all = 0;
        for(int i=0;i<runway.size();i++)
        {
            if(computeTime<=runway.get(i).runwayHalt  && runway.get(i).status)
            {
                all = 1;
                Request r = new Request(fname,weight,cho,computeTime,runway.get(i));
                r.start();
                try{Thread.sleep(50);}
                catch (Exception e){}
                break;
            }
        }
        if(all == 0)
            System.out.println("you have to wait");
    }
    public void getChoice()
    {
        System.out.println("1.Take off");
        System.out.println("2.Landing ");
        System.out.println("3.Emergency Landing");
        System.out.println("4.Show runway");
        System.out.println("5.Exit");
        System.out.println("enter your choice :");
        ch = scan.nextInt();
        switch (ch){
            case 1:{
                scan.nextLine();
                getDetails(ch);
                for(Flight f:flight)
                {
                    if(fname.equals(f.flightType))
                    {
                        computeTime = f.computeTime(weight);
                        runwayAssign();
                    }
                }
                break;
            }
            case 2:{
                scan.nextLine();
                getDetails(ch);
                for(Flight f:flight)
                {
                    if(fname.equals(f.flightType))
                    {
                        computeTime = f.computeTime(weight);
                        runwayAssign();
                    }
                }
                break;
            }
            case 3:{
                scan.nextLine();
                getDetails(ch);
                for(Flight f:flight)
                {
                    if(fname.equals(f.flightType))
                    {
                        computeTime = f.computeTime(weight);
                        runwayAssign();
                    }
                }
                break;
            }
            case 4:{
                for(Runway run:runway)
                {
                    if(run.status)
                        System.out.println(run.runwayType+" is free");
                    else
                        System.out.println(run.runwayType+" is busy");
                }
                break;
            }
            case 5:
                return;

        }
    }
    public static void main(String[] args)
    {
        ATC atc = new ATC();
        int ans = 1;
        Scanner s = new Scanner(System.in);
        while(ans == 1)
        {
            atc.getChoice();
            System.out.println("do you want to continue ....(1 for Yes and 0 for No)");
            ans = s.nextInt();
        }
    }
}
