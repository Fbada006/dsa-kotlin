package org.example.sort

fun sort(arr: IntArray, temp: IntArray, low: Int, high: Int): IntArray {
    if (low < high) { // base case
        val mid = low + (high - low) / 2 // overflow condition (low + high) / 2;
        sort(arr, temp, low, mid)
        sort(arr, temp, mid + 1, high)
        merge(arr, temp, low, mid, high)
    }
    return arr
}

private fun merge(arr: IntArray, temp: IntArray, low: Int, mid: Int, high: Int) {
    for (i in low..high) {
        temp[i] = arr[i]
    }
    var i = low // traverse left sorted subarray
    var j = mid + 1 // traverse right sorted subarray
    var k = low // will merge both arrays into original array (arr)

    while (i <= mid && j <= high) {
        if (temp[i] <= temp[j]) {
            arr[k] = temp[i]
            i++
        } else {
            arr[k] = temp[j]
            j++
        }
        k++
    }

    while (i <= mid) {
        arr[k] = temp[i]
        k++
        i++
    }
}

fun main() {
    val arr = intArrayOf(5, 2, 9, 5, 2, 7, 5, 3, 0)
    val temp = IntArray(arr.size)
    println(sort(arr, temp, 0, arr.size - 1).contentToString())
}
