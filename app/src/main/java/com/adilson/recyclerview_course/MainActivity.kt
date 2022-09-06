package com.adilson.recyclerview_course

import android.os.Bundle
import android.util.Log
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

        val adapter  = UserAdapter(user)

        binding.rvUser.adapter = adapter

        binding.fabSelectUsers.setOnClickListener{

            adapter.getSelectedItems().forEach{
                Log.i("Teste", it.toString())
            }
        }




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


}