import java.util.ArrayList;
import java.util.AbstractList;

public class ContactList extends AbstractList {

    // instance variable
    private ArrayList<String> contactList;

    // constructor
    // to-do: initializes an empty contact list
    public ContactList() {
        this.contactList = new ArrayList<String>();
    }

    // methods

    // to-do: findInsertLocation(String name)
    /**
     * returns the location in the contact list where the name should go to keep the
     * alphabetized
     */
    private int findInsertLocation(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Null Input");
        }
        for (int i = 0; i < contactList.size(); i++) {
            if ((Character.getNumericValue(name.charAt(0))) < (Character
                    .getNumericValue((contactList.get(i)).charAt(0)))) {
                return i;
            }
        }
        // You can use a sequential search here. But for a Stretch Challenge, try to do
        // a binary search.
        return contactList.size();
    }

    // to-do: add(String name)
    /**
     * adds a name to the contact list so that the list remains alphabetized, it
     * prints out which
     * name is being added, also the method prevents duplicate names from being
     * added
     */
    public boolean add(String name) {
        System.out.println("+ Adding " + name);
        for (int i = 0; i < contactList.size(); i++) {
            if (name.equals(contactList.get(i))) {
                System.out.println(name + " is alreday in the contact list.");
                return false;
            }
        }
        if (name == null) {
            throw new IllegalArgumentException("Input is Null");
        }
        contactList.add(findInsertLocation(name), name);
        return true;
    }

    // to-do: add(ArrayList<String> names)
    /* this method adds a list of names to the contact list */
    public void add(ArrayList<String> names) {
        for (String name : names) {
            add(name);
        }
    }

    // to-do: remove(String name)
    /** removes name from the contact list and keeps list alphabetized */
    public boolean remove(String name) {
        System.out.println("- Removing " + name);
        for (int i = 0; i < contactList.size(); i++) {
            if (name.equals(contactList.get(i))) {
                contactList.remove(i);
                return true;
            }
        }
        return false;
    }

    // to-do: remove(ArrayList<String> names)
    /* this method removes a list of names from the contact list */
    public void remove(ArrayList<String> names) {
        for (String name : names) {
            remove(name);
        }
    }

    /** returns a String containing all of the words in list */
    public String toString() {
        return "Contact List: " + contactList.toString();
    }

    // to-do: get(int index)
    /** returns the name at the specified index */
    public String get(int index) {
        return contactList.get(index);
    }

    // to-do: size()
    /** returns the number of names in the contact list */
    public int size() {
        return contactList.size();
    }

    // to-do: clear()
    /** removes all names from the contact list */
    public void clear() {
        System.out.println("Clearing the contact list");
        contactList.removeAll(contactList);
    }

}
