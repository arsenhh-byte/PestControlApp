package com.example.terminator

import android.content.Context
import android.content.SharedPreferences

open class PreferenceManager constructor(context: Context) : IPreferenceHelper {
    //private constant variable that can access the shared preferences file
    private val PREFS_NAME = "SharedPreferencesDemo"
    private var preferences: SharedPreferences

    //declaring an init block where i will create an instance of the shared pref

    init {
        preferences = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE)
    }

    override fun getUserName() {
        preferences[USER_NAME]?: " "
    }

    override fun getUserGender() {
        preferences[USER_GENDER]?: " "
    }

    override fun getUserHouse() {
        preferences[USER_HOUSE]?: " "
    }

    override fun getUserPhone() {
        preferences[USER_PHONE]?: " "
    }

    override fun getUserEmail() {
        preferences[USER_EMAIL]?: " "
    }

    override fun getUserPest() {
        preferences[USER_PEST]?: " "
    }

    override fun getUserDate() {
        preferences[USER_DATE]?: " "
    }

    override fun setUserName(username: String) {
        preferences[USER_NAME] = username
    }

    override fun setUserGender(usergender: String) {
        preferences[USER_GENDER] = usergender
    }

    override fun setUserHouse(userhouse: String) {
        preferences[USER_HOUSE] = userhouse
    }

    override fun setUserPhone(userphone: String) {
        preferences[USER_PHONE] = userphone
    }

    override fun setUserEmail(useremail: String) {
        preferences[USER_EMAIL] = useremail
    }

    override fun setUserPest(userpest: String) {
        preferences[USER_PEST] = userpest
    }

    override fun setUserDate(userdate: String) {
        preferences[USER_DATE] = userdate
    }


    //method for clearing our data set to the preferences
    override fun clearPrefs(){
        preferences.edit().clear().apply()
    }

    //create a companion object
    companion object {
        //define variables to represent the valus to be stored in the shared prefs
        const val USER_NAME = "Arsen"
        const val USER_GENDER = "Male"
        const val USER_HOUSE = "206"
        const val USER_PHONE = "0785691980"
        const val USER_EMAIL = "arsenheny2@gmail.com"
        const val USER_PEST = "Roaches,Lice and Rats"
        const val USER_DATE= "23rd October 2021"


    }





    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor)-> Unit){
        val editor = this.edit()
        operation(editor)
        editor.apply()
    }

    private operator fun SharedPreferences.set(key: String, value: Any?) {
        when (value) {
            is String? -> edit { it.putString(key, value) }
            is Int -> edit { it.putInt(key, value) }
            is Boolean -> edit { it.putBoolean(key, value) }
            is Float -> edit { it.putFloat(key, value) }
            is Long -> edit { it.putLong(key, value) }
            else -> throw UnsupportedOperationException("Not yet implemented")
        }
    }

    //the reading process

    private inline operator fun <reified T : Any> SharedPreferences.get(
        key: String,
        defaultValue: T? = null
    ): T? {
        return when (T::class) {
            String::class -> getString(key, defaultValue as? String) as T?
            Int::class -> getInt(key, defaultValue as? Int ?: -1) as T?
            Boolean::class -> getBoolean(key, defaultValue as? Boolean ?: false) as T?
            Float::class -> getFloat(key, defaultValue as? Float ?: -1f) as T?
            Long::class -> getLong(key, defaultValue as? Long ?: -1) as T?
            else -> throw UnsupportedOperationException("Not yet implemented")
        }
    }



}