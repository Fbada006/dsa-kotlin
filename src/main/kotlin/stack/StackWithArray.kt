package org.example.stack

class StackWithArray(capacity: Int) {
    private var top = 0
    private lateinit var arr: IntArray

    fun Stack(capacity: Int) {
        top = -1
        arr = IntArray(capacity)
    }

    fun size(): Int {
        return top + 1
    }

    fun isEmpty(): Boolean {
        return top < 0
    }

    fun isFull(): Boolean {
        return arr.size == size()
    }

    fun push(data: Int) {
        if (isFull()) {
            throw RuntimeException("Stack is full !!!")
        }
        top++
        arr[top] = data
    }

    fun pop(): Int {
        if (isEmpty()) {
            throw RuntimeException("Stack is empty !!!")
        }
        val result = arr[top]
        top--
        return result
    }

    fun peek(): Int {
        if (isEmpty()) {
            throw RuntimeException("Stack is empty !!!")
        }
        return arr[top]
    }
}
