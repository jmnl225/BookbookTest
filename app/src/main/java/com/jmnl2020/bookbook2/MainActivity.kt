package com.jmnl2020.bookbook2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(HomeFragment())

        bottom_navigation_view.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.btnav_home -> {
                    loadFragment(HomeFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.btnav_history -> {
                    loadFragment(HistoryFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.btnav_calendar -> {
                    loadFragment(CalendarFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.btnav_setting -> {
                    loadFragment(SettingFragment())
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }





    }//onCreate

    private fun loadFragment(fragment: Fragment){
        //load Fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }



}//MainActivity


