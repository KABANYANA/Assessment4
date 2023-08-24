package com.example.assessment4.api


import com.example.assessment4.model.User
import com.example.assessment4.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiInterface {
    @GET("/posts")
    suspend fun getUsers(): Response<UserResponse>
    @GET("/posts/{id}")
    fun getUserById(@Path("id") userId:Int):Response<User>




}
