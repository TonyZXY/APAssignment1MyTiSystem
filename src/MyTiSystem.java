import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import TopUpHistory.*;
import TravelPass.*;

/**
 * Project APAss1,
 * Created by TonyZheng on 16/8/9.
 */
public class MyTiSystem {

    private void mainMenu() { //main menu
        System.out.println("Welcome to MyTi");
        System.out.println("1. Buy a travel pass");
        System.out.println("2. Charge my MyTi");
        System.out.println("3. Show remaining credit");
//        System.out.println("4. Purchase a Journey using a MyTi card");
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

    private void admin(){
        System.out.println("1. Print all Journeys made using all MyTi cards");
        System.out.println("2. Show Station statistics");
        System.out.println("3. Add a new User");
//        System.out.println("4. Create a new MyTi Card");
//        System.out.println("5. Attach a MyTi Card to a User");
        System.out.println("0. Exit");
        System.out.println("Your option:");
    }

    private void adminMenu(){
        System.out.println("Enter Admin username");
        String username = new Scanner(System.in).nextLine();
        System.out.println("Enter Admin Password");
        String password = new Scanner(System.in).nextLine();
        boolean valid =UsersData.checkAdmin(username,password);
        if(valid){
            runAdminMenu();
        }else {
            System.err.println("Invalid Admin user, Exiting");
            menuRun();
        }
    }

    private void runAdminMenu(){
        int m;
        try{
            do{
                admin();
                m = new Scanner(System.in).nextInt();
                switch (m){
                    case 1:
                        printAllJorneys();
                        break;
                    case 2:
                        showStationStatistics();
                        break;
                    case 3:
                        addNewUser();
                        break;
                    case 0:
                        menuRun();
                        break;
                    default:
                        printBlackLine();
                        System.out.println("Invalid Input. Try again.");
                        runAdminMenu();
                }
            }while (m!=0);
        }catch (Exception e){
            printBlackLine();
            System.out.println("Invalid Input, Try again.");
            runAdminMenu();
        }
    }

    private void printAllJorneys(){

    }

    private void showStationStatistics(){

    }

    private void addNewUser(){
        String id;
        String userName;
        String email;
        char type;
        try {
            System.out.println("Enter User id");
            id = new Scanner(System.in).nextLine();
            System.out.println("Enter User Name");
            userName = new Scanner(System.in).nextLine();
            System.out.println("Enter User E-mail Address");
            email = new Scanner(System.in).nextLine();
            System.out.println("Enter User Type");
            System.out.println("(A)Adult,(C)Conssion,(S)Student");
            type = new Scanner(System.in).next().charAt(0);
            UsersData.addNewUser(id,userName,email,type);
        }catch (Exception e){
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
            double rate = UsersData.getRate(userID);
            travelPassPurchaseMenu(userID, balance, rate);
        } else {
            printBlackLine();
            System.err.println("User ID not found. Try again.");
            menuRun();
        }
    }


    private void purchaseTwoHoursPass(String userID, double balance, double rate) { //zone choose (2hours)
        try {
            zoneMenu();
            int m = new Scanner(System.in).nextInt();
            switch (m) {
                case 1:
                    purchaseZoneOneTwoHoursPass(userID, balance, rate);
                    break;
                case 2:
                    purchaseZoneTwoTwoHoursPass(userID, balance, rate);
                    break;
                case 3:
                    selectByStationTwoHoursPass(userID, balance, rate);
                    break;
                case 0:
                    mainMenu();
                    break;
                default:
                    printBlackLine();
                    System.out.println("Invalid Input, Try again.");
                    purchaseTwoHoursPass(userID, balance, rate);
            }
        } catch (InputMismatchException e) {
            printBlackLine();
            System.out.println("Invalid Input, Try again.");
            purchaseTwoHoursPass(userID, balance, rate);
        }

    }

    private void travelPassPurchaseMenu(String id, double balance, double rate) { //purchase choose pass type
        try {
            purchaseMenu();
            int m = new Scanner(System.in).nextInt();
            switch (m) {
                case 1:
                    purchaseTwoHoursPass(id, balance, rate);
                    break;
                case 2:
                    purchaseOneDayPass(id, balance, rate);
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
            travelPassPurchaseMenu(id, balance, rate);
        }

    }

    private void purchaseZoneOneTwoHoursPass(String id, double balance, double rate) { //make purchase of 2hours zone1
        try {
            if (balance - (3.5 * rate) < 0) {
                printBlackLine();
                throw new NoEnoughFundExcpetion("No enough Fund in your card");
            } else {
                UsersData.users.get(id).purchase(3.5 * rate);
                Calendar date = Calendar.getInstance();
                UsersData.users.get(id).getHistory().add(new TwoHoursPassZone1(date, 3.5 * rate));  //add history
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

    private void purchaseZoneTwoTwoHoursPass(String id, double balance, double rate) { //make purchase of 2hours zone1&2
        try {
            if (balance - (5.0 * rate) < 0) {
                printBlackLine();
                throw new NoEnoughFundExcpetion("No enough Fund in your card");
            } else {
                UsersData.users.get(id).purchase(5.0 * rate);
                Calendar date = Calendar.getInstance();
                UsersData.users.get(id).getHistory().add(new TwoHoursPassZone2(date, 5.0 * rate)); //add history
                System.out.println("You successfully purchase 2 hours Zone 1 & Zone 2 travel Pass.");
                printBlackLine();
                menuRun();
            }
        } catch (NoEnoughFundExcpetion err) {
            System.err.println(err);
            menuRun();
        }
    }

    private void purchaseOneDayPass(String id, double balance, double rate) { //day pass menu

        try {
            zoneMenu();
            int m = new Scanner(System.in).nextInt();
            switch (m) {
                case 1:
                    purchaseZoneOneDayPass(id, balance, rate);
                    break;
                case 2:
                    purchaseZoneTwoDayPass(id, balance, rate);
                    break;
                case 3:
                    selectByStationDayPass(id, balance, rate);
                    break;
                case 0:
                    menuRun();
                    break;
                default:
                    printBlackLine();
                    System.out.println("Invalid Input, Try again.");
                    purchaseOneDayPass(id, balance, rate);
            }
        } catch (InputMismatchException e) {
            printBlackLine();
            System.out.println("Invalid Input, Try again.");
            purchaseOneDayPass(id, balance, rate);
        }

    }

    private void purchaseZoneOneDayPass(String id, double balance, double rate) {
        try {
            if (balance - (6.9 * rate) < 0) {
                throw new NoEnoughFundExcpetion("No enough Fund in your card");
            } else {
                UsersData.users.get(id).purchase(6.9 * rate);
                Calendar date = Calendar.getInstance();
                UsersData.users.get(id).getHistory().add(new AllDayPassZone1(date, 6.9 * rate)); //add history
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

    private void purchaseZoneTwoDayPass(String id, double balance, double rate) {
        try {
            if (balance - (9.8 * rate) < 0) {
                throw new NoEnoughFundExcpetion("No enough Fund in your card");
            } else {
                UsersData.users.get(id).purchase(9.8 * rate);
                Calendar date = Calendar.getInstance();
                UsersData.users.get(id).getHistory().add(new AllDayPassZone2(date, 9.8 * rate)); //add history
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

    private void selectByStationTwoHoursPass(String id, double balance, double rate) { //select by station name 2 hours pass
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
                purchaseZoneOneTwoHoursPass(id, balance, rate);
            } else if ((thisZone == 1 && destnationZone == 2) || (thisZone == 2 && destnationZone == 1) || (thisZone == 2 && destnationZone == 2)) {
                purchaseZoneTwoTwoHoursPass(id, balance, rate);
            }

        } catch (Exception e) {
            printBlackLine();
            System.err.println("Invalid input, Try again");
            selectByStationTwoHoursPass(id, balance, rate);
        }
    }

    private void selectByStationDayPass(String id, double balance, double rate) { //select by station name day pass
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
                purchaseZoneOneDayPass(id, balance, rate);
            } else if ((thisZone == 1 && destnationZone == 2) || (thisZone == 2 && destnationZone == 1) || (thisZone == 2 && destnationZone == 2)) {
                purchaseZoneTwoDayPass(id, balance, rate);
            }
        } catch (Exception e) {
            printBlackLine();
            System.out.println("Invalid input, Try again");
            selectByStationDayPass(id, balance, rate);
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
                UsersData.topUp(id,amount); //topUp
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

    private void printBlackLine() {
        System.out.println(" ");
    }
}
