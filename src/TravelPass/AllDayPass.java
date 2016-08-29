package TravelPass;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

/**
 * Project APAss1,
 * Created by TonyZheng on 18/08/2016.
 */
public class AllDayPass extends TravelPass{
    char Duration;
    public AllDayPass(Calendar calendar){
        super(calendar);
        this.Duration = 'D';
    }
}
