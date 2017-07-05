package com.gst.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String expiryDate = "3017-05-20";

        long exDate  = getMillFromDate(expiryDate, "yyyy-MM-dd");

        if (System.currentTimeMillis() >= exDate)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);

            builder.setMessage("Your app is expired. Please contact admin for more details.");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    finish();
                }
            });
            builder.setCancelable(false);
            builder.show();

            return;
        }


        CountDownTimer countDownTimer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {

                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();
    }


    public static long getMillFromDate(final String str_date, final String dateFormate) {
        try {
            DateFormat formatter = new SimpleDateFormat(dateFormate);
            Date date = formatter.parse(str_date);
            return (date.getTime());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
