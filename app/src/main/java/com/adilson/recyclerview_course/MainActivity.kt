package com.adilson.recyclerview_course

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.adilson.recyclerview_course.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val user = mutableListOf<String>()

        repeat(500){
            user.add("Adilson Jager $it")
        }

        binding.rvUser.adapter = UserAdapter(user)
        binding.rvUser.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))


    }
}