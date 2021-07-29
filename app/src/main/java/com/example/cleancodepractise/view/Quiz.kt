package com.example.cleancodepractise.view

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.cleancodepractise.R
import com.example.cleancodepractise.data.repo.QuestionRepo
import com.example.cleancodepractise.databinding.ActivityQuizBinding
import com.example.cleancodepractise.receiverAndService.TimeReceiver
import com.example.cleancodepractise.viewmodal.QuestionViewModal
import com.example.cleancodepractise.viewmodal.viewmodalfactory.ViewModalFactory
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class Quiz : AppCompatActivity() {

    private lateinit var binding:ActivityQuizBinding
    @Inject lateinit var viewModelFactory: ViewModalFactory
    @Inject lateinit var  sampleViewModal: QuestionViewModal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_quiz)
        setAlarm(System.currentTimeMillis() -840000)
       bindData()
       observeChange()
    }
    private fun observeChange()
    {
        sampleViewModal._question
            .observe(this, Observer
            {
                Log.d(" Question Number $it  ", sampleViewModal.questionNumber.toString())

            })
        sampleViewModal.questionNumber.observe(this,{
            if(it==16)
            {
                Log.d(" QActivity Started  ", sampleViewModal.questionNumber.toString())
                startActivity(Intent(this, Congratulation::class.java))
            }
        })
        println("After observing0")
    }

    fun bindData()
    {
       initialseViewModel()
        binding.viewModal = sampleViewModal
        binding.lifecycleOwner=this
    }

    private fun initialseViewModel()
    {
       sampleViewModal= ViewModalFactory(QuestionRepo()).create(QuestionViewModal::class.java)

    }
    private fun setAlarm(timeInMillis: Long) {
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, TimeReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)
        alarmManager.setRepeating(
            AlarmManager.RTC,
            timeInMillis,
            AlarmManager.INTERVAL_FIFTEEN_MINUTES,
            pendingIntent
        )
        Toast.makeText(this, "Alarm is set", Toast.LENGTH_SHORT).show()
        Log.d("Alarm Bell", " Time in millis " +getDate(timeInMillis,"\"dd/MM/yyyy hh:mm:ss.SSS\""))
        println(" Time in millis " +getDate(timeInMillis,"\"dd/MM/yyyy hh:mm:ss.SSS\""))
    }
    fun getDate(milliSeconds: Long, dateFormat: String?): String? {
        // Create a DateFormatter object for displaying date in specified format.
        val formatter = SimpleDateFormat(dateFormat)
        // Create a calendar object that will convert the date and time value in milliseconds to date.
        val calendar: Calendar = Calendar.getInstance()
        calendar.setTimeInMillis(milliSeconds)
        return formatter.format(calendar.getTime())
    }
}
