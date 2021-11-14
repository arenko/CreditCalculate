package com.credit.clearscore.data.model.result

sealed class ApiResult<out T : Any> {

    data class Success<out T : Any>(val data: T) : ApiResult<T>()
    data class NetworkError(val exception: Exception) : ApiResult<Nothing>()
    data class DataError(val errorCode: Int) : ApiResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is NetworkError -> "Error[exception=$exception]"
            is DataError -> "Error[errorCode=$errorCode]"
        }
    }
}