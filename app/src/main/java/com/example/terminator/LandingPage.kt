package com.example.terminator

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.homepage2.*
import kotlinx.android.synthetic.main.landing_page.*

class LandingPage : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawer: DrawerLayout
    private lateinit var toolbar: Toolbar
    private lateinit var navView: NavigationView
    lateinit var btnCall: Button
    lateinit var btnEmail: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.landing_page)
        btnCall = findViewById(R.id.call)
        btnEmail = findViewById(R.id.email)
        drawer = findViewById(R.id.drawer_layout)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        navView = findViewById(R.id.nav_drawer)
        navView.setNavigationItemSelectedListener(this)
        //hamburger icon
        val toggle: ActionBarDrawerToggle = ActionBarDrawerToggle(this,
            drawer,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        //attach a drawer listener for the toogle
        drawer.addDrawerListener(toggle)
        //sync state
        toggle.syncState()



        image1.setOnClickListener {
            val intent = Intent(Intent(this, NavigationDrawerActivity::class.java))
            startActivity(intent)
        }


        btnCall.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:" + "0785691980")
            startActivity(dialIntent)

        }

        btnEmail.setOnClickListener(View.OnClickListener {
            val addresses = "arsenhenry2@gmail.com"
            val subject = "works"
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.setData(Uri.parse("mailto:")) // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, addresses)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent)
            }
        })


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                val intent1 = Intent(this@LandingPage, LandingPage::class.java)
                startActivity(intent1)
            }
            R.id.nav_commercial -> {
                val intent1 = Intent(this@LandingPage, CommercialActivity::class.java)
                startActivity(intent1)
            }
            R.id.nav_fumigation -> {
                val intent1 = Intent(this@LandingPage, FumigationActivity::class.java)
                startActivity(intent1)
            }
            R.id.nav_outdoor -> {
                val intent1 = Intent(this@LandingPage, OutdoorActivity::class.java)
                startActivity(intent1)
            }
            R.id.nav_prevention -> {
                val intent1 = Intent(this@LandingPage, PestPreventionActivity::class.java)
                startActivity(intent1)
            }
            R.id.nav_recycler -> {
                val intent1 = Intent(this@LandingPage, RecyclerView::class.java)
                startActivity(intent1)
            }
            R.id.nav_form -> {
                val intent1 = Intent(this@LandingPage, FormActivity::class.java)
                startActivity(intent1)
            }
        }
return true
    }

    override fun onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }
}
