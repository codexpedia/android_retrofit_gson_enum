package com.example.retrofitgsonenum

import com.google.gson.annotations.SerializedName

data class Cloth (
    @SerializedName("size") val clothSize : ClothSize,
    @SerializedName("cloth") val cloth : String
)