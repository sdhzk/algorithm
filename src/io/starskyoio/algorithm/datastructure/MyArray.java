package io.starskyoio.algorithm.datastructure;

import java.util.Arrays;

public class MyArray {
    private int[] array;
    private int size;

    public MyArray(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
    }

    /**
     * 插入元素
     *
     * @param element
     * @param index
     */
    public void insert(int element, int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("数组越界：" + index);
        }
        // 数组扩容为原来容量的2倍
        if (size == array.length) {
            resize();
        }
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    /**
     * 数组扩容
     */
    private void resize() {
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    /**
     * 删除元素
     *
     * @param index
     * @return
     */
    public int delete(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("数组越界：" + index);
        }
        int deleteElement = array[index];
        array[index] = 0;
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return deleteElement;
    }


    @Override
    public String toString() {
        return "MyArray{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray(4);
        myArray.insert(1, 0);
        myArray.insert(2, 1);
        myArray.insert(3, 2);
        myArray.insert(4, 3);
        System.out.println(myArray);
        myArray.delete(3);
        System.out.println(myArray);
//        int[] arr = {1,3,4};
//        int[] newArr = new int[arr.length * 2];
//        System.arraycopy(arr, 0, newArr, 0, arr.length);
//        System.out.println(arr);
//        System.out.println(newArr);
    }
}
