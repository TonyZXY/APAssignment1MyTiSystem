package TravelPass;

import java.sql.Time;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

/**
 * Project APAss1,
 * Created by TonyZheng on 18/08/2016.
 */
public class TwoHoursPass extends TravelPass {
    char duration;
    public TwoHoursPass(Calendar calendar){
        super(calendar);
        this.duration = 'H';
    }
}
