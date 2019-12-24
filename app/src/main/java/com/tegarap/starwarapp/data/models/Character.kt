package com.tegarap.starwarapp.data.models


import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("birth_year")
    val birthYear: String, // 19BBY
    @SerializedName("created")
    val created: String, // 2014-12-09T13:50:51.644000Z
    @SerializedName("edited")
    val edited: String, // 2014-12-20T21:17:56.891000Z
    @SerializedName("eye_color")
    val eyeColor: String, // blue
    @SerializedName("films")
    val films: List<String>,
    @SerializedName("gender")
    val gender: String, // male
    @SerializedName("hair_color")
    val hairColor: String, // blond
    @SerializedName("height")
    val height: String, // 172
    @SerializedName("homeworld")
    val homeworld: String, // https://swapi.co/api/planets/1/
    @SerializedName("mass")
    val mass: String, // 77
    @SerializedName("name")
    val name: String, // Luke Skywalker
    @SerializedName("skin_color")
    val skinColor: String, // fair
    @SerializedName("species")
    val species: List<String>,
    @SerializedName("starships")
    val starships: List<String>,
    @SerializedName("url")
    val url: String, // https://swapi.co/api/people/1/
    @SerializedName("vehicles")
    val vehicles: List<String>
)