package org.example.stack

import java.util.*

class NextGreaterElement {

    fun nextGreaterElement(array: IntArray): IntArray {
        // The final result of the array we return
        val result = IntArray(array.size)
        // Stack to hold the values from the end of the array
        val stack = Stack<Int>()

        for (i in array.size - 1 downTo 0) {
            while (stack.isNotEmpty() && stack.peek() <= array[i]) {
                // In this case, this item cannot be the next greater element so we need to remove it from the stack
                stack.pop()
            }

            if (stack.isEmpty()) {
                // An empty stack means there is no comparison to do so this spot needs to be occupied by -1
                result[i] = -1
            } else {
                // Otherwise this spot is occupied by the top most item
                result[i] = stack.peek()
            }
            // Add the next element to the stack
            stack.push(array[i])
        }

        // A bit of housekeeping to clear memory
        stack.clear()

        // Return the result
        return result
    }
}
