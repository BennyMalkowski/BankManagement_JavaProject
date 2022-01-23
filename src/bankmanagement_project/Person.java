package bankmanagement_project;

/**
 *
 * @author Santiago Benito
 */
public class Person {

    private String nif;
    private String name;

    public Person(String nif, String name) {
        this.nif = nif;
        this.name = name;
    }

    public String getNif() {
        return nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSame(Person person) {
        if (person.getNif().equalsIgnoreCase(this.nif)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSame(String idNumber) {
        if (idNumber.equalsIgnoreCase(this.nif)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String exit = this.name + "(" + ")" + this.nif;
        return exit;
    }

}
