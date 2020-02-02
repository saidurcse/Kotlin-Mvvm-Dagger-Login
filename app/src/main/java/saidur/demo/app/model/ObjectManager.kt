package saidur.demo.app.model

import android.content.SharedPreferences

import com.google.gson.Gson


class ObjectManager(val sharedPreferences: SharedPreferences, val gson: Gson) {

    fun save(key: String, o: Any) {
        sharedPreferences.edit()
            .putString(key, gson.toJson(o))
            .apply()
    }

    operator fun <T> get(key: String, type: Class<T>): T? {
        val json = sharedPreferences.getString(key, null) ?: return null

        return gson.fromJson(json, type)
    }
}
