package tech.vladflore.consumerest;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.vladflore.consumerest.model.User;

public class UseCase {

	private WebService webService;

	public List<String> listUsernamesAlphabetically() {
		String users = webService.fetchAllUsers();
		try {
			List<User> userList = new ObjectMapper().readValue(users, new TypeReference<>() {});
			return userList.stream().map(User::getUsername).sorted().collect(Collectors.toList());
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public void setWebService(WebService webService) {
		this.webService = webService;
	}
}
