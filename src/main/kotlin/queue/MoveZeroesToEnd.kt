package org.example.queue

import java.util.LinkedList
import java.util.Queue

fun moveZeroesToEnd(arr: IntArray): IntArray {
    val queue: Queue<Int> = LinkedList()

    for (num in arr) {
        if (num != 0) queue.offer(num)
    }

    for (i in arr.indices) {
        arr[i] = if (queue.isNotEmpty()) queue.poll() else 0
    }

    return arr
}

fun moveGivenNumToEnd(arr: IntArray, num: Int): IntArray {
    // J keeps track of the num elements
    var j = 0
    arr.forEachIndexed { index, value ->
        if (value != num && arr[j] == num) {
            val temp = arr[index]
            arr[index] = num // Can replace the value to 0 here
            arr[j] = temp
        }
        if (arr[j] != num) {
            j++
        }
    }
    return arr
}

fun main() {
    val arr = intArrayOf(2, 3, 3, 2, 2, 3)
    println(moveGivenNumToEnd(arr, 3).contentToString())
}
