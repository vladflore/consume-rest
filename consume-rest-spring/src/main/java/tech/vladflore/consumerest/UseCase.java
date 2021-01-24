package tech.vladflore.consumerest;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.vladflore.consumerest.model.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UseCase implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(ConsumeRestApplication.class);

	private final WebService webService;

	public UseCase(WebService webService) {
		this.webService = webService;
	}

	@Override
	public void run(String... args) throws Exception {
		String users = webService.fetchAllUsers();
		List<User> userList = new ObjectMapper().readValue(users, new TypeReference<>() {});
		List<String> usernames = userList.stream().map(User::getUsername).sorted().collect(Collectors.toList());
		logger.info(usernames.toString());
	}
}
