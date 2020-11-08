package com.example.appcartera.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movimientos")
data class User (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val descripcion: String,
    val cantidad: Int,
    val fecha: Int,
    val hora: Int
)