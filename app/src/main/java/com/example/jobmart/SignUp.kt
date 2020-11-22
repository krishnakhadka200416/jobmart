package com.example.jobmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.password
import kotlinx.android.synthetic.main.activity_sign_up.*

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
    private fun signupuser(){


        if(first_name.text.toString().isEmpty()){
            userName.error = "Please enter first name"
            userName.requestFocus()
            return
        }
       if(middle_name.text.toString().isEmpty()){
           userName.error = "Please enter middle name"
           userName.requestFocus()
           return
       }
       if(last_name.text.toString().isEmpty()){
           userName.error = "Please enter last name"
           userName.requestFocus()
           return
       }
       if(email.text.toString().isEmpty()){
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
        auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this,SignUp::class.java))
                    finish()

                } else {

                    Toast.makeText(baseContext, "Sign Up  failed.",
                        Toast.LENGTH_SHORT).show()

                }

                // ...
            }
    }
}