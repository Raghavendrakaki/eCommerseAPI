package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Util.ConfigManager;
import helpers.PersonServiceHelper;
import io.restassured.response.Response;

public class TestDeletePerson {
	public static PersonServiceHelper psh;
	@BeforeTest
	public void init() {
		ConfigManager.getInstance();
		psh = new PersonServiceHelper();

		// test code 2
		// Testcode2

	}

	@Test
	public void deletePersonTest() {
		Response rs = psh.deletePerson();
	}
}
