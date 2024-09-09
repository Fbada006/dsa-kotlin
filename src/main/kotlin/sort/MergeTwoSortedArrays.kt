package org.example.sort

fun mergeTwoSortedArrays(arr1: IntArray, arr2: IntArray, n: Int, m: Int): IntArray {
    val result = IntArray(n + m)
    var i = 0 // traverse arr 1
    var j = 0 // traverse arr2
    var k = 0 // traverse result

    while (i < n && j < m) {
        val elem1 = arr1[i]
        val elem2 = arr2[j]
        if (elem1 < elem2) { // if arr 1 element is bigger than arr2 at jth elem
            result[k] = arr1[i] // store arr 1 elem in result
            i++
        } else {
            result[k] = arr2[j] // store arr2 elem in result
            j++
        }
        k++
    }

    // either arr 1 or arr2 are exhausted
    while (i < n) {
        result[k] = arr1[i]
        i++
        k++
    }

    while (j < m) {
        result[k] = arr1[j]
        j++
        k++
    }

    return result
}


fun main() {
    val arr1 = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val arr2 = intArrayOf(2, 4, 6, 8, 9, 10)
    val result = mergeTwoSortedArrays(arr1, arr2, arr1.size, arr2.size)
    println(result.contentToString())
}
