package org.example.hashing

class HashTable(capacity: Int) {
    private val buckets = arrayOfNulls<HashNode>(capacity)
    private var size = 0

    fun getSize() = size
    fun isEmpty() = size == 0

    fun put(key: Int, value: Int) {}

    fun get(key: Int): String? {
        return null
    }

    fun remove(key: Int): String? {
        return null
    }
}

data class HashNode(
    val key: Int,
    val value: String,
    val next: HashNode?
)
