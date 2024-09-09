package org.example.stack

import java.util.*

class ReverseStringWithStack {

    fun reverse(string: String): String {
        val stack = Stack<Char>()
        val chars = string.toCharArray()

        for (char in chars) {
            stack.push(char)
        }

        for ((idx, _) in chars.withIndex()) {
            chars[idx] = stack.pop()
        }

        return String(chars)
    }
}
