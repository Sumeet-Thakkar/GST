package com.gst.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.gst.GSTApplication;
import com.gst.activities.MainActivity;
import com.gst.utils.FragmentUtil;
import com.gst.utils.Methods;


/**
 * Created by mind on 22/2/17.
 */

public class BaseFragment extends Fragment {

    public MainActivity mActivity;
    public FragmentUtil fragmentUtil;
    Resources mResources;
//    public ConnectionUtil connectionUtil;
    GSTApplication GSTApplication;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivity = (MainActivity) getActivity();
        fragmentUtil = new FragmentUtil(mActivity);
        mResources = mActivity.getResources();
//        connectionUtil = new ConnectionUtil();
        new Methods((MainActivity) getActivity());
//        new APIUtil((MainActivity) getActivity());
        GSTApplication = (GSTApplication) getActivity().getApplicationContext();

    }
}
