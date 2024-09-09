package org.example.queue

import org.example.linkedlist.ListNode

class Queue {

    private var front: ListNode? = null
    private var rear: ListNode? = null
    private var length = 0

    fun length() = length
    fun isEmpty() = length == 0

    fun display() {
        if (isEmpty()) return

        var current = front
        while (current != null) {
            print("${current.data} --> ")
            current = current.next
        }
        print(null)
    }

    fun enqueue(data: Int) {
        val node = ListNode(data)

        if (isEmpty()) {
            front = node
        } else {
            rear?.next = node
        }
        rear = node
        length++
    }

    fun dequeue(): Int? {
        if (isEmpty()) throw NoSuchElementException("Empty Queue")
        val res = front?.data
        front = front?.next
        if (front == null) rear = null
        length--

        return res
    }
}
