package io.starskyoio.algorithm.datastructure;

/**
 * 栈（数组实现）
 */
public class MyStack {

    private int[] array;

    private int size;

    public MyStack(int capacity) {
        array = new int[capacity];
    }

    public void push(int element) {
        if(size == array.length){
            resize();
        }
        array[size] = element;
        size++;
    }

    public void resize() {
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public int pop() {
        if(size == 0){
            throw new ArrayIndexOutOfBoundsException("栈元素为空");
        }

        int top = array[size - 1];
        array[size - 1] = 0;
        size--;
        return top;
    }

    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(3);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.print();
        myStack.pop();
        myStack.print();
        myStack.pop();
        myStack.print();
        myStack.pop();
        myStack.print();
        myStack.pop();
        myStack.print();
    }

}
