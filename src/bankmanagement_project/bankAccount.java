package bankmanagement_project;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Santiago Benito
 */
public class bankAccount {

    private long numAccount;
    private Person accountHolder;
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

    public String seeAuthorized() {
        return authorized.toString();
    }
}
