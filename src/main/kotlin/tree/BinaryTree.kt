package org.example.tree

import org.example.queue.Queue
import java.util.*


class BinaryTree {
    var root: TreeNode? = null

    // Preorder traversal is a tree traversal algorithm that visits the nodes of a tree data structure in a specific order:
    // Root node: Visit the root node first
    // Left subtree: Recursively traverse the left subtree
    // Right subtree: Recursively traverse the right subtree
    // Difference with in order is where you interact with the root node
    fun preorderTraversal(root: TreeNode?) {
        if (root == null) return
        print("${root.data} ")
        preorderTraversal(root.left)
        preorderTraversal(root.right)
    }

    fun iterativePreorderTraversal(root: TreeNode?) {
        if (root == null) return
        val stack = Stack<TreeNode>()
        stack.push(root)
        while (stack.isNotEmpty()) {
            val node = stack.pop()
            print("${node.data} ")

            if (node.right != null) stack.push(node.right)
            if (node.left != null) stack.push(node.left)
        }
    }

    // Inorder traversal: traverse from the left subtree, then to the root, then to the right subtree.
    fun inorderTraversal(root: TreeNode?) {
        if (root == null) return
        inorderTraversal(root.left)
        print("${root.data} ")
        inorderTraversal(root.right)
    }

    fun iterativeInorderTraversal(root: TreeNode?) {
        if (root == null) return
        val stack = Stack<TreeNode>()
        var temp = root
        while (stack.isNotEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp)
                temp = temp.left
            } else {
                temp = stack.pop()
                print("${temp.data} ")
                temp = temp.right
            }
        }
    }

    // Postorder traversal is a depth-first search (DFS) algorithm that visits nodes in a binary search tree in a specific order:
    // Traverse the left subtree
    // Traverse the right subtree
    // Visit the root node
    fun postorderTraversal(root: TreeNode?) {
        if (root == null) return
        postorderTraversal(root.left)
        postorderTraversal(root.right)
        print("${root.data} ")
    }

    fun iterativePostorderTraversal(root: TreeNode?) {
        if (root == null) return

        val stack = Stack<TreeNode>()
        var current = root
        while (stack.isNotEmpty() || current != null) {
            if (current != null) {
                stack.push(current)
                current = current.left
            } else {
                var temp = stack.peek().right
                if (temp == null) {
                    temp = stack.pop()
                    print("${temp.data} ")
                    // At this point, we have processed this node's left, and we need to process the right node of the parent
                    while (stack.isNotEmpty() && temp == stack.peek().right) {
                        temp = stack.pop()
                        print("${temp.data} ")
                    }
                } else {
                    current = temp
                }
            }
        }
    }

    // Go level by level of the tree and print the left and right
    fun levelOrderTraversal(root: TreeNode?) {
        if (root == null) return
        val queue: java.util.Queue<TreeNode> = LinkedList()
        queue.offer(root)
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            print("${node.data} ")
            if (node.left != null) queue.offer(node.left)
            if (node.right != null) queue.offer(node.right)
        }
    }

    fun findMax(root: TreeNode?): Int {
        if (root == null) return Integer.MIN_VALUE
        var result = root.data

        val left = findMax(root.left)
        val right = findMax(root.right)

        if (left > result) {
            result = left
        }
        if (right > result) {
            result = right
        }
        return result
    }

    fun createBinaryTree() {
        val first = TreeNode(9)
        val second = TreeNode(2)
        val third = TreeNode(3)
        val fourth = TreeNode(4)
        val fifth = TreeNode(3)

        root = first
        first.left = second
        first.right = third
        second.left = fourth
        second.right = fifth
    }
}

data class TreeNode(
    val data: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null
)
