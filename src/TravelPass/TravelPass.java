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

    public String getStartName() {
        return startName;
    }

    public String getEndName() {
        return endName;
    }

    public char getType() {
        return type;
    }

    private String startName;
    private String endName;
    private char type;

    TravelPass(Calendar calendar,char duration,int zone,String startName,String endName,char type){
        this.startName = startName;
        this.endName = endName;
        this.type = type;
//        this.date = date;
        this.calendar = calendar;
        this.Duration = duration;
        this.zone = zone;
    }

    TravelPass(Calendar calendar,char duration,int zone,String startName,char type){
        this.startName = startName;
        this.Duration = duration;
        this.zone = zone;
        this.type = type;
        this.calendar = calendar;
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

