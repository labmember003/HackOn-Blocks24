package com.falcon.unikit.models.body

import com.google.gson.annotations.SerializedName

data class GetMyNotesBody(
    @SerializedName("googleToken")
    val googleToken: String
)
