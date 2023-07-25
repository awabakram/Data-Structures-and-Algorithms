

/**
 * QuickSort
 */
public class QuickSort {

    public static int[] quickSort(int[] arrayToSort, int low, int high)
    {
        if(low<high)
        {
            int[][] returnarray = partition(arrayToSort, low, high);
            int j = returnarray[0][0];
            arrayToSort = returnarray[1];
            arrayToSort = quickSort(arrayToSort, low, j);
            arrayToSort = quickSort(arrayToSort, j+1, high);
        }
        return arrayToSort;
        
    }

    public static int[][] partition(int[] arrayToSort, int low, int high)
    {
        int pivotPos = low; //(low+high)/2; 
        int pivot = arrayToSort[pivotPos];

        int i = low;
        int j = high;
        while (i < j)
        {
            // while (arrayToSort[i] <= pivot)
            // {
            //     i++;
            // }
            // while (arrayToSort[j] > pivot)
            // {
            //     j--;
            // }
            do 
            {
                i++;
            } while (arrayToSort[i] <= pivot);

            do 
            {
                j--;
            } while(arrayToSort[j] > pivot);

            if(i<j)
            {
                int temp =  arrayToSort[j];
                arrayToSort[j] = arrayToSort[i];
                arrayToSort[i] = temp;
            }
            
        }
        int temp = arrayToSort[j];
        arrayToSort[j] = arrayToSort[pivotPos];
        arrayToSort[pivotPos] = temp;
        int[][] returnarray = {{j}, arrayToSort};
        return returnarray;
    }
    public static void main(String[] args) 
    {
        int[] arrayToSort = {10,54,23,4,54,76, Integer.MAX_VALUE};
        int[] sortedArray = quickSort(arrayToSort, 0, arrayToSort.length-1);
        for (int i : sortedArray) {
            System.out.print(i + " ");
        }
    }
}