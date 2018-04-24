package com.example.avigail.twitter;

import com.example.avigail.twitter.data.TwitterService;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterSession;

/**
 * Created by Avigail on 12.04.2018.
 */

public class СustomTwitterApi extends TwitterApiClient {

    public СustomTwitterApi(Session session){
        super((TwitterSession) session);
    }

    public TwitterService getTwitterService() {
        return getService(TwitterService.class);
    }
    }
