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
    private var Exerciselist:ArrayList<Exercisemodel>?=null
    private var currentExercisePosition=-1
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
        Exerciselist=constants.defaultExerciseList()
        binding?.toolbarExercise?.title = "7 Minute workout"
        binding?.toolbarExercise?.setNavigationOnClickListener {
            onBackPressed()
        }
        setupRestView()
    }
private fun setupRestView()
{
    binding?.flProgress?.visibility=View.VISIBLE
    binding?.textviewTitle?.visibility=View.VISIBLE
    binding?.tvExerciseName?.visibility=View.INVISIBLE
    binding?.exersiseView?.visibility=View.INVISIBLE
    binding?.ivimage?.visibility=View.INVISIBLE
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
            object : CountDownTimer(5000, 1000)//millisinfuture matlab katin jel basnu paro timer
            //1000 matlab harek tick matlab 1 sec ma onTick call hunxa
            {
                override fun onTick(millisUntilFinished: Long) {
                    binding?.progressbar?.progress = 10 - restProgress
                    binding?.tvTimer?.text =(10 - restProgress).toString()
                    //we cant assigin no so converted to string
                    restProgress++
                }

                override fun onFinish() {
                    currentExercisePosition++//array ko position 0 bata hos vanera ++ gareko -1 lai 0 banaako
                    setupExerciseView()
                }

            }.start()
    }
    private fun setupExerciseView()
    {
        binding?.flProgress?.visibility=View.INVISIBLE
        binding?.textviewTitle?.visibility=View.INVISIBLE
        binding?.tvExerciseName?.visibility=View.VISIBLE
        binding?.exersiseView?.visibility=View.VISIBLE
        binding?.ivimage?.visibility=View.VISIBLE
        if(erestTimer !=null)
        {
            erestTimer?.cancel()
            erestProgress=0
        }
        binding?.ivimage?.setImageResource(Exerciselist!![currentExercisePosition].getImage())
        binding?.tvExerciseName?.text=Exerciselist!![currentExercisePosition].getName()
        setExerciseProgressBar()
    }
    private fun setExerciseProgressBar() {
        binding?.progressbar?.progress = erestProgress
        erestTimer =
            object : CountDownTimer(5000, 1000)//millisinfuture matlab katin jel basnu paro timer
            //1000 matlab harek tick matlab 1 sec ma onTick call hunxa
            {
                override fun onTick(millisUntilFinished: Long) {
                    binding?.progressbarExercise?.progress = 30 - erestProgress
                    binding?.tvTimerExercise?.text =(30 - erestProgress).toString()
                    erestProgress++
                    //we cant assigin no so converted to string
                }

                override fun onFinish() {
                    if(currentExercisePosition < Exerciselist?.size!!-1)
                    {
                      setupRestView()
                    }
                    else
                    {
                        Toast.makeText(this@ExerciseActivity,
                            "Congratulations you have completed the exercise",Toast.LENGTH_SHORT).show()
                    }
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