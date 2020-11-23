package com.example.jobmart

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_in.password
import kotlinx.android.synthetic.main.activity_sign_up.*


class  SignIn : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        auth = FirebaseAuth.getInstance()

        val btn_click_me2 = findViewById(R.id.login) as Button
        btn_click_me2.setOnClickListener {
            signinuser()

        }
        val btn_click_me = findViewById(R.id.signup) as Button
        btn_click_me.setOnClickListener {
            startActivity(Intent(this, SignUp::class.java))
            finish()
        }
        forgotpassword.setOnClickListener {
           forgotpassword()
        }




    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser: FirebaseUser? = auth.currentUser
        updateUI(currentUser)
    }

    fun updateUI(currentUser: FirebaseUser?) {


    }
    private fun forgotpassword()
    {
        auth.sendPasswordResetEmail(userName.text.toString())
            .addOnCompleteListener(this, OnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Reset link sent to your email", Toast.LENGTH_LONG)
                        .show()
                } else {
                    Toast.makeText(this, "Unable to send reset mail", Toast.LENGTH_LONG)
                        .show()
                }
            })
    }
    private fun signinuser()
    {


        auth.signInWithEmailAndPassword(userName.text.toString(), password.text.toString())
            .addOnCompleteListener(this, OnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Successfully Logged In", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
                }
            })

    }
}