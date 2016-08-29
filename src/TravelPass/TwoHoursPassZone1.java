package TravelPass;

import java.util.Calendar;

/**
 * Project APAss1,
 * Created by TonyZheng on 18/08/2016.
 */
public class TwoHoursPassZone1 extends TwoHoursPass {
    double price;
    public TwoHoursPassZone1(Calendar calendar,double price){
        super(calendar);
        this.price = price;
    }
}
