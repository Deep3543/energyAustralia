package com.example.energyaustralia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_insert.*

class Insert : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)


        BtnInsertDetails.setOnClickListener {
            var db=DatabaseHelper(this)
            var Cno=etCno.text.toString()
            var Cname=etCname.text.toString()
            var Cunit=etNoOfunitsConsumed.text.toString()
            var PPUnit=etPricePerUnit.text.toString()
            var flag = db.insert(Cno, Cname, Cunit,PPUnit)
            if(flag)
            {
                Toast.makeText(this,"Inserted successfully", Toast.LENGTH_LONG).show()
                etCno.text.clear()
                etCname.text.clear()
                etNoOfunitsConsumed.text.clear()

                etPricePerUnit.text.clear()
            }
            else
            {
                Toast.makeText(this,"Error!!", Toast.LENGTH_LONG).show()
            }
        }

    }
}