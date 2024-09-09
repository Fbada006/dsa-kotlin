package org.example.stack

import java.util.*

class ValidParentheses {

    fun validParentheses(string: String): Boolean {
        if (string.isEmpty()) return true
        if (string.length % 2 != 0) return false

        val stack = Stack<Char>()

        for (char in string) {
            if (char == '(' || char == '[' || char == '{') {
                stack.push(char)
            } else {
                if (stack.isEmpty()) return false
                val topChar = stack.peek()

                if ((char == ')' && topChar == '(') ||
                    (char == ']' && topChar == '[') ||
                    (char == '}' && topChar == '{')
                ) {
                    stack.pop()
                } else {
                    return false
                }
            }
        }

        return stack.isEmpty()
    }
}
