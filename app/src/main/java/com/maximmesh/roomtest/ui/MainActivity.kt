package com.maximmesh.roomtest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData
import com.maximmesh.roomtest.databinding.ActivityMainBinding
import com.maximmesh.roomtest.db.room.ItemEntity
import com.maximmesh.roomtest.db.room.MainDB

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db = MainDB.getDB(this) //инициализировали DB

        db.getDao().getAllItems().asLiveData().observe(this){list -> //получить как liveData
            binding.texView.text = "" //перед циклом очищаем
            list.forEach {
                val text = "Id: ${it.id} Name: ${it.name} Price: ${it.price}\n"
                binding.texView.append(text) //выводим базу в текстВью
            }
        }
        binding.buttonSave.setOnClickListener {
            val item = ItemEntity(
                null,
                binding.editTextName.text.toString(),
                binding.editTextPrice.text.toString()
            )
            Thread {
                db.getDao().insertItem(item) //записали в базу данных.
                // Нельзя использовать Main поток, пока сделал обычный вспомогательный, лучше конечно корутины
            }.start()

        }
    }
}