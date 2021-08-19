package com.laohu.study.platform.extensions

inline fun <reified T> Any.asTo(): T? {
    return this as? T
}

fun Boolean?.orFalse() = this ?: false

fun String?.isNotNullOrEmpty() = !this.isNullOrEmpty()

fun Int?.orZero() = this ?: 0

fun Long?.orZero() = this ?: 0L