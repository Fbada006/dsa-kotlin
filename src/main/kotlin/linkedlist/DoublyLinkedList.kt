package org.example.linkedlist

class DoublyLinkedList {
    var head: DoubleListNode? = null
    var tail: DoubleListNode? = null
    private var length = 0

    fun isEmpty() = length == 0
    fun length() = length

    fun insertFirst(value: Int) {
        val newNode = DoubleListNode(value)
        if (isEmpty()) {
            tail = newNode
        } else {
            head?.previous = newNode
        }

        newNode.next = head
        head = newNode

        length++
    }

    fun insertLast(value: Int) {
        val node = DoubleListNode(value)
        if (isEmpty()) head = node else tail?.next = node

        node.previous = tail
        tail = node
        length++
    }

    fun deleteFirst() {
        if (isEmpty()) return

        val temp = head
        if (head == tail) {
            tail = null
        } else {
            head?.next?.previous = null
        }
        head = head?.next
        temp?.next = null

        length--
    }

    fun deleteLast() {
        if (isEmpty()) return

        val temp = tail
        if (head == tail) {
            head = null
        } else {
            tail?.previous?.next = null
        }

        tail = tail?.previous
        temp?.previous = null

        length--
    }

    fun display(reversed: Boolean = false) {
        if (reversed) {
            if (tail == null) return
            var tail = tail
            while (tail != null) {
                print("${tail.data} --> ")
                tail = tail.previous
            }
        } else {
            if (head == null) return
            var current = head
            while (current != null) {
                print("${current.data} --> ")
                current = current.next
            }
        }

        print(null)
    }
}

data class DoubleListNode(val data: Int, var previous: DoubleListNode? = null, var next: DoubleListNode? = null)


