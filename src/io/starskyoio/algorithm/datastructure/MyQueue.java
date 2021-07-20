package io.starskyoio.algorithm.datastructure;

/**
 * 循环队列（数组实现)
 */
public class MyQueue {
    private int[] array;
    private int front;
    private int rear;

    public MyQueue(int capacity) {
        array = new int[capacity];
    }

    public void enQueue(int element) {
        if ((rear + 1) % array.length == front) {
            throw new RuntimeException("队列已满");
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    public int deQueue() {
        if (rear == front) {
            throw new RuntimeException("队列已空");
        }
        int frontElement = array[front];
        front = (front + 1) % array.length;
        return frontElement;
    }

    public void print() {
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(10);
        myQueue.enQueue(1);
        myQueue.print();
        myQueue.enQueue(2);
        myQueue.print();
        myQueue.enQueue(3);
        myQueue.print();
        myQueue.deQueue();
        myQueue.print();
        myQueue.deQueue();
        myQueue.print();
        myQueue.deQueue();
        myQueue.print();
    }
}
