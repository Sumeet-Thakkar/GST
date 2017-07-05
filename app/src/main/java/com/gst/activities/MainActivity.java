package com.gst.activities;

import android.opengl.Visibility;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.gst.GSTApplication;
import com.gst.R;
import com.gst.fragments.HomeFragment;
import com.gst.utils.FragmentUtil;
import com.gst.utils.Validation;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.gst.utils.Methods.hideKeyboard;


public class MainActivity extends AppCompatActivity {

    public FragmentUtil fragmentUtil;
    MainActivity mActivity;

    GSTApplication GSTApplication;

    @BindView(R.id.rl_header)
    RelativeLayout rl_header;

    @BindView(R.id.iv_back)
    ImageView iv_back;

    @BindView(R.id.tv_title)
    TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivity = MainActivity.this;
        fragmentUtil = new FragmentUtil(mActivity);

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        GSTApplication = (GSTApplication) this.getApplicationContext();


        fragmentUtil.addFragment(new HomeFragment(), false, false);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        hideKeyboard(mActivity);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    /**
     * Show message in snack bar.
     *
     * @param message: showing message.
     */
    public void showSnackBar(String message) {

        hideKeyboard(this);

        if (!Validation.isRequiredField(message)) return;


        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
/*        if (!Validation.isRequiredField(message)) {
            return;
        }
        Snackbar snackbar = Snackbar.make(coordinatorLayout, "" + message, Snackbar.LENGTH_LONG);
        View snackbarView = snackbar.getView();

        snackbarView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        TextView textView = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(13);

        textView.setTextColor(getResources().getColor(R.color.colorAccent));
        snackbar.show();*/
    }

    /**
     * Set header title.
     */
    public void setHeaderTitle(String Title) {

        iv_back.setVisibility(View.VISIBLE);
        tv_title.setText(Title);
    }
}
