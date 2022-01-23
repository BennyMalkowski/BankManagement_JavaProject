package bankmanagement_project;

/**
 *
 * @author Santiago Benito
 */
public class BankManagement_Project {

    public static void main(String[] args) {
        Person holder = new Person("334446665", "Tobias Spencer");

        bankAccount account1 = new bankAccount(1122334455, holder);

        Person woman1 = new Person("19222433Y", "Linda Watson");
        Person woman2 = new Person("22888444D", "Amanda Banks");
        Person man1 = new Person("22888444D", "Ben Ashcroft");

        if (account1.isAuthorized(woman1)) {
            System.out.println(woman1.getName() + " has been authorized.");
        }
        if (account1.isAuthorized(woman2)) {
            System.out.println(woman2.getName() + " has been authorized.");
        }
        if (account1.isAuthorized(man1)) {
                System.out.println(man1.getName() + " has been authorized.");
            }
        if (woman2.isSame(man1)) {
            System.out.println(woman2 + " and " + man1 + " have the same ID Number");
        }
        System.out.println("Authorised persons on the account: " + account1.seeAuthorized());
        
    } 
}
