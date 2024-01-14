package com.example.excercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.excercise.databinding.ActivityExerciseBinding

class ExerciseActivity : AppCompatActivity() {
    private var binding:ActivityExerciseBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        binding=ActivityExerciseBinding.inflate(layoutInflater)
        /**
         * creating a tool bar
         * first of all we have to set up a tool bar in xml file
         */
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarExercise)
        if(supportActionBar != null)
        {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarExercise?.title="Let's Exercise Together"
        binding?.toolbarExercise?.setNavigationOnClickListener {
            onBackPressed()
        }
 }
}