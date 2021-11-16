package com.example.demo.client;

import java.util.UUID;

import com.example.demo.models.User;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import io.reactivex.Single;
import retrofit2.http.Query;

public interface Client {

	@GET("api/v1/user/{id}")
	Single<Response<User>> getUser(@Path("id") UUID id);

	@GET("api/v1/user/email")
	Single<Response<User>> getUserByEmail(@Query(value = "email") String email);
}
