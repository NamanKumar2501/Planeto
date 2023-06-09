package com.example.planeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.my_recycler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exit = findViewById<TextView>(R.id.exitBtn);

        window.decorView.apply { systemUiVisibility =
        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN}
        my_recycler.adapter = Adapter(setData.SetPlanets())
        my_recycler.layoutManager = LinearLayoutManager(this)



        exit.setOnClickListener{
            val builder = AlertDialog.Builder(this)

            //set title for alert dialog
            builder.setMessage("Do you want to exit this application....")

            //set message for alert dialog
            builder.setTitle("Exit in this Application : ")
            builder.setIcon(android.R.drawable.ic_dialog_alert)

            //performing positive action
            builder.setPositiveButton("Yes"){dialogInterface, which ->
                Toast.makeText(applicationContext,"Clicked Yes",Toast.LENGTH_SHORT).show()
                finish()
            }

            builder.setNegativeButton("No"){dialogInterface, which ->
                Toast.makeText(applicationContext,"Clicked No",Toast.LENGTH_SHORT).show()
            }

            //performing cancel action
            builder.setNeutralButton("Cancel"){dialogInterface , which ->
                Toast.makeText(applicationContext,"Canceled",Toast.LENGTH_SHORT).show()
            }

            //Creating AlertDialog
            val alertDialog: AlertDialog= builder.create()

            // Set Other dialog properties
            alertDialog.setCancelable(false)
            alertDialog.show()

        }

    }
}