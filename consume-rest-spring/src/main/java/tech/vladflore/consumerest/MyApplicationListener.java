package tech.vladflore.consumerest;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.vladflore.consumerest.model.User;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener implements ApplicationListener<ApplicationReadyEvent> {

	private static final Logger logger = LoggerFactory.getLogger(ConsumeRestApplication.class);

	private final WebService webService;

	public MyApplicationListener(@Qualifier("webServiceReactiveImpl") WebService webService) {
		this.webService = webService;
	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
		String users = webService.fetchAllUsers();
		List<User> userList;
		try {
			userList = new ObjectMapper().readValue(users, new TypeReference<>() {});
			List<String> usernames = userList.stream().map(User::getUsername).sorted().collect(Collectors.toList());
			logger.info(usernames.toString());
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
