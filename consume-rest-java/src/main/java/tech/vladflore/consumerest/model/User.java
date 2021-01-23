package tech.vladflore.consumerest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"id",
		"name",
		"username",
		"email",
		"address",
		"phone",
		"website",
		"company"
})
public class User {

	@JsonProperty("id")
	public Integer id;

	@JsonProperty("name")
	public String name;

	@JsonProperty("username")
	public String username;

	@JsonProperty("email")
	public String email;

	@JsonProperty("address")
	public Address address;

	@JsonProperty("phone")
	public String phone;

	@JsonProperty("website")
	public String website;

	@JsonProperty("company")
	public Company company;

	public String getUsername() {
		return username;
	}
}
