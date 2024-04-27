package com.example.excercise

import android.health.connect.datatypes.ExerciseSegment

object constants {
    fun defaultExerciseList():ArrayList<Exercisemodel>
    {
       val exerciselist =ArrayList<Exercisemodel>()
        val jumpingjacks=Exercisemodel(
            1,"Jumping Jacks",
            R.drawable.ic_jumping_jacks,false,false)

        val abdominal_crunch=Exercisemodel(2,"abdominal crunch",
            R.drawable.ic_abdominal_crunch,false,false)

        val highknees=Exercisemodel(3,"High knees Running in Place",R.drawable.ic_high_knees_running_in_place
        ,false,false)

        val lunge= Exercisemodel(4,"Lunge",
            R.drawable.ic_lunge,false,false)

        val plank = Exercisemodel(5,"Plank",
            R.drawable.ic_plank,false,false)

        val push_up=Exercisemodel(6,"push up",
            R.drawable.ic_push_up,false,false)

        val push_up_and_rotation=Exercisemodel(7,"Push up and Rotation",
            R.drawable.ic_push_up_and_rotation,false,false)

        val side_plank=Exercisemodel(8,"Side Plank",
            R.drawable.ic_side_plank,false,false)

        val squat=Exercisemodel(9,"squat",
            R.drawable.ic_squat,false,false)

        val step_up_onto_chair=Exercisemodel(10,"Step up onto Chair",
            R.drawable.ic_step_up_onto_chair,false,false)

        val triceps =Exercisemodel(11,"Triceps dip on chair",
            R.drawable.ic_triceps_dip_on_chair,false,false)

        val wall_sit=Exercisemodel(12,"wall sit",
            R.drawable.ic_wall_sit,false,false)

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