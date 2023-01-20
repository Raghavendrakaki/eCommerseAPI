package tests;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Util.ConfigManager;
import helpers.PersonServiceHelper;
import io.restassured.response.Response;

public class TestPostPerson {

public static PersonServiceHelper psh;
	
	@BeforeTest
	public void init() {
		ConfigManager.getInstance();
		psh = new PersonServiceHelper();
	}

	@Test
	public void createPersonTest() {
		Response rs = psh.CreatePerson();
		assertNotNull(rs.jsonPath().get("id"), "Person id is not null");
	}

}
