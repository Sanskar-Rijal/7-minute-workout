package com.example.excercise

import android.health.connect.datatypes.ExerciseSegment

object constants {
    fun defaultExerciseList():ArrayList<Exercisemodel>
    {
       val exerciselist =ArrayList<Exercisemodel>()
        val jumpingjacks=Exercisemodel(
            1,"Jumping Jacks",
            R.drawable.jumping_jacks,false,false)

        val abdominal_crunch=Exercisemodel(2,"Abdominal Crunch",
            R.drawable.ab_crunch,false,false)

        val highknees=Exercisemodel(3,
            "High knees Running in Place",R.drawable.high_knees
        ,false,false)

        val lunge= Exercisemodel(4,"Lunge",
            R.drawable.lunge,false,false)

        val plank = Exercisemodel(5,"Plank",
            R.drawable.plank,false,false)

        val push_up=Exercisemodel(6,"Push Up",
            R.drawable.pushups,false,false)

        val push_up_and_rotation=Exercisemodel(7,"Push up And Rotation",
            R.drawable.pushup_and_rotation,false,false)

        val side_plank=Exercisemodel(8,"Side Plank",
            R.drawable.plank,false,false)

        val squat=Exercisemodel(9,"Squat",
            R.drawable.squat,false,false)

        val step_up_onto_chair=Exercisemodel(10,"Step Up Onto Chair",
            R.drawable.stepup,false,false)

        val triceps =Exercisemodel(11,"Triceps Dip On Chair",
            R.drawable.triceps_dip,false,false)

        val wall_sit=Exercisemodel(12,"Wall Sit",
            R.drawable.wall_sit,false,false)

        exerciselist.add(jumpingjacks)
        exerciselist.add(abdominal_crunch)
        exerciselist.add(highknees)
        exerciselist.add(lunge)
        exerciselist.add(plank)
        exerciselist.add(push_up)
        exerciselist.add(push_up_and_rotation)
        exerciselist.add(side_plank)
        exerciselist.add(squat)
        exerciselist.add(step_up_onto_chair)
        exerciselist.add(triceps)
        exerciselist.add(wall_sit)
        return  exerciselist
    }
}