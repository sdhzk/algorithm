package io.starskyoio.algorithm.datastructure;

/**
 * LinkedList实现
 */
public class MyLinkedList {
    /**
     * 头节点
     */
    private Node head;

    /**
     * 尾节点
     */
    private Node tail;

    /**
     * 链表实际大小
     */
    private int size;

    /**
     * 插入节点
     *
     * @param element
     * @param index
     */
    public void insert(int element, int index) {

    }

    /**
     * 删除节点
     *
     * @param index
     * @return
     */
    public int delete(int index) {
        return 0;
    }

    /**
     * 查询节点
     *
     * @param index
     * @return
     */
    public int get(int index) {
        return 0;
    }

    /**
     * 节点
     */
    private static class Node {
        /**
         * 数据
         */
        int data;

        /**
         * 下一个节点指针
         */
        Node next;
    }
}
