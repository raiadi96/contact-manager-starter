package com.programming.techie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactManagerTest {

	@Test
	void shouldCreateContact() {
		ContactManager contactManager = new ContactManager();
		contactManager.addContact("ramesh", "suresh", "0123456789");
		Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
		Assertions.assertEquals(1, contactManager.getAllContacts().size());
		Assertions.assertTrue(contactManager.getAllContacts().stream().filter(contact -> 
			contact.getFirstName().equals("ramesh")
		).findAny().isPresent());
	}
	
	@Test
	void shouldValidateFirstName() {
		ContactManager contactManager = new ContactManager();
		Assertions.assertThrows(RuntimeException.class,()->{ contactManager.addContact(null, "suresh", "0123456789");});
	}
	
	@Test
	void shouldValidateLastName() {
		ContactManager contactManager = new ContactManager();
		Assertions.assertThrows(RuntimeException.class,()->{ contactManager.addContact("ramesh", null, "0123456789");});
	}
	
	@Test
	void shouldValidatePhoneNumber() {
		ContactManager contactManager = new ContactManager();
		Assertions.assertThrows(RuntimeException.class,()->{ contactManager.addContact("ramesh", "suresh", "1123456789");});
	}

}
 