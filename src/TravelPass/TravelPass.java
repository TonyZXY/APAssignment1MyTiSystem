package TravelPass;

import java.util.Calendar;

/**
 * Project APAss1,
 * Created by TonyZheng on 18/08/2016.
 */
public class TravelPass {
//    Date date;
    private Calendar calendar;
    private char Duration;
    private int zone;
    TravelPass(Calendar calendar,char duration,int zone){
//        this.date = date;
        this.calendar = calendar;
        this.Duration = duration;
        this.zone = zone;
    }

    public Calendar getCalendar(){
        return calendar;
    }

    public char getDuration(){
        return Duration;
    }

    public int getZone(){
        return zone;
    }

}

