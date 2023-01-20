package model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"FirstName",
"LastName",
"Age",
"id",
"Address",
"PhoneNumbers"
})
public class Person {

@JsonProperty("FirstName")
private String firstName;
@JsonProperty("LastName")
private String lastName;
@JsonProperty("Age")
private Integer age;
@JsonProperty("id")
private Integer id;
@JsonProperty("Address")
private String address;
@JsonProperty("PhoneNumbers")
private String phoneNumbers;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("FirstName")
public String getFirstName() {
return firstName;
}

@JsonProperty("FirstName")
public void setFirstName(String firstName) {
this.firstName = firstName;
}

@JsonProperty("LastName")
public String getLastName() {
return lastName;
}

@JsonProperty("LastName")
public void setLastName(String lastName) {
this.lastName = lastName;
}

@JsonProperty("Age")
public Integer getAge() {
return age;
}

@JsonProperty("Age")
public void setAge(Integer age) {
this.age = age;
}

@JsonProperty("id")
public Integer getId() {
return id;
}

@JsonProperty("id")
public void setId(Integer id) {
this.id = id;
}

@JsonProperty("Address")
public String getAddress() {
return address;
}

@JsonProperty("Address")
public void setAddress(String address) {
this.address = address;
}

@JsonProperty("PhoneNumbers")
public String getPhoneNumbers() {
return phoneNumbers;
}

@JsonProperty("PhoneNumbers")
public void setPhoneNumbers(String phoneNumbers) {
this.phoneNumbers = phoneNumbers;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}