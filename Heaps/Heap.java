package Heaps;

import java.util.Arrays;

public class Heap 
{
    int[] heap;
    int numOfItemsInHeap;
    public Heap(int maxHeapSize, int[] numbersToInsert)
    {
        //create heap
        heap = new int[maxHeapSize];
        numOfItemsInHeap = 0;
        for (int i : numbersToInsert) {
            insert(i);
            
        }
    }

    public Heap(int[] numbersToHeapify)
    {
        //heapify an array
        for (int i = numbersToHeapify.length-1; i >= 0 ; i--) 
        {
            
        }
    }

    public void insert(int numToInsert)
    {
        //if the heap is full, increase the size of the array
        if (numOfItemsInHeap >= heap.length)
        {
            increaseMaxHeapSize(1);
        }

        //insert the item into the end of the heap
        int numIndex = numOfItemsInHeap;
        heap[numIndex] = numToInsert;
        numOfItemsInHeap++;

        //move the item upwards towards the root as necessary
        int parentIndex = (numIndex-1)/2;
        int parent = heap[parentIndex];

        while (parent < numToInsert)
        {
            heap[parentIndex] = numToInsert;
            heap[numIndex] = parent;
            numIndex = parentIndex;
            parentIndex = (numIndex-1)/2;
            parent = heap[parentIndex];
        }
    }

    public int delete()
    {
        if(numOfItemsInHeap == 0)
        {
            return -1;
        }
        else if (numOfItemsInHeap == 1)
        {
            int numToReturn = heap[0];
            //heap[0] = 0;
            numOfItemsInHeap--;
            return numToReturn;
        }
        int numToReturn = heap[0];
        heap[0] = heap[numOfItemsInHeap - 1];
        heap[numOfItemsInHeap - 1] = numToReturn;
        //heap[numOfItemsInHeap - 1] = 0;
        numOfItemsInHeap--;

        int numIndex = 0;
        int childIndex1 = 2*numIndex + 1;
        int childIndex2 = 2*numIndex + 2;

        while(childIndex1 < numOfItemsInHeap && childIndex2 < numOfItemsInHeap)
        {
            
            int largerChild;
            int largerChildIndex;
            if (heap[childIndex1] > heap[childIndex2])
            {
                largerChild = heap[childIndex1];
                largerChildIndex = childIndex1;
            }
            else
            {
                largerChild = heap[childIndex2];
                largerChildIndex = childIndex2;
            }
            
            if (largerChild > heap[numIndex])
            {
                heap[largerChildIndex] = heap[numIndex];
                heap[numIndex] = largerChild;
                numIndex = largerChildIndex;
            }
            else
            {
                break;
            }
            childIndex1 = 2*numIndex + 1;
            childIndex2 = 2*numIndex + 2;
        }
        if (childIndex1 < numOfItemsInHeap)
        {
            int largerChild = heap[childIndex1];
            int largerChildIndex = childIndex1;
            if (largerChild > heap[numIndex])
            {
                heap[largerChildIndex] = heap[numIndex];
                heap[numIndex] = largerChild;
                numIndex = largerChildIndex;
            }
        }

        return numToReturn;
    }

    public void increaseMaxHeapSize(int incrementValue)
    {
        heap = Arrays.copyOf(heap, heap.length + incrementValue);
    }

    public static int[] heapSort(int[] arrayToSort)
    {
        Heap newHeap = new Heap(arrayToSort.length,arrayToSort);
        int[] sortedArray = new int[arrayToSort.length];
        for (int i = 0; i < arrayToSort.length; i++) {
            sortedArray[i] = newHeap.delete();
        }
        return newHeap.getHeap();
        //return sortedArray;
    }

    public int[] getHeap() {
        return heap;
    }

    public void printHeap()
    {
        // for (int i : heap) {
        //     System.out.print(i + " ");
        // }
        for (int i = 0; i < numOfItemsInHeap; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
        System.out.println("Rest of array:");
        for (int i = numOfItemsInHeap; i < heap.length; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }


}
