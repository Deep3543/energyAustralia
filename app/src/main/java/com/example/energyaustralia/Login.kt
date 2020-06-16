package com.example.energyaustralia

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin.setOnClickListener {

            var id=etUsername.text.toString()
            var password=etpassword.text.toString()
            //17BCA093
            if((id.equals("admin")) && (password.equals("admin"))){
                var preference=getSharedPreferences("MyPref", Context.MODE_PRIVATE)
                var editor=preference.edit()
                editor.putString("uname",etUsername.text.toString())
                editor.commit()

                Toast.makeText(this,"Login Successfully", Toast.LENGTH_LONG).show()
                var intent: Intent = Intent(this,Dashboard::class.java)
                //17BCA093
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this,"username or password wrong", Toast.LENGTH_LONG).show()
            }
        }
    }
}
