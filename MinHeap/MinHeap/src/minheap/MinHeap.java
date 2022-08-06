/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minheap;

import java.awt.ItemSelectable;
import java.util.Arrays;

/**
 *
 * @author Student
 */
public class MinHeap {

    public static void main(String[] args) {

    }

    public class Min_Heap {

        private int capacity = 10;
        private int size = 0;

        private int[] arr = new int[capacity];

        private int getLeft(int index) {
            return arr[2 * index + 1];
        }

        private int getRight(int index) {
            return arr[2 * index + 2];
        }

        private int getParent(int index) {
            return arr[(index - 1) / 2];
        }

        private boolean hasLeft(int index) {
            return (2 * index + 1) < size;
        }

        private boolean hasRight(int index) {
            return (2 * index + 2) < size;
        }

        private boolean hasParent(int index) {
            return ((index - 1) / 2) < size;
        }

        private void swap(int i, int j) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }

        private void ensureExtraCapacity() {
            if (size == capacity) {
                arr = Arrays.copyOf(arr, capacity * 2);
                capacity *= 2;
            }
        }

        public int peek() {
            if (size == 0) {
                throw new IllegalStateException();
            }
            return arr[0];
        }

        public int poll() {
            if (size == 0) {
                throw new IllegalStateException();
            }
            int item = arr[0];
            arr[0] = arr[size - 1];
            size--;
            heapifyDown();
            return item;
        }

        public void add(int item) {
            ensureExtraCapacity();
            arr[size] = item;
            size++;
            heapifyUp();
        }

        public void heapifyDown() {
            int index = 0;
            while (hasLeft(index)) {
                int smallerChildIndex = 2 * index + 1;
                if (hasRight(index) && getRight(index) < getLeft(index)) {
                    smallerChildIndex = 2 * index + 2;
                }

                if (arr[index] < arr[smallerChildIndex]) {
                    break;
                } else {
                    swap(index, smallerChildIndex);

                }
                index = smallerChildIndex;
            }
        }

        public void heapifyUp() {
            int index = size - 1;
            while (hasParent(index) && getParent(index) > arr[index]) {
                swap((index - 1) / 2, index);
                index = (index - 1) / 2;
            }
        }

    }

}
