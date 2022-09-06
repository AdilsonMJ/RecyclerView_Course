package com.adilson.recyclerview_course

import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.util.forEach
import androidx.recyclerview.widget.RecyclerView
import com.adilson.recyclerview_course.databinding.ResItemUserBinding
import layout.User

class UserAdapter(
    private val users: List<User>,
    ) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private val userStateArray : SparseBooleanArray = SparseBooleanArray()


    inner class UserViewHolder(itemView : ResItemUserBinding) :
        RecyclerView.ViewHolder(itemView.root){

        private val tvNameUser : TextView
        private val cbUser : CheckBox

        init {
            tvNameUser = itemView.tvNameUser
            cbUser = itemView.cbUser
        }

        fun bind(userName : String, position: Int){
            tvNameUser.text = userName
            cbUser.isChecked = userStateArray[position, false]
            cbUser.setOnClickListener{
                userStateArray.put(position, cbUser.isChecked) // Put Atualiza se ja exister.
            }

        }

    }

    fun getSelectedItems(): List<User>{
        val selectedUsers = mutableListOf<User>()
        userStateArray.forEach{key, value ->

            if (value){
                selectedUsers.add(users[key])
            }

        }

        return  selectedUsers
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        // val view = LayoutInflater.from(parent.context).inflate(R.layout.res_item_user, parent, false)

        val resItemUserBinding = ResItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(resItemUserBinding)

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position].fullName, position)

    }

    override fun getItemCount(): Int {
        return users.size
    }

}