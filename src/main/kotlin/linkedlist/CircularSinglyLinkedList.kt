package org.example.linkedlist

class CircularSinglyLinkedList {

    private var last: ListNode? = null
    private var length = 0

    fun length() = length
    fun isEmpty() = length == 0

    fun display() {
        if (last == null) return

        var first = last?.next

        while (first != last) {
            print("${first?.data} ")
            first = first?.next
        }
        print("${first?.data}")
        println()
    }

    fun insertFirst(data: Int) {
        val newNode = ListNode(data)
        if (last == null) {
            last = newNode
            last?.next = newNode
            return
        }

        newNode.next = last?.next
        last?.next = newNode
        length++
    }

    fun insertLast(data: Int) {
        val newNode = ListNode(data)
        if (last == null) {
            last = newNode
            last?.next = newNode
            return
        }

        newNode.next = last?.next
        last?.next = newNode
        last = newNode

        length++
    }

    fun deleteFirst(): ListNode? {
        // 1 2 3 4 5 6 7
        if (isEmpty()) throw NoSuchElementException("Empty list")

        val temp = last?.next

        last?.next = temp?.next
        temp?.next = null

        return temp
    }

    fun deleteLast() {
        // 1 2 3 4 5 6 7
        if (isEmpty()) return

        val temp = last
    }

    fun createCircularSinglyLinkedList() {
        val first = ListNode(1)
        val second = ListNode(5)
        val third = ListNode(10)
        val fourth = ListNode(15)
        val fifth = ListNode(1)

        first.next = second
        second.next = third
        third.next = fourth
        fourth.next = fifth
        fifth.next = first

        last = fifth
        length = 5
    }
}
