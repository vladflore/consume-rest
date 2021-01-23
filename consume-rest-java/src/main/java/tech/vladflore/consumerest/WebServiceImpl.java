package tech.vladflore.consumerest;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Objects;

public class WebServiceImpl implements WebService {

	private final String targetUrl;

	private final HttpClient client = HttpClient.newHttpClient();

	public WebServiceImpl(String targetUrl) {
		this.targetUrl = Objects.requireNonNull(targetUrl);
	}

	@Override
	public String fetchAllUsers() {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(targetUrl))
				.build();
		return client.sendAsync(request, BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.join();
	}
}
