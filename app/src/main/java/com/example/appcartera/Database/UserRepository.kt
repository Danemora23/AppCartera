package com.example.appcartera.Database

import android.service.autofill.UserData
import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {
    val readAllUser: LiveData<List<User>> = userDao.readdAllUser()
    fun addUser(user: User){
        userDao.addUser(user)
    }
}