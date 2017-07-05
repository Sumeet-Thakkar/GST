package com.gst.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gst.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class UnderstandingFragment extends BaseFragment implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calculator, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        mActivity.setHeaderTitle("");

        mLinearLayoutManager = new LinearLayoutManager(mActivity);
        recyclerView.setLayoutManager(mLinearLayoutManager);

    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        btn_gst_rule.setOnClickListener(this);

    }

    @Override
    public void onResume() {
        super.onResume();

    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.btn_gst_rule:
//                fragmentUtil.addFragmentIgnorIfCurrent(new SettingFragment(), true, true);
//                break;
//
//            case R.id.btn_gst_understanding:
//                fragmentUtil.addFragmentIgnorIfCurrent(new SettingFragment(), true, true);
//                break;
//
//            case R.id.btn_gst_calculator:
//                fragmentUtil.addFragmentIgnorIfCurrent(new SettingFragment(), true, true);
//                break;
        }
    }



    @Override
    public void onRefresh() {


    }
}
