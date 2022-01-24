package bankmanagement_project;

import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * @author Santiago Benito
 */
public class bankAccount {

    private long numAccount;
    private Person accountHolder;
    private double balance = 0;
    private Set<Person> authorized = new HashSet<>();

    public bankAccount(long numAccount, Person accountHolder) {
        this.numAccount = numAccount;
        this.accountHolder = accountHolder;
    }

    public long getNumAccount() {
        return numAccount;
    }

    public Person getAccountHolder() {
        return accountHolder;
    }

    public Set<Person> getAuthorized() {
        return authorized;
    }

    public void setAuthorized(Set<Person> authorized) {
        this.authorized = authorized;
    }

    public boolean isAuthorized(Person whoIsAuthorized) {
        return authorized.add(whoIsAuthorized);
    }

    public double getBalance() {
        return balance;
    }

    public String seeAuthorized() {
        return authorized.toString();
    }

    public String getFormattedBalance() {
        NumberFormat formatImport = NumberFormat.getCurrencyInstance(new Locale("es", "ES"));
        return formatImport.format(balance);
    }

    public int depositMoney(double amount) {
        if (amount > 0 && amount < 3000) {
            balance += amount;
            return 0;
        } else if (amount >= 3000) {
            balance += amount;
            return 1;
        } else {
            return -1;
        }
    }

    public double takeMoney(double amount) {
        if (amount > 0) {
            if (this.balance - amount <= -50) {
                return -1;
            }
            if (this.balance - amount > 0 && this.balance > -50) {
                this.balance -= amount;
                return 0;
            }
            this.balance -= amount;
            return 1;
        } else {
            return -2;
        }
    }

}
