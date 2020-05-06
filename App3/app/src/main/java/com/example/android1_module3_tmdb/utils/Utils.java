package com.example.android1_module3_tmdb.utils;

import android.content.Context;
import android.preference.PreferenceManager;

public class Utils {
    private  static final String SESSION_ID_KEY="session_id_key";

    public static void saveSessionId(String sessionId, Context context){
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putString(SESSION_ID_KEY,sessionId)
                .apply();
    }
    public static String getSessionId(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(SESSION_ID_KEY,null);
    }
}
