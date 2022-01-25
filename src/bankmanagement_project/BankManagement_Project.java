package bankmanagement_project;

import java.util.Scanner;

/**
 *
 * @author Santiago Benito
 */
public class BankManagement_Project {

    static Scanner sc = new Scanner(System.in);
    static Scanner sc2 = new Scanner(System.in);

    public static void main(String[] args) {
        Person holder = new Person("334446665", "Tobias Spencer");

        bankAccount account = new bankAccount(1122334455, holder);

        Person woman1 = new Person("19222433Y", "Linda Watson");
        Person woman2 = new Person("22888444D", "Amanda Banks");
        Person man1 = new Person("22888444D", "Ben Ashcroft");

        do {
            String answer = menu();
            switch (answer) {
                case "0":
                    System.out.println("Thank you for using our app");
                    return;
                case "1":
                    menuAddMoney(account);
                    break;
                case "2":
                    menuTakeMoney(account);
                    break;
                      case "3":
                          System.out.println(account.accountInfo());
                    break;
                default:
                    System.out.println("You must select a correct number");
            }
        } while (true);
    }

    public static String menu() {
        String answer;
        System.out.println("BANK ACCOUNT MANAGEMENT");
        
        System.out.println("1-Deposit money.");
        System.out.println("2-Withdraw money."); 
        System.out.println("3-Info Account. \n");
        System.out.println("0-Exit.");
        answer = sc.nextLine();
        return answer;
    }

    public static void menuAddMoney(bankAccount account) {
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String blue = "\u001B[34m";

        System.out.println("How much money do you want to deposit?");
        double amount = Double.parseDouble(sc.nextLine());
        switch (account.depositMoney(amount)) {
            case 0:
                System.out.println(green + "Your deposit of " + amount + "€ has been made successfully");
                System.out.println(blue + "Balance: " + account.getFormattedBalance());
                break;
            case 1:
                System.out.println(red + "----- WARNING: NOTIFY THE TREASURY -----");
                System.out.println(blue + "Balance: " + account.getFormattedBalance());
                break;
            case -1:
                System.out.println(red + "The banking operation could not be carried out");
                System.out.println(blue + "Balance: " + account.getFormattedBalance());
            default:
                System.out.println(red + "You must select a normal amount");
        }
    }

    public static void menuTakeMoney(bankAccount account) {
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String blue = "\u001B[34m";

        System.out.println("How much money do you want to withdraw from your account?");
        double amount = sc2.nextDouble();
        int takeMoney = (int) account.takeMoney(amount);
        
        switch (takeMoney) {
            case 0:
                System.out.println(green + "Your withdraw of " + amount + "€ has been made successfully");
                System.out.println(blue + "Balance: " + account.getFormattedBalance());
                break;
            case 1:
                System.out.println(green + "Your withdraw of " + amount + "€ has been made successfully");
                System.out.println(red + "----- WARNING: NEGATIVE BALANCE -----");
                System.out.println(blue + "Balance: " + account.getFormattedBalance());
                break;
            case -1:
                System.out.println(red + "The banking operation could not be carried out. You have no money");
                System.out.println(blue + "Balance: " + account.getFormattedBalance());
                break;
            default:
                System.out.println(red + "You must select a normal amount");
                break;
        }
    }
}
