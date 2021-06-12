package com.example.terminator

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_form.*
import kotlinx.android.synthetic.main.delete_dialog.*

class SQLformactivity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)


        btnDelete.setOnClickListener {

            deleteData()
        }

        btnUpdate.setOnClickListener {

            updateData()
        }

    }

    //saving data
    fun saveData(view: View){

        val name = NameET.text.toString()
        val gender = GenderET.text.toString()
        val house_number = HouseET.text.toString()
        val phone_number = PhoneET.text.toString()
        val email = EmailEt.text.toString()
        val pest_control = PestET.text.toString()
        val date = DateET.text.toString()


        val databaseHandler: DatabaseHandler = DatabaseHandler(this)

        if (name.trim() != "" && gender.trim() != "" && house_number.trim() != "" && phone_number.trim() != ""&& email.trim() != ""&& pest_control.trim() != ""&& date.trim() != "" ) {

            val status = databaseHandler.addUsers(SqlListModel(name,gender,house_number,Integer.valueOf(phone_number),email,pest_control,date))

            if (status > -1){
                Toast.makeText(applicationContext,"Record succesfully added", Toast.LENGTH_LONG).show()


                NameET.text?.clear()
                GenderET.text?.clear()
                HouseET.text?.clear()
                PhoneET.text?.clear()
                EmailEt.text?.clear()
                PestET.text?.clear()
                DateET.text?.clear()
            }

        } else {

            Toast.makeText(applicationContext,"Please fill in the fields", Toast.LENGTH_LONG).show()
        }

    }


    fun viewData(view: View){

        val databaseHandler = DatabaseHandler(this)
        //
        val viewdata: List<SqlListModel> = databaseHandler.readData()

        val empArrayName = Array<String>(viewdata.size){"null"}
        val empArrayGender = Array<String>(viewdata.size){"null"}
        val empArrayHouse = Array<String>(viewdata.size){"null"}
        val empArrayPhone = Array<String>(viewdata.size){"0"}
        val empArrayEmail = Array<String>(viewdata.size){"null"}
        val empArrayPest = Array<String>(viewdata.size){"null"}
        val empArrayDate = Array<String>(viewdata.size){"null"}


        var index = 0
        for(e in viewdata){
            empArrayName[index] = e.userName
            empArrayGender[index] = e.userGender
            empArrayHouse[index] = e.userHouse
            empArrayPhone[index] = e.userPhone.toString()
            empArrayEmail[index] = e.userEmail
            empArrayPest[index] = e.userPest
            empArrayDate[index] = e.userDate

            index++
        }



        val myadpater = SqlListAdapter(this,empArrayName,empArrayGender,empArrayHouse,empArrayPhone,empArrayEmail,empArrayPest,empArrayDate)


        listItems.adapter = myadpater
    }

    fun deleteData(){
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = this.layoutInflater

        val dialogView = inflater.inflate(R.layout.delete_dialog,null)
        dialogBuilder.setView(dialogView)


        val delete_number  = dialogView.findViewById<EditText>(R.id.DeletePhone)
        //customize our pop up , title and a message
        dialogBuilder.setTitle("Delete Your records")
        dialogBuilder.setMessage("Enter your phone number and email to delete data")


        dialogBuilder.setPositiveButton("Delete Data",
            DialogInterface.OnClickListener { dialog, which ->



            val Inputphone = DeletePhone.text.toString()

            val databaseHandler = DatabaseHandler(this)

            if (Inputphone.trim() != ""){

                val status = databaseHandler.deleteData(SqlListModel("","","",0,"","",""))
                if (status > -1){
                    Toast.makeText(applicationContext,"Record successfully deleted", Toast.LENGTH_LONG).show()

                }
            } else {
                Toast.makeText(applicationContext," fields must not be empty", Toast.LENGTH_LONG).show()
            }





        })


        dialogBuilder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->


            Toast.makeText(applicationContext,"Process cancelled", Toast.LENGTH_LONG).show()

            dialog.dismiss()

        })

        dialogBuilder.setNeutralButton("Help", DialogInterface.OnClickListener { dialog, which ->

            Toast.makeText(applicationContext,"Simply enter phone number to delete from SQLite", Toast.LENGTH_LONG).show()
        })


        val b  = dialogBuilder.create()
        b.show()



    }

    fun updateData(){
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = this.layoutInflater

        val dialogView = inflater.inflate(R.layout.update_dialog,null)
        dialogBuilder.setView(dialogView)


        val update_name = dialogView.findViewById<EditText>(R.id.UpdateName)
        val update_gender = dialogView.findViewById<EditText>(R.id.UpdateGender)
        val update_house = dialogView.findViewById<EditText>(R.id.UpdateHouse)
        val update_phone = dialogView.findViewById<EditText>(R.id.UpdatePhone)
        val update_email = dialogView.findViewById<EditText>(R.id.UpdateEmail)
        val update_pest = dialogView.findViewById<EditText>(R.id.UpdatePest)
        val update_date = dialogView.findViewById<EditText>(R.id.UpdateDate)



        dialogBuilder.setTitle("Update Data")
        dialogBuilder.setMessage("Enter Phone Number, to update specific record")

        dialogBuilder.setPositiveButton("Update Data",
            DialogInterface.OnClickListener { dialog, which ->

            val updateName = update_name.text.toString()
            val updateGender = update_gender.text.toString()
            val updateHouse = update_house.text.toString()
                val updatePhone = update_phone.text.toString()
                val updateEmail = update_email.text.toString()
                val updatePest = update_pest.text.toString()
                val updateDate = update_date.text.toString()



            if (updateName.trim() != "" && updateGender.trim() != "" && updateHouse.trim() != "" && updatePhone.trim() != "" && updateEmail.trim() != "" && updatePest.trim() != "" &&  updateDate.trim() != ""  )
                {


                val databaseHandler  = DatabaseHandler(this)
                val status = databaseHandler.updateData(SqlListModel(updateName,updateGender,updateHouse,Integer.valueOf(updatePhone),updateEmail,updatePest,updateDate))

                if(status > -1){
                    Toast.makeText(applicationContext,"Update successful", Toast.LENGTH_LONG).show()

                } else {
                    Toast.makeText(applicationContext,"Update failed", Toast.LENGTH_LONG).show()

                }
            } else {
                Toast.makeText(applicationContext,"Update fields cannot be empty", Toast.LENGTH_LONG).show()
            }

        })

        dialogBuilder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->


            Toast.makeText(applicationContext,"Process cancelled", Toast.LENGTH_LONG).show()

            dialog.dismiss()

        })

        dialogBuilder.setNeutralButton("Help", DialogInterface.OnClickListener { dialog, which ->

            Toast.makeText(applicationContext,"Simply enter records to update from SQLite", Toast.LENGTH_LONG).show()
        })


        val b  = dialogBuilder.create()
        b.show()

    }


}