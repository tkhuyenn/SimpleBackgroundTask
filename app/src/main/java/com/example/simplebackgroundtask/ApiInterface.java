package com.example.simplebackgroundtask;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("users")
    Call<ArrayList<User>> getAllUsers();

    @GET("users/{id}")
    Call<User> getUsersByID(@Path("id") int id);

    String token = "113de560946cf253f1a1fd89d55f700fb3239247a3ab04982ba447f502863238";
    @POST("users?access-token=" + token)
    Call<User> addUser(@Body() User user);

    @DELETE("users/{id}?access-token=" + token)
    Call<ResponseBody> deleteUser(@Path("id") int id);
}
