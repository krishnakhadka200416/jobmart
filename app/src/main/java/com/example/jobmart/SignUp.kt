package com.example.jobmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class SignUp : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        auth = FirebaseAuth.getInstance()
        signup.setOnClickListener{
            signupuser()

        }
    }
    fun signupuser(){
        if(userName.text.toString().isEmpty()){
            userName.error = "Please enter email"
            userName.requestFocus()
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(userName.text.toString()).matches()){
            userName.error = "Please enter email"
            userName.requestFocus()
            return
        }
        if(password.text.toString().isEmpty()){
            password.error ="please enter password"
            password.requestFocus()
            return
        }
    }
}