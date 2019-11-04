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

class appBody : AppCompatActivity() {

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
        setContentView(R.layout.activity_main)

        btnAdd.setOnClickListener{
            addTodo()
        }

        btnSummary.setOnClickListener{
            openSummary()
        }

        btnDeleteAll.setOnClickListener{
            layoutContent.removeAllViews()
            balance = 0
            expense = 0
            income = 0
            updateBalance()
        }


    }

    private fun openSummary() {
        var intentDetails = Intent()
        intentDetails.setClass(this@appBody, SummaryActivity::class.java)
        intentDetails.putExtra(INCOME,income)
        intentDetails.putExtra(EXPENSE, expense)

        startActivity(intentDetails)

        //startActivityForResult(intentDetails, 1001)
    }

    private fun addTodo() {
        var todoView = layoutInflater.inflate(
            R.layout.income_layout, null, false)

        if(etIncome.text.isNotEmpty() && etAmount.text.isNotEmpty()) {

            todoView.tvIncome.text = etIncome.text.toString()
            todoView.tvAmount.text = etAmount.text.toString() + "$"

            if (cbIncome.isChecked) {
                todoView.ivIncome.setImageResource(
                    android.R.drawable.ic_input_add
                )
                balance += etAmount.text.toString().toInt();
                income += etAmount.text.toString().toInt();
            }else{
                balance -= etAmount.text.toString().toInt();
                expense += etAmount.text.toString().toInt();
            }
            todoView.btnDelete.setOnClickListener {
                layoutContent.removeView(todoView);

            }


            layoutContent.addView(todoView, 0)
            updateBalance()
            etIncome.setText("")
            etAmount.setText("")
        }else{
            if(etIncome.text.isEmpty()) {
                etIncome.error = "This field cannot be empty"
            }
            if(etAmount.text.isEmpty()) {
                etAmount.error = "This field cannot be empty"
            }
        }
    }

    private fun updateBalance(){
        txtBalance.setText("Balance: $balance$")
    }

}
