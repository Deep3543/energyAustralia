package com.example.energyaustralia

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_dashboard.*

class Dashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val bottomSheetDialog= BottomSheetDialog(this)

        val view =layoutInflater.inflate(R.layout.bottom_sheet_layout,null)

        bottomSheetDialog.setContentView(view)

        menu_button.setOnClickListener {
            bottomSheetDialog.show()
        }

        val BtnIns = view.findViewById<Button>(R.id.insert);
        val BtnVi = view.findViewById<Button>(R.id.view);
        val BtnExit = view.findViewById<Button>(R.id.exit);
        val BtnLogot= view.findViewById<Button>(R.id.signout)


        BtnIns.setOnClickListener {
            bottomSheetDialog.dismiss()
            var intent: Intent = Intent(this,Insert::class.java)
            startActivity(intent)
        }
        BtnVi.setOnClickListener {
            var intent: Intent = Intent(this, View::class.java)
            startActivity(intent)
        }
        BtnExit.setOnClickListener {
            finishAndRemoveTask()

        }
        BtnLogot.setOnClickListener {

            var preference=getSharedPreferences("MyPref", Context.MODE_PRIVATE)
            var edit=preference.edit()
            edit.clear()

            edit.commit()
            Toast.makeText(this,"Logout Successfully", Toast.LENGTH_LONG).show()
            var intent: Intent = Intent(this,Login::class.java)
            startActivity(intent)
            finish()
        }
    }
}
