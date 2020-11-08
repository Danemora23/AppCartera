package com.example.appcartera.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDataBase : RoomDatabase(){
    abstract fun UserDao(): UserDao
    companion object{
        @Volatile
        private var INSTACE: UserDataBase? = null

        fun getDataBase(context: Context): UserDataBase{
            val intance = INSTACE
            if(intance != null){
                return intance
            }
            synchronized(this){
                val instancen = Room.databaseBuilder(
                    context.applicationContext,
                    UserDataBase::class.java,
                    "usr_database"
                ).build()
                INSTACE=instancen
                return instancen
            }
        }
    }
}