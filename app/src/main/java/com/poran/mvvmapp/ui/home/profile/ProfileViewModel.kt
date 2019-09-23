package com.poran.mvvmapp.ui.home.profile

import androidx.lifecycle.ViewModel
import com.poran.mvvmapp.data.repositories.UserRepository

class ProfileViewModel (
    repository: UserRepository
): ViewModel() {
    val user=repository.getUser()

}
