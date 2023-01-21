package com.tarasov_denis.retrofittraining

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
//import com.tarasov_denis.retrofittraining.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    //private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
       // binding = ActivityMainBinding.inflate(layoutInflater)
      // val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(R.layout.activity_main)


        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val text1 = findViewById<TextView>(R.id.text1)

        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer {
            text1.text = it.body
            Log.d(TAG, it.body)
            Log.d(TAG, it.title)
            Log.d(TAG, it.id.toString())
            Log.d(TAG, it.userId.toString())
        })

        viewModel.getPosts()
        viewModel.myResponseList.observe(this, Observer {
            for (user in it) {
                Log.d(TAG, user.body)
                Log.d(TAG, user.title)
                Log.d(TAG, user.id.toString())
                Log.d(TAG, user.userId.toString())
            }
        })

    }
}

// https://dev.to/theimpulson/making-get-requests-with-retrofit2-on-android-using-kotlin-4e4c

// https://www.section.io/engineering-education/making-api-requests-using-retrofit-android/

// https://habr.com/ru/post/428736/

// https://developer.alexanderklimov.ru/android/library/retrofit.php

// про data binding:
// https://www.fandroid.info/%D1%83%D1%80%D0%BE%D0%BA-8-android-data-binding-%D0%BE%D1%81%D0%BD%D0%BE%D0%B2%D1%8B