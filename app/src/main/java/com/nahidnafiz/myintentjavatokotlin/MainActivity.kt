package com.nahidnafiz.myintentjavatokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nahidnafiz.myintentjavatokotlin.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity()
{
    lateinit var binding: ActivityMainBinding
    lateinit var dataHelper: DataHelper

    private val timer = Timer()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataHelper = DataHelper(applicationContext)
        
        //Toast.make===



    }




}











