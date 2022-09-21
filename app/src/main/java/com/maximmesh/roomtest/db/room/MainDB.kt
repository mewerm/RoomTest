package com.maximmesh.roomtest.db.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ItemEntity::class], version = 1) //version - версия data base
abstract class MainDB: RoomDatabase() {
//через этот класс будем получать доступ к функции специальной которая будет создавать базу данных, либо выдавать инстаницю
    //создаем companion object

    abstract fun getDao(): ItemDao

    companion object{
        //ниже функция, которая будет выдавать нашу базу данных
        fun getDB(context: Context): MainDB {
        return Room.databaseBuilder(
            context.applicationContext,
            MainDB::class.java,
            "test.db"
        ).build()
        }

    }
}