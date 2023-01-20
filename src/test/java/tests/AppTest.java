package tests;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Util.ConfigManager;
import helpers.PersonServiceHelper;
import io.restassured.response.Response;

/**
 * Unit test for simple App.
 */
public class AppTest {
	public static PersonServiceHelper psh;

	@BeforeTest
	public void init() {
		ConfigManager.getInstance();
		psh = new PersonServiceHelper();
	}

	@Test(priority=0)
	public void createPersonTest() {
		Response rs = psh.CreatePerson();
		assertNotNull(rs.jsonPath().get("id"), "Person id is not null");
	}
	@Test(priority=1)
	public void patchPersonTest() {
		Response rs = psh.patchUpdatePerson();
		assertNotNull(rs.jsonPath().get("id"), "Person id is not null");
	}
	@Test(priority=2)
	public void deletePersonTest() {
		Response rs = psh.deletePerson();
	}
}
