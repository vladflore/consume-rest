package tech.vladflore.consumerest;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(properties = { "targetUrl=http://dummy-url.com/users" })
class ConsumeRestApplicationTests {

	@MockBean
	private UseCase useCase;

	@MockBean
	private MyApplicationListener myApplicationListener;

	@Test
	void contextLoads() {
		assertThat(useCase).isNotNull();
		assertThat(myApplicationListener).isNotNull();
	}

}
