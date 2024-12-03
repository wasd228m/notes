package com.example.myapplication.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://yourserver.com/") // Замените на ваш URL
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: NoteApi = retrofit.create(NoteApi::class.java)
}