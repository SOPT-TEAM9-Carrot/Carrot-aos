package com.sopt.carrot.util

object StringUtils {
    fun lineHandle(comment: String): String {
        var newString = ""
        var index = 0

        while (index < comment.length) {
            if (index > 0) {
                newString += "\n" + comment.slice(index..getSmall(comment.length - 1, index + 26))
            } else {
                newString += comment.slice(index..getSmall(comment.length - 1, index + 26))
            }
            index += 27
        }
        return newString
    }

    fun getSmall(a: Int, b: Int) = if (a <= b) a else b
}