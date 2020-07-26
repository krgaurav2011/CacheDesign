package com.gaurav.cache.DataStructure

import org.junit.jupiter.api.Test
import org.junit.platform.runner.JUnitPlatform
import org.junit.platform.suite.api.SelectPackages
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
@SelectPackages("com.gaurav.cache.DataStructure")
class DoublyLinkedListTest {

    private var dll: DoublyLinkedList<Int> = DoublyLinkedList()

    private fun verifyDLL(doublyLinkedList: DoublyLinkedList<Int>, list: List<Int>) {
        val res = mutableListOf<Int>()
        var head = doublyLinkedList.getHead()
        while (head != null) {

            res += head.element
            head = head.next
        }
        print(res)
        print(list)
        assertEquals(res, list)
    }

    @Test
    fun testNodeAttachment() {
        val node1 = DoublyLinkedListNode(1)
        val node2 = DoublyLinkedListNode(2)
        val node3 = DoublyLinkedListNode(3)
        val node4 = DoublyLinkedListNode(4)
        dll.addToFront(node1)
        verifyDLL(dll, listOf(1))
        dll.addToFront(node2)
        verifyDLL(dll, listOf(1, 2).reversed())
        dll.addToFront(node3)
        verifyDLL(dll, listOf(1, 2, 3).reversed())
        dll.addToFront(node4)
        verifyDLL(dll, listOf(1, 2, 3, 4).reversed())

        dll.detachNode(node2)
        verifyDLL(dll, listOf(1, 3, 4).reversed())
        dll.detachNode(node1)
        verifyDLL(dll, listOf( 3, 4).reversed())
        dll.detachNode(node4)
        verifyDLL(dll, listOf( 3).reversed())
        dll.detachNode(node3)
        verifyDLL(dll, listOf<Int>().reversed())
        dll.detachNode(null)
        verifyDLL(dll, listOf<Int>().reversed())

    }

    @Test
    fun testNodeDetachment() {
        val dll = DoublyLinkedList<Int>()
        val node1 = dll.addElementToFront(1)
        val node2 =dll.addElementToFront(2)
        val node3 =dll.addElementToFront(3)
        val node4 =dll.addElementToFront(4)
        val node5 =dll.addElementToFront(5)
        verifyDLL(dll, listOf(5,4,3,2,1))


        dll.detachNode(node2)
        verifyDLL(dll, listOf(1, 3, 4, 5).reversed())
        dll.detachNode(node1)
        verifyDLL(dll, listOf( 3, 4, 5).reversed())
        dll.detachNode(node4)
        verifyDLL(dll, listOf( 3, 5).reversed())
        dll.detachNode(node3)
        verifyDLL(dll, listOf<Int>(5).reversed())
        dll.detachNode(node5)
        verifyDLL(dll, listOf<Int>().reversed())
        dll.detachNode(null)
        verifyDLL(dll, listOf<Int>().reversed())
    }

}