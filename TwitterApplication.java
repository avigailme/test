package com.example.avigail.twitter;

import android.app.Application;

import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;


/**
 * Created by Avigail on 12.04.2018.
 */

public class TwitterApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TwitterAuthConfig twitterAuthConfig = new TwitterAuthConfig(
                getString(R.string.CONSUMER_KEY),
                getString(R.string.CONSUMER_SECRET)
        );
        TwitterConfig twitterConfig = new TwitterConfig
                .Builder(this)
                .twitterAuthConfig(twitterAuthConfig)
                .build();

        Twitter.initialize(twitterConfig);


    }
}
