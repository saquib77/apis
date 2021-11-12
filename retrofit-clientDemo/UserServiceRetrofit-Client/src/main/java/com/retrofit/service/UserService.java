package com.retrofit.service;

import java.util.List;
import java.util.UUID;

import com.retrofit.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {
	
	@GET("user/{id}")
	public Call<UserResponse> getUserById(@Path("id") UUID id);
	
	@GET("user/list")
	public Call<List<UserResponse>> getAllUser();
}
