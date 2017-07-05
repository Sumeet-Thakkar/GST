package com.gst.fragments;


import android.content.SyncStatusObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.gst.R;
import com.gst.utils.Methods;
import com.marshalchen.ultimaterecyclerview.expanx.Util.parent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends BaseFragment {

//    @BindView(R.id.btn_gst_rule)
//    Button btn_gst_rule;

    @BindView(R.id.et_amount)
    EditText et_amount;

    @BindView(R.id.sp_percentage)
    Spinner sp_percentage;

//    @BindView(R.id.cb_include_gst)
//    CheckBox cb_include_gst;
//
//    @BindView(R.id.cb_exclude_gst)
//    CheckBox cb_exclude_gst;

    @BindView(R.id.tv_original_cost)
    TextView tv_original_cost;

    @BindView(R.id.tv_gst_perc)
    TextView tv_gst_perc;

    @BindView(R.id.tv_gst_price)
    TextView tv_gst_price;

    @BindView(R.id.tv_net_price)
    TextView tv_net_price;

    @BindView(R.id.radioGST)
    RadioGroup radioGST;



    String Selected_GST_Percentage = "";
    int Amount = 0;

    String Value1 = "Select GST Percentage";
    String Value2 = "5%";
    String Value3 = "12%";
    String Value4 = "18%";
    String Value5 = "28%";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calculator, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        mActivity.setHeaderTitle("GST Calculator");

        sp_percentage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String item = sp_percentage.getItemAtPosition(position).toString();

                Selected_GST_Percentage = item;

                switch(Selected_GST_Percentage)
                {
                    case "Value1":

                        break;

                }
                // Showing selected spinner item
                Toast.makeText(mActivity, "Selected: " + item, Toast.LENGTH_LONG).show();
                int selectedId = radioGST.getCheckedRadioButtonId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        et_amount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Toast.makeText(mActivity,"beforeTextChanged"+charSequence.toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                SetValues(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        // Spinner Drop down elements
        List<String> GST_Percentages = new ArrayList <String>();
        GST_Percentages.add("");
        GST_Percentages.add("5%");
        GST_Percentages.add("12%");
        GST_Percentages.add("18%");
        GST_Percentages.add("28%");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter <String>(mActivity, android.R.layout.simple_spinner_item, GST_Percentages);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        sp_percentage.setAdapter(dataAdapter);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        btn_gst_calculator.setOnClickListener(this);
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

    public void SetValues(String value)
    {

        int Amount, GSTPerc, GSTPrice, NetPrice, ExcludeGST;

        Amount = Integer.parseInt(value);
        GSTPerc = Integer.parseInt(Selected_GST_Percentage.split("%")[0]);

        tv_original_cost.setText(value);

        tv_gst_perc.setText(Selected_GST_Percentage);

        GSTPrice = (Amount*GSTPerc/100);

        tv_gst_price.setText(String.valueOf(GSTPrice));

        NetPrice = Amount + GSTPrice;

        tv_net_price.setText(String.valueOf(NetPrice));

        ExcludeGST = (Amount*(100+GSTPerc)/100);

        Methods.syso("ExcludeGST == "+ExcludeGST);
    }
}