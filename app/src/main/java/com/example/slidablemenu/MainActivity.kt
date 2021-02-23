package com.example.slidablemenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // we need open and close to be read out by the system for accessibility
        toggle = ActionBarDrawerToggle(this, drawer_layout, R.string.open, R.string.close)
        //connecting the drawer with the toggle
        drawer_layout.addDrawerListener(toggle)
        //tell the toggle that is ready to be used
        toggle.syncState()

        //set up the back navigation arrow
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        // setting up the actions when items are clicked.
        navView.setNavigationItemSelectedListener {
            when (it.itemId) {

                R.id.item1 -> Toast.makeText(this, "Item 1 has been clicked", Toast.LENGTH_SHORT)
                    .show()
                R.id.item2 -> Toast.makeText(this, "Item 2 has been clicked", Toast.LENGTH_SHORT)
                    .show()
                R.id.item3 -> Toast.makeText(this, "Item 3 has been clicked", Toast.LENGTH_SHORT)
                    .show()
            }
            true
        }
    }

    // to open the drawer by pressing on the toggle we need to implement the code below, otherwise you can only open the drawer but swiping from left.
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

}