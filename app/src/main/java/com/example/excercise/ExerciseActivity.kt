package com.example.excercise

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.provider.MediaStore.Audio.Media
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.core.view.size
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.excercise.databinding.ActivityExerciseBinding
import org.w3c.dom.Text
import java.util.Locale

class ExerciseActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    private var binding: ActivityExerciseBinding? = null

    private var restTimer: CountDownTimer? = null
    private var restProgress = 0

    private var erestTimer: CountDownTimer? = null
    private var erestProgress = 0

    private var Exerciselist:ArrayList<Exercisemodel>?=null

    private var currentExercisePosition=-1
    //setting up text to speech
    private var tts:TextToSpeech?=null
    private var player:MediaPlayer?=null//adding mediaplayer

    private var exerciseAdapter:ExerciseStatusAdapter?=null
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
        tts= TextToSpeech(this,this)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        Exerciselist=constants.defaultExerciseList()
        binding?.toolbarExercise?.title = "7 minute Workout"
        binding?.toolbarExercise?.setNavigationOnClickListener {
            onBackPressed()
        }
        setupRestView()
        setupExerciseStatusRecyclerView()
        binding?.rvExerciseStatus?.adapter=exerciseAdapter
    }
    /**setting up recycler view status **/
    private fun setupExerciseStatusRecyclerView()
    {
        binding?.rvExerciseStatus?.layoutManager= LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        //i don't want it to display in reverse order so false
        exerciseAdapter = ExerciseStatusAdapter(Exerciselist!!)

    }
    private fun setupRestView()
    {
        try {
            val soundURI= Uri.parse(
                "android.resource://com.example.excercise/"+R.raw.press_start)
            player=MediaPlayer.create(applicationContext,soundURI)
            player?.isLooping=false
            player?.start()
        }catch (e:Exception)
        {
            e.printStackTrace()
        }
        binding?.flProgress?.visibility=View.VISIBLE
        binding?.textviewTitle?.visibility=View.VISIBLE
        binding?.tvExerciseName?.visibility=View.INVISIBLE
        binding?.exersiseView?.visibility=View.INVISIBLE
        binding?.ivimage?.visibility=View.INVISIBLE
        binding?.tvupcomminglabel?.visibility=View.VISIBLE
        binding?.tvupcommingexercisename?.visibility=View.VISIBLE
        if (restTimer !=null) //checking if timer is already running or not, if its running then canceling it by making 0
        {
            restTimer?.cancel()
            restProgress=0
        }
        //binding?.flProgress?.visibility=View.INVISIBLE
        /**
         * now adding upcomming label and upcomming exercises
         */
        binding?.tvupcommingexercisename?.text=Exerciselist!![currentExercisePosition+1].getName()//currentExercise position is at -1 so if we don't do +1 app will crash
        setRestProgressBar()
    }
    private fun setRestProgressBar() {
        binding?.progressbar?.progress = restProgress
        restTimer =
            object : CountDownTimer(10000, 1000)//millisinfuture matlab katin jel basnu paro timer
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
        binding?.tvupcomminglabel?.visibility=View.INVISIBLE
        binding?.tvupcommingexercisename?.visibility=View.INVISIBLE
        speakOut("Exercise name is "+Exerciselist!![currentExercisePosition].getName())
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
            object : CountDownTimer(30000, 1000)//millisinfuture matlab katin jel basnu paro timer
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
        if(tts !=null) {
            tts?.shutdown()
            tts?.stop()
        }
        if(player !=null)
        {
            player?.stop()
        }
        binding=null
    }
    private  fun speakOut(text:String) {
        tts?.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")
    }

    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS)
        {
            val result = tts!!.setLanguage(Locale.ENGLISH)
            if(result == TextToSpeech.LANG_MISSING_DATA ||
                result == TextToSpeech.LANG_NOT_SUPPORTED)
            {
                Log.e("TTS","The language specified is not supported")
            }
        }
        else
        {
            Log.e("TTS","initialization failed")
        }
    }
    }