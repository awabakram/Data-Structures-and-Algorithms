/**
 * BubbleSort
 */
public class BubbleSort 
{
    public static int[] bubbleSort(int[] array)
    {
        boolean sorted = false;

        while(!sorted)
        {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) 
            {
                if (array[i] > array[i+1])
                {
                    sorted = false;
                    int temp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = temp;
                }
                
            }
        }

        return array;
    }
    public static void main(String[] args) 
    {
        int[] arrayToSort = {5,67,32,4,1,0,1,2,3};
        int[] sortedArray = bubbleSort(arrayToSort);
        for (int integer : sortedArray) {
            System.out.print(integer + " ");
        }
        
    }
}