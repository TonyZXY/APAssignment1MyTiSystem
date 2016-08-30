package TravelPass;

import java.util.Calendar;

/**
 * Project APAss1,
 * Created by TonyZheng on 18/08/2016.
 */
public class AllDayPassZone1 extends TravelPass {
    double price;
    
    public AllDayPassZone1(Calendar calendar,char duration,int zone,double price){
        super(calendar,duration,zone);
        this.price = price;
    }
}
