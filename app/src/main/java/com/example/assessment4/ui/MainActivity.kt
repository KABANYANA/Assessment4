package com.example.assessment4.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assessment4.databinding.ActivityMainBinding
import com.example.assessment4.repository.UserViewModel


class MainActivity : AppCompatActivity() {

    val usersViewModel: UserViewModel by viewModels()
    lateinit var adapter : Adapter
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        usersViewModel.fetchUsers()

//        usersViewModel.errLiveData.observe(this) { err ->
//            Toast.makeText(baseContext, err, Toast.LENGTH_LONG).show()
        usersViewModel.errLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })




        usersViewModel.usersLiveData.observe(this, Observer { usersList->
            val userRvAdapter = Adapter(usersList ?: emptyList(), context = this)
            binding.rvPosts.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.rvPosts.adapter = userRvAdapter
            Toast.makeText(baseContext,"fetched successfully",Toast.LENGTH_LONG).show()
        })
    }
}