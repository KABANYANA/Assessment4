package com.example.assessment4.ui

import android.content.Context

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assessment4.databinding.UserBinding

import com.example.assessment4.model.User


class Adapter(var userList:List<User>,var context:Context): RecyclerView.Adapter<Adapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding= UserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserViewHolder(binding)


    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        var newUser = userList.get(position)
        holder.bindd(newUser)


    }


    override fun getItemCount(): Int {
        return userList.size
    }
    class UserViewHolder(var binding: UserBinding):RecyclerView.ViewHolder(binding.root){
       fun bindd(newUser: User) {
           binding.apply {

               tvId.text=newUser.id.toString()
               tvTitle.text=newUser.title
               tvBody.text=newUser.body



           }

       }

    }
}

