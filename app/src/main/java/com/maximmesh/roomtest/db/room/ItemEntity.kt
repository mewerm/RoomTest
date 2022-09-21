package com.maximmesh.roomtest.db.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items" ) //необходимая аннотация для room, чтобы показать ему, что это не просто data class. Указываем имя таблицы,
data class ItemEntity(
    @PrimaryKey(autoGenerate = true) //для автоматической генерации Первичного ключа
      val id: Int? = null,
    @ColumnInfo(name = "name") //название колонок
    val name: String,
    @ColumnInfo(name = "price") //название колонок
    val price: String,


)
