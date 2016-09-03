package TravelPassHistory;

import java.util.ArrayList;

import TravelPass.TravelPass;

/**
 * Project APAssignment1MyTiSystem
 * Created by TonyZheng on 3/09/2016.
 */
public class TravelPassHistory {
    String id;
    TravelPass travelPass;

    public TravelPassHistory(String id, TravelPass travelPass) {
        this.id = id;
        this.travelPass = travelPass;
    }

    public static ArrayList getTravelPassHistory() {
        return travelPassHistory;
    }

    public static ArrayList<TravelPassHistory> travelPassHistory = new ArrayList<>();

}
