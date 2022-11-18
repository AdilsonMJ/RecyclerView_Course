package com.adilson.recyclerview_course

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.adilson.recyclerview_course.databinding.ResItemUserBinding
import layout.UserItem

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private val asyncListDiff: AsyncListDiffer<UserItem> = AsyncListDiffer(this, diffCallBack)

    inner class UserViewHolder(private val binding: ResItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /*
            ** Dono da View, wrapper da view que contem o objeto a ser reciclado.
            ** Reseprentacao da view no kotlin
            * Pode Ser Criado dentro da Class Adapter ou fora.
            * Dentro: Padrão criar Dentro, pois só sera utilizada dentro do adapter.
            * Fora: Caso utiliza a mesma viewHolder em mais de 1 adapter, se cria a viewHolder fora do adapter
         */

        private val textViewName: TextView

        init {
            textViewName = binding.tvNameUser
        }

        // Bind (liga) vincula os dados na view. Recebe os dados e passa para a View
        fun bind(user: UserItem) {
            binding.tvNameUser.text = user.fullName

        }
    }


    // inflate o objeto/layout que vai ser reciclado.
    // Sera Vai chamar esse metodo para criar o objeto, porem nao preenche o conteudo da view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        // val view = LayoutInflater.from(parent.context).inflate(R.layout.res_item_user, parent, false)
        val resItemUserBinding =
            ResItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(resItemUserBinding)

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(asyncListDiff.currentList[position])

    }

    override fun getItemCount(): Int = asyncListDiff.currentList.size

    fun upDateUser(userItem: List<UserItem>) {
        asyncListDiff.submitList(userItem)
    }

    object diffCallBack : DiffUtil.ItemCallback<UserItem>() {
        override fun areItemsTheSame(oldItem: UserItem, newItem: UserItem): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
            return when {
                oldItem.name == newItem.name -> false
                oldItem.lastName == newItem.lastName -> false
                else -> true
            }
        }

    }

}