package TravelPass;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

/**
 * Project APAss1,
 * Created by TonyZheng on 18/08/2016.
 */
public class AllDayPassZone1 extends AllDayPass {
    double price;
    
    public AllDayPassZone1(Calendar calendar,double price){
        super(calendar);
        this.price = price;
    }
}
