package com.tegarap.starwarapp.data.network

import com.tegarap.starwarapp.data.network.response.CharactersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("people/")
    fun getCharacters(@Query("page") page: Int): Call<CharactersResponse>

}


