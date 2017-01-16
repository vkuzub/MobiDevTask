package com.mobidevtask.utils;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.mobidevtask.App;
import com.mobidevtask.R;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Locale;


public class CommonDataExtractUtils {

    //                                                  2016-12-29T13:50:38+02:00
//    public static final String TIME_INPUT_FORMAT = "yyyy-MM-dd'T'HH:mm:ss+SS:SS";
//                                                    2017-01-11 16:11:26
    public static final String TIME_INPUT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_OUTPUT_DATE = "dd.MM.yyyy";
    public static final String TIME_OUTPUT_FORMAT_BIRTHDAY = "yyyy-MM-dd'T'HH:mm:ss+SS:SS";
    public static final String TIME_OUTPUT_TIME = "HH:mm";


    public static String getStringValue(@Nullable String... strings) {
        if (!CollectionUtils.isNullOrEmpty(strings)) {
            StringBuilder sb = new StringBuilder();
            for (String string : strings) {
                if (!TextUtils.isEmpty(string)) {
                    sb.append(string).append(" ");
                }
            }
            String res = sb.toString().trim();
            if (TextUtils.isEmpty(res)) {
                return App.getContext().getString(R.string.undefined);
            }
            return res;
        }
        return App.getContext().getString(R.string.undefined);
    }

    public static String getDateTime(String time, String outputFormat) {
        try {
            if (!TextUtils.isEmpty(time)) {
                DateTimeFormatter formatter = DateTimeFormat.forPattern(TIME_INPUT_FORMAT);
                formatter.withLocale(Locale.getDefault());
                DateTime dt = formatter.parseDateTime(time);
                return dt.toString(outputFormat);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return App.getContext().getString(R.string.undefined);
    }

    public static String getDateTime(long time, String outputFormat) {
        try {
            DateTime dt = new DateTime(time, DateTimeZone.getDefault());
            return dt.toString(outputFormat);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return App.getContext().getString(R.string.undefined);
    }


//    public static String getImageUrl(@Nullable Image cover) {
//        if (cover != null) {
//            return com.k_3soft.global2.network.ServiceGenerator.DEBUG_API_BASE_URL_FOR_IMAGES + cover.getIdImage() + "-medium_default/img.jpg";
//        }
//        return "";
//    }
}
