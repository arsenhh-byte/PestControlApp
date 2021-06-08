package com.example.terminator
interface IPreferenceHelper {
    fun getUserName()
    fun getUserGender()
    fun getUserHouse()
    fun getUserPhone()
    fun getUserEmail()
    fun getUserPest()
    fun getUserDate()
    fun setUserName(username: String)
    fun setUserGender(usergender: String)
    fun setUserHouse(userhouse: String)
    fun setUserPhone(userphone: String)
    fun setUserEmail(useremail: String)
    fun setUserPest(userpest: String)
    fun setUserDate(userdate: String)
    fun clearPrefs()
}