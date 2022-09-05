package com.adilson.recyclerview_course

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adilson.recyclerview_course.databinding.ResItemUserBinding
import layout.User

class UserAdapter(
    private val users: List<User>,
    private val onClick: (String) -> Unit
    ) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(itemView : ResItemUserBinding) : RecyclerView.ViewHolder(itemView.root){
        private val tvNameUser : TextView

        init {
            tvNameUser = itemView.tvNameUser
        }

        fun bind(userName : String, onClick: (String) -> Unit){
            tvNameUser.text = userName
            itemView.rootView.setOnClickListener{
                onClick(userName)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        // val view = LayoutInflater.from(parent.context).inflate(R.layout.res_item_user, parent, false)

        val resItemUserBinding = ResItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(resItemUserBinding)

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position].fullName, onClick)

    }

    override fun getItemCount(): Int {
        return users.size
    }

}