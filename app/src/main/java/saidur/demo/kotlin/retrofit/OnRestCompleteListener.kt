package saidur.demo.kotlin.retrofit

import saidur.demo.kotlin.retrofit.model.ResponseType

interface OnRestCompleteListener<T> {

    fun onComplete(responseType: ResponseType, result: T, message: String)
}
