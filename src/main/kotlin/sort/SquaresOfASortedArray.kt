package org.example.sort

import kotlin.math.abs

// Given an integer array sorted in ascending order, return an array of the squares of each number sorted in ascending order
// Example, given input arr [-4,-1,0,3,10] output will be [0,1,9,16,100].
// After squaring, the array becomes [16,1,0,9,100], after sorting then it becomes [0,1,9,16,100]
fun sortedSquares(array: IntArray): IntArray {
    val result = IntArray(array.size)
    var i = 0 // Track items from start
    var j = array.lastIndex // Track items from end index
    for (idx in result.indices.reversed()) {
        if (abs(array[i]) > abs(array[j])) {
            // If a number is bigger, then it has a bigger square
            // So the current index in the resulting array is this number squared
            result[idx] = array[i] * array[i]
            i++
        } else {
            result[idx] = array[j] * array[j]
            j--
        }
    }

    return result
}

fun main() {
    val array = intArrayOf(-4,-1,0,3,10)
    print(sortedSquares(array).contentToString())
}
