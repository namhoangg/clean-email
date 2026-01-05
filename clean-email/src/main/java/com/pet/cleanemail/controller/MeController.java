package com.pet.cleanemail.controller;

import java.util.Map;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeController {

	@GetMapping("/api/me")
	public Map<String, Object> me(@AuthenticationPrincipal OAuth2User user) {
		return Map.of(
			"name", user.getAttribute("name"),
			"email", user.getAttribute("email")
		);
	}
}
