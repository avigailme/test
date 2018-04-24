package com.example.avigail.twitter.ui;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.avigail.twitter.R;
import com.example.avigail.twitter.СustomTwitterApi;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.models.User;
import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Avigail on 12.04.2018.
 */

public class ProfileFragment extends BaseFragment {
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.tvDetails)
    TextView tvDetails;


    @Override
    protected int getViewLayout() {
        return R.layout.fragment_profile;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        getProfileData();
    }

    private void getProfileData(){
        СustomTwitterApi twitterApi = new СustomTwitterApi(TwitterCore
                .getInstance()
                .getSessionManager()
                .getActiveSession());
        Call<User> call = twitterApi.getTwitterService().getUserData();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful() &&response.body()!=null){
                    tvDetails.setText(response.body().name);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
