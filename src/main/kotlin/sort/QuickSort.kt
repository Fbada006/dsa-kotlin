package org.example.sort

fun quickSort(array: IntArray, low: Int, high: Int): IntArray {
    if (low < high) {
        val pivot = partition(array, low, high)
        // We need to ignore the pivot here because it is already sorted, plus sorting the left side will be
        // problematic if on the left side because high will always be the pivot
        quickSort(array, low, pivot - 1) // Sort the left side
        quickSort(array, pivot + 1, high) // Sort the right side
    }

    return array
}

private fun partition(arr: IntArray, low: Int, high: Int): Int {
    // Low to j-1 will have elements smaller than the pivot
    // J to i-1 will have elements greater than pivot
    // i to high are items that have not been traversed yet
    val pivot = arr[high]
    var i = low
    var j = low

    // Traverse the whole array from i to last item
    while (i <= high) {
        if (arr[i] <= pivot) {
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
            // This item has been sorted and temp is in the correct place, ie j-1 so increase j to keep sorting others
            j++
        }
        // Move to the next item
        i++
    }
    // J-1 will have the index of the partition
    return j - 1
}

fun main() {
    val arr = intArrayOf(1, 2, 0, 0, 2, 1, 0, 2, 0, 1, 2, 0)
    println(quickSort(arr, 0, arr.lastIndex).contentToString())
}
