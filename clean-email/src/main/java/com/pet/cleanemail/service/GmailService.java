package com.pet.cleanemail.service;

import com.pet.cleanemail.client.GmailClient;
import com.pet.cleanemail.dto.GmailProfile;
import org.springframework.stereotype.Service;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;

@Service
public class GmailService {

	private final GmailClient gmailClient;

	public GmailService(GmailClient gmailClient) {
		this.gmailClient = gmailClient;
	}

	public GmailProfile getProfile(OAuth2AuthorizedClient authorizedClient) {
		if (authorizedClient == null || authorizedClient.getAccessToken() == null) {
			throw new IllegalStateException("Missing OAuth2 access token");
		}

		return gmailClient.getProfile(authorizedClient.getAccessToken().getTokenValue());
	}
}
