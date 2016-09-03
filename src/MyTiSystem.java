import java.util.*;

import TopUpHistory.TopUpHistory;
import TravelPass.*;
import TravelPassHistory.TravelPassHistory;

/**
 * Project APAss1,
 * Created by TonyZheng on 16/8/9.
 */
public class MyTiSystem {

    public void setZoneOneOneDayPassPrice(double zoneOneOneDayPassPrice) {
        this.zoneOneOneDayPassPrice = zoneOneOneDayPassPrice;
    }

    public void setZoneOneTwoHoursPassPrice(double zoneOneTwoHoursPassPrice) {
        this.zoneOneTwoHoursPassPrice = zoneOneTwoHoursPassPrice;
    }

    public void setZoneTwoOneDayPassPrice(double zoneTwoOneDayPassPrice) {
        this.zoneTwoOneDayPassPrice = zoneTwoOneDayPassPrice;
    }

    public void setZoneTwoTwoHoursPassPrice(double zoneTwoTwoHoursPassPrice) {
        this.zoneTwoTwoHoursPassPrice = zoneTwoTwoHoursPassPrice;
    }

    private double zoneOneOneDayPassPrice = 6.9;
    private double zoneOneTwoHoursPassPrice = 3.5;
    private double zoneTwoOneDayPassPrice = 9.8;
    private double zoneTwoTwoHoursPassPrice = 5.0;

    private void mainMenu() { //main menu
        System.out.println("Welcome to MyTi");
        System.out.println("1. Buy a travel pass");
        System.out.println("2. Charge my MyTi");
        System.out.println("3. Show remaining credit");
//        System.out.println("4. Purchase a Journey using a MyTi card");
        System.out.println("5. Show Card Info");
        System.out.println("7. Admin mod");
        System.out.println("0. Quit");
        System.out.println("Choose an option:");
    }

    private void purchaseMenu() { //option 1
        System.out.println("What time period");
        System.out.println("1. 2 Hours");
        System.out.println("2. All Day");
        System.out.println("0. Cancel");
        System.out.println("Your option:");
    }

    private void zoneMenu() { //option 1
        System.out.println("Which zone: ");
        System.out.println("1. Zone 1");
        System.out.println("2. Zone 1 and 2");
        System.out.println("3. Select by Station");
        System.out.println("0. Cancel");
        System.out.println("Your option:");
    }

    private void admin() {
        System.out.println("1. Print all Journeys made using all MyTi cards");
        System.out.println("2. Show Station statistics");
        System.out.println("3. Add a new User");
//        System.out.println("4. Create a new MyTi Card");
//        System.out.println("5. Attach a MyTi Card to a User");
        System.out.println("7. Change Current Station");
        System.out.println("0. Exit");
        System.out.println("Your option:");
    }

    private void cardInfo() {
        System.out.println("1. Show recent 10 travel history");
        System.out.println("2. Show recent 10 TopUp history");
        System.out.println("3. Show card Info");
        System.out.println("0. Exit");
        System.out.println("Your option:");
    }

    private void cardInfoMenu() {
        System.out.println("Enter card id:");
        String id = new Scanner(System.in).nextLine();
        double balance = UsersData.checkUserID(id);
        if (balance == -1) {
            System.err.println("Card ID not Found!");
            menuRun();
        } else {
            runCardInfoMenu(id);
        }
    }

    private void runCardInfoMenu(String id) { //card info menu
        int m;
        try {
            do {
                cardInfo();
                m = new Scanner(System.in).nextInt();
                switch (m) {
//                    case 1:
//                        recent10TravelHistory(id);
//                        break;
                    case 2:
                        recent10TopUpHistory(id);
                        break;
//                    case 3:
//                        showMoreInfo(id);
//                        break;
                    case 0:
                        menuRun();
                        break;
                    default:
                        System.err.println("Invalid Input, Try again.");
                        runCardInfoMenu(id);
                }
            } while (m != 0);
        } catch (Exception e) {
            System.err.println("Invalid Input, Try again.");
            runCardInfoMenu(id);
        }
    }

    private void recent10TopUpHistory(String id) {
        int i = UsersData.users.get(id).historySize();
        if (i > 10) {
            for (int x = 0; x < 10; x++) {
                double balance = UsersData.users.get(id).getTopUpHistories().get(i - x - 1).getBalance();
                Date date = UsersData.users.get(id).getTopUpHistories().get(i - x - 1).getDate();
                System.out.println("TopUp $" + balance + ", at Time:" + date);
            }
            menuRun();
        } else {
            for (int x = i; x > 0; x--) {
                double balance = UsersData.users.get(id).getTopUpHistories().get(x - 1).getBalance();
                Date date = UsersData.users.get(id).getTopUpHistories().get(x - 1).getDate();
                System.out.println("TopUp $" + balance + ", at Time:" + date);
            }
            menuRun();
        }
    }

    private void adminMenu() {
        System.out.println("Enter Admin username");
        String username = new Scanner(System.in).nextLine();
        System.out.println("Enter Admin Password");
        String password = new Scanner(System.in).nextLine();
        boolean valid = UsersData.checkAdmin(username, password);
        if (valid) {
            runAdminMenu();
        } else {
            System.err.println("Invalid Admin user, Exiting");
            menuRun();
        }
    }

    private void runAdminMenu() {
        int m;
        try {
            do {
                admin();
                m = new Scanner(System.in).nextInt();
                switch (m) {
                    case 1:
                        printAllJorneys();
                        break;
                    case 2:
                        showStationStatistics();
                        break;
                    case 3:
                        addNewUser();
                        break;
                    case 7:
                        changeCurrentStation();
                        break;
                    case 0:
                        menuRun();
                        break;
                    default:
                        printBlackLine();
                        System.out.println("Invalid Input. Try again.");
                        runAdminMenu();
                }
            } while (m != 0);
        } catch (Exception e) {
            printBlackLine();
            System.out.println("Invalid Input, Try again.");
            runAdminMenu();
        }
    }

    private void printAllJorneys() {

    }

    private void showStationStatistics() {

    }

    private void changeCurrentStation() {
        System.out.println("Current Station is: " + thisStop);
        System.out.println("Station Name    :  Zone");
        for (int i = 0; i < UsersData.stationsName.size(); i++) {
            System.out.println(UsersData.stationsName.get(i));
        }
        System.out.println("Enter Changed Station: ");
        String station = new Scanner(System.in).nextLine();
        boolean valid = UsersData.checkStation(station);
        if (valid) {
            setThisStop(station);
            System.out.println("Current station now is: " + thisStop);
            runAdminMenu();
        } else {
            System.out.println("Invalid station name, Try again");
            runAdminMenu();
        }
    }

    private void addNewUser() {
        String id;
        String userName;
        String email;
        char type;
        try {
            char m;
            do {
                System.out.println("Enter User id");
                System.out.println("Enter (Q) to Quit");
                id = new Scanner(System.in).nextLine();
                m = new Scanner(System.in).next().charAt(0);
                boolean valid = UsersData.checkUser(id);
                if (valid) {
                    System.out.println("User id is Used, try other ID");
//                    System.out.println("Sorry, that card already has a user; only 1 user per card is allowed");
                    addNewUser();
                }
                System.out.println("Enter User Name");
                userName = new Scanner(System.in).nextLine();
                System.out.println("Enter User E-mail Address");
                email = new Scanner(System.in).nextLine();
                System.out.println("Enter User Type");
                System.out.println("(A)Adult,(C)Conssion,(S)Student");
                type = new Scanner(System.in).next().charAt(0);
                UsersData.addNewUser(id, userName, email, type);
            } while (m != 'Q');
            runAdminMenu();
        } catch (Exception e) {
            System.out.println("Invalid Input, Try again.");
            addNewUser();
        }
    }

//    private Scanner keyPad = new Scanner(System.in);

    void menuRun() {
        int m;
        try {
            do {
                mainMenu();
                m = new Scanner(System.in).nextInt();
                switch (m) {
                    case 1:
                        travelPassPurchase();
                        break;
                    case 2:
                        chargeMyTiCard();
                        break;
                    case 3:
                        showCreditMenu();
                        break;
//                    case 4:
//                        journeyPurchase();
//                        break;
                    case 5:
                        cardInfoMenu();
                        break;
                    case 7:
                        adminMenu();
                        break;
//                    case 0:
//                        waitingForCustomer();
//                        break;
                    default:
                        printBlackLine();
                        System.out.println("Invalid Input, Try again.");
                        menuRun();
                }
            } while (m != 0);
        } catch (InputMismatchException e) {
            printBlackLine();
            System.out.println("Invalid Input, Try again.");
            menuRun();
        }
    }

    private void travelPassPurchase() { //check user info
        String userID;
        printBlackLine();
        System.out.print("Which card ID: ");
        userID = new Scanner(System.in).nextLine();
        double balance = UsersData.checkUserID(userID);
        if (balance != -1) {
            char type = UsersData.users.get(userID).getType();
            double rate = UsersData.getRate(userID);
            travelPassPurchaseMenu(userID, balance, rate, type);
        } else {
            printBlackLine();
            System.err.println("User ID not found. Try again.");
            menuRun();
        }
    }


    private void purchaseTwoHoursPass(String userID, double balance, double rate, char type) { //zone choose (2hours)
        try {
            zoneMenu();
            int m = new Scanner(System.in).nextInt();
            switch (m) {
                case 1:
                    purchaseZoneOneTwoHoursPass(userID, balance, rate, type, null);
                    break;
                case 2:
                    purchaseZoneTwoTwoHoursPass(userID, balance, rate, type, null);
                    break;
                case 3:
                    selectByStationTwoHoursPass(userID, balance, rate, type);
                    break;
                case 0:
                    mainMenu();
                    break;
                default:
                    printBlackLine();
                    System.out.println("Invalid Input, Try again.");
                    purchaseTwoHoursPass(userID, balance, rate, type);
            }
        } catch (InputMismatchException e) {
            printBlackLine();
            System.out.println("Invalid Input, Try again.");
            purchaseTwoHoursPass(userID, balance, rate, type);
        }

    }

    private void travelPassPurchaseMenu(String id, double balance, double rate, char type) { //purchase choose pass type
        try {
            purchaseMenu();
            int m = new Scanner(System.in).nextInt();
            switch (m) {
                case 1:
                    purchaseTwoHoursPass(id, balance, rate, type);
                    break;
                case 2:
                    purchaseOneDayPass(id, balance, rate, type);
                    break;
                case 0:
                    menuRun();
                    break;
                default:
                    printBlackLine();
                    System.out.println("Invalid Input, Try again.");
                    travelPassPurchase();
            }
        } catch (InputMismatchException e) {
            printBlackLine();
            System.out.println("Invalid Input, Try again.");
            travelPassPurchaseMenu(id, balance, rate, type);
        }

    }

    private void purchaseZoneOneTwoHoursPass(String id, double balance, double rate, char type, String endName) { //make purchase of 2hours zone1
        try {
            if (balance - (zoneOneTwoHoursPassPrice * rate) < 0) {
                printBlackLine();
                throw new NoEnoughFundExcpetion("No enough Fund in your card");
            } else {
                UsersData.users.get(id).purchase(zoneOneTwoHoursPassPrice * rate);
                Calendar date = Calendar.getInstance();
                if (Objects.equals(endName, null)) {
                    UsersData.users.get(id).getHistory().add(new TwoHoursPassZone1(date, 'H', 1, zoneOneTwoHoursPassPrice * rate, thisStop, type));  //add history
                    TravelPassHistory.travelPassHistory.add(new TravelPassHistory(id,new TwoHoursPassZone1(date, 'H', 1, zoneOneTwoHoursPassPrice * rate, thisStop, type)));
                } else {
                    UsersData.users.get(id).getHistory().add(new TwoHoursPassZone1(date, 'H', 1, zoneOneTwoHoursPassPrice * rate, thisStop, endName, type));
                    TravelPassHistory.travelPassHistory.add(new TravelPassHistory(id,new TwoHoursPassZone1(date, 'H', 1, zoneOneTwoHoursPassPrice * rate, thisStop, endName, type)));
                }
                System.out.println("You successfully purchase 2 hours Zone 1 travel Pass.");
                printBlackLine();
                menuRun();
            }
        } catch (NoEnoughFundExcpetion e) {
            printBlackLine();
            System.err.println(e);
            menuRun();
        }
    }

    private void purchaseZoneTwoTwoHoursPass(String id, double balance, double rate, char type, String endName) { //make purchase of 2hours zone1&2
        try {
            if (balance - (zoneTwoTwoHoursPassPrice * rate) < 0) {
                printBlackLine();
                throw new NoEnoughFundExcpetion("No enough Fund in your card");
            } else {
                UsersData.users.get(id).purchase(zoneTwoTwoHoursPassPrice * rate);
                Calendar date = Calendar.getInstance();
                if (Objects.equals(endName, null)) {
                    UsersData.users.get(id).getHistory().add(new TwoHoursPassZone2(date, 'H', 2, zoneTwoTwoHoursPassPrice * rate, thisStop, type)); //add history
                    TravelPassHistory.travelPassHistory.add(new TravelPassHistory(id,new TwoHoursPassZone2(date, 'H', 2, zoneTwoTwoHoursPassPrice * rate, thisStop, type)));
                } else {
                    UsersData.users.get(id).getHistory().add(new TwoHoursPassZone2(date, 'H', 2, zoneTwoTwoHoursPassPrice * rate, thisStop, endName, type));
                    TravelPassHistory.travelPassHistory.add(new TravelPassHistory(id,new TwoHoursPassZone2(date, 'H', 2, zoneTwoTwoHoursPassPrice * rate, thisStop, endName, type)));
                }
                System.out.println("You successfully purchase 2 hours Zone 1 & Zone 2 travel Pass.");
                printBlackLine();
                menuRun();
            }
        } catch (NoEnoughFundExcpetion err) {
            System.err.println(err);
            menuRun();
        }
    }

    private void purchaseOneDayPass(String id, double balance, double rate, char type) { //day pass menu

        try {
            zoneMenu();
            int m = new Scanner(System.in).nextInt();
            switch (m) {
                case 1:
                    purchaseZoneOneDayPass(id, balance, rate, type, null);
                    break;
                case 2:
                    purchaseZoneTwoDayPass(id, balance, rate, type, null);
                    break;
                case 3:
                    selectByStationDayPass(id, balance, rate, type);
                    break;
                case 0:
                    menuRun();
                    break;
                default:
                    printBlackLine();
                    System.out.println("Invalid Input, Try again.");
                    purchaseOneDayPass(id, balance, rate, type);
            }
        } catch (InputMismatchException e) {
            printBlackLine();
            System.out.println("Invalid Input, Try again.");
            purchaseOneDayPass(id, balance, rate, type);
        }

    }

    private void purchaseZoneOneDayPass(String id, double balance, double rate, char type, String endName) { //purchase
        try {
            if (balance - (zoneOneOneDayPassPrice * rate) < 0) {
                throw new NoEnoughFundExcpetion("No enough Fund in your card");
            } else {
                UsersData.users.get(id).purchase(zoneOneOneDayPassPrice * rate);
                Calendar date = Calendar.getInstance();
                if (Objects.equals(endName, null)) {
                    UsersData.users.get(id).getHistory().add(new AllDayPassZone1(date, 'D', 1, zoneOneOneDayPassPrice * rate, thisStop, type)); //add history
                    TravelPassHistory.travelPassHistory.add(new TravelPassHistory(id, new AllDayPassZone1(date, 'D', 1, zoneOneOneDayPassPrice * rate, thisStop, type)));
                } else {
                    UsersData.users.get(id).getHistory().add(new AllDayPassZone1(date, 'D', 1, zoneOneOneDayPassPrice * rate, thisStop, endName, type));
                    TravelPassHistory.travelPassHistory.add(new TravelPassHistory(id, new AllDayPassZone1(date, 'D', 1, zoneOneOneDayPassPrice * rate, thisStop, endName, type)));
                }
                System.out.println("You successfully purchase 1 day Zone 1 travel Pass.");
                printBlackLine();
                menuRun();
            }
        } catch (NoEnoughFundExcpetion err) {
            printBlackLine();
            System.err.println(err);
            menuRun();
        }
    }

    private void purchaseZoneTwoDayPass(String id, double balance, double rate, char type, String endName) { //purchase
        try {
            if (balance - (zoneTwoOneDayPassPrice * rate) < 0) {
                throw new NoEnoughFundExcpetion("No enough Fund in your card");
            } else {
                UsersData.users.get(id).purchase(zoneTwoOneDayPassPrice * rate);
                Calendar date = Calendar.getInstance();
                if (Objects.equals(endName, null)) {
                    UsersData.users.get(id).getHistory().add(new AllDayPassZone2(date, 'D', 2, zoneTwoOneDayPassPrice * rate, thisStop, type)); //add history
                    TravelPassHistory.travelPassHistory.add(new TravelPassHistory(id, new AllDayPassZone2(date, 'D', 2, zoneTwoOneDayPassPrice * rate, thisStop, type)));
                } else {
                    UsersData.users.get(id).getHistory().add(new AllDayPassZone2(date, 'D', 2, zoneTwoOneDayPassPrice * rate, thisStop, endName, type));
                    TravelPassHistory.travelPassHistory.add(new TravelPassHistory(id, new AllDayPassZone2(date, 'D', 2, zoneTwoOneDayPassPrice * rate, thisStop, endName, type)));
                    //add travel pass history for admin to use
                }
                System.out.println("You successfully purchase 1 day Zone 1 & Zone 2 travel Pass.");
                printBlackLine();
                menuRun();
            }
        } catch (NoEnoughFundExcpetion err) {
            printBlackLine();
            System.err.println(err);
            menuRun();
        }
    }

    private void selectByStationTwoHoursPass(String id, double balance, double rate, char type) { //select by station name 2 hours pass
        try {
            System.out.println("Station Name    :  Zone");
            for (int i = 0; i < UsersData.stationsName.size(); i++) {
                System.out.println(UsersData.stationsName.get(i));
            }
            printBlackLine();
            System.out.println("Please enter station name:");
            String thisStop = "Central";
            String destnationStop = new Scanner(System.in).nextLine();
            int thisZone = UsersData.station.get(thisStop).getZone();
            int destnationZone = UsersData.station.get(destnationStop).getZone();
            if (thisZone == 1 && destnationZone == 1) {
                purchaseZoneOneTwoHoursPass(id, balance, rate, type, destnationStop);
            } else if ((thisZone == 1 && destnationZone == 2) || (thisZone == 2 && destnationZone == 1) || (thisZone == 2 && destnationZone == 2)) {
                purchaseZoneTwoTwoHoursPass(id, balance, rate, type, destnationStop);
            }

        } catch (Exception e) {
            printBlackLine();
            System.err.println("Invalid input, Try again");
            selectByStationTwoHoursPass(id, balance, rate, type);
        }
    }

    public void setThisStop(String thisStop) {
        this.thisStop = thisStop;
    }

    private String thisStop = "Central";

    private void selectByStationDayPass(String id, double balance, double rate, char type) { //select by station name day pass
        try {
            System.out.println("Station Name    :  Zone");
            for (int i = 0; i < UsersData.stationsName.size(); i++) {
                System.out.println(UsersData.stationsName.get(i));
            }
            printBlackLine();
            System.out.println("Please enter station name:");
            String destnationStop = new Scanner(System.in).nextLine();
            int thisZone = UsersData.station.get(thisStop).getZone();
            int destnationZone = UsersData.station.get(destnationStop).getZone();
            if (thisZone == 1 && destnationZone == 1) {
                purchaseZoneOneDayPass(id, balance, rate, type, destnationStop);
            } else if ((thisZone == 1 && destnationZone == 2) || (thisZone == 2 && destnationZone == 1) || (thisZone == 2 && destnationZone == 2)) {
                purchaseZoneTwoDayPass(id, balance, rate, type, destnationStop);
            }
        } catch (Exception e) {
            printBlackLine();
            System.out.println("Invalid input, Try again");
            selectByStationDayPass(id, balance, rate, type);
        }
    }

    private void chargeMyTiCard() { //check user id before TopUp
        String userID;
        System.out.print("Which card ID: ");
        userID = new Scanner(System.in).nextLine();
        double balance = UsersData.checkUserID(userID);
        printBlackLine();
        if (balance != -1) {
            confirmMyTiTopUp(userID, balance);
        } else {
            printBlackLine();
            System.err.println("User ID not found. Try again.");
            menuRun();
        }
    }

    private void confirmMyTiTopUp(String id, double balance) {  //check if valid
        try {
            System.out.println("Your current balance is: " + balance + "$");
            System.out.println("How much to TopUp:");
            double amount = new Scanner(System.in).nextInt();
            printBlackLine();
            if (amount % 5 != 0) {
                throw new TopUpException("You can only TopUp in precise multiples of $5.00");
            } else if (amount + balance > 100) {
                throw new OverAmountException("Your credit can not over $100");
            } else {
//                Calendar date = Calendar.getInstance();
//                UsersData.users.get(id).topUp(amount);
//                UsersData.users.get(id).getTopUpHistories().add(new TopUpHistory(balance, date));//add TopUp history

//      TopUp method used to use method in the comment
                UsersData.topUp(id, amount); //topUp
                System.out.println("your current balance is: " + UsersData.checkUserID(id) + "$");
                printBlackLine();
            }
        } catch (TopUpException err) { // others Exceptions
            System.err.println(err);
            System.err.println("Please try again");
            confirmMyTiTopUp(id, balance);
        } catch (OverAmountException errs) {
            System.err.println(errs);
            System.err.println("Please try again");
            confirmMyTiTopUp(id, balance);
        } catch (Exception e) {
            System.err.println("Invalid input, Try again");
            confirmMyTiTopUp(id, balance);
        }
    }

    private void showCreditMenu() { // credit
        String userID;
        System.out.println("Which card ID: ");
        userID = new Scanner(System.in).nextLine();
        double balance = UsersData.checkUserID(userID);
        if (balance != -1) {
//            System.out.println();
            System.out.println("Your balance is: " + balance);
            printBlackLine();
        } else {
            System.err.println("User ID not found, try again");
            menuRun();
        }
    }

    private int checkValidTicket(String id) {  //this method is to check if the ticket is valid;
        int valid = 3;
        try {
            Calendar now = Calendar.getInstance();
            Calendar ticketTime = UsersData.users.get(id).getHistory().get(UsersData.users.get(id).historySize() - 1).getCalendar();
            char ticketType = UsersData.users.get(id).getHistory().get(UsersData.users.get(id).historySize() - 1).getDuration();
//            int ticketZone = UsersData.users.get(id).getHistory().get(UsersData.users.get(id).historySize() - 1).getZone();
//            int thisZone = UsersData.station.get(thisStop).getZone();
            //ticketTime is the most resent ticket time.
            int nowDate = now.get(Calendar.DAY_OF_YEAR);
            int ticketDate = ticketTime.get(Calendar.DAY_OF_YEAR);
            long nowSecend = now.getTimeInMillis();
            long ticketSecend = ticketTime.getTimeInMillis();
            if ((nowDate == ticketDate && nowSecend - ticketSecend <= 7200000) || (nowDate == ticketDate && ticketType == 'D')) {
                //valid;
                valid = 1;
            } else if (nowDate == ticketDate && nowSecend - ticketSecend > 7200000) {
                //buy a one day pass;
                valid = 2;
            } else if (nowDate != ticketDate) {
                //buy a new pass;
                valid = 3;
            }
        } catch (Exception e) {
            valid = 3;
        }
        return valid;
    }

    private void printBlackLine() {
        System.out.println(" ");
    }
}
