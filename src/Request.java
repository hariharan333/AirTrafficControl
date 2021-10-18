import java.lang.*;
public class Request extends Thread{
    String fname;
    int weight;
    String requestType;
    int computeTime;
    Runway r;
    public Request(String fname,int weight,String requestType,int computeTime,Runway r)
    {
        this.fname = fname;
        this.weight =weight;
        this.requestType = requestType;
        this.computeTime = computeTime;
        this.r = r;
    }

    public void run()
    {
        r.status = false;
        try
        {
            System.out.println("---------------------------------------------------------------------");
            System.out.println(requestType+" approved for "+fname+" with "+weight+" tonnes weight in "+r.runwayType);
            System.out.println("touch down will happen in 15 sec");
            System.out.println("the plane will be stop after "+computeTime+" of touchdown");
            System.out.println(r.runwayType+" will be available for next request in "+computeTime+"sec");
            System.out.println("---------------------------------------------------------------------");
            Thread.sleep(1000*computeTime);
            r.status = true;
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

}
