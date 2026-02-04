package pt.portugueseeats.kmp.core

import pt.portugueseeats.kmp.domain.error.ErrorEntity

sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val error: ErrorEntity) : Result<Nothing>()
}