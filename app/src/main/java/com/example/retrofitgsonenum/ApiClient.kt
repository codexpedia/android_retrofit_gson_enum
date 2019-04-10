package com.example.retrofitgsonenum

import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {
    // https://api.jsonbin.io/b/5cad463a4b652413968069a2
    // https://api.myjson.com/bins/17n6pk
    @GET("bins/17n6pk")
    fun getClothes(): Call<List<Cloth>>
}