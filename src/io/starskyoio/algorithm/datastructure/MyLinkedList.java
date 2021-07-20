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
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("超出链表范围：" + index);
        }
        Node insertNode = new Node(element);
        if (size == 0) {
            //链表为空
            head = insertNode;
            tail = insertNode;
        } else if (index == 0) {
            //链表头插入
            insertNode.next = head;
            head = insertNode;
        } else if (size == index) {
            //链表尾插入
            tail.next = insertNode;
            tail = insertNode;
        } else {
            //中间插入
            Node prevNode = get(index - 1);
            insertNode.next = prevNode.next;
            prevNode.next = insertNode;
        }
        size++;
    }

    /**
     * 删除节点
     *
     * @param index
     * @return
     */
    public Node delete(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("超出链表范围：" + index);
        }
        Node removedNode;
        if (index == 0) {
            removedNode = head;
            head = head.next;
        } else if (index == size - 1) {
            removedNode = tail;
            Node prevNode = get(index - 1);
            tail = prevNode;
            tail.next = null;
        } else {
            Node prevNode = get(index - 1);
            removedNode = prevNode.next;
            prevNode.next = removedNode.next;
        }
        size--;
        return removedNode;
    }

    /**
     * 查询节点
     *
     * @param index
     * @return
     */
    public Node get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("超出链表范围：" + index);
        }
        Node findNode = head;
        if(index == 0){
            return findNode;
        }
        int i = 1;
        while ((findNode = findNode.next) != null) {
            if (i == index) {
                break;
            }
            i++;
        }
        return findNode;
    }

    public void print() {
        Node node = head;
        System.out.print(node.data);
        while((node = node.next) != null){
            System.out.print(","+node.data);
        }
        System.out.println();
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

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.insert(1, 0);
        list.insert(4, 0);
        list.insert(5, 0);
        list.insert(8, 0);
        list.print();
        list.insert(2, 1);
        list.print();
        list.insert(8, 1);
        list.print();
        list.delete(0);
        list.print();
        list.delete(4);
        list.print();
        list.delete(2);
        list.print();
    }
}
