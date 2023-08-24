package com.example.assessment4.model

data class UserResponse(

    var products:List<User>,
    var total:Int,
    var skip:Int,
    var limit:Int
)
