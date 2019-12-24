package com.tegarap.starwarapp.ui.characters

import android.net.Uri
import com.tegarap.starwarapp.data.network.ApiClient
import com.tegarap.starwarapp.data.network.response.CharactersResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.tegarap.starwarapp.data.models.Character

class CharactersInteractor {

    interface onLoadCharacters {
        fun onLoadCharactersSuccess(characters: List<Character>?, nextPage: Int?)
        fun onLoadCharactersError()
    }

    fun getCharacters(onLoadCharacters: onLoadCharacters, page: Int) {
        ApiClient.service.getCharacters(page).enqueue(object : Callback<CharactersResponse> {
            override fun onFailure(call: Call<CharactersResponse>, t: Throwable) {
                onLoadCharacters.onLoadCharactersError()
            }

            override fun onResponse(call: Call<CharactersResponse>, response: Response<CharactersResponse>) {
                var nextPage: Int? = null
                if(response.body()?.next != null) {
                    nextPage = Uri.parse(response.body()?.next).getQueryParameter("page")?.toInt()
                }
                onLoadCharacters.onLoadCharactersSuccess(response.body()?.results, nextPage)
            }
        })
    }
}