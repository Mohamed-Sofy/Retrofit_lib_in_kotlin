package com.example.retrofitinkotlin.Retrofit

import com.example.retrofitinkotlin.model.post
import io.reactivex.Observable
import retrofit2.http.GET

interface API {
    @get:GET("posts")
    val posts: Observable<List<post>>
}