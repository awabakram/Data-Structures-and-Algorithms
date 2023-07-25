package Heaps;

public class Main 
{
    public static void main(String[] args) 
    {
        int[] array = {1,32,45,65,3,4,5};
        // Heap myHeap = new Heap(10,array);
        // myHeap.printHeap();
        // int deletedNum = myHeap.delete();
        // System.out.println("Deleted num: " + deletedNum);
        // myHeap.printHeap();

        int[] sortedArray = Heap.heapSort(array);
        for (int i : sortedArray) {
            System.out.print(i + " ");
        }
        
    }
}
