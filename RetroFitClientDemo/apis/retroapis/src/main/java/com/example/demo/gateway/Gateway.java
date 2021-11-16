package com.example.demo.gateway;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.example.demo.client.Client;
import com.example.demo.models.User;

import retrofit2.Response;

@Component
public class Gateway {
	@Autowired
	private Client client;

	public Optional<User> getUser(UUID id) {
		Response<User> userResp = client.getUser(id).blockingGet();
		if (!userResp.isSuccessful()) {
			return Optional.empty();
		} else if (userResp.code() == HttpStatus.BAD_REQUEST.value()) {
			return Optional.empty();
		}
		return Optional.of(userResp.body());
	}

	public Optional<User> getUserByEmail(String email) {
		Response<User> userResp = client.getUserByEmail(email).blockingGet();
		if (!userResp.isSuccessful()) {
			return Optional.empty();
		} else if (userResp.code() == HttpStatus.BAD_REQUEST.value()) {
			return Optional.empty();
		}
		return Optional.of(userResp.body());
	}
}
