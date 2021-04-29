package com.example.terminator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class NavigationDrawerActivity : AppCompatActivity(), NavigationView .OnNavigationItemSelectedListener {
    //initialize the variable to tag the DrawerLayout Class
    private lateinit var drawer: DrawerLayout
    private lateinit var toolbar: Toolbar  //toolbar
    private lateinit var navView: NavigationView





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer_activity)

        //view identification

        drawer = findViewById(R.id.nav_drawer)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        navView = findViewById(R.id.nav_drawer)
        //giving nav view a listener
        navView.setNavigationItemSelectedListener(this)


        //new instance of the ActionBarToggle class so that we can get the hamburger icon
        val toggle: ActionBarDrawerToggle = ActionBarDrawerToggle(this,drawer,toolbar,
            R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        //attach a drawer listener for the toggle effect
        drawer.addDrawerListener(toggle)
        //sync state
        toggle.syncState()






    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_home -> {
                val intentHome =
                    Intent(this@NavigationDrawerActivity, Homepage::class.java)
                startActivity(intentHome)
            }

            R.id.nav_commercial -> {

                val intentCommercial = Intent(this@NavigationDrawerActivity, CommercialActivity::class.java)
                startActivity(intentCommercial)
            }


            R.id.nav_fumigation -> {
                val intentFumigation =
                    Intent(this@NavigationDrawerActivity, FumigationActivity::class.java)
                startActivity(intentFumigation)
            }


            R.id.nav_bottom -> {
                val intentBottom =
                    Intent(this@NavigationDrawerActivity,BottomNavigation ::class.java)
                startActivity(intentBottom)
            }





            R.id.nav_outdoor ->{
                val intentOutdoor = Intent(this@NavigationDrawerActivity,OutdoorActivity ::class.java)

                startActivity(intentOutdoor)
            }

            //intent sharing
            R.id.nav_prevention -> {
                val intentPrevention = Intent(this@NavigationDrawerActivity, PestPreventionActivity::class.java)
                startActivity(intentPrevention)
            }


            R.id.nav_recycler -> {
                val intentRecycler =
                    Intent(this@NavigationDrawerActivity, RecyclerViewActivity::class.java)
                startActivity(intentRecycler)
            }


            R.id.nav_form -> {
                val intentForm = Intent(this@NavigationDrawerActivity, FormActivity::class.java)
                startActivity(intentForm)
            }
//
        }
        return true
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }


}