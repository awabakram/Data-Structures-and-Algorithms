

public class MergeSort 
{
    public static int[] mergeSort(int[] arrayToSort)
    {
        if(arrayToSort.length == 1)
        {
            return arrayToSort;
        }
        int array1Len = arrayToSort.length/2;
        int array2Len = arrayToSort.length - array1Len;
        int[] array1 = new int[array1Len];
        int[] array2 = new int[array2Len];

        int index = 0;
        for (int i = 0; i < array1.length; i++) 
        {
            array1[i] = arrayToSort[index];
            index++;
        }
        for (int i = 0; i < array2.length; i++) 
        {
            array2[i] = arrayToSort[index];
            index++;
        }

        if(array1.length > 1)
        {
            array1 = mergeSort(array1);
        }
        if(array2.length > 1)
        {
            array2 = mergeSort(array2);
        }

        return merge(array1, array2);

    }

    public static int[] merge(int[] array1, int[] array2)
    {
        int[] mergedArray = new int[array1.length+array2.length];
        int array1Index = 0;
        int array2Index = 0;

        for (int i = 0; i < mergedArray.length; i++) 
        {
            if(array1Index == array1.length)
            {
                mergedArray[i] = array2[array2Index];
                array2Index++;
                continue;
            }
            if(array2Index == array2.length)
            {
                mergedArray[i] = array1[array1Index];
                array1Index++;
                continue;
            }
            if (array1[array1Index] < array2[array2Index])
            {
                mergedArray[i] = array1[array1Index];
                array1Index++;
            }
            else
            {
                mergedArray[i] = array2[array2Index];
                array2Index++;
            }
            // else if (array1[array1Index] > array2[array2Index])
            // {
            //     mergedArray[i] = array2[array2Index];
            //     array2Index++;
            // }
            // else
            // {
            //     mergedArray[i] = array1[array1Index];
            //     array1Index++;
            //     i++;
            //     mergedArray[i] = array2[array2Index];
            //     array2Index++;
            // }    
        }
        
        return mergedArray;
    }
    public static void main(String[] args) 
    {
        int[] arrayToSort = {10,2,15,5,654,76,1,2,3,3,4,96};
        int[] sortedArray = mergeSort(arrayToSort);
        for (int i : sortedArray) {
            System.out.print(i + " ");
        }
    }
}
