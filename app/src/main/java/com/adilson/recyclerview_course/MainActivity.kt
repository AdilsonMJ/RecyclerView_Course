package com.adilson.recyclerview_course

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adilson.recyclerview_course.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }

}