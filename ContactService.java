package ContactService;
import java.util.ArrayList;
import java.util.List;

public class ContactService {

    private static List<Contact> contacts = new ArrayList<Contact>(); 

    public List<Contact> addContact(Contact newContact) throws Exception {
        // Check that the contact id is unique for all contacts
        for (Contact contact : contacts) {
            if (contact.getContactId() == newContact.getContactId()) {
                throw new Exception("ContactId already in use");
            }
        }
        // Add the contact to contacts
        contacts.add(newContact);
        return contacts;
    }

    public List<Contact> deleteContact(String contactId) throws Exception {
        try {
            var contact = getContact(contactId);

            // If the id does exist, delete the contact from the list of contacts
            contacts.remove(contact);
        } catch (Exception ex) {
            throw ex;
        }

        return contacts;
    }

    public Contact updateContactFirstName(String contactId, String firstName) throws Exception {
        try {
            var contact = getContact(contactId);

            // If the contact exists, update the first name
            contact.setFirstName(firstName);
            return contact;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public Contact updateContactLastName(String contactId, String lastName) throws Exception {
        try {
            var contact = getContact(contactId);

            // If the contact exists, update the last name
            contact.setLastName(lastName);
            return contact;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public Contact updateContactPhoneNumber(String contactId, String phoneNumber) throws Exception {
        try {
            var contact = getContact(contactId);
    
            // If the contact exists, update the phone number
            contact.setPhoneNumber(phoneNumber);
            return contact;
            } catch (Exception ex) {
                throw ex;
            }
    }

    public Contact updateContactAddress(String contactId, String address) throws Exception {
        try {
        var contact = getContact(contactId);

        // If the contact exists, update the address
        contact.setAddress(address);
        return contact;
        } catch (Exception ex) {
            throw ex;
        }
    }

    private Contact getContact(String contactId) throws Exception {

        // Search for the contact with the id
        for (Contact contact : contacts) {
            if (contact.getContactId() == contactId) {
                return contact;
            }
        }
        // If the id does not exist, throw an error
        throw new Exception("Contact Not Found");
    }
}
