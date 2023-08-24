package com.example.assessment4.ui

import android.content.Context

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assessment4.databinding.UserBinding

import com.example.assessment4.model.User


class Adapter(var userList:List<User>,var context:Context): RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding= UserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserViewHolder(binding)


    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        var newProduct = userList[position]
        val binding = holder.binding
        binding.tvId.text = newProduct.id.toString()
        binding.tvTitle.text = newProduct.title




    }


    override fun getItemCount(): Int {
        return userList.size
    }
}

class UserViewHolder(var binding: UserBinding):RecyclerView.ViewHolder(binding.root){

}