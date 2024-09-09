package org.example.tree

// Determine whether a given binary tree is a valid binary search tree or not given the following rules
// 1. The left subtree of a node has nodes with values less than the node
// 2. The right subtree of a node has nodes with values greater than the node
// 3. Both the left and right subtrees must also be binary search trees
fun isValidBST(root: TreeNode?, min: Long, max: Long): Boolean {
    if (root == null) return true
    if (root.data !in  min..max) return false

    // As we go to the left side of the tree, only the upper bound (max) changes to the parent value
    // This is because the children on the left should not be greater than the parent's value
    val isLeftValid = isValidBST(root.left, min, root.data.toLong())

    if (isLeftValid) {
        // As we go on the right side, only the lower bound (min) changes to the parent value
        // This is because the children on the right should be greater than the parent's value
        val isRightValid = isValidBST(root.right, root.data.toLong(), max)
        return isRightValid
    }

    return false
}

fun main() {
    val bst = BinarySearchTree()
    bst.insert(5)
    bst.insert(3)
    bst.insert(7)
    bst.insert(4)
    println(isValidBST(bst.root, Long.MIN_VALUE, Long.MAX_VALUE))
}

