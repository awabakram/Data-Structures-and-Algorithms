

public class LinearSearch {
    //Returns the index of the item, if not found then returns -1
    public static int linearSearch(int[] array, int itemToFind)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == itemToFind)
            {
                return i;
            }
        }

        return -1;
    }
    public static void main(String[] args) 
    {
        int[] arrayToSearch = {0,34,523,453,1,2,3,4,67,9,-54};
        System.out.println(linearSearch(arrayToSearch, 2));
        System.out.println(linearSearch(arrayToSearch, -54));
    }
}
