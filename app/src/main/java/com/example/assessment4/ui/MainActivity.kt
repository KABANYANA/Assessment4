package com.example.assessment4.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.assessment4.databinding.ActivityMainBinding
import com.example.assessment4.repository.UserViewModel


class MainActivity : AppCompatActivity() {

    val usersViewModel:UserViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        usersViewModel.fetchUsers()

        usersViewModel.errLiveData.observe(this,{err->
            Toast.makeText(baseContext,err,Toast.LENGTH_LONG).show() })

        usersViewModel.usersLiveData.observe(this, {usersList->
            val usersRvAdapter=Adapter(usersList?: emptyList(), context = this)
            binding.rvPosts.layoutManager=GridLayoutManager(this@MainActivity,2)
            binding.rvPosts.adapter =usersRvAdapter
            Toast.makeText(baseContext,
            "fetches${usersList.size} users",Toast.LENGTH_LONG).show()

        })
    }}