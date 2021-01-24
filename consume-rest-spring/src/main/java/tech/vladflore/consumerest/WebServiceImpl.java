package tech.vladflore.consumerest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebServiceImpl implements WebService {

	private final RestTemplate restTemplate;

	@Value("${targetUrl}")
	private String targetUrl;

	public WebServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public String fetchAllUsers() {
		return restTemplate.getForObject(targetUrl, String.class);
	}
}
