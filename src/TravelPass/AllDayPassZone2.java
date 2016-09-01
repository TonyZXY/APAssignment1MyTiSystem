package TravelPass;

import java.util.Calendar;

/**
 * Project APAss1,
 * Created by TonyZheng on 18/08/2016.
 */
public class AllDayPassZone2 extends TravelPass {
    double price;
    public AllDayPassZone2(Calendar calendar,char duration,int zone,double price,String startName,String endName,char type){
        super(calendar,duration,zone,startName,endName,type);
        this.price = price;
    }

    public AllDayPassZone2(Calendar calendar,char duration,int zone,double price,String startName,char type){
        super(calendar,duration,zone,startName,type);
        this.price = price;
    }
}
