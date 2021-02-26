package ClassNotes.Feb18_SearchAndSort_Feb25;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {6,5,3,1,8,7,2,4};
        int[] arr2 = {5,1,3,2,2,2,1,2,7,7,7,9,11,1,3,4,4,4,2,6};
        int[] arr3 = {1,2,0,0,2,2,1,1,0,0,1,2,0,1};
        int[] arr4 = {1,5,5,3,2,5,5,5,0,5};
        int[] arr5 = {7,3,-2,8,5,6};
        int[] arr6 = {-1,-1,0,1,1,1,2,2,2,3,3,3,6,6,7,7,7,7,8,9,9};
//        bubbleSort(arr);
//        selectionSort(arr);
//        mergeSort(arr);
//        quickSort(arr);
//        findNthLargest(arr5, 2);
//        System.out.println(findNthSmallest(arr5,2));
//        countSort(arr2, 12);
//        dutchFlag(arr3, 1);
//        printArray(arr3);
//        System.out.println(majorityElement(arr4));
//        sortArrayWaveForm(arr5);
//        System.out.println(getFirstIndex(arr2, 1));
    }

    private static void printArray(int[] arr){
        if(arr == null){
            return;
        }

        for(int i: arr){
            System.out.printf(i + ", ");
        }
        System.out.println();
    }

    private static void swap(int[] arr, int i, int j) {
        if(arr == null || arr.length < 2 || i < 0 || j < 0 || i >= arr.length || j >= arr.length){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //complexity = O(n^2), space complexity O(1)
    public static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length; i ++){

            for(int j = 0; j < arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length; i ++){
            int minIndex = i;
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
                if(minIndex != i ){
                    swap(arr, minIndex, i);
                }
            }
        }
    }

    public static void mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length-1);
    }

    //wrapper function

    //complexity O(nLog2n) better than O(n^2)
    private static void mergeSort(int[] arr, int low, int high){

        if(low >= high){
            return;
        }
        //recursive
        //complexity Log2(n)
        int mid = (low + high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid +1, high);
        merge(arr, low, high);

    }
    //complexity
    //Space O(n) //
    private static void merge(int[] arr, int low, int high){

        int mid = (low + high)/2;
        int[] temp = new int[high-low+1];
        int i = low;
        int j = mid +1;
        int index = 0;

        //at this point O(n/2)
        while (i <= mid && j <= high){
            if(arr[i] < arr[j]){
                temp[index] = arr[i];
                i ++;
            } else {
                temp[index] = arr[j];
                j ++;
            }
            index ++;
        }

        //O(n/2)
        //copy the remaining
        while (i <= mid){
            temp[index++] = arr[i ++];
        }
        while (j <= high){
            temp[index++] = arr[j ++];
        }


        //at this point temp has the sorted array
        //copy temp into original array
        //O(n)
        i = low;
        for (int k = 0; k < temp.length; k++) {
            arr[i] = temp[k];
            i ++;
        }

    }

    public static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }


    private static void quickSort(int[] arr, int low, int high){
        //individual level
        if(low < high){
            int position = partition(arr, low, high);
            quickSort(arr, low, position-1);
            quickSort(arr, position+1, high);
        }
    }

    //O(n)
    private static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int wall = low-1;

        for (int i = low; i < high; i++) {
            if(arr[i] < pivot){
                wall++;
                swap(arr, i, wall);
            }
        }
        //we will put the pivot value at the wall position
        wall++;
        swap(arr, high, wall);
        return wall;

    }

    public static void findNthLargest(int[] arr, int n){
        if(arr == null || arr.length ==  0 || n < 0 || n >= arr.length){
            return;
        }
        findNthLargest(arr, n, 0, arr.length-1);

    }

    public static void findNthLargest(int[] arr, int n, int low, int high){
        if(low < high){
            int position = partition(arr, low, high);
            if(position == arr.length-n){
                System.out.println(arr[position]);
                return;
            }
            findNthLargest(arr, n, low, position-1);
            findNthLargest(arr, n,position+1, high);
        }
    }

    public static int findNthSmallest(int[] arr, int n){
        Arrays.sort(arr);
        return arr[n - 1];
    }



    public static void countSort(int[] arr, int RANGE){
        int[] count = new int[RANGE];

        //increment values in count array for that particular index
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]] ++;
        }

        int index = 0;

        //Overwrite on the original Array number of times
        //an element occurred.
        for (int i = 0; i < RANGE; i++) {
            while (count[i] > 0){
                arr[index] = i;
                index ++;
                count[i] --;
            }

        }
    }

    public static void dutchFlag(int[] arr, int pivot){
        int low = 0;
        int mid = 0;
        int high = arr.length -1;

        while (mid <= high){

            if(arr[mid] < pivot){
                swap(arr, mid ++, low ++);
            }else if (arr[mid] == pivot){
                mid ++;
            } else{
                swap(arr, mid, high--);
            }

        }
    }

    public static int majorityElement(int[] arr){

        int candidate = findCandidate(arr);

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == candidate){
                count ++;
            }
        }

        if(count > arr.length/2){
            return candidate;
        }

        return Integer.MIN_VALUE;
    }

    private static int findCandidate(int[] arr){
        int majorityCandidate = arr[0];
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == majorityCandidate){
                count ++;
            } else {
                count --;
                if(count == 0){
                    count = 1;
                    majorityCandidate = arr[i];
                }
            }
        }
        return majorityCandidate;
    }

    //complexity = nLon(n)
    private static void sortArrayWaveForm(int[] arr){
        if(arr == null || arr.length <=1 ){
            return;
        }
        //sort the array
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i = i + 2) {
            swap(arr, i, i + 1);
        }
        printArray(arr);
    }

    //complexity O(n)
    private static void sortArrayWaveFormOn(int[] arr){
        for (int i = 0; i < arr.length; i = i + 2) {

            if(i > 0 && arr[i - 1] > arr[i]){
                swap(arr, i-1, i);
            }

            if(i < arr.length -1 && arr[i] < arr[i + 1] ){
                swap(arr, i, i + 1);
            }
        }
        printArray(arr);
    }

    //binary search
    //O(log(n))
    private static boolean binSearch(int[] arr, int x){
        if(arr == null){
            return false;
        }

        int low = 0;
        int high = arr.length -1;

        while (low <= high){
            int mid = (low + high)/2;
            if(arr[mid] > x){
                high = mid - 1;
            }else if (arr[mid] < x){
                low = mid + 1;
            }else{
                return true;
            }
        }
        return false;

    }

    //recursive
    public static boolean binSearchRecursive(int[] arr, int x){
        if(arr == null){
            return false;
        }
        return binSearchRecursive(arr, x, 0, arr.length-1);
    }

    //wrapper function
    private static boolean binSearchRecursive(int[] arr, int x, int low, int high){
        if(low > high){
            return false;
        }
        int mid = (low + high)/2;

        if(arr[mid] < x){
            return binSearchRecursive(arr, x, mid + 1, high);
        }else if(arr[mid] > x){
            return binSearchRecursive(arr, x, low, mid - 1);
        }
        return true;
    }

    public static int getNumberOfOccurances(int[] arr, int x){
        return getNumberOfOccurances(arr, x, 0, arr.length -1 );
    }

    private static int getNumberOfOccurances(int[] arr, int x, int low, int high){
        if(low > high){
            return 0;
        }
        if(arr[high] < x){
            return 0;
        }
        if(arr[low] > x){
            return 0;
        }

        if(arr[low] == x && arr[high] == x){
            return high - low + 1;
        }

        int mid = (low + high)/2;

        if(arr[mid] < x){
            return getNumberOfOccurances(arr, x, mid + 1, high);
        }else if(arr[mid] > x){
            return getNumberOfOccurances(arr, x, low, mid -1);
        }else{
            return 1 + getNumberOfOccurances(arr, x, low, mid - 1) +
                    getNumberOfOccurances(arr, x, mid + 1, high);
        }

    }

    public static int getFirstIndex(int[] arr, int x){
        return getFirstIndex(arr, x, 0 , arr.length - 1);
    }

    private static int getFirstIndex(int[] arr, int x, int low, int high){
        if(low > high || arr[low] > x || arr[high] < x){
            return -1;
        }
        if(arr[low] == x){
            return low;
        }

        int mid = (low + high)/2;

        if(arr[mid] < x){
            return getFirstIndex(arr, x, mid + 1, high);
        }else if(arr[mid] > x){
            return getFirstIndex(arr, x, low, mid - 1);
        }else{
            return getFirstIndex(arr, x, low, mid);
        }

    }

//    public static int getLastIndex(int[] arr, int x){
//        return getLastIndex(arr, x, 0, )
//    }
//
//    private static int getLastIndex(int[] arr, int x, int low, int high){
//        if(low > high || arr[low] > x || arr[high] < x){
//            return -1;
//        }
//        if(arr[high] == x){
//            return high;
//        }
//
//        int mid = (low + high)/2;
//
//        if(arr[mid] < x){
//            return getFirstIndex(arr, x, mid + 1, high);
//        }else if(arr[mid] > x){
//            return getFirstIndex(arr, x, low, mid - 1);
//        }else{
//            return getFirstIndex(arr, x, mid, high-1);
//        }
//    }







}
