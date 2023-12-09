import java.util.Scanner;//import scanner package
class Customer {
    String acName, acNo, acType;
    int acPin;
    double acBalance;

    // Constructor for the Customer class
    Customer(String accountName, String accountNumber, String accountType, int accountPin, double accountBalance) {
        acName = accountName;
        acNo = accountNumber;
        acType = accountType;
        acPin = accountPin;
        acBalance = accountBalance;
    }
    // Method to display customer information
    void info(String str) {
        System.out.println(str + " Account Details: ");
        System.out.println("Account Name " + acName);
        System.out.println("Account Number " + acNo);
        System.out.println("Account Type " + acType);
        System.out.println("Account Balance " + acBalance);
        System.out.println();
    }
}

class Activity extends Customer {//derived class 
    Activity(String accountName, String accountNumber, String accountType, int accountPin, double accountBalance)
    {
       super(accountName, accountNumber, accountType, accountPin, accountBalance);
    }
    // Method to perform various banking activities
    void process(Activity tharun) {
        int option, ePin;
        double eTransfer, eDeposit, eWithdraw;
        Scanner sc = new Scanner(System.in);
        String choice = "y", eAcName, eAcNo, eType;
        while (choice.equalsIgnoreCase("y")) {
        	System.out.println("**********Welcome to Banking Process****************");
			System.out.println("*** 1. To Check Balance ***");
			System.out.println("*** 2. Deposit Process ***");
			System.out.println("*** 3. Withdrawl Process ***");
			System.out.println("*** 4. Transfer Process ***");
			System.out.println("****************************************************");
            System.out.println("Enter Your Option");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Balance Check");
                    System.out.println("Enter Bank Name");
                    eAcName = sc.next();
                    if (eAcName.equals(acName)) {//checking bank name
                        System.out.println("Enter Account Number");
                        eAcNo = sc.next();
                        if (eAcNo.equals(acNo)) {//checking account number
                            System.out.println("Enter Account Type");
                            eType = sc.next();
                            if (eType.equals(acType)) {//checking account type
                                System.out.println("Enter Account Pin");
                                ePin = sc.nextInt();
                                if (ePin == acPin) {//checking account pin
                                    System.out.println("Your Account Balance is " + acBalance);//display balance
                                } else {
                                    System.out.println("Entered Wrong Pin");
                                }
                            } else {
                                System.out.println("Entered Invalid Account Type");
                            }
                        } else {
                            System.out.println("Entered Wrong Account Number");
                        }
                    } else {
                        System.out.println("Entered Invalid Bank Name");
                    }
                    break;
                case 2:
                    System.out.println("Deposit Money");
                    System.out.println("Enter Bank Name");
                    eAcName = sc.next();
                    if (eAcName.equals(acName)) {
                        System.out.println("Enter Account Number");
                        eAcNo = sc.next();
                        if (eAcNo.equals(acNo)) {
                            System.out.println("Enter Account Type");
                            eType = sc.next();
                            if (eType.equals(acType)) {
                                System.out.println("Enter Account Pin");
                                ePin = sc.nextInt();
                                if (ePin == acPin) {
                                    System.out.println("Enter Amount To Deposit");
                                    eDeposit = sc.nextDouble();//enter amount to deposit
                                    acBalance += eDeposit;//add deposit amount to main account balance
                                    System.out.println("Amount Deposited successfully");
                                } else {
                                    System.out.println("Entered Wrong Pin");
                                }
                            } else {
                                System.out.println("Entered Invalid Account Type");
                            }
                        } else {
                            System.out.println("Entered Wrong Account Number");
                        }
                    } else {
                        System.out.println("Entered Invalid Bank Name");
                    }
                    break;
                case 3:
                    System.out.println("Withdraw Money");
                    System.out.println("Enter Bank Name");
                    eAcName = sc.next();
                    if (eAcName.equals(acName)) {
                        System.out.println("Enter Account Number");
                        eAcNo = sc.next();
                        if (eAcNo.equals(acNo)) {
                            System.out.println("Enter Account Type");
                            eType = sc.next();
                            if (eType.equals(acType)) {
                                System.out.println("Enter Account Pin");
                                ePin = sc.nextInt();
                                if (ePin == acPin) {
                                    System.out.println("Enter Amount To withdraw");
                                    eWithdraw = sc.nextDouble();// enter amount to withdraw
                                    if (eWithdraw > acBalance) {//withdraw amount must be less then the main balance
                                        System.out.println("Insufficient Funds To Withdraw Money");
                                    } else {
                                        acBalance -= eWithdraw;//else  withdraw from main balance
                                        System.out.println("Money successfully withdrawn");
                                    }
                                } else {
                                    System.out.println("Entered Wrong Pin");
                                }
                            } else {
                                System.out.println("Entered Invalid Account Type");
                            }
                        } else {
                            System.out.println("Entered Wrong Account Number");
                        }
                    } else {
                        System.out.println("Entered Invalid Bank Name");
                    }
                    break;
                case 4:
                    System.out.println("Transfer Money");
                    System.out.println(" Enter Bank Name");
                    eAcName = sc.next();
                    if (eAcName.equals(tharun.acName)) {//check account with other account
                        System.out.println("Enter Account Number");
                        eAcNo = sc.next();
                        if (eAcNo.equals(tharun.acNo)) {
                            System.out.println("Enter Account Type");
                            eType = sc.next();
                            if (eType.equals(tharun.acType)) {
                                System.out.println("Enter Your Account Pin");
                                ePin = sc.nextInt();
                                if (ePin == acPin) {//enter your pin to transfer money
                                    System.out.println("Enter Amount To Transfer");
                                    eTransfer = sc.nextDouble();
                                    if (eTransfer > acBalance) {
                                        System.out.println("Insufficient funds To Transfer Money");
                                    } else {
                                        tharun.acBalance += eTransfer;
                                        acBalance -= eTransfer;
                                        System.out.println("Money Transferred successfully");
                                    }
                                } else {
                                    System.out.println("Entered Wrong Pin");
                                }
                            } else {
                                System.out.println("Entered Invalid Account Type");
                            }
                        } else {
                            System.out.println("Entered Wrong Account Number");
                        }
                    } else {
                        System.out.println("Entered Invalid Bank Name");
                    }
                    break;
                default:
                    System.out.println("Entered Invalid Option " + option);
            }
            System.out.println("Do you want to continue? Press 'y' Or press any other key to exit()");
            choice = sc.next();
        }
        System.out.println("Bye");
    }
}

public class Sample1 {

    public static void main(String[] args) {
        Activity varun = new Activity("sbi", "sbi1234", "savings", 9876, 15000);
        Activity tharun = new Activity("axis", "axis67890", "savings", 1234, 60000);
        varun.process(tharun); // Perform banking activities using the 'varun' object
        varun.info("varun"); // Display account details for 'varun'
        tharun.info("tharun"); // Display account details for 'tharun'
    }
}
