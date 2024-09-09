package org.example.search

fun binarySearch(arr: IntArray, target: Int): Int {
    var low = 0
    var high = arr.size - 1
    while (low <= high) {
        val mid = (low + high) / 2
        if (arr[mid] == target) return mid

        if (target < arr[mid]) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return -1
}

fun binarySearchRecursive(arr: IntArray, target: Int, low: Int, high: Int): Int {
    if (low > high) return -1

    val mid = (low + high) / 2
    return when {
        arr[mid] == target -> mid
        arr[mid] > target -> binarySearchRecursive(arr, target, low, mid - 1)
        else -> binarySearchRecursive(arr, target, mid + 1, high)
    }
}

fun main() {
    val array = intArrayOf(2, 3, 4, 10, 40)
    val result = binarySearchRecursive(array, 10, 0, array.lastIndex)
    println("Binary search recursive $result")
    println("Binary search normal ${binarySearch(array, 10)}")
}
