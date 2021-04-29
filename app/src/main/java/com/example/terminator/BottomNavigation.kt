package com.example.terminator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigation : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    //initialize variable to tag bottom nav
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        //view identification
        bottomNav= findViewById(R.id.bottomview)
        //set a listener to it
        bottomNav.setOnNavigationItemSelectedListener(this)


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_fumigation->{
                val intentFumigation= Intent(this@BottomNavigation,FumigationActivity::class.java)
                startActivity(intentFumigation)
            }
            R.id.nav_outdoor->{
                val intentOutdoor= Intent(this@BottomNavigation,OutdoorActivity::class.java)
                startActivity(intentOutdoor)
            }
            R.id.nav_prevention->{
                val intentPrevention= Intent(this@BottomNavigation,PestPreventionActivity::class.java)
                startActivity(intentPrevention)
            }
        }
        return true

    }
}