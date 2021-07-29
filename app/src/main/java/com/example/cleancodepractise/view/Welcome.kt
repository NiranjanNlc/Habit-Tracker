package com.example.cleancodepractise.view

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import com.example.cleancodepractise.R
import kotlinx.android.synthetic.main.activity_welcome.*

class Welcome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        rotate(imageView)
        translate(nameDetail)
        scale(developer)
        fader(version)
        //colorizer(name)
        Handler().postDelayed(Runnable() {
                   run()
            {
                startActivity(Intent(this,Quiz::class.java))
                finish();
            }
        }, 5000);
    }

    fun rotate(star:View)
    {
        val animator = ObjectAnimator.ofFloat(star, View.ROTATION, -360f, 0f)
        animator.duration = 1000
        animator.start()
    }
    fun translate(star:View)
    {
        val animator = ObjectAnimator.ofFloat(star, View.TRANSLATION_X, 200f)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }
    fun scale(star:View)
    {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 4f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 4f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(
            star, scaleX, scaleY)
        animator.repeatCount = 4
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }
    private fun fader(star:View) {
        val animator = ObjectAnimator.ofFloat(star, View.ALPHA, 0f)
        animator.repeatCount = 5
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }
    private fun colorizer( star: Button) {
        var animator = ObjectAnimator.ofArgb(star.parent,
            "backgroundColor", Color.BLACK, Color.RED)
        animator.setDuration(500)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }
    fun showerAnimation()
    {

        // coould not make it for the implementation due to time constraints .................
    }
}

