package com.example.avigail.twitter.data;

import com.twitter.sdk.android.core.models.User;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Avigail on 12.04.2018.
 */

public interface TwitterService {


    @GET("1.1/account/verify_credentials.json")
    Call<User> getUserData();
}
