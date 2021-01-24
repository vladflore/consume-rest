package tech.vladflore.consumerest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"street",
		"suite",
		"city",
		"zipcode",
		"geo"
})
public class Address {

	@JsonProperty("street")
	public String street;

	@JsonProperty("suite")
	public String suite;

	@JsonProperty("city")
	public String city;

	@JsonProperty("zipcode")
	public String zipcode;

	@JsonProperty("geo")
	public Geo geo;

}
