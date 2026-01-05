package com.pet.cleanemail.dto;

public record GmailProfile(
	String emailAddress,
	long messagesTotal,
	long threadsTotal,
	String historyId
) {
}
