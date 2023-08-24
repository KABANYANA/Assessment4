package com.example.assessment4.repository

//import com.example.assessment4.api.ApiClient
//import com.example.assessment4.api.ApiInterface
//import com.example.assessment4.model.UserResponse
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.withContext
//import retrofit2.Response
//
//class UserRepository {
//    val apiClient= ApiClient.buildApiClient(ApiInterface::class.java)
//
//    suspend fun getUsers() {
//        return withContext(Dispatchers.IO){
//            apiClient.getUsers()}
//    }
//}

import com.example.assessment4.api.ApiClient
import com.example.assessment4.api.ApiInterface


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class UserRepository {

    val  apiClient=ApiClient.buildApiClient((ApiInterface::class.java))
    suspend fun getUsers(){
        return withContext(Dispatchers.IO){
            apiClient.getUsers()
        }
    }
}