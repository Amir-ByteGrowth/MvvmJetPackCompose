package com.example.mvvmjetpackcompose.data.remote



data class Resource<out T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String, data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, message)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}

sealed class ResourceSealed<T>(
    val data: T? = null,
    val message: String? = null
) {

    class Success<T>(data: T) : ResourceSealed<T>(data)

    class Error<T>(message: String?, data: T? = null) : ResourceSealed<T>(data, message)

    class Loading<T> : ResourceSealed<T>()

    class Empty<T> : ResourceSealed<T>()

}