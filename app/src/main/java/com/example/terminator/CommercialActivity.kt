package com.example.terminator

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class CommercialActivity : AppCompatActivity() {



    lateinit var btnCall: Button
    lateinit var btnEmail: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCall = findViewById(R.id.call)
        btnEmail = findViewById(R.id.email)

        btnCall.setOnClickListener(View.OnClickListener {    val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel" + "0785691980")
            startActivity(dialIntent)
        })

        btnEmail.setOnClickListener(View.OnClickListener {   val addresses = "arsenhenry2@gmail.com"
            val subject = "works"
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.setData(Uri.parse("mailto:")) // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, addresses)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            if (intent.resolveActivity(getPackageManager()) != null)
            {
                startActivity(intent)
            }
        })



    }
}