package com.example.cleancodepractise.data.modal

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cleancode.Habbit

@Entity(tableName = "result")
data class Result (@PrimaryKey(autoGenerate = true) val id: Int =0, val question : String, val score:Int)
{

}
