package org.example.sort

// Given a sorted array of positive integers, rearrange the array alternately i.e first element should be a maximum
// value, at second position minimum value, at third position second max, at fourth position second min, and so on.
// Example:
//Input: arr[] = {1, 2, 3, 4, 5, 6, 7}
//Output: arr[] = {7, 1, 6, 2, 5, 3, 4}
//Explanation: First 7 is the max value, then 1 is the min value, then 6 is the second max value, then 2 is the second
// min value, then 5 is the third max value, then 3 is the third min value and at last 4 is the fourth max value.
fun rearrange(arr: LongArray, n: Int): LongArray {
    val result = LongArray(n)

    // Indexes of smallest and largest elements
    // from remaining array.
    var small = 0
    var large = n - 1

    // Alternates between high and low.
    // If true, we get the large into the current pos
    // else get the small into the current pos
    var shouldAlternate = true

    // Store result in temp[]
    for (i in 0 until n) {
        if (shouldAlternate) {
            result[i] = arr[large--]
        } else {
            result[i] = arr[small++]
        }
        shouldAlternate = !shouldAlternate
    }

    return result
}

fun main() {
    val arr = longArrayOf(1, 2, 3, 4, 5, 6, 7)
    println(rearrange(arr, arr.size).contentToString())
}
