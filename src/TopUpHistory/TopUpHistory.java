package TopUpHistory;

import java.util.Calendar;
import java.util.Date;

/**
 * Project APAssignment1MyTiSystem
 * Created by TonyZheng on 27/08/2016.
 */
public class TopUpHistory {
    public double getBalance() {
        return balance;
    }

    public Date getDate() {
        return date.getTime();
    }

    private double balance;
    private Calendar date;

    public TopUpHistory(double balance, Calendar date) {
        this.balance = balance;
        this.date = date;
    }


}
