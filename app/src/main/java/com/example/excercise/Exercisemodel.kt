package com.example.excercise

class Exercisemodel(
    private var id:Int,
    private var name:String,
    private var image :Int,
    private var isCompleted:Boolean,
    private  var isSelected:Boolean
)
{
    fun getId():Int
    {
        return id
    }
    fun setId(id: Int)
    {
        this.id=id
    }
    fun getName():String
    {
        return name
    }
    fun setName( name:String)
    {
        this.name=name
    }
    fun getImage():Int
    {
        return image
    }
    fun setImage(image: Int)
    {
        this.image=image
    }
    fun getIscompleted():Boolean
    {
        return isCompleted
    }
    fun setIscompleted(completed:Boolean)
    {
        isCompleted=completed
    }
    fun getIsselected():Boolean
    {
        return isSelected
    }
    fun setIsselected(select:Boolean)
    {
        this.isSelected=select
    }
}