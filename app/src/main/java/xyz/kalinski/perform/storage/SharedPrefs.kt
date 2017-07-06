package xyz.kalinski.perform.storage

import android.content.Context
import android.content.SharedPreferences
import xyz.kalinski.perform.di.scope.ApplicationScope
import javax.inject.Inject

@ApplicationScope
class SharedPrefs @Inject constructor(context: Context, private var sharedPreferences: SharedPreferences = context.getSharedPreferences("perform.storage", Context.MODE_PRIVATE)) {

    object Strings {}

    object Longs {}

    object Booleans {}

    object Ints {}


    fun storeString(key: String, value: String) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.commit()
    }

    fun storeInt(key: String, value: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(key, value)
        editor.commit()
    }

    fun storeBoolean(key: String, value: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(key, value)
        editor.commit()
    }

    fun storeLong(key: String, value: Long) {
        val editor = sharedPreferences.edit()
        editor.putLong(key, value)
        editor.commit()
    }

    fun getStringValue(key: String, defValue: String): String {
        return sharedPreferences.getString(key, defValue)
    }

    fun getIntValue(key: String): Int {
        return getIntValue(key, 0)
    }

    fun getIntValue(key: String, defValue: Int): Int {
        return sharedPreferences.getInt(key, defValue)
    }

    fun getLongValue(key: String): Long {
        return getLongValue(key, 0)
    }

    fun getLongValue(key: String, defValue: Long): Long {
        return sharedPreferences.getLong(key, defValue)
    }

    fun getBooleanValue(key: String, defValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defValue)
    }

    fun getBooleanValue(key: String): Boolean {
        return getBooleanValue(key, false)
    }

}
