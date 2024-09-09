package org.example.sort

fun bubbleSort(array: IntArray): IntArray {
    var isSwapped: Boolean
    for (i in array.indices) {
        isSwapped = false
        // We ignore the last item here because it is sorted
        for (j in 0 until array.size - i - 1) {
            if (array[j] > array[j + 1]) {
                // Store in temp variable
                val temp = array[j]
                // swap the two items
                array[j] = array[j + 1]
                array[j + 1] = temp
                isSwapped = true
            }
        }
        if (!isSwapped) break
    }
    return array
}

fun main() {
    val array = intArrayOf(3, 2, 4, 1, 0)
    println(bubbleSort(array).contentToString())
}
