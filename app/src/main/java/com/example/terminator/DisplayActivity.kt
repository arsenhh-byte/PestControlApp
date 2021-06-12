package com.example.terminator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_display.*

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        val bundle: Bundle? = intent.extras
        val phone: Int = bundle!!.getInt("phone")



        val nameshared: String? = intent.getStringExtra("Name")
        val gendershared: String? = intent.getStringExtra("Gender")
        val houseshared: String? = intent.getStringExtra("House NO")
        val phoneshared: Int? = intent.getIntExtra("Phone No",0)
        val emailshared: String? = intent.getStringExtra("Email add")
        val pestshared: String? = intent.getStringExtra("Pest to control")
        val dateshared: String? = intent.getStringExtra("Date to visit")



        resultTV.text = "Your info:  \n\nName: " +nameshared+ "\nGender: "+gendershared+"\nHouseNumber: "+houseshared+"\nPhone Number:"+phoneshared+"\nemail address:"+emailshared+"\nPest to Control:"+pestshared+"\nDate to be visited:"+dateshared

        homebtn.setOnClickListener(View.OnClickListener {

            val intenthome = Intent(this,LandingPage::class.java)
            startActivity(intenthome)
        })


    }




}