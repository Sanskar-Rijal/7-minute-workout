package com.example.excercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.core.view.size
import com.example.excercise.databinding.ActivityExerciseBinding

class ExerciseActivity : AppCompatActivity() {
    private var binding: ActivityExerciseBinding? = null
    private var restTimer: CountDownTimer? = null
    private var restProgress = 0
    private var erestTimer: CountDownTimer? = null
    private var erestProgress = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        /**
         * creating a tool bar
         * first of all we have to set up a tool bar in xml file
         */
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarExercise)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarExercise?.title = "7 Minute workout"
        binding?.toolbarExercise?.setNavigationOnClickListener {
            onBackPressed()
        }
        setupRestView()
    }
private fun setupRestView()
{
    if (restTimer !=null) //checking if timer is already running or not, if its running then canceling it by making 0
    {
        restTimer?.cancel()
        restProgress=0
    }
    //binding?.flProgress?.visibility=View.INVISIBLE
    setRestProgressBar()
}
    private fun setRestProgressBar() {
        binding?.progressbar?.progress = restProgress
        restTimer =
            object : CountDownTimer(10000, 1000)//millisinfuture matlab katin jel basnu paro timer
            //1000 matlab harek tick matlab 1 sec ma onTick call hunxa
            {
                override fun onTick(millisUntilFinished: Long) {
                    restProgress++
                    binding?.progressbar?.progress = 10 - restProgress
                    binding?.tvTimer?.text =(10 - restProgress).toString()
                        //we cant assigin no so converted to string
                }

                override fun onFinish() {
                    setupExerciseView()
                }

            }.start()
    }
    private fun setupExerciseView()
    {
        binding?.flProgress?.visibility=View.INVISIBLE
        binding?.textviewTitle?.text="Exercise Name"
        binding?.exersiseView?.visibility=View.VISIBLE
        if(erestTimer !=null)
        {
            erestTimer?.cancel()
            erestProgress=0
        }
        setExerciseProgressBar()
    }
    private fun setExerciseProgressBar() {
        binding?.progressbar?.progress = restProgress
        restTimer =
            object : CountDownTimer(30000, 1000)//millisinfuture matlab katin jel basnu paro timer
            //1000 matlab harek tick matlab 1 sec ma onTick call hunxa
            {
                override fun onTick(millisUntilFinished: Long) {
                    erestProgress++
                    binding?.progressbarExercise?.progress = 30 - erestProgress
                    binding?.tvTimerExercise?.text =(30 - erestProgress).toString()
                    //we cant assigin no so converted to string
                }

                override fun onFinish() {
                    Toast.makeText(this@ExerciseActivity, "30 seconds are over", Toast.LENGTH_SHORT)
                        .show()
                }

            }.start()
    }


    override fun onDestroy() {
        super.onDestroy()
        if (restTimer !=null)
        {
            restTimer?.cancel()
            restProgress=0
        }
        if(erestTimer !=null)
        {
            erestTimer?.cancel()
            erestProgress=0
        }
        binding=null
    }
}