package org.example.queue

import java.util.*
import java.util.Queue

class GenerateBinaryNumbers {

    fun generateBinaryNums(n: Int): Array<String> {
        val result = arrayOfNulls<String>(n)
        val queue: Queue<String> = LinkedList()
        queue.offer("1")

        for (i in 0 until  n) {
            result[i] = queue.poll()
            val n1 = result[i] + "0"
            val n2 = result[i] + "1"
            queue.offer(n1)
            queue.offer(n2)
        }

        return result.requireNoNulls()
    }
}
