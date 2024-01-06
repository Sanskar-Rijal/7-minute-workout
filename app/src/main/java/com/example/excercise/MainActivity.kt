package com.example.excercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import com.example.excercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding:ActivityMainBinding?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)//it says use this xml file called activity main
        //inflate it with this layout  aand store it inside binding object and use this root which is activity main xml file
        //now binding object can be used
        setContentView(binding?.root)
        //val frm_lyt :FrameLayout =findViewById(R.id.fl_start)
        binding?.flStart?.setOnClickListener {
            Toast.makeText(this@MainActivity,"Here will start the exercise",
                Toast.LENGTH_SHORT).show()
        }
        }
    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }
}