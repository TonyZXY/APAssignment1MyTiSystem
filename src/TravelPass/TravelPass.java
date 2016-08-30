package TravelPass;

import java.util.Calendar;

/**
 * Project APAss1,
 * Created by TonyZheng on 18/08/2016.
 */
public class TravelPass {
//    Date date;
    Calendar calendar;
    char Duration;
    public TravelPass(Calendar calendar,char duration){
//        this.date = date;
        this.calendar = calendar;
        this.Duration = duration;
    }

    public Calendar getCalendar(){
        return calendar;
    }

    public char getDuration(){
        return Duration;
    }
}

