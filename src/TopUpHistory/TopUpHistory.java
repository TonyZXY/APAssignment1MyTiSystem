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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    private double balance;
    private Calendar date;
    public TopUpHistory(double balance,Calendar date){
        this.balance = balance;
        this.date = date;
    }


}
