package com.retrofit.client;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
	public static Retrofit getInstance() {
		OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
		Retrofit retrofit = new Retrofit.Builder()
		          .baseUrl("http://localhost:8080/api/v1/")
		          .addConverterFactory(GsonConverterFactory.create())
		          .client(httpClient.build())
		          .build();
		return retrofit;
	}
}
