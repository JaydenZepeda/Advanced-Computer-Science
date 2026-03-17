import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.AbstractList;

public class ContactList extends AbstractList<Contact> {
    private ArrayList<Contact> contactList;

    public ContactList() {
        this.contactList = new ArrayList<Contact>();
    }

    public boolean add(Contact contact) {
        contact.verifyNumber(contact.getTelephoneNumber());
        contact.verifyNumberFixNum(contact.getTelephoneNumber());
        for (int i = 0; i < contactList.size(); i++) {
            if (contact.compareTo(contactList.get(i)) == 0
                    || contact.getTelephoneNumber().compareTo(contactList.get(i).getTelephoneNumber()) == 0) {
                return false;
            }
        }
        contactList.add(contact);
        return true;
    }

    public boolean remove(Contact contact) {
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).compareTo(contact) == 0) {
                contactList.remove(contact);
                return true;
            }
        }
        return false;
    }

    public void sortByFirstName() {
        Collections.sort(contactList);
    }

    public void sortByLastName() {
        for (int i = 1; i < contactList.size(); i++) {
            Contact key = contactList.get(i);
            int index = i - 1;
            while (index >= 0 && contactList.get(index).compareForLastNameSort(key) > 0) {
                contactList.set(index + 1, contactList.get(index));
                index--;
            }
            contactList.set(index + 1, key);
        }
    }

    public void sortByTelephoneNumber() {
        for (int i = 0; i < contactList.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < contactList.size(); j++) {
                if (contactList.get(j).getTelephoneNumber()
                        .compareTo(contactList.get(minIndex).getTelephoneNumber()) < 0) {
                    minIndex = j;
                }
            }
            Contact temp = contactList.get(minIndex);
            contactList.set(minIndex, contactList.get(i));
            contactList.set(i, temp);
        }
    }

    public Contact searchContacts(String telephoneNumber) {
        for (int i = 0; i < contactList.size(); i++) {
            if (telephoneNumber.equals(contactList.get(i).getTelephoneNumber())) {
                return contactList.get(i);
            }
        }
        return null;
    }

    public String toString() {
        String totalString = "Contact List:\n";
        for (Contact contact : contactList) {
            totalString += contact.toString() + "\n";
        }
        return totalString;
    }

    @Override
    public int size() {
        return contactList.size();
    }

    @Override
    public Contact get(int index) {
        return contactList.get(index);
    }
}
