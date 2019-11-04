package com.example.andwallet

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.app.Activity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_summary.*


class SummaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var extras = getIntent().getExtras();
        var income: Int = extras!!.getInt(MainActivity.INCOME, 0)
        var expense: Int = extras!!.getInt(MainActivity.EXPENSE, 0)
        var total = income - expense;
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)
        txtExpense.setText("Expense: $expense$")
        txtIncome.setText("Income: $income$")
        txtTotal.setText("Total: $total$")



    }
}
