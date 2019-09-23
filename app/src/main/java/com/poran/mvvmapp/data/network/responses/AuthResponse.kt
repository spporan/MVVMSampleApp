package com.poran.mvvmapp.data.network.responses

import com.poran.mvvmapp.data.db.entities.User

data class AuthResponse(
    val isSuccessful:Boolean?,
    val message:String?,
    val user:User?
)