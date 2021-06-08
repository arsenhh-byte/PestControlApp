package com.example.terminator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_form.*
import kotlinx.android.synthetic.main.update_dialog.*

class SharedPreferenceActivity : AppCompatActivity() {
    private val preferenceHelper : IPreferenceHelper by lazy { PreferenceManager(applicationContext)}
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.update_dialog)

        textView_Shared.text = "Your user name is: ${preferenceHelper.getUserName()} Your gender is : ${preferenceHelper.getUserGender()} Your House Number is :${preferenceHelper.getUserHouse()} Your Phone Number is :${preferenceHelper.getUserPhone()} Your Email Address is  :${preferenceHelper.getUserEmail()} Pest to be controlled is/are :${preferenceHelper.getUserPest()} Date for visit is :${preferenceHelper.getUserDate()} "


        btnUpdateShared.setOnClickListener{
            preferenceHelper.setUserName(UpdateName.text.toString())
            preferenceHelper.setUserGender(UpdateGender.text.toString())
            preferenceHelper.setUserHouse(UpdateHouse.text.toString())
            preferenceHelper.setUserPhone(UpdatePhone.text.toString())
            preferenceHelper.setUserEmail(UpdateEmail.text.toString())
            preferenceHelper.setUserPest(UpdatePest.text.toString())
            preferenceHelper.setUserDate(UpdateDate.text.toString())

            textView_Shared.text = "Set Your user name: ${preferenceHelper.getUserName()} Select Your Gender : ${preferenceHelper.getUserGender()} Your House Number:${preferenceHelper.getUserHouse()} Your Phone Number is :${preferenceHelper.getUserPhone()} Your Email Address is  :${preferenceHelper.getUserEmail()} Pest to be controlled is/are :${preferenceHelper.getUserPest()} Date for visit is :${preferenceHelper.getUserDate()} "


        }
    }

}
