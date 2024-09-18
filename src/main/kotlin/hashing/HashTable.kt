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
        // move the head back to the start in case it traversed above during checking for duplicate keys
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
        val bucketIndex = getBucketIndex(key)
        var head = buckets[bucketIndex]

        // Loop through the bucket and find the key's value
        while (head != null) {
            if (key == head.key) {
                return head.value
            }
            head = head.next
        }
        // Key does not exist
        return null
    }

    fun remove(key: Int): String? {
        val bucketIndex = getBucketIndex(key)
        var head = buckets[bucketIndex] // This will keep track of the removed node
        var previous: HashNode? = null // Since we are removing, we need to track the previous value

        while (head != null) {
            if (key == head.key) break // key found. No need to continue
            previous = head
            head = head.next
        }

        if (head == null) return null
        size --

        if (previous != null) {
            // In this case, the key is not in the first position of the bucket array, so we remove head
            // from the chain. prev.next = [head is broken here] head.next
            previous.next = head.next
        } else {
            // The key is in the first position so we need to remove the first position of the bucket and replace it
            // with head.next thus removing head from the chain
            buckets[bucketIndex] = head.next
        }

        return head.value
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

    println(table.getSize()) // 2
    println(table.get(21)) // New John
    println(table.remove(21)) // New John
    println(table.getSize()) // 1
}
