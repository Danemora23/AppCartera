package com.example.appcartera.Database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel (application: Application):AndroidViewModel(application) {
    val readAllUser:LiveData<List<User>>
    private val repository: UserRepository
    init {
        val userDao = UserDataBase.getDataBase(application).UserDao()
        repository = UserRepository(userDao)
        readAllUser = repository.readAllUser
    }
    fun addUser(user: User){
        viewModelScope.launch (Dispatchers.IO){
            repository.addUser(user)
        }
    }
}