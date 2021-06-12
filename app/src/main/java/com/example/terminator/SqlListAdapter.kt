package com.example.terminator
import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.ArrayAdapter
import android.view.ViewGroup
import android.widget.TextView

class SqlListAdapter(private val context: Activity, private val name: Array<String>, private val gender: Array<String>, private val housenumber: Array<String>, private val phonenumber: Array<String>, private val email: Array<String>, private val pest_to_control: Array<String>, private val date_to_visit: Array<String>)
    : ArrayAdapter<String>(context,R.layout.activity_form
    ,name)
{

    override fun getView(position: Int, view: View?,parent: ViewGroup):View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.activity_form,null,true)


        val Name: TextView = rowView.findViewById(R.id.NameET)
        val Gender: TextView = rowView.findViewById(R.id.GenderET)
        val HouseNumber: TextView = rowView.findViewById(R.id.HouseET)
        val PhoneNumber: TextView = rowView.findViewById(R.id.PhoneET)
        val Email: TextView = rowView.findViewById(R.id.EmailEt)
        val Pest_To_Control: TextView = rowView.findViewById(R.id.PestET)
        val Date_To_Control: TextView = rowView.findViewById(R.id.DateET)


        //view identification and also set data according to position

        Name.text = "ID: ${name[position]}"
        Gender.text = "ID: ${gender[position]}"
        HouseNumber.text = "ID: ${housenumber[position]}"
        PhoneNumber.text = "ID: ${phonenumber[position]}"
        Email.text = "ID: ${email[position]}"
        Pest_To_Control.text = "ID: ${pest_to_control[position]}"
        Date_To_Control.text = "ID: ${date_to_visit[position]}"

        return rowView


    }
}