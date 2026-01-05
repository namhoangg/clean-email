package com.pet.cleanemail.client;

import com.pet.cleanemail.dto.GmailProfile;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class GmailClient {

	private final RestClient restClient;

	public GmailClient(RestClient.Builder builder) {
		this.restClient = builder
			.baseUrl("https://gmail.googleapis.com/gmail/v1")
			.build();
	}

	public GmailProfile getProfile(String accessToken) {
		return restClient
			.get()
			.uri("/users/me/profile")
			.header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
			.retrieve()
			.body(GmailProfile.class);
	}
}
