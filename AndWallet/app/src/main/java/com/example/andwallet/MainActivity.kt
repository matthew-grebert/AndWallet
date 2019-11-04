package com.example.andwallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.income_layout.*
import kotlinx.android.synthetic.main.income_layout.view.*
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_summary.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_pin.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var balance = 0
    var expense = 0
    var income = 0

    companion object{
        const val EXPENSE = "EXPENSE"
        const val INCOME = "INCOME"


        const val REQUEST_DETAILS = 1001
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin)
        btnPin.setOnClickListener{
            if(txtPinput.text.toString() == "1234"){
                var intentD = Intent()
                intentD.setClass(this@MainActivity, appBody::class.java)
                startActivity(intentD)
            }else{
                txtPinput.error= "Wrong Password. Try 1234"
            }
        }


    }


}
