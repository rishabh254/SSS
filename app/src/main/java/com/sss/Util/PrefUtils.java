package com.sss.Util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Khyati on 3/6/2015.
 */

/*
 Utilities and constants related to app prefrences
*/
public class PrefUtils {
    private static final String PREF_LOGIN_DONE="pref_login_done";
    private static final String PREF_WELCOME_DONE="pref_welcome_done";
    private static final String PREF_LOGIN_SKIPPED="pref_login_skipped";

    public static boolean isLoginDone(final Context context){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getBoolean(PREF_LOGIN_DONE,false);
    }

    public static void markLogInDone(final Context context){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putBoolean(PREF_LOGIN_DONE,true).commit();
    }

    public static boolean isSkiped(final Context context){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getBoolean(PREF_LOGIN_SKIPPED,false);
    }

    public static void markSkipped(final Context context){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putBoolean(PREF_LOGIN_SKIPPED,true).commit();
    }

    public static void unMarkLogInDone(final Context context){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putBoolean(PREF_LOGIN_DONE,false).commit();
    }

    public static boolean isWelcomeDone(final Context context){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getBoolean(PREF_WELCOME_DONE,false);
    }

    public static void markWelcomeDone(final Context context){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putBoolean(PREF_WELCOME_DONE,true).commit();
    }

    public static void unMarkWelcomeDone(final Context context){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putBoolean(PREF_WELCOME_DONE,false).commit();
    }

    public static void signOut(final Context context) {
        unMarkWelcomeDone(context);
        unMarkLogInDone(context);
    }

    public static void saveUsername(Context context,String username){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putString("username",username).commit();
    }

    public static String getUsername(Context context){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        String username= sp.getString("username","N.A.");
        return username;
    }
}
