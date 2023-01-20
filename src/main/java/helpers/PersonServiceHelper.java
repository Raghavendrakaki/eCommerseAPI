package helpers;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import Util.ConfigManager;
import constants.EndPoints;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Person;

public class PersonServiceHelper {
	public static final String BaseURI = ConfigManager.getInstance().getString("baseUrl");
	// public static final String BasePost =
	// ConfigManager.getInstance().getString("port");

	public PersonServiceHelper() {
		RestAssured.baseURI = BaseURI.toString();
		// RestAssured.basePath = ;
		RestAssured.useRelaxedHTTPSValidation();
	}

	public List<Person> getAllPerson() {
		Response rs = RestAssured.given().contentType(ContentType.JSON).get(EndPoints.GET_ALL_PERSON).andReturn();

		java.lang.reflect.Type type = new TypeRef<List<Person>>() {
		}.getType();
		List<Person> pers = rs.as(type);
		assertEquals(rs.getStatusCode(), HttpStatus.SC_OK, "OK");
		rs.prettyPrint();
		return pers;

	}

	public Response CreatePerson() {
		Person person = new Person();
		person.setFirstName("Raghavendra");
		person.setAge(28);
		person.setId(457);
		person.setLastName("Kaki");
		person.setPhoneNumbers("951445852");
		Response rs = RestAssured.given().contentType(ContentType.JSON).when().body(person)
				.post(EndPoints.CREATE_PERSON).andReturn();

		assertEquals(rs.getStatusCode(), HttpStatus.SC_CREATED, "CREATED");
		rs.prettyPrint();
		return rs;

	}
	public Response patchUpdatePerson() {
		Person person = new Person();
		person.setFirstName("Raghavendra-1");
		
		person.setPhoneNumbers("951445852updated");
		Response rs = RestAssured.given().contentType(ContentType.JSON).pathParam("id",457).when().body(person)
				.patch(EndPoints.UPDATE_PERSON).andReturn();

		assertEquals(rs.getStatusCode(), HttpStatus.SC_OK, "OK");
		rs.prettyPrint();
		return rs;

	}

	public Response deletePerson() {
		Response rs = RestAssured.given().contentType(ContentType.JSON).pathParam("id",457).when()
				.delete(EndPoints.DELETE_PERSON).andReturn();

		assertEquals(rs.getStatusCode(), HttpStatus.SC_OK, "OK");
		rs.prettyPrint();
		return rs;
	}

}
