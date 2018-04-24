package com.example.avigail.twitter.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.avigail.twitter.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Avigail on 12.04.2018.
 */

public abstract class BaseFragment extends Fragment {
    private ProgressDialog mDialog;
    private Unbinder unbinder;

    protected abstract int getViewLayout();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivity()!= null){
            mActivity=getActivity();
        }

    }

    private FragmentActivity mActivity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getViewLayout(),container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }
    protected void showProgressBar(String msg){
        if (mDialog == null){
            mDialog = new ProgressDialog(mActivity);
            mDialog.setMessage(msg==null? getString(R.string.please_wait):msg);
            mDialog.setCancelable(false);
            mDialog.show();
        }
    }

    protected void dismissProgressBar(){
        if (mDialog!= null && mDialog.isShowing()){
            mDialog.dismiss();
        }
        mDialog=null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
