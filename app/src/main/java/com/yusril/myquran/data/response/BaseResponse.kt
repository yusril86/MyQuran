package com.yusril.myquran.data.response

import com.google.gson.annotations.SerializedName

data class BaseResponse<ModelName>(

//    @SerializedName("data")
    val data: ModelName? = null,

)

data class BaseResponseList<ModelName>(
    val data: List<ModelName>? = null
)

data class BaseResponseMessage(
    @SerializedName("message")
    val message: String? = null
)



