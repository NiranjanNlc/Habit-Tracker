package com.example.cleancodepractise.viewmodal

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleancodepractise.cleancode.Habbit
import com.example.cleancodepractise.data.repo.QuestionRepo

class QuestionViewModal(val repo:QuestionRepo)
//@Inject constructor (val repo: QuestionRepo)
    : ViewModel()
{
    val habbits :List<Habbit> =  (repo.provideQuestions().toList())
    var questionNumber=MutableLiveData<Int>();
    val question =MutableLiveData<String>()
    val _question :LiveData<String> = question
    val _optionA= MutableLiveData<Boolean>()
    var _optionB= MutableLiveData<Boolean>()
    init {
        questionNumber.value=0
        _optionB.value=false
        _optionA.value=false
        question.value = questionNumber.value?.let { habbits.get(it).habbit }
    }
    fun nextQuestion()
    {
        if(checkAnswerGiven())
        {
            saveToRepo()
            nullifyAllOptions()
            println(" Genrated next question ....")
            displayNextQuestion()
        }
    }


    private fun checkAnswerGiven(): Boolean
    {
        var check =if ((_optionB.value!!).or(_optionA.value!!)) true else false
        Log.d("  next question status " , check.toString())
        return check
    }

    private fun displayNextQuestion()
    {
        if(questionNumber.value!! <16)
        {question.value = questionNumber.value?.let { habbits.get(it).habbit }
        }
        else
        {
            repo.saveRecordToFireBase()
        }
    }

    private fun nullifyAllOptions()
    {
        questionNumber.value= questionNumber.value?.plus(1)
        _optionA.value = false
        _optionB .value= false
    }

    private fun saveToRepo()
    {

        repo.updateHabitRecords(question.value!!,_optionA.value!!)
    }
}