package com.gst.utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.gst.BuildConfig;
import com.gst.R;
import com.gst.activities.MainActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Random;
import java.util.TimeZone;
import java.util.TreeMap;

/**
 * Created by mind on 22/2/17.
 */

public class Methods {

    static MainActivity mActivity;

    public Methods(MainActivity mActivity) {
        Methods.mActivity = mActivity;
    }

    public static void syso(String s)
    {
        if (BuildConfig.DEBUG)
        {
            System.out.println("SYSO= "+s);
        }
    }

    /**
     * Hidekeyboard.
     *
     * @param mActivity: Main activity object.
     */
    public static void hideKeyboard(Activity mActivity) {
        if (mActivity != null) {
            mActivity.getWindow().setSoftInputMode(
                    WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
            );
            View view = mActivity.getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager) mActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    /**
     * Check currently any audio is playing or not in other app.
     *
     * @return: true if none.
     */
    public static boolean validateMicAvailability() {
        Boolean available = true;
        AudioRecord recorder =
                new AudioRecord(MediaRecorder.AudioSource.MIC, 44100,
                        AudioFormat.CHANNEL_IN_MONO,
                        AudioFormat.ENCODING_DEFAULT, 44100);

        if (recorder == null)
        {
            return true;
        }

        try {
            if (recorder.getRecordingState() != AudioRecord.RECORDSTATE_STOPPED) {
                available = false;

            }

            recorder.startRecording();
            if (recorder.getRecordingState() != AudioRecord.RECORDSTATE_RECORDING) {
                recorder.stop();
                available = false;

            }
           /* recorder.stop();

            recorder.release();
            recorder = null;*/

        } finally {

            if (recorder != null) {
                recorder.release();
                recorder = null;
            }
        }

        return available;
    }

    /***
     * To prevent from double clicking the row item and so prevents overlapping fragment.
     * **/
    public static void avoidDoubleClicks(final View view) {
        final long DELAY_IN_MS = 500;
        if (!view.isClickable()) {
            return;
        }
        view.setClickable(false);
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                view.setClickable(true);
            }
        }, DELAY_IN_MS);
    }

    static Random random = new Random();

    public static int getRandomColor(Context mContext)
    {

//        random.setSeed(5);

        int rnd = random.nextInt(8);

        int rndColor = 0;

        if (rnd==1) rndColor = mContext.getResources().getColor(R.color.rnd1);
        else if (rnd==2) rndColor = mContext.getResources().getColor(R.color.rnd2);
        else if (rnd==3) rndColor = mContext.getResources().getColor(R.color.rnd3);
        else if (rnd==4) rndColor = mContext.getResources().getColor(R.color.rnd4);
        else if (rnd==5) rndColor = mContext.getResources().getColor(R.color.rnd5);
        else if (rnd==6) rndColor = mContext.getResources().getColor(R.color.rnd6);
        else if (rnd==7) rndColor = mContext.getResources().getColor(R.color.rnd7);
        else  rndColor = mContext.getResources().getColor(R.color.rnd8);

        return rndColor;
    }

    public static String getDir()
    {

        String mFilePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        mFilePath += "/Yuud/";

        return mFilePath;
    }

    /**
     * @param mainActivity use for get applicationContext
     * @param dp value to convert into px
     * @return converted px from dp value
     */
    public static int dpToPx(MainActivity mainActivity , int dp) {
        DisplayMetrics displayMetrics = mainActivity.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    /**
     * @param mainActivity use for get applicationContext
     * @param px value to convert into dp
     * @return converted dp from px value
     */
    public static int pxToDp(MainActivity mainActivity, int px) {
        DisplayMetrics displayMetrics = mainActivity.getResources().getDisplayMetrics();
        return Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    /**
     * Get height of the device.
     * @param mainActivity: mainactivity reference
     * @return: height of device.
     */
    public static int getHeight(MainActivity mainActivity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        mainActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        return height;
//        int width = displayMetrics.widthPixels;
    }

//    /**
//     * this method will handle the exception we will get for the API request
//     *
//     * @param t Throwable
//     */
//    public static void setExceptionMessage(Throwable t) {
//        if (t instanceof TimeoutException) {
//            mActivity.showSnackBar(mActivity.getResources().getString(R.string.comments));
//        } else if (t instanceof UnknownHostException) {
//            mActivity.showSnackBar(mActivity.getResources().getString(R.string.no_internet_connection));
//        } else if (t instanceof NetworkErrorException || t instanceof NetworkOnMainThreadException) {
//            mActivity.showSnackBar(mActivity.getResources().getString(R.string.network_error));
//        } else {
//            mActivity.showSnackBar(mActivity.getResources().getString(R.string.something_went_wrong));
//        }
//    }


    /**
     * Get token for passing in API.
     * @return: token
     */
    public static String getToken() {
        String token = MyPreferences.getPref(mActivity, KeyUtil.PREF_TOKEN_KEY);
        if (Validation.isRequiredField(token)) {
            return token;
        } else {
            return "";
        }
    }





    public static List<Float> stringToList(String s)
    {
        List<Float> floatList = new ArrayList<>();

        try {

            if (s!=null) {
                s = s.replace(" ", "");
                s = s.replace("[", "");
                s = s.replace("]", "");

                String[] strings = s.split(",");

                for (String string : strings) {
//                    String f = String.format("%.10f", Validation.getFloatFromString(string));
//                    floatList.add(Validation.getFloatFromString(f));
                    floatList.add(Validation.getFloatFromString(string));
                }

            }


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return floatList;
    }

    private static final NavigableMap<Long, String> suffixes = new TreeMap<>();
    static {
        suffixes.put(1_000L, "k");
        suffixes.put(1_000_000L, "M");
        suffixes.put(1_000_000_000L, "G");
        suffixes.put(1_000_000_000_000L, "T");
        suffixes.put(1_000_000_000_000_000L, "P");
        suffixes.put(1_000_000_000_000_000_000L, "E");
    }

    /**
     * Metho to set count more than 1000.
     * @param value: count
     * @return: count with format
     */
    public static String numberFormat(long value) {

        //Long.MIN_VALUE == -Long.MIN_VALUE so we need an adjustment here
        if (value == Long.MIN_VALUE) return numberFormat(Long.MIN_VALUE + 1);
        if (value < 0) return "-" + numberFormat(-value);
        if (value < 1000) return Long.toString(value); //deal with easy case

        Map.Entry<Long, String> e = suffixes.floorEntry(value);
        Long divideBy = e.getKey();
        String suffix = e.getValue();

        long truncated = value / (divideBy / 10); //the number part of the output times 10
        boolean hasDecimal = truncated < 100 && (truncated / 10d) != (truncated / 10);
        return hasDecimal ? (truncated / 10d) + suffix : (truncated / 10) + suffix;
    }

    /**
     * Get time from gmt.
     *
     * @param inputDate:    input date
     * @param outputFormat: output format
     * @return: time
     */
    public static String getTimeDateFromGMT(String inputDate, String outputFormat) {
        return getChangedDateFormateGMTToLocal(inputDate, "yyyy-MM-dd HH:mm:ss", outputFormat);
    }

    public static String getChangedDateFormateGMTToLocal(final String mDate, final String mOldDateFormat, final String newDateFormate) {
        SimpleDateFormat inputFormat = new SimpleDateFormat(mOldDateFormat);
        SimpleDateFormat outputFormat = new SimpleDateFormat(newDateFormate);

        Date date;
        String str;

        try {
            inputFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            date = inputFormat.parse(mDate);
            outputFormat.setTimeZone(TimeZone.getDefault());
            str = outputFormat.format(date);
            return str;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }


    private static float maxWidth = 0;
    public static float getMaxWidth(Context context) {
        if (maxWidth != 0) {
//            Methods.syso("MAXWIDTH===="+maxWidth);//1080
            return maxWidth;
        }

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        float width = metrics.widthPixels;
        maxWidth = width;
        return maxWidth;
    }

    public static void setGraphPressAnim(View view)
    {
        AnimatorSet set = new AnimatorSet();
        set.playTogether(
//                ObjectAnimator.ofFloat(view, "scaleX", 1.5f, 1.0f),
//                ObjectAnimator.ofFloat(view, "scaleY", 1.5f, 1.0f),
                ObjectAnimator.ofFloat(view, "alpha",  0.2f, 1.0f)
        );
        set.setDuration(200).start();
    }

    public static void loadListItemAnim(View view)
    {
        AnimatorSet set = new AnimatorSet();
        set.playTogether(

                ObjectAnimator.ofFloat(view, "scaleX", 0.7f, 1.0f),
                ObjectAnimator.ofFloat(view, "scaleY", 0.7f, 1.0f),
                ObjectAnimator.ofFloat(view, "alpha",  0.5f, 1.0f)
        );
        set.setDuration(200).start();
    }






}
