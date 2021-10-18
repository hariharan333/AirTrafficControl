import java.util.*;
import java.lang.*;
public class Flight {
    String flightType;
    int maxWeight;
    int timeToHalt;
    Flight(String flightType,int maxWeight,int timeToHalt){
        this.flightType = flightType;
        this.maxWeight = maxWeight;
        this.timeToHalt = timeToHalt;
    }
    int computeTime(int weight)
    {
        int val=0;
        int ans=(weight*100/maxWeight);
        if(ans>=75)
            val = timeToHalt;
        else if(ans>=50 && ans<75)
            val = (int)(timeToHalt-(timeToHalt * (10f/100f)));
        else if(ans<50)
            val = (int)(timeToHalt-(timeToHalt * (20f/100f)));

        return val+10;
    }
}
