package saidur.demo.app.retrofit

import saidur.demo.app.retrofit.model.ResponseType

interface OnRestCompleteListener<T> {

    fun onComplete(responseType: ResponseType, result: T, message: String)
}
