package org.example.linkedlist

class SinglyLinkedList {

    var head: ListNode? = null

    fun insertFirst(data: Int) {
        val node = ListNode(data)
        node.next = head
        head = node
    }

    fun insertLast(data: Int) {
        val node = ListNode(data)
        if (head == null) {
            head = node
            return
        }
        var current = head
        while (current?.next != null) {
            current = current.next
        }
        current?.next = node
    }

    fun insertAtPosition(data: Int, position: Int) {
        if (position == 1) {
            insertFirst(data)
            return
        }

        var previous = head
        var count = 1

        while (count < position - 1) {
            previous = previous?.next
            count++
        }

        // What was the original next pointer, which will be the next of the new node
        // The previous pointer's next will now be the new node
        val previousNext = previous?.next
        val node = ListNode(data)
        node.next = previousNext
        previous?.next = node
    }

    fun deleteFirst(): ListNode? {
        if (head == null) return null

        val temp = head
        head = temp?.next
        temp?.next = null
        return temp
    }

    fun deleteLast(): ListNode? {
        if (head == null || head?.next == null) return head

        var lastItem = head
        var previous: ListNode? = null

        while (lastItem?.next != null) {
            previous = lastItem
            lastItem = lastItem.next
        }

        previous?.next = null

        return lastItem
    }

    fun deleteAtPosition(position: Int): ListNode? {
        if (position == 1) return deleteFirst()

        var previous = head
        var count = 1

        while (count < position - 1) {
            previous = previous?.next
            count++
        }

        val temp = previous?.next
        val tempNext = temp?.next
        temp?.next = null

        previous?.next = tempNext

        return temp
    }

    fun display() {
        var current = head
        while (current != null) {
            print("${current.data} --> ")
            current = current.next
        }
        println(null)
    }

    fun middle(): ListNode? {
        if (head == null) return null
        var slowPointer = head
        var fastPointer = head

        while (fastPointer?.next != null) {
            slowPointer = slowPointer?.next
            fastPointer = fastPointer.next?.next
        }
        return slowPointer
    }

    fun getNthNodeFromEnd(n: Int): ListNode? {
        if (head == null) return null

        require(n > 0 && n <= size()) { "Invalid value: n = $n" }

        var mainPtr = head
        var refPtr = head
        var count = 0

        while (count < n) {
            refPtr = refPtr?.next
            count++
        }

        while (refPtr != null) {
            refPtr = refPtr.next
            mainPtr = mainPtr!!.next
        }
        return mainPtr
    }

    fun reverse(): ListNode? {
        // 1 2 3 4 5 6 7 8
        if (head == null) {
            return null
        }

        var current = head
        var previous: ListNode? = null
        var next: ListNode?

        while (current != null) {
            next = current.next
            current.next = previous
            previous = current
            current = next
        }
        return previous
    }

    fun find(searchKey: Int): ListNode? {
        if (size() == 0) return null

        var current = head
        while (current != null) {
            if (current.data == searchKey) {
                return current
            }
            current = current.next
        }
        return null
    }

    fun size(): Int {
        if (head == null) return 0
        var count = 0
        var current = head
        while (current != null) {
            count++
            current = current.next
        }
        return count
    }

    fun removeDuplicates() {
        var current = head
        while (current?.next != null) {
            if (current.data == current.next?.data) {
                current.next = current.next?.next
            } else
                current = current.next
        }
    }

    fun insertInSorted(newNode: ListNode): ListNode? {
        var current = head
        var previous: ListNode? = null

        // Important to check here so that you can add more than one value of the same value
        while (current != null && current.data <= newNode.data) {
            previous = current
            current = current.next
        }

        newNode.next = current
        previous?.next = newNode

        return head
    }

    fun removeGivenKey(key: Int): ListNode? {
        var current = head
        var previous: ListNode? = null

        while (current != null && current.data != key) {
            previous = current
            current = current.next
        }

        if (current == null) return null
        previous?.next = current.next
        return current
    }

    fun detectLoop(): Boolean {
        var fastPointer = head
        var slowPointer = head

        while (fastPointer?.next != null) {
            fastPointer = fastPointer.next?.next
            slowPointer = slowPointer?.next

            if (slowPointer == fastPointer) {
                return true
            }
        }
        return false
    }

    fun loopStartRemove() {
        var fastPointer = head
        var slowPointer = head

        while (fastPointer?.next != null) {
            fastPointer = fastPointer.next?.next
            slowPointer = slowPointer?.next

            if (slowPointer == fastPointer) {
                removeLoop(slowPointer)
                break
            }
        }
    }

    private fun removeLoop(slowPointer: ListNode?) {
        var slowPtr = slowPointer
        var temp = head

        while (temp?.next != slowPtr?.next) {
            temp = temp?.next
            slowPtr = slowPtr?.next
        }
        slowPointer?.next = null
    }

//    private fun getStartingNode(slowPtr: ListNode?): ListNode? {
//        var temp = head
//        while (temp != slowPtr) {
//            temp = temp?.next
//            slowPtr = slowPtr?.next
//        }
//        return temp // starting node of the loop
//    }
}

// Merge two
fun merge(nodeA: ListNode?, nodeB: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var tail: ListNode = dummy
    var a = nodeA
    var b = nodeB

    while (a != null && b != null) {
        if (a.data <= b.data) {
            tail.next = a
            a = a.next
        } else {
            tail.next = b
            b = b.next
        }
        tail = tail.next!!
    }

    if (a == null) {
        tail.next = b
    } else {
        tail.next = a
    }

    return dummy.next
}

fun mergeAddingReversed(listA: SinglyLinkedList, listB: SinglyLinkedList): ListNode? {
    val dummy = ListNode(0)
    var tail: ListNode = dummy
    var a = listA.reverse()
    var b = listB.reverse()
    var carry = 0

    while (a != null || b != null) {
        val x = a?.data ?: 0
        val y = b?.data ?: 0
        val sum = carry + x + y
        carry = sum / 10
        val remainder = sum % 10
        tail.next = ListNode(remainder)
        tail = tail.next!!
        a = a?.next
        b = b?.next
    }

    if (carry > 0) {
        tail.next = ListNode(carry)
    }

    return dummy.next
}

data class ListNode(val data: Int, var next: ListNode? = null)
