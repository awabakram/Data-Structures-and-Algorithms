
/**
 * BinarySearch
 */
public class BinarySearch {
    public static int binarySearch(int[] arrayToSearch, int itemToFind)
    {
        int start = 0;
        int end = arrayToSearch.length - 1;
        while (start <= end)
        {
            int mid = (start + end)/2;
            if (arrayToSearch[mid] == itemToFind)
            {
                return mid;
            }
            else if (itemToFind < arrayToSearch[mid])
            {
                end = mid - 1;
            }
            else if (itemToFind > arrayToSearch[mid])
            {
                start = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) 
    {
        int[] array = {10,11,12,23,34,45,66,67,98,99,190};
        int returnVal = binarySearch(array, 99 );
        System.out.println(returnVal);
    }
}