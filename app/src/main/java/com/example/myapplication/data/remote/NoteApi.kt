package com.example.myapplication.data.remote


import com.example.myapplication.Note
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.*

interface NoteApi {
    @GET("/notes")
    suspend fun getNotes(): List<Note>

    @POST("/notes")
    suspend fun postNote(@Body note: Note): Response<Unit>

    @DELETE("/notes/{id}")
    suspend fun deleteNoteById(@Path("id") id: Int): Response<Unit>
}