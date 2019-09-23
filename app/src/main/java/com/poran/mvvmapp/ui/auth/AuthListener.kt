package com.poran.mvvmapp.ui.auth

import com.poran.mvvmapp.data.db.entities.User

interface AuthListener {

    fun onStarted()
    fun onSuccess(user:User)
    fun onFailure(message:String)
}