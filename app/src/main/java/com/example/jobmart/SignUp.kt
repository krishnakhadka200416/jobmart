package com.example.jobmart

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.password
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class SignUp : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var userreference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        auth = FirebaseAuth.getInstance()

        register.setOnClickListener{
            signupuser()

        }
    }
    private fun signupuser(){
        val Fnames = first_name.text.toString()
        val Lnames = last_name.text.toString()
        val Mnames = middle_name.text.toString()
        val emails = email.text.toString()
        if(email.text.toString().isEmpty()){
            email.error = "Please enter email"
            email.requestFocus()
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()){
            email.error = "Please enter email"
            email.requestFocus()
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
                    val currentUser = auth.currentUser
                    currentUser!!.sendEmailVerification()
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                store(Fnames, Mnames, Lnames, emails)
                            }
                        }
                //    startActivity(Intent(this,MainActivity::class.java))
                  //  finish()
                } else {
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()

                }

            }
    }
    private fun store(Fnames: String, Mnames: String, Lnames: String, emails: String) {

        var curruserId = auth.currentUser!!.uid
        userreference = FirebaseDatabase.getInstance().reference.child("usersID").child(curruserId)

        val currUserHashMap = HashMap<String, Any>()

        currUserHashMap["usersID"] = curruserId
        currUserHashMap["FName"] = Fnames.toLowerCase()
        currUserHashMap["MName"] = Mnames.toLowerCase()
        currUserHashMap["LName"] = Lnames.toLowerCase()
        currUserHashMap["Email"] = emails
        userreference.updateChildren(currUserHashMap)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Sign up Success.", Toast.LENGTH_LONG).show();
                    startActivity(Intent(this@SignUp, MainActivity::class.java))
                    finish()}
            }

    }

}