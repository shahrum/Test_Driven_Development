package com.hanselnpetal.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.hanselnpetal.domain.CustomerContact;

@RunWith(SpringRunner.class) // This is test :D
@SpringBootTest(webEnvironment = WebEnvironment.NONE) // Let know this is an spring boot application and I dont want any
														// Of my controller run during this test
public class ContactsManagementServiceIntegrationTest {

	// This is the component I want to test :)
	@Autowired
	private ContactsManagementService contactsManagementService;

	// This is my real first test
	@Test
	public void testAddContactHappyPath() {

		// Create a contact
		CustomerContact aContact = new CustomerContact();
		aContact.setFirstName("Jenny");
		aContact.setLastName("Johnson");
		aContact.setEmail("jeny@gmail.com");

		// Test adding the contact
		CustomerContact newContact = contactsManagementService.add(aContact);

		// Verify the addition
		//Is what I sent and What I received Are Same !
		assertNotNull(newContact);
		
		// Does it have an Id
		assertNotNull(newContact.getId());
		
		// A simple comparison between what I expect and what I received
		assertEquals("Jenny", newContact.getFirstName()); 

	}
}
