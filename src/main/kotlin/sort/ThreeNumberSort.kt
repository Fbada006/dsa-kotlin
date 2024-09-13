package org.example.sort

fun threeNumberSort(array: IntArray): IntArray {
    var i = 0 // Traverse from start to end
    var j = 0 // Keep track of when zeros have been moved to the start and swapping index
    var k = array.size - 1 // Traverse from end to start

    while (i <= k) {
        if (array[i] == 0) {
            // Move the zeros to the start
            swap(array, i, j)
            i++
            j++
        } else if (array[i] == 1) {
            // 1 is not to be touched so move along
            i++
        } else if (array[i] == 2) {
            // Move the 2 to the end
            swap(array, i, k)
            k--
        }
    }
    return array
}

private fun swap(array: IntArray, i: Int, j: Int) {
    val temp = array[i]
    array[i] = array[j]
    array[j] = temp
}

fun main() {
    val arr = intArrayOf(1, 2, 0, 0, 2, 1, 0, 2, 0, 1, 2, 0)
    println(threeNumberSort(arr).contentToString())
}
