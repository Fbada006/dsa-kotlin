package org.example.tree

// A Binary Search Tree is a data structure used in computer science for organizing and storing data in a sorted manner.
// Each node in a Binary Search Tree has at most two children, a left child and a right child, with the left child
// containing values less than the parent node and the right child containing values greater than the parent node.
// This hierarchical structure allows for efficient searching, insertion, and deletion operations on the data stored
// in the tree.
class BinarySearchTree {

    var root: TreeNode? = null

    fun insert(value: Int) {
        this.root = insert(root, value)
    }

    fun insert(root: TreeNode?, value: Int): TreeNode {
        var rootNode = root
        if (rootNode == null) {
            rootNode = TreeNode(value)
            return rootNode
        }

        if (value < rootNode.data) {
            rootNode.left = insert(root?.left, value)
        } else {
            rootNode.right = insert(root?.right, value)
        }

        return rootNode
    }

    fun inOrderTraversal() {
        inOrderTraversal(root)
    }

    fun inOrderTraversal(root: TreeNode?) {
        if (root == null) return
        inOrderTraversal(root.left)
        print("${root.data} ")
        inOrderTraversal(root.right)
    }

    fun search(key: Int): TreeNode? {
        return search(root, key)
    }

    fun search(root: TreeNode?, key: Int): TreeNode? {
        if (root == null || root.data == key) {
            return root
        }

        return if (key < root.data) {
            search(root.left, key)
        } else {
            search(root.right, key)
        }
    }
}

fun main() {
    val bst = BinarySearchTree()
    bst.insert(5)
    bst.insert(3)
    bst.insert(7)
    bst.insert(1)
    bst.inOrderTraversal()
    println()
    println(bst.search(23))
}
