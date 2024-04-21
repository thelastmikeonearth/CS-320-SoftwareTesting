package Test;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ContactService.Contact;

class ContactTest {

	@Test
	void contactIdIsValid() {
		var contactId = "1234567890";
		Contact contact = new Contact(contactId, "Mike", "Damico", "20 Orchard", "5558675309");
		Assert.assertEquals(contactId, contact.getContactId());
	}

	@Test
	void contactIdIsNull() {
		var contactId = (String)null;
		Assert.assertThrows(Exception.class, 
							() -> new Contact(contactId, "Mike", "Damico", "20 Orchard", "5558675309"));
	}

	@Test
	void contactIdIsLongerThanTenCharacters() {
		var contactId = "12345678910";
		Assert.assertThrows(Exception.class, 
							() -> new Contact(contactId, "Mike", "Damico", "20 Orchard", "5558675309"));
	}
	
	@Test
	void firstNameIsValid() {
		var firstName = "1234567890";
		Contact contact = new Contact("1", firstName, "Damico", "20 Orchard", "5558675309");
		Assert.assertEquals(firstName, contact.getFirstName());
	}

	@Test
	void firstNameIsNull() {
		var firstName = (String)null;
		Assert.assertThrows(Exception.class, 
							() -> new Contact("1", firstName, "Damico", "20 Orchard", "5558675309"));
	}

	@Test
	void firstNameIsLongerThanTenCharacters() {
		var firstName = "12345678910";
		Assert.assertThrows(Exception.class, 
							() -> new Contact("1", firstName, "Damico", "20 Orchard", "5558675309"));
	}

	@Test
	void updateFirstNameIsValid() {
		Contact contact = new Contact("1", "Mike", "Damico", "20 Orchard", "5558675309");

		var firstName = "1234567890";
		contact.setFirstName(firstName);
		Assert.assertEquals(firstName, contact.getFirstName());
	}

	@Test
	void updateFirstNameIsNull() {
		Contact contact = new Contact("1", "Mike", "Damico", "20 Orchard", "5558675309");
		
		var firstName = (String)null;
		Assert.assertThrows(Exception.class, 
							() -> contact.setFirstName(firstName));
		Assert.assertNotEquals(firstName, contact.getFirstName());
	}

	@Test
	void updateFirstNameIsLongerThanTenCharacters() {
		Contact contact = new Contact("1", "Mike", "Damico", "20 Orchard", "5558675309");
		
		var firstName = "12345678910";
		Assert.assertThrows(Exception.class, 
							() -> contact.setFirstName(firstName));
		Assert.assertNotEquals(firstName, contact.getFirstName());
	}

	@Test
	void lastNameIsValid() {
		var lastName = "1234567890";
		Contact contact = new Contact("1", "Michael", lastName, "20 Orchard", "5558675309");
		Assert.assertEquals(lastName, contact.getLastName());
	}

	@Test
	void lastNameIsNull() {
		var lastName = (String)null;
		Assert.assertThrows(Exception.class, 
							() -> new Contact("1", "Michael", lastName, "20 Orchard", "5558675309"));
	}

	@Test
	void lastNameIsLongerThanTenCharacters() {
		var lastName = "12345678910";
		Assert.assertThrows(Exception.class, 
							() -> new Contact("1", "Michael", lastName, "20 Orchard", "5558675309"));
	}

	@Test
	void updateLastNameIsValid() {
		Contact contact = new Contact("1", "Mike", "Damico", "20 Orchard", "5558675309");

		var lastName = "1234567890";
		contact.setLastName(lastName);
		Assert.assertEquals(lastName, contact.getLastName());
	}

	@Test
	void updateLastNameIsNull() {
		Contact contact = new Contact("1", "Mike", "Damico", "20 Orchard", "5558675309");
		
		var lastName = (String)null;
		Assert.assertThrows(Exception.class, 
							() -> contact.setLastName(lastName));
		Assert.assertNotEquals(lastName, contact.getLastName());
	}

	@Test
	void updateLastNameIsLongerThanTenCharacters() {
		Contact contact = new Contact("1", "Mike", "Damico", "20 Orchard", "5558675309");
		
		var lastName = "12345678910";
		Assert.assertThrows(Exception.class, 
							() -> contact.setLastName(lastName));
		Assert.assertNotEquals(lastName, contact.getLastName());
	}
	
	@Test
	void addressIsValid() {
		var address = "20 Orchard";
		Contact contact = new Contact("1", "Michael", "Damico", address, "5558675309");
		Assert.assertEquals(address, contact.getAddress());
	}

	@Test
	void addressIsNull() {
		var address = (String)null;
		Assert.assertThrows(Exception.class, 
							() -> new Contact("1", "Michael", "Damico", address, "5558675309"));
	}

	@Test
	void addressIsLongerThanThirtyCharacters() {
		var address = "1234567891012345678910123456789101";
		Assert.assertThrows(Exception.class, 
							() -> new Contact("1", "Michael", "Damico", address, "5558675309"));
	}

	@Test
	void updateAddressIsValid() {
		Contact contact = new Contact("1", "Mike", "Damico", "20 Orchard", "5558675309");

		var address = "1234567890";
		contact.setAddress(address);
		Assert.assertEquals(address, contact.getAddress());
	}

	@Test
	void updateAddressIsNull() {
		Contact contact = new Contact("1", "Mike", "Damico", "20 Orchard", "5558675309");
		
		var address = (String)null;
		Assert.assertThrows(Exception.class, 
							() -> contact.setAddress(address));
		Assert.assertNotEquals(address, contact.getAddress());
	}

	@Test
	void updateAddressIsLongerThanThirtyCharacters() {
		Contact contact = new Contact("1", "Mike", "Damico", "20 Orchard", "5558675309");
		
		var address = "1234567891012345678910123456789101";
		Assert.assertThrows(Exception.class, 
							() -> contact.setFirstName(address));
		Assert.assertNotEquals(address, contact.getAddress());
	}

	@Test
	void phoneNumberIsValid() {
		var phoneNumber = "5551237654";
		Contact contact = new Contact("1", "Michael", "Damico", "20 Orchard", phoneNumber);
		Assert.assertEquals(phoneNumber, contact.getPhoneNumber());
	}

	@Test
	void phoneNumberIsNull() {
		var phoneNumber = (String)null;
		Assert.assertThrows(Exception.class, 
							() -> new Contact("1", "Michael", "Damico", "20 Orchard", phoneNumber));
	}

	@Test
	void phoneNumberIsLongerThanTenCharacters() {
		var phoneNumber = "12345678910";
		Assert.assertThrows(Exception.class, 
							() -> new Contact("1", "Michael", "Damico", "20 Orchard", phoneNumber));
	}

	@Test
	void phoneNumberIsLessThanTenCharacters() {
		var phoneNumber = "123456789";
		Assert.assertThrows(Exception.class, 
							() -> new Contact("1", "Michael", "Damico", "20 Orchard", phoneNumber));
	}
	@Test
	void updatePhoneNumberIsValid() {
		Contact contact = new Contact("1", "Mike", "Damico", "20 Orchard", "5558675309");

		var phoneNumber = "1234567890";
		contact.setPhoneNumber(phoneNumber);
		Assert.assertEquals(phoneNumber, contact.getPhoneNumber());
	}

	@Test
	void updatePhoneNumberIsNull() {
		Contact contact = new Contact("1", "Mike", "Damico", "20 Orchard", "5558675309");
		
		var phoneNumber = (String)null;
		Assert.assertThrows(Exception.class, 
							() -> contact.setPhoneNumber(phoneNumber));
		Assert.assertNotEquals(phoneNumber, contact.getPhoneNumber());
	}

	@Test
	void updatePhoneNumberIsLongerThanTenCharacters() {
		Contact contact = new Contact("1", "Mike", "Damico", "20 Orchard", "5558675309");
		
		var phoneNumber = "12345678910";
		Assert.assertThrows(Exception.class, 
							() -> contact.setPhoneNumber(phoneNumber));
		Assert.assertNotEquals(phoneNumber, contact.getPhoneNumber());
	}

	@Test
	void updatePhoneNumberIsLessThanTenCharacters() {
		Contact contact = new Contact("1", "Mike", "Damico", "20 Orchard", "5558675309");
		
		var phoneNumber = "123456789";
		Assert.assertThrows(Exception.class, 
							() -> contact.setPhoneNumber(phoneNumber));
		Assert.assertNotEquals(phoneNumber, contact.getPhoneNumber());
	}
}
