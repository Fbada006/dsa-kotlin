package org.example.hashing

// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
// Input: nums = [1,2,3,1] - true because 1 appears twice. Input: nums [1,2,3,4] - false because all are unique
fun containsDuplicatesKotlin(nums: IntArray): Boolean {
    if (nums.size < 2) return false

    return nums.groupBy { num -> num }.any {
        it.value.size > 1
    }
}

fun main() {
    println(containsDuplicatesKotlin(intArrayOf(1,2,3,1))) // true
    println(containsDuplicatesKotlin(intArrayOf(1,2,3,4))) // false
    println(containsDuplicatesKotlin(intArrayOf(-1,2,3,-1))) // true
    println(containsDuplicatesKotlin(intArrayOf(1,2,3,-1))) // false
}
