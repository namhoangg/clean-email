package com.pet.cleanemail.controller;

import com.pet.cleanemail.dto.GmailProfile;
import com.pet.cleanemail.service.GmailService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gmail")
public class GmailController {

	private final GmailService gmailService;

	public GmailController(GmailService gmailService) {
		this.gmailService = gmailService;
	}

	@GetMapping("/profile")
	public GmailProfile profile(
		@RegisteredOAuth2AuthorizedClient("google") OAuth2AuthorizedClient authorizedClient
	) {
		return gmailService.getProfile(authorizedClient);
	}
}
