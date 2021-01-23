package tech.vladflore.consumerest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UseCaseTest {

	private static WebService webService;

	@BeforeAll
	static void setup() {
		webService = Mockito.mock(WebServiceImpl.class);
	}

	@Test
	@DisplayName("should list all usernames in alphabetical order")
	void listUsernamesAlphabetically() {
		Mockito.when(webService.fetchAllUsers()).thenReturn(getUsersAsString());
		UseCase useCase = new UseCase();
		useCase.setWebService(webService);

		List<String> users = useCase.listUsernamesAlphabetically();

		List<String> expected = Arrays.asList("Antonette", "Bret");
		assertEquals(expected, users);
	}

	private String getUsersAsString() {
		InputStream usersStream = getClass().getClassLoader().getResourceAsStream("getUsers.json");
		return new BufferedReader(new InputStreamReader(Objects.requireNonNull(usersStream), StandardCharsets.UTF_8))
				.lines()
				.collect(Collectors.joining(System.lineSeparator()));
	}

}
