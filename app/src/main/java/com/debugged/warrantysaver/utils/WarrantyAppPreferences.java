package com.debugged.warrantysaver.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class WarrantyAppPreferences {
    public static final String KEY_METER_VALUE = "WarrantyAppPreferences";
    private static final String USER_INFO = "USER_INFO";
    private static final String KEY_IS_COACH_MARKS_SHOWN_APP_STORE = "isCoachMarkShownAppStore";
    private static WarrantyAppPreferences instance;
    private static final String KEY_PREF_LOGGEDIN = "login";
    private static final String KEY_PREF_MOBILE_NUMBER = "mobilenum";
    private static final String KEY_FIREBASE_TOKEN = "KEY_FIREBASE_TOKEN";

    public static synchronized WarrantyAppPreferences getInstance() {
        if (instance == null) {
            instance = new WarrantyAppPreferences();
        }
        return instance;
    }

    private static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences("parental", Context.MODE_PRIVATE);
    }

    public static void putLong(Context context, String key, long value) {
        getPreferences(context).edit().putLong(key, value).commit();
    }

    public static long getLong(Context context, String key) {
        return getPreferences(context).getLong(key, 0);
    }

    private static void putString(Context context, String key, String value) {
        getPreferences(context).edit().putString(key, value).commit();
    }

    private static SharedPreferences getLoginPreferences(Context context) {
        return context.getSharedPreferences("LoginParentalPref", Context.MODE_PRIVATE);
    }


    private static String getString(Context context, String key, String defValue) {
        return getPreferences(context).getString(key, defValue);
    }

    public static boolean getBoolean(Context context, String key, boolean def) {
        return getPreferences(context).getBoolean(KEY_METER_VALUE + key, def);
    }

    public static void putBoolean(Context context, String key, boolean value) {
        getPreferences(context).edit().putBoolean(KEY_METER_VALUE + key, value).commit();
    }

    public static void setStringPrefrence(Context context, String type, String value) {
        putString(context, KEY_METER_VALUE + type, value);
    }

    public static String getStringPrefrence(Context context, String type) {
        return getString(context, KEY_METER_VALUE + type, "");
    }


    public static void clear(Context context) {
        getPreferences(context).edit().clear().commit();
    }
    public static void setLoginPref(Context context, boolean isLogin) {
        putBoolean(context, KEY_PREF_LOGGEDIN, isLogin);
    }

    /**
     * @param context the context
     * @return the sync count
     */
    public static boolean isLoggedIn(Context context) {
        return getBoolean(context, KEY_PREF_LOGGEDIN, false);
    }

    public static void setMobileNumber(Context context, String color) {
        setStringPrefrence(context, KEY_PREF_MOBILE_NUMBER, color);
    }

    public static String getMobileNumber(Context context) {
        String mobilenumber = getStringPrefrence(context, KEY_PREF_MOBILE_NUMBER);
        return mobilenumber;
    }
    public static void setKeyFirebaseToken(Context context, String color) {
        setStringPrefrence(context, KEY_FIREBASE_TOKEN, color);
    }

    public static String getKeyFirebaseToken(Context context) {
        String firebaseToken = getStringPrefrence(context, KEY_FIREBASE_TOKEN);
        return firebaseToken;
    }
}
