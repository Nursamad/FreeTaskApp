package com.geektech.freetaskapp.models;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {

    private SharedPreferences preferences;

    public Prefs(Context context) {
        preferences = context.getSharedPreferences("setting", Context.MODE_PRIVATE);
    }

    public void saveBoardShow() {
        preferences.edit().putBoolean("isShown", true).apply();
    }

    public boolean isBoardShow() {
        return preferences.getBoolean("isShowm", false);
    }
}
