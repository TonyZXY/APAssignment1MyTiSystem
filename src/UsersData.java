import TopUpHistory.TopUpHistory;
import TravelPass.TravelPass;

import java.util.*;

import Station.*;

/**
 * Project APAss1,
 * Created by TonyZheng on 17/08/2016.
 */
public class UsersData {
    // this is users data storage
    static HashMap<String, Users> users = new HashMap<>();

    static void addNewUser(String id, String userName, String email, double balance, char type) {
        users.put(id, new Users(id, userName, email, balance, type));
    }//this add method is for test.

    static void addNewUser(String id, String userName, String email, char type) {
        users.put(id, new Users(id, userName, email, type));
    }
    
    
/*    public static double checkUserID(String ID){
        String id = ID;
        double balance ;
        try{
            balance = users.get(id).getBalance();
        }catch (Exception e){
            balance = -1;
        }
        return balance;
    }*/

    static double checkUserID(String ID) {
        double balance;
        try {
            balance = users.get(ID).getBalance();
        } catch (Exception e) {
            balance = -1;
        }
        return balance;
    }


    static double getRate(String ID) { //here is rate setting
        double rate = 1;
        char type = users.get(ID).getType();
        if (type == 'A') {
            rate = 1.0;
        } else if (type == 'C') {
            rate = 0.8;
        } else if (type == 'S') {
            rate = 0.5;
        }
        return rate;
    }

//    static Hashmap<String,> history = new HashMap<>();

    // this is stations data storage
    static HashMap<String, Station> station = new HashMap<>();
    static ArrayList<String> stationsName = new ArrayList<>();

    void addStation(String name, int zone) {
        station.put(name, new Station(name, zone));
        stationsName.add(name + "            " + zone);
    }

//    public void travelHistory(String id, double balance) {
//
//    }

    static void topUp(String id, double balance) {
        users.get(id).topUp(balance);
        Calendar date = Calendar.getInstance();
        users.get(id).getTopUpHistories().add(new TopUpHistory(balance, date));
    }

    static boolean checkAdmin(String username,String password){
        String name = "Admin";
        String pass = "Admin";
        boolean valid = false;
        if(Objects.equals(name, username) && Objects.equals(pass, password)){
            valid = true;
        }
        return valid;
    }
}
