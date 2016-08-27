package TopUpHistory;

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
        return date;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private double balance;
    private Date date;
    public TopUpHistory(double balance,Date date){
        this.balance = balance;
        this.date = date;
    }


}
