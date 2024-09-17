package org.example.hashing

class HashTable(capacity: Int) {
    private val buckets = arrayOfNulls<HashNode>(capacity)
    private var size = 0

    fun getSize() = size
    fun isEmpty() = size == 0

    fun put(key: Int?, value: String?) {
        require(value != null) { "Value cannot be null" }
        require(key != null) { "Key cannot be null" }

        val bucketIndex = getBucketIndex(key)
        var head = buckets[bucketIndex]

        // First traverse the list to check if there are any duplicate keys. If any, simply replace the value of the key
        // and return. A map cannot have more than one similar key
        while (head != null) {
            if (key == head.key) {
                head.value = value
                return
            }
            head = head.next
        }

        size++
        // move the head back to the start
        head = buckets[bucketIndex]
        val newNode = HashNode(key, value)
        // Join the nodes by inserting the new node before the current head
        newNode.next = head
        // the new node comes to the very first item of the bucket
        buckets[bucketIndex] = newNode
    }

    // We use modular (%) hashing
    private fun getBucketIndex(key: Int): Int {
        return key % buckets.size
    }

    fun get(key: Int): String? {
        return null
    }

    fun remove(key: Int): String? {
        return null
    }
}

data class HashNode(
    val key: Int,
    var value: String,
    var next: HashNode? = null
)


fun main() {
    val table = HashTable(10)
    table.put(105, "Tom")
    table.put(21, "John")
    table.put(21, "New John")

    println(table.getSize()) // Is 2
}
