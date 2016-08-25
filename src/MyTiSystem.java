import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Project APAss1,
 * Created by TonyZheng on 16/8/9.
 */
public class MyTiSystem {
    private void mainMenu(){ //main menu
        System.out.println("Welcome to MyTi");
        System.out.println("1. Buy a travel pass");
        System.out.println("2. Charge my MyTi");
        System.out.println("3. Show remaining credit");
//        System.out.println("4. Purchase a Journey using a MyTi card");
        System.out.println("0. Quit");
        System.out.println("Choose an option:");
    }
    
    private void purchaseMenu(){ //option 1
        System.out.println("What time period");
        System.out.println("1. 2 Hours");
        System.out.println("2. All Day");
        System.out.println("0. Cancel");
        System.out.println("Your option:");
    }
    
    private void zoneMenu(){ //option 1
        System.out.println("Which zone: ");
        System.out.println("1. Zone 1");
        System.out.println("2. Zone 1 and 2");
        System.out.println("3. Select by Station");
        System.out.println("0. Cancel");
        System.out.println("Your option:");
    }
    
//    private Scanner keyPad = new Scanner(System.in);
    
    public void menuRun(){
        int m;
        try{
            do {
                mainMenu();
                m = new Scanner(System.in).nextInt();
                switch (m){
                    case 1: travelPassPurchase();
                        break;
                    case 2: chargeMyTiCard();
                        break;
                    case 3: showCreditMenu();
                        break;
//                    case 4: journeyPurchase();
//                        break;
//                    case 0: waitingForCustomer();
//                        break;
                    default:
                        System.out.println("Invalid Input, Try again.");
                        menuRun();
                }
            }while(m!=0);
        }catch (InputMismatchException e){
            System.out.println("Invalid Input, Try again.");
            menuRun();
        }
    }
    
    private void travelPassPurchase(){ //check user info
        String userID;
        System.out.print("Which card ID: ");
        userID = new Scanner(System.in).nextLine();
        double balance = UsersData.checkUserID(userID);
        if(balance!=-1){
            double rate = UsersData.getRate(userID);
            travelPassPurchaseMenu(userID,balance,rate);
        }else {
            System.err.println("User ID not found. Try again.");
            menuRun();
        }
    }
    
    private void purchaseTwoHoursPass(String userID,double balance,double rate){ //zone choose (2hours)
        try {
            zoneMenu();
            int m = new Scanner(System.in).nextInt();
            switch (m) {
                case 1:
                    purchaseZoneOneTwoHoursPass(userID, balance,rate);
                    break;
                case 2:
                    purchaseZoneTwoTwoHoursPass(userID, balance,rate);
                    break;
                case 3: selectByStationTwoHoursPass(userID,balance,rate);
                    break;
                case 0:
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid Input, Try again.");
                    purchaseTwoHoursPass(userID, balance,rate);
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid Input, Try again.");
            purchaseTwoHoursPass(userID,balance,rate);
        }
        
    }
    
    private void travelPassPurchaseMenu(String id,double balance,double rate) { //purchase choose pass type
        try {
            purchaseMenu();
            int m = new Scanner(System.in).nextInt();
            switch (m) {
                case 1:
                    purchaseTwoHoursPass(id, balance,rate);
                    break;
                case 2:
                    purchaseOneDayPass(id, balance,rate);
                    break;
                case 0:
                    menuRun();
                    break;
                default:
                    System.out.println("Invalid Input, Try again.");
                    travelPassPurchase();
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid Input, Try again.");
            travelPassPurchaseMenu(id,balance,rate);
        }
        
    }
    
    private void purchaseZoneOneTwoHoursPass(String id,double balance,double rate){ //make purchase of 2hours zone1
        try{
            if(balance - (3.5*rate)<0){
                throw new NoEnoughFundExcpetion("No enough Fund in your card");
            }else{
                UsersData.users.get(id).purchase(3.5*rate);
                System.out.println("You successfully purchase 2 hours Zone 1 travel Pass.");
                menuRun();
            }
        }catch (NoEnoughFundExcpetion e){
            System.err.println(e);
            menuRun();
        }
    }
    
    private void purchaseZoneTwoTwoHoursPass(String id,double balance,double rate){ //make purchase of 2hours zone1&2
        try{
            if(balance - (5.0*rate)<0){
                throw new NoEnoughFundExcpetion("No enough Fund in your card");
            }else{
                UsersData.users.get(id).purchase(5.0*rate);
                System.out.println("You successfully purchase 2 hours Zone 1 & Zone 2 travel Pass.");
                menuRun();
            }
        }catch (NoEnoughFundExcpetion err){
            System.err.println(err);
            menuRun();
        }
    }
    
    private void purchaseOneDayPass(String id,double balance,double rate){ //day pass menu
        
        try {
            zoneMenu();
            int m = new Scanner(System.in).nextInt();
            switch (m) {
                case 1:
                    purchaseZoneOneDayPass(id, balance,rate);
                    break;
                case 2:
                    purchaseZoneTwoDayPass(id, balance,rate);
                    break;
                case 3:
                    selectByStationDayPass(id,balance,rate);
                    break;
                case 0:
                    menuRun();
                    break;
                default:
                    System.out.println("Invalid Input, Try again.");
                    purchaseOneDayPass(id, balance,rate);
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid Input, Try again.");
            purchaseOneDayPass(id,balance,rate);
        }
        
    }
    
    private void purchaseZoneOneDayPass(String id, double balance,double rate){
        try{
            if(balance - (6.9* rate)< 0 ){
                throw new NoEnoughFundExcpetion("No enough Fund in your card");
            }else{
                UsersData.users.get(id).purchase(6.9*rate);
                System.out.println("You successfully purchase 1 day Zone 1 travel Pass.");
                menuRun();
            }
        }catch(NoEnoughFundExcpetion err){
            System.err.println(err);
            menuRun();
        }
    }
    
    private void purchaseZoneTwoDayPass(String id,double balance,double rate){
        try{
            if(balance - (9.8*rate)< 0 ){
                throw new NoEnoughFundExcpetion("No enough Fund in your card");
            }else{
                UsersData.users.get(id).purchase(9.8);
                System.out.println("You successfully purchase 1 day Zone 1 & Zone 2 travel Pass.");
                menuRun();
            }
        }catch (NoEnoughFundExcpetion err){
            System.err.println(err);
            menuRun();
        }
    }

    private void selectByStationTwoHoursPass(String id,double balance,double rate) { //select by station name 2 hours pass
        try {
            System.out.println("Station Name    :  Zone");
            for (int i = 0; i < UsersData.stationsName.size(); i++) {
                System.out.println(UsersData.stationsName.get(i));
            }
            System.out.println("Please enter station name:");
            String thisStop = "Central";
            String destnationStop = new Scanner(System.in).nextLine();
            int thisZone = UsersData.station.get(thisStop).getZone();
            int destnationZone = UsersData.station.get(destnationStop).getZone();
            if (thisZone == 1 && destnationZone == 1) {
                purchaseZoneOneTwoHoursPass(id, balance,rate);
            } else if ((thisZone == 1 && destnationZone == 2) || (thisZone == 2 && destnationZone == 1) || (thisZone == 2 && destnationZone == 2)) {
                purchaseZoneTwoTwoHoursPass(id, balance,rate);
            }
    
        }catch(Exception e){
            System.err.println("Invalid input, Try again");
            selectByStationTwoHoursPass(id,balance,rate);
        }
    }
    
    private void selectByStationDayPass(String id,double balance,double rate){ //select by station name day pass
        try{
            System.out.println("Station Name    :  Zone");
            for (int i = 0; i < UsersData.stationsName.size(); i++) {
                System.out.println(UsersData.stationsName.get(i));
            }
            System.out.println("Please enter station name:");
            String thisStop = "Central";
            String destnationStop = new Scanner(System.in).nextLine();
            int thisZone = UsersData.station.get(thisStop).getZone();
            int destnationZone = UsersData.station.get(destnationStop).getZone();
            if(thisZone == 1 && destnationZone == 1){
                purchaseZoneOneDayPass(id,balance,rate);
            }else if((thisZone == 1 && destnationZone == 2) || (thisZone == 2 && destnationZone == 1) || (thisZone == 2 && destnationZone == 2)){
                purchaseZoneTwoDayPass(id,balance,rate);
            }
        }catch(Exception e){
            System.out.println("Invalid input, Try again");
            selectByStationDayPass(id,balance,rate);
        }
    }
    
    private void chargeMyTiCard(){ //check user id before TopUp
        String userID;
        System.out.print("Which card ID: ");
        userID = new Scanner(System.in).nextLine();
        double balance = UsersData.checkUserID(userID);
        if(balance!=-1){
            confirmMyTiTopUp(userID,balance);
        }else {
            System.err.println("User ID not found. Try again.");
            menuRun();
        }
    }
    
    private void confirmMyTiTopUp(String id,double balance){  //check if valid
        try{
            System.out.println("Your current balance is: " + balance + "$");
            System.out.println("How much to TopUp:");
            double amount = new Scanner(System.in).nextInt();
            if(amount%5!=0){
                throw new TopUpException("You can only TopUp in precise multiples of $5.00");
            }else if(amount+balance>100){
                throw new OverAmountException("Your credit can not over $100");
            }else{
                UsersData.users.get(id).topUp(amount);
            }
        }catch (TopUpException err){
            System.err.println(err);
            System.err.println("Please try again");
            confirmMyTiTopUp(id,balance);
        }catch (OverAmountException errs){
            System.err.println(errs);
            System.err.println("Please try again");
            confirmMyTiTopUp(id,balance);
        }catch(Exception e){
            System.err.println("Invalid input, Try again");
            confirmMyTiTopUp(id,balance);
        }
    }
    
    private void showCreditMenu(){
        String userID;
        System.out.println("Which card ID: ");
        userID = new Scanner(System.in).nextLine();
        double balance = UsersData.checkUserID(userID);
        if(balance!=-1){
            System.out.println("Your balance is: "+ balance);
        }else{
            System.err.println("User ID not found, try again");
            menuRun();
        }
    }
}
