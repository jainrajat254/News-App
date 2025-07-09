package org.example.project.core.state

sealed class ResultState<out T> {
    object Loading : ResultState<Nothing>()
    object Idle : ResultState<Nothing>()
    data class Success<out T>(val data: T) : ResultState<T>()
    data class Failure(val error: Throwable) : ResultState<Nothing>()
}