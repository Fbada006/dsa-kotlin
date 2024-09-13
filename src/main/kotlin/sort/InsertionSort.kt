package org.example.sort

fun insertionSort(array: IntArray) {
    array.forEachIndexed { idx, element ->
        var j = idx - 1 // Sorted part will always be the previous item

        while (j >= 0 && array[j] > element) {
            // Shift the larger elements compared to the current element by 1 position
            array[j + 1] = array[j]
            j -= 1
        }
        // Because temp will be minus one here, we need to move it forward
        array[j + 1] = element
        println(array.joinToString())
    }
}

fun main() {
    val array = intArrayOf(3, 2, 4, 1, 0)
    println(insertionSort(array))
}
