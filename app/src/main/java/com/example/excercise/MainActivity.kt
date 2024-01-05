package com.example.excercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val frm_lyt :FrameLayout =findViewById(R.id.fl_start)
        frm_lyt.setOnClickListener {
            Toast.makeText(this@MainActivity,"Here will start the exercise",
                Toast.LENGTH_SHORT).show()
        }
    }
}