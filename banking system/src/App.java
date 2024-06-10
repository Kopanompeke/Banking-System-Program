import java.time.LocalDateTime;
import java.util.Scanner;

public class App {

    static String details, addie, answer, account;
    static int IDnumber, signin, pin, PersonalAccNumber = 12345,
            SavingsAccNumber = 67890, deposit, withdraw, transfer;
    static double balance = 0.00, newbalance, PersonalAccbalance, SavingsAccbalance;

    static void userDetals() {
        System.out.println("WELCOME TO ABSA,MY NAME IS KOPANO AND ILL BE HELPING YOU OPEN AN ACCOUNT TODAY");
        Scanner k = new Scanner(System.in);
        System.out.println("May i please have your name and surname:");
        details = k.nextLine();
        System.out.println("May i please have your residential address:");
        addie = k.nextLine();
        System.out.println("May i please have your IDnumber:");
        IDnumber = k.nextInt();
        System.out.println("you maybe enter any 4 numbers  of your choice that will be your ATM pin");
        pin = k.nextInt();
        System.out.println("********************************************************************");
        System.out.println("Account holder`s name:" + details);
        System.out.println("Personal Account number:" + PersonalAccNumber);
        System.out.println("Savings Account number:" + SavingsAccNumber);
        System.out.println("Initial PersonalAccbalance:" + "R" + balance);
        System.out.println("Initial SavingsAccbalance:" + "R" + balance);
        System.out.println("Account pin:" + pin);
        System.out.println("Address:" + " " + addie);
        System.out.println("********************************************************************");

    }

    static void Login() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        Scanner k = new Scanner(System.in);
        System.out.println("enter pin to sign in");
        signin = k.nextInt();
        if (signin == pin) {
            Deposit();
        } else {
            Login();
        }
        System.out.println("********************************************************************");
    }

    static void Deposit() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        Scanner k = new Scanner(System.in);
        System.out.println("Enter the amount to deposit:");
        deposit = k.nextInt();
        System.out.println("on which account,PersonalAccount(a) or SavingsAccount(b):");
        account = k.next();
        if (account.equalsIgnoreCase("a")) {
            PersonalAccbalance = deposit + balance;
            System.out.println("Personal Account balance:" + " " + "R" + PersonalAccbalance + " " + currentDateTime);
        } else if (account.equalsIgnoreCase("b")) {
            SavingsAccbalance = deposit + balance;
            System.out.println("Savings Account balance:" + " " + "R" + SavingsAccbalance + " " + currentDateTime);
        }

    }

    static void accountActivity() {
        Scanner k = new Scanner(System.in);
        System.out.println("Do wish to transfer(a) or withdraw(b) or statement(c):");
        answer = k.next();
        if (answer.equalsIgnoreCase("a")) {
            Transfer();
        } else if (answer.equalsIgnoreCase("b")) {
            Withdraw();
        } else if (answer.equalsIgnoreCase("c")) {
            Statement();
        }
    }

    static void Transfer() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        Scanner k = new Scanner(System.in);
        System.out.println("Enter the amount to transfer:");
        transfer = k.nextInt();
        if (account.equalsIgnoreCase("a")) {
            if (transfer < PersonalAccbalance) {
                newbalance = PersonalAccbalance - transfer;
                System.out.println("Personal Account balance:" + " " + "R" + newbalance + " " + currentDateTime);
                accountActivity();
            } else {
                System.out.println("insufficent funds.your balance is:" + " " + "R" + PersonalAccbalance);
                Transfer();
            }

        } else if (account.equalsIgnoreCase("b")) {
            if (transfer < SavingsAccbalance) {
                newbalance = SavingsAccbalance - transfer;
                System.out.println("Savings Account balance:" + " " + "R" + newbalance + " " + currentDateTime);
            } else {
                System.out.println("insufficent funds.your balance is:" + " " + "R" + SavingsAccbalance);
                Transfer();
            }

        }
        System.out.println("********************************************************************");
    }

    static void Withdraw() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        Scanner k = new Scanner(System.in);
        System.out.println("Enter the amount to withdraw:");
        withdraw = k.nextInt();
        if (account.equalsIgnoreCase("a")) {
            if (withdraw < PersonalAccbalance) {
                newbalance = PersonalAccbalance - withdraw;
                System.out.println("Personal Account balance:" + " " + "R" + newbalance + " " + currentDateTime);

            } else {
                System.out.println("insufficent funds.your balance is:" + " " + "R" + PersonalAccbalance);
                Withdraw();

            }
        } else if (account.equalsIgnoreCase("b")) {
            if (withdraw < SavingsAccbalance) {
                newbalance = SavingsAccbalance - withdraw;
                System.out.println("Savings Account balance:" + " " + "R" + newbalance + " " + currentDateTime);
            } else {
                System.out.println("insufficent funds.your balance is:" + " " + "R" + SavingsAccbalance);
                Withdraw();

            }

        }
        System.out.println("********************************************************************");
    }

    static void Statement() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("CAPITEC BANK LIMITED:");
        System.out.println("5 Neutron Road");
        System.out.println("Techno Park");
        System.out.println("Stellenbosch");
        System.out.println("7600");
        System.out.println("Branch code:470010");
        System.out.println("Transaction Date:" + " " + currentDateTime);
        System.out.println("**********************************************************************");
        System.out.println("Account holder`s name:" + details);
        System.out.println("ID Number: " + IDnumber);
        System.out.println("Address:" + " " + addie);
        System.out.println("Personal Account number:" + PersonalAccNumber);
        System.out.println("Savings Account number:" + SavingsAccNumber);
        System.out.println("Personal Account balance:" + " " + PersonalAccbalance);
        System.out.println("Savings Account balance:" + " " + SavingsAccbalance);

    }

    public static void main(String[] args) throws Exception {
        userDetals();
        Login();
        // Deposit();
        accountActivity();
        // Transfer();
        // Withdraw();
        // Statement();
    }
}