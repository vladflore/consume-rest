package tech.vladflore.consumerest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebServiceReactiveImpl implements WebService {

	@Value("${targetUrl}")
	private String targetUrl;

	@Override
	public String fetchAllUsers() {
		String baseUrl = targetUrl.substring(0, targetUrl.lastIndexOf('/'));
		WebClient webClient = WebClient.create(baseUrl);
		return webClient
				.get()
				.uri("/users")
				.accept(MediaType.TEXT_PLAIN)
				.exchangeToMono(res -> res.bodyToMono(String.class))
				.block();
	}
}
