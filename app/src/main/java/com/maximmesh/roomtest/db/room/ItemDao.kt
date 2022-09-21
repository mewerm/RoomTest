package com.maximmesh.roomtest.db.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao //для работы с рум опять же нужна эта аннотация
interface ItemDao {
    @Insert // собственно как и здесь. Insert для записи, Query для считывания
    fun insertItem (item: ItemEntity)

    @Query("SELECT * FROM items") //обычный запрос SQLite * - означает все
    fun getAllItems(): Flow<List<ItemEntity>> //класс Flow благодаря библиотеке "androidx.lifecycle:lifecycle-livedata-ktx:2.5.1"
    //благодаря этому Flow будет постоянно обновляться список при измнениях(добавили,удалили и тд)

}