package org.example.stack

import org.example.linkedlist.ListNode
import java.util.*

class StackWithLinkedList {

    private var top: ListNode? = null
    private var length = 0

    fun length() = length
    fun isEmpty() = length == 0

    fun push(data: Int) {
        val node = ListNode(data)
        node.next = top
        top = node
        length++
    }

    fun pop(): Int {
        if (isEmpty()) throw EmptyStackException()
        val result = top!!.data

        top = top?.next
        length--
        return result
    }

    fun peek(): Int {
        if (isEmpty()) throw EmptyStackException()
        return top!!.data
    }
}
