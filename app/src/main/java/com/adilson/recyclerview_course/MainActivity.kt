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
        val adapter  = UserAdapter()
        adapter.setData(user)
        binding.rvUser.adapter = adapter

        binding.fabSelectUsers.setOnClickListener{

            user.add( User(
                -1,
                "Nilton",
                "Reis"
            ))
            adapter.setData(user)

            adapter.getSelectedItems().forEach{
                Log.i("Teste", it.name)
            }
        }




    }

    private fun getData(): MutableList<User> {
        val user = mutableListOf<User>()

        repeat(5) {
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