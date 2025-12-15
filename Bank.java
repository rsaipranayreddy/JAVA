import java.util.Scanner;
import java.lang.*;

class Account{
    String customerName;
    String accountNumber;
    String accountType;
    double balance;

    Account(String name, String accNo, String accType, double initialBalance) {
        this.customerName = name;
        this.accountNumber = accNo;
        this.accountType = accType;
        this.balance = initialBalance;
    }

    void deposit(double amount){
        balance+=amount;
        System.out.println("Deposited: Rs" + amount);
    }
    void displayBalance(){
        System.out.println("Account Holder: " + customerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Current Balance: Rs " + balance);
    }
}

class SavAcct extends Account{
    double interestRate = 0.05;
    SavAcct(String name, String accNo, double initialBalance) {
        super(name, accNo, "Savings", initialBalance);
    }

    void computeAndDepositInterest(int years) {
        double interest = balance * Math.pow((1 + interestRate), years) - balance;
        balance += interest;
        System.out.println("Interest of Rs" + String.format("%.2f", interest) + " added for " + years + " year(s).");
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance for withdrawal.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: Rs" + amount);
        }
    }
}

class CurAcct extends Account {
    double minimumBalance = 1000;
    double serviceCharge = 100;

    CurAcct(String name, String accNo, double initialBalance) {
        super(name, accNo, "Current", initialBalance);
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance for withdrawal.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: Rs" + amount);
            checkMinimumBalance();
        }
    }

    void checkMinimumBalance() {
        if (balance < minimumBalance) {
            balance -= serviceCharge;
            System.out.println("Balance below minimum. Service charge of Rs" + serviceCharge + " imposed.");
        }
    }

    void chequeBookFacility() {
        System.out.println("Cheque book facility is available.");
    }
}


public class Bank {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);

        System.out.println("Enter Customer Name:");
        String name = obj.nextLine();
        System.out.println("Enter Account Number:");
        String accNo = obj.nextLine();
        System.out.println("Choose Account Type (1. Savings  2. Current):");
        int type = obj.nextInt();

        System.out.println("Enter Initial Deposit:");
        double initial = obj.nextDouble();

        if (type == 1) {
            int deposit,years,withdraw;
            SavAcct sa = new SavAcct(name, accNo, initial);
            while(true){
                System.out.println("1.compute deposit interest\n2.deposit\n3.withdraw\n4.balance\n5.Exit");
                System.out.print("Enter choice:");
                int choice=obj.nextInt();
                switch(choice){
                    case 1:
                        System.out.println("Enter years for claculating interest:");
                        years=obj.nextInt();
                        sa.computeAndDepositInterest(years);
                        break;
                    case 2:
                        System.out.println("Enter deposit amount:");
                        deposit=obj.nextInt();
                        sa.deposit(deposit);
                        break;
                    case 3:
                        System.out.println("Enter withdraw amount:");
                        withdraw=obj.nextInt();
                        sa.withdraw(withdraw);
                        break;
                    case 4:
                        sa.displayBalance();
                        break;
                    case 5:
                        System.exit(1);
                        break;
                    default:
                        System.out.println("invalid choice!");
                }

            }
        } 
        else if (type == 2) {
            CurAcct ca = new CurAcct(name, accNo, initial);
            
            while(true){
                int deposit,withdraw;
                System.out.println("1.deposit\n2.withdraw\n3.cheque Book Facility\n4.balance\n5.Exit");
                System.out.print("Enter choice:");
                int choice=obj.nextInt();
                switch(choice){
                    case 1:
                        System.out.println("Enter deposit amount:");
                        deposit=obj.nextInt();
                        ca.deposit(deposit);
                        break;
                    case 2:
                        System.out.println("Enter withdraw amount:");
                        withdraw=obj.nextInt();
                        ca.withdraw(withdraw);
                        break;
                    case 3:
                        ca.chequeBookFacility();
                        break;

                    case 4:
                        ca.displayBalance();
                        break;
                    case 5:
                        System.exit(1);
                        break;
                    default:
                        System.out.println("invalid choice!");
                }

            }
        } 
        else 
        {
            System.out.println("Invalid account type selected.");
        }

        obj.close();
    }
}
