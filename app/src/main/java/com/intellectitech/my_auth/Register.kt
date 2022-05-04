package com.intellectitech.my_auth

import android.content.Intent
import android.media.tv.TvContract
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth


class Register : AppCompatActivity() {
    private lateinit var analytics: FirebaseAnalytics
    private lateinit var auth: FirebaseAuth

    //The lateinit var lookup in defined a property without value set directly
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        analytics = Firebase.analytics
        auth = Firebase.auth
    }
    //View is the base class for widgets,
    fun register(view:View){
        val email = findViewById<EditText>(R.id.etemail1).text.toString()
        val password =findViewById<EditText>(R.id.etpwd).text.toString()
         auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{ task ->
             if(task.isSuccessful){
                 val intent = Intent(this,MainActivity::class.java)
                 startActivity(intent)
                 finish()
             }
         }.addOnFailureListener{exception ->
             Toast.makeText(applicationContext,exception.localizedMessage, Toast.LENGTH_LONG).show()



         } }
    fun goToLogin(view:View){
      val intent=Intent(this,Login::class.java)
        startActivity(intent)

    }

}