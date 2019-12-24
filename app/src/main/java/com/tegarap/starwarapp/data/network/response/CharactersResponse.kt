package com.tegarap.starwarapp.data.network.response

import java.util.ArrayList
import com.tegarap.starwarapp.data.models.Character

class CharactersResponse {
    var next: String? = null
    var results: List<Character>? = ArrayList()
}