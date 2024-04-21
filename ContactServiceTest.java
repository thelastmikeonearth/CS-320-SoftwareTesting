package Test;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ContactService.Contact;
import ContactService.ContactService;

class ContactServiceTest {

	ContactService service = new ContactService();
	List<String> cleanUpContactIds = new ArrayList<String>();

	@AfterEach
	void afterEach() throws Exception {
		for (var contactId : cleanUpContactIds) {
				try {
					service.deleteContact(contactId);
				} catch (Exception ex) {
					// keep going if there's a failure
				}
		}
		cleanUpContactIds = new ArrayList<String>();
	}

	@Test
	void addContactValid() throws Exception {
		var contact = new Contact("1", "Mike", "Damico", "20 Orchard Drive", "5558675309");
		cleanUpContactIds.add(contact.getContactId());

		var result = service.addContact(contact);
		Assert.assertTrue(result.contains(contact));
	}

	@Test
	void addContactWithDuplicateId() throws Exception {
		// Create a contact
		var contact = new Contact("1", "Mike", "Damico", "20 Orchard", "5558675309");
		cleanUpContactIds.add(contact.getContactId());

		// Add that contact to contacts
		service.addContact(contact);
		// Create another contact with the same id as the first contact
		var contact2 = new Contact(contact.getContactId(), "Mara", "D'Amico", "276 Railroad St", "5558093456");

		// Assert that the method throws when you attempt to add the second contact
		Assert.assertThrows(Exception.class, 
							() -> service.addContact(contact2));
	}

	@Test
	void deleteContactValid() throws Exception {
		// Create a contact
		var contact = new Contact("1", "Mike", "Damico", "20 Orchard", "5558675309");
		cleanUpContactIds.add(contact.getContactId());
		// Add the contact to the list of contacts
		service.addContact(contact);
		// Delete the contact from the list of contacts (service.deleteContact(contact.getContactId()))
		var result = service.deleteContact(contact.getContactId());
		Assert.assertFalse(result.contains(contact));
	}

	@Test
	void deleteContactWithIdThatDoesNotExist() {
		// Attempt to delete any contact id and verify that it throws
		Assert.assertThrows(Exception.class, 
							() -> service.deleteContact("any string"));
	}

	@Test
	void updateFirstNameValid() throws Exception {
		// Create a contact
		var contact = new Contact("1", "Mike", "Damico", "20 Orchard", "5558675309");
		cleanUpContactIds.add(contact.getContactId());
		service.addContact(contact);

		// Update the first name of the contact
		var firstName = "Mara";
		var result = service.updateContactFirstName(contact.getContactId(), firstName);
		// Verify that the contact's first name is updated
		Assert.assertEquals(firstName, result.getFirstName());
	}

	@Test
	void updateFirstNameWithIdThatDoesNotExist() {
		// Attempt to update the first name of a contact with any id and verify that it throws
		Assert.assertThrows(Exception.class, 
							() -> service.updateContactFirstName("any string", "Mara"));
	}

	@Test
	void updateLastNameValid() throws Exception{
		// Create a contact
		var contact = new Contact("1", "Mike", "Damico", "20 Orchard", "5558675309");
		cleanUpContactIds.add(contact.getContactId());
		service.addContact(contact);
		
		// Update the last name of the contact
		var lastName = "Smith";
		var result = service.updateContactLastName(contact.getContactId(), lastName);
		// Verify that the contact's last name is updated
		Assert.assertEquals(lastName, result.getLastName());
	}

	@Test
	void updateLastNameWithIdThatDoesNotExist() {
		// Attempt to update the last name of a contact with any id and verify that it throws
		Assert.assertThrows(Exception.class, 
							() -> service.updateContactLastName("any string", "Smith"));
	}

	@Test
	void updatePhoneNumberValid() throws Exception{
		// Create a contact
		var contact = new Contact("1", "Mike", "Damico", "20 Orchard", "5558675309");
		cleanUpContactIds.add(contact.getContactId());
		service.addContact(contact);
		
		// Update the phone number of the contact
		var phoneNumber = "1236546789";
		var result = service.updateContactPhoneNumber(contact.getContactId(), phoneNumber);
		// Verify that the contact's phone number is updated
		Assert.assertEquals(phoneNumber, result.getPhoneNumber());
	}

	@Test
	void updatePhoneNumberWithIdThatDoesNotExist() {
		// Attempt to update the phone number of a contact with any id and verify that it throws
		Assert.assertThrows(Exception.class, 
							() -> service.updateContactPhoneNumber("any string", "1234567890"));
	}

	@Test
	void updateAddressValid() throws Exception{
		// Create a contact
		var contact = new Contact("1", "Mike", "Damico", "20 Orchard", "5558675309");
		cleanUpContactIds.add(contact.getContactId());
		service.addContact(contact);
		
		// Update the address of the contact
		var address = "276 Railroad St";
		var result = service.updateContactAddress(contact.getContactId(), address);
		// Verify that the contact's address is updated
		Assert.assertEquals(address, result.getAddress());
	}

	@Test
	void updateAddressWithIdThatDoesNotExist() {
		// Attempt to update the address of a contact with any id and verify that it throws
		Assert.assertThrows(Exception.class, 
							() -> service.updateContactAddress("any string", "20 Orchard Drive"));
	}

}
