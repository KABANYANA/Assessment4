package com.example.assessment4.repository

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assessment4.model.User
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {

    val userRepo= UserRepository()
    val usersLiveData= MutableLiveData<List<User>>()
    val errLiveData= MutableLiveData<String>()


    fun fetchUsers() {
        viewModelScope.launch {
            var response= userRepo.getUsers()

            if (response.isSuccessful){
                usersLiveData.postValue((response.body()?.users))
            }else{
                errLiveData.postValue((response.errorBody()?.string()))
            }
        }
    }
}