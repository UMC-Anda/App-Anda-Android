package com.example.anda.data.entities

import com.google.gson.annotations.SerializedName

data class MyLocation(
    @SerializedName("yCoordi") val yCoordi: Float,
    @SerializedName("xCoordi") val xCoordi: Float,
    @SerializedName("within") val within: Float
    )
