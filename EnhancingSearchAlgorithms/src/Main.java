import java.util.Arrays;
public class Main
{
    public static void main(String[] args)
    {
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 11;
        // task 1: add iteration count to linear search
        int linearIterations = linearSearch(array, target);
        if (linearIterations >= 0)
        {
            System.out.println("Linear Search: Element found at index " + linearIterations
                    + " with " + (linearIterations + 1) + " iterations.");
        } else
        {
            System.out.println("Linear Search: Element not found with " + (Math.abs(linearIterations) - 1) + " iterations.");
        }
        //task 2: implement a recursive version of binary search
        //binary search requires a sorted array
        Arrays.sort(array);
        int binaryIterations = recursiveBinarySearch(array, target, 0, array.length - 1);
        if (binaryIterations >= 0)
        {
            System.out.println("Recursive Binary Search: Element found at index " + binaryIterations
                    + " with " + (binaryIterations + 1) + " iterations.");
        } else {
            System.out.println("Recursive Binary Search: Element not found with " + (Math.abs(binaryIterations) - 1) + " iterations.");
        }
        //task 3: error handling
        try
        {
            //simulating non-integer input
            int nonIntegerTarget = Integer.parseInt("abc");
            linearSearch(array, nonIntegerTarget);
        } catch (NumberFormatException e)
        {
            System.out.println("Error: Input must be an integer.");
        }
        //task 4: performance comparison
        int[] positionsToSearch = {array[0], array[array.length / 2], array[array.length - 1]};
        for (int position : positionsToSearch)
        {
            long startTimeLinear = System.nanoTime();
            linearSearch(array, position);
            long endTimeLinear = System.nanoTime();
            long linearTime = endTimeLinear - startTimeLinear;

            long startTimeBinary = System.nanoTime();
            recursiveBinarySearch(array, position, 0, array.length - 1);
            long endTimeBinary = System.nanoTime();
            long binaryTime = endTimeBinary - startTimeBinary;

            System.out.println("Search Time for element " + position + ": Linear - " + linearTime + " ns, Binary - " + binaryTime + " ns");
        }
    }
    //linear search algorithm with iteration count
    private static int linearSearch(int[] array, int target)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == target)
            {
                //element found, return index
                return i;
            }
        }
        //element not found, return negative index
        return -array.length - 1;
    }
    //recursive binary search algorithm
    private static int recursiveBinarySearch(int[] array, int target, int left, int right) {
        if (left <= right)
        {
            int mid = left + (right - left) / 2;
            if (array[mid] == target)
            {
                //element found, return index
                return mid;
            } else if (array[mid] < target)
            {
                //search right half
                return recursiveBinarySearch(array, target, mid + 1, right);
            } else
            {
                //search left half
                return recursiveBinarySearch(array, target, left, mid - 1);
            }
        }
        //element not found, return negative index
        return -left - 1;
    }
}
