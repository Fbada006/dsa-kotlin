package org.example.sort

fun selectionSort(array: IntArray) {
    for (i in array.indices) {
        // Track the minimum index
        var min = i
        // Start from i + 1 because we need to ignore the item before i
        for (j in i + 1 until array.size) {
            if (array[j] < array[min]) {
                // Find the minimum value
                min = j
            }
        }
        // Swap the minimum
        val temp = array[min]
        array[min] = array[i]
        array[i] = temp
        println(array.contentToString())
    }
}

fun main() {
    val array = intArrayOf(3, 2, 4, 1, 0)
    println(selectionSort(array))
}
