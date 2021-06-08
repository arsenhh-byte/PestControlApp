package com.example.terminator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_form.*


class FormActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var editText1: EditText
    lateinit var editText2: EditText

    lateinit var editText3: EditText

    lateinit var editText4: EditText

    lateinit var editText5: EditText

    lateinit var editText6: EditText
    lateinit var editText7: EditText


    lateinit var buttonClick: Button

    var names: String = " "
    var genders: String = " "
    var house_numbers: String = " "
    var phone_numbers: Int = 0
    var email_adds: String = " "
    var pest_to_controls: String = " "
    var date_for_visits: String = " "



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)



        textView = findViewById(R.id.textsample)
        editText1 = findViewById(R.id.NameET)
        editText2 = findViewById(R.id.GenderET)
        editText3 = findViewById(R.id.HouseET)
        editText4 = findViewById(R.id.PhoneET)
        editText5 = findViewById(R.id.EmailEt)
        editText6 = findViewById(R.id.PestET)
        editText7 = findViewById(R.id.DateET)
        buttonClick = findViewById(R.id.btnsave)
        buttonClick = findViewById(R.id.btnview)
        buttonClick = findViewById(R.id.btndelete)
        buttonClick = findViewById(R.id.btnupdate)



        names = textView.text as String
        genders = textView.text as String
        house_numbers = textView.text as String
        phone_numbers = textView.text as Int
        email_adds = textView.text as String
        pest_to_controls = textView.text as String
        date_for_visits = textView.text as String



    }

    fun onSaveButtonClick(view: View) {

        //collect data from edit text
        val name = NameET.text.toString()
        val gender = GenderET.text.toString()
        val house_number = HouseET.text.toString()
        val phone_no = PhoneET.text.toString().toInt()
        val email_add = EmailEt.text.toString()
        val pest_to_control = PestET.text.toString()
        val date_for_visit = DateET.text.toString()


        //fetch text from names
        names = editText1.text.toString()
        Log.d("ShareData","text from Edit text1" + editText1 + "text from Edit text" + names)



        genders = editText2.text.toString()
        Log.d("ShareData","text from Edit text2" + editText2 + "text from Edit text" + genders)


        house_numbers = editText3.text.toString()
        Log.d("ShareData","text from Edit text1" + editText3 + "text from Edit text" + house_numbers)

        phone_numbers = editText4.text.toString().toInt()
        Log.d("ShareData","text from Edit text1" + editText4 + "text from Edit text" + phone_numbers)

        email_adds = editText5.text.toString()
        Log.d("ShareData","text from Edit text1" + editText5 + "text from Edit text" + email_adds)

        pest_to_controls = editText6.text.toString()
        Log.d("ShareData","text from Edit text1" + editText6 + "text from Edit text" + pest_to_controls)

        date_for_visits = editText7.text.toString()
        Log.d("ShareData","text from Edit text1" + editText7 + "text from Edit text" + date_for_visits)


        val intentformsharing = Intent(this@FormActivity,DisplayActivity::class.java)

        //intent to sharing text
        intentformsharing.putExtra("Name", names)
        intentformsharing.putExtra("Gender",genders)
        intentformsharing.putExtra("House NO", house_numbers)
        intentformsharing.putExtra("Phone No", phone_numbers)
        intentformsharing.putExtra("Email add",email_adds)
        intentformsharing.putExtra("Pest to control",pest_to_controls)
        intentformsharing.putExtra("Date to visit",date_for_visits)
        startActivity(intentformsharing)


        //Logining info





//start intent and pass data




    }
}