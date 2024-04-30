public class Main {

    // Linear search with iteration count
    public static int linearSearch(int[] array, int target) {
        int iterations = 0;
        for (int i = 0; i < array.length; i++) {
            iterations++;
            if (array[i] == target) {
                System.out.println("Linear Search Iterations: " + iterations);
                return i; // Target found, return index
            }
        }
        System.out.println("Linear Search Iterations: " + iterations);
        return -1; // Target not found
    }

    // Recursive binary search implementation
    public static int recursiveBinarySearch(int[] array, int target, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == target) {
                return mid; // Target found
            } else if (array[mid] < target) {
                return recursiveBinarySearch(array, target, mid + 1, high); // Search right half
            } else {
                return recursiveBinarySearch(array, target, low, mid - 1); // Search left half
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15};

        // Test linear search with iteration count
        int linearSearchResult = linearSearch(sortedArray, 7);
        if (linearSearchResult != -1) {
            System.out.println("Linear Search: Element found at index " + linearSearchResult);
        } else {
            System.out.println("Linear Search: Element not found");
        }

        // Test recursive binary search
        int recursiveBinarySearchResult = recursiveBinarySearch(sortedArray, 9, 0, sortedArray.length - 1);
        if (recursiveBinarySearchResult != -1) {
            System.out.println("Recursive Binary Search: Element found at index " + recursiveBinarySearchResult);
        } else {
            System.out.println("Recursive Binary Search: Element not found");
        }

        // Example of error handling for non-integer input
        try {
            int userInput = Integer.parseInt("abc");
            System.out.println("User Input: " + userInput);
        } catch (NumberFormatException e) {
            System.out.println("Error: Input is not a valid integer.");
        }

        // Example of performance comparison by searching for elements at different positions
        long startTime = System.nanoTime();
        linearSearch(sortedArray, 1); // Search for first element
        long linearSearchTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        recursiveBinarySearch(sortedArray, 15, 0, sortedArray.length - 1); // Search for last element
        long binarySearchTime = System.nanoTime() - startTime;

        System.out.println("Linear Search Time: " + linearSearchTime + " nanoseconds");
        System.out.println("Binary Search Time: " + binarySearchTime + " nanoseconds");
    }
}
