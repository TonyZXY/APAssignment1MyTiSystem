package TravelPass;

import java.util.Calendar;

/**
 * Project APAss1,
 * Created by TonyZheng on 18/08/2016.
 */
public class AllDayPassZone2 extends TravelPass {
    double price;
    public AllDayPassZone2(Calendar calendar,char duration,double price){
        super(calendar,duration);
        this.price = price;
    }
}
