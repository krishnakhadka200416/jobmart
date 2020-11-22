package com.example.jobmart

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*


class SignIn : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        auth = FirebaseAuth.getInstance()

       signup.setOnClickListener{
           startActivity(Intent(this,SignUp::class.java))
           finish()
       }

    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser: FirebaseUser? = auth.currentUser
        UpdateUI(currentUser)
    }

    fun UpdateUI(currentUser: FirebaseUser?){

    }
}