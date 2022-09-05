package com.adilson.recyclerview_course

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.adilson.recyclerview_course.databinding.ActivityMainBinding
import layout.User

class MainActivity : AppCompatActivity() {


    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val user = getData()
        populateData(user) // I can user the lamb because I just have 1 param, but if I have 2 or more I need user this way.



    }

    private fun getData(): MutableList<User> {
        val user = mutableListOf<User>()

        repeat(500) {
            user.add(
                User(
                    id = it.toLong(),
                    name = "Adilson",
                    lastName = "Jager"
                )
            )
        }
        return user
    }

    private fun populateData(user: MutableList<User>) {
        binding.rvUser.adapter = UserAdapter(
            user,
            {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        )
    }
}