package org.example

import org.example.tree.BinaryTree
import java.math.BigInteger

fun main() {
    val tree = BinaryTree()
    tree.createBinaryTree()
    tree.preorderTraversal(tree.root)
    println()
    tree.iterativePreorderTraversal(tree.root)
    println()
    tree.inorderTraversal(tree.root)
    println()
    tree.iterativeInorderTraversal(tree.root)
    println()
    tree.postorderTraversal(tree.root)
    println()
    tree.iterativePostorderTraversal(tree.root)
    println()
    tree.levelOrderTraversal(tree.root)
    println()
    println(tree.findMax(tree.root))
}

fun <T, R> List<T>.myFold(initial: R, operation: (acc: R, T) -> R): R {
    var accumulator = initial
    for (element in this) accumulator = operation(accumulator, element)
    return accumulator
}

fun isPalindrome(string: String) = string == string.reversed()

fun isPalindrome1(string: String): Boolean {
    var start = 0
    var end = string.lastIndex

    while (start < end) {
        if (string[start] != string[end]) return false
        start++
        end--
    }
    return true
}

fun loop() {
    val data = intArrayOf(1, 0, 2, 0, 2)
    var lastZeroIdx = data.size - 1
    data.forEachIndexed { index, i ->
        if (i == 0) {
            if (index < data.size - 1) {
                data[index] = data[index + 1]
            }
            data[lastZeroIdx] = 0
            lastZeroIdx = data.lastIndexOf(0)
        }
    }

    println(data.contentToString())
}

private val FIB_CACHE: MutableMap<Int, BigInteger> =
    mutableMapOf()

fun fib(n: Int): BigInteger = FIB_CACHE.getOrPut(n) {
    if (n <= 1) BigInteger.ONE else fib(n - 1) + fib(n - 2)
}
