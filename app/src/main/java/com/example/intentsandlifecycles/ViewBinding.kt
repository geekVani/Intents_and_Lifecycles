package com.example.intentsandlifecycles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentsandlifecycles.databinding.ActivityMainBinding
import com.example.intentsandlifecycles.databinding.ActivityViewBindingBinding

class ViewBinding : AppCompatActivity() {

    lateinit var mainBinding: ActivityViewBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // add view binding
        mainBinding = ActivityViewBindingBinding.inflate(layoutInflater)
        val view = mainBinding.root

        setContentView(view)

        // replaces findviewbyid method with view binding
        mainBinding.btnTodo.setOnClickListener {

            mainBinding.tvResultItem.text = mainBinding.etTodo.text.toString()
        }


    }
}