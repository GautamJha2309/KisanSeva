package com.example.sih_v2.News.util;

import android.content.Context;
import android.net.ConnectivityManager;

import androidx.annotation.NonNull;

public class Internet {

    public static boolean checkConnection(@NonNull Context context) {
        return ((ConnectivityManager) context.getSystemService
                (Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
    }
}
