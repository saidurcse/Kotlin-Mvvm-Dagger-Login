package saidur.demo.kotlin.util

import android.content.Context
import android.content.SharedPreferences
import saidur.demo.kotlin.util.PrefKey.FIRST_STATUS

class SharedPrefsHelper(context: Context) {

    val mSharedPreferences: SharedPreferences
    val DemoPref = "demo-prefs"

    init {
        this.mSharedPreferences = context.getSharedPreferences(DemoPref, Context.MODE_PRIVATE)
    }

    fun put(key: String, value: String) {
        mSharedPreferences.edit().putString(key, value).apply()
    }

    fun put(key: String, value: Int) {
        mSharedPreferences.edit().putInt(key, value).apply()
    }

    fun put(key: String, value: Float) {
        mSharedPreferences.edit().putFloat(key, value).apply()
    }

    fun put(key: String, value: Boolean) {
        mSharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun setFirstTimeUser(status: Boolean) {
        mSharedPreferences.edit().putBoolean(FIRST_STATUS, status).apply()
    }

    fun getFirstTimeUser(): Boolean {
        return mSharedPreferences.getBoolean(FIRST_STATUS, false)
    }

    operator fun get(key: String, defaultValue: String): String? {
        return mSharedPreferences.getString(key, defaultValue)
    }

    operator fun get(key: String, defaultValue: Int): Int? {
        return mSharedPreferences.getInt(key, defaultValue)
    }

    operator fun get(key: String, defaultValue: Float): Float? {
        return mSharedPreferences.getFloat(key, defaultValue)
    }

    operator fun get(key: String, defaultValue: Boolean): Boolean? {
        return mSharedPreferences.getBoolean(key, defaultValue)
    }

    fun deleteSavedData(key: String) {
        mSharedPreferences.edit().remove(key).apply()
    }
}
