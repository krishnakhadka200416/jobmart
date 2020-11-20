package com.example.jobmart

import android.os.Bundle
import android.os.Message
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.jobmart.fragments.HomeFragment
import com.example.jobmart.fragments.NotificationsFragment
import com.example.jobmart.fragments.ProfileFragment
import com.example.jobmart.fragments.SearchFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)


    }
}