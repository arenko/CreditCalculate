package com.credit.clearscore.base

import android.content.Context
import android.util.Log
import com.credit.clearscore.data.model.result.ApiResult
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Response
import javax.inject.Inject


open class BaseRepository @Inject constructor(@ApplicationContext private val context: Context) {

    suspend fun <T : Any> request(call: suspend () -> Response<T>): T? {

        val result: ApiResult<T> = apiResult(call)
        var data: T? = null

        when (result) {
            is ApiResult.Success -> data = result.data
            is ApiResult.NetworkError -> {
                Log.d("network error", "${result.exception}")
            }
        }

        return data

    }

    private suspend fun <T : Any> apiResult(call: suspend () -> Response<T>): ApiResult<T> {
        val response = call.invoke()
        if (response.isSuccessful) {
            return ApiResult.Success(response.body()!!)
        } else {
            return ApiResult.NetworkError(Exception())
        }
    }
}