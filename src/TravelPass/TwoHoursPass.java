package TravelPass;

import java.util.Calendar;


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
