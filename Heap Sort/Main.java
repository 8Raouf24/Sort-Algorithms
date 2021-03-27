// Java program for implementation of Heap Sort

import java.util.Random;

public class Main {
    public static  void heapSort(long arr[])
    {
        int n = arr.length;
 
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
 
        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            long temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
 
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
     static void heapify(long arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i) {
            long swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
 
    /* A utility function to print array of size n */
    static void printArray(long arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    static void sortedArray(long arr[])
    {
        

    }

    public static void main(String[] args) {
        double[] lengths = {
            5*Math.pow(10, 4),
            Math.pow(10, 5),
            2*Math.pow(10, 5),
            4*Math.pow(10, 5),
            8*Math.pow(10, 5),
            3.2*Math.pow(10, 6),
            6.4*Math.pow(10, 6),
            12.8*Math.pow(10, 6),
            25.6*Math.pow(10, 6),
            51.2*Math.pow(10, 6),
            102.4*Math.pow(10, 6),
            204.8*Math.pow(10, 6)
        };
        // Random random = new Random();
        // long[] numbers = random.longs((long) Math.pow(10, 1)).toArray();

        for(int i = 2; i < lengths.length; i++){
            long l = (long) lengths[i];
            Random random = new Random();
            long[] numbers = random.longs(l).toArray();
            double startTime = System.nanoTime();
            heapSort(numbers);
            double elapsedTime = System.nanoTime() - startTime;
            
            System.out.println("algo1 for n=" + l + ": " + elapsedTime/1000000000);
        }
    }
}