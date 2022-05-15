package com.example.cleancodepractise.data.repo

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.cleancodepractise.cleancode.Habbit
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import java.util.*
import kotlin.collections.HashMap

class QuestionRepo {
    var _scores = 0;
    val _score = MutableLiveData<Int>()
    val name: MutableMap<String, Int> = HashMap<String, Int>()

    fun provideQuestions(): Array<Habbit> {
        return Habbit.values();
    }

    fun updateScore(answer: Boolean) {
        if (answer) {
            _scores = _scores + 6
            _score.value = _scores
        }
    }

    fun updateHabitRecords(habbit:String, status: Boolean) {
        name.put(habbit, if (status) 1 else 0)
        updateScore(status)
    }

    fun saveRecordToFireBase() {
        basicReadWrite( )
    }

    fun basicReadWrite() {
        // [START write_message]
        // Write a message to the database
        val database = Firebase.database
        val myRef = database.getReference(Date().toString())
        myRef.setValue(name)
        // [END write_message]

        // [START read_message]
        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue<Map<String,Int>>()
                Log.d(ContentValues.TAG, "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
            }
        })
    }

}