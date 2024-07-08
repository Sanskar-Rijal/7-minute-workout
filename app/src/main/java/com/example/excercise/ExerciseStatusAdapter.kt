package com.example.excercise

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.excercise.databinding.ActivityExerciseBinding
import com.example.excercise.databinding.ItemExerciseStatusBinding

class ExerciseStatusAdapter(val items:ArrayList<Exercisemodel>):
    RecyclerView.Adapter<ExerciseStatusAdapter.ViewHolder>()
//we will make  viewholder an inner class
{
        class ViewHolder(itembinding: ItemExerciseStatusBinding):RecyclerView.ViewHolder
            (itembinding.root)//we are using view binding so we need to pass the binding
        {
                val tvItem = itembinding.tvItem
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemExerciseStatusBinding.inflate(LayoutInflater
            .from(parent.context),parent,false))//we don't wat to attach to parrent so false
    /**layout inflator we need to get it from somewhere,i.e parent contex **/
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val model : Exercisemodel = items[position]//it will be called 12 times because,we have 12 exercises
        holder.tvItem.text=model.getId().toString()
        /**we are getting id as a string from the model
         which is used to display exercise number**/
    }
}