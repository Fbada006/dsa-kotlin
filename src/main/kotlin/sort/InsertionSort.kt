package org.example.sort

fun insertionSort(array: IntArray) {
    array.forEachIndexed { idx, element ->
        var j = idx - 1

        while (j >= 0 && array[j] > element) {
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
