package tests;

import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Util.ConfigManager;
import helpers.PersonServiceHelper;
import model.Person;

public class TestGetPerson {

	public static PersonServiceHelper psh;
	
	@BeforeTest
	public void init() {
		ConfigManager.getInstance();
		psh = new PersonServiceHelper();
	}

	@Test
	public void getAll() {
		List<Person> list = psh.getAllPerson();
		assertNotNull(list, "Person list is not null");
	}
}
