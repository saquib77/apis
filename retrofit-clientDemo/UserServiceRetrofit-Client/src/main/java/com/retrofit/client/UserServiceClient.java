package com.retrofit.client;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

import com.retrofit.model.UserResponse;
import com.retrofit.service.UserService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

@Service
public class UserServiceClient {
	
	public List<UserResponse> getAllUser(){
		List<UserResponse> list = null;
		Retrofit retrofit = RetrofitInstance.getInstance();
		UserService userService = retrofit.create(UserService.class);
		Call<List<UserResponse>> callSync = userService.getAllUser();
		try {
			Response<List<UserResponse>> response = callSync.execute();
			list = response.body();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public UserResponse getUser(UUID id) {
		UserResponse userRes=null;
		Retrofit retrofit = RetrofitInstance.getInstance();
		UserService userService = retrofit.create(UserService.class); 
		Call<UserResponse> callSync = userService.getUserById(id);
		try {
			Response<UserResponse> response = callSync.execute();
			userRes = response.body();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userRes;
	}
}
