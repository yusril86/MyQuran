package com.yusril.myquran.data.response

import com.google.gson.annotations.SerializedName

data class BaseResponse<ModelName>(

    val data: ModelName? = null,

)

data class BaseResponseList<ModelName>(

    @SerializedName("data")
    val data: List<ModelName>? = null,

    @SerializedName("message")
    val message: String? = null,

    @SerializedName("status")
    val status: Boolean
)

data class BaseResponseMessage(
    @SerializedName("message")
    val message: String? = null
)


