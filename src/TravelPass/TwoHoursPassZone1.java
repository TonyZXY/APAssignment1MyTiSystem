package TravelPass;

import java.sql.Time;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

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
