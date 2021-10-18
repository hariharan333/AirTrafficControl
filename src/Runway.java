import java.util.*;
import java.lang.*;
public class Runway extends Thread{
    String runwayType;
    int runwayHalt;
    boolean status;

    public Runway(String runwayType,int runwayHalt,boolean status){
        this.runwayType = runwayType;
        this.runwayHalt = runwayHalt;
        this.status = status;
    }
}
