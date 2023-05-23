package com.sopt.carrot.util

import android.content.Context
import android.util.Log
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun <ResponseType> Call<ResponseType>.enqueueUtil(
    onSuccess: (ResponseType) -> Unit,
    onError: ((stateCode: Int) -> Unit)? = null,
) {
    this.enqueue(object : Callback<ResponseType> {
        override fun onResponse(call: Call<ResponseType>, response: Response<ResponseType>) {
            if (response.isSuccessful) {
                onSuccess.invoke(response.body() ?: return)
            } else {
                Log.d("Hello", "error")
                onError?.invoke(response.code())
            }
        }

        override fun onFailure(call: Call<ResponseType>, t: Throwable) {
            Log.d("NetworkTest", "error:$t")
        }
    })
}

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
